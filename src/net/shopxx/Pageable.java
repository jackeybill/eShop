package net.shopxx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Pageable
  implements Serializable
{
  private static final long serialVersionUID = -3930180379790344299L;
  private static final int IIIllIlI = 1;
  private static final int IIIllIll = 20;
  private static final int IIIlllII = 1000;
  private int IIIlllIl = 1;
  private int IIIllllI = 20;
  private String IIIlllll;
  private String IIlIIIII;
  private String IIlIIIIl;
  private Order.Direction IIlIIIlI;
  private List<Filter> IIlIIIll = new ArrayList();
  private List<Order> IIlIIlII = new ArrayList();

  public Pageable()
  {
  }

  public Pageable(Integer pageNumber, Integer pageSize)
  {
    if ((pageNumber != null) && (pageNumber.intValue() >= 1))
      this.IIIlllIl = pageNumber.intValue();
    if ((pageSize != null) && (pageSize.intValue() >= 1) && (pageSize.intValue() <= 1000))
      this.IIIllllI = pageSize.intValue();
  }

  public int getPageNumber()
  {
    return this.IIIlllIl;
  }

  public void setPageNumber(int pageNumber)
  {
    if (pageNumber < 1)
      pageNumber = 1;
    this.IIIlllIl = pageNumber;
  }

  public int getPageSize()
  {
    return this.IIIllllI;
  }

  public void setPageSize(int pageSize)
  {
    if ((pageSize < 1) || (pageSize > 1000))
      pageSize = 20;
    this.IIIllllI = pageSize;
  }

  public String getSearchProperty()
  {
    return this.IIIlllll;
  }

  public void setSearchProperty(String searchProperty)
  {
    this.IIIlllll = searchProperty;
  }

  public String getSearchValue()
  {
    return this.IIlIIIII;
  }

  public void setSearchValue(String searchValue)
  {
    this.IIlIIIII = searchValue;
  }

  public String getOrderProperty()
  {
    return this.IIlIIIIl;
  }

  public void setOrderProperty(String orderProperty)
  {
    this.IIlIIIIl = orderProperty;
  }

  public Order.Direction getOrderDirection()
  {
    return this.IIlIIIlI;
  }

  public void setOrderDirection(Order.Direction orderDirection)
  {
    this.IIlIIIlI = orderDirection;
  }

  public List<Filter> getFilters()
  {
    return this.IIlIIIll;
  }

  public void setFilters(List<Filter> filters)
  {
    this.IIlIIIll = filters;
  }

  public List<Order> getOrders()
  {
    return this.IIlIIlII;
  }

  public void setOrders(List<Order> orders)
  {
    this.IIlIIlII = orders;
  }

  public boolean equals(Object obj)
  {
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (this == obj)
      return true;
    Pageable localPageable = (Pageable)obj;
    return new EqualsBuilder().append(getPageNumber(), localPageable.getPageNumber()).append(getPageSize(), localPageable.getPageSize()).append(getSearchProperty(), localPageable.getSearchProperty()).append(getSearchValue(), localPageable.getSearchValue()).append(getOrderProperty(), localPageable.getOrderProperty()).append(getOrderDirection(), localPageable.getOrderDirection()).append(getFilters(), localPageable.getFilters()).append(getOrders(), localPageable.getOrders()).isEquals();
  }

  public int hashCode()
  {
    return new HashCodeBuilder(17, 37).append(getPageNumber()).append(getPageSize()).append(getSearchProperty()).append(getSearchValue()).append(getOrderProperty()).append(getOrderDirection()).append(getFilters()).append(getOrders()).toHashCode();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.Pageable
 * JD-Core Version:    0.6.2
 */