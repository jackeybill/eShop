package net.shopxx.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.shopxx.entity.FriendLink;
import net.shopxx.service.FriendLinkService;
import org.springframework.stereotype.Component;

@Component("friendLinkListDirective")
public class FriendLinkListDirective extends BaseDirective
{
  private static final String IIIllIlI = "friendLinks";

  @Resource(name="friendLinkServiceImpl")
  private FriendLinkService IIIllIll;

  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    boolean bool = IIIllIlI(env, params);
    String str = IIIllIll(env, params);
    Integer localInteger = IIIllIll(params);
    List localList2 = IIIllIlI(params, FriendLink.class, new String[0]);
    List localList3 = IIIllIlI(params, new String[0]);
    List localList1;
    if (bool)
      localList1 = this.IIIllIll.findList(localInteger, localList2, localList3, str);
    else
      localList1 = this.IIIllIll.findList(localInteger, localList2, localList3);
    IIIllIlI("friendLinks", localList1, env, body);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.template.directive.FriendLinkListDirective
 * JD-Core Version:    0.6.2
 */