package net.shopxx.service;

public abstract interface CacheService
{
  public abstract String getDiskStorePath();

  public abstract int getCacheSize();

  public abstract void clear();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.CacheService
 * JD-Core Version:    0.6.2
 */