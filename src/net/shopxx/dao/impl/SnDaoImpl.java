package net.shopxx.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import net.shopxx.dao.SnDao;
import net.shopxx.entity.Sn;
import net.shopxx.entity.Sn.Type;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository("snDaoImpl")
public class SnDaoImpl
  implements SnDao, InitializingBean
{
  private SnDaoImpl.HiloOptimizer IIIllIlI;
  private SnDaoImpl.HiloOptimizer IIIllIll;
  private SnDaoImpl.HiloOptimizer IIIlllII;
  private SnDaoImpl.HiloOptimizer IIIlllIl;
  private SnDaoImpl.HiloOptimizer IIIllllI;
  private SnDaoImpl.HiloOptimizer IIIlllll;

  @PersistenceContext
  private EntityManager IIlIIIII;

  @Value("${sn.product.prefix}")
  private String IIlIIIIl;

  @Value("${sn.product.maxLo}")
  private int IIlIIIlI;

  @Value("${sn.order.prefix}")
  private String IIlIIIll;

  @Value("${sn.order.maxLo}")
  private int IIlIIlII;

  @Value("${sn.payment.prefix}")
  private String IIlIIlIl;

  @Value("${sn.payment.maxLo}")
  private int IIlIIllI;

  @Value("${sn.refunds.prefix}")
  private String IIlIIlll;

  @Value("${sn.refunds.maxLo}")
  private int IIlIlIII;

  @Value("${sn.shipping.prefix}")
  private String IIlIlIIl;

  @Value("${sn.shipping.maxLo}")
  private int IIlIlIlI;

  @Value("${sn.returns.prefix}")
  private String IIlIlIll;

  @Value("${sn.returns.maxLo}")
  private int IIlIllII;

  public void afterPropertiesSet()
  {
    this.IIIllIlI = new SnDaoImpl.HiloOptimizer(this, Sn.Type.product, this.IIlIIIIl, this.IIlIIIlI);
    this.IIIllIll = new SnDaoImpl.HiloOptimizer(this, Sn.Type.order, this.IIlIIIll, this.IIlIIlII);
    this.IIIlllII = new SnDaoImpl.HiloOptimizer(this, Sn.Type.payment, this.IIlIIlIl, this.IIlIIllI);
    this.IIIlllIl = new SnDaoImpl.HiloOptimizer(this, Sn.Type.refunds, this.IIlIIlll, this.IIlIlIII);
    this.IIIllllI = new SnDaoImpl.HiloOptimizer(this, Sn.Type.shipping, this.IIlIlIIl, this.IIlIlIlI);
    this.IIIlllll = new SnDaoImpl.HiloOptimizer(this, Sn.Type.returns, this.IIlIlIll, this.IIlIllII);
  }

  public String generate(Sn.Type type)
  {
    Assert.notNull(type);
    if (type == Sn.Type.product)
      return this.IIIllIlI.generate();
    if (type == Sn.Type.order)
      return this.IIIllIll.generate();
    if (type == Sn.Type.payment)
      return this.IIIlllII.generate();
    if (type == Sn.Type.refunds)
      return this.IIIlllIl.generate();
    if (type == Sn.Type.shipping)
      return this.IIIllllI.generate();
    if (type == Sn.Type.returns)
      return this.IIIlllll.generate();
    return null;
  }

  private long IIIllIlI(Sn.Type paramType)
  {
    String str = "select sn from Sn sn where sn.type = :type";
    Sn localSn = (Sn)this.IIlIIIII.createQuery(str, Sn.class).setFlushMode(FlushModeType.COMMIT).setParameter("type", paramType).setLockMode(LockModeType.PESSIMISTIC_WRITE).getSingleResult();
    long l = localSn.getLastValue().longValue();
    localSn.setLastValue(Long.valueOf(l + 1L));
    this.IIlIIIII.merge(localSn);
    return l;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.SnDaoImpl
 * JD-Core Version:    0.6.2
 */