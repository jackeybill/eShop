package net.shopxx.service;

import java.util.List;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.entity.Tag;
import net.shopxx.entity.Tag.Type;

public abstract interface TagService extends BaseService<Tag, Long>
{
  public abstract List<Tag> findList(Tag.Type paramType);

  public abstract List<Tag> findList(Integer paramInteger, List<Filter> paramList, List<Order> paramList1, String paramString);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.TagService
 * JD-Core Version:    0.6.2
 */