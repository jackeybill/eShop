package net.shopxx.service;

import java.util.List;
import net.shopxx.plugin.PaymentPlugin;
import net.shopxx.plugin.StoragePlugin;

public abstract interface PluginService
{
  public abstract List<PaymentPlugin> getPaymentPlugins();

  public abstract List<StoragePlugin> getStoragePlugins();

  public abstract List<PaymentPlugin> getPaymentPlugins(boolean paramBoolean);

  public abstract List<StoragePlugin> getStoragePlugins(boolean paramBoolean);

  public abstract PaymentPlugin getPaymentPlugin(String paramString);

  public abstract StoragePlugin getStoragePlugin(String paramString);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.PluginService
 * JD-Core Version:    0.6.2
 */