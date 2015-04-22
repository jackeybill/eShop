package net.shopxx.dao;

import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Member;
import net.shopxx.entity.Receiver;

public abstract interface ReceiverDao extends BaseDao<Receiver, Long>
{
  public abstract Receiver findDefault(Member paramMember);

  public abstract Page<Receiver> findPage(Member paramMember, Pageable paramPageable);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.ReceiverDao
 * JD-Core Version:    0.6.2
 */