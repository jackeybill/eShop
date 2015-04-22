package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.PluginConfigDao;
import net.shopxx.entity.PluginConfig;
import net.shopxx.service.PluginConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("pluginConfigServiceImpl")
public class PluginConfigServiceImpl extends BaseServiceImpl<PluginConfig, Long>
  implements PluginConfigService
{

  @Resource(name="pluginConfigDaoImpl")
  private PluginConfigDao IIIllIlI;

  @Resource(name="pluginConfigDaoImpl")
  public void setBaseDao(PluginConfigDao pluginConfigDao)
  {
    super.setBaseDao(pluginConfigDao);
  }

  @Transactional(readOnly=true)
  public boolean pluginIdExists(String pluginId)
  {
    return this.IIIllIlI.pluginIdExists(pluginId);
  }

  @Transactional(readOnly=true)
  public PluginConfig findByPluginId(String pluginId)
  {
    return this.IIIllIlI.findByPluginId(pluginId);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.PluginConfigServiceImpl
 * JD-Core Version:    0.6.2
 */