package net.shopxx.dao;

import net.shopxx.entity.DeliveryTemplate;

public abstract interface DeliveryTemplateDao extends BaseDao<DeliveryTemplate, Long>
{
  public abstract DeliveryTemplate findDefault();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.DeliveryTemplateDao
 * JD-Core Version:    0.6.2
 */