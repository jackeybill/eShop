package net.shopxx.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_delivery_corp")
public class DeliveryCorp extends OrderEntity
{
  private static final long serialVersionUID = 10595703086045998L;
  private String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private Set<ShippingMethod> IIIlllIl = new HashSet();

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

  @Length(max=200)
  public String getUrl()
  {
    return this.IIIllIll;
  }

  public void setUrl(String url)
  {
    this.IIIllIll = url;
  }

  @Length(max=200)
  public String getCode()
  {
    return this.IIIlllII;
  }

  public void setCode(String code)
  {
    this.IIIlllII = code;
  }

  @OneToMany(mappedBy="defaultDeliveryCorp", fetch=FetchType.LAZY)
  public Set<ShippingMethod> getShippingMethods()
  {
    return this.IIIlllIl;
  }

  public void setShippingMethods(Set<ShippingMethod> shippingMethods)
  {
    this.IIIlllIl = shippingMethods;
  }

  @PreRemove
  public void preRemove()
  {
    Set localSet = getShippingMethods();
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        ShippingMethod localShippingMethod = (ShippingMethod)localIterator.next();
        localShippingMethod.setDefaultDeliveryCorp(null);
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.DeliveryCorp
 * JD-Core Version:    0.6.2
 */