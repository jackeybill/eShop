package net.shopxx.template.directive;

import freemarker.core.Environment;
import freemarker.template.Template;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateModel;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.shopxx.Filter;
import net.shopxx.Order;
import net.shopxx.Order.Direction;
import net.shopxx.util.FreemarkerUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public abstract class BaseDirective
  implements TemplateDirectiveModel
{
  private static final String IIIllIlI = "useCache";
  private static final String IIIllIll = "cacheRegion";
  private static final String IIIlllII = "id";
  private static final String IIIlllIl = "count";
  private static final String IIIllllI = "orderBy";
  private static final String IIIlllll = "\\s*,\\s*";
  private static final String IIlIIIII = "\\s+";

  protected boolean IIIllIlI(Environment paramEnvironment, Map<String, TemplateModel> paramMap)
  {
    Boolean localBoolean = (Boolean)FreemarkerUtils.getParameter("useCache", Boolean.class, paramMap);
    return localBoolean != null ? localBoolean.booleanValue() : true;
  }

  protected String IIIllIll(Environment paramEnvironment, Map<String, TemplateModel> paramMap)
  {
    String str = (String)FreemarkerUtils.getParameter("cacheRegion", String.class, paramMap);
    return str != null ? str : paramEnvironment.getTemplate().getName();
  }

  protected Long IIIllIlI(Map<String, TemplateModel> paramMap)
  {
    return (Long)FreemarkerUtils.getParameter("id", Long.class, paramMap);
  }

  protected Integer IIIllIll(Map<String, TemplateModel> paramMap)
  {
    return (Integer)FreemarkerUtils.getParameter("count", Integer.class, paramMap);
  }

  protected List<Filter> IIIllIlI(Map<String, TemplateModel> paramMap, Class<?> paramClass, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    PropertyDescriptor[] arrayOfPropertyDescriptor1 = PropertyUtils.getPropertyDescriptors(paramClass);
    for (PropertyDescriptor localPropertyDescriptor : arrayOfPropertyDescriptor1)
    {
      String str = localPropertyDescriptor.getName();
      Class localClass = localPropertyDescriptor.getPropertyType();
      if ((!ArrayUtils.contains(paramArrayOfString, str)) && (paramMap.containsKey(str)))
      {
        Object localObject = FreemarkerUtils.getParameter(str, localClass, paramMap);
        localArrayList.add(Filter.eq(str, localObject));
      }
    }
    return localArrayList;
  }

  protected List<Order> IIIllIlI(Map<String, TemplateModel> paramMap, String[] paramArrayOfString)
  {
    String str1 = StringUtils.trim((String)FreemarkerUtils.getParameter("orderBy", String.class, paramMap));
    ArrayList localArrayList = new ArrayList();
    if (StringUtils.isNotEmpty(str1))
    {
      String[] arrayOfString1 = str1.split("\\s*,\\s*");
      for (String str2 : arrayOfString1)
        if (StringUtils.isNotEmpty(str2))
        {
          Object localObject = null;
          Order.Direction localDirection = null;
          String[] arrayOfString3 = str2.split("\\s+");
          if (arrayOfString3.length == 1)
          {
            localObject = arrayOfString3[0];
          }
          else
          {
            if (arrayOfString3.length < 2)
              continue;
            localObject = arrayOfString3[0];
            try
            {
              localDirection = Order.Direction.valueOf(arrayOfString3[1]);
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              continue;
            }
          }
          if (!ArrayUtils.contains(paramArrayOfString, localObject))
            localArrayList.add(new Order(localObject, localDirection));
        }
    }
    return localArrayList;
  }

  protected void IIIllIlI(String paramString, Object paramObject, Environment paramEnvironment, TemplateDirectiveBody paramTemplateDirectiveBody)
  {
    TemplateModel localTemplateModel = FreemarkerUtils.getVariable(paramString, paramEnvironment);
    FreemarkerUtils.setVariable(paramString, paramObject, paramEnvironment);
    paramTemplateDirectiveBody.render(paramEnvironment.getOut());
    FreemarkerUtils.setVariable(paramString, localTemplateModel, paramEnvironment);
  }

  protected void IIIllIlI(Map<String, Object> paramMap, Environment paramEnvironment, TemplateDirectiveBody paramTemplateDirectiveBody)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      TemplateModel localTemplateModel = FreemarkerUtils.getVariable(str, paramEnvironment);
      localHashMap.put(str, localTemplateModel);
    }
    FreemarkerUtils.setVariables(paramMap, paramEnvironment);
    paramTemplateDirectiveBody.render(paramEnvironment.getOut());
    FreemarkerUtils.setVariables(localHashMap, paramEnvironment);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.template.directive.BaseDirective
 * JD-Core Version:    0.6.2
 */