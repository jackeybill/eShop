package net.shopxx.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.persistence.LockModeType;
import net.shopxx.Filter;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.Setting;
import net.shopxx.Setting.StockAllocationTime;
import net.shopxx.dao.CartDao;
import net.shopxx.dao.CouponCodeDao;
import net.shopxx.dao.DepositDao;
import net.shopxx.dao.MemberDao;
import net.shopxx.dao.MemberRankDao;
import net.shopxx.dao.OrderDao;
import net.shopxx.dao.OrderItemDao;
import net.shopxx.dao.OrderLogDao;
import net.shopxx.dao.PaymentDao;
import net.shopxx.dao.ProductDao;
import net.shopxx.dao.RefundsDao;
import net.shopxx.dao.ReturnsDao;
import net.shopxx.dao.ShippingDao;
import net.shopxx.dao.SnDao;
import net.shopxx.entity.Admin;
import net.shopxx.entity.Cart;
import net.shopxx.entity.CartItem;
import net.shopxx.entity.Coupon;
import net.shopxx.entity.CouponCode;
import net.shopxx.entity.Deposit;
import net.shopxx.entity.Deposit.Type;
import net.shopxx.entity.GiftItem;
import net.shopxx.entity.Member;
import net.shopxx.entity.MemberRank;
import net.shopxx.entity.Order.OrderStatus;
import net.shopxx.entity.Order.PaymentStatus;
import net.shopxx.entity.Order.ShippingStatus;
import net.shopxx.entity.OrderItem;
import net.shopxx.entity.OrderLog;
import net.shopxx.entity.OrderLog.Type;
import net.shopxx.entity.Payment;
import net.shopxx.entity.Payment.Type;
import net.shopxx.entity.PaymentMethod;
import net.shopxx.entity.PaymentMethod.Type;
import net.shopxx.entity.Product;
import net.shopxx.entity.Promotion;
import net.shopxx.entity.Receiver;
import net.shopxx.entity.Refunds;
import net.shopxx.entity.Refunds.Type;
import net.shopxx.entity.Returns;
import net.shopxx.entity.ReturnsItem;
import net.shopxx.entity.Shipping;
import net.shopxx.entity.ShippingItem;
import net.shopxx.entity.ShippingMethod;
import net.shopxx.entity.Sn.Type;
import net.shopxx.service.OrderService;
import net.shopxx.service.StaticService;
import net.shopxx.util.SettingUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service("orderServiceImpl")
public class OrderServiceImpl extends BaseServiceImpl<net.shopxx.entity.Order, Long>
  implements OrderService
{

  @Resource(name="orderDaoImpl")
  private OrderDao IIIllIlI;

  @Resource(name="orderItemDaoImpl")
  private OrderItemDao IIIllIll;

  @Resource(name="orderLogDaoImpl")
  private OrderLogDao IIIlllII;

  @Resource(name="cartDaoImpl")
  private CartDao IIIlllIl;

  @Resource(name="couponCodeDaoImpl")
  private CouponCodeDao IIIllllI;

  @Resource(name="snDaoImpl")
  private SnDao IIIlllll;

  @Resource(name="memberDaoImpl")
  private MemberDao IIlIIIII;

  @Resource(name="memberRankDaoImpl")
  private MemberRankDao IIlIIIIl;

  @Resource(name="productDaoImpl")
  private ProductDao IIlIIIlI;

  @Resource(name="depositDaoImpl")
  private DepositDao IIlIIIll;

  @Resource(name="paymentDaoImpl")
  private PaymentDao IIlIIlII;

  @Resource(name="refundsDaoImpl")
  private RefundsDao IIlIIlIl;

  @Resource(name="shippingDaoImpl")
  private ShippingDao IIlIIllI;

  @Resource(name="returnsDaoImpl")
  private ReturnsDao IIlIIlll;

  @Resource(name="staticServiceImpl")
  private StaticService IIlIlIII;

  @Resource(name="orderDaoImpl")
  public void setBaseDao(OrderDao orderDao)
  {
    super.setBaseDao(orderDao);
  }

  @Transactional(readOnly=true)
  public net.shopxx.entity.Order findBySn(String sn)
  {
    return this.IIIllIlI.findBySn(sn);
  }

  @Transactional(readOnly=true)
  public List<net.shopxx.entity.Order> findList(Member member, Integer count, List<Filter> filters, List<net.shopxx.Order> orders)
  {
    return this.IIIllIlI.findList(member, count, filters, orders);
  }

  @Transactional(readOnly=true)
  public Page<net.shopxx.entity.Order> findPage(Member member, Pageable pageable)
  {
    return this.IIIllIlI.findPage(member, pageable);
  }

  @Transactional(readOnly=true)
  public Page<net.shopxx.entity.Order> findPage(Order.OrderStatus orderStatus, Order.PaymentStatus paymentStatus, Order.ShippingStatus shippingStatus, Boolean hasExpired, Pageable pageable)
  {
    return this.IIIllIlI.findPage(orderStatus, paymentStatus, shippingStatus, hasExpired, pageable);
  }

  @Transactional(readOnly=true)
  public Long count(Order.OrderStatus orderStatus, Order.PaymentStatus paymentStatus, Order.ShippingStatus shippingStatus, Boolean hasExpired)
  {
    return this.IIIllIlI.count(orderStatus, paymentStatus, shippingStatus, hasExpired);
  }

  @Transactional(readOnly=true)
  public Long waitingPaymentCount(Member member)
  {
    return this.IIIllIlI.waitingPaymentCount(member);
  }

  @Transactional(readOnly=true)
  public Long waitingShippingCount(Member member)
  {
    return this.IIIllIlI.waitingShippingCount(member);
  }

  @Transactional(readOnly=true)
  public BigDecimal getSalesAmount(Date beginDate, Date endDate)
  {
    return this.IIIllIlI.getSalesAmount(beginDate, endDate);
  }

  @Transactional(readOnly=true)
  public Integer getSalesVolume(Date beginDate, Date endDate)
  {
    return this.IIIllIlI.getSalesVolume(beginDate, endDate);
  }

  public void releaseStock()
  {
    this.IIIllIlI.releaseStock();
  }

  @Transactional(readOnly=true)
  public net.shopxx.entity.Order build(Cart cart, Receiver receiver, PaymentMethod paymentMethod, ShippingMethod shippingMethod, CouponCode couponCode, boolean isInvoice, String invoiceTitle, boolean useBalance, String memo)
  {
    Assert.notNull(cart);
    Assert.notNull(cart.getMember());
    Assert.notEmpty(cart.getCartItems());
    net.shopxx.entity.Order localOrder = new net.shopxx.entity.Order();
    localOrder.setShippingStatus(Order.ShippingStatus.unshipped);
    localOrder.setFee(new BigDecimal(0));
    localOrder.setDiscount(cart.getDiscount());
    localOrder.setPoint(Integer.valueOf(cart.getPoint()));
    localOrder.setMemo(memo);
    localOrder.setMember(cart.getMember());
    if (receiver != null)
    {
      localOrder.setConsignee(receiver.getConsignee());
      localOrder.setAreaName(receiver.getAreaName());
      localOrder.setAddress(receiver.getAddress());
      localOrder.setZipCode(receiver.getZipCode());
      localOrder.setPhone(receiver.getPhone());
      localOrder.setArea(receiver.getArea());
    }
    if (!cart.getPromotions().isEmpty())
    {
      localObject1 = new StringBuffer();
      localObject3 = cart.getPromotions().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Promotion)((Iterator)localObject3).next();
        if ((localObject2 != null) && (((Promotion)localObject2).getName() != null))
          ((StringBuffer)localObject1).append(" " + ((Promotion)localObject2).getName());
      }
      if (((StringBuffer)localObject1).length() > 0)
        ((StringBuffer)localObject1).deleteCharAt(0);
      localOrder.setPromotion(((StringBuffer)localObject1).toString());
    }
    localOrder.setPaymentMethod(paymentMethod);
    if ((shippingMethod != null) && (paymentMethod != null) && (paymentMethod.getShippingMethods().contains(shippingMethod)))
    {
      localObject1 = shippingMethod.calculateFreight(Integer.valueOf(cart.getWeight()));
      localObject3 = cart.getPromotions().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Promotion)((Iterator)localObject3).next();
        if (((Promotion)localObject2).getIsFreeShipping().booleanValue())
        {
          localObject1 = new BigDecimal(0);
          break;
        }
      }
      localOrder.setFreight((BigDecimal)localObject1);
      localOrder.setShippingMethod(shippingMethod);
    }
    else
    {
      localOrder.setFreight(new BigDecimal(0));
    }
    if ((couponCode != null) && (cart.isCouponAllowed()))
    {
      this.IIIllllI.lock(couponCode, LockModeType.PESSIMISTIC_READ);
      if ((!couponCode.getIsUsed().booleanValue()) && (couponCode.getCoupon() != null) && (cart.isValid(couponCode.getCoupon())))
      {
        localObject1 = couponCode.getCoupon().calculatePrice(cart.getAmount());
        localObject2 = cart.getAmount().subtract((BigDecimal)localObject1);
        if (((BigDecimal)localObject2).compareTo(new BigDecimal(0)) > 0)
          localOrder.setDiscount(cart.getDiscount().add((BigDecimal)localObject2));
        localOrder.setCouponCode(couponCode);
      }
    }
    Object localObject1 = localOrder.getOrderItems();
    Object localObject3 = cart.getCartItems().iterator();
    Product localProduct;
    OrderItem localOrderItem;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (CartItem)((Iterator)localObject3).next();
      if ((localObject2 != null) && (((CartItem)localObject2).getProduct() != null))
      {
        localProduct = ((CartItem)localObject2).getProduct();
        localOrderItem = new OrderItem();
        localOrderItem.setSn(localProduct.getSn());
        localOrderItem.setName(localProduct.getName());
        localOrderItem.setFullName(localProduct.getFullName());
        localOrderItem.setPrice(((CartItem)localObject2).getUnitPrice());
        localOrderItem.setWeight(localProduct.getWeight());
        localOrderItem.setThumbnail(localProduct.getThumbnail());
        localOrderItem.setIsGift(Boolean.valueOf(false));
        localOrderItem.setQuantity(((CartItem)localObject2).getQuantity());
        localOrderItem.setShippedQuantity(Integer.valueOf(0));
        localOrderItem.setReturnQuantity(Integer.valueOf(0));
        localOrderItem.setProduct(localProduct);
        localOrderItem.setOrder(localOrder);
        ((List)localObject1).add(localOrderItem);
      }
    }
    localObject3 = cart.getGiftItems().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (GiftItem)((Iterator)localObject3).next();
      if ((localObject2 != null) && (((GiftItem)localObject2).getGift() != null))
      {
        localProduct = ((GiftItem)localObject2).getGift();
        localOrderItem = new OrderItem();
        localOrderItem.setSn(localProduct.getSn());
        localOrderItem.setName(localProduct.getName());
        localOrderItem.setFullName(localProduct.getFullName());
        localOrderItem.setPrice(new BigDecimal(0));
        localOrderItem.setWeight(localProduct.getWeight());
        localOrderItem.setThumbnail(localProduct.getThumbnail());
        localOrderItem.setIsGift(Boolean.valueOf(true));
        localOrderItem.setQuantity(((GiftItem)localObject2).getQuantity());
        localOrderItem.setShippedQuantity(Integer.valueOf(0));
        localOrderItem.setReturnQuantity(Integer.valueOf(0));
        localOrderItem.setProduct(localProduct);
        localOrderItem.setOrder(localOrder);
        ((List)localObject1).add(localOrderItem);
      }
    }
    Object localObject2 = SettingUtils.get();
    if ((((Setting)localObject2).getIsInvoiceEnabled().booleanValue()) && (isInvoice) && (StringUtils.isNotEmpty(invoiceTitle)))
    {
      localOrder.setIsInvoice(Boolean.valueOf(true));
      localOrder.setInvoiceTitle(invoiceTitle);
      localOrder.setTax(localOrder.calculateTax());
    }
    else
    {
      localOrder.setIsInvoice(Boolean.valueOf(false));
      localOrder.setTax(new BigDecimal(0));
    }
    if (useBalance)
    {
      localObject3 = cart.getMember();
      if (((Member)localObject3).getBalance().compareTo(localOrder.getAmount()) >= 0)
        localOrder.setAmountPaid(localOrder.getAmount());
      else
        localOrder.setAmountPaid(((Member)localObject3).getBalance());
    }
    else
    {
      localOrder.setAmountPaid(new BigDecimal(0));
    }
    if (localOrder.getAmountPayable().compareTo(new BigDecimal(0)) == 0)
    {
      localOrder.setOrderStatus(Order.OrderStatus.confirmed);
      localOrder.setPaymentStatus(Order.PaymentStatus.paid);
    }
    else if ((localOrder.getAmountPayable().compareTo(new BigDecimal(0)) > 0) && (localOrder.getAmountPaid().compareTo(new BigDecimal(0)) > 0))
    {
      localOrder.setOrderStatus(Order.OrderStatus.confirmed);
      localOrder.setPaymentStatus(Order.PaymentStatus.partialPayment);
    }
    else
    {
      localOrder.setOrderStatus(Order.OrderStatus.unconfirmed);
      localOrder.setPaymentStatus(Order.PaymentStatus.unpaid);
    }
    if ((paymentMethod != null) && (paymentMethod.getTimeout() != null) && (localOrder.getPaymentStatus() == Order.PaymentStatus.unpaid))
      localOrder.setExpire(DateUtils.addMinutes(new Date(), paymentMethod.getTimeout().intValue()));
    return localOrder;
  }

  public net.shopxx.entity.Order create(Cart cart, Receiver receiver, PaymentMethod paymentMethod, ShippingMethod shippingMethod, CouponCode couponCode, boolean isInvoice, String invoiceTitle, boolean useBalance, String memo, Admin operator)
  {
    Assert.notNull(cart);
    Assert.notNull(cart.getMember());
    Assert.notEmpty(cart.getCartItems());
    Assert.notNull(receiver);
    Assert.notNull(paymentMethod);
    Assert.notNull(shippingMethod);
    net.shopxx.entity.Order localOrder = build(cart, receiver, paymentMethod, shippingMethod, couponCode, isInvoice, invoiceTitle, useBalance, memo);
    localOrder.setSn(this.IIIlllll.generate(Sn.Type.order));
    if (paymentMethod.getType() == PaymentMethod.Type.online)
    {
      localOrder.setLockExpire(DateUtils.addSeconds(new Date(), 10));
      localOrder.setOperator(operator);
    }
    if (localOrder.getCouponCode() != null)
    {
      couponCode.setIsUsed(Boolean.valueOf(true));
      couponCode.setUsedDate(new Date());
      this.IIIllllI.merge(couponCode);
    }
    Object localObject2 = cart.getPromotions().iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Promotion)((Iterator)localObject2).next();
      localObject4 = ((Promotion)localObject1).getCoupons().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject3 = (Coupon)((Iterator)localObject4).next();
        localOrder.getCoupons().add(localObject3);
      }
    }
    Object localObject1 = SettingUtils.get();
    if ((((Setting)localObject1).getStockAllocationTime() == Setting.StockAllocationTime.order) || ((((Setting)localObject1).getStockAllocationTime() == Setting.StockAllocationTime.payment) && ((localOrder.getPaymentStatus() == Order.PaymentStatus.partialPayment) || (localOrder.getPaymentStatus() == Order.PaymentStatus.paid))))
      localOrder.setIsAllocatedStock(Boolean.valueOf(true));
    else
      localOrder.setIsAllocatedStock(Boolean.valueOf(false));
    this.IIIllIlI.persist(localOrder);
    localObject2 = new OrderLog();
    ((OrderLog)localObject2).setType(OrderLog.Type.create);
    ((OrderLog)localObject2).setOperator(operator != null ? operator.getUsername() : null);
    ((OrderLog)localObject2).setOrder(localOrder);
    this.IIIlllII.persist(localObject2);
    Object localObject3 = cart.getMember();
    if (localOrder.getAmountPaid().compareTo(new BigDecimal(0)) > 0)
    {
      this.IIlIIIII.lock(localObject3, LockModeType.PESSIMISTIC_WRITE);
      ((Member)localObject3).setBalance(((Member)localObject3).getBalance().subtract(localOrder.getAmountPaid()));
      this.IIlIIIII.merge(localObject3);
      localObject4 = new Deposit();
      ((Deposit)localObject4).setType(operator != null ? Deposit.Type.adminPayment : Deposit.Type.memberPayment);
      ((Deposit)localObject4).setCredit(new BigDecimal(0));
      ((Deposit)localObject4).setDebit(localOrder.getAmountPaid());
      ((Deposit)localObject4).setBalance(((Member)localObject3).getBalance());
      ((Deposit)localObject4).setOperator(operator != null ? operator.getUsername() : null);
      ((Deposit)localObject4).setMember((Member)localObject3);
      ((Deposit)localObject4).setOrder(localOrder);
      this.IIlIIIll.persist(localObject4);
    }
    if ((((Setting)localObject1).getStockAllocationTime() == Setting.StockAllocationTime.order) || ((((Setting)localObject1).getStockAllocationTime() == Setting.StockAllocationTime.payment) && ((localOrder.getPaymentStatus() == Order.PaymentStatus.partialPayment) || (localOrder.getPaymentStatus() == Order.PaymentStatus.paid))))
    {
      Iterator localIterator = localOrder.getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        localObject4 = (OrderItem)localIterator.next();
        if (localObject4 != null)
        {
          Product localProduct = ((OrderItem)localObject4).getProduct();
          this.IIlIIIlI.lock(localProduct, LockModeType.PESSIMISTIC_WRITE);
          if ((localProduct != null) && (localProduct.getStock() != null))
          {
            localProduct.setAllocatedStock(Integer.valueOf(localProduct.getAllocatedStock().intValue() + (((OrderItem)localObject4).getQuantity().intValue() - ((OrderItem)localObject4).getShippedQuantity().intValue())));
            this.IIlIIIlI.merge(localProduct);
            this.IIIllIlI.flush();
            this.IIlIlIII.build(localProduct);
          }
        }
      }
    }
    this.IIIlllIl.remove(cart);
    return localOrder;
  }

  public void update(net.shopxx.entity.Order order, Admin operator)
  {
    Assert.notNull(order);
    net.shopxx.entity.Order localOrder = (net.shopxx.entity.Order)this.IIIllIlI.find(order.getId());
    if (localOrder.getIsAllocatedStock().booleanValue())
    {
      Iterator localIterator = localOrder.getOrderItems().iterator();
      Product localProduct;
      while (localIterator.hasNext())
      {
        localObject = (OrderItem)localIterator.next();
        if (localObject != null)
        {
          localProduct = ((OrderItem)localObject).getProduct();
          this.IIlIIIlI.lock(localProduct, LockModeType.PESSIMISTIC_WRITE);
          if ((localProduct != null) && (localProduct.getStock() != null))
          {
            localProduct.setAllocatedStock(Integer.valueOf(localProduct.getAllocatedStock().intValue() - (((OrderItem)localObject).getQuantity().intValue() - ((OrderItem)localObject).getShippedQuantity().intValue())));
            this.IIlIIIlI.merge(localProduct);
            this.IIIllIlI.flush();
            this.IIlIlIII.build(localProduct);
          }
        }
      }
      localIterator = order.getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        localObject = (OrderItem)localIterator.next();
        if (localObject != null)
        {
          localProduct = ((OrderItem)localObject).getProduct();
          this.IIlIIIlI.lock(localProduct, LockModeType.PESSIMISTIC_WRITE);
          if ((localProduct != null) && (localProduct.getStock() != null))
          {
            localProduct.setAllocatedStock(Integer.valueOf(localProduct.getAllocatedStock().intValue() + (((OrderItem)localObject).getQuantity().intValue() - ((OrderItem)localObject).getShippedQuantity().intValue())));
            this.IIlIIIlI.merge(localProduct);
            this.IIlIIIlI.flush();
            this.IIlIlIII.build(localProduct);
          }
        }
      }
    }
    this.IIIllIlI.merge(order);
    Object localObject = new OrderLog();
    ((OrderLog)localObject).setType(OrderLog.Type.modify);
    ((OrderLog)localObject).setOperator(operator != null ? operator.getUsername() : null);
    ((OrderLog)localObject).setOrder(order);
    this.IIIlllII.persist(localObject);
  }

  public void confirm(net.shopxx.entity.Order order, Admin operator)
  {
    Assert.notNull(order);
    order.setOrderStatus(Order.OrderStatus.confirmed);
    this.IIIllIlI.merge(order);
    OrderLog localOrderLog = new OrderLog();
    localOrderLog.setType(OrderLog.Type.confirm);
    localOrderLog.setOperator(operator != null ? operator.getUsername() : null);
    localOrderLog.setOrder(order);
    this.IIIlllII.persist(localOrderLog);
  }

  public void complete(net.shopxx.entity.Order order, Admin operator)
  {
    Assert.notNull(order);
    Member localMember = order.getMember();
    this.IIlIIIII.lock(localMember, LockModeType.PESSIMISTIC_WRITE);
    if ((order.getShippingStatus() == Order.ShippingStatus.partialShipment) || (order.getShippingStatus() == Order.ShippingStatus.shipped))
    {
      localMember.setPoint(Long.valueOf(localMember.getPoint().longValue() + order.getPoint().intValue()));
      localIterator = order.getCoupons().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Coupon)localIterator.next();
        this.IIIllllI.build((Coupon)localObject, localMember);
      }
    }
    if ((order.getShippingStatus() == Order.ShippingStatus.unshipped) || (order.getShippingStatus() == Order.ShippingStatus.returned))
    {
      localObject = order.getCouponCode();
      if (localObject != null)
      {
        ((CouponCode)localObject).setIsUsed(Boolean.valueOf(false));
        ((CouponCode)localObject).setUsedDate(null);
        this.IIIllllI.merge(localObject);
        order.setCouponCode(null);
        this.IIIllIlI.merge(order);
      }
    }
    localMember.setAmount(localMember.getAmount().add(order.getAmountPaid()));
    if (!localMember.getMemberRank().getIsSpecial().booleanValue())
    {
      localObject = this.IIlIIIIl.findByAmount(localMember.getAmount());
      if ((localObject != null) && (((MemberRank)localObject).getAmount().compareTo(localMember.getMemberRank().getAmount()) > 0))
        localMember.setMemberRank((MemberRank)localObject);
    }
    this.IIlIIIII.merge(localMember);
    Product localProduct;
    if (order.getIsAllocatedStock().booleanValue())
    {
      localIterator = order.getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        localObject = (OrderItem)localIterator.next();
        if (localObject != null)
        {
          localProduct = ((OrderItem)localObject).getProduct();
          this.IIlIIIlI.lock(localProduct, LockModeType.PESSIMISTIC_WRITE);
          if ((localProduct != null) && (localProduct.getStock() != null))
          {
            localProduct.setAllocatedStock(Integer.valueOf(localProduct.getAllocatedStock().intValue() - (((OrderItem)localObject).getQuantity().intValue() - ((OrderItem)localObject).getShippedQuantity().intValue())));
            this.IIlIIIlI.merge(localProduct);
            this.IIIllIlI.flush();
            this.IIlIlIII.build(localProduct);
          }
        }
      }
      order.setIsAllocatedStock(Boolean.valueOf(false));
    }
    Iterator localIterator = order.getOrderItems().iterator();
    while (localIterator.hasNext())
    {
      localObject = (OrderItem)localIterator.next();
      if (localObject != null)
      {
        localProduct = ((OrderItem)localObject).getProduct();
        this.IIlIIIlI.lock(localProduct, LockModeType.PESSIMISTIC_WRITE);
        if (localProduct != null)
        {
          Integer localInteger = ((OrderItem)localObject).getQuantity();
          Calendar localCalendar1 = Calendar.getInstance();
          Calendar localCalendar2 = DateUtils.toCalendar(localProduct.getWeekSalesDate());
          Calendar localCalendar3 = DateUtils.toCalendar(localProduct.getMonthSalesDate());
          if ((localCalendar1.get(1) != localCalendar2.get(1)) || (localCalendar1.get(3) > localCalendar2.get(3)))
            localProduct.setWeekSales(Long.valueOf(localInteger.intValue()));
          else
            localProduct.setWeekSales(Long.valueOf(localProduct.getWeekSales().longValue() + localInteger.intValue()));
          if ((localCalendar1.get(1) != localCalendar3.get(1)) || (localCalendar1.get(2) > localCalendar3.get(2)))
            localProduct.setMonthSales(Long.valueOf(localInteger.intValue()));
          else
            localProduct.setMonthSales(Long.valueOf(localProduct.getMonthSales().longValue() + localInteger.intValue()));
          localProduct.setSales(Long.valueOf(localProduct.getSales().longValue() + localInteger.intValue()));
          localProduct.setWeekSalesDate(new Date());
          localProduct.setMonthSalesDate(new Date());
          this.IIlIIIlI.merge(localProduct);
          this.IIIllIlI.flush();
          this.IIlIlIII.build(localProduct);
        }
      }
    }
    order.setOrderStatus(Order.OrderStatus.completed);
    order.setExpire(null);
    this.IIIllIlI.merge(order);
    Object localObject = new OrderLog();
    ((OrderLog)localObject).setType(OrderLog.Type.complete);
    ((OrderLog)localObject).setOperator(operator != null ? operator.getUsername() : null);
    ((OrderLog)localObject).setOrder(order);
    this.IIIlllII.persist(localObject);
  }

  public void cancel(net.shopxx.entity.Order order, Admin operator)
  {
    Assert.notNull(order);
    CouponCode localCouponCode = order.getCouponCode();
    if (localCouponCode != null)
    {
      localCouponCode.setIsUsed(Boolean.valueOf(false));
      localCouponCode.setUsedDate(null);
      this.IIIllllI.merge(localCouponCode);
      order.setCouponCode(null);
      this.IIIllIlI.merge(order);
    }
    if (order.getIsAllocatedStock().booleanValue())
    {
      Iterator localIterator = order.getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        localObject = (OrderItem)localIterator.next();
        if (localObject != null)
        {
          Product localProduct = ((OrderItem)localObject).getProduct();
          this.IIlIIIlI.lock(localProduct, LockModeType.PESSIMISTIC_WRITE);
          if ((localProduct != null) && (localProduct.getStock() != null))
          {
            localProduct.setAllocatedStock(Integer.valueOf(localProduct.getAllocatedStock().intValue() - (((OrderItem)localObject).getQuantity().intValue() - ((OrderItem)localObject).getShippedQuantity().intValue())));
            this.IIlIIIlI.merge(localProduct);
            this.IIIllIlI.flush();
            this.IIlIlIII.build(localProduct);
          }
        }
      }
      order.setIsAllocatedStock(Boolean.valueOf(false));
    }
    order.setOrderStatus(Order.OrderStatus.cancelled);
    order.setExpire(null);
    this.IIIllIlI.merge(order);
    Object localObject = new OrderLog();
    ((OrderLog)localObject).setType(OrderLog.Type.cancel);
    ((OrderLog)localObject).setOperator(operator != null ? operator.getUsername() : null);
    ((OrderLog)localObject).setOrder(order);
    this.IIIlllII.persist(localObject);
  }

  public void payment(net.shopxx.entity.Order order, Payment payment, Admin operator)
  {
    Assert.notNull(order);
    Assert.notNull(payment);
    this.IIIllIlI.lock(order, LockModeType.PESSIMISTIC_WRITE);
    payment.setOrder(order);
    this.IIlIIlII.merge(payment);
    if (payment.getType() == Payment.Type.deposit)
    {
      localObject1 = order.getMember();
      this.IIlIIIII.lock(localObject1, LockModeType.PESSIMISTIC_WRITE);
      ((Member)localObject1).setBalance(((Member)localObject1).getBalance().subtract(payment.getAmount()));
      this.IIlIIIII.merge(localObject1);
      localObject2 = new Deposit();
      ((Deposit)localObject2).setType(operator != null ? Deposit.Type.adminPayment : Deposit.Type.memberPayment);
      ((Deposit)localObject2).setCredit(new BigDecimal(0));
      ((Deposit)localObject2).setDebit(payment.getAmount());
      ((Deposit)localObject2).setBalance(((Member)localObject1).getBalance());
      ((Deposit)localObject2).setOperator(operator != null ? operator.getUsername() : null);
      ((Deposit)localObject2).setMember((Member)localObject1);
      ((Deposit)localObject2).setOrder(order);
      this.IIlIIIll.persist(localObject2);
    }
    Object localObject1 = SettingUtils.get();
    if ((!order.getIsAllocatedStock().booleanValue()) && (((Setting)localObject1).getStockAllocationTime() == Setting.StockAllocationTime.payment))
    {
      Iterator localIterator = order.getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (OrderItem)localIterator.next();
        if (localObject2 != null)
        {
          Product localProduct = ((OrderItem)localObject2).getProduct();
          this.IIlIIIlI.lock(localProduct, LockModeType.PESSIMISTIC_WRITE);
          if ((localProduct != null) && (localProduct.getStock() != null))
          {
            localProduct.setAllocatedStock(Integer.valueOf(localProduct.getAllocatedStock().intValue() + (((OrderItem)localObject2).getQuantity().intValue() - ((OrderItem)localObject2).getShippedQuantity().intValue())));
            this.IIlIIIlI.merge(localProduct);
            this.IIIllIlI.flush();
            this.IIlIlIII.build(localProduct);
          }
        }
      }
      order.setIsAllocatedStock(Boolean.valueOf(true));
    }
    order.setAmountPaid(order.getAmountPaid().add(payment.getAmount()));
    order.setFee(payment.getFee());
    order.setExpire(null);
    if (order.getAmountPaid().compareTo(order.getAmount()) >= 0)
    {
      order.setOrderStatus(Order.OrderStatus.confirmed);
      order.setPaymentStatus(Order.PaymentStatus.paid);
    }
    else if (order.getAmountPaid().compareTo(new BigDecimal(0)) > 0)
    {
      order.setOrderStatus(Order.OrderStatus.confirmed);
      order.setPaymentStatus(Order.PaymentStatus.partialPayment);
    }
    this.IIIllIlI.merge(order);
    Object localObject2 = new OrderLog();
    ((OrderLog)localObject2).setType(OrderLog.Type.payment);
    ((OrderLog)localObject2).setOperator(operator != null ? operator.getUsername() : null);
    ((OrderLog)localObject2).setOrder(order);
    this.IIIlllII.persist(localObject2);
  }

  public void refunds(net.shopxx.entity.Order order, Refunds refunds, Admin operator)
  {
    Assert.notNull(order);
    Assert.notNull(refunds);
    this.IIIllIlI.lock(order, LockModeType.PESSIMISTIC_WRITE);
    refunds.setOrder(order);
    this.IIlIIlIl.persist(refunds);
    if (refunds.getType() == Refunds.Type.deposit)
    {
      localObject = order.getMember();
      this.IIlIIIII.lock(localObject, LockModeType.PESSIMISTIC_WRITE);
      ((Member)localObject).setBalance(((Member)localObject).getBalance().add(refunds.getAmount()));
      this.IIlIIIII.merge(localObject);
      Deposit localDeposit = new Deposit();
      localDeposit.setType(Deposit.Type.adminRefunds);
      localDeposit.setCredit(refunds.getAmount());
      localDeposit.setDebit(new BigDecimal(0));
      localDeposit.setBalance(((Member)localObject).getBalance());
      localDeposit.setOperator(operator != null ? operator.getUsername() : null);
      localDeposit.setMember((Member)localObject);
      localDeposit.setOrder(order);
      this.IIlIIIll.persist(localDeposit);
    }
    order.setAmountPaid(order.getAmountPaid().subtract(refunds.getAmount()));
    order.setExpire(null);
    if (order.getAmountPaid().compareTo(new BigDecimal(0)) == 0)
      order.setPaymentStatus(Order.PaymentStatus.refunded);
    else if (order.getAmountPaid().compareTo(new BigDecimal(0)) > 0)
      order.setPaymentStatus(Order.PaymentStatus.partialRefunds);
    this.IIIllIlI.merge(order);
    Object localObject = new OrderLog();
    ((OrderLog)localObject).setType(OrderLog.Type.refunds);
    ((OrderLog)localObject).setOperator(operator != null ? operator.getUsername() : null);
    ((OrderLog)localObject).setOrder(order);
    this.IIIlllII.persist(localObject);
  }

  public void shipping(net.shopxx.entity.Order order, Shipping shipping, Admin operator)
  {
    Assert.notNull(order);
    Assert.notNull(shipping);
    Assert.notEmpty(shipping.getShippingItems());
    this.IIIllIlI.lock(order, LockModeType.PESSIMISTIC_WRITE);
    Setting localSetting = SettingUtils.get();
    Object localObject2;
    if ((!order.getIsAllocatedStock().booleanValue()) && (localSetting.getStockAllocationTime() == Setting.StockAllocationTime.ship))
    {
      localIterator = order.getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (OrderItem)localIterator.next();
        if (localObject1 != null)
        {
          localObject2 = ((OrderItem)localObject1).getProduct();
          this.IIlIIIlI.lock(localObject2, LockModeType.PESSIMISTIC_WRITE);
          if ((localObject2 != null) && (((Product)localObject2).getStock() != null))
          {
            ((Product)localObject2).setAllocatedStock(Integer.valueOf(((Product)localObject2).getAllocatedStock().intValue() + (((OrderItem)localObject1).getQuantity().intValue() - ((OrderItem)localObject1).getShippedQuantity().intValue())));
            this.IIlIIIlI.merge(localObject2);
            this.IIIllIlI.flush();
            this.IIlIlIII.build((Product)localObject2);
          }
        }
      }
      order.setIsAllocatedStock(Boolean.valueOf(true));
    }
    shipping.setOrder(order);
    this.IIlIIllI.persist(shipping);
    Iterator localIterator = shipping.getShippingItems().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (ShippingItem)localIterator.next();
      localObject2 = order.getOrderItem(((ShippingItem)localObject1).getSn());
      if (localObject2 != null)
      {
        Product localProduct = ((OrderItem)localObject2).getProduct();
        this.IIlIIIlI.lock(localProduct, LockModeType.PESSIMISTIC_WRITE);
        if (localProduct != null)
        {
          if (localProduct.getStock() != null)
          {
            localProduct.setStock(Integer.valueOf(localProduct.getStock().intValue() - ((ShippingItem)localObject1).getQuantity().intValue()));
            if (order.getIsAllocatedStock().booleanValue())
              localProduct.setAllocatedStock(Integer.valueOf(localProduct.getAllocatedStock().intValue() - ((ShippingItem)localObject1).getQuantity().intValue()));
          }
          this.IIlIIIlI.merge(localProduct);
          this.IIIllIlI.flush();
          this.IIlIlIII.build(localProduct);
        }
        this.IIIllIll.lock(localObject2, LockModeType.PESSIMISTIC_WRITE);
        ((OrderItem)localObject2).setShippedQuantity(Integer.valueOf(((OrderItem)localObject2).getShippedQuantity().intValue() + ((ShippingItem)localObject1).getQuantity().intValue()));
      }
    }
    if (order.getShippedQuantity() >= order.getQuantity())
    {
      order.setShippingStatus(Order.ShippingStatus.shipped);
      order.setIsAllocatedStock(Boolean.valueOf(false));
    }
    else if (order.getShippedQuantity() > 0)
    {
      order.setShippingStatus(Order.ShippingStatus.partialShipment);
    }
    order.setExpire(null);
    this.IIIllIlI.merge(order);
    Object localObject1 = new OrderLog();
    ((OrderLog)localObject1).setType(OrderLog.Type.shipping);
    ((OrderLog)localObject1).setOperator(operator != null ? operator.getUsername() : null);
    ((OrderLog)localObject1).setOrder(order);
    this.IIIlllII.persist(localObject1);
  }

  public void returns(net.shopxx.entity.Order order, Returns returns, Admin operator)
  {
    Assert.notNull(order);
    Assert.notNull(returns);
    Assert.notEmpty(returns.getReturnsItems());
    this.IIIllIlI.lock(order, LockModeType.PESSIMISTIC_WRITE);
    returns.setOrder(order);
    this.IIlIIlll.persist(returns);
    Iterator localIterator = returns.getReturnsItems().iterator();
    while (localIterator.hasNext())
    {
      localObject = (ReturnsItem)localIterator.next();
      OrderItem localOrderItem = order.getOrderItem(((ReturnsItem)localObject).getSn());
      if (localOrderItem != null)
      {
        this.IIIllIll.lock(localOrderItem, LockModeType.PESSIMISTIC_WRITE);
        localOrderItem.setReturnQuantity(Integer.valueOf(localOrderItem.getReturnQuantity().intValue() + ((ReturnsItem)localObject).getQuantity().intValue()));
      }
    }
    if (order.getReturnQuantity() >= order.getShippedQuantity())
      order.setShippingStatus(Order.ShippingStatus.returned);
    else if (order.getReturnQuantity() > 0)
      order.setShippingStatus(Order.ShippingStatus.partialReturns);
    order.setExpire(null);
    this.IIIllIlI.merge(order);
    Object localObject = new OrderLog();
    ((OrderLog)localObject).setType(OrderLog.Type.returns);
    ((OrderLog)localObject).setOperator(operator != null ? operator.getUsername() : null);
    ((OrderLog)localObject).setOrder(order);
    this.IIIlllII.persist(localObject);
  }

  public void delete(net.shopxx.entity.Order order)
  {
    if (order.getIsAllocatedStock().booleanValue())
    {
      Iterator localIterator = order.getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        OrderItem localOrderItem = (OrderItem)localIterator.next();
        if (localOrderItem != null)
        {
          Product localProduct = localOrderItem.getProduct();
          this.IIlIIIlI.lock(localProduct, LockModeType.PESSIMISTIC_WRITE);
          if ((localProduct != null) && (localProduct.getStock() != null))
          {
            localProduct.setAllocatedStock(Integer.valueOf(localProduct.getAllocatedStock().intValue() - (localOrderItem.getQuantity().intValue() - localOrderItem.getShippedQuantity().intValue())));
            this.IIlIIIlI.merge(localProduct);
            this.IIIllIlI.flush();
            this.IIlIlIII.build(localProduct);
          }
        }
      }
    }
    super.delete(order);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.OrderServiceImpl
 * JD-Core Version:    0.6.2
 */