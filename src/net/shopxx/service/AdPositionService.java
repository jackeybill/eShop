package net.shopxx.service;

import net.shopxx.entity.AdPosition;

public abstract interface AdPositionService extends BaseService<AdPosition, Long>
{
  public abstract AdPosition find(Long paramLong, String paramString);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.AdPositionService
 * JD-Core Version:    0.6.2
 */