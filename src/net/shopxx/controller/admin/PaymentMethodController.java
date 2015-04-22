package net.shopxx.controller.admin;

import java.util.HashSet;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.PaymentMethod;
import net.shopxx.entity.PaymentMethod.Type;
import net.shopxx.service.PaymentMethodService;
import net.shopxx.service.ShippingMethodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminPaymentMethodController")
@RequestMapping({"/admin/payment_method"})
public class PaymentMethodController extends BaseController
{

  @Resource(name="paymentMethodServiceImpl")
  private PaymentMethodService IIIlllIl;

  @Resource(name="shippingMethodServiceImpl")
  private ShippingMethodService IIIllllI;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("types", PaymentMethod.Type.values());
    model.addAttribute("shippingMethods", this.IIIllllI.findAll());
    return "/admin/payment_method/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(PaymentMethod paymentMethod, Long[] shippingMethodIds, RedirectAttributes redirectAttributes)
  {
    paymentMethod.setShippingMethods(new HashSet(this.IIIllllI.findList(shippingMethodIds)));
    if (!IIIllIlI(paymentMethod, new Class[0]))
      return "/admin/common/error";
    paymentMethod.setOrders(null);
    this.IIIlllIl.save(paymentMethod);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("types", PaymentMethod.Type.values());
    model.addAttribute("shippingMethods", this.IIIllllI.findAll());
    model.addAttribute("paymentMethod", this.IIIlllIl.find(id));
    return "/admin/payment_method/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(PaymentMethod paymentMethod, Long[] shippingMethodIds, RedirectAttributes redirectAttributes)
  {
    paymentMethod.setShippingMethods(new HashSet(this.IIIllllI.findList(shippingMethodIds)));
    if (!IIIllIlI(paymentMethod, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.update(paymentMethod, new String[] { "orders" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/payment_method/list";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    if (ids.length >= this.IIIlllIl.count())
      return Message.error("admin.common.deleteAllNotAllowed", new Object[0]);
    this.IIIlllIl.delete(ids);
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.PaymentMethodController
 * JD-Core Version:    0.6.2
 */