package net.shopxx.service;

import java.util.List;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.entity.Review;
import net.shopxx.entity.Review.Type;

public abstract interface ReviewService extends BaseService<Review, Long>
{
  public abstract List<Review> findList(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean, Integer paramInteger, List<Filter> paramList, List<Order> paramList1);

  public abstract List<Review> findList(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean, Integer paramInteger, List<Filter> paramList, List<Order> paramList1, String paramString);

  public abstract Page<Review> findPage(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean, Pageable paramPageable);

  public abstract Long count(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean);

  public abstract boolean isReviewed(Member paramMember, Product paramProduct);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.ReviewService
 * JD-Core Version:    0.6.2
 */