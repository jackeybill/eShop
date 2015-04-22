package net.shopxx.dao;

import java.util.List;
import net.shopxx.entity.FriendLink;
import net.shopxx.entity.FriendLink.Type;

public abstract interface FriendLinkDao extends BaseDao<FriendLink, Long>
{
  public abstract List<FriendLink> findList(FriendLink.Type paramType);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.FriendLinkDao
 * JD-Core Version:    0.6.2
 */