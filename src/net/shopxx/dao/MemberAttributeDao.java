package net.shopxx.dao;

import java.util.List;
import net.shopxx.entity.MemberAttribute;

public abstract interface MemberAttributeDao extends BaseDao<MemberAttribute, Long>
{
  public abstract Integer findUnusedPropertyIndex();

  public abstract List<MemberAttribute> findList();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.MemberAttributeDao
 * JD-Core Version:    0.6.2
 */