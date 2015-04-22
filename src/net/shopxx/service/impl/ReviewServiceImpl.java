package net.shopxx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.ProductDao;
import net.shopxx.dao.ReviewDao;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.entity.Review;
import net.shopxx.entity.Review.Type;
import net.shopxx.service.ReviewService;
import net.shopxx.service.StaticService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("reviewServiceImpl")
public class ReviewServiceImpl extends BaseServiceImpl<Review, Long>
  implements ReviewService
{

  @Resource(name="reviewDaoImpl")
  private ReviewDao IIIllIlI;

  @Resource(name="productDaoImpl")
  private ProductDao IIIllIll;

  @Resource(name="staticServiceImpl")
  private StaticService IIIlllII;

  @Resource(name="reviewDaoImpl")
  public void setBaseDao(ReviewDao reviewDao)
  {
    super.setBaseDao(reviewDao);
  }

  @Transactional(readOnly=true)
  public List<Review> findList(Member member, Product product, Review.Type type, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders)
  {
    return this.IIIllIlI.findList(member, product, type, isShow, count, filters, orders);
  }

  @Transactional(readOnly=true)
  @Cacheable({"review"})
  public List<Review> findList(Member member, Product product, Review.Type type, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders, String cacheRegion)
  {
    return this.IIIllIlI.findList(member, product, type, isShow, count, filters, orders);
  }

  @Transactional(readOnly=true)
  public Page<Review> findPage(Member member, Product product, Review.Type type, Boolean isShow, Pageable pageable)
  {
    return this.IIIllIlI.findPage(member, product, type, isShow, pageable);
  }

  @Transactional(readOnly=true)
  public Long count(Member member, Product product, Review.Type type, Boolean isShow)
  {
    return this.IIIllIlI.count(member, product, type, isShow);
  }

  @Transactional(readOnly=true)
  public boolean isReviewed(Member member, Product product)
  {
    return this.IIIllIlI.isReviewed(member, product);
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public void save(Review review)
  {
    super.save(review);
    Product localProduct = review.getProduct();
    if (localProduct != null)
    {
      this.IIIllIlI.flush();
      long l1 = this.IIIllIlI.calculateTotalScore(localProduct);
      long l2 = this.IIIllIlI.calculateScoreCount(localProduct);
      localProduct.setTotalScore(Long.valueOf(l1));
      localProduct.setScoreCount(Long.valueOf(l2));
      this.IIIllIll.merge(localProduct);
      this.IIIllIlI.flush();
      this.IIIlllII.build(localProduct);
    }
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public Review update(Review review)
  {
    Review localReview = (Review)super.update(review);
    Product localProduct = localReview.getProduct();
    if (localProduct != null)
    {
      this.IIIllIlI.flush();
      long l1 = this.IIIllIlI.calculateTotalScore(localProduct);
      long l2 = this.IIIllIlI.calculateScoreCount(localProduct);
      localProduct.setTotalScore(Long.valueOf(l1));
      localProduct.setScoreCount(Long.valueOf(l2));
      this.IIIllIll.merge(localProduct);
      this.IIIllIlI.flush();
      this.IIIlllII.build(localProduct);
    }
    return localReview;
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public Review update(Review review, String[] ignoreProperties)
  {
    return (Review)super.update(review, ignoreProperties);
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public void delete(Long[] ids)
  {
    super.delete(ids);
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public void delete(Review review)
  {
    if (review != null)
    {
      super.delete(review);
      Product localProduct = review.getProduct();
      if (localProduct != null)
      {
        this.IIIllIlI.flush();
        long l1 = this.IIIllIlI.calculateTotalScore(localProduct);
        long l2 = this.IIIllIlI.calculateScoreCount(localProduct);
        localProduct.setTotalScore(Long.valueOf(l1));
        localProduct.setScoreCount(Long.valueOf(l2));
        this.IIIllIll.merge(localProduct);
        this.IIIllIlI.flush();
        this.IIIlllII.build(localProduct);
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.ReviewServiceImpl
 * JD-Core Version:    0.6.2
 */