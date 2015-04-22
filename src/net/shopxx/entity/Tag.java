package net.shopxx.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_tag")
public class Tag extends OrderEntity
{
  private static final long serialVersionUID = -2735037966597250149L;
  private String IIIllIlI;
  private Tag.Type IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private Set<Article> IIIllllI = new HashSet();
  private Set<Product> IIIlllll = new HashSet();

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

  @NotNull(groups={BaseEntity.Save.class})
  @Column(nullable=false, updatable=false)
  public Tag.Type getType()
  {
    return this.IIIllIll;
  }

  public void setType(Tag.Type type)
  {
    this.IIIllIll = type;
  }

  @Length(max=200)
  public String getIcon()
  {
    return this.IIIlllII;
  }

  public void setIcon(String icon)
  {
    this.IIIlllII = icon;
  }

  @Length(max=200)
  public String getMemo()
  {
    return this.IIIlllIl;
  }

  public void setMemo(String memo)
  {
    this.IIIlllIl = memo;
  }

  @ManyToMany(mappedBy="tags", fetch=FetchType.LAZY)
  public Set<Article> getArticles()
  {
    return this.IIIllllI;
  }

  public void setArticles(Set<Article> articles)
  {
    this.IIIllllI = articles;
  }

  @ManyToMany(mappedBy="tags", fetch=FetchType.LAZY)
  public Set<Product> getProducts()
  {
    return this.IIIlllll;
  }

  public void setProducts(Set<Product> products)
  {
    this.IIIlllll = products;
  }

  @PreRemove
  public void preRemove()
  {
    Set localSet = getArticles();
    Object localObject2;
    if (localSet != null)
    {
      localObject2 = localSet.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Article)((Iterator)localObject2).next();
        ((Article)localObject1).getTags().remove(this);
      }
    }
    Object localObject1 = getProducts();
    if (localObject1 != null)
    {
      Iterator localIterator = ((Set)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Product)localIterator.next();
        ((Product)localObject2).getTags().remove(this);
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Tag
 * JD-Core Version:    0.6.2
 */