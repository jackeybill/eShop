package net.shopxx.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import net.shopxx.dao.AreaDao;
import net.shopxx.entity.Area;
import org.springframework.stereotype.Repository;

@Repository("areaDaoImpl")
public class AreaDaoImpl extends BaseDaoImpl<Area, Long>
  implements AreaDao
{
  public List<Area> findRoots(Integer count)
  {
    String str = "select area from Area area where area.parent is null order by area.order asc";
    TypedQuery localTypedQuery = this.IIIllIlI.createQuery(str, Area.class).setFlushMode(FlushModeType.COMMIT);
    if (count != null)
      localTypedQuery.setMaxResults(count.intValue());
    return localTypedQuery.getResultList();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.AreaDaoImpl
 * JD-Core Version:    0.6.2
 */