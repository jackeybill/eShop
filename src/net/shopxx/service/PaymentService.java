package net.shopxx.service;

import net.shopxx.entity.Payment;

public abstract interface PaymentService extends BaseService<Payment, Long>
{
  public abstract Payment findBySn(String paramString);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.PaymentService
 * JD-Core Version:    0.6.2
 */