package net.shopxx.job;

import javax.annotation.Resource;
import net.shopxx.service.StaticService;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("staticJob")
@Lazy(false)
public class StaticJob
{

  @Resource(name="staticServiceImpl")
  private StaticService IIIllIlI;

  @Scheduled(cron="${job.static_build.cron}")
  public void build()
  {
    this.IIIllIlI.buildAll();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.job.StaticJob
 * JD-Core Version:    0.6.2
 */