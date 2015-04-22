package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_attribute")
public class Attribute extends OrderEntity
{
  private static final long serialVersionUID = 2447794131117928367L;
  private String IIIllIlI;
  private Integer IIIllIll;
  private ProductCategory IIIlllII;
  private List<String> IIIlllIl = new ArrayList();

  @JsonProperty
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

  @Column(nullable=false, updatable=false)
  public Integer getPropertyIndex()
  {
    return this.IIIllIll;
  }

  public void setPropertyIndex(Integer propertyIndex)
  {
    this.IIIllIll = propertyIndex;
  }

  @NotNull(groups={BaseEntity.Save.class})
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public ProductCategory getProductCategory()
  {
    return this.IIIlllII;
  }

  public void setProductCategory(ProductCategory productCategory)
  {
    this.IIIlllII = productCategory;
  }

  @JsonProperty
  @NotEmpty
  @ElementCollection
  @CollectionTable(name="xx_attribute_option")
  public List<String> getOptions()
  {
    return this.IIIlllIl;
  }

  public void setOptions(List<String> options)
  {
    this.IIIlllIl = options;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Attribute
 * JD-Core Version:    0.6.2
 */