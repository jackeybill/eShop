package net.shopxx.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.ReviewDao;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.entity.Review;
import net.shopxx.entity.Review.Type;
import org.springframework.stereotype.Repository;

@Repository("reviewDaoImpl")
public class ReviewDaoImpl extends BaseDaoImpl<Review, Long>
  implements ReviewDao
{
  public List<Review> findList(Member member, Product product, Review.Type type, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Review.class);
    Root localRoot = localCriteriaQuery.from(Review.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    if (member != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("member"), member));
    if (product != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("product"), product));
    if (type == Review.Type.positive)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.ge(localRoot.get("score"), Integer.valueOf(4)));
    else if (type == Review.Type.moderate)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("score"), Integer.valueOf(3)));
    else if (type == Review.Type.negative)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.le(localRoot.get("score"), Integer.valueOf(2)));
    if (isShow != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isShow"), isShow));
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, null, count, filters, orders);
  }

  public Page<Review> findPage(Member member, Product product, Review.Type type, Boolean isShow, Pageable pageable)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Review.class);
    Root localRoot = localCriteriaQuery.from(Review.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    if (member != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("member"), member));
    if (product != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("product"), product));
    if (type == Review.Type.positive)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.ge(localRoot.get("score"), Integer.valueOf(4)));
    else if (type == Review.Type.moderate)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("score"), Integer.valueOf(3)));
    else if (type == Review.Type.negative)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.le(localRoot.get("score"), Integer.valueOf(2)));
    if (isShow != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isShow"), isShow));
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, pageable);
  }

  public Long count(Member member, Product product, Review.Type type, Boolean isShow)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Review.class);
    Root localRoot = localCriteriaQuery.from(Review.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    if (member != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("member"), member));
    if (product != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("product"), product));
    if (type == Review.Type.positive)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.ge(localRoot.get("score"), Integer.valueOf(4)));
    else if (type == Review.Type.moderate)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("score"), Integer.valueOf(3)));
    else if (type == Review.Type.negative)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.le(localRoot.get("score"), Integer.valueOf(2)));
    if (isShow != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isShow"), isShow));
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, null);
  }

  public boolean isReviewed(Member member, Product product)
  {
    if ((member == null) || (product == null))
      return false;
    String str = "select count(*) from Review review where review.member = :member and review.product = :product";
    Long localLong = (Long)this.IIIllIlI.createQuery(str, Long.class).setFlushMode(FlushModeType.COMMIT).setParameter("member", member).setParameter("product", product).getSingleResult();
    return localLong.longValue() > 0L;
  }

  public long calculateTotalScore(Product product)
  {
    if (product == null)
      return 0L;
    String str = "select sum(review.score) from Review review where review.product = :product and review.isShow = :isShow";
    Long localLong = (Long)this.IIIllIlI.createQuery(str, Long.class).setFlushMode(FlushModeType.COMMIT).setParameter("product", product).setParameter("isShow", Boolean.valueOf(true)).getSingleResult();
    return localLong != null ? localLong.longValue() : 0L;
  }

  public long calculateScoreCount(Product product)
  {
    if (product == null)
      return 0L;
    String str = "select count(*) from Review review where review.product = :product and review.isShow = :isShow";
    return ((Long)this.IIIllIlI.createQuery(str, Long.class).setFlushMode(FlushModeType.COMMIT).setParameter("product", product).setParameter("isShow", Boolean.valueOf(true)).getSingleResult()).longValue();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.ReviewDaoImpl
 * JD-Core Version:    0.6.2
 */