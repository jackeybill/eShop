package net.shopxx.dao;

import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Coupon;

public abstract interface CouponDao extends BaseDao<Coupon, Long>
{
  public abstract Page<Coupon> findPage(Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Pageable paramPageable);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.CouponDao
 * JD-Core Version:    0.6.2
 */