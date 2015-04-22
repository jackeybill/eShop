package net.shopxx.dao;

import java.math.BigDecimal;
import net.shopxx.entity.MemberRank;

public abstract interface MemberRankDao extends BaseDao<MemberRank, Long>
{
  public abstract boolean nameExists(String paramString);

  public abstract boolean amountExists(BigDecimal paramBigDecimal);

  public abstract MemberRank findDefault();

  public abstract MemberRank findByAmount(BigDecimal paramBigDecimal);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.MemberRankDao
 * JD-Core Version:    0.6.2
 */