package net.shopxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_navigation")
public class Navigation extends OrderEntity
{
  private static final long serialVersionUID = -7635757647887646795L;
  private String IIIllIlI;
  private Navigation.Position IIIllIll;
  private String IIIlllII;
  private Boolean IIIlllIl;

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
  public Navigation.Position getPosition()
  {
    return this.IIIllIll;
  }

  public void setPosition(Navigation.Position position)
  {
    this.IIIllIll = position;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getUrl()
  {
    return this.IIIlllII;
  }

  public void setUrl(String url)
  {
    this.IIIlllII = url;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsBlankTarget()
  {
    return this.IIIlllIl;
  }

  public void setIsBlankTarget(Boolean isBlankTarget)
  {
    this.IIIlllIl = isBlankTarget;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Navigation
 * JD-Core Version:    0.6.2
 */