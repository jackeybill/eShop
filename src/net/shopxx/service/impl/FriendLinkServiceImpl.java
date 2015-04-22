package net.shopxx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.dao.FriendLinkDao;
import net.shopxx.entity.FriendLink;
import net.shopxx.entity.FriendLink.Type;
import net.shopxx.service.FriendLinkService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("friendLinkServiceImpl")
public class FriendLinkServiceImpl extends BaseServiceImpl<FriendLink, Long>
  implements FriendLinkService
{

  @Resource(name="friendLinkDaoImpl")
  public FriendLinkDao friendLinkDao;

  @Resource(name="friendLinkDaoImpl")
  public void setBaseDao(FriendLinkDao friendLinkDao)
  {
    super.setBaseDao(friendLinkDao);
  }

  @Transactional(readOnly=true)
  public List<FriendLink> findList(FriendLink.Type type)
  {
    return this.friendLinkDao.findList(type);
  }

  @Transactional(readOnly=true)
  @Cacheable({"friendLink"})
  public List<FriendLink> findList(Integer count, List<Filter> filters, List<Order> orders, String cacheRegion)
  {
    return this.friendLinkDao.findList(null, count, filters, orders);
  }

  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public void save(FriendLink friendLink)
  {
    super.save(friendLink);
  }

  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public FriendLink update(FriendLink friendLink)
  {
    return (FriendLink)super.update(friendLink);
  }

  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public FriendLink update(FriendLink friendLink, String[] ignoreProperties)
  {
    return (FriendLink)super.update(friendLink, ignoreProperties);
  }

  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }

  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public void delete(Long[] ids)
  {
    super.delete(ids);
  }

  @Transactional
  @CacheEvict(value={"friendLink"}, allEntries=true)
  public void delete(FriendLink friendLink)
  {
    super.delete(friendLink);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.FriendLinkServiceImpl
 * JD-Core Version:    0.6.2
 */