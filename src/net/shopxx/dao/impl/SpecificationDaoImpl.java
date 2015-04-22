package net.shopxx.dao.impl;

import net.shopxx.dao.SpecificationDao;
import net.shopxx.entity.Specification;
import org.springframework.stereotype.Repository;

@Repository("specificationDaoImpl")
public class SpecificationDaoImpl extends BaseDaoImpl<Specification, Long>
  implements SpecificationDao
{
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.SpecificationDaoImpl
 * JD-Core Version:    0.6.2
 */