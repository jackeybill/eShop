package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.ParameterDao;
import net.shopxx.entity.Parameter;
import net.shopxx.service.ParameterService;
import org.springframework.stereotype.Service;

@Service("parameterServiceImpl")
public class ParameterServiceImpl extends BaseServiceImpl<Parameter, Long>
  implements ParameterService
{
  @Resource(name="parameterDaoImpl")
  public void setBaseDao(ParameterDao parameterDao)
  {
    super.setBaseDao(parameterDao);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.ParameterServiceImpl
 * JD-Core Version:    0.6.2
 */