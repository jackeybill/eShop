package net.shopxx;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Order
  implements Serializable
{
  private static final long serialVersionUID = -3078342809727773232L;
  private static final Order.Direction IIIllIlI = Order.Direction.desc;
  private String IIIllIll;
  private Order.Direction IIIlllII = IIIllIlI;

  public Order()
  {
  }

  public Order(String property, Order.Direction direction)
  {
    this.IIIllIll = property;
    this.IIIlllII = direction;
  }

  public static Order asc(String property)
  {
    return new Order(property, Order.Direction.asc);
  }

  public static Order desc(String property)
  {
    return new Order(property, Order.Direction.desc);
  }

  public String getProperty()
  {
    return this.IIIllIll;
  }

  public void setProperty(String property)
  {
    this.IIIllIll = property;
  }

  public Order.Direction getDirection()
  {
    return this.IIIlllII;
  }

  public void setDirection(Order.Direction direction)
  {
    this.IIIlllII = direction;
  }

  public boolean equals(Object obj)
  {
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (this == obj)
      return true;
    Order localOrder = (Order)obj;
    return new EqualsBuilder().append(getProperty(), localOrder.getProperty()).append(getDirection(), localOrder.getDirection()).isEquals();
  }

  public int hashCode()
  {
    return new HashCodeBuilder(17, 37).append(getProperty()).append(getDirection()).toHashCode();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.Order
 * JD-Core Version:    0.6.2
 */