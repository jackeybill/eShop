package net.shopxx.interceptor;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.shopxx.util.CookieUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TokenInterceptor extends HandlerInterceptorAdapter
{
  private static final String IIIllIlI = "token";
  private static final String IIIllIll = "token";
  private static final String IIIlllII = "token";
  private static final String IIIlllIl = "Bad or missing token!";

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
  {
    String str1 = CookieUtils.getCookie(request, "token");
    if (request.getMethod().equalsIgnoreCase("POST"))
    {
      String str2 = request.getHeader("X-Requested-With");
      if ((str2 != null) && (str2.equalsIgnoreCase("XMLHttpRequest")))
      {
        if ((str1 != null) && (str1.equals(request.getHeader("token"))))
          return true;
        response.addHeader("tokenStatus", "accessDenied");
      }
      else if ((str1 != null) && (str1.equals(request.getParameter("token"))))
      {
        return true;
      }
      if (str1 == null)
      {
        str1 = UUID.randomUUID().toString();
        CookieUtils.addCookie(request, response, "token", str1);
      }
      response.sendError(403, "Bad or missing token!");
      return false;
    }
    if (str1 == null)
    {
      str1 = UUID.randomUUID().toString();
      CookieUtils.addCookie(request, response, "token", str1);
    }
    request.setAttribute("token", str1);
    return true;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.interceptor.TokenInterceptor
 * JD-Core Version:    0.6.2
 */