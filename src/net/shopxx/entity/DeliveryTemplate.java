package net.shopxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_delivery_template")
public class DeliveryTemplate extends BaseEntity
{
  private static final long serialVersionUID = -3711024981692804054L;
  private String IIIllIlI;
  private String IIIllIll;
  private Integer IIIlllII;
  private Integer IIIlllIl;
  private Integer IIIllllI;
  private Integer IIIlllll;
  private String IIlIIIII;
  private Boolean IIlIIIIl;
  private String IIlIIIlI;

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

  @NotEmpty
  @Lob
  @Column(nullable=false)
  public String getContent()
  {
    return this.IIIllIll;
  }

  public void setContent(String content)
  {
    this.IIIllIll = content;
  }

  @NotNull
  @Min(1L)
  @Column(nullable=false)
  public Integer getWidth()
  {
    return this.IIIlllII;
  }

  public void setWidth(Integer width)
  {
    this.IIIlllII = width;
  }

  @NotNull
  @Min(1L)
  @Column(nullable=false)
  public Integer getHeight()
  {
    return this.IIIlllIl;
  }

  public void setHeight(Integer height)
  {
    this.IIIlllIl = height;
  }

  @NotNull
  @Column(nullable=false)
  public Integer getOffsetX()
  {
    return this.IIIllllI;
  }

  public void setOffsetX(Integer offsetX)
  {
    this.IIIllllI = offsetX;
  }

  @NotNull
  @Column(nullable=false)
  public Integer getOffsetY()
  {
    return this.IIIlllll;
  }

  public void setOffsetY(Integer offsetY)
  {
    this.IIIlllll = offsetY;
  }

  @Length(max=200)
  public String getBackground()
  {
    return this.IIlIIIII;
  }

  public void setBackground(String background)
  {
    this.IIlIIIII = background;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsDefault()
  {
    return this.IIlIIIIl;
  }

  public void setIsDefault(Boolean isDefault)
  {
    this.IIlIIIIl = isDefault;
  }

  @Length(max=200)
  public String getMemo()
  {
    return this.IIlIIIlI;
  }

  public void setMemo(String memo)
  {
    this.IIlIIIlI = memo;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.DeliveryTemplate
 * JD-Core Version:    0.6.2
 */