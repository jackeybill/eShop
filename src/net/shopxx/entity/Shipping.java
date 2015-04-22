package net.shopxx.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="xx_shipping")
public class Shipping extends BaseEntity
{
  private static final long serialVersionUID = -261737051893669935L;
  private String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;
  private String IIIlllll;
  private BigDecimal IIlIIIII;
  private String IIlIIIIl;
  private String IIlIIIlI;
  private String IIlIIIll;
  private String IIlIIlII;
  private String IIlIIlIl;
  private String IIlIIllI;
  private String IIlIIlll;
  private Order IIlIlIII;
  private List<ShippingItem> IIlIlIIl = new ArrayList();

  @Column(nullable=false, updatable=false, unique=true)
  public String getSn()
  {
    return this.IIIllIlI;
  }

  public void setSn(String sn)
  {
    this.IIIllIlI = sn;
  }

  @NotEmpty
  @Column(nullable=false, updatable=false)
  public String getShippingMethod()
  {
    return this.IIIllIll;
  }

  public void setShippingMethod(String shippingMethod)
  {
    this.IIIllIll = shippingMethod;
  }

  @NotEmpty
  @Column(nullable=false, updatable=false)
  public String getDeliveryCorp()
  {
    return this.IIIlllII;
  }

  public void setDeliveryCorp(String deliveryCorp)
  {
    this.IIIlllII = deliveryCorp;
  }

  public String getDeliveryCorpUrl()
  {
    return this.IIIlllIl;
  }

  @Column(updatable=false)
  public void setDeliveryCorpUrl(String deliveryCorpUrl)
  {
    this.IIIlllIl = deliveryCorpUrl;
  }

  public String getDeliveryCorpCode()
  {
    return this.IIIllllI;
  }

  @Column(updatable=false)
  public void setDeliveryCorpCode(String deliveryCorpCode)
  {
    this.IIIllllI = deliveryCorpCode;
  }

  @Length(max=200)
  @Column(updatable=false)
  public String getTrackingNo()
  {
    return this.IIIlllll;
  }

  public void setTrackingNo(String trackingNo)
  {
    this.IIIlllll = trackingNo;
  }

  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(updatable=false, precision=21, scale=6)
  public BigDecimal getFreight()
  {
    return this.IIlIIIII;
  }

  public void setFreight(BigDecimal freight)
  {
    this.IIlIIIII = freight;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false, updatable=false)
  public String getConsignee()
  {
    return this.IIlIIIIl;
  }

  public void setConsignee(String consignee)
  {
    this.IIlIIIIl = consignee;
  }

  @NotEmpty
  @Column(nullable=false, updatable=false)
  public String getArea()
  {
    return this.IIlIIIlI;
  }

  public void setArea(String area)
  {
    this.IIlIIIlI = area;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false, updatable=false)
  public String getAddress()
  {
    return this.IIlIIIll;
  }

  public void setAddress(String address)
  {
    this.IIlIIIll = address;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false, updatable=false)
  public String getZipCode()
  {
    return this.IIlIIlII;
  }

  public void setZipCode(String zipCode)
  {
    this.IIlIIlII = zipCode;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false, updatable=false)
  public String getPhone()
  {
    return this.IIlIIlIl;
  }

  public void setPhone(String phone)
  {
    this.IIlIIlIl = phone;
  }

  @Column(nullable=false, updatable=false)
  public String getOperator()
  {
    return this.IIlIIllI;
  }

  public void setOperator(String operator)
  {
    this.IIlIIllI = operator;
  }

  @Length(max=200)
  @Column(updatable=false)
  public String getMemo()
  {
    return this.IIlIIlll;
  }

  public void setMemo(String memo)
  {
    this.IIlIIlll = memo;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="orders", nullable=false, updatable=false)
  public Order getOrder()
  {
    return this.IIlIlIII;
  }

  public void setOrder(Order order)
  {
    this.IIlIlIII = order;
  }

  @Valid
  @NotEmpty
  @OneToMany(mappedBy="shipping", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
  public List<ShippingItem> getShippingItems()
  {
    return this.IIlIlIIl;
  }

  public void setShippingItems(List<ShippingItem> shippingItems)
  {
    this.IIlIlIIl = shippingItems;
  }

  @Transient
  public int getQuantity()
  {
    int i = 0;
    if (getShippingItems() != null)
    {
      Iterator localIterator = getShippingItems().iterator();
      while (localIterator.hasNext())
      {
        ShippingItem localShippingItem = (ShippingItem)localIterator.next();
        if ((localShippingItem != null) && (localShippingItem.getQuantity() != null))
          i += localShippingItem.getQuantity().intValue();
      }
    }
    return i;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Shipping
 * JD-Core Version:    0.6.2
 */