package net.shopxx.entity;

import org.apache.commons.collections.Predicate;

class Cart$1
  implements Predicate
{
  Cart$1(Cart paramCart, GiftItem paramGiftItem)
  {
  }

  public boolean evaluate(Object object)
  {
    GiftItem localGiftItem = (GiftItem)object;
    return (localGiftItem != null) && (localGiftItem.getGift().equals(this.IIIllIll.getGift()));
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Cart.1
 * JD-Core Version:    0.6.2
 */