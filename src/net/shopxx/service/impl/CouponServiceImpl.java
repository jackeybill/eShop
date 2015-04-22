package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.CouponDao;
import net.shopxx.entity.Coupon;
import net.shopxx.service.CouponService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("couponServiceImpl")
public class CouponServiceImpl extends BaseServiceImpl<Coupon, Long>
  implements CouponService
{

  @Resource(name="couponDaoImpl")
  private CouponDao IIIllIlI;

  @Resource(name="couponDaoImpl")
  public void setBaseDao(CouponDao couponDao)
  {
    super.setBaseDao(couponDao);
  }

  @Transactional(readOnly=true)
  public Page<Coupon> findPage(Boolean isEnabled, Boolean isExchange, Boolean hasExpired, Pageable pageable)
  {
    return this.IIIllIlI.findPage(isEnabled, isExchange, hasExpired, pageable);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.CouponServiceImpl
 * JD-Core Version:    0.6.2
 */