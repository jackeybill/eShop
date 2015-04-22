package net.shopxx.filter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.shopxx.service.RSAService;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class AuthenticationFilter extends FormAuthenticationFilter
{
  private static final String IIIllIlI = "enPassword";
  private static final String IIIllIll = "captchaId";
  private static final String IIIlllII = "captcha";
  private String IIIlllIl = "enPassword";
  private String IIIllllI = "captchaId";
  private String IIIlllll = "captcha";

  @Resource(name="rsaServiceImpl")
  private RSAService IIlIIIII;

  protected org.apache.shiro.authc.AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse)
  {
    String str1 = getUsername(servletRequest);
    String str2 = getPassword(servletRequest);
    String str3 = IIIllIlI(servletRequest);
    String str4 = IIIllIll(servletRequest);
    boolean bool = isRememberMe(servletRequest);
    String str5 = getHost(servletRequest);
    return new net.shopxx.AuthenticationToken(str1, str2, str3, str4, bool, str5);
  }

  protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse)
  {
    HttpServletRequest localHttpServletRequest = (HttpServletRequest)servletRequest;
    HttpServletResponse localHttpServletResponse = (HttpServletResponse)servletResponse;
    String str = localHttpServletRequest.getHeader("X-Requested-With");
    if ((str != null) && (str.equalsIgnoreCase("XMLHttpRequest")))
    {
      localHttpServletResponse.addHeader("loginStatus", "accessDenied");
      localHttpServletResponse.sendError(403);
      return false;
    }
    return super.onAccessDenied(localHttpServletRequest, localHttpServletResponse);
  }

  protected boolean onLoginSuccess(org.apache.shiro.authc.AuthenticationToken token, Subject subject, ServletRequest servletRequest, ServletResponse servletResponse)
  {
    Session localSession = subject.getSession();
    HashMap localHashMap = new HashMap();
    Collection localCollection = localSession.getAttributeKeys();
    Iterator localIterator = localCollection.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      localHashMap.put(localObject, localSession.getAttribute(localObject));
    }
    localSession.stop();
    localSession = subject.getSession();
    localIterator = localHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      localSession.setAttribute(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
    }
    return super.onLoginSuccess(token, subject, servletRequest, servletResponse);
  }

  protected String getPassword(ServletRequest servletRequest)
  {
    HttpServletRequest localHttpServletRequest = (HttpServletRequest)servletRequest;
    String str = this.IIlIIIII.decryptParameter(this.IIIlllIl, localHttpServletRequest);
    this.IIlIIIII.removePrivateKey(localHttpServletRequest);
    return str;
  }

  protected String IIIllIlI(ServletRequest paramServletRequest)
  {
    String str = WebUtils.getCleanParam(paramServletRequest, this.IIIllllI);
    if (str == null)
      str = ((HttpServletRequest)paramServletRequest).getSession().getId();
    return str;
  }

  protected String IIIllIll(ServletRequest paramServletRequest)
  {
    return WebUtils.getCleanParam(paramServletRequest, this.IIIlllll);
  }

  public String getEnPasswordParam()
  {
    return this.IIIlllIl;
  }

  public void setEnPasswordParam(String enPasswordParam)
  {
    this.IIIlllIl = enPasswordParam;
  }

  public String getCaptchaIdParam()
  {
    return this.IIIllllI;
  }

  public void setCaptchaIdParam(String captchaIdParam)
  {
    this.IIIllllI = captchaIdParam;
  }

  public String getCaptchaParam()
  {
    return this.IIIlllll;
  }

  public void setCaptchaParam(String captchaParam)
  {
    this.IIIlllll = captchaParam;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.filter.AuthenticationFilter
 * JD-Core Version:    0.6.2
 */