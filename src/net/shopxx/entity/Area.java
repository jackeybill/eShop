package net.shopxx.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_area")
public class Area extends OrderEntity
{
  private static final long serialVersionUID = -2158109459123036967L;
  private static final String IIIllIlI = ",";
  private String IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private Area IIIllllI;
  private Set<Area> IIIlllll = new HashSet();
  private Set<Member> IIlIIIII = new HashSet();
  private Set<Receiver> IIlIIIIl = new HashSet();
  private Set<Order> IIlIIIlI = new HashSet();
  private Set<DeliveryCenter> IIlIIIll = new HashSet();

  @NotEmpty
  @Length(max=100)
  @Column(nullable=false, length=100)
  public String getName()
  {
    return this.IIIllIll;
  }

  public void setName(String name)
  {
    this.IIIllIll = name;
  }

  @Column(nullable=false, length=500)
  public String getFullName()
  {
    return this.IIIlllII;
  }

  public void setFullName(String fullName)
  {
    this.IIIlllII = fullName;
  }

  @Column(nullable=false, updatable=false)
  public String getTreePath()
  {
    return this.IIIlllIl;
  }

  public void setTreePath(String treePath)
  {
    this.IIIlllIl = treePath;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  public Area getParent()
  {
    return this.IIIllllI;
  }

  public void setParent(Area parent)
  {
    this.IIIllllI = parent;
  }

  @OneToMany(mappedBy="parent", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("order asc")
  public Set<Area> getChildren()
  {
    return this.IIIlllll;
  }

  public void setChildren(Set<Area> children)
  {
    this.IIIlllll = children;
  }

  @OneToMany(mappedBy="area", fetch=FetchType.LAZY)
  public Set<Member> getMembers()
  {
    return this.IIlIIIII;
  }

  public void setMembers(Set<Member> members)
  {
    this.IIlIIIII = members;
  }

  @OneToMany(mappedBy="area", fetch=FetchType.LAZY)
  public Set<Receiver> getReceivers()
  {
    return this.IIlIIIIl;
  }

  public void setReceivers(Set<Receiver> receivers)
  {
    this.IIlIIIIl = receivers;
  }

  @OneToMany(mappedBy="area", fetch=FetchType.LAZY)
  public Set<Order> getOrders()
  {
    return this.IIlIIIlI;
  }

  public void setOrders(Set<Order> orders)
  {
    this.IIlIIIlI = orders;
  }

  @OneToMany(mappedBy="area", fetch=FetchType.LAZY)
  public Set<DeliveryCenter> getDeliveryCenters()
  {
    return this.IIlIIIll;
  }

  public void setDeliveryCenters(Set<DeliveryCenter> deliveryCenters)
  {
    this.IIlIIIll = deliveryCenters;
  }

  @PrePersist
  public void prePersist()
  {
    Area localArea = getParent();
    if (localArea != null)
    {
      setFullName(localArea.getFullName() + getName());
      setTreePath(localArea.getTreePath() + localArea.getId() + ",");
    }
    else
    {
      setFullName(getName());
      setTreePath(",");
    }
  }

  @PreUpdate
  public void preUpdate()
  {
    Area localArea = getParent();
    if (localArea != null)
      setFullName(localArea.getFullName() + getName());
    else
      setFullName(getName());
  }

  @PreRemove
  public void preRemove()
  {
    Set localSet = getMembers();
    if (localSet != null)
    {
      localObject2 = localSet.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Member)((Iterator)localObject2).next();
        ((Member)localObject1).setArea(null);
      }
    }
    Object localObject1 = getReceivers();
    if (localObject1 != null)
    {
      localObject3 = ((Set)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Receiver)((Iterator)localObject3).next();
        ((Receiver)localObject2).setArea(null);
      }
    }
    Object localObject2 = getOrders();
    Object localObject4;
    if (localObject2 != null)
    {
      localObject4 = ((Set)localObject2).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject3 = (Order)((Iterator)localObject4).next();
        ((Order)localObject3).setArea(null);
      }
    }
    Object localObject3 = getDeliveryCenters();
    if (localObject3 != null)
    {
      Iterator localIterator = ((Set)localObject3).iterator();
      while (localIterator.hasNext())
      {
        localObject4 = (DeliveryCenter)localIterator.next();
        ((DeliveryCenter)localObject4).setArea(null);
      }
    }
  }

  public String toString()
  {
    return getFullName();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Area
 * JD-Core Version:    0.6.2
 */