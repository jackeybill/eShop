package net.shopxx.controller.admin;

import com.sun.mail.smtp.SMTPSendFailedException;
import com.sun.mail.smtp.SMTPSenderFailedException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Properties;
import javax.mail.MessagingException;
import net.shopxx.FileInfo.FileType;
import net.shopxx.Message;
import net.shopxx.Setting;
import net.shopxx.Setting.AccountLockType;
import net.shopxx.Setting.CaptchaType;
import net.shopxx.Setting.ConsultationAuthority;
import net.shopxx.Setting.ReviewAuthority;
import net.shopxx.Setting.RoundType;
import net.shopxx.Setting.StockAllocationTime;
import net.shopxx.Setting.WatermarkPosition;
import net.shopxx.service.CacheService;
import net.shopxx.service.FileService;
import net.shopxx.service.MailService;
import net.shopxx.service.StaticService;
import net.shopxx.util.SettingUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminstingController")
@RequestMapping({"/admin/setting"})
public class SettingController extends BaseController
{

  @javax.annotation.Resource(name="fileServiceImpl")
  private FileService IIIlllIl;

  @javax.annotation.Resource(name="mailServiceImpl")
  private MailService IIIllllI;

  @javax.annotation.Resource(name="cacheServiceImpl")
  private CacheService IIIlllll;

  @javax.annotation.Resource(name="staticServiceImpl")
  private StaticService IIlIIIII;

  @RequestMapping(value={"/mail_test"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message mailTest(String smtpFromMail, String smtpHost, Integer smtpPort, String smtpUsername, String smtpPassword, String toMail)
  {
    if (StringUtils.isEmpty(toMail))
      return IIIllIll;
    Setting localSetting = SettingUtils.get();
    if (StringUtils.isEmpty(smtpPassword))
      smtpPassword = localSetting.getSmtpPassword();
    try
    {
      if ((!IIIllIlI(Setting.class, "smtpFromMail", smtpFromMail, new Class[0])) || (!IIIllIlI(Setting.class, "smtpHost", smtpHost, new Class[0])) || (!IIIllIlI(Setting.class, "smtpPort", smtpPort, new Class[0])) || (!IIIllIlI(Setting.class, "smtpUsername", smtpUsername, new Class[0])))
        return IIIllIll;
      this.IIIllllI.sendTestMail(smtpFromMail, smtpHost, smtpPort, smtpUsername, smtpPassword, toMail);
    }
    catch (MailSendException localMailSendException)
    {
      Exception[] arrayOfException1 = localMailSendException.getMessageExceptions();
      if (arrayOfException1 != null)
        for (Exception localException1 : arrayOfException1)
        {
          Object localObject;
          Exception localException2;
          if ((localException1 instanceof SMTPSendFailedException))
          {
            localObject = (SMTPSendFailedException)localException1;
            localException2 = ((SMTPSendFailedException)localObject).getNextException();
            if ((localException2 instanceof SMTPSenderFailedException))
              return Message.error("admin.setting.mailTestSenderFailed", new Object[0]);
          }
          else if ((localException1 instanceof MessagingException))
          {
            localObject = (MessagingException)localException1;
            localException2 = ((MessagingException)localObject).getNextException();
            if ((localException2 instanceof UnknownHostException))
              return Message.error("admin.setting.mailTestUnknownHost", new Object[0]);
            if ((localException2 instanceof ConnectException))
              return Message.error("admin.setting.mailTestConnect", new Object[0]);
          }
        }
      return Message.error("admin.setting.mailTestError", new Object[0]);
    }
    catch (MailAuthenticationException localMailAuthenticationException)
    {
      return Message.error("admin.setting.mailTestAuthentication", new Object[0]);
    }
    catch (Exception localException)
    {
      return Message.error("admin.setting.mailTestError", new Object[0]);
    }
    return Message.success("admin.setting.mailTestSuccess", new Object[0]);
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(ModelMap model)
  {
    model.addAttribute("watermarkPositions", Setting.WatermarkPosition.values());
    model.addAttribute("roundTypes", Setting.RoundType.values());
    model.addAttribute("captchaTypes", Setting.CaptchaType.values());
    model.addAttribute("accountLockTypes", Setting.AccountLockType.values());
    model.addAttribute("stockAllocationTimes", Setting.StockAllocationTime.values());
    model.addAttribute("reviewAuthorities", Setting.ReviewAuthority.values());
    model.addAttribute("consultationAuthorities", Setting.ConsultationAuthority.values());
    return "/admin/setting/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Setting setting, MultipartFile watermarkImageFile, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(setting, new Class[0]))
      return "/admin/common/error";
    if ((setting.getUsernameMinLength().intValue() > setting.getUsernameMaxLength().intValue()) || (setting.getPasswordMinLength().intValue() > setting.getPasswordMinLength().intValue()))
      return "/admin/common/error";
    Setting localSetting = SettingUtils.get();
    if (StringUtils.isEmpty(setting.getSmtpPassword()))
      setting.setSmtpPassword(localSetting.getSmtpPassword());
    if ((watermarkImageFile != null) && (!watermarkImageFile.isEmpty()))
    {
      if (!this.IIIlllIl.isValid(FileInfo.FileType.image, watermarkImageFile))
      {
        IIIllIlI(redirectAttributes, Message.error("admin.upload.invalid", new Object[0]));
        return "redirect:edit.jhtml";
      }
      localObject1 = this.IIIlllIl.uploadLocal(FileInfo.FileType.image, watermarkImageFile);
      setting.setWatermarkImage((String)localObject1);
    }
    else
    {
      setting.setWatermarkImage(localSetting.getWatermarkImage());
    }
    setting.setCnzzSiteId(localSetting.getCnzzSiteId());
    setting.setCnzzPassword(localSetting.getCnzzPassword());
    SettingUtils.set(setting);
    this.IIIlllll.clear();
    this.IIlIIIII.buildIndex();
    this.IIlIIIII.buildOther();
    Object localObject1 = null;
    label416: 
    try
    {
      ClassPathResource localClassPathResource = new ClassPathResource("/shopxx.properties");
      Properties localProperties = PropertiesLoaderUtils.loadProperties(localClassPathResource);
      String str1 = localProperties.getProperty("template.update_delay");
      String str2 = localProperties.getProperty("message.cache_seconds");
      if (setting.getIsDevelopmentEnabled().booleanValue())
      {
        if ((!str1.equals("0")) || (!str2.equals("0")))
        {
          localObject1 = new FileOutputStream(localClassPathResource.getFile());
          localProperties.setProperty("template.update_delay", "0");
          localProperties.setProperty("message.cache_seconds", "0");
          localProperties.store((OutputStream)localObject1, "SHOP++ PROPERTIES");
          break label416;
        }
      }
      else if ((str1.equals("0")) || (str2.equals("0")))
      {
        localObject1 = new FileOutputStream(localClassPathResource.getFile());
        localProperties.setProperty("template.update_delay", "3600");
        localProperties.setProperty("message.cache_seconds", "3600");
        localProperties.store((OutputStream)localObject1, "SHOP++ PROPERTIES");
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    finally
    {
      IOUtils.closeQuietly((OutputStream)localObject1);
    }
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:edit.jhtml";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.SettingController
 * JD-Core Version:    0.6.2
 */