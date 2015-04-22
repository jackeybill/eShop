package net.shopxx.dao;

import java.util.List;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Consultation;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;

public abstract interface ConsultationDao extends BaseDao<Consultation, Long>
{
  public abstract List<Consultation> findList(Member paramMember, Product paramProduct, Boolean paramBoolean, Integer paramInteger, List<Filter> paramList, List<Order> paramList1);

  public abstract Page<Consultation> findPage(Member paramMember, Product paramProduct, Boolean paramBoolean, Pageable paramPageable);

  public abstract Long count(Member paramMember, Product paramProduct, Boolean paramBoolean);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.ConsultationDao
 * JD-Core Version:    0.6.2
 */