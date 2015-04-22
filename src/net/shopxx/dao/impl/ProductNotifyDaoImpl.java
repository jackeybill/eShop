package net.shopxx.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.ProductNotifyDao;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.entity.ProductNotify;
import org.springframework.stereotype.Repository;

@Repository("productNotifyDaoImpl")
public class ProductNotifyDaoImpl extends BaseDaoImpl<ProductNotify, Long>
  implements ProductNotifyDao
{
  public boolean exists(Product product, String email)
  {
    String str = "select count(*) from ProductNotify productNotify where productNotify.product = :product and lower(productNotify.email) = lower(:email) and productNotify.hasSent = false";
    Long localLong = (Long)this.IIIllIlI.createQuery(str, Long.class).setFlushMode(FlushModeType.COMMIT).setParameter("product", product).setParameter("email", email).getSingleResult();
    return localLong.longValue() > 0L;
  }

  public Page<ProductNotify> findPage(Member member, Boolean isMarketable, Boolean isOutOfStock, Boolean hasSent, Pageable pageable)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(ProductNotify.class);
    Root localRoot = localCriteriaQuery.from(ProductNotify.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    if (member != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("member"), member));
    if (isMarketable != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("product").get("isMarketable"), isMarketable));
    if (isOutOfStock != null)
    {
      Path localPath1 = localRoot.get("product").get("stock");
      Path localPath2 = localRoot.get("product").get("allocatedStock");
      if (isOutOfStock.booleanValue())
        localPredicate = localCriteriaBuilder.and(new Predicate[] { localPredicate, localCriteriaBuilder.isNotNull(localPath1), localCriteriaBuilder.lessThanOrEqualTo(localPath1, localPath2) });
      else
        localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localCriteriaBuilder.isNull(localPath1), localCriteriaBuilder.greaterThan(localPath1, localPath2)));
    }
    if (hasSent != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("hasSent"), hasSent));
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, pageable);
  }

  public Long count(Member member, Boolean isMarketable, Boolean isOutOfStock, Boolean hasSent)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(ProductNotify.class);
    Root localRoot = localCriteriaQuery.from(ProductNotify.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    if (member != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("member"), member));
    if (isMarketable != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("product").get("isMarketable"), isMarketable));
    if (isOutOfStock != null)
    {
      Path localPath1 = localRoot.get("product").get("stock");
      Path localPath2 = localRoot.get("product").get("allocatedStock");
      if (isOutOfStock.booleanValue())
        localPredicate = localCriteriaBuilder.and(new Predicate[] { localPredicate, localCriteriaBuilder.isNotNull(localPath1), localCriteriaBuilder.lessThanOrEqualTo(localPath1, localPath2) });
      else
        localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localCriteriaBuilder.isNull(localPath1), localCriteriaBuilder.greaterThan(localPath1, localPath2)));
    }
    if (hasSent != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("hasSent"), hasSent));
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, null);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.ProductNotifyDaoImpl
 * JD-Core Version:    0.6.2
 */