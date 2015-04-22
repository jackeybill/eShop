package net.shopxx.dao;

import net.shopxx.entity.Log;

public abstract interface LogDao extends BaseDao<Log, Long>
{
  public abstract void removeAll();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.LogDao
 * JD-Core Version:    0.6.2
 */