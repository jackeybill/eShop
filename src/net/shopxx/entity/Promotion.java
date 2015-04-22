package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_promotion")
public class Promotion extends OrderEntity
{
  private static final long serialVersionUID = 3536993535267962279L;
  private static final String IIIllIlI = "/promotion/content";
  private static final String IIIllIll = ".jhtml";
  private String IIIlllII;
  private String IIIlllIl;
  private Date IIIllllI;
  private Date IIIlllll;
  private BigDecimal IIlIIIII;
  private BigDecimal IIlIIIIl;
  private Promotion.Operator IIlIIIlI;
  private BigDecimal IIlIIIll;
  private Promotion.Operator IIlIIlII;
  private BigDecimal IIlIIlIl;
  private Boolean IIlIIllI;
  private Boolean IIlIIlll;
  private String IIlIlIII;
  private Set<MemberRank> IIlIlIIl = new HashSet();
  private Set<ProductCategory> IIlIlIlI = new HashSet();
  private Set<Product> IIlIlIll = new HashSet();
  private Set<Brand> IIlIllII = new HashSet();
  private Set<Coupon> IIlIllIl = new HashSet();
  private List<GiftItem> IIlIlllI = new ArrayList();

  @JsonProperty
  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getName()
  {
    return this.IIIlllII;
  }

  public void setName(String name)
  {
    this.IIIlllII = name;
  }

  @JsonProperty
  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getTitle()
  {
    return this.IIIlllIl;
  }

  public void setTitle(String title)
  {
    this.IIIlllIl = title;
  }

  @JsonProperty
  public Date getBeginDate()
  {
    return this.IIIllllI;
  }

  public void setBeginDate(Date beginDate)
  {
    this.IIIllllI = beginDate;
  }

  @JsonProperty
  public Date getEndDate()
  {
    return this.IIIlllll;
  }

  public void setEndDate(Date endDate)
  {
    this.IIIlllll = endDate;
  }

  @JsonProperty
  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(precision=21, scale=6)
  public BigDecimal getStartPrice()
  {
    return this.IIlIIIII;
  }

  public void setStartPrice(BigDecimal startPrice)
  {
    this.IIlIIIII = startPrice;
  }

  @JsonProperty
  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(precision=21, scale=6)
  public BigDecimal getEndPrice()
  {
    return this.IIlIIIIl;
  }

  public void setEndPrice(BigDecimal endPrice)
  {
    this.IIlIIIIl = endPrice;
  }

  @NotNull
  @Column(nullable=false)
  public Promotion.Operator getPriceOperator()
  {
    return this.IIlIIIlI;
  }

  public void setPriceOperator(Promotion.Operator priceOperator)
  {
    this.IIlIIIlI = priceOperator;
  }

  @Digits(integer=12, fraction=3)
  @Column(precision=21, scale=6)
  public BigDecimal getPriceValue()
  {
    return this.IIlIIIll;
  }

  public void setPriceValue(BigDecimal priceValue)
  {
    this.IIlIIIll = priceValue;
  }

  @NotNull
  @Column(nullable=false)
  public Promotion.Operator getPointOperator()
  {
    return this.IIlIIlII;
  }

  public void setPointOperator(Promotion.Operator pointOperator)
  {
    this.IIlIIlII = pointOperator;
  }

  public BigDecimal getPointValue()
  {
    return this.IIlIIlIl;
  }

