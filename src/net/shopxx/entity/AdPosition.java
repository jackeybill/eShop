package net.shopxx.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_ad_position")
public class AdPosition extends BaseEntity
{
  private static final long serialVersionUID = -7849848867030199578L;
  private String IIIllIlI;
  private Integer IIIllIll;
  private Integer IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;
  private Set<Ad> IIIlllll = new HashSet();

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
  @Min(1L)
  @Column(nullable=false)
  public Integer getWidth()
  {
    return this.IIIllIll;
  }

  public void setWidth(Integer width)
  {
    this.IIIllIll = width;
  }

  @NotNull
  @Min(1L)
  @Column(nullable=false)
  public Integer getHeight()
  {
    return this.IIIlllII;
  }

  public void setHeight(Integer height)
  {
    this.IIIlllII = height;
  }

  @Length(max=200)
  public String getDescription()
  {
    return this.IIIlllIl;
  }

  public void setDescription(String description)
  {
    this.IIIlllIl = description;
  }

  @NotEmpty
  @Lob
  @Column(nullable=false)
  public String getTemplate()
  {
    return this.IIIllllI;
  }

  public void setTemplate(String template)
  {
    this.IIIllllI = template;
  }

  @OneToMany(mappedBy="adPosition", fetch=FetchType.EAGER, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("order asc")
  public Set<Ad> getAds()
  {
    return this.IIIlllll;
  }

  public void setAds(Set<Ad> ads)
  {
    this.IIIlllll = ads;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.AdPosition
 * JD-Core Version:    0.6.2
 */