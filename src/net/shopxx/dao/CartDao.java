package net.shopxx.dao;

import net.shopxx.entity.Cart;

public abstract interface CartDao extends BaseDao<Cart, Long>
{
  public abstract void evictExpired();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.CartDao
 * JD-Core Version:    0.6.2
 */