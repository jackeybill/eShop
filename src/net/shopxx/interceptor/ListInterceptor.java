package net.shopxx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.shopxx.util.CookieUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ListInterceptor extends HandlerInterceptorAdapter
{
  private static final String IIIllIlI = "redirect:";
  private static final String IIIllIll = "listQuery";

  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
  {
    if ((modelAndView != null) && (modelAndView.isReference()))
    {
      String str1 = modelAndView.getViewName();
      if (StringUtils.startsWith(str1, "redirect:"))
      {
        String str2 = CookieUtils.getCookie(request, "listQuery");
        if (StringUtils.isNotEmpty(str2))
        {
          if (StringUtils.startsWith(str2, "?"))
            str2 = str2.substring(1);
          if (StringUtils.contains(str1, "?"))
            modelAndView.setViewName(str1 + "&" + str2);
          else
            modelAndView.setViewName(str1 + "?" + str2);
          CookieUtils.removeCookie(request, response, "listQuery");
        }
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.interceptor.ListInterceptor
 * JD-Core Version:    0.6.2
 */