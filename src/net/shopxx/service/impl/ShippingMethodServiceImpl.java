package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.ShippingMethodDao;
import net.shopxx.entity.ShippingMethod;
import net.shopxx.service.ShippingMethodService;
import org.springframework.stereotype.Service;

@Service("shippingMethodServiceImpl")
public class ShippingMethodServiceImpl extends BaseServiceImpl<ShippingMethod, Long>
  implements ShippingMethodService
{
  @Resource(name="shippingMethodDaoImpl")
  public void setBaseDao(ShippingMethodDao shippingMethodDao)
  {
    super.setBaseDao(shippingMethodDao);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.ShippingMethodServiceImpl
 * JD-Core Version:    0.6.2
 */