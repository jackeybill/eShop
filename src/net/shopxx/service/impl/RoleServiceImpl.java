package net.shopxx.service.impl;

import javax.annotation.Resource;
import net.shopxx.dao.RoleDao;
import net.shopxx.entity.Role;
import net.shopxx.service.RoleService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("roleServiceImpl")
public class RoleServiceImpl extends BaseServiceImpl<Role, Long>
  implements RoleService
{
  @Resource(name="roleDaoImpl")
  public void setBaseDao(RoleDao roleDao)
  {
    super.setBaseDao(roleDao);
  }

  @Transactional
  @CacheEvict(value={"authorization"}, allEntries=true)
  public void save(Role role)
  {
    super.save(role);
  }

  @Transactional
  @CacheEvict(value={"authorization"}, allEntries=true)
  public Role update(Role role)
  {
    return (Role)super.update(role);
  }

  @Transactional
  @CacheEvict(value={"authorization"}, allEntries=true)
  public Role update(Role role, String[] ignoreProperties)
  {
    return (Role)super.update(role, ignoreProperties);
  }

  @Transactional
  @CacheEvict(value={"authorization"}, allEntries=true)
  public void delete(Long id)
  {
    super.delete(id);
  }

  @Transactional
  @CacheEvict(value={"authorization"}, allEntries=true)
  public void delete(Long[] ids)
  {
    super.delete(ids);
  }

  @Transactional
  @CacheEvict(value={"authorization"}, allEntries=true)
  public void delete(Role role)
  {
    super.delete(role);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.RoleServiceImpl
 * JD-Core Version:    0.6.2
 */