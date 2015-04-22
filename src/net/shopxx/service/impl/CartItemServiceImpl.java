package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.CartItemDao;
import net.shopxx.entity.CartItem;
import net.shopxx.service.CartItemService;
import org.springframework.stereotype.Service;

@Service("cartItemServiceImpl")
public class CartItemServiceImpl extends BaseServiceImpl<CartItem, Long>
  implements CartItemService
{
  @Resource(name="cartItemDaoImpl")
  public void setBaseDao(CartItemDao cartItemDao)
  {
    super.setBaseDao(cartItemDao);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.CartItemServiceImpl
 * JD-Core Version:    0.6.2
 */