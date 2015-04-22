package net.shopxx.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_specification_value")
public class SpecificationValue extends OrderEntity
{
  private static final long serialVersionUID = -8624741017444123488L;
  private String IIIllIlI;
  private String IIIllIll;
  private Specification IIIlllII;
  private Set<Product> IIIlllIl = new HashSet();

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
  public String getImage()
  {
    return this.IIIllIll;
  }

  public void setImage(String image)
  {
    this.IIIllIll = image;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false)
  public Specification getSpecification()
  {
    return this.IIIlllII;
  }

  public void setSpecification(Specification specification)
  {
    this.IIIlllII = specification;
  }

  @ManyToMany(mappedBy="specificationValues", fetch=FetchType.LAZY)
  public Set<Product> getProducts()
  {
    return this.IIIlllIl;
  }

  public void setProducts(Set<Product> products)
  {
    this.IIIlllIl = products;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.SpecificationValue
 * JD-Core Version:    0.6.2
 */