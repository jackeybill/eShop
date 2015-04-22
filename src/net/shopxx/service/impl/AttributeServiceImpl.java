package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.AttributeDao;
import net.shopxx.entity.Attribute;
import net.shopxx.service.AttributeService;
import org.springframework.stereotype.Service;

@Service("attributeServiceImpl")
public class AttributeServiceImpl extends BaseServiceImpl<Attribute, Long>
  implements AttributeService
{
  @Resource(name="attributeDaoImpl")
  public void setBaseDao(AttributeDao attributeDao)
  {
    super.setBaseDao(attributeDao);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.AttributeServiceImpl
 * JD-Core Version:    0.6.2
 */