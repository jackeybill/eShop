package net.shopxx.dao;

import java.util.List;
import net.shopxx.entity.Navigation;
import net.shopxx.entity.Navigation.Position;

public abstract interface NavigationDao extends BaseDao<Navigation, Long>
{
  public abstract List<Navigation> findList(Navigation.Position paramPosition);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.NavigationDao
 * JD-Core Version:    0.6.2
 */