package net.shopxx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.dao.TagDao;
import net.shopxx.entity.Tag;
import net.shopxx.entity.Tag.Type;
import net.shopxx.service.TagService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tagServiceImpl")
public class TagServiceImpl extends BaseServiceImpl<Tag, Long>
  implements TagService
{

  @Resource(name="tagDaoImpl")
  private TagDao IIIllIlI;

  @Resource(name="tagDaoImpl")
  public void setBaseDao(TagDao tagDao)
  {
    super.setBaseDao(tagDao);
  }

  @Transactional(readOnly=true)
  public List<Tag> findList(Tag.Type type)
  {
    return this.IIIllIlI.findList(type);
  }

  @Transactional(readOnly=true)
  @Cacheable({"tag"})
  public List<Tag> findList(Integer count, List<Filter> filters, List<Order> orders, String cacheRegion)
  {
    return this.IIIllIlI.findList(null, count, filters, orders);
  }

  @Transactional
  @CacheEvict(value={"tag"}, allEntries=true)
  public void save(Tag tag)
  {
    super.save(tag);
  }

  @Transactional
  @CacheEvict(value={"tag"}, allEntries=true)
  public Tag update(Tag tag)
  {
    return (Tag)super.update(tag);
  }

  @Transactional
  @CacheEvict(value={"tag"}, allEntries=true)
  public Tag update(Tag tag, String[] ignoreProperties)
  {
    return (Tag)super.update(tag, ignoreProperties);
  }

  @Transactional
  @CacheEvict(value={"tag"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }

  @Transactional
  @CacheEvict(value={"tag"}, allEntries=true)
  public void delete(Long[] ids)
  {
    super.delete(ids);
  }

  @Transactional
  @CacheEvict(value={"tag"}, allEntries=true)
  public void delete(Tag tag)
  {
    super.delete(tag);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.TagServiceImpl
 * JD-Core Version:    0.6.2
 */