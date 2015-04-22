package net.shopxx.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import net.shopxx.Principal;
import net.shopxx.dao.AdminDao;
import net.shopxx.entity.Admin;
import net.shopxx.entity.Role;
import net.shopxx.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminServiceImpl")
public class AdminServiceImpl extends BaseServiceImpl<Admin, Long>
  implements AdminService
{

  @Resource(name="adminDaoImpl")
  private AdminDao IIIllIlI;

  @Resource(name="adminDaoImpl")
  public void setBaseDao(AdminDao adminDao)
  {
    super.setBaseDao(adminDao);
  }

  @Transactional(readOnly=true)
  public boolean usernameExists(String username)
  {
    return this.IIIllIlI.usernameExists(username);
  }

  @Transactional(readOnly=true)
  public Admin findByUsername(String username)
  {
    return this.IIIllIlI.findByUsername(username);
  }

  @Transactional(readOnly=true)
  public List<String> findAuthorities(Long id)
  {
    ArrayList localArrayList = new ArrayList();
    Admin localAdmin = (Admin)this.IIIllIlI.find(id);
    if (localAdmin != null)
    {
      Iterator localIterator = localAdmin.getRoles().iterator();
      while (localIterator.hasNext())
      {
        Role localRole = (Role)localIterator.next();
        localArrayList.addAll(localRole.getAuthorities());
      }
    }
    return localArrayList;
  }

  @Transactional(readOnly=true)
  public boolean isAuthenticated()
  {
    Subject localSubject = SecurityUtils.getSubject();
    if (localSubject != null)
      return localSubject.isAuthenticated();
    return false;
  }

  @Transactional(readOnly=true)
  public Admin getCurrent()
  {
    Subject localSubject = SecurityUtils.getSubject();
    if (localSubject != null)
    {
      Principal localPrincipal = (Principal)localSubject.getPrincipal();
      if (localPrincipal != null)
        return (Admin)this.IIIllIlI.find(localPrincipal.getId());
    }
    return null;
  }

  @Transactional(readOnly=true)
  public String getCurrentUsername()
  {
    Subject localSubject = SecurityUtils.getSubject();
    if (localSubject != null)
    {
      Principal localPrincipal = (Principal)localSubject.getPrincipal();
      if (localPrincipal != null)
        return localPrincipal.getUsername();
    }
    return null;
  }

  @Transactional
  @CacheEvict(value={"authorization"}, allEntries=true)
  public void save(Admin admin)
  {
    super.save(admin);
  }

  @Transactional
  @CacheEvict(value={"authorization"}, allEntries=true)
  public Admin update(Admin admin)
  {
    return (Admin)super.update(admin);
  }

  @Transactional
  @CacheEvict(value={"authorization"}, allEntries=true)
  public Admin update(Admin admin, String[] ignoreProperties)
  {
    return (Admin)super.update(admin, ignoreProperties);
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
  public void delete(Admin admin)
  {
    super.delete(admin);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.AdminServiceImpl
 * JD-Core Version:    0.6.2
 */