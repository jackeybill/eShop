package net.shopxx.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_role")
public class Role extends BaseEntity
{
  private static final long serialVersionUID = -6614052029623997372L;
  private String IIIllIlI;
  private Boolean IIIllIll;
  private String IIIlllII;
  private List<String> IIIlllIl = new ArrayList();
  private Set<Admin> IIIllllI = new HashSet();

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
  public Boolean getIsSystem()
  {
    return this.IIIllIll;
  }

  public void setIsSystem(Boolean isSystem)
  {
    this.IIIllIll = isSystem;
  }

  @Length(max=200)
  public String getDescription()
  {
    return this.IIIlllII;
  }

  public void setDescription(String description)
  {
    this.IIIlllII = description;
  }

  @ElementCollection
  @CollectionTable(name="xx_role_authority")
  public List<String> getAuthorities()
  {
    return this.IIIlllIl;
  }

  public void setAuthorities(List<String> authorities)
  {
    this.IIIlllIl = authorities;
  }

  @ManyToMany(mappedBy="roles", fetch=FetchType.LAZY)
  public Set<Admin> getAdmins()
  {
    return this.IIIllllI;
  }

  public void setAdmins(Set<Admin> admins)
  {
    this.IIIllllI = admins;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Role
 * JD-Core Version:    0.6.2
 */