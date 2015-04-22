package net.shopxx.service.impl;

import net.shopxx.plugin.StoragePlugin;
import org.apache.commons.collections.Predicate;

class PluginServiceImpl$2
  implements Predicate
{
  PluginServiceImpl$2(PluginServiceImpl paramPluginServiceImpl, boolean paramBoolean)
  {
  }

  public boolean evaluate(Object object)
  {
    StoragePlugin localStoragePlugin = (StoragePlugin)object;
    return localStoragePlugin.getIsEnabled() == this.IIIllIll;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.PluginServiceImpl.2
 * JD-Core Version:    0.6.2
 */