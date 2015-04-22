package net.shopxx.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import net.shopxx.dao.PaymentDao;
import net.shopxx.entity.Payment;
import org.springframework.stereotype.Repository;

@Repository("paymentDaoImpl")
public class PaymentDaoImpl extends BaseDaoImpl<Payment, Long>
  implements PaymentDao
{
  public Payment findBySn(String sn)
  {
    if (sn == null)
      return null;
    String str = "select payment from Payment payment where lower(payment.sn) = lower(:sn)";
    try
    {
      return (Payment)this.IIIllIlI.createQuery(str, Payment.class).setFlushMode(FlushModeType.COMMIT).setParameter("sn", sn).getSingleResult();
    }
    catch (NoResultException localNoResultException)
    {
    }
    return null;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.PaymentDaoImpl
 * JD-Core Version:    0.6.2
 */