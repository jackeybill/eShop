package net.shopxx.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_member_rank")
public class MemberRank extends BaseEntity
{
  private static final long serialVersionUID = 3599029355500655209L;
  private String IIIllIlI;
  private Double IIIllIll;
  private BigDecimal IIIlllII;
  private Boolean IIIlllIl;
  private Boolean IIIllllI;
  private Set<Member> IIIlllll = new HashSet();
  private Set<Promotion> IIlIIIII = new HashSet();

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false, unique=true)
  public String getName()
  {
    return this.IIIllIlI;
  }

  public void setName(String name)
  {
    this.IIIllIlI = name;
  }

  @NotNull
  @Min(0L)
  @Digits(integer=3, fraction=3)
  @Column(nullable=false, precision=12, scale=6)
  public Double getScale()
  {
    return this.IIIllIll;
  }

  public void setScale(Double scale)
  {
    this.IIIllIll = scale;
  }

  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(unique=true, precision=21, scale=6)
  public BigDecimal getAmount()
  {
    return this.IIIlllII;
  }

  public void setAmount(BigDecimal amount)
  {
    this.IIIlllII = amount;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsDefault()
  {
    return this.IIIlllIl;
  }

  public void setIsDefault(Boolean isDefault)
  {
    this.IIIlllIl = isDefault;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsSpecial()
  {
    return this.IIIllllI;
  }

  public void setIsSpecial(Boolean isSpecial)
  {
    this.IIIllllI = isSpecial;
  }

  @OneToMany(mappedBy="memberRank", fetch=FetchType.LAZY)
  public Set<Member> getMembers()
  {
    return this.IIIlllll;
  }

  public void setMembers(Set<Member> members)
  {
    this.IIIlllll = members;
  }

  @ManyToMany(mappedBy="memberRanks", fetch=FetchType.LAZY)
  public Set<Promotion> getPromotions()
  {
    return this.IIlIIIII;
  }

  public void setPromotions(Set<Promotion> promotions)
  {
    this.IIlIIIII = promotions;
  }

  @PreRemove
  public void preRemove()
  {
    Set localSet = getPromotions();
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        Promotion localPromotion = (Promotion)localIterator.next();
        localPromotion.getMemberRanks().remove(this);
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.MemberRank
 * JD-Core Version:    0.6.2
 */