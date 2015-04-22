package net.shopxx.dao.impl;

import net.shopxx.entity.Parameter;
import org.apache.commons.collections.Predicate;

class ParameterGroupDaoImpl$1
  implements Predicate
{
  ParameterGroupDaoImpl$1(ParameterGroupDaoImpl paramParameterGroupDaoImpl)
  {
  }

  public boolean evaluate(Object object)
  {
    Parameter localParameter = (Parameter)object;
    return (localParameter != null) && (localParameter.getId() != null);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.ParameterGroupDaoImpl.1
 * JD-Core Version:    0.6.2
 */