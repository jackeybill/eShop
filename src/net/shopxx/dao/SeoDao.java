package net.shopxx.dao;

import net.shopxx.entity.Seo;
import net.shopxx.entity.Seo.Type;

public abstract interface SeoDao extends BaseDao<Seo, Long>
{
  public abstract Seo find(Seo.Type paramType);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.SeoDao
 * JD-Core Version:    0.6.2
 */