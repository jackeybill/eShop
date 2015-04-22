package net.shopxx.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;

@Entity
@Table(name="xx_coupon_code")
public class CouponCode extends BaseEntity
{
  private static final long serialVersionUID = -1812874037224306719L;
  private String IIIllIlI;
  private Boolean IIIllIll;
  private Date IIIlllII;
  private Coupon IIIlllIl;
  private Member IIIllllI;
  private Order IIIlllll;

  @Column(nullable=false, updatable=false, unique=true)
  public String getCode()
  {
    return this.IIIllIlI;
  }

  public void setCode(String code)
  {
    this.IIIllIlI = code;
  }

  @Column(nullable=false)
  public Boolean getIsUsed()
  {
    return this.IIIllIll;
  }

  public void setIsUsed(Boolean isUsed)
  {
    this.IIIllIll = isUsed;
  }

  public Date getUsedDate()
  {
    return this.IIIlllII;
  }

  public void setUsedDate(Date usedDate)
  {
    this.IIIlllII = usedDate;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Coupon getCoupon()
  {
    return this.IIIlllIl;
  }

  public void setCoupon(Coupon coupon)
  {
    this.IIIlllIl = coupon;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  public Member getMember()
  {
    return this.IIIllllI;
  }

  public void setMember(Member member)
  {
    this.IIIllllI = member;
  }

  @OneToOne(mappedBy="couponCode", fetch=FetchType.LAZY)
  @JoinColumn(name="orders")
  public Order getOrder()
  {
    return this.IIIlllll;
  }

  public void setOrder(Order order)
  {
    this.IIIlllll = order;
  }

  @PreRemove
  public void preRemove()
  {
    if (getOrder() != null)
      getOrder().setCouponCode(null);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.CouponCode
 * JD-Core Version:    0.6.2
 */