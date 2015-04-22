package net.shopxx.plugin.oss;

import java.math.BigDecimal;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.controller.admin.BaseController;
import net.shopxx.entity.PluginConfig;
import net.shopxx.service.PluginConfigService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminPluginOssController")
@RequestMapping({"/admin/storage_plugin/oss"})
public class OssController extends BaseController
{

  @Resource(name="ossPlugin")
  private OssPlugin IIIlllIl;

  @Resource(name="pluginConfigServiceImpl")
  private PluginConfigService IIIllllI;

  @RequestMapping(value={"/install"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String install(RedirectAttributes redirectAttributes)
  {
    String str = System.getProperty("java.specification.version");
    Object localObject;
    if (StringUtils.isNotEmpty(str))
    {
      localObject = new BigDecimal(str);
      if (((BigDecimal)localObject).compareTo(new BigDecimal("1.6")) < 0)
      {
        IIIllIlI(redirectAttributes, Message.error("admin.plugin.oss.unsupportedJavaVersion", new Object[0]));
        return "redirect:/admin/storage_plugin/list.jhtml";
      }
    }
    if (!this.IIIlllIl.getIsInstalled())
    {
      localObject = new PluginConfig();
      ((PluginConfig)localObject).setPluginId(this.IIIlllIl.getId());
      ((PluginConfig)localObject).setIsEnabled(Boolean.valueOf(false));
      this.IIIllllI.save(localObject);
    }
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:/admin/storage_plugin/list.jhtml";
  }

  @RequestMapping(value={"/uninstall"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String uninstall(RedirectAttributes redirectAttributes)
  {
    if (this.IIIlllIl.getIsInstalled())
    {
      PluginConfig localPluginConfig = this.IIIlllIl.getPluginConfig();
      this.IIIllllI.delete(localPluginConfig);
    }
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:/admin/storage_plugin/list.jhtml";
  }

  @RequestMapping(value={"/setting"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String setting(ModelMap model)
  {
    PluginConfig localPluginConfig = this.IIIlllIl.getPluginConfig();
    model.addAttribute("pluginConfig", localPluginConfig);
    return "/net/shopxx/plugin/oss/setting";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(String accessId, String accessKey, String bucketName, String urlPrefix, @RequestParam(defaultValue="false") Boolean isEnabled, Integer order, RedirectAttributes redirectAttributes)
  {
    PluginConfig localPluginConfig = this.IIIlllIl.getPluginConfig();
    localPluginConfig.setAttribute("accessId", accessId);
    localPluginConfig.setAttribute("accessKey", accessKey);
    localPluginConfig.setAttribute("bucketName", bucketName);
    localPluginConfig.setAttribute("urlPrefix", StringUtils.removeEnd(urlPrefix, "/"));
    localPluginConfig.setIsEnabled(isEnabled);
    localPluginConfig.setOrder(order);
    this.IIIllllI.update(localPluginConfig);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:/admin/storage_plugin/list.jhtml";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.plugin.oss.OssController
 * JD-Core Version:    0.6.2
 */