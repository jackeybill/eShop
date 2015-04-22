package net.shopxx.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Attribute;
import net.shopxx.entity.Brand;
import net.shopxx.entity.Goods;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.entity.Product.OrderType;
import net.shopxx.entity.ProductCategory;
import net.shopxx.entity.Promotion;
import net.shopxx.entity.Tag;

public abstract interface ProductDao extends BaseDao<Product, Long>
{
  public abstract boolean snExists(String paramString);

  public abstract Product findBySn(String paramString);

  public abstract List<Product> search(String paramString, Boolean paramBoolean, Integer paramInteger);

  public abstract List<Product> findList(ProductCategory paramProductCategory, Brand paramBrand, Promotion paramPromotion, List<Tag> paramList, Map<Attribute, String> paramMap, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Boolean paramBoolean5, Boolean paramBoolean6, Product.OrderType paramOrderType, Integer paramInteger, List<Filter> paramList1, List<Order> paramList2);

  public abstract List<Product> findList(ProductCategory paramProductCategory, Date paramDate1, Date paramDate2, Integer paramInteger1, Integer paramInteger2);

  public abstract List<Product> findList(Goods paramGoods, Set<Product> paramSet);

  public abstract Page<Product> findPage(ProductCategory paramProductCategory, Brand paramBrand, Promotion paramPromotion, List<Tag> paramList, Map<Attribute, String> paramMap, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Boolean paramBoolean5, Boolean paramBoolean6, Product.OrderType paramOrderType, Pageable paramPageable);

  public abstract Page<Product> findPage(Member paramMember, Pageable paramPageable);

  public abstract Page<Object> findSalesPage(Date paramDate1, Date paramDate2, Pageable paramPageable);

  public abstract Long count(Member paramMember, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Boolean paramBoolean5, Boolean paramBoolean6);

  public abstract boolean isPurchased(Member paramMember, Product paramProduct);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.ProductDao
 * JD-Core Version:    0.6.2
 */