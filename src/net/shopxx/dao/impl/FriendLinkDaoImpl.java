package net.shopxx.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import net.shopxx.dao.FriendLinkDao;
import net.shopxx.entity.FriendLink;
import net.shopxx.entity.FriendLink.Type;
import org.springframework.stereotype.Repository;

@Repository("friendLinkDaoImpl")
public class FriendLinkDaoImpl extends BaseDaoImpl<FriendLink, Long>
  implements FriendLinkDao
{
  public List<FriendLink> findList(FriendLink.Type type)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(FriendLink.class);
    Root localRoot = localCriteriaQuery.from(FriendLink.class);
    localCriteriaQuery.select(localRoot);
    if (type != null)
      localCriteriaQuery.where(localCriteriaBuilder.equal(localRoot.get("type"), type));
    localCriteriaQuery.orderBy(new Order[] { localCriteriaBuilder.asc(localRoot.get("order")) });
    return this.IIIllIlI.createQuery(localCriteriaQuery).setFlushMode(FlushModeType.COMMIT).getResultList();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.FriendLinkDaoImpl
 * JD-Core Version:    0.6.2
 */