package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.PaymentMethodDao;
import net.shopxx.entity.PaymentMethod;
import net.shopxx.service.PaymentMethodService;
import org.springframework.stereotype.Service;

@Service("paymentMethodServiceImpl")
public class PaymentMethodServiceImpl extends BaseServiceImpl<PaymentMethod, Long>
  implements PaymentMethodService
{
  @Resource(name="paymentMethodDaoImpl")
  public void setBaseDao(PaymentMethodDao paymentMethodDao)
  {
    super.setBaseDao(paymentMethodDao);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.PaymentMethodServiceImpl
 * JD-Core Version:    0.6.2
 */