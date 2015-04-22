package net.shopxx.service;

import net.shopxx.entity.Cart;
import net.shopxx.entity.Member;

public abstract interface CartService extends BaseService<Cart, Long>
{
  public abstract Cart getCurrent();

  public abstract void merge(Member paramMember, Cart paramCart);

  public abstract void evictExpired();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.CartService
 * JD-Core Version:    0.6.2
 */