package net.shopxx.service;

import java.util.List;
import net.shopxx.entity.Admin;

public abstract interface AdminService extends BaseService<Admin, Long>
{
  public abstract boolean usernameExists(String paramString);

  public abstract Admin findByUsername(String paramString);

  public abstract List<String> findAuthorities(Long paramLong);

  public abstract boolean isAuthenticated();

  public abstract Admin getCurrent();

  public abstract String getCurrentUsername();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.AdminService
 * JD-Core Version:    0.6.2
 */