package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.ParameterGroupDao;
import net.shopxx.entity.ParameterGroup;
import net.shopxx.service.ParameterGroupService;
import org.springframework.stereotype.Service;

@Service("parameterGroupServiceImpl")
public class ParameterGroupServiceImpl extends BaseServiceImpl<ParameterGroup, Long>
  implements ParameterGroupService
{
  @Resource(name="parameterGroupDaoImpl")
  public void setBaseDao(ParameterGroupDao parameterGroupDao)
  {
    super.setBaseDao(parameterGroupDao);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.ParameterGroupServiceImpl
 * JD-Core Version:    0.6.2
 */