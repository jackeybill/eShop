package net.shopxx.util;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.utility.DeepUnwrap;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import net.shopxx.CommonAttributes;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

public final class FreemarkerUtils
{
  private static final ConvertUtilsBean IIIllIlI = new FreemarkerUtils.1();

  static
  {
    DateConverter localDateConverter = new DateConverter();
    localDateConverter.setPatterns(CommonAttributes.DATE_PATTERNS);
    IIIllIlI.register(localDateConverter, Date.class);
  }

  public static String process(String template, Map<String, ?> model)
  {
    Configuration localConfiguration = null;
    ApplicationContext localApplicationContext = SpringUtils.getApplicationContext();
    if (localApplicationContext != null)
    {
      FreeMarkerConfigurer localFreeMarkerConfigurer = (FreeMarkerConfigurer)SpringUtils.getBean("freeMarkerConfigurer", FreeMarkerConfigurer.class);
      if (localFreeMarkerConfigurer != null)
        localConfiguration = localFreeMarkerConfigurer.getConfiguration();
    }
    return process(template, model, localConfiguration);
  }

  public static String process(String template, Map<String, ?> model, Configuration configuration)
  {
    if (template == null)
      return null;
    if (configuration == null)
      configuration = new Configuration();
    StringWriter localStringWriter = new StringWriter();
    try
    {
      new Template("template", new StringReader(template), configuration).process(model, localStringWriter);
    }
    catch (TemplateException localTemplateException)
    {
      localTemplateException.printStackTrace();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localStringWriter.toString();
  }

  public static <T> T getParameter(String name, Class<T> type, Map<String, TemplateModel> params)
  {
    Assert.hasText(name);
    Assert.notNull(type);
    Assert.notNull(params);
    TemplateModel localTemplateModel = (TemplateModel)params.get(name);
    if (localTemplateModel == null)
      return null;
    Object localObject = DeepUnwrap.unwrap(localTemplateModel);
    return IIIllIlI.convert(localObject, type);
  }

  public static TemplateModel getVariable(String name, Environment env)
  {
    Assert.hasText(name);
    Assert.notNull(env);
    return env.getVariable(name);
  }

  public static void setVariable(String name, Object value, Environment env)
  {
    Assert.hasText(name);
    Assert.notNull(env);
    if ((value instanceof TemplateModel))
      env.setVariable(name, (TemplateModel)value);
    else
      env.setVariable(name, ObjectWrapper.BEANS_WRAPPER.wrap(value));
  }

  public static void setVariables(Map<String, Object> variables, Environment env)
  {
    Assert.notNull(variables);
    Assert.notNull(env);
    Iterator localIterator = variables.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof TemplateModel))
        env.setVariable(str, (TemplateModel)localObject);
      else
        env.setVariable(str, ObjectWrapper.BEANS_WRAPPER.wrap(localObject));
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.util.FreemarkerUtils
 * JD-Core Version:    0.6.2
 */