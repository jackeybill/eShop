package net.shopxx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter
{
  private static final Logger IIIllIlI = LoggerFactory.getLogger(ExecuteTimeInterceptor.class);
  private static final String IIIllIll = ExecuteTimeInterceptor.class.getName() + ".START_TIME";
  public static final String EXECUTE_TIME_ATTRIBUTE_NAME = ExecuteTimeInterceptor.class.getName() + ".EXECUTE_TIME";
  private static final String IIIlllII = "redirect:";

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
  {
    Long localLong = (Long)request.getAttribute(IIIllIll);
    if (localLong == null)
    {
      localLong = Long.valueOf(System.currentTimeMillis());
      request.setAttribute(IIIllIll, localLong);
    }
    return true;
  }

  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
  {
    Long localLong1 = (Long)request.getAttribute(EXECUTE_TIME_ATTRIBUTE_NAME);
    Object localObject;
    if (localLong1 == null)
    {
      localObject = (Long)request.getAttribute(IIIllIll);
      Long localLong2 = Long.valueOf(System.currentTimeMillis());
      localLong1 = Long.valueOf(localLong2.longValue() - ((Long)localObject).longValue());
      request.setAttribute(IIIllIll, localObject);
    }
    if (modelAndView != null)
    {
      localObject = modelAndView.getViewName();
      if (!StringUtils.startsWith((String)localObject, "redirect:"))
        modelAndView.addObject(EXECUTE_TIME_ATTRIBUTE_NAME, localLong1);
    }
    if (IIIllIlI.isDebugEnabled())
      IIIllIlI.debug("[" + handler + "] executeTime: " + localLong1 + "ms");
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.interceptor.ExecuteTimeInterceptor
 * JD-Core Version:    0.6.2
 */