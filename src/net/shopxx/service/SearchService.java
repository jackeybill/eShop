package net.shopxx.service;

import java.math.BigDecimal;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.entity.Article;
import net.shopxx.entity.Product;
import net.shopxx.entity.Product.OrderType;

public abstract interface SearchService
{
  public abstract void index();

  public abstract void index(Class<?> paramClass);

  public abstract void index(Article paramArticle);

  public abstract void index(Product paramProduct);

  public abstract void purge();

  public abstract void purge(Class<?> paramClass);

  public abstract void purge(Article paramArticle);

  public abstract void purge(Product paramProduct);

  public abstract Page<Article> search(String paramString, Pageable paramPageable);

  public abstract Page<Product> search(String paramString, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Product.OrderType paramOrderType, Pageable paramPageable);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.SearchService
 * JD-Core Version:    0.6.2
 */