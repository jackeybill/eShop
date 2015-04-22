package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.DeliveryCorp;
import net.shopxx.entity.ShippingMethod;
import net.shopxx.service.DeliveryCorpService;
import net.shopxx.service.ShippingMethodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminShippingMethodController")
@RequestMapping({"/admin/shipping_method"})
public class ShippingMethodController extends BaseController
{

  @Resource(name="shippingMethodServiceImpl")
  private ShippingMethodService IIIlllIl;

  @Resource(name="deliveryCorpServiceImpl")
  private DeliveryCorpService IIIllllI;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("deliveryCorps", this.IIIllllI.findAll());
    return "/admin/shipping_method/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(ShippingMethod shippingMethod, Long defaultDeliveryCorpId, RedirectAttributes redirectAttributes)
  {
    shippingMethod.setDefaultDeliveryCorp((DeliveryCorp)this.IIIllllI.find(defaultDeliveryCorpId));
    if (!IIIllIlI(shippingMethod, new Class[0]))
      return "/admin/common/error";
    shippingMethod.setPaymentMethods(null);
    shippingMethod.setOrders(null);
    this.IIIlllIl.save(shippingMethod);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("deliveryCorps", this.IIIllllI.findAll());
    model.addAttribute("shippingMethod", this.IIIlllIl.find(id));
    return "/admin/shipping_method/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(ShippingMethod shippingMethod, Long defaultDeliveryCorpId, RedirectAttributes redirectAttributes)
  {
    shippingMethod.setDefaultDeliveryCorp((DeliveryCorp)this.IIIllllI.find(defaultDeliveryCorpId));
    if (!IIIllIlI(shippingMethod, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.update(shippingMethod, new String[] { "paymentMethods", "orders" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/shipping_method/list";
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
 * Qualified Name:     net.shopxx.controller.admin.ShippingMethodController
 * JD-Core Version:    0.6.2
 */