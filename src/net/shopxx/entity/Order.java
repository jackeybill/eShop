package net.shopxx.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import net.shopxx.Setting;
import net.shopxx.util.SettingUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_order")
public class Order extends BaseEntity
{
  private static final long serialVersionUID = 8370942500343156156L;
  private static final String IIIllIlI = " ";
  private String IIIllIll;
  private Order.OrderStatus IIIlllII;
  private Order.PaymentStatus IIIlllIl;
  private Order.ShippingStatus IIIllllI;
  private BigDecimal IIIlllll;
  private BigDecimal IIlIIIII;
  private BigDecimal IIlIIIIl;
  private BigDecimal IIlIIIlI;
  private Integer IIlIIIll;
  private String IIlIIlII;
  private String IIlIIlIl;
  private String IIlIIllI;
  private String IIlIIlll;
  private String IIlIlIII;
  private Boolean IIlIlIIl;
  private String IIlIlIlI;
  private BigDecimal IIlIlIll;
  private String IIlIllII;
  private String IIlIllIl;
  private Date IIlIlllI;
  private Date IIlIllll;
  private Boolean IIllIIII;
  private String IIllIIIl;
  private String IIllIIlI;
  private Area IIllIIll;
  private PaymentMethod IIllIlII;
  private ShippingMethod IIllIlIl;
  private Admin IIllIllI;
  private Member IIllIlll;
  private CouponCode IIlllIII;
  private List<Coupon> IIlllIIl = new ArrayList();
  private List<OrderItem> IIlllIlI = new ArrayList();
  private Set<OrderLog> IIlllIll = new HashSet();
  private Set<Deposit> IIllllII = new HashSet();
  private Set<Payment> IIllllIl = new HashSet();
  private Set<Refunds> IIlllllI = new HashSet();
  private Set<Shipping> IIllllll = new HashSet();
  private Set<Returns> IlIIIIII = new HashSet();

  @Column(nullable=false, updatable=false, unique=true)
  public String getSn()
  {
    return this.IIIllIll;
  }

  public void setSn(String sn)
  {
    this.IIIllIll = sn;
  }

  @Column(nullable=false)
  public Order.OrderStatus getOrderStatus()
  {
    return this.IIIlllII;
  }

  public void setOrderStatus(Order.OrderStatus orderStatus)
  {
    this.IIIlllII = orderStatus;
  }

  @Column(nullable=false)
  public Order.PaymentStatus getPaymentStatus()
  {
    return this.IIIlllIl;
  }

  public void setPaymentStatus(Order.PaymentStatus paymentStatus)
  {
    this.IIIlllIl = paymentStatus;
  }

  @Column(nullable=false)
  public Order.ShippingStatus getShippingStatus()
  {
    return this.IIIllllI;
  }

  public void setShippingStatus(Order.ShippingStatus shippingStatus)
  {
    this.IIIllllI = shippingStatus;
  }

  @Column(nullable=false, precision=21, scale=6)
  public BigDecimal getFee()
  {
    return this.IIIlllll;
  }

  public void setFee(BigDecimal fee)
  {
    this.IIIlllll = fee;
  }

  @NotNull
  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(nullable=false, precision=21, scale=6)
  public BigDecimal getFreight()
  {
    return this.IIlIIIII;
  }

  public void setFreight(BigDecimal freight)
  {
    this.IIlIIIII = freight;
  }

  @NotNull
  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(nullable=false, precision=21, scale=6)
  public BigDecimal getDiscount()
  {
    return this.IIlIIIIl;
  }

  public void setDiscount(BigDecimal discount)
  {
    this.IIlIIIIl = discount;
  }

  @Column(nullable=false, precision=21, scale=6)
  public BigDecimal getAmountPaid()
  {
    return this.IIlIIIlI;
  }

  public void setAmountPaid(BigDecimal amountPaid)
  {
    this.IIlIIIlI = amountPaid;
  }

  @NotNull
  @Min(0L)
  @Column(nullable=false)
  public Integer getPoint()
  {
    return this.IIlIIIll;
  }

  public void setPoint(Integer point)
  {
    this.IIlIIIll = point;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getConsignee()
  {
    return this.IIlIIlII;
  }

  public void setConsignee(String consignee)
  {
    this.IIlIIlII = consignee;
  }

  @Column(nullable=false)
  public String getAreaName()
  {
    return this.IIlIIlIl;
  }

  public void setAreaName(String areaName)
  {
    this.IIlIIlIl = areaName;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getAddress()
  {
    return this.IIlIIllI;
  }

  public void setAddress(String address)
  {
    this.IIlIIllI = address;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getZipCode()
  {
    return this.IIlIIlll;
  }

  public void setZipCode(String zipCode)
  {
    this.IIlIIlll = zipCode;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getPhone()
  {
    return this.IIlIlIII;
  }

  public void setPhone(String phone)
  {
    this.IIlIlIII = phone;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsInvoice()
  {
    return this.IIlIlIIl;
  }

  public void setIsInvoice(Boolean isInvoice)
  {
    this.IIlIlIIl = isInvoice;
  }

  @Length(max=200)
  public String getInvoiceTitle()
  {
    return this.IIlIlIlI;
  }

  public void setInvoiceTitle(String invoiceTitle)
  {
    this.IIlIlIlI = invoiceTitle;
  }

  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(nullable=false, precision=21, scale=6)
  public BigDecimal getTax()
  {
    return this.IIlIlIll;
  }

  public void setTax(BigDecimal tax)
  {
    this.IIlIlIll = tax;
  }

  @Length(max=200)
  public String getMemo()
  {
    return this.IIlIllII;
  }

  public void setMemo(String memo)
  {
    this.IIlIllII = memo;
  }

  @Column(updatable=false)
  public String getPromotion()
  {
    return this.IIlIllIl;
  }

  public void setPromotion(String promotion)
  {
    this.IIlIllIl = promotion;
  }

  public Date getExpire()
  {
    return this.IIlIlllI;
  }

  public void setExpire(Date expire)
  {
    this.IIlIlllI = expire;
  }

  public Date getLockExpire()
  {
    return this.IIlIllll;
  }

  public void setLockExpire(Date lockExpire)
  {
    this.IIlIllll = lockExpire;
  }

  @Column(nullable=false)
  public Boolean getIsAllocatedStock()
  {
    return this.IIllIIII;
  }

  public void setIsAllocatedStock(Boolean isAllocatedStock)
  {
    this.IIllIIII = isAllocatedStock;
  }

  @Column(nullable=false)
  public String getPaymentMethodName()
  {
    return this.IIllIIIl;
  }

  public void setPaymentMethodName(String paymentMethodName)
  {
    this.IIllIIIl = paymentMethodName;
  }

  @Column(nullable=false)
  public String getShippingMethodName()
  {
    return this.IIllIIlI;
  }

  public void setShippingMethodName(String shippingMethodName)
  {
    this.IIllIIlI = shippingMethodName;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  public Area getArea()
  {
    return this.IIllIIll;
  }

  public void setArea(Area area)
  {
    this.IIllIIll = area;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  public PaymentMethod getPaymentMethod()
  {
    return this.IIllIlII;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod)
  {
    this.IIllIlII = paymentMethod;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  public ShippingMethod getShippingMethod()
  {
    return this.IIllIlIl;
  }

  public void setShippingMethod(ShippingMethod shippingMethod)
  {
    this.IIllIlIl = shippingMethod;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  public Admin getOperator()
  {
    return this.IIllIllI;
  }

  public void setOperator(Admin operator)
  {
    this.IIllIllI = operator;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Member getMember()
  {
    return this.IIllIlll;
  }

  public void setMember(Member member)
  {
    this.IIllIlll = member;
  }

  @OneToOne(fetch=FetchType.LAZY)
  public CouponCode getCouponCode()
  {
    return this.IIlllIII;
  }

  public void setCouponCode(CouponCode couponCode)
  {
    this.IIlllIII = couponCode;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_order_coupon")
  public List<Coupon> getCoupons()
  {
    return this.IIlllIIl;
  }

  public void setCoupons(List<Coupon> coupons)
  {
    this.IIlllIIl = coupons;
  }

  @Valid
  @NotEmpty
  @OneToMany(mappedBy="order", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL}, orphanRemoval=true)
  @OrderBy("isGift asc")
  public List<OrderItem> getOrderItems()
  {
    return this.IIlllIlI;
  }

  public void setOrderItems(List<OrderItem> orderItems)
  {
    this.IIlllIlI = orderItems;
  }

  @OneToMany(mappedBy="order", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("createDate asc")
  public Set<OrderLog> getOrderLogs()
  {
    return this.IIlllIll;
  }

  public void setOrderLogs(Set<OrderLog> orderLogs)
  {
    this.IIlllIll = orderLogs;
  }

  @OneToMany(mappedBy="order", fetch=FetchType.LAZY)
  public Set<Deposit> getDeposits()
  {
    return this.IIllllII;
  }

  public void setDeposits(Set<Deposit> deposits)
  {
    this.IIllllII = deposits;
  }

  @OneToMany(mappedBy="order", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("createDate asc")
  public Set<Payment> getPayments()
  {
    return this.IIllllIl;
  }

  public void setPayments(Set<Payment> payments)
  {
    this.IIllllIl = payments;
  }

  @OneToMany(mappedBy="order", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("createDate asc")
  public Set<Refunds> getRefunds()
  {
    return this.IIlllllI;
  }

  public void setRefunds(Set<Refunds> refunds)
  {
    this.IIlllllI = refunds;
  }

  @OneToMany(mappedBy="order", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("createDate asc")
  public Set<Shipping> getShippings()
  {
    return this.IIllllll;
  }

  public void setShippings(Set<Shipping> shippings)
  {
    this.IIllllll = shippings;
  }

  @OneToMany(mappedBy="order", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("createDate asc")
  public Set<Returns> getReturns()
  {
    return this.IlIIIIII;
  }

  public void setReturns(Set<Returns> returns)
  {
    this.IlIIIIII = returns;
  }

  @Transient
  public String getProductName()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (getOrderItems() != null)
    {
      Iterator localIterator = getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        OrderItem localOrderItem = (OrderItem)localIterator.next();
        if ((localOrderItem != null) && (localOrderItem.getFullName() != null))
          localStringBuffer.append(" ").append(localOrderItem.getFullName());
      }
      if (localStringBuffer.length() > 0)
        localStringBuffer.deleteCharAt(0);
    }
    return localStringBuffer.toString();
  }

  @Transient
  public int getWeight()
  {
    int i = 0;
    if (getOrderItems() != null)
    {
      Iterator localIterator = getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        OrderItem localOrderItem = (OrderItem)localIterator.next();
        if (localOrderItem != null)
          i += localOrderItem.getTotalWeight();
      }
    }
    return i;
  }

  @Transient
  public int getQuantity()
  {
    int i = 0;
    if (getOrderItems() != null)
    {
      Iterator localIterator = getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        OrderItem localOrderItem = (OrderItem)localIterator.next();
        if ((localOrderItem != null) && (localOrderItem.getQuantity() != null))
          i += localOrderItem.getQuantity().intValue();
      }
    }
    return i;
  }

  @Transient
  public int getShippedQuantity()
  {
    int i = 0;
    if (getOrderItems() != null)
    {
      Iterator localIterator = getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        OrderItem localOrderItem = (OrderItem)localIterator.next();
        if ((localOrderItem != null) && (localOrderItem.getShippedQuantity() != null))
          i += localOrderItem.getShippedQuantity().intValue();
      }
    }
    return i;
  }

  @Transient
  public int getReturnQuantity()
  {
    int i = 0;
    if (getOrderItems() != null)
    {
      Iterator localIterator = getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        OrderItem localOrderItem = (OrderItem)localIterator.next();
        if ((localOrderItem != null) && (localOrderItem.getReturnQuantity() != null))
          i += localOrderItem.getReturnQuantity().intValue();
      }
    }
    return i;
  }

  @Transient
  public BigDecimal getPrice()
  {
    BigDecimal localBigDecimal = new BigDecimal(0);
    if (getOrderItems() != null)
    {
      Iterator localIterator = getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        OrderItem localOrderItem = (OrderItem)localIterator.next();
        if ((localOrderItem != null) && (localOrderItem.getSubtotal() != null))
          localBigDecimal = localBigDecimal.add(localOrderItem.getSubtotal());
      }
    }
    return localBigDecimal;
  }

  @Transient
  public BigDecimal getAmount()
  {
    BigDecimal localBigDecimal = getPrice().subtract(getDiscount() != null ? getDiscount() : new BigDecimal(0)).add(getFreight() != null ? getFreight() : new BigDecimal(0)).add(getFee() != null ? getFee() : new BigDecimal(0)).add(getTax() != null ? getTax() : new BigDecimal(0));
    return localBigDecimal.compareTo(new BigDecimal(0)) > 0 ? localBigDecimal : new BigDecimal(0);
  }

  @Transient
  public BigDecimal getAmountPayable()
  {
    BigDecimal localBigDecimal = getAmount().subtract(getAmountPaid());
    return localBigDecimal.compareTo(new BigDecimal(0)) > 0 ? localBigDecimal : new BigDecimal(0);
  }

  @Transient
  public boolean isExpired()
  {
    return (getExpire() != null) && (new Date().after(getExpire()));
  }

  @Transient
  public OrderItem getOrderItem(String sn)
  {
    if ((sn != null) && (getOrderItems() != null))
    {
      Iterator localIterator = getOrderItems().iterator();
      while (localIterator.hasNext())
      {
        OrderItem localOrderItem = (OrderItem)localIterator.next();
        if ((localOrderItem != null) && (sn.equalsIgnoreCase(localOrderItem.getSn())))
          return localOrderItem;
      }
    }
    return null;
  }

  @Transient
  public boolean isLocked(Admin operator)
  {
    return (getLockExpire() != null) && (new Date().before(getLockExpire())) && (getOperator() != operator);
  }

  @Transient
  public BigDecimal calculateTax()
  {
    Setting localSetting = SettingUtils.get();
    BigDecimal localBigDecimal;
    if (localSetting.getIsTaxPriceEnabled().booleanValue())
      localBigDecimal = getPrice().subtract(getDiscount()).multiply(new BigDecimal(localSetting.getTaxRate().toString()));
    else
      localBigDecimal = new BigDecimal(0);
    return localSetting.setScale(localBigDecimal);
  }

  @PrePersist
  public void prePersist()
  {
    if (getArea() != null)
      setAreaName(getArea().getFullName());
    if (getPaymentMethod() != null)
      setPaymentMethodName(getPaymentMethod().getName());
    if (getShippingMethod() != null)
      setShippingMethodName(getShippingMethod().getName());
  }

  @PreUpdate
  public void preUpdate()
  {
    if (getArea() != null)
      setAreaName(getArea().getFullName());
    if (getPaymentMethod() != null)
      setPaymentMethodName(getPaymentMethod().getName());
    if (getShippingMethod() != null)
      setShippingMethodName(getShippingMethod().getName());
  }

  @PreRemove
  public void preRemove()
  {
    Set localSet = getDeposits();
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        Deposit localDeposit = (Deposit)localIterator.next();
        localDeposit.setOrder(null);
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Order
 * JD-Core Version:    0.6.2
 */