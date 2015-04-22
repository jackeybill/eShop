package net.shopxx.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="xx_refunds")
public class Refunds extends BaseEntity
{
  private static final long serialVersionUID = 354885216604823632L;
  private String IIIllIlI;
  private Refunds.Type IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;
  private BigDecimal IIIlllll;
  private String IIlIIIII;
  private String IIlIIIIl;
  private String IIlIIIlI;
  private Order IIlIIIll;

  @Column(nullable=false, updatable=false, unique=true)
  public String getSn()
  {
    return this.IIIllIlI;
  }

  public void setSn(String sn)
  {
    this.IIIllIlI = sn;
  }

  @NotNull
  @Column(nullable=false, updatable=false)
  public Refunds.Type getType()
  {
    return this.IIIllIll;
  }

  public void setType(Refunds.Type type)
  {
    this.IIIllIll = type;
  }

  @Column(updatable=false)
  public String getPaymentMethod()
  {
    return this.IIIlllII;
  }

  public void setPaymentMethod(String paymentMethod)
  {
    this.IIIlllII = paymentMethod;
  }

  @Length(max=200)
  @Column(updatable=false)
  public String getBank()
  {
    return this.IIIlllIl;
  }

  public void setBank(String bank)
  {
    this.IIIlllIl = bank;
  }

  @Length(max=200)
  @Column(updatable=false)
  public String getAccount()
  {
    return this.IIIllllI;
  }

  public void setAccount(String account)
  {
    this.IIIllllI = account;
  }

  @NotNull
  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(nullable=false, updatable=false, precision=21, scale=6)
  public BigDecimal getAmount()
  {
    return this.IIIlllll;
  }

  public void setAmount(BigDecimal amount)
  {
    this.IIIlllll = amount;
  }

  @Length(max=200)
  @Column(updatable=false)
  public String getPayee()
  {
    return this.IIlIIIII;
  }

  public void setPayee(String payee)
  {
    this.IIlIIIII = payee;
  }

  @Column(nullable=false, updatable=false)
  public String getOperator()
  {
    return this.IIlIIIIl;
  }

  public void setOperator(String operator)
  {
    this.IIlIIIIl = operator;
  }

  @Length(max=200)
  @Column(updatable=false)
  public String getMemo()
  {
    return this.IIlIIIlI;
  }

  public void setMemo(String memo)
  {
    this.IIlIIIlI = memo;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="orders", nullable=false, updatable=false)
  public Order getOrder()
  {
    return this.IIlIIIll;
  }

  public void setOrder(Order order)
  {
    this.IIlIIIll = order;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Refunds
 * JD-Core Version:    0.6.2
 */