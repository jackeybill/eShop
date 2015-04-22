package net.shopxx.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_member_attribute")
public class MemberAttribute extends OrderEntity
{
  private static final long serialVersionUID = 4513705276569738136L;
  private String IIIllIlI;
  private MemberAttribute.Type IIIllIll;
  private Boolean IIIlllII;
  private Boolean IIIlllIl;
  private Integer IIIllllI;
  private List<String> IIIlllll = new ArrayList();

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
  public MemberAttribute.Type getType()
  {
    return this.IIIllIll;
  }

  public void setType(MemberAttribute.Type type)
  {
    this.IIIllIll = type;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsEnabled()
  {
    return this.IIIlllII;
  }

  public void setIsEnabled(Boolean isEnabled)
  {
    this.IIIlllII = isEnabled;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsRequired()
  {
    return this.IIIlllIl;
  }

  public void setIsRequired(Boolean isRequired)
  {
    this.IIIlllIl = isRequired;
  }

  @Column(updatable=false)
  public Integer getPropertyIndex()
  {
    return this.IIIllllI;
  }

  public void setPropertyIndex(Integer propertyIndex)
  {
    this.IIIllllI = propertyIndex;
  }

  @ElementCollection
  @CollectionTable(name="xx_member_attribute_option")
  public List<String> getOptions()
  {
    return this.IIIlllll;
  }

  public void setOptions(List<String> options)
  {
    this.IIIlllll = options;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.MemberAttribute
 * JD-Core Version:    0.6.2
 */