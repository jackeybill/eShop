package net.shopxx.service.impl;

import net.shopxx.entity.Product;
import org.apache.commons.collections.Predicate;

class GoodsServiceImpl$1
  implements Predicate
{
  GoodsServiceImpl$1(GoodsServiceImpl paramGoodsServiceImpl)
  {
  }

  public boolean evaluate(Object object)
  {
    Product localProduct = (Product)object;
    return (localProduct != null) && (localProduct.getId() != null);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.GoodsServiceImpl.1
 * JD-Core Version:    0.6.2
 */