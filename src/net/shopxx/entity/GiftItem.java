package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="xx_gift_item", uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"gift", "promotion"})})
public class GiftItem extends BaseEntity
{
  private static final long serialVersionUID = 6593657730952481829L;
  private Integer IIIllIlI;
  private Product IIIllIll;
  private Promotion IIIlllII;

  @JsonProperty
  @NotNull
  @Min(1L)
  @Column(nullable=false)
  public Integer getQuantity()
  {
    return this.IIIllIlI;
  }

  public void setQuantity(Integer quantity)
  {
    this.IIIllIlI = quantity;
  }

  @JsonProperty
  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Product getGift()
  {
    return this.IIIllIll;
  }

  public void setGift(Product gift)
  {
    this.IIIllIll = gift;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Promotion getPromotion()
  {
    return this.IIIlllII;
  }

  public void setPromotion(Promotion promotion)
  {
    this.IIIlllII = promotion;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.GiftItem
 * JD-Core Version:    0.6.2
 */