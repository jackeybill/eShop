package net.shopxx.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import net.shopxx.dao.GoodsDao;
import net.shopxx.dao.ProductDao;
import net.shopxx.dao.SnDao;
import net.shopxx.entity.Goods;
import net.shopxx.entity.Product;
import net.shopxx.entity.Sn.Type;
import net.shopxx.entity.SpecificationValue;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository("goodsDaoImpl")
public class GoodsDaoImpl extends BaseDaoImpl<Goods, Long>
  implements GoodsDao
{

  @Resource(name="productDaoImpl")
  private ProductDao IIIllIll;

  @Resource(name="snDaoImpl")
  private SnDao IIIlllII;

  public void persist(Goods goods)
  {
    Assert.notNull(goods);
    if (goods.getProducts() != null)
    {
      Iterator localIterator = goods.getProducts().iterator();
      while (localIterator.hasNext())
      {
        Product localProduct = (Product)localIterator.next();
        IIIllIlI(localProduct);
      }
    }
    super.persist(goods);
  }

  public Goods merge(Goods goods)
  {
    Assert.notNull(goods);
    if (goods.getProducts() != null)
    {
      Iterator localIterator = goods.getProducts().iterator();
      while (localIterator.hasNext())
      {
        Product localProduct = (Product)localIterator.next();
        if (localProduct.getId() != null)
        {
          String str;
          if (!localProduct.getIsGift().booleanValue())
          {
            str = "delete from GiftItem giftItem where giftItem.gift = :product";
            this.IIIllIlI.createQuery(str).setFlushMode(FlushModeType.COMMIT).setParameter("product", localProduct).executeUpdate();
          }
          if ((!localProduct.getIsMarketable().booleanValue()) || (localProduct.getIsGift().booleanValue()))
          {
            str = "delete from CartItem cartItem where cartItem.product = :product";
            this.IIIllIlI.createQuery(str).setFlushMode(FlushModeType.COMMIT).setParameter("product", localProduct).executeUpdate();
          }
        }
        IIIllIlI(localProduct);
      }
    }
    return (Goods)super.merge(goods);
  }

  private void IIIllIlI(Product paramProduct)
  {
    if (paramProduct == null)
      return;
    if (StringUtils.isEmpty(paramProduct.getSn()))
    {
      do
        localObject = this.IIIlllII.generate(Sn.Type.product);
      while (this.IIIllIll.snExists((String)localObject));
      paramProduct.setSn((String)localObject);
    }
    Object localObject = new StringBuffer(paramProduct.getName());
    if ((paramProduct.getSpecificationValues() != null) && (!paramProduct.getSpecificationValues().isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramProduct.getSpecificationValues());
      Collections.sort(localArrayList, new GoodsDaoImpl.1(this));
      ((StringBuffer)localObject).append("[");
      int i = 0;
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        if (i != 0)
          ((StringBuffer)localObject).append(" ");
        ((StringBuffer)localObject).append(((SpecificationValue)localIterator.next()).getName());
        i++;
      }
      ((StringBuffer)localObject).append("]");
    }
    paramProduct.setFullName(((StringBuffer)localObject).toString());
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.GoodsDaoImpl
 * JD-Core Version:    0.6.2
 */