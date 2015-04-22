package net.shopxx.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_specification")
public class Specification extends OrderEntity
{
  private static final long serialVersionUID = -6346775052811140926L;
  private String IIIllIlI;
  private Specification.Type IIIllIll;
  private String IIIlllII;
  private List<SpecificationValue> IIIlllIl = new ArrayList();
  private Set<Product> IIIllllI = new HashSet();

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
  public Specification.Type getType()
  {
    return this.IIIllIll;
  }

  public void setType(Specification.Type type)
  {
    this.IIIllIll = type;
  }

  @Length(max=200)
  public String getMemo()
  {
    return this.IIIlllII;
  }

  public void setMemo(String memo)
  {
    this.IIIlllII = memo;
  }

  @Valid
  @NotEmpty
  @OneToMany(mappedBy="specification", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL}, orphanRemoval=true)
  @OrderBy("order asc")
  public List<SpecificationValue> getSpecificationValues()
  {
    return this.IIIlllIl;
  }

  public void setSpecificationValues(List<SpecificationValue> specificationValues)
  {
    this.IIIlllIl = specificationValues;
  }

  @ManyToMany(mappedBy="specifications", fetch=FetchType.LAZY)
  public Set<Product> getProducts()
  {
    return this.IIIllllI;
  }

  public void setProducts(Set<Product> products)
  {
    this.IIIllllI = products;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Specification
 * JD-Core Version:    0.6.2
 */