package net.shopxx.service;

import java.util.Map;
import net.shopxx.entity.Article;
import net.shopxx.entity.Product;

public abstract interface StaticService
{
  public abstract int build(String paramString1, String paramString2, Map<String, Object> paramMap);

  public abstract int build(String paramString1, String paramString2);

  public abstract int build(Article paramArticle);

  public abstract int build(Product paramProduct);

  public abstract int buildIndex();

  public abstract int buildSitemap();

  public abstract int buildOther();

  public abstract int buildAll();

  public abstract int delete(String paramString);

  public abstract int delete(Article paramArticle);

  public abstract int delete(Product paramProduct);

  public abstract int deleteIndex();

  public abstract int deleteOther();
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.StaticService
 * JD-Core Version:    0.6.2
 */