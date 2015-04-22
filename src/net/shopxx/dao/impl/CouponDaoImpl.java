package net.shopxx.dao.impl;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.CouponDao;
import net.shopxx.entity.Coupon;
import org.springframework.stereotype.Repository;

@Repository("couponDaoImpl")
public class CouponDaoImpl extends BaseDaoImpl<Coupon, Long>
  implements CouponDao
{
  public Page<Coupon> findPage(Boolean isEnabled, Boolean isExchange, Boolean hasExpired, Pageable pageable)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Coupon.class);
    Root localRoot = localCriteriaQuery.from(Coupon.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    if (isEnabled != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isEnabled"), isEnabled));
    if (isExchange != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isExchange"), isExchange));
    if (hasExpired != null)
      if (hasExpired.booleanValue())
        localPredicate = localCriteriaBuilder.and(new Predicate[] { localPredicate, localRoot.get("endDate").isNotNull(), localCriteriaBuilder.lessThan(localRoot.get("endDate"), new Date()) });
      else
        localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localRoot.get("endDate").isNull(), localCriteriaBuilder.greaterThanOrEqualTo(localRoot.get("endDate"), new Date())));
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, pageable);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.CouponDaoImpl
 * JD-Core Version:    0.6.2
 */