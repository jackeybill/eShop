package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.AdDao;
import net.shopxx.entity.Ad;
import net.shopxx.service.AdService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adServiceImpl")
public class AdServiceImpl extends BaseServiceImpl<Ad, Long>
  implements AdService
{
  @Resource(name="adDaoImpl")
  public void setBaseDao(AdDao adDao)
  {
    super.setBaseDao(adDao);
  }

  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public void save(Ad ad)
  {
    super.save(ad);
  }

  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public Ad update(Ad ad)
  {
    return (Ad)super.update(ad);
  }

  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public Ad update(Ad ad, String[] ignoreProperties)
  {
    return (Ad)super.update(ad, ignoreProperties);
  }

  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }

  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public void delete(Long[] ids)
  {
    super.delete(ids);
  }

  @Transactional
  @CacheEvict(value={"adPosition"}, allEntries=true)
  public void delete(Ad ad)
  {
    super.delete(ad);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.AdServiceImpl
 * JD-Core Version:    0.6.2
 */