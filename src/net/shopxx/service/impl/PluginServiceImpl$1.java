package net.shopxx.service.impl;

import net.shopxx.plugin.PaymentPlugin;
import org.apache.commons.collections.Predicate;

class PluginServiceImpl$1
  implements Predicate
{
  PluginServiceImpl$1(PluginServiceImpl paramPluginServiceImpl, boolean paramBoolean)
  {
  }

  public boolean evaluate(Object object)
  {
    PaymentPlugin localPaymentPlugin = (PaymentPlugin)object;
    return localPaymentPlugin.getIsEnabled() == this.IIIllIll;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.PluginServiceImpl.1
 * JD-Core Version:    0.6.2
 */