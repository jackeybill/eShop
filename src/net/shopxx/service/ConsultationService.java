package net.shopxx.service;

import java.util.List;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Consultation;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;

public abstract interface ConsultationService extends BaseService<Consultation, Long>
{
  public abstract List<Consultation> findList(Member paramMember, Product paramProduct, Boolean paramBoolean, Integer paramInteger, List<Filter> paramList, List<Order> paramList1);

  public abstract List<Consultation> findList(Member paramMember, Product paramProduct, Boolean paramBoolean, Integer paramInteger, List<Filter> paramList, List<Order> paramList1, String paramString);

  public abstract Page<Consultation> findPage(Member paramMember, Product paramProduct, Boolean paramBoolean, Pageable paramPageable);

  public abstract Long count(Member paramMember, Product paramProduct, Boolean paramBoolean);

  public abstract void reply(Consultation paramConsultation1, Consultation paramConsultation2);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.ConsultationService
 * JD-Core Version:    0.6.2
 */