  public void setPointValue(BigDecimal pointValue)
  {
    this.IIlIIlIl = pointValue;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsFreeShipping()
  {
    return this.IIlIIllI;
  }

  public void setIsFreeShipping(Boolean isFreeShipping)
  {
    this.IIlIIllI = isFreeShipping;
  }

  @JsonProperty
  @NotNull
  @Column(nullable=false)
  public Boolean getIsCouponAllowed()
  {
    return this.IIlIIlll;
  }

  public void setIsCouponAllowed(Boolean isCouponAllowed)
  {
    this.IIlIIlll = isCouponAllowed;
  }

  @Lob
  public String getIntroduction()
  {
    return this.IIlIlIII;
  }

  public void setIntroduction(String introduction)
  {
    this.IIlIlIII = introduction;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_promotion_member_rank")
  public Set<MemberRank> getMemberRanks()
  {
    return this.IIlIlIIl;
  }

  public void setMemberRanks(Set<MemberRank> memberRanks)
  {
    this.IIlIlIIl = memberRanks;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_promotion_product_category")
  public Set<ProductCategory> getProductCategories()
  {
    return this.IIlIlIlI;
  }

  public void setProductCategories(Set<ProductCategory> productCategories)
  {
    this.IIlIlIlI = productCategories;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_promotion_product")
  public Set<Product> getProducts()
  {
    return this.IIlIlIll;
  }

  public void setProducts(Set<Product> products)
  {
    this.IIlIlIll = products;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_promotion_brand")
  public Set<Brand> getBrands()
  {
    return this.IIlIllII;
  }

  public void setBrands(Set<Brand> brands)
  {
    this.IIlIllII = brands;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_promotion_coupon")
  public Set<Coupon> getCoupons()
  {
    return this.IIlIllIl;
  }

  public void setCoupons(Set<Coupon> coupons)
  {
    this.IIlIllIl = coupons;
  }

  @Valid
  @OneToMany(mappedBy="promotion", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL}, orphanRemoval=true)
  public List<GiftItem> getGiftItems()
  {
    return this.IIlIlllI;
  }

  public void setGiftItems(List<GiftItem> giftItems)
  {
    this.IIlIlllI = giftItems;
  }

  @Transient
  public boolean hasBegun()
  {
    return (getBeginDate() == null) || (new Date().after(getBeginDate()));
  }

  @Transient
  public boolean hasEnded()
  {
    return (getEndDate() != null) && (new Date().after(getEndDate()));
  }

  @Transient
  public String getPath()
  {
    if (getId() != null)
      return "/promotion/content/" + getId() + ".jhtml";
    return null;
  }

  @Transient
  public BigDecimal calculatePrice(BigDecimal price)
  {
    if ((price != null) && (getPriceOperator() != null) && (getPriceValue() != null))
    {
      BigDecimal localBigDecimal;
      if (getPriceOperator() == Promotion.Operator.add)
        localBigDecimal = price.add(getPriceValue());
      else if (getPriceOperator() == Promotion.Operator.subtract)
        localBigDecimal = price.subtract(getPriceValue());
      else if (getPriceOperator() == Promotion.Operator.multiply)
        localBigDecimal = price.multiply(getPriceValue());
      else
        localBigDecimal = price.divide(getPriceValue());
      return localBigDecimal.compareTo(new BigDecimal(0)) > 0 ? localBigDecimal : new BigDecimal(0);
    }
    return price;
  }

  @Transient
  public Integer calculatePoint(Integer point)
  {
    if ((point != null) && (getPointOperator() != null) && (getPointValue() != null))
    {
      BigDecimal localBigDecimal;
      if (getPointOperator() == Promotion.Operator.add)
        localBigDecimal = new BigDecimal(point.intValue()).add(getPointValue());
      else if (getPointOperator() == Promotion.Operator.subtract)
        localBigDecimal = new BigDecimal(point.intValue()).subtract(getPointValue());
      else if (getPointOperator() == Promotion.Operator.multiply)
        localBigDecimal = new BigDecimal(point.intValue()).multiply(getPointValue());
      else
        localBigDecimal = new BigDecimal(point.intValue()).divide(getPointValue());
      return Integer.valueOf(localBigDecimal.compareTo(new BigDecimal(0)) > 0 ? localBigDecimal.intValue() : 0);
    }
    return point;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Promotion
 * JD-Core Version:    0.6.2
 */