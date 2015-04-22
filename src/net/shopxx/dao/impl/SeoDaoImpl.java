package net.shopxx.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import net.shopxx.dao.SeoDao;
import net.shopxx.entity.Seo;
import net.shopxx.entity.Seo.Type;
import org.springframework.stereotype.Repository;

@Repository("seoDaoImpl")
public class SeoDaoImpl extends BaseDaoImpl<Seo, Long>
  implements SeoDao
{
  public Seo find(Seo.Type type)
  {
    if (type == null)
      return null;
    try
    {
      String str = "select seo from Seo seo where seo.type = :type";
      return (Seo)this.IIIllIlI.createQuery(str, Seo.class).setFlushMode(FlushModeType.COMMIT).setParameter("type", type).getSingleResult();
    }
    catch (NoResultException localNoResultException1)
    {
    }
    return null;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.SeoDaoImpl
 * JD-Core Version:    0.6.2
 */