package net.shopxx.util;

import java.util.Locale;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.LocaleResolver;

@Component("springUtils")
@Lazy(false)
public final class SpringUtils
  implements DisposableBean, ApplicationContextAware
{
  private static ApplicationContext IIIllIlI;

  public void setApplicationContext(ApplicationContext applicationContext)
  {
    IIIllIlI = applicationContext;
  }

  public void destroy()
  {
    IIIllIlI = null;
  }

  public static ApplicationContext getApplicationContext()
  {
    return IIIllIlI;
  }

  public static Object getBean(String name)
  {
    Assert.hasText(name);
    return IIIllIlI.getBean(name);
  }

  public static <T> T getBean(String name, Class<T> type)
  {
    Assert.hasText(name);
    Assert.notNull(type);
    return IIIllIlI.getBean(name, type);
  }

  public static String getMessage(String code, Object[] args)
  {
    LocaleResolver localLocaleResolver = (LocaleResolver)getBean("localeResolver", LocaleResolver.class);
    Locale localLocale = localLocaleResolver.resolveLocale(null);
    return IIIllIlI.getMessage(code, args, localLocale);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.util.SpringUtils
 * JD-Core Version:    0.6.2
 */