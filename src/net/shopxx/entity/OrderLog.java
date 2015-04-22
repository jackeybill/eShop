package net.shopxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="xx_order_log")
public class OrderLog extends BaseEntity
{
  private static final long serialVersionUID = -2704154761295319939L;
  private OrderLog.Type IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private Order IIIlllIl;

  public OrderLog()
  {
  }

  public OrderLog(OrderLog.Type type, String operator)
  {
    this.IIIllIlI = type;
    this.IIIllIll = operator;
  }

  public OrderLog(OrderLog.Type type, String operator, String content)
  {
    this.IIIllIlI = type;
    this.IIIllIll = operator;
    this.IIIlllII = content;
  }

  @Column(nullable=false, updatable=false)
  public OrderLog.Type getType()
  {
    return this.IIIllIlI;
  }

  public void setType(OrderLog.Type type)
  {
    this.IIIllIlI = type;
  }

  @Column(updatable=false)
  public String getOperator()
  {
    return this.IIIllIll;
  }

  public void setOperator(String operator)
  {
    this.IIIllIll = operator;
  }

  @Column(updatable=false)
  public String getContent()
  {
    return this.IIIlllII;
  }

  public void setContent(String content)
  {
    this.IIIlllII = content;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="orders", nullable=false, updatable=false)
  public Order getOrder()
  {
    return this.IIIlllIl;
  }

  public void setOrder(Order order)
  {
    this.IIIlllIl = order;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.OrderLog
 * JD-Core Version:    0.6.2
 */