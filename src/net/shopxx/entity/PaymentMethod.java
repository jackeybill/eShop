package net.shopxx.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_payment_method")
public class PaymentMethod extends OrderEntity
{
  private static final long serialVersionUID = 6949816500116581199L;
  private String IIIllIlI;
  private PaymentMethod.Type IIIllIll;
  private Integer IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;
  private String IIIlllll;
  private Set<ShippingMethod> IIlIIIII = new HashSet();
  private Set<Order> IIlIIIIl = new HashSet();

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

  @NotNull
  @Column(nullable=false)
  public PaymentMethod.Type getType()
  {
    return this.IIIllIll;
  }

  public void setType(PaymentMethod.Type type)
  {
    this.IIIllIll = type;
  }

  @Min(1L)
  public Integer getTimeout()
  {
    return this.IIIlllII;
  }

  public void setTimeout(Integer timeout)
  {
    this.IIIlllII = timeout;
  }

  @Length(max=200)
  public String getIcon()
  {
    return this.IIIlllIl;
  }

  public void setIcon(String icon)
  {
    this.IIIlllIl = icon;
  }

  @Length(max=200)
  public String getDescription()
  {
    return this.IIIllllI;
  }

  public void setDescription(String description)
  {
    this.IIIllllI = description;
  }

  @Lob
  public String getContent()
  {
    return this.IIIlllll;
  }

  public void setContent(String content)
  {
    this.IIIlllll = content;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_payment_shipping_method")
  @OrderBy("order asc")
  public Set<ShippingMethod> getShippingMethods()
  {
    return this.IIlIIIII;
  }

  public void setShippingMethods(Set<ShippingMethod> shippingMethods)
  {
    this.IIlIIIII = shippingMethods;
  }

  @OneToMany(mappedBy="paymentMethod", fetch=FetchType.LAZY)
  public Set<Order> getOrders()
  {
    return this.IIlIIIIl;
  }

  public void setOrders(Set<Order> orders)
  {
    this.IIlIIIIl = orders;
  }

  @PreRemove
  public void preRemove()
  {
    Set localSet = getOrders();
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        Order localOrder = (Order)localIterator.next();
        localOrder.setPaymentMethod(null);
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.PaymentMethod
 * JD-Core Version:    0.6.2
 */