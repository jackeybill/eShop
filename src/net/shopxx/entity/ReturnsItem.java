package net.shopxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_returns_item")
public class ReturnsItem extends BaseEntity
{
  private static final long serialVersionUID = -4112374596087084162L;
  private String IIIllIlI;
  private String IIIllIll;
  private Integer IIIlllII;
  private Returns IIIlllIl;

  @NotEmpty
  @Column(nullable=false, updatable=false)
  public String getSn()
  {
    return this.IIIllIlI;
  }

  public void setSn(String sn)
  {
    this.IIIllIlI = sn;
  }

  @NotEmpty
  @Column(nullable=false, updatable=false)
  public String getName()
  {
    return this.IIIllIll;
  }

  public void setName(String name)
  {
    this.IIIllIll = name;
  }

  @NotNull
  @Min(1L)
  @Column(nullable=false, updatable=false)
  public Integer getQuantity()
  {
    return this.IIIlllII;
  }

  public void setQuantity(Integer quantity)
  {
    this.IIIlllII = quantity;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Returns getReturns()
  {
    return this.IIIlllIl;
  }

  public void setReturns(Returns returns)
  {
    this.IIIlllIl = returns;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.ReturnsItem
 * JD-Core Version:    0.6.2
 */