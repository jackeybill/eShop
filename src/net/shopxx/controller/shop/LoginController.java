package net.shopxx.controller.shop;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.shopxx.Message;
import net.shopxx.Principal;
import net.shopxx.Setting;
import net.shopxx.Setting.AccountLockType;
import net.shopxx.Setting.CaptchaType;
import net.shopxx.entity.Cart;
import net.shopxx.entity.Member;
import net.shopxx.service.CaptchaService;
import net.shopxx.service.CartService;
import net.shopxx.service.MemberService;
import net.shopxx.service.RSAService;
import net.shopxx.util.CookieUtils;
import net.shopxx.util.SettingUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopLoginController")
@RequestMapping({"/login"})
public class LoginController extends BaseController
{

  @Resource(name="captchaServiceImpl")
  private CaptchaService IIIlllIl;

  @Resource(name="rsaServiceImpl")
  private RSAService IIIllllI;

  @Resource(name="memberServiceImpl")
  private MemberService IIIlllll;

  @Resource(name="cartServiceImpl")
  private CartService IIlIIIII;

  @RequestMapping(value={"/check"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public Boolean check()
  {
    return Boolean.valueOf(this.IIIlllll.isAuthenticated());
  }

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String index(String redirectUrl, HttpServletRequest request, ModelMap model)
  {
    Setting localSetting = SettingUtils.get();
    if ((redirectUrl != null) && (!redirectUrl.equalsIgnoreCase(localSetting.getSiteUrl())) && (!redirectUrl.startsWith(request.getContextPath() + "/")) && (!redirectUrl.startsWith(localSetting.getSiteUrl() + "/")))
      redirectUrl = null;
    model.addAttribute("redirectUrl", redirectUrl);
    model.addAttribute("captchaId", UUID.randomUUID().toString());
    return "/shop/login/index";
  }

  @RequestMapping(value={"/submit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message submit(String captchaId, String captcha, String username, HttpServletRequest request, HttpServletResponse response, HttpSession session)
  {
    String str = this.IIIllllI.decryptParameter("enPassword", request);
    this.IIIllllI.removePrivateKey(request);
    if (!this.IIIlllIl.isValid(Setting.CaptchaType.memberLogin, captchaId, captcha))
      return Message.error("shop.captcha.invalid", new Object[0]);
    if ((StringUtils.isEmpty(username)) || (StringUtils.isEmpty(str)))
      return Message.error("shop.common.invalid", new Object[0]);
    Setting localSetting = SettingUtils.get();
    Member localMember;
    if ((localSetting.getIsEmailLogin().booleanValue()) && (username.contains("@")))
    {
      List localList = this.IIIlllll.findListByEmail(username);
      if (localList.isEmpty())
        localMember = null;
      else if (localList.size() == 1)
        localMember = (Member)localList.get(0);
      else
        return Message.error("shop.login.unsupportedAccount", new Object[0]);
    }
    else
    {
      localMember = this.IIIlllll.findByUsername(username);
    }
    if (localMember == null)
      return Message.error("shop.login.unknownAccount", new Object[0]);
    if (!localMember.getIsEnabled().booleanValue())
      return Message.error("shop.login.disabledAccount", new Object[0]);
    int i;
    if (localMember.getIsLocked().booleanValue())
      if (ArrayUtils.contains(localSetting.getAccountLockTypes(), Setting.AccountLockType.member))
      {
        i = localSetting.getAccountLockTime().intValue();
        if (i == 0)
          return Message.error("shop.login.lockedAccount", new Object[0]);
        localObject1 = localMember.getLockedDate();
        localObject2 = DateUtils.addMinutes((Date)localObject1, i);
        if (new Date().after((Date)localObject2))
        {
          localMember.setLoginFailureCount(Integer.valueOf(0));
          localMember.setIsLocked(Boolean.valueOf(false));
          localMember.setLockedDate(null);
          this.IIIlllll.update(localMember);
        }
        else
        {
          return Message.error("shop.login.lockedAccount", new Object[0]);
        }
      }
      else
      {
        localMember.setLoginFailureCount(Integer.valueOf(0));
        localMember.setIsLocked(Boolean.valueOf(false));
        localMember.setLockedDate(null);
        this.IIIlllll.update(localMember);
      }
    if (!DigestUtils.md5Hex(str).equals(localMember.getPassword()))
    {
      i = localMember.getLoginFailureCount().intValue() + 1;
      if (i >= localSetting.getAccountLockCount().intValue())
      {
        localMember.setIsLocked(Boolean.valueOf(true));
        localMember.setLockedDate(new Date());
      }
      localMember.setLoginFailureCount(Integer.valueOf(i));
      this.IIIlllll.update(localMember);
      if (ArrayUtils.contains(localSetting.getAccountLockTypes(), Setting.AccountLockType.member))
        return Message.error("shop.login.accountLockCount", new Object[] { localSetting.getAccountLockCount() });
      return Message.error("shop.login.incorrectCredentials", new Object[0]);
    }
    localMember.setLoginIp(request.getRemoteAddr());
    localMember.setLoginDate(new Date());
    localMember.setLoginFailureCount(Integer.valueOf(0));
    this.IIIlllll.update(localMember);
    Cart localCart = this.IIlIIIII.getCurrent();
    if ((localCart != null) && (localCart.getMember() == null))
    {
      this.IIlIIIII.merge(localMember, localCart);
      CookieUtils.removeCookie(request, response, "cartId");
      CookieUtils.removeCookie(request, response, "cartKey");
    }
    Object localObject1 = new HashMap();
    Object localObject2 = session.getAttributeNames();
    Object localObject3;
    while (((Enumeration)localObject2).hasMoreElements())
    {
      localObject3 = (String)((Enumeration)localObject2).nextElement();
      ((Map)localObject1).put(localObject3, session.getAttribute((String)localObject3));
    }
    session.invalidate();
    session = request.getSession();
    Iterator localIterator = ((Map)localObject1).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (Map.Entry)localIterator.next();
      session.setAttribute((String)((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
    }
    session.setAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME, new Principal(localMember.getId(), username));
    CookieUtils.addCookie(request, response, "username", localMember.getUsername());
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.LoginController
 * JD-Core Version:    0.6.2
 */