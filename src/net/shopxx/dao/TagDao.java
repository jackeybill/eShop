package net.shopxx.dao;

import java.util.List;
import net.shopxx.entity.Tag;
import net.shopxx.entity.Tag.Type;

public abstract interface TagDao extends BaseDao<Tag, Long>
{
  public abstract List<Tag> findList(Tag.Type paramType);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.TagDao
 * JD-Core Version:    0.6.2
 */