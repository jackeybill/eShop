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
@Table(name="xx_returns")
public class Returns extends BaseEntity
{
  private static final long serialVersionUID = -8019074120457087212L;
  private String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private BigDecimal IIIllllI;
  private String IIIlllll;
  private String IIlIIIII;
  private String IIlIIIIl;
  private String IIlIIIlI;
  private String IIlIIIll;
  private String IIlIIlII;
  private String IIlIIlIl;
  private Order IIlIIllI;
  private List<ReturnsItem> IIlIIlll = new ArrayList();

  @Column(nullable=false, updatable=false, unique=true)
  public String getSn()
  {
    return this.IIIllIlI;
  }

  public void setSn(String sn)
  {
    this.IIIllIlI = sn;
  }

  @Column(updatable=false)
  public String getShippingMethod()
  {
    return this.IIIllIll;
  }

  public void setShippingMethod(String shippingMethod)
  {
    this.IIIllIll = shippingMethod;
  }

  @Column(updatable=false)
  public String getDeliveryCorp()
  {
    return this.IIIlllII;
  }

  public void setDeliveryCorp(String deliveryCorp)
  {
    this.IIIlllII = deliveryCorp;
  }

  @Length(max=200)
  @Column(updatable=false)
  public String getTrackingNo()
  {
    return this.IIIlllIl;
  }

  public void setTrackingNo(String trackingNo)
  {
    this.IIIlllIl = trackingNo;
  }

  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(updatable=false, precision=21, scale=6)
  public BigDecimal getFreight()
  {
    return this.IIIllllI;
  }

  public void setFreight(BigDecimal freight)
  {
    this.IIIllllI = freight;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false, updatable=false)
  public String getShipper()
  {
    return this.IIIlllll;
  }

  public void setShipper(String shipper)
  {
    this.IIIlllll = shipper;
  }

  @NotEmpty
  @Column(nullable=false, updatable=false)
  public String getArea()
  {
    return this.IIlIIIII;
  }

  public void setArea(String area)
  {
    this.IIlIIIII = area;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false, updatable=false)
  public String getAddress()
  {
    return this.IIlIIIIl;
  }

  public void setAddress(String address)
  {
    this.IIlIIIIl = address;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false, updatable=false)
  public String getZipCode()
  {
    return this.IIlIIIlI;
  }

  public void setZipCode(String zipCode)
  {
    this.IIlIIIlI = zipCode;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false, updatable=false)
  public String getPhone()
  {
    return this.IIlIIIll;
  }

  public void setPhone(String phone)
  {
    this.IIlIIIll = phone;
  }

  @Column(nullable=false, updatable=false)
  public String getOperator()
  {
    return this.IIlIIlII;
  }

  public void setOperator(String operator)
  {
    this.IIlIIlII = operator;
  }

  @Length(max=200)
  @Column(updatable=false)
  public String getMemo()
  {
    return this.IIlIIlIl;
  }

  public void setMemo(String memo)
  {
    this.IIlIIlIl = memo;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="orders", nullable=false, updatable=false)
  public Order getOrder()
  {
    return this.IIlIIllI;
  }

  public void setOrder(Order order)
  {
    this.IIlIIllI = order;
  }

  @Valid
  @NotEmpty
  @OneToMany(mappedBy="returns", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
  public List<ReturnsItem> getReturnsItems()
  {
    return this.IIlIIlll;
  }

  public void setReturnsItems(List<ReturnsItem> returnsItems)
  {
    this.IIlIIlll = returnsItems;
  }

  @Transient
  public int getQuantity()
  {
    int i = 0;
    if (getReturnsItems() != null)
    {
      Iterator localIterator = getReturnsItems().iterator();
      while (localIterator.hasNext())
      {
        ReturnsItem localReturnsItem = (ReturnsItem)localIterator.next();
        if ((localReturnsItem != null) && (localReturnsItem.getQuantity() != null))
          i += localReturnsItem.getQuantity().intValue();
      }
    }
    return i;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Returns
 * JD-Core Version:    0.6.2
 */