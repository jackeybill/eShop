package net.shopxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_review")
public class Review extends BaseEntity
{
  private static final long serialVersionUID = 8795901519290584100L;
  private static final String IIIllIlI = "/review/content";
  private static final String IIIllIll = ".jhtml";
  private Integer IIIlllII;
  private String IIIlllIl;
  private Boolean IIIllllI;
  private String IIIlllll;
  private Member IIlIIIII;
  private Product IIlIIIIl;

  @NotNull
  @Min(1L)
  @Max(5L)
  @Column(nullable=false, updatable=false)
  public Integer getScore()
  {
    return this.IIIlllII;
  }

  public void setScore(Integer score)
  {
    this.IIIlllII = score;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false, updatable=false)
  public String getContent()
  {
    return this.IIIlllIl;
  }

  public void setContent(String content)
  {
    this.IIIlllIl = content;
  }

  @Column(nullable=false)
  public Boolean getIsShow()
  {
    return this.IIIllllI;
  }

  public void setIsShow(Boolean isShow)
  {
    this.IIIllllI = isShow;
  }

  @Column(nullable=false, updatable=false)
  public String getIp()
  {
    return this.IIIlllll;
  }

  public void setIp(String ip)
  {
    this.IIIlllll = ip;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(updatable=false)
  public Member getMember()
  {
    return this.IIlIIIII;
  }

  public void setMember(Member member)
  {
    this.IIlIIIII = member;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Product getProduct()
  {
    return this.IIlIIIIl;
  }

  public void setProduct(Product product)
  {
    this.IIlIIIIl = product;
  }

  @Transient
  public String getPath()
  {
    if ((getProduct() != null) && (getProduct().getId() != null))
      return "/review/content/" + getProduct().getId() + ".jhtml";
    return null;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Review
 * JD-Core Version:    0.6.2
 */