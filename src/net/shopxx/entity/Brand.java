package net.shopxx.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_brand")
public class Brand extends OrderEntity
{
  private static final long serialVersionUID = -6109590619136943215L;
  private static final String IIIllIlI = "/brand/content";
  private static final String IIIllIll = ".jhtml";
  private String IIIlllII;
  private Brand.Type IIIlllIl;
  private String IIIllllI;
  private String IIIlllll;
  private String IIlIIIII;
  private Set<Product> IIlIIIIl = new HashSet();
  private Set<ProductCategory> IIlIIIlI = new HashSet();
  private Set<Promotion> IIlIIIll = new HashSet();

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

  @NotNull
  @Column(nullable=false)
  public Brand.Type getType()
  {
    return this.IIIlllIl;
  }

  public void setType(Brand.Type type)
  {
    this.IIIlllIl = type;
  }

  @Length(max=200)
  public String getLogo()
  {
    return this.IIIllllI;
  }

  public void setLogo(String logo)
  {
    this.IIIllllI = logo;
  }

  @Length(max=200)
  public String getUrl()
  {
    return this.IIIlllll;
  }

  public void setUrl(String url)
  {
    this.IIIlllll = url;
  }

  @Lob
  public String getIntroduction()
  {
    return this.IIlIIIII;
  }

  public void setIntroduction(String introduction)
  {
    this.IIlIIIII = introduction;
  }

  @OneToMany(mappedBy="brand", fetch=FetchType.LAZY)
  public Set<Product> getProducts()
  {
    return this.IIlIIIIl;
  }

  public void setProducts(Set<Product> products)
  {
    this.IIlIIIIl = products;
  }

  @ManyToMany(mappedBy="brands", fetch=FetchType.LAZY)
  @OrderBy("order asc")
  public Set<ProductCategory> getProductCategories()
  {
    return this.IIlIIIlI;
  }

  public void setProductCategories(Set<ProductCategory> productCategories)
  {
    this.IIlIIIlI = productCategories;
  }

  @ManyToMany(mappedBy="brands", fetch=FetchType.LAZY)
  public Set<Promotion> getPromotions()
  {
    return this.IIlIIIll;
  }

  public void setPromotions(Set<Promotion> promotions)
  {
    this.IIlIIIll = promotions;
  }

  @Transient
  public String getPath()
  {
    if (getId() != null)
      return "/brand/content/" + getId() + ".jhtml";
    return null;
  }

  @PreRemove
  public void preRemove()
  {
    Set localSet = getProducts();
    if (localSet != null)
    {
      localObject2 = localSet.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Product)((Iterator)localObject2).next();
        ((Product)localObject1).setBrand(null);
      }
    }
    Object localObject1 = getProductCategories();
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((Set)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (ProductCategory)((Iterator)localObject3).next();
        ((ProductCategory)localObject2).getBrands().remove(this);
      }
    }
    Object localObject2 = getPromotions();
    if (localObject2 != null)
    {
      Iterator localIterator = ((Set)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (Promotion)localIterator.next();
        ((Promotion)localObject3).getBrands().remove(this);
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Brand
 * JD-Core Version:    0.6.2
 */