package net.shopxx.service;

import net.shopxx.entity.DeliveryTemplate;

public abstract interface DeliveryTemplateService extends BaseService<DeliveryTemplate, Long>
{
  public abstract DeliveryTemplate findDefault();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.DeliveryTemplateService
 * JD-Core Version:    0.6.2
 */