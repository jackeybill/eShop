package net.shopxx.dao;

import net.shopxx.entity.Admin;

public abstract interface AdminDao extends BaseDao<Admin, Long>
{
  public abstract boolean usernameExists(String paramString);

  public abstract Admin findByUsername(String paramString);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.AdminDao
 * JD-Core Version:    0.6.2
 */