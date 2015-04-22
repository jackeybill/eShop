package net.shopxx.service;

import java.util.List;
import net.shopxx.entity.ArticleCategory;

public abstract interface ArticleCategoryService extends BaseService<ArticleCategory, Long>
{
  public abstract List<ArticleCategory> findRoots();

  public abstract List<ArticleCategory> findRoots(Integer paramInteger);

  public abstract List<ArticleCategory> findRoots(Integer paramInteger, String paramString);

  public abstract List<ArticleCategory> findParents(ArticleCategory paramArticleCategory);

  public abstract List<ArticleCategory> findParents(ArticleCategory paramArticleCategory, Integer paramInteger);

  public abstract List<ArticleCategory> findParents(ArticleCategory paramArticleCategory, Integer paramInteger, String paramString);

  public abstract List<ArticleCategory> findTree();

  public abstract List<ArticleCategory> findChildren(ArticleCategory paramArticleCategory);

  public abstract List<ArticleCategory> findChildren(ArticleCategory paramArticleCategory, Integer paramInteger);

  public abstract List<ArticleCategory> findChildren(ArticleCategory paramArticleCategory, Integer paramInteger, String paramString);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.ArticleCategoryService
 * JD-Core Version:    0.6.2
 */