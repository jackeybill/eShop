package net.shopxx.interceptor;

import java.net.URLEncoder;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.shopxx.Principal;
import net.shopxx.entity.Member;
import net.shopxx.service.MemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter
{
  private static final String IIIllIlI = "redirect:";
  private static final String IIIllIll = "redirectUrl";
  private static final String IIIlllII = "member";
  private static final String IIIlllIl = "/login.jhtml";
  private String IIIllllI = "/login.jhtml";

  @Value("${url_escaping_charset}")
  private String IIIlllll;

  @Resource(name="memberServiceImpl")
  private MemberService IIlIIIII;

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
  {
    HttpSession localHttpSession = request.getSession();
    Principal localPrincipal = (Principal)localHttpSession.getAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME);
    if (localPrincipal != null)
      return true;
    String str1 = request.getHeader("X-Requested-With");
    if ((str1 != null) && (str1.equalsIgnoreCase("XMLHttpRequest")))
    {
      response.addHeader("loginStatus", "accessDenied");
      response.sendError(403);
      return false;
    }
    if (request.getMethod().equalsIgnoreCase("GET"))
    {
      String str2 = request.getQueryString() != null ? request.getRequestURI() + "?" + request.getQueryString() : request.getRequestURI();
      response.sendRedirect(request.getContextPath() + this.IIIllllI + "?" + "redirectUrl" + "=" + URLEncoder.encode(str2, this.IIIlllll));
    }
    else
    {
      response.sendRedirect(request.getContextPath() + this.IIIllllI);
    }
    return false;
  }

  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
  {
    if (modelAndView != null)
    {
      String str = modelAndView.getViewName();
      if (!StringUtils.startsWith(str, "redirect:"))
        modelAndView.addObject("member", this.IIlIIIII.getCurrent());
    }
  }

  public String getLoginUrl()
  {
    return this.IIIllllI;
  }

  public void setLoginUrl(String loginUrl)
  {
    this.IIIllllI = loginUrl;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.interceptor.MemberInterceptor
 * JD-Core Version:    0.6.2
 */