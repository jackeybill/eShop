package net.shopxx.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="xx_payment")
public class Payment extends BaseEntity
{
  private static final long serialVersionUID = -5052430116564638634L;
  public static final String TYPE_SEPARATOR = "-";
  private String IIIllIlI;
  private Payment.Type IIIllIll;
  private Payment.Status IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;
  private String IIIlllll;
  private BigDecimal IIlIIIII;
  private BigDecimal IIlIIIIl;
  private String IIlIIIlI;
  private String IIlIIIll;
  private Date IIlIIlII;
  private String IIlIIlIl;
  private String IIlIIllI;
  private Date IIlIIlll;
  private Deposit IIlIlIII;
  private Member IIlIlIIl;
  private Order IIlIlIlI;

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
  public Payment.Type getType()
  {
    return this.IIIllIll;
  }

  public void setType(Payment.Type type)
  {
    this.IIIllIll = type;
  }

  @Column(nullable=false)
  public Payment.Status getStatus()
  {
    return this.IIIlllII;
  }

  public void setStatus(Payment.Status status)
  {
    this.IIIlllII = status;
  }

  @Column(updatable=false)
  public String getPaymentMethod()
  {
    return this.IIIlllIl;
  }

  public void setPaymentMethod(String paymentMethod)
  {
    this.IIIlllIl = paymentMethod;
  }

  @Length(max=200)
  public String getBank()
  {
    return this.IIIllllI;
  }

  public void setBank(String bank)
  {
    this.IIIllllI = bank;
  }

  @Length(max=200)
  public String getAccount()
  {
    return this.IIIlllll;
  }

  public void setAccount(String account)
  {
    this.IIIlllll = account;
  }

  @Column(nullable=false, precision=21, scale=6)
  public BigDecimal getFee()
  {
    return this.IIlIIIII;
  }

  public void setFee(BigDecimal fee)
  {
    this.IIlIIIII = fee;
  }

  @NotNull
  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(nullable=false, precision=21, scale=6)
  public BigDecimal getAmount()
  {
    return this.IIlIIIIl;
  }

  public void setAmount(BigDecimal amount)
  {
    this.IIlIIIIl = amount;
  }

  @Length(max=200)
  public String getPayer()
  {
    return this.IIlIIIlI;
  }

  public void setPayer(String payer)
  {
    this.IIlIIIlI = payer;
  }

  @Column(updatable=false)
  public String getOperator()
  {
    return this.IIlIIIll;
  }

  public void setOperator(String operator)
  {
    this.IIlIIIll = operator;
  }

  public Date getPaymentDate()
  {
    return this.IIlIIlII;
  }

  public void setPaymentDate(Date paymentDate)
  {
    this.IIlIIlII = paymentDate;
  }

  @Length(max=200)
  public String getMemo()
  {
    return this.IIlIIlIl;
  }

  public void setMemo(String memo)
  {
    this.IIlIIlIl = memo;
  }

  @JoinColumn(updatable=false)
  public String getPaymentPluginId()
  {
    return this.IIlIIllI;
  }

  public void setPaymentPluginId(String paymentPluginId)
  {
    this.IIlIIllI = paymentPluginId;
  }

  @JoinColumn(updatable=false)
  public Date getExpire()
  {
    return this.IIlIIlll;
  }

  public void setExpire(Date expire)
  {
    this.IIlIIlll = expire;
  }

  @OneToOne(mappedBy="payment", fetch=FetchType.LAZY)
  public Deposit getDeposit()
  {
    return this.IIlIlIII;
  }

  public void setDeposit(Deposit deposit)
  {
    this.IIlIlIII = deposit;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(updatable=false)
  public Member getMember()
  {
    return this.IIlIlIIl;
  }

  public void setMember(Member member)
  {
    this.IIlIlIIl = member;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="orders", updatable=false)
  public Order getOrder()
  {
    return this.IIlIlIlI;
  }

  public void setOrder(Order order)
  {
    this.IIlIlIlI = order;
  }

  @Transient
  public boolean hasExpired()
  {
    return (getExpire() != null) && (new Date().after(getExpire()));
  }

  @PreRemove
  public void preRemove()
  {
    if (getDeposit() != null)
      getDeposit().setPayment(null);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Payment
 * JD-Core Version:    0.6.2
 */