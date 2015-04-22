package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.DepositDao;
import net.shopxx.entity.Deposit;
import net.shopxx.entity.Member;
import net.shopxx.service.DepositService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("depositServiceImpl")
public class DepositServiceImpl extends BaseServiceImpl<Deposit, Long>
  implements DepositService
{

  @Resource(name="depositDaoImpl")
  private DepositDao IIIllIlI;

  @Resource(name="depositDaoImpl")
  public void setBaseDao(DepositDao depositDao)
  {
    super.setBaseDao(depositDao);
  }

  @Transactional(readOnly=true)
  public Page<Deposit> findPage(Member member, Pageable pageable)
  {
    return this.IIIllIlI.findPage(member, pageable);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.DepositServiceImpl
 * JD-Core Version:    0.6.2
 */