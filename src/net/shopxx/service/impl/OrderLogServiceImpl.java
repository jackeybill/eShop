package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.OrderLogDao;
import net.shopxx.entity.OrderLog;
import net.shopxx.service.OrderLogService;
import org.springframework.stereotype.Service;

@Service("orderLogServiceImpl")
public class OrderLogServiceImpl extends BaseServiceImpl<OrderLog, Long>
  implements OrderLogService
{
  @Resource(name="orderLogDaoImpl")
  public void setBaseDao(OrderLogDao orderLogDao)
  {
    super.setBaseDao(orderLogDao);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.OrderLogServiceImpl
 * JD-Core Version:    0.6.2
 */