package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.DeliveryCenterDao;
import net.shopxx.entity.DeliveryCenter;
import net.shopxx.service.DeliveryCenterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("deliveryCenterServiceImpl")
public class DeliveryCenterServiceImpl extends BaseServiceImpl<DeliveryCenter, Long>
  implements DeliveryCenterService
{

  @Resource(name="deliveryCenterDaoImpl")
  private DeliveryCenterDao IIIllIlI;

  @Resource(name="deliveryCenterDaoImpl")
  public void setBaseDao(DeliveryCenterDao DeliveryCenterDao)
  {
    super.setBaseDao(DeliveryCenterDao);
  }

  @Transactional(readOnly=true)
  public DeliveryCenter findDefault()
  {
    return this.IIIllIlI.findDefault();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.DeliveryCenterServiceImpl
 * JD-Core Version:    0.6.2
 */