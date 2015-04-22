package net.shopxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="xx_seo")
public class Seo extends BaseEntity
{
  private static final long serialVersionUID = -3503657242384822672L;
  private Seo.Type IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;

  @Column(nullable=false, updatable=false, unique=true)
  public Seo.Type getType()
  {
    return this.IIIllIlI;
  }

  public void setType(Seo.Type type)
  {
    this.IIIllIlI = type;
  }

  @Length(max=200)
  public String getTitle()
  {
    return this.IIIllIll;
  }

  public void setTitle(String title)
  {
    this.IIIllIll = title;
  }

  @Length(max=200)
  public String getKeywords()
  {
    return this.IIIlllII;
  }

  public void setKeywords(String keywords)
  {
    if (keywords != null)
      keywords = keywords.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "");
    this.IIIlllII = keywords;
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
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Seo
 * JD-Core Version:    0.6.2
 */