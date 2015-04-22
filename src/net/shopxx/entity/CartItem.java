package net.shopxx.entity;

import java.math.BigDecimal;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import net.shopxx.Setting;
import net.shopxx.util.SettingUtils;

@Entity
@Table(name="xx_cart_item")
public class CartItem extends BaseEntity
{
  private static final long serialVersionUID = 2979296789363163144L;
  public static final Integer MAX_QUANTITY = Integer.valueOf(10000);
  private Integer IIIllIlI;
  private Product IIIllIll;
  private Cart IIIlllII;

  @Column(nullable=false)
  public Integer getQuantity()
  {
    return this.IIIllIlI;
  }

  public void setQuantity(Integer quantity)
  {
    this.IIIllIlI = quantity;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Product getProduct()
  {
    return this.IIIllIll;
  }

  public void setProduct(Product product)
  {
    this.IIIllIll = product;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false)
  public Cart getCart()
  {
    return this.IIIlllII;
  }

  public void setCart(Cart cart)
  {
    this.IIIlllII = cart;
  }

  @Transient
  public long getPoint()
  {
    if ((getProduct() != null) && (getProduct().getPoint() != null) && (getQuantity() != null))
      return getProduct().getPoint().longValue() * getQuantity().intValue();
    return 0L;
  }

  @Transient
  public int getWeight()
  {
    if ((getProduct() != null) && (getProduct().getWeight() != null) && (getQuantity() != null))
      return getProduct().getWeight().intValue() * getQuantity().intValue();
    return 0;
  }

  @Transient
  public BigDecimal getUnitPrice()
  {
    if ((getProduct() != null) && (getProduct().getPrice() != null))
    {
      Setting localSetting = SettingUtils.get();
      if ((getCart() != null) && (getCart().getMember() != null) && (getCart().getMember().getMemberRank() != null))
      {
        MemberRank localMemberRank = getCart().getMember().getMemberRank();
        Map localMap = getProduct().getMemberPrice();
        if ((localMap != null) && (!localMap.isEmpty()) && (localMap.containsKey(localMemberRank)))
          return localSetting.setScale((BigDecimal)localMap.get(localMemberRank));
        if (localMemberRank.getScale() != null)
          return localSetting.setScale(getProduct().getPrice().multiply(new BigDecimal(localMemberRank.getScale().doubleValue())));
      }
      return localSetting.setScale(getProduct().getPrice());
    }
    return new BigDecimal(0);
  }

  @Transient
  public BigDecimal getSubtotal()
  {
    if (getQuantity() != null)
      return getUnitPrice().multiply(new BigDecimal(getQuantity().intValue()));
    return new BigDecimal(0);
  }

  @Transient
  public boolean getIsLowStock()
  {
    return (getQuantity() != null) && (getProduct() != null) && (getProduct().getStock() != null) && (getQuantity().intValue() > getProduct().getAvailableStock().intValue());
  }

  @Transient
  public void add(int quantity)
  {
    if (quantity > 0)
      if (getQuantity() != null)
        setQuantity(Integer.valueOf(getQuantity().intValue() + quantity));
      else
        setQuantity(Integer.valueOf(quantity));
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.CartItem
 * JD-Core Version:    0.6.2
 */