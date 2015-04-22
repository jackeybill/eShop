package net.shopxx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T>
  implements Serializable
{
  private static final long serialVersionUID = -2053800594583879853L;
  private final List<T> IIIllIlI = new ArrayList();
  private final long IIIllIll;
  private final Pageable IIIlllII;

  public Page()
  {
    this.IIIllIll = 0L;
    this.IIIlllII = new Pageable();
  }

  public Page(List<T> content, long total, Pageable pageable)
  {
    this.IIIllIlI.addAll(content);
    this.IIIllIll = total;
    this.IIIlllII = pageable;
  }

  public int getPageNumber()
  {
    return this.IIIlllII.getPageNumber();
  }

  public int getPageSize()
  {
    return this.IIIlllII.getPageSize();
  }

  public String getSearchProperty()
  {
    return this.IIIlllII.getSearchProperty();
  }

  public String getSearchValue()
  {
    return this.IIIlllII.getSearchValue();
  }

  public String getOrderProperty()
  {
    return this.IIIlllII.getOrderProperty();
  }

  public Order.Direction getOrderDirection()
  {
    return this.IIIlllII.getOrderDirection();
  }

  public List<Order> getOrders()
  {
    return this.IIIlllII.getOrders();
  }

  public List<Filter> getFilters()
  {
    return this.IIIlllII.getFilters();
  }

  public int getTotalPages()
  {
    return (int)Math.ceil(getTotal() / getPageSize());
  }

  public List<T> getContent()
  {
    return this.IIIllIlI;
  }

  public long getTotal()
  {
    return this.IIIllIll;
  }

  public Pageable getPageable()
  {
    return this.IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.Page
 * JD-Core Version:    0.6.2
 */