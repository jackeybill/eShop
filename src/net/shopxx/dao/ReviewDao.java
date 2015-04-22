package net.shopxx.dao;

import java.util.List;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.entity.Review;
import net.shopxx.entity.Review.Type;

public abstract interface ReviewDao extends BaseDao<Review, Long>
{
  public abstract List<Review> findList(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean, Integer paramInteger, List<Filter> paramList, List<Order> paramList1);

  public abstract Page<Review> findPage(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean, Pageable paramPageable);

  public abstract Long count(Member paramMember, Product paramProduct, Review.Type paramType, Boolean paramBoolean);

  public abstract boolean isReviewed(Member paramMember, Product paramProduct);

  public abstract long calculateTotalScore(Product paramProduct);

  public abstract long calculateScoreCount(Product paramProduct);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.ReviewDao
 * JD-Core Version:    0.6.2
 */