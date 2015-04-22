package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.RefundsDao;
import net.shopxx.entity.Refunds;
import net.shopxx.service.RefundsService;
import org.springframework.stereotype.Service;

@Service("refundsServiceImpl")
public class RefundsServiceImpl extends BaseServiceImpl<Refunds, Long>
  implements RefundsService
{
  @Resource(name="refundsDaoImpl")
  public void setBaseDao(RefundsDao refundsDao)
  {
    super.setBaseDao(refundsDao);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.RefundsServiceImpl
 * JD-Core Version:    0.6.2
 */