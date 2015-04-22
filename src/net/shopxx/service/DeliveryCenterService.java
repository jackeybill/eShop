package net.shopxx.service;

import net.shopxx.entity.DeliveryCenter;

public abstract interface DeliveryCenterService extends BaseService<DeliveryCenter, Long>
{
  public abstract DeliveryCenter findDefault();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.DeliveryCenterService
 * JD-Core Version:    0.6.2
 */