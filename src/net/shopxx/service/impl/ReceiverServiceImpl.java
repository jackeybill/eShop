package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.ReceiverDao;
import net.shopxx.entity.Member;
import net.shopxx.entity.Receiver;
import net.shopxx.service.ReceiverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("receiverServiceImpl")
public class ReceiverServiceImpl extends BaseServiceImpl<Receiver, Long>
  implements ReceiverService
{

  @Resource(name="receiverDaoImpl")
  private ReceiverDao IIIllIlI;

  @Resource(name="receiverDaoImpl")
  public void setBaseDao(ReceiverDao receiverDao)
  {
    super.setBaseDao(receiverDao);
  }

  @Transactional(readOnly=true)
  public Receiver findDefault(Member member)
  {
    return this.IIIllIlI.findDefault(member);
  }

  @Transactional(readOnly=true)
  public Page<Receiver> findPage(Member member, Pageable pageable)
  {
    return this.IIIllIlI.findPage(member, pageable);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.ReceiverServiceImpl
 * JD-Core Version:    0.6.2
 */