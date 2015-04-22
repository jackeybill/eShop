package net.shopxx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.dao.PromotionDao;
import net.shopxx.entity.Promotion;
import net.shopxx.service.PromotionService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("promotionServiceImpl")
public class PromotionServiceImpl extends BaseServiceImpl<Promotion, Long>
  implements PromotionService
{

  @Resource(name="promotionDaoImpl")
  private PromotionDao IIIllIlI;

  @Resource(name="promotionDaoImpl")
  public void setBaseDao(PromotionDao promotionDao)
  {
    super.setBaseDao(promotionDao);
  }

  @Transactional(readOnly=true)
  public List<Promotion> findList(Boolean hasBegun, Boolean hasEnded, Integer count, List<Filter> filters, List<Order> orders)
  {
    return this.IIIllIlI.findList(hasBegun, hasEnded, count, filters, orders);
  }

  @Transactional(readOnly=true)
  @Cacheable({"promotion"})
  public List<Promotion> findList(Boolean hasBegun, Boolean hasEnded, Integer count, List<Filter> filters, List<Order> orders, String cacheRegion)
  {
    return this.IIIllIlI.findList(hasBegun, hasEnded, count, filters, orders);
  }

  @Transactional
  @CacheEvict(value={"promotion", "product"}, allEntries=true)
  public void save(Promotion promotion)
  {
    super.save(promotion);
  }

  @Transactional
  @CacheEvict(value={"promotion", "product"}, allEntries=true)
  public Promotion update(Promotion promotion)
  {
    return (Promotion)super.update(promotion);
  }

  @Transactional
  @CacheEvict(value={"promotion", "product"}, allEntries=true)
  public Promotion update(Promotion promotion, String[] ignoreProperties)
  {
    return (Promotion)super.update(promotion, ignoreProperties);
  }

  @Transactional
  @CacheEvict(value={"promotion", "product"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }

  @Transactional
  @CacheEvict(value={"promotion", "product"}, allEntries=true)
  public void delete(Long[] ids)
  {
    super.delete(ids);
  }

  @Transactional
  @CacheEvict(value={"promotion", "product"}, allEntries=true)
  public void delete(Promotion promotion)
  {
    super.delete(promotion);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.PromotionServiceImpl
 * JD-Core Version:    0.6.2
 */