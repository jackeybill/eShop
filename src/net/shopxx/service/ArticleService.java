package net.shopxx.service;

import java.util.Date;
import java.util.List;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Article;
import net.shopxx.entity.ArticleCategory;
import net.shopxx.entity.Tag;

public abstract interface ArticleService extends BaseService<Article, Long>
{
  public abstract List<Article> findList(ArticleCategory paramArticleCategory, List<Tag> paramList, Integer paramInteger, List<Filter> paramList1, List<Order> paramList2);

  public abstract List<Article> findList(ArticleCategory paramArticleCategory, List<Tag> paramList, Integer paramInteger, List<Filter> paramList1, List<Order> paramList2, String paramString);

  public abstract List<Article> findList(ArticleCategory paramArticleCategory, Date paramDate1, Date paramDate2, Integer paramInteger1, Integer paramInteger2);

  public abstract Page<Article> findPage(ArticleCategory paramArticleCategory, List<Tag> paramList, Pageable paramPageable);

  public abstract long viewHits(Long paramLong);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.ArticleService
 * JD-Core Version:    0.6.2
 */