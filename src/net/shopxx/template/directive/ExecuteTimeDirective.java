package net.shopxx.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.Map;
import net.shopxx.interceptor.ExecuteTimeInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Component("executeTimeDirective")
public class ExecuteTimeDirective extends BaseDirective
{
  private static final String IIIllIlI = "executeTime";

  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
    if (localRequestAttributes != null)
    {
      Long localLong = (Long)localRequestAttributes.getAttribute(ExecuteTimeInterceptor.EXECUTE_TIME_ATTRIBUTE_NAME, 0);
      if (localLong != null)
        IIIllIlI("executeTime", localLong, env, body);
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.template.directive.ExecuteTimeDirective
 * JD-Core Version:    0.6.2
 */