package net.shopxx.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.io.Writer;
import java.util.Map;
import net.shopxx.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Component("flashMessageDirective")
public class FlashMessageDirective extends BaseDirective
{
  public static final String FLASH_MESSAGE_ATTRIBUTE_NAME = FlashMessageDirective.class.getName() + ".FLASH_MESSAGE";
  private static final String IIIllIlI = "flashMessage";

  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
    if (localRequestAttributes != null)
    {
      Message localMessage = (Message)localRequestAttributes.getAttribute(FLASH_MESSAGE_ATTRIBUTE_NAME, 0);
      if (body != null)
      {
        IIIllIlI("flashMessage", localMessage, env, body);
      }
      else if (localMessage != null)
      {
        Writer localWriter = env.getOut();
        localWriter.write("$.message(\"" + localMessage.getType() + "\", \"" + localMessage.getContent() + "\");");
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.template.directive.FlashMessageDirective
 * JD-Core Version:    0.6.2
 */