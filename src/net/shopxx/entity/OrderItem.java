package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_order_item")
public class OrderItem extends BaseEntity
{
  private static final long serialVersionUID = -4999926022604479334L;
  private String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private BigDecimal IIIlllIl;
  private Integer IIIllllI;
  private String IIIlllll;
  private Boolean IIlIIIII;
  private Integer IIlIIIIl;
  private Integer IIlIIIlI;
  private Integer IIlIIIll;
  private Product IIlIIlII;
  private Order IIlIIlIl;

  @JsonProperty
  @NotEmpty
  @Column(nullable=false, updatable=false)
  public String getSn()
  {
    return this.IIIllIlI;
  }

  public void setSn(String sn)
  {
    this.IIIllIlI = sn;
  }

  @JsonProperty
  @Column(nullable=false, updatable=false)
  public String getName()
  {
    return this.IIIllIll;
  }

  public void setName(String name)
  {
    this.IIIllIll = name;
  }

  @JsonProperty
  @Column(nullable=false, updatable=false)
  public String getFullName()
  {
    return this.IIIlllII;
  }

  public void setFullName(String fullName)
  {
    this.IIIlllII = fullName;
  }

  @JsonProperty
  @NotNull
  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(nullable=false, precision=21, scale=6)
  public BigDecimal getPrice()
  {
    return this.IIIlllIl;
  }

  public void setPrice(BigDecimal price)
  {
    this.IIIlllIl = price;
  }

  @JsonProperty
  @Column(updatable=false)
  public Integer getWeight()
  {
    return this.IIIllllI;
  }

  public void setWeight(Integer weight)
  {
    this.IIIllllI = weight;
  }

  @JsonProperty
  @Column(updatable=false)
  public String getThumbnail()
  {
    return this.IIIlllll;
  }

  public void setThumbnail(String thumbnail)
  {
    this.IIIlllll = thumbnail;
  }

  @JsonProperty
  @Column(nullable=false, updatable=false)
  public Boolean getIsGift()
  {
    return this.IIlIIIII;
  }

  public void setIsGift(Boolean isGift)
  {
    this.IIlIIIII = isGift;
  }

  @JsonProperty
  @NotNull
  @Min(1L)
  @Max(10000L)
  @Column(nullable=false)
  public Integer getQuantity()
  {
    return this.IIlIIIIl;
  }

  public void setQuantity(Integer quantity)
  {
    this.IIlIIIIl = quantity;
  }

  @Column(nullable=false)
  public Integer getShippedQuantity()
  {
    return this.IIlIIIlI;
  }

  public void setShippedQuantity(Integer shippedQuantity)
  {
    this.IIlIIIlI = shippedQuantity;
  }

  @Column(nullable=false)
  public Integer getReturnQuantity()
  {
    return this.IIlIIIll;
  }

  public void setReturnQuantity(Integer returnQuantity)
  {
    this.IIlIIIll = returnQuantity;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  public Product getProduct()
  {
    return this.IIlIIlII;
  }

  public void setProduct(Product product)
  {
    this.IIlIIlII = product;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="orders", nullable=false, updatable=false)
  public Order getOrder()
  {
    return this.IIlIIlIl;
  }

  public void setOrder(Order order)
  {
    this.IIlIIlIl = order;
  }

  @JsonProperty
  @Transient
  public int getTotalWeight()
  {
    if ((getWeight() != null) && (getQuantity() != null))
      return getWeight().intValue() * getQuantity().intValue();
    return 0;
  }

  @JsonProperty
  @Transient
  public BigDecimal getSubtotal()
  {
    if ((getPrice() != null) && (getQuantity() != null))
      return getPrice().multiply(new BigDecimal(getQuantity().intValue()));
    return new BigDecimal(0);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.OrderItem
 * JD-Core Version:    0.6.2
 */