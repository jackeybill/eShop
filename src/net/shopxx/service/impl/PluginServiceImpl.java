package net.shopxx.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.shopxx.plugin.PaymentPlugin;
import net.shopxx.plugin.StoragePlugin;
import net.shopxx.service.PluginService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

@Service("pluginServiceImpl")
public class PluginServiceImpl
  implements PluginService
{

  @Resource
  private List<PaymentPlugin> IIIllIlI = new ArrayList();

  @Resource
  private List<StoragePlugin> IIIllIll = new ArrayList();

  @Resource
  private Map<String, PaymentPlugin> IIIlllII = new HashMap();

  @Resource
  private Map<String, StoragePlugin> IIIlllIl = new HashMap();

  public List<PaymentPlugin> getPaymentPlugins()
  {
    Collections.sort(this.IIIllIlI);
    return this.IIIllIlI;
  }

  public List<StoragePlugin> getStoragePlugins()
  {
    Collections.sort(this.IIIllIll);
    return this.IIIllIll;
  }

  public List<PaymentPlugin> getPaymentPlugins(boolean isEnabled)
  {
    ArrayList localArrayList = new ArrayList();
    CollectionUtils.select(this.IIIllIlI, new PluginServiceImpl.1(this, isEnabled), localArrayList);
    Collections.sort(localArrayList);
    return localArrayList;
  }

  public List<StoragePlugin> getStoragePlugins(boolean isEnabled)
  {
    ArrayList localArrayList = new ArrayList();
    CollectionUtils.select(this.IIIllIll, new PluginServiceImpl.2(this, isEnabled), localArrayList);
    Collections.sort(localArrayList);
    return localArrayList;
  }

  public PaymentPlugin getPaymentPlugin(String id)
  {
    return (PaymentPlugin)this.IIIlllII.get(id);
  }

  public StoragePlugin getStoragePlugin(String id)
  {
    return (StoragePlugin)this.IIIlllIl.get(id);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.PluginServiceImpl
 * JD-Core Version:    0.6.2
 */