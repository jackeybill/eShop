package net.shopxx.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import net.shopxx.dao.LogDao;
import net.shopxx.entity.Log;
import org.springframework.stereotype.Repository;

@Repository("logDaoImpl")
public class LogDaoImpl extends BaseDaoImpl<Log, Long>
  implements LogDao
{
  public void removeAll()
  {
    String str = "delete from Log log";
    this.IIIllIlI.createQuery(str).setFlushMode(FlushModeType.COMMIT).executeUpdate();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.LogDaoImpl
 * JD-Core Version:    0.6.2
 */