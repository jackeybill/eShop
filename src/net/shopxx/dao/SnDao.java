package net.shopxx.dao;

import net.shopxx.entity.Sn.Type;

public abstract interface SnDao
{
  public abstract String generate(Sn.Type paramType);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.SnDao
 * JD-Core Version:    0.6.2
 */