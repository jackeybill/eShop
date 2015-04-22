package net.shopxx.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import net.shopxx.Filter;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Admin;
import net.shopxx.entity.Cart;
import net.shopxx.entity.CouponCode;
import net.shopxx.entity.Member;
import net.shopxx.entity.Order.OrderStatus;
import net.shopxx.entity.Order.PaymentStatus;
import net.shopxx.entity.Order.ShippingStatus;
import net.shopxx.entity.Payment;
import net.shopxx.entity.PaymentMethod;
import net.shopxx.entity.Receiver;
import net.shopxx.entity.Refunds;
import net.shopxx.entity.Returns;
import net.shopxx.entity.Shipping;
import net.shopxx.entity.ShippingMethod;

public abstract interface OrderService extends BaseService<net.shopxx.entity.Order, Long>
{
  public abstract net.shopxx.entity.Order findBySn(String paramString);

  public abstract List<net.shopxx.entity.Order> findList(Member paramMember, Integer paramInteger, List<Filter> paramList, List<net.shopxx.Order> paramList1);

  public abstract Page<net.shopxx.entity.Order> findPage(Member paramMember, Pageable paramPageable);

  public abstract Page<net.shopxx.entity.Order> findPage(Order.OrderStatus paramOrderStatus, Order.PaymentStatus paramPaymentStatus, Order.ShippingStatus paramShippingStatus, Boolean paramBoolean, Pageable paramPageable);

  public abstract Long count(Order.OrderStatus paramOrderStatus, Order.PaymentStatus paramPaymentStatus, Order.ShippingStatus paramShippingStatus, Boolean paramBoolean);

  public abstract Long waitingPaymentCount(Member paramMember);

  public abstract Long waitingShippingCount(Member paramMember);

  public abstract BigDecimal getSalesAmount(Date paramDate1, Date paramDate2);

  public abstract Integer getSalesVolume(Date paramDate1, Date paramDate2);

  public abstract void releaseStock();

  public abstract net.shopxx.entity.Order build(Cart paramCart, Receiver paramReceiver, PaymentMethod paramPaymentMethod, ShippingMethod paramShippingMethod, CouponCode paramCouponCode, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2);

  public abstract net.shopxx.entity.Order create(Cart paramCart, Receiver paramReceiver, PaymentMethod paramPaymentMethod, ShippingMethod paramShippingMethod, CouponCode paramCouponCode, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, Admin paramAdmin);

  public abstract void update(net.shopxx.entity.Order paramOrder, Admin paramAdmin);

  public abstract void confirm(net.shopxx.entity.Order paramOrder, Admin paramAdmin);

  public abstract void complete(net.shopxx.entity.Order paramOrder, Admin paramAdmin);

  public abstract void cancel(net.shopxx.entity.Order paramOrder, Admin paramAdmin);

  public abstract void payment(net.shopxx.entity.Order paramOrder, Payment paramPayment, Admin paramAdmin);

  public abstract void refunds(net.shopxx.entity.Order paramOrder, Refunds paramRefunds, Admin paramAdmin);

  public abstract void shipping(net.shopxx.entity.Order paramOrder, Shipping paramShipping, Admin paramAdmin);

  public abstract void returns(net.shopxx.entity.Order paramOrder, Returns paramReturns, Admin paramAdmin);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.OrderService
 * JD-Core Version:    0.6.2
 */