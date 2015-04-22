package net.shopxx.plugin.alipayDirect;

import java.math.BigDecimal;
import javax.annotation.Resource;
import net.shopxx.controller.admin.BaseController;
import net.shopxx.entity.PluginConfig;
import net.shopxx.plugin.PaymentPlugin.FeeType;
import net.shopxx.service.PluginConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminAlipayDirectController")
@RequestMapping({"/admin/payment_plugin/alipay_direct"})
public class AlipayDirectController extends BaseController
{

  @Resource(name="alipayDirectPlugin")
  private AlipayDirectPlugin IIIlllIl;

  @Resource(name="pluginConfigServiceImpl")
  private PluginConfigService IIIllllI;

  @RequestMapping(value={"/install"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String install(RedirectAttributes redirectAttributes)
  {
    if (!this.IIIlllIl.getIsInstalled())
    {
      PluginConfig localPluginConfig = new PluginConfig();
      localPluginConfig.setPluginId(this.IIIlllIl.getId());
      localPluginConfig.setIsEnabled(Boolean.valueOf(false));
      this.IIIllllI.save(localPluginConfig);
    }
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:/admin/payment_plugin/list.jhtml";
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
    return "redirect:/admin/payment_plugin/list.jhtml";
  }

  @RequestMapping(value={"/setting"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String setting(ModelMap model)
  {
    PluginConfig localPluginConfig = this.IIIlllIl.getPluginConfig();
    model.addAttribute("feeTypes", PaymentPlugin.FeeType.values());
    model.addAttribute("pluginConfig", localPluginConfig);
    return "/net/shopxx/plugin/alipayDirect/setting";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(String paymentName, String partner, String key, PaymentPlugin.FeeType feeType, BigDecimal fee, String logo, String description, @RequestParam(defaultValue="false") Boolean isEnabled, Integer order, RedirectAttributes redirectAttributes)
  {
    PluginConfig localPluginConfig = this.IIIlllIl.getPluginConfig();
    localPluginConfig.setAttribute("paymentName", paymentName);
    localPluginConfig.setAttribute("partner", partner);
    localPluginConfig.setAttribute("key", key);
    localPluginConfig.setAttribute("feeType", feeType.toString());
    localPluginConfig.setAttribute("fee", fee.toString());
    localPluginConfig.setAttribute("logo", logo);
    localPluginConfig.setAttribute("description", description);
    localPluginConfig.setIsEnabled(isEnabled);
    localPluginConfig.setOrder(order);
    this.IIIllllI.update(localPluginConfig);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:/admin/payment_plugin/list.jhtml";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.plugin.alipayDirect.AlipayDirectController
 * JD-Core Version:    0.6.2
 */