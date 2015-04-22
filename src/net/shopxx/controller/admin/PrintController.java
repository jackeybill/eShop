package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.entity.DeliveryCenter;
import net.shopxx.entity.DeliveryTemplate;
import net.shopxx.service.DeliveryCenterService;
import net.shopxx.service.DeliveryTemplateService;
import net.shopxx.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminPrintController")
@RequestMapping({"/admin/print"})
public class PrintController extends BaseController
{

  @Resource(name="orderServiceImpl")
  private OrderService IIIlllIl;

  @Resource(name="deliveryTemplateServiceImpl")
  private DeliveryTemplateService IIIllllI;

  @Resource(name="deliveryCenterServiceImpl")
  private DeliveryCenterService IIIlllll;

  @RequestMapping(value={"/order"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String order(Long id, ModelMap model)
  {
    model.addAttribute("order", this.IIIlllIl.find(id));
    return "/admin/print/order";
  }

  @RequestMapping(value={"/product"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String product(Long id, ModelMap model)
  {
    model.addAttribute("order", this.IIIlllIl.find(id));
    return "/admin/print/product";
  }

  @RequestMapping(value={"/shipping"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String shipping(Long id, ModelMap model)
  {
    model.addAttribute("order", this.IIIlllIl.find(id));
    return "/admin/print/shipping";
  }

  @RequestMapping(value={"/delivery"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String delivery(Long orderId, Long deliveryTemplateId, Long deliveryCenterId, ModelMap model)
  {
    DeliveryTemplate localDeliveryTemplate = (DeliveryTemplate)this.IIIllllI.find(deliveryTemplateId);
    DeliveryCenter localDeliveryCenter = (DeliveryCenter)this.IIIlllll.find(deliveryCenterId);
    if (localDeliveryTemplate == null)
      localDeliveryTemplate = this.IIIllllI.findDefault();
    if (localDeliveryCenter == null)
      localDeliveryCenter = this.IIIlllll.findDefault();
    model.addAttribute("deliveryTemplates", this.IIIllllI.findAll());
    model.addAttribute("deliveryCenters", this.IIIlllll.findAll());
    model.addAttribute("order", this.IIIlllIl.find(orderId));
    model.addAttribute("deliveryTemplate", localDeliveryTemplate);
    model.addAttribute("deliveryCenter", localDeliveryCenter);
    return "/admin/print/delivery";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.PrintController
 * JD-Core Version:    0.6.2
 */