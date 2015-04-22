package net.shopxx.dao;

import net.shopxx.entity.DeliveryCenter;

public abstract interface DeliveryCenterDao extends BaseDao<DeliveryCenter, Long>
{
  public abstract DeliveryCenter findDefault();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.DeliveryCenterDao
 * JD-Core Version:    0.6.2
 */