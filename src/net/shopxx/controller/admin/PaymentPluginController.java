package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.service.PluginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminPaymentPluginController")
@RequestMapping({"/admin/payment_plugin"})
public class PaymentPluginController extends BaseController
{

  @Resource(name="pluginServiceImpl")
  private PluginService IIIlllIl;

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(ModelMap model)
  {
    model.addAttribute("paymentPlugins", this.IIIlllIl.getPaymentPlugins());
    return "/admin/payment_plugin/list";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.PaymentPluginController
 * JD-Core Version:    0.6.2
 */