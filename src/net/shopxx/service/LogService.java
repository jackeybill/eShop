package net.shopxx.service;

import net.shopxx.entity.Log;

public abstract interface LogService extends BaseService<Log, Long>
{
  public abstract void clear();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.LogService
 * JD-Core Version:    0.6.2
 */