package net.shopxx.service;

import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Deposit;
import net.shopxx.entity.Member;

public abstract interface DepositService extends BaseService<Deposit, Long>
{
  public abstract Page<Deposit> findPage(Member paramMember, Pageable paramPageable);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.DepositService
 * JD-Core Version:    0.6.2
 */