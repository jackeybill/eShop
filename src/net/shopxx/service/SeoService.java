package net.shopxx.service;

import net.shopxx.entity.Seo;
import net.shopxx.entity.Seo.Type;

public abstract interface SeoService extends BaseService<Seo, Long>
{
  public abstract Seo find(Seo.Type paramType);

  public abstract Seo find(Seo.Type paramType, String paramString);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.SeoService
 * JD-Core Version:    0.6.2
 */