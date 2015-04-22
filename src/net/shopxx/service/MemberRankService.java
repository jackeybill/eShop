package net.shopxx.service;

import java.math.BigDecimal;
import net.shopxx.entity.MemberRank;

public abstract interface MemberRankService extends BaseService<MemberRank, Long>
{
  public abstract boolean nameExists(String paramString);

  public abstract boolean nameUnique(String paramString1, String paramString2);

  public abstract boolean amountExists(BigDecimal paramBigDecimal);

  public abstract boolean amountUnique(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2);

  public abstract MemberRank findDefault();

  public abstract MemberRank findByAmount(BigDecimal paramBigDecimal);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.MemberRankService
 * JD-Core Version:    0.6.2
 */