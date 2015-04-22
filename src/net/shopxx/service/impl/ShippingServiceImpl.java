package net.shopxx.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import net.shopxx.Setting;
import net.shopxx.dao.ShippingDao;
import net.shopxx.entity.Shipping;
import net.shopxx.service.ShippingService;
import net.shopxx.util.SettingUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("shippingServiceImpl")
public class ShippingServiceImpl extends BaseServiceImpl<Shipping, Long>
  implements ShippingService
{

  @Resource(name="shippingDaoImpl")
  private ShippingDao IIIllIlI;

  @Resource(name="shippingDaoImpl")
  public void setBaseDao(ShippingDao shippingDao)
  {
    super.setBaseDao(shippingDao);
  }

  @Transactional(readOnly=true)
  public Shipping findBySn(String sn)
  {
    return this.IIIllIlI.findBySn(sn);
  }

  @Transactional(readOnly=true)
  @Cacheable({"shipping"})
  public Map<String, Object> query(Shipping shipping)
  {
    Setting localSetting = SettingUtils.get();
    Object localObject = new HashMap();
    if ((shipping != null) && (StringUtils.isNotEmpty(localSetting.getKuaidi100Key())) && (StringUtils.isNotEmpty(shipping.getDeliveryCorpCode())) && (StringUtils.isNotEmpty(shipping.getTrackingNo())))
      try
      {
        ObjectMapper localObjectMapper = new ObjectMapper();
        URL localURL = new URL("http://api.kuaidi100.com/api?id=" + localSetting.getKuaidi100Key() + "&com=" + shipping.getDeliveryCorpCode() + "&nu=" + shipping.getTrackingNo() + "&show=0&muti=1&order=asc");
        localObject = (Map)localObjectMapper.readValue(localURL, Map.class);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    return localObject;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.ShippingServiceImpl
 * JD-Core Version:    0.6.2
 */