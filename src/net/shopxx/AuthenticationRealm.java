package net.shopxx;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import net.shopxx.entity.Admin;
import net.shopxx.service.AdminService;
import net.shopxx.service.CaptchaService;
import net.shopxx.util.SettingUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class AuthenticationRealm extends AuthorizingRealm
{

  @Resource(name="captchaServiceImpl")
  private CaptchaService IIIllIlI;

  @Resource(name="adminServiceImpl")
  private AdminService IIIllIll;

  protected AuthenticationInfo doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken token)
  {
    AuthenticationToken localAuthenticationToken = (AuthenticationToken)token;
    String str1 = localAuthenticationToken.getUsername();
    String str2 = new String(localAuthenticationToken.getPassword());
    String str3 = localAuthenticationToken.getCaptchaId();
    String str4 = localAuthenticationToken.getCaptcha();
    String str5 = localAuthenticationToken.getHost();
    if (!this.IIIllIlI.isValid(Setting.CaptchaType.adminLogin, str3, str4))
      throw new UnsupportedTokenException();
    if ((str1 != null) && (str2 != null))
    {
      Admin localAdmin = this.IIIllIll.findByUsername(str1);
      if (localAdmin == null)
        throw new UnknownAccountException();
      if (!localAdmin.getIsEnabled().booleanValue())
        throw new DisabledAccountException();
      Setting localSetting = SettingUtils.get();
      int i;
      if (localAdmin.getIsLocked().booleanValue())
        if (ArrayUtils.contains(localSetting.getAccountLockTypes(), Setting.AccountLockType.admin))
        {
          i = localSetting.getAccountLockTime().intValue();
          if (i == 0)
            throw new LockedAccountException();
          Date localDate1 = localAdmin.getLockedDate();
          Date localDate2 = DateUtils.addMinutes(localDate1, i);
          if (new Date().after(localDate2))
          {
            localAdmin.setLoginFailureCount(Integer.valueOf(0));
            localAdmin.setIsLocked(Boolean.valueOf(false));
            localAdmin.setLockedDate(null);
            this.IIIllIll.update(localAdmin);
          }
          else
          {
            throw new LockedAccountException();
          }
        }
        else
        {
          localAdmin.setLoginFailureCount(Integer.valueOf(0));
          localAdmin.setIsLocked(Boolean.valueOf(false));
          localAdmin.setLockedDate(null);
          this.IIIllIll.update(localAdmin);
        }
      if (!DigestUtils.md5Hex(str2).equals(localAdmin.getPassword()))
      {
        i = localAdmin.getLoginFailureCount().intValue() + 1;
        if (i >= localSetting.getAccountLockCount().intValue())
        {
          localAdmin.setIsLocked(Boolean.valueOf(true));
          localAdmin.setLockedDate(new Date());
        }
        localAdmin.setLoginFailureCount(Integer.valueOf(i));
        this.IIIllIll.update(localAdmin);
        throw new IncorrectCredentialsException();
      }
      localAdmin.setLoginIp(str5);
      localAdmin.setLoginDate(new Date());
      localAdmin.setLoginFailureCount(Integer.valueOf(0));
      this.IIIllIll.update(localAdmin);
      return new SimpleAuthenticationInfo(new Principal(localAdmin.getId(), str1), str2, getName());
    }
    throw new UnknownAccountException();
  }

  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
  {
    Principal localPrincipal = (Principal)principals.fromRealm(getName()).iterator().next();
    if (localPrincipal != null)
    {
      List localList = this.IIIllIll.findAuthorities(localPrincipal.getId());
      if (localList != null)
      {
        SimpleAuthorizationInfo localSimpleAuthorizationInfo = new SimpleAuthorizationInfo();
        localSimpleAuthorizationInfo.addStringPermissions(localList);
        return localSimpleAuthorizationInfo;
      }
    }
    return null;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.AuthenticationRealm
 * JD-Core Version:    0.6.2
 */