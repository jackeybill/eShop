package net.shopxx.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="xx_goods")
public class Goods extends BaseEntity
{
  private static final long serialVersionUID = -6977025562650112419L;
  private Set<Product> IIIllIlI = new HashSet();

  @OneToMany(mappedBy="goods", fetch=FetchType.EAGER, cascade={javax.persistence.CascadeType.ALL}, orphanRemoval=true)
  public Set<Product> getProducts()
  {
    return this.IIIllIlI;
  }

  public void setProducts(Set<Product> products)
  {
    this.IIIllIlI = products;
  }

  @Transient
  public Set<SpecificationValue> getSpecificationValues()
  {
    HashSet localHashSet = new HashSet();
    if (getProducts() != null)
    {
      Iterator localIterator = getProducts().iterator();
      while (localIterator.hasNext())
      {
        Product localProduct = (Product)localIterator.next();
        localHashSet.addAll(localProduct.getSpecificationValues());
      }
    }
    return localHashSet;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Goods
 * JD-Core Version:    0.6.2
 */