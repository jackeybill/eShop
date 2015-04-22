package net.shopxx.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.ConsultationDao;
import net.shopxx.entity.Consultation;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import org.springframework.stereotype.Repository;

@Repository("consultationDaoImpl")
public class ConsultationDaoImpl extends BaseDaoImpl<Consultation, Long>
  implements ConsultationDao
{
  public List<Consultation> findList(Member member, Product product, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Consultation.class);
    Root localRoot = localCriteriaQuery.from(Consultation.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.isNull(localRoot.get("forConsultation")));
    if (member != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("member"), member));
    if (product != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("product"), product));
    if (isShow != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isShow"), isShow));
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, null, count, filters, orders);
  }

  public Page<Consultation> findPage(Member member, Product product, Boolean isShow, Pageable pageable)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Consultation.class);
    Root localRoot = localCriteriaQuery.from(Consultation.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.isNull(localRoot.get("forConsultation")));
    if (member != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("member"), member));
    if (product != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("product"), product));
    if (isShow != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isShow"), isShow));
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, pageable);
  }

  public Long count(Member member, Product product, Boolean isShow)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Consultation.class);
    Root localRoot = localCriteriaQuery.from(Consultation.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.isNull(localRoot.get("forConsultation")));
    if (member != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("member"), member));
    if (product != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("product"), product));
    if (isShow != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isShow"), isShow));
    localCriteriaQuery.where(localPredicate);
    return super.IIIllIlI(localCriteriaQuery, null);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.ConsultationDaoImpl
 * JD-Core Version:    0.6.2
 */