package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.Payment;
import net.shopxx.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("adminPaymentController")
@RequestMapping({"/admin/payment"})
public class PaymentController extends BaseController
{

  @Resource(name="paymentServiceImpl")
  private PaymentService IIIlllIl;

  @RequestMapping(value={"/view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String view(Long id, ModelMap model)
  {
    model.addAttribute("payment", this.IIIlllIl.find(id));
    return "/admin/payment/view";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/payment/list";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    if (ids != null)
    {
      for (Long localLong : ids)
      {
        Payment localPayment = (Payment)this.IIIlllIl.find(localLong);
        if ((localPayment != null) && (localPayment.getExpire() != null) && (!localPayment.hasExpired()))
          return Message.error("admin.payment.deleteUnexpiredNotAllowed", new Object[0]);
      }
      this.IIIlllIl.delete(ids);
    }
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.PaymentController
 * JD-Core Version:    0.6.2
 */