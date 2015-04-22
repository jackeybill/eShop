package net.shopxx.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="xx_deposit")
public class Deposit extends BaseEntity
{
  private static final long serialVersionUID = -8323452873046981882L;
  private Deposit.Type IIIllIlI;
  private BigDecimal IIIllIll;
  private BigDecimal IIIlllII;
  private BigDecimal IIIlllIl;
  private String IIIllllI;
  private String IIIlllll;
  private Member IIlIIIII;
  private Order IIlIIIIl;
  private Payment IIlIIIlI;

  @Column(nullable=false, updatable=false)
  public Deposit.Type getType()
  {
    return this.IIIllIlI;
  }

  public void setType(Deposit.Type type)
  {
    this.IIIllIlI = type;
  }

  @Column(nullable=false, updatable=false, precision=21, scale=6)
  public BigDecimal getCredit()
  {
    return this.IIIllIll;
  }

  public void setCredit(BigDecimal credit)
  {
    this.IIIllIll = credit;
  }

  @Column(nullable=false, updatable=false, precision=21, scale=6)
  public BigDecimal getDebit()
  {
    return this.IIIlllII;
  }

  public void setDebit(BigDecimal debit)
  {
    this.IIIlllII = debit;
  }

  @Column(nullable=false, updatable=false, precision=21, scale=6)
  public BigDecimal getBalance()
  {
    return this.IIIlllIl;
  }

  public void setBalance(BigDecimal balance)
  {
    this.IIIlllIl = balance;
  }

  @Column(updatable=false)
  public String getOperator()
  {
    return this.IIIllllI;
  }

  public void setOperator(String operator)
  {
    this.IIIllllI = operator;
  }

  @Length(max=200)
  @Column(updatable=false)
  public String getMemo()
  {
    return this.IIIlllll;
  }

  public void setMemo(String memo)
  {
    this.IIIlllll = memo;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Member getMember()
  {
    return this.IIlIIIII;
  }

  public void setMember(Member member)
  {
    this.IIlIIIII = member;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="orders")
  public Order getOrder()
  {
    return this.IIlIIIIl;
  }

  public void setOrder(Order order)
  {
    this.IIlIIIIl = order;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  public Payment getPayment()
  {
    return this.IIlIIIlI;
  }

  public void setPayment(Payment payment)
  {
    this.IIlIIIlI = payment;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Deposit
 * JD-Core Version:    0.6.2
 */