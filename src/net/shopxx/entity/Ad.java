package net.shopxx.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_ad")
public class Ad extends OrderEntity
{
  private static final long serialVersionUID = -1307743303786909390L;
  private String IIIllIlI;
  private Ad.Type IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private Date IIIllllI;
  private Date IIIlllll;
  private String IIlIIIII;
  private AdPosition IIlIIIIl;

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getTitle()
  {
    return this.IIIllIlI;
  }

  public void setTitle(String title)
  {
    this.IIIllIlI = title;
  }

  @NotNull
  @Column(nullable=false)
  public Ad.Type getType()
  {
    return this.IIIllIll;
  }

  public void setType(Ad.Type type)
  {
    this.IIIllIll = type;
  }

  @Lob
  public String getContent()
  {
    return this.IIIlllII;
  }

  public void setContent(String content)
  {
    this.IIIlllII = content;
  }

  @Length(max=200)
  public String getPath()
  {
    return this.IIIlllIl;
  }

  public void setPath(String path)
  {
    this.IIIlllIl = path;
  }

  public Date getBeginDate()
  {
    return this.IIIllllI;
  }

  public void setBeginDate(Date beginDate)
  {
    this.IIIllllI = beginDate;
  }

  public Date getEndDate()
  {
    return this.IIIlllll;
  }

  public void setEndDate(Date endDate)
  {
    this.IIIlllll = endDate;
  }

  @Length(max=200)
  public String getUrl()
  {
    return this.IIlIIIII;
  }

  public void setUrl(String url)
  {
    this.IIlIIIII = url;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false)
  public AdPosition getAdPosition()
  {
    return this.IIlIIIIl;
  }

  public void setAdPosition(AdPosition adPosition)
  {
    this.IIlIIIIl = adPosition;
  }

  @Transient
  public boolean hasBegun()
  {
    return (getBeginDate() == null) || (new Date().after(getBeginDate()));
  }

  @Transient
  public boolean hasEnded()
  {
    return (getEndDate() != null) && (new Date().after(getEndDate()));
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Ad
 * JD-Core Version:    0.6.2
 */