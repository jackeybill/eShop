package net.shopxx.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_consultation")
public class Consultation extends BaseEntity
{
  private static final long serialVersionUID = -3950317769006303385L;
  private static final String IIIllIlI = "/consultation/content";
  private static final String IIIllIll = ".jhtml";
  private String IIIlllII;
  private Boolean IIIlllIl;
  private String IIIllllI;
  private Member IIIlllll;
  private Product IIlIIIII;
  private Consultation IIlIIIIl;
  private Set<Consultation> IIlIIIlI = new HashSet();

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false, updatable=false)
  public String getContent()
  {
    return this.IIIlllII;
  }

  public void setContent(String content)
  {
    this.IIIlllII = content;
  }

  @Column(nullable=false)
  public Boolean getIsShow()
  {
    return this.IIIlllIl;
  }

  public void setIsShow(Boolean isShow)
  {
    this.IIIlllIl = isShow;
  }

  @Column(nullable=false, updatable=false)
  public String getIp()
  {
    return this.IIIllllI;
  }

  public void setIp(String ip)
  {
    this.IIIllllI = ip;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(updatable=false)
  public Member getMember()
  {
    return this.IIIlllll;
  }

  public void setMember(Member member)
  {
    this.IIIlllll = member;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Product getProduct()
  {
    return this.IIlIIIII;
  }

  public void setProduct(Product product)
  {
    this.IIlIIIII = product;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(updatable=false)
  public Consultation getForConsultation()
  {
    return this.IIlIIIIl;
  }

  public void setForConsultation(Consultation forConsultation)
  {
    this.IIlIIIIl = forConsultation;
  }

  @OneToMany(mappedBy="forConsultation", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("createDate asc")
  public Set<Consultation> getReplyConsultations()
  {
    return this.IIlIIIlI;
  }

  public void setReplyConsultations(Set<Consultation> replyConsultations)
  {
    this.IIlIIIlI = replyConsultations;
  }

  @Transient
  public String getPath()
  {
    if ((getProduct() != null) && (getProduct().getId() != null))
      return "/consultation/content/" + getProduct().getId() + ".jhtml";
    return null;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Consultation
 * JD-Core Version:    0.6.2
 */