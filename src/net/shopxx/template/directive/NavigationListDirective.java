package net.shopxx.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.shopxx.entity.Navigation;
import net.shopxx.service.NavigationService;
import org.springframework.stereotype.Component;

@Component("navigationListDirective")
public class NavigationListDirective extends BaseDirective
{
  private static final String IIIllIlI = "navigations";

  @Resource(name="navigationServiceImpl")
  private NavigationService IIIllIll;

  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    boolean bool = IIIllIlI(env, params);
    String str = IIIllIll(env, params);
    Integer localInteger = IIIllIll(params);
    List localList2 = IIIllIlI(params, Navigation.class, new String[0]);
    List localList3 = IIIllIlI(params, new String[0]);
    List localList1;
    if (bool)
      localList1 = this.IIIllIll.findList(localInteger, localList2, localList3, str);
    else
      localList1 = this.IIIllIll.findList(localInteger, localList2, localList3);
    IIIllIlI("navigations", localList1, env, body);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.template.directive.NavigationListDirective
 * JD-Core Version:    0.6.2
 */