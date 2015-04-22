package net.shopxx.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import net.shopxx.dao.DeliveryTemplateDao;
import net.shopxx.entity.DeliveryTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository("deliveryTemplateDaoImpl")
public class DeliveryTemplateDaoImpl extends BaseDaoImpl<DeliveryTemplate, Long>
  implements DeliveryTemplateDao
{
  public DeliveryTemplate findDefault()
  {
    try
    {
      String str = "select deliveryTemplate from DeliveryTemplate deliveryTemplate where deliveryTemplate.isDefault = true";
      return (DeliveryTemplate)this.IIIllIlI.createQuery(str, DeliveryTemplate.class).setFlushMode(FlushModeType.COMMIT).getSingleResult();
    }
    catch (NoResultException localNoResultException)
    {
    }
    return null;
  }

  public void persist(DeliveryTemplate deliveryTemplate)
  {
    Assert.notNull(deliveryTemplate);
    if (deliveryTemplate.getIsDefault().booleanValue())
    {
      String str = "update DeliveryTemplate deliveryTemplate set deliveryTemplate.isDefault = false where deliveryTemplate.isDefault = true";
      this.IIIllIlI.createQuery(str).setFlushMode(FlushModeType.COMMIT).executeUpdate();
    }
    super.persist(deliveryTemplate);
  }

  public DeliveryTemplate merge(DeliveryTemplate deliveryTemplate)
  {
    Assert.notNull(deliveryTemplate);
    if (deliveryTemplate.getIsDefault().booleanValue())
    {
      String str = "update DeliveryTemplate deliveryTemplate set deliveryTemplate.isDefault = false where deliveryTemplate.isDefault = true and deliveryTemplate != :deliveryTemplate";
      this.IIIllIlI.createQuery(str).setFlushMode(FlushModeType.COMMIT).setParameter("deliveryTemplate", deliveryTemplate).executeUpdate();
    }
    return (DeliveryTemplate)super.merge(deliveryTemplate);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.DeliveryTemplateDaoImpl
 * JD-Core Version:    0.6.2
 */