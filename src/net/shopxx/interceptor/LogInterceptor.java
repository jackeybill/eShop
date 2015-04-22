package net.shopxx.interceptor;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.shopxx.LogConfig;
import net.shopxx.entity.Log;
import net.shopxx.service.AdminService;
import net.shopxx.service.LogConfigService;
import net.shopxx.service.LogService;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter
{
  private static final String[] IIIllIlI = { "password", "rePassword", "currentPassword" };
  private static AntPathMatcher IIIllIll = new AntPathMatcher();
  private String[] IIIlllII = IIIllIlI;

  @Resource(name="logConfigServiceImpl")
  private LogConfigService IIIlllIl;

  @Resource(name="logServiceImpl")
  private LogService IIIllllI;

  @Resource(name="adminServiceImpl")
  private AdminService IIIlllll;

  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
  {
    List localList = this.IIIlllIl.getAll();
    if (localList != null)
    {
      String str1 = request.getServletPath();
      Iterator localIterator1 = localList.iterator();
      while (localIterator1.hasNext())
      {
        LogConfig localLogConfig = (LogConfig)localIterator1.next();
        if (IIIllIll.match(localLogConfig.getUrlPattern(), str1))
        {
          String str2 = this.IIIlllll.getCurrentUsername();
          String str3 = localLogConfig.getOperation();
          String str4 = str2;
          String str5 = (String)request.getAttribute(Log.LOG_CONTENT_ATTRIBUTE_NAME);
          String str6 = request.getRemoteAddr();
          request.removeAttribute(Log.LOG_CONTENT_ATTRIBUTE_NAME);
          StringBuffer localStringBuffer = new StringBuffer();
          Map localMap = request.getParameterMap();
          if (localMap != null)
          {
            Iterator localIterator2 = localMap.entrySet().iterator();
            while (localIterator2.hasNext())
            {
              localObject = (Map.Entry)localIterator2.next();
              String str7 = (String)((Map.Entry)localObject).getKey();
              if (!ArrayUtils.contains(this.IIIlllII, str7))
              {
                String[] arrayOfString1 = (String[])((Map.Entry)localObject).getValue();
                if (arrayOfString1 != null)
                  for (String str8 : arrayOfString1)
                    localStringBuffer.append(str7 + " = " + str8 + "\n");
              }
            }
          }
          Object localObject = new Log();
          ((Log)localObject).setOperation(str3);
          ((Log)localObject).setOperator(str4);
          ((Log)localObject).setContent(str5);
          ((Log)localObject).setParameter(localStringBuffer.toString());
          ((Log)localObject).setIp(str6);
          this.IIIllllI.save(localObject);
          break;
        }
      }
    }
  }

  public String[] getIgnoreParameters()
  {
    return this.IIIlllII;
  }

  public void setIgnoreParameters(String[] ignoreParameters)
  {
    this.IIIlllII = ignoreParameters;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.interceptor.LogInterceptor
 * JD-Core Version:    0.6.2
 */