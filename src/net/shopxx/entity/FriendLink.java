package net.shopxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_friend_link")
public class FriendLink extends OrderEntity
{
  private static final long serialVersionUID = 3019642557500517628L;
  private String IIIllIlI;
  private FriendLink.Type IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;

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
  public FriendLink.Type getType()
  {
    return this.IIIllIll;
  }

  public void setType(FriendLink.Type type)
  {
    this.IIIllIll = type;
  }

  @Length(max=200)
  public String getLogo()
  {
    return this.IIIlllII;
  }

  public void setLogo(String logo)
  {
    this.IIIlllII = logo;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getUrl()
  {
    return this.IIIlllIl;
  }

  public void setUrl(String url)
  {
    this.IIIlllIl = url;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.FriendLink
 * JD-Core Version:    0.6.2
 */