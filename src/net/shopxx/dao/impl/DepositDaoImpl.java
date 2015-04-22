package net.shopxx.dao.impl;

import java.util.Collections;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.DepositDao;
import net.shopxx.entity.Deposit;
import net.shopxx.entity.Member;
import org.springframework.stereotype.Repository;

@Repository("depositDaoImpl")
public class DepositDaoImpl extends BaseDaoImpl<Deposit, Long>
  implements DepositDao
{
  public Page<Deposit> findPage(Member member, Pageable pageable)
  {
    if (member == null)
      return new Page(Collections.emptyList(), 0L, pageable);
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Deposit.class);
    Root localRoot = localCriteriaQuery.from(Deposit.class);
    localCriteriaQuery.select(localRoot);
    localCriteriaQuery.where(localCriteriaBuilder.equal(localRoot.get("member"), member));
    return super.IIIllIlI(localCriteriaQuery, pageable);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.DepositDaoImpl
 * JD-Core Version:    0.6.2
 */