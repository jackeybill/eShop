package net.shopxx.dao.impl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import net.shopxx.Filter;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.ArticleDao;
import net.shopxx.entity.Article;
import net.shopxx.entity.ArticleCategory;
import net.shopxx.entity.Tag;
import org.springframework.stereotype.Repository;

@Repository("articleDaoImpl")
public class ArticleDaoImpl extends BaseDaoImpl<Article, Long>
  implements ArticleDao
{
  public List<Article> findList(ArticleCategory articleCategory, List<Tag> tags, Integer count, List<Filter> filters, List<net.shopxx.Order> orders)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Article.class);
    Root localRoot = localCriteriaQuery.from(Article.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isPublication"), Boolean.valueOf(true)));
    if (articleCategory != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localCriteriaBuilder.equal(localRoot.get("articleCategory"), articleCategory), localCriteriaBuilder.like(localRoot.get("articleCategory").get("treePath"), "%," + articleCategory.getId() + "," + "%")));
    if ((tags != null) && (!tags.isEmpty()))
    {
      localPredicate = localCriteriaBuilder.and(localPredicate, localRoot.join("tags").in(tags));
      localCriteriaQuery.distinct(true);
    }
    localCriteriaQuery.where(localPredicate);
    localCriteriaQuery.orderBy(new javax.persistence.criteria.Order[] { localCriteriaBuilder.desc(localRoot.get("isTop")) });
    return super.IIIllIlI(localCriteriaQuery, null, count, filters, orders);
  }

  public List<Article> findList(ArticleCategory articleCategory, Date beginDate, Date endDate, Integer first, Integer count)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Article.class);
    Root localRoot = localCriteriaQuery.from(Article.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isPublication"), Boolean.valueOf(true)));
    if (articleCategory != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localCriteriaBuilder.equal(localRoot.get("articleCategory"), articleCategory), localCriteriaBuilder.like(localRoot.get("articleCategory").get("treePath"), "%," + articleCategory.getId() + "," + "%")));
    if (beginDate != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.greaterThanOrEqualTo(localRoot.get("createDate"), beginDate));
    if (endDate != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.lessThanOrEqualTo(localRoot.get("createDate"), endDate));
    localCriteriaQuery.where(localPredicate);
    localCriteriaQuery.orderBy(new javax.persistence.criteria.Order[] { localCriteriaBuilder.desc(localRoot.get("isTop")) });
    return super.IIIllIlI(localCriteriaQuery, first, count, null, null);
  }

  public Page<Article> findPage(ArticleCategory articleCategory, List<Tag> tags, Pageable pageable)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Article.class);
    Root localRoot = localCriteriaQuery.from(Article.class);
    localCriteriaQuery.select(localRoot);
    Predicate localPredicate = localCriteriaBuilder.conjunction();
    localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get("isPublication"), Boolean.valueOf(true)));
    if (articleCategory != null)
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.or(localCriteriaBuilder.equal(localRoot.get("articleCategory"), articleCategory), localCriteriaBuilder.like(localRoot.get("articleCategory").get("treePath"), "%," + articleCategory.getId() + "," + "%")));
    if ((tags != null) && (!tags.isEmpty()))
    {
      localPredicate = localCriteriaBuilder.and(localPredicate, localRoot.join("tags").in(tags));
      localCriteriaQuery.distinct(true);
    }
    localCriteriaQuery.where(localPredicate);
    localCriteriaQuery.orderBy(new javax.persistence.criteria.Order[] { localCriteriaBuilder.desc(localRoot.get("isTop")) });
    return super.IIIllIlI(localCriteriaQuery, pageable);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.ArticleDaoImpl
 * JD-Core Version:    0.6.2
 */