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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import net.shopxx.Setting;
import net.shopxx.util.SettingUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_coupon")
public class Coupon extends BaseEntity
{
  private static final long serialVersionUID = -7907808728349149722L;
  private String IIIllIlI;
  private String IIIllIll;
  private Date IIIlllII;
  private Date IIIlllIl;
  private BigDecimal IIIllllI;
  private BigDecimal IIIlllll;
  private Boolean IIlIIIII;
  private Boolean IIlIIIIl;
  private Integer IIlIIIlI;
  private Coupon.Operator IIlIIIll;
  private BigDecimal IIlIIlII;
  private String IIlIIlIl;
  private Set<CouponCode> IIlIIllI = new HashSet();
  private Set<Promotion> IIlIIlll = new HashSet();
  private List<Order> IIlIlIII = new ArrayList();

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getName()
  {
    return this.IIIllIlI;
  }

  public void setName(String name)
  {
    this.IIIllIlI = name;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getPrefix()
  {
    return this.IIIllIll;
  }

  public void setPrefix(String prefix)
  {
    this.IIIllIll = prefix;
  }

  public Date getBeginDate()
  {
    return this.IIIlllII;
  }

  public void setBeginDate(Date beginDate)
  {
    this.IIIlllII = beginDate;
  }

  public Date getEndDate()
  {
    return this.IIIlllIl;
  }

  public void setEndDate(Date endDate)
  {
    this.IIIlllIl = endDate;
  }

  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(precision=21, scale=6)
  public BigDecimal getStartPrice()
  {
    return this.IIIllllI;
  }

  public void setStartPrice(BigDecimal startPrice)
  {
    this.IIIllllI = startPrice;
  }

  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(precision=21, scale=6)
  public BigDecimal getEndPrice()
  {
    return this.IIIlllll;
  }

  public void setEndPrice(BigDecimal endPrice)
  {
    this.IIIlllll = endPrice;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsEnabled()
  {
    return this.IIlIIIII;
  }

  public void setIsEnabled(Boolean isEnabled)
  {
    this.IIlIIIII = isEnabled;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsExchange()
  {
    return this.IIlIIIIl;
  }

  public void setIsExchange(Boolean isExchange)
  {
    this.IIlIIIIl = isExchange;
  }

  @Min(0L)
  public Integer getPoint()
  {
    return this.IIlIIIlI;
  }

  public void setPoint(Integer point)
  {
    this.IIlIIIlI = point;
  }

  @NotNull
  @Column(nullable=false)
  public Coupon.Operator getPriceOperator()
  {
    return this.IIlIIIll;
  }

  public void setPriceOperator(Coupon.Operator priceOperator)
  {
    this.IIlIIIll = priceOperator;
  }

  @Digits(integer=12, fraction=3)
  @Column(precision=21, scale=6)
  public BigDecimal getPriceValue()
  {
    return this.IIlIIlII;
  }

  public void setPriceValue(BigDecimal priceValue)
  {
    this.IIlIIlII = priceValue;
  }

  @Lob
  public String getIntroduction()
  {
    return this.IIlIIlIl;
  }

  public void setIntroduction(String introduction)
  {
    this.IIlIIlIl = introduction;
  }

  @OneToMany(mappedBy="coupon", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<CouponCode> getCouponCodes()
  {
    return this.IIlIIllI;
  }

  public void setCouponCodes(Set<CouponCode> couponCodes)
  {
    this.IIlIIllI = couponCodes;
  }

  @ManyToMany(mappedBy="coupons", fetch=FetchType.LAZY)
  public Set<Promotion> getPromotions()
  {
    return this.IIlIIlll;
  }

  public void setPromotions(Set<Promotion> promotions)
  {
    this.IIlIIlll = promotions;
  }

  @ManyToMany(mappedBy="coupons", fetch=FetchType.LAZY)
  public List<Order> getOrders()
  {
    return this.IIlIlIII;
  }

  public void setOrders(List<Order> orders)
  {
    this.IIlIlIII = orders;
  }

  @Transient
  public boolean hasBegun()
  {
    return (getBeginDate() == null) || (new Date().after(getBeginDate()));
  }

  @Transient
  public boolean hasExpired()
  {
    return (getEndDate() != null) && (new Date().after(getEndDate()));
  }

  @Transient
  public BigDecimal calculatePrice(BigDecimal price)
  {
    if ((price != null) && (getPriceOperator() != null) && (getPriceValue() != null))
    {
      Setting localSetting = SettingUtils.get();
      if (getPriceOperator() == Coupon.Operator.add)
        localBigDecimal = price.add(getPriceValue());
      else if (getPriceOperator() == Coupon.Operator.subtract)
        localBigDecimal = price.subtract(getPriceValue());
      else if (getPriceOperator() == Coupon.Operator.multiply)
        localBigDecimal = price.multiply(getPriceValue());
      else
        localBigDecimal = price.divide(getPriceValue());
      BigDecimal localBigDecimal = localSetting.setScale(localBigDecimal);
      return localBigDecimal.compareTo(new BigDecimal(0)) > 0 ? localBigDecimal : new BigDecimal(0);
    }
    return price;
  }

  @PreRemove
  public void preRemove()
  {
    Set localSet = getPromotions();
    Object localObject2;
    if (localSet != null)
    {
      localObject2 = localSet.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Promotion)((Iterator)localObject2).next();
        ((Promotion)localObject1).getCoupons().remove(this);
      }
    }
    Object localObject1 = getOrders();
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Order)localIterator.next();
        ((Order)localObject2).getCoupons().remove(this);
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Coupon
 * JD-Core Version:    0.6.2
 */