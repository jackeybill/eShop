package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.SnDao;
import net.shopxx.entity.Sn.Type;
import net.shopxx.service.SnService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("snServiceImpl")
public class SnServiceImpl
  implements SnService
{

  @Resource(name="snDaoImpl")
  private SnDao IIIllIlI;

  @Transactional
  public String generate(Sn.Type type)
  {
    return this.IIIllIlI.generate(type);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.SnServiceImpl
 * JD-Core Version:    0.6.2
 */