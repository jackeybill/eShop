package net.shopxx.listener;

import java.io.File;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import net.shopxx.service.CacheService;
import net.shopxx.service.SearchService;
import net.shopxx.service.StaticService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

@Component("initListener")
public class InitListener
  implements ApplicationListener<ContextRefreshedEvent>, ServletContextAware
{
  private static final String IIIllIlI = "/install_init.conf";
  private ServletContext IIIllIll;

  @Resource(name="staticServiceImpl")
  private StaticService IIIlllII;

  @Resource(name="cacheServiceImpl")
  private CacheService IIIlllIl;

  @Resource(name="searchServiceImpl")
  private SearchService IIIllllI;

  public void setServletContext(ServletContext servletContext)
  {
    this.IIIllIll = servletContext;
  }

  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
  {
    if ((this.IIIllIll != null) && (contextRefreshedEvent.getApplicationContext().getParent() == null))
    {
      File localFile = new File(this.IIIllIll.getRealPath("/install_init.conf"));
      if (localFile.exists())
      {
        this.IIIlllIl.clear();
        this.IIIlllII.buildAll();
        this.IIIllllI.purge();
        this.IIIllllI.index();
        localFile.delete();
      }
      else
      {
        this.IIIlllII.buildIndex();
        this.IIIlllII.buildOther();
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.listener.InitListener
 * JD-Core Version:    0.6.2
 */