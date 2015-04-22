package net.shopxx.service;

import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.entity.ProductNotify;

public abstract interface ProductNotifyService extends BaseService<ProductNotify, Long>
{
  public abstract boolean exists(Product paramProduct, String paramString);

  public abstract Page<ProductNotify> findPage(Member paramMember, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Pageable paramPageable);

  public abstract Long count(Member paramMember, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3);

  public abstract int send(Long[] paramArrayOfLong);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.ProductNotifyService
 * JD-Core Version:    0.6.2
 */