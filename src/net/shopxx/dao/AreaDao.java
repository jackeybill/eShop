package net.shopxx.dao;

import java.util.List;
import net.shopxx.entity.Area;

public abstract interface AreaDao extends BaseDao<Area, Long>
{
  public abstract List<Area> findRoots(Integer paramInteger);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.AreaDao
 * JD-Core Version:    0.6.2
 */