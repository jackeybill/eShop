package net.shopxx.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import net.shopxx.dao.NavigationDao;
import net.shopxx.entity.Navigation;
import net.shopxx.entity.Navigation.Position;
import org.springframework.stereotype.Repository;

@Repository("navigationDaoImpl")
public class NavigationDaoImpl extends BaseDaoImpl<Navigation, Long>
  implements NavigationDao
{
  public List<Navigation> findList(Navigation.Position position)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Navigation.class);
    Root localRoot = localCriteriaQuery.from(Navigation.class);
    localCriteriaQuery.select(localRoot);
    if (position != null)
      localCriteriaQuery.where(localCriteriaBuilder.equal(localRoot.get("position"), position));
    localCriteriaQuery.orderBy(new Order[] { localCriteriaBuilder.asc(localRoot.get("order")) });
    return this.IIIllIlI.createQuery(localCriteriaQuery).setFlushMode(FlushModeType.COMMIT).getResultList();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.NavigationDaoImpl
 * JD-Core Version:    0.6.2
 */