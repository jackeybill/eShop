package net.shopxx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import net.shopxx.dao.ArticleCategoryDao;
import net.shopxx.entity.ArticleCategory;
import net.shopxx.service.ArticleCategoryService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("articleCategoryServiceImpl")
public class ArticleCategoryServiceImpl extends BaseServiceImpl<ArticleCategory, Long>
  implements ArticleCategoryService
{

  @Resource(name="articleCategoryDaoImpl")
  private ArticleCategoryDao IIIllIlI;

  @Resource(name="articleCategoryDaoImpl")
  public void setBaseDao(ArticleCategoryDao articleCategoryDao)
  {
    super.setBaseDao(articleCategoryDao);
  }

  @Transactional(readOnly=true)
  public List<ArticleCategory> findRoots()
  {
    return this.IIIllIlI.findRoots(null);
  }

  @Transactional(readOnly=true)
  public List<ArticleCategory> findRoots(Integer count)
  {
    return this.IIIllIlI.findRoots(count);
  }

  @Transactional(readOnly=true)
  @Cacheable({"articleCategory"})
  public List<ArticleCategory> findRoots(Integer count, String cacheRegion)
  {
    return this.IIIllIlI.findRoots(count);
  }

  @Transactional(readOnly=true)
  public List<ArticleCategory> findParents(ArticleCategory articleCategory)
  {
    return this.IIIllIlI.findParents(articleCategory, null);
  }

  @Transactional(readOnly=true)
  public List<ArticleCategory> findParents(ArticleCategory articleCategory, Integer count)
  {
    return this.IIIllIlI.findParents(articleCategory, count);
  }

  @Transactional(readOnly=true)
  @Cacheable({"articleCategory"})
  public List<ArticleCategory> findParents(ArticleCategory articleCategory, Integer count, String cacheRegion)
  {
    return this.IIIllIlI.findParents(articleCategory, count);
  }

  @Transactional(readOnly=true)
  public List<ArticleCategory> findTree()
  {
    return this.IIIllIlI.findChildren(null, null);
  }

  @Transactional(readOnly=true)
  public List<ArticleCategory> findChildren(ArticleCategory articleCategory)
  {
    return this.IIIllIlI.findChildren(articleCategory, null);
  }

  @Transactional(readOnly=true)
  public List<ArticleCategory> findChildren(ArticleCategory articleCategory, Integer count)
  {
    return this.IIIllIlI.findChildren(articleCategory, count);
  }

  @Transactional(readOnly=true)
  @Cacheable({"articleCategory"})
  public List<ArticleCategory> findChildren(ArticleCategory articleCategory, Integer count, String cacheRegion)
  {
    return this.IIIllIlI.findChildren(articleCategory, count);
  }

  @Transactional
  @CacheEvict(value={"article", "articleCategory"}, allEntries=true)
  public void save(ArticleCategory articleCategory)
  {
    super.save(articleCategory);
  }

  @Transactional
  @CacheEvict(value={"article", "articleCategory"}, allEntries=true)
  public ArticleCategory update(ArticleCategory articleCategory)
  {
    return (ArticleCategory)super.update(articleCategory);
  }

  @Transactional
  @CacheEvict(value={"article", "articleCategory"}, allEntries=true)
  public ArticleCategory update(ArticleCategory articleCategory, String[] ignoreProperties)
  {
    return (ArticleCategory)super.update(articleCategory, ignoreProperties);
  }

  @Transactional
  @CacheEvict(value={"article", "articleCategory"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }

  @Transactional
  @CacheEvict(value={"article", "articleCategory"}, allEntries=true)
  public void delete(Long[] ids)
  {
    super.delete(ids);
  }

  @Transactional
  @CacheEvict(value={"article", "articleCategory"}, allEntries=true)
  public void delete(ArticleCategory articleCategory)
  {
    super.delete(articleCategory);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.ArticleCategoryServiceImpl
 * JD-Core Version:    0.6.2
 */