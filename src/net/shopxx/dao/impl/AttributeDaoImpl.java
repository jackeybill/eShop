package net.shopxx.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import net.shopxx.dao.AttributeDao;
import net.shopxx.entity.Attribute;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository("attributeDaoImpl")
public class AttributeDaoImpl extends BaseDaoImpl<Attribute, Long>
  implements AttributeDao
{
  public void persist(Attribute attribute)
  {
    Assert.notNull(attribute);
    String str = "select attribute.propertyIndex from Attribute attribute where attribute.productCategory = :productCategory";
    List localList = this.IIIllIlI.createQuery(str, Integer.class).setFlushMode(FlushModeType.COMMIT).setParameter("productCategory", attribute.getProductCategory()).getResultList();
    for (int i = 0; i < 20; i++)
      if (!localList.contains(Integer.valueOf(i)))
      {
        attribute.setPropertyIndex(Integer.valueOf(i));
        super.persist(attribute);
        break;
      }
  }

  public void remove(Attribute attribute)
  {
    if (attribute != null)
    {
      String str1 = "attributeValue" + attribute.getPropertyIndex();
      String str2 = "update Product product set product." + str1 + " = null where product.productCategory = :productCategory";
      this.IIIllIlI.createQuery(str2).setFlushMode(FlushModeType.COMMIT).setParameter("productCategory", attribute.getProductCategory()).executeUpdate();
      super.remove(attribute);
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.AttributeDaoImpl
 * JD-Core Version:    0.6.2
 */