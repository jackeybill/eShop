package net.shopxx.dao.impl;

import java.util.Comparator;
import net.shopxx.entity.SpecificationValue;
import org.apache.commons.lang.builder.CompareToBuilder;

class ProductDaoImpl$1
  implements Comparator<SpecificationValue>
{
  ProductDaoImpl$1(ProductDaoImpl paramProductDaoImpl)
  {
  }

  public int compare(SpecificationValue a1, SpecificationValue a2)
  {
    return new CompareToBuilder().append(a1.getSpecification(), a2.getSpecification()).toComparison();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.ProductDaoImpl.1
 * JD-Core Version:    0.6.2
 */