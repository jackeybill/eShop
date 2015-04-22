package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.DeliveryCorp;
import net.shopxx.service.DeliveryCorpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminDeliveryCorpController")
@RequestMapping({"/admin/delivery_corp"})
public class DeliveryCorpController extends BaseController
{

  @Resource(name="deliveryCorpServiceImpl")
  private DeliveryCorpService IIIlllIl;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add()
  {
    return "/admin/delivery_corp/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(DeliveryCorp deliveryCorp, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(deliveryCorp, new Class[0]))
      return "/admin/common/error";
    deliveryCorp.setShippingMethods(null);
    this.IIIlllIl.save(deliveryCorp);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("deliveryCorp", this.IIIlllIl.find(id));
    return "/admin/delivery_corp/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(DeliveryCorp deliveryCorp, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(deliveryCorp, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.update(deliveryCorp, new String[] { "shippingMethods" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/delivery_corp/list";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    this.IIIlllIl.delete(ids);
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.DeliveryCorpController
 * JD-Core Version:    0.6.2
 */