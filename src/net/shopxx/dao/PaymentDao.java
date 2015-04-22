package net.shopxx.dao;

import net.shopxx.entity.Payment;

public abstract interface PaymentDao extends BaseDao<Payment, Long>
{
  public abstract Payment findBySn(String paramString);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.PaymentDao
 * JD-Core Version:    0.6.2
 */