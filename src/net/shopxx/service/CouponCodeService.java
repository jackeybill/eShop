package net.shopxx.service;

import java.util.List;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Coupon;
import net.shopxx.entity.CouponCode;
import net.shopxx.entity.Member;

public abstract interface CouponCodeService extends BaseService<CouponCode, Long>
{
  public abstract boolean codeExists(String paramString);

  public abstract CouponCode findByCode(String paramString);

  public abstract CouponCode build(Coupon paramCoupon, Member paramMember);

  public abstract List<CouponCode> build(Coupon paramCoupon, Member paramMember, Integer paramInteger);

  public abstract CouponCode exchange(Coupon paramCoupon, Member paramMember);

  public abstract Page<CouponCode> findPage(Member paramMember, Pageable paramPageable);

  public abstract Long count(Coupon paramCoupon, Member paramMember, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.CouponCodeService
 * JD-Core Version:    0.6.2
 */