package net.shopxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_product_notify")
public class ProductNotify extends BaseEntity
{
  private static final long serialVersionUID = 3192904068727393421L;
  private String IIIllIlI;
  private Boolean IIIllIll;
  private Member IIIlllII;
  private Product IIIlllIl;

  @NotEmpty
  @Email
  @Length(max=200)
  @Column(nullable=false, updatable=false)
  public String getEmail()
  {
    return this.IIIllIlI;
  }

  public void setEmail(String email)
  {
    this.IIIllIlI = email;
  }

  @Column(nullable=false)
  public Boolean getHasSent()
  {
    return this.IIIllIll;
  }

  public void setHasSent(Boolean hasSent)
  {
    this.IIIllIll = hasSent;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(updatable=false)
  public Member getMember()
  {
    return this.IIIlllII;
  }

  public void setMember(Member member)
  {
    this.IIIlllII = member;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Product getProduct()
  {
    return this.IIIlllIl;
  }

  public void setProduct(Product product)
  {
    this.IIIlllIl = product;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.ProductNotify
 * JD-Core Version:    0.6.2
 */