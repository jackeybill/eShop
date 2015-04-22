package net.shopxx.controller.shop;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.shopxx.entity.Member;
import net.shopxx.entity.Order;
import net.shopxx.entity.Order.PaymentStatus;
import net.shopxx.entity.Payment;
import net.shopxx.entity.Payment.Status;
import net.shopxx.entity.Payment.Type;
import net.shopxx.entity.PaymentMethod;
import net.shopxx.entity.PaymentMethod.Type;
import net.shopxx.entity.Sn.Type;
import net.shopxx.plugin.PaymentPlugin;
import net.shopxx.service.MemberService;
import net.shopxx.service.OrderService;
import net.shopxx.service.PaymentService;
import net.shopxx.service.PluginService;
import net.shopxx.service.SnService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopPaymentController")
@RequestMapping({"/payment"})
public class PaymentController extends BaseController
{

  @Resource(name="orderServiceImpl")
  private OrderService IIIlllIl;

  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;

  @Resource(name="pluginServiceImpl")
  private PluginService IIIlllll;

  @Resource(name="paymentServiceImpl")
  private PaymentService IIlIIIII;

  @Resource(name="snServiceImpl")
  private SnService IIlIIIIl;

  @RequestMapping(value={"/submit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String submit(String sn, String paymentPluginId, HttpServletRequest request, ModelMap model)
  {
    Order localOrder = this.IIIlllIl.findBySn(sn);
    if (localOrder == null)
      return "/shop/common/error";
    Member localMember = this.IIIllllI.getCurrent();
    if ((localMember == null) || (localOrder.getMember() != localMember) || (localOrder.isExpired()))
      return "/shop/common/error";
    if ((localOrder.getPaymentMethod() == null) || (localOrder.getPaymentMethod().getType() == PaymentMethod.Type.offline))
      return "/shop/common/error";
    if ((localOrder.getPaymentStatus() != Order.PaymentStatus.unpaid) && (localOrder.getPaymentStatus() != Order.PaymentStatus.partialPayment))
      return "/shop/common/error";
    if (localOrder.getAmountPayable().compareTo(new BigDecimal(0)) <= 0)
      return "/shop/common/error";
    PaymentPlugin localPaymentPlugin = this.IIIlllll.getPaymentPlugin(paymentPluginId);
    if ((localPaymentPlugin == null) || (!localPaymentPlugin.getIsEnabled()))
      return "/shop/common/error";
    BigDecimal localBigDecimal1 = localPaymentPlugin.getFee(localOrder.getAmountPayable());
    BigDecimal localBigDecimal2 = localOrder.getAmountPayable().add(localBigDecimal1);
    Payment localPayment = new Payment();
    localPayment.setSn(this.IIlIIIIl.generate(Sn.Type.payment));
    localPayment.setType(Payment.Type.online);
    localPayment.setStatus(Payment.Status.wait);
    localPayment.setPaymentMethod(localOrder.getPaymentMethodName() + "-" + localPaymentPlugin.getPaymentName());
    localPayment.setFee(localBigDecimal1);
    localPayment.setAmount(localBigDecimal2);
    localPayment.setPaymentPluginId(paymentPluginId);
    localPayment.setExpire(localPaymentPlugin.getTimeout() != null ? DateUtils.addMinutes(new Date(), localPaymentPlugin.getTimeout().intValue()) : null);
    localPayment.setMember(null);
    localPayment.setOrder(localOrder);
    this.IIlIIIII.save(localPayment);
    model.addAttribute("url", localPaymentPlugin.getUrl());
    model.addAttribute("method", localPaymentPlugin.getMethod());
    model.addAttribute("parameterMap", localPaymentPlugin.getParameterMap(localPayment.getSn(), localBigDecimal2, localOrder.getProductName(), request));
    return "shop/payment/submit";
  }

  @RequestMapping({"/return/{sn}"})
  public String returns(@PathVariable String sn, HttpServletRequest request, ModelMap model)
  {
    Payment localPayment = this.IIlIIIII.findBySn(sn);
    if (localPayment == null)
      return "/shop/common/error";
    if (localPayment.getStatus() == Payment.Status.wait)
    {
      PaymentPlugin localPaymentPlugin = this.IIIlllll.getPaymentPlugin(localPayment.getPaymentPluginId());
      if ((localPaymentPlugin != null) && (localPaymentPlugin.verify(sn, request)))
      {
        BigDecimal localBigDecimal1 = localPaymentPlugin.getAmount(sn, request);
        if (localBigDecimal1.compareTo(localPayment.getAmount()) >= 0)
        {
          Order localOrder = localPayment.getOrder();
          if (localOrder != null)
          {
            if (localBigDecimal1.compareTo(localOrder.getAmountPayable()) >= 0)
              this.IIIlllIl.payment(localOrder, localPayment, null);
          }
          else
          {
            Member localMember = localPayment.getMember();
            if (localMember != null)
            {
              BigDecimal localBigDecimal2 = localPayment.getAmount().subtract(localPayment.getFee());
              this.IIIllllI.update(localMember, null, localBigDecimal2, IIIllIlI("shop.payment.paymentName", new Object[] { localPaymentPlugin.getPaymentName() }), null);
            }
          }
        }
        localPayment.setStatus(Payment.Status.success);
        localPayment.setAmount(localBigDecimal1);
        localPayment.setPaymentDate(new Date());
      }
      else
      {
        localPayment.setStatus(Payment.Status.failure);
        localPayment.setPaymentDate(new Date());
      }
      this.IIlIIIII.update(localPayment);
    }
    model.addAttribute("payment", localPayment);
    return "shop/payment/return";
  }

  @RequestMapping({"/notify/{sn}"})
  public String notify(@PathVariable String sn, HttpServletRequest request, ModelMap model)
  {
    Payment localPayment = this.IIlIIIII.findBySn(sn);
    if (localPayment != null)
    {
      PaymentPlugin localPaymentPlugin = this.IIIlllll.getPaymentPlugin(localPayment.getPaymentPluginId());
      if (localPaymentPlugin != null)
      {
        if ((localPayment.getStatus() == Payment.Status.wait) && (localPaymentPlugin.verify(sn, request)))
        {
          BigDecimal localBigDecimal1 = localPaymentPlugin.getAmount(sn, request);
          if (localBigDecimal1.compareTo(localPayment.getAmount()) >= 0)
          {
            Order localOrder = localPayment.getOrder();
            if (localOrder != null)
            {
              if (localBigDecimal1.compareTo(localOrder.getAmountPayable()) >= 0)
                this.IIIlllIl.payment(localOrder, localPayment, null);
            }
            else
            {
              Member localMember = localPayment.getMember();
              if (localMember != null)
              {
                BigDecimal localBigDecimal2 = localPayment.getAmount().subtract(localPayment.getFee());
                this.IIIllllI.update(localMember, null, localBigDecimal2, IIIllIlI("shop.payment.paymentName", new Object[] { localPaymentPlugin.getPaymentName() }), null);
              }
            }
          }
          localPayment.setStatus(Payment.Status.success);
          localPayment.setAmount(localBigDecimal1);
          localPayment.setPaymentDate(new Date());
          this.IIlIIIII.update(localPayment);
        }
        model.addAttribute("notifyContext", localPaymentPlugin.getNotifyContext(sn, request));
      }
    }
    return "shop/payment/notify";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.PaymentController
 * JD-Core Version:    0.6.2
 */