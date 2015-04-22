package net.shopxx.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import net.shopxx.dao.GoodsDao;
import net.shopxx.dao.ProductDao;
import net.shopxx.entity.Goods;
import net.shopxx.entity.Product;
import net.shopxx.service.GoodsService;
import net.shopxx.service.StaticService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service("goodsServiceImpl")
public class GoodsServiceImpl extends BaseServiceImpl<Goods, Long>
  implements GoodsService
{

  @Resource(name="goodsDaoImpl")
  private GoodsDao IIIllIlI;

  @Resource(name="productDaoImpl")
  private ProductDao IIIllIll;

  @Resource(name="staticServiceImpl")
  private StaticService IIIlllII;

  @Resource(name="goodsDaoImpl")
  public void setBaseDao(GoodsDao goodsDao)
  {
    super.setBaseDao(goodsDao);
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public void save(Goods goods)
  {
    Assert.notNull(goods);
    super.save(goods);
    this.IIIllIlI.flush();
    if (goods.getProducts() != null)
    {
      Iterator localIterator = goods.getProducts().iterator();
      while (localIterator.hasNext())
      {
        Product localProduct = (Product)localIterator.next();
        this.IIIlllII.build(localProduct);
      }
    }
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public Goods update(Goods goods)
  {
    Assert.notNull(goods);
    HashSet localHashSet = new HashSet();
    CollectionUtils.select(goods.getProducts(), new GoodsServiceImpl.1(this), localHashSet);
    List localList = this.IIIllIll.findList(goods, localHashSet);
    Object localObject2 = localList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Product)((Iterator)localObject2).next();
      this.IIIlllII.delete((Product)localObject1);
    }
    Object localObject1 = (Goods)super.update(goods);
    this.IIIllIlI.flush();
    if (((Goods)localObject1).getProducts() != null)
    {
      Iterator localIterator = ((Goods)localObject1).getProducts().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Product)localIterator.next();
        this.IIIlllII.build((Product)localObject2);
      }
    }
    return localObject1;
  }

  @Transactional
  @CacheEvict(value={"product", "productCategory", "review", "consultation"}, allEntries=true)
  public Goods update(Goods goods, String[] ignoreProperties)
  {
    return (Goods)super.update(goods, ignoreProperties);
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
  public void delete(Goods goods)
  {
    if ((goods != null) && (goods.getProducts() != null))
    {
      Iterator localIterator = goods.getProducts().iterator();
      while (localIterator.hasNext())
      {
        Product localProduct = (Product)localIterator.next();
        this.IIIlllII.delete(localProduct);
      }
    }
    super.delete(goods);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.GoodsServiceImpl
 * JD-Core Version:    0.6.2
 */