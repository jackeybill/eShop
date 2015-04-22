package net.shopxx.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.LockModeType;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.ProductDao;
import net.shopxx.entity.Attribute;
import net.shopxx.entity.Brand;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.entity.Product.OrderType;
import net.shopxx.entity.ProductCategory;
import net.shopxx.entity.Promotion;
import net.shopxx.entity.Tag;
import net.shopxx.service.ProductService;
import net.shopxx.service.StaticService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service("productServiceImpl")
public class ProductServiceImpl extends BaseServiceImpl<Product, Long>
  implements ProductService, DisposableBean
{
  private long IIIllIlI = System.currentTimeMillis();

  @Resource(name="ehCacheManager")
  private CacheManager IIIllIll;

  @Resource(name="productDaoImpl")
  private ProductDao IIIlllII;

  @Resource(name="staticServiceImpl")
  private StaticService IIIlllIl;

  @Resource(name="productDaoImpl")
  public void setBaseDao(ProductDao productDao)
  {
    super.setBaseDao(productDao);
  }

  @Transactional(readOnly=true)
  public boolean snExists(String sn)
  {
    return this.IIIlllII.snExists(sn);
  }

  @Transactional(readOnly=true)
  public Product findBySn(String sn)
  {
    return this.IIIlllII.findBySn(sn);
  }

  @Transactional(readOnly=true)
  public boolean snUnique(String previousSn, String currentSn)
  {
    if (StringUtils.equalsIgnoreCase(previousSn, currentSn))
      return true;
    return !this.IIIlllII.snExists(currentSn);
  }

  @Transactional(readOnly=true)
  public List<Product> search(String keyword, Boolean isGift, Integer count)
  {
    return this.IIIlllII.search(keyword, isGift, count);
  }

  @Transactional(readOnly=true)
  public List<Product> findList(ProductCategory productCategory, Brand brand, Promotion promotion, List<Tag> tags, Map<Attribute, String> attributeValue, BigDecimal startPrice, BigDecimal endPrice, Boolean isMarketable, Boolean isList, Boolean isTop, Boolean isGift, Boolean isOutOfStock, Boolean isStockAlert, Product.OrderType orderType, Integer count, List<Filter> filters, List<Order> orders)
  {
    return this.IIIlllII.findList(productCategory, brand, promotion, tags, attributeValue, startPrice, endPrice, isMarketable, isList, isTop, isGift, isOutOfStock, isStockAlert, orderType, count, filters, orders);
  }

  @Transactional(readOnly=true)
  @Cacheable({"product"})
  public List<Product> findList(ProductCategory productCategory, Brand brand, Promotion promotion, List<Tag> tags, Map<Attribute, String> attributeValue, BigDecimal startPrice, BigDecimal endPrice, Boolean isMarketable, Boolean isList, Boolean isTop, Boolean isGift, Boolean isOutOfStock, Boolean isStockAlert, Product.OrderType orderType, Integer count, List<Filter> filters, List<Order> orders, String cacheRegion)
  {
    return this.IIIlllII.findList(productCategory, brand, promotion, tags, attributeValue, startPrice, endPrice, isMarketable, isList, isTop, isGift, isOutOfStock, isStockAlert, orderType, count, filters, orders);
  }

  @Transactional(readOnly=true)
  public List<Product> findList(ProductCategory productCategory, Date beginDate, Date endDate, Integer first, Integer count)
  {
    return this.IIIlllII.findList(productCategory, beginDate, endDate, first, count);
  }

  @Transactional(readOnly=true)
  public Page<Product> findPage(ProductCategory productCategory, Brand brand, Promotion promotion, List<Tag> tags, Map<Attribute, String> attributeValue, BigDecimal startPrice, BigDecimal endPrice, Boolean isMarketable, Boolean isList, Boolean isTop, Boolean isGift, Boolean isOutOfStock, Boolean isStockAlert, Product.OrderType orderType, Pageable pageable)
  {
    return this.IIIlllII.findPage(productCategory, brand, promotion, tags, attributeValue, startPrice, endPrice, isMarketable, isList, isTop, isGift, isOutOfStock, isStockAlert, orderType, pageable);
  }

  @Transactional(readOnly=true)
  public Page<Product> findPage(Member member, Pageable pageable)
  {
    return this.IIIlllII.findPage(member, pageable);
  }

  @Transactional(readOnly=true)
  public Page<Object> findSalesPage(Date beginDate, Date endDate, Pageable pageable)
  {
    return this.IIIlllII.findSalesPage(beginDate, endDate, pageable);
  }

  @Transactional(readOnly=true)
  public Long count(Member favoriteMember, Boolean isMarketable, Boolean isList, Boolean isTop, Boolean isGift, Boolean isOutOfStock, Boolean isStockAlert)
  {
    return this.IIIlllII.count(favoriteMember, isMarketable, isList, isTop, isGift, isOutOfStock, isStockAlert);
  }

  @Transactional(readOnly=true)
  public boolean isPurchased(Member member, Product product)
  {
    return this.IIIlllII.isPurchased(member, product);
  }

  public long viewHits(Long id)
  {
    Ehcache localEhcache = this.IIIllIll.getEhcache("productHits");
    Element localElement = localEhcache.get(id);
    if (localElement != null)
    {
      localLong = (Long)localElement.getObjectValue();
    }
    else
    {
      Product localProduct = (Product)this.IIIlllII.find(id);
      if (localProduct == null)
        return 0L;
      localLong = localProduct.getHits();
    }
    Long localLong = Long.valueOf(localLong.longValue() + 1L);
    localEhcache.put(new Element(id, localLong));
    long l = System.currentTimeMillis();
    if (l > this.IIIllIlI + 600000L)
    {
      this.IIIllIlI = l;
      IIIllIlI();
      localEhcache.removeAll();
    }
    return localLong.longValue();
  }

  public void destroy()
  {
    IIIllIlI();
  }

  private void IIIllIlI()
  {
    Ehcache localEhcache = this.IIIllIll.getEhcache("productHits");
    List localList = localEhcache.getKeys();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      Product localProduct = (Product)this.IIIlllII.find(localLong);
      if (localProduct != null)
      {
        this.IIIlllII.lock(localProduct, LockModeType.PESSIMISTIC_WRITE);
        Element localElement = localEhcache.get(localLong);
        long l1 = ((Long)localElement.getObjectValue()).longValue();
        long l2 = l1 - localProduct.getHits().longValue();
        Calendar localCalendar1 = Calendar.getInstance();
        Calendar localCalendar2 = DateUtils.toCalendar(localProduct.getWeekHitsDate());
        Calendar localCalendar3 = DateUtils.toCalendar(localProduct.getMonthHitsDate());
        if ((localCalendar1.get(1) != localCalendar2.get(1)) || (localCalendar1.get(3) > localCalendar2.get(3)))
          localProduct.setWeekHits(Long.valueOf(l2));
        else
          localProduct.setWeekHits(Long.valueOf(localProduct.getWeekHits().longValue() + l2));
        if ((localCalendar1.get(1) != localCalendar3.get(1)) || (localCalendar1.get(2) > localCalendar3.get(2)))
          localProduct.setMonthHits(Long.valueOf(l2));
        else
          localProduct.setMonthHits(Long.valueOf(localProduct.getMonthHits().longValue() + l2));
        localProduct.setHits(Long.valueOf(l1));
        localProduct.setWeekHitsDate(new Date());
        localProduct.setMonthHitsDate(new Date());
        this.IIIlllII.merge(localProduct);
      }
    }
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public void save(Product product)
  {
    Assert.notNull(product);
    super.save(product);
    this.IIIlllII.flush();
    this.IIIlllIl.build(product);
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public Product update(Product product)
  {
    Assert.notNull(product);
    Product localProduct = (Product)super.update(product);
    this.IIIlllII.flush();
    this.IIIlllIl.build(localProduct);
    return localProduct;
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public Product update(Product product, String[] ignoreProperties)
  {
    return (Product)super.update(product, ignoreProperties);
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
  public void delete(Product product)
  {
    if (product != null)
      this.IIIlllIl.delete(product);
    super.delete(product);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.ProductServiceImpl
 * JD-Core Version:    0.6.2
 */