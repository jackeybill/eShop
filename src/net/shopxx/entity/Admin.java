package net.shopxx.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_admin")
public class Admin extends BaseEntity
{
  private static final long serialVersionUID = -7519486823153844426L;
  private String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;
  private Boolean IIIlllll;
  private Boolean IIlIIIII;
  private Integer IIlIIIIl;
  private Date IIlIIIlI;
  private Date IIlIIIll;
  private String IIlIIlII;
  private Set<Role> IIlIIlIl = new HashSet();
  private Set<Order> IIlIIllI = new HashSet();

  @NotEmpty(groups={BaseEntity.Save.class})
  @Pattern(regexp="^[0-9a-z_A-Z\\u4e00-\\u9fa5]+$")
  @Length(min=2, max=20)
  @Column(nullable=false, updatable=false, unique=true)
  public String getUsername()
  {
    return this.IIIllIlI;
  }

  public void setUsername(String username)
  {
    this.IIIllIlI = username;
  }

  @NotEmpty(groups={BaseEntity.Save.class})
  @Pattern(regexp="^[^\\s&\"<>]+$")
  @Length(min=4, max=20)
  @Column(nullable=false)
  public String getPassword()
  {
    return this.IIIllIll;
  }

  public void setPassword(String password)
  {
    this.IIIllIll = password;
  }

  @NotEmpty
  @Email
  @Length(max=200)
  @Column(nullable=false)
  public String getEmail()
  {
    return this.IIIlllII;
  }

  public void setEmail(String email)
  {
    this.IIIlllII = email;
  }

  @Length(max=200)
  public String getName()
  {
    return this.IIIlllIl;
  }

  public void setName(String name)
  {
    this.IIIlllIl = name;
  }

  @Length(max=200)
  public String getDepartment()
  {
    return this.IIIllllI;
  }

  public void setDepartment(String department)
  {
    this.IIIllllI = department;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsEnabled()
  {
    return this.IIIlllll;
  }

  public void setIsEnabled(Boolean isEnabled)
  {
    this.IIIlllll = isEnabled;
  }

  @Column(nullable=false)
  public Boolean getIsLocked()
  {
    return this.IIlIIIII;
  }

  public void setIsLocked(Boolean isLocked)
  {
    this.IIlIIIII = isLocked;
  }

  @Column(nullable=false)
  public Integer getLoginFailureCount()
  {
    return this.IIlIIIIl;
  }

  public void setLoginFailureCount(Integer loginFailureCount)
  {
    this.IIlIIIIl = loginFailureCount;
  }

  public Date getLockedDate()
  {
    return this.IIlIIIlI;
  }

  public void setLockedDate(Date lockedDate)
  {
    this.IIlIIIlI = lockedDate;
  }

  public Date getLoginDate()
  {
    return this.IIlIIIll;
  }

  public void setLoginDate(Date loginDate)
  {
    this.IIlIIIll = loginDate;
  }

  public String getLoginIp()
  {
    return this.IIlIIlII;
  }

  public void setLoginIp(String loginIp)
  {
    this.IIlIIlII = loginIp;
  }

  @NotEmpty
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_admin_role")
  public Set<Role> getRoles()
  {
    return this.IIlIIlIl;
  }

  public void setRoles(Set<Role> roles)
  {
    this.IIlIIlIl = roles;
  }

  @OneToMany(mappedBy="operator", fetch=FetchType.LAZY)
  public Set<Order> getOrders()
  {
    return this.IIlIIllI;
  }

  public void setOrders(Set<Order> orders)
  {
    this.IIlIIllI = orders;
  }

  @PreRemove
  public void preRemove()
  {
    Set localSet = getOrders();
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        Order localOrder = (Order)localIterator.next();
        localOrder.setLockExpire(null);
        localOrder.setOperator(null);
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Admin
 * JD-Core Version:    0.6.2
 */