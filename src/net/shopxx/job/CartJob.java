package net.shopxx.job;

import javax.annotation.Resource;
import net.shopxx.service.CartService;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("cartJob")
@Lazy(false)
public class CartJob
{

  @Resource(name="cartServiceImpl")
  private CartService IIIllIlI;

  @Scheduled(cron="${job.cart_evict_expired.cron}")
  public void evictExpired()
  {
    this.IIIllIlI.evictExpired();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.job.CartJob
 * JD-Core Version:    0.6.2
 */