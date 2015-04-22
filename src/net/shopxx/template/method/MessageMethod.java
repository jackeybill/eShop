package net.shopxx.template.method;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModel;
import java.util.List;
import net.shopxx.util.SpringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component("messageMethod")
public class MessageMethod
  implements TemplateMethodModel
{
  public Object exec(List arguments)
  {
    if ((arguments != null) && (!arguments.isEmpty()) && (arguments.get(0) != null) && (StringUtils.isNotEmpty(arguments.get(0).toString())))
    {
      String str1 = null;
      String str2 = arguments.get(0).toString();
      if (arguments.size() > 1)
      {
        Object[] arrayOfObject = arguments.subList(1, arguments.size()).toArray();
        str1 = SpringUtils.getMessage(str2, arrayOfObject);
      }
      else
      {
        str1 = SpringUtils.getMessage(str2, new Object[0]);
      }
      return new SimpleScalar(str1);
    }
    return null;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.template.method.MessageMethod
 * JD-Core Version:    0.6.2
 */