package net.shopxx.service.impl;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import net.shopxx.Setting;
import net.shopxx.entity.ProductNotify;
import net.shopxx.entity.SafeKey;
import net.shopxx.service.MailService;
import net.shopxx.service.TemplateService;
import net.shopxx.util.SettingUtils;
import net.shopxx.util.SpringUtils;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Service("mailServiceImpl")
public class MailServiceImpl
  implements MailService
{

  @Resource(name="freeMarkerConfigurer")
  private FreeMarkerConfigurer IIIllIlI;

  @Resource(name="javaMailSender")
  private JavaMailSenderImpl IIIllIll;

  @Resource(name="taskExecutor")
  private TaskExecutor IIIlllII;

  @Resource(name="templateServiceImpl")
  private TemplateService IIIlllIl;

  private void IIIllIlI(MimeMessage paramMimeMessage)
  {
    try
    {
      this.IIIlllII.execute(new MailServiceImpl.1(this, paramMimeMessage));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void send(String smtpFromMail, String smtpHost, Integer smtpPort, String smtpUsername, String smtpPassword, String toMail, String subject, String templatePath, Map<String, Object> model, boolean async)
  {
    Assert.hasText(smtpFromMail);
    Assert.hasText(smtpHost);
    Assert.notNull(smtpPort);
    Assert.hasText(smtpUsername);
    Assert.hasText(smtpPassword);
    Assert.hasText(toMail);
    Assert.hasText(subject);
    Assert.hasText(templatePath);
    try
    {
      Setting localSetting = SettingUtils.get();
      Configuration localConfiguration = this.IIIllIlI.getConfiguration();
      freemarker.template.Template localTemplate = localConfiguration.getTemplate(templatePath);
      String str = FreeMarkerTemplateUtils.processTemplateIntoString(localTemplate, model);
      this.IIIllIll.setHost(smtpHost);
      this.IIIllIll.setPort(smtpPort.intValue());
      this.IIIllIll.setUsername(smtpUsername);
      this.IIIllIll.setPassword(smtpPassword);
      MimeMessage localMimeMessage = this.IIIllIll.createMimeMessage();
      MimeMessageHelper localMimeMessageHelper = new MimeMessageHelper(localMimeMessage, false, "utf-8");
      localMimeMessageHelper.setFrom(MimeUtility.encodeWord(localSetting.getSiteName()) + " <" + smtpFromMail + ">");
      localMimeMessageHelper.setSubject(subject);
      localMimeMessageHelper.setTo(toMail);
      localMimeMessageHelper.setText(str, true);
      if (async)
        IIIllIlI(localMimeMessage);
      else
        this.IIIllIll.send(localMimeMessage);
    }
    catch (TemplateException localTemplateException1)
    {
      localTemplateException1.printStackTrace();
    }
    catch (IOException localIOException1)
    {
      localIOException1.printStackTrace();
    }
    catch (MessagingException localMessagingException1)
    {
      localMessagingException1.printStackTrace();
    }
  }

  public void send(String toMail, String subject, String templatePath, Map<String, Object> model, boolean async)
  {
    Setting localSetting = SettingUtils.get();
    send(localSetting.getSmtpFromMail(), localSetting.getSmtpHost(), localSetting.getSmtpPort(), localSetting.getSmtpUsername(), localSetting.getSmtpPassword(), toMail, subject, templatePath, model, async);
  }

  public void send(String toMail, String subject, String templatePath, Map<String, Object> model)
  {
    Setting localSetting = SettingUtils.get();
    send(localSetting.getSmtpFromMail(), localSetting.getSmtpHost(), localSetting.getSmtpPort(), localSetting.getSmtpUsername(), localSetting.getSmtpPassword(), toMail, subject, templatePath, model, true);
  }

  public void send(String toMail, String subject, String templatePath)
  {
    Setting localSetting = SettingUtils.get();
    send(localSetting.getSmtpFromMail(), localSetting.getSmtpHost(), localSetting.getSmtpPort(), localSetting.getSmtpUsername(), localSetting.getSmtpPassword(), toMail, subject, templatePath, null, true);
  }

  public void sendTestMail(String smtpFromMail, String smtpHost, Integer smtpPort, String smtpUsername, String smtpPassword, String toMail)
  {
    Setting localSetting = SettingUtils.get();
    String str = SpringUtils.getMessage("admin.setting.testMailSubject", new Object[] { localSetting.getSiteName() });
    net.shopxx.Template localTemplate = this.IIIlllIl.get("testMail");
    send(smtpFromMail, smtpHost, smtpPort, smtpUsername, smtpPassword, toMail, str, localTemplate.getTemplatePath(), null, false);
  }

  public void sendFindPasswordMail(String toMail, String username, SafeKey safeKey)
  {
    Setting localSetting = SettingUtils.get();
    HashMap localHashMap = new HashMap();
    localHashMap.put("username", username);
    localHashMap.put("safeKey", safeKey);
    String str = SpringUtils.getMessage("shop.password.mailSubject", new Object[] { localSetting.getSiteName() });
    net.shopxx.Template localTemplate = this.IIIlllIl.get("findPasswordMail");
    send(toMail, str, localTemplate.getTemplatePath(), localHashMap);
  }

  public void sendProductNotifyMail(ProductNotify productNotify)
  {
    Setting localSetting = SettingUtils.get();
    HashMap localHashMap = new HashMap();
    localHashMap.put("productNotify", productNotify);
    String str = SpringUtils.getMessage("admin.productNotify.mailSubject", new Object[] { localSetting.getSiteName() });
    net.shopxx.Template localTemplate = this.IIIlllIl.get("productNotifyMail");
    send(productNotify.getEmail(), str, localTemplate.getTemplatePath(), localHashMap);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.MailServiceImpl
 * JD-Core Version:    0.6.2
 */