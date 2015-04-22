package net.shopxx.service;

import java.util.List;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.entity.FriendLink;
import net.shopxx.entity.FriendLink.Type;

public abstract interface FriendLinkService extends BaseService<FriendLink, Long>
{
  public abstract List<FriendLink> findList(FriendLink.Type paramType);

  public abstract List<FriendLink> findList(Integer paramInteger, List<Filter> paramList, List<Order> paramList1, String paramString);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.FriendLinkService
 * JD-Core Version:    0.6.2
 */