package net.shopxx.service.impl;

import freemarker.template.TemplateModelException;
import javax.annotation.Resource;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.config.DiskStoreConfiguration;
import net.shopxx.service.CacheService;
import net.shopxx.util.SettingUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Service("cacheServiceImpl")
public class CacheServiceImpl
  implements CacheService
{

  @Resource(name="ehCacheManager")
  private CacheManager IIIllIlI;

  @Resource(name="messageSource")
  private ReloadableResourceBundleMessageSource IIIllIll;

  @Resource(name="freeMarkerConfigurer")
  private FreeMarkerConfigurer IIIlllII;

  public String getDiskStorePath()
  {
    return this.IIIllIlI.getConfiguration().getDiskStoreConfiguration().getPath();
  }

  public int getCacheSize()
  {
    int i = 0;
    String[] arrayOfString1 = this.IIIllIlI.getCacheNames();
    if (arrayOfString1 != null)
      for (String str : arrayOfString1)
      {
        Ehcache localEhcache = this.IIIllIlI.getEhcache(str);
        if (localEhcache != null)
          i += localEhcache.getSize();
      }
    return i;
  }

  @CacheEvict(value={"setting", "authorization", "logConfig", "template", "shipping", "area", "seo", "adPosition", "memberAttribute", "navigation", "tag", "friendLink", "brand", "article", "articleCategory", "product", "productCategory", "review", "consultation", "promotion"}, allEntries=true)
  public void clear()
  {
    this.IIIllIll.clearCache();
    try
    {
      this.IIIlllII.getConfiguration().setSharedVariable("setting", SettingUtils.get());
    }
    catch (TemplateModelException localTemplateModelException)
    {
      localTemplateModelException.printStackTrace();
    }
    this.IIIlllII.getConfiguration().clearTemplateCache();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.CacheServiceImpl
 * JD-Core Version:    0.6.2
 */