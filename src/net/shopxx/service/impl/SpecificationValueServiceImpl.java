package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.SpecificationValueDao;
import net.shopxx.entity.SpecificationValue;
import net.shopxx.service.SpecificationValueService;
import org.springframework.stereotype.Service;

@Service("specificationValueServiceImpl")
public class SpecificationValueServiceImpl extends BaseServiceImpl<SpecificationValue, Long>
  implements SpecificationValueService
{
  @Resource(name="specificationValueDaoImpl")
  public void setBaseDao(SpecificationValueDao specificationValueDao)
  {
    super.setBaseDao(specificationValueDao);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.SpecificationValueServiceImpl
 * JD-Core Version:    0.6.2
 */