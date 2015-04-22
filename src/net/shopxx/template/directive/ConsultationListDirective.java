package net.shopxx.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.shopxx.entity.Brand;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.service.ConsultationService;
import net.shopxx.service.MemberService;
import net.shopxx.service.ProductService;
import net.shopxx.util.FreemarkerUtils;
import org.springframework.stereotype.Component;

@Component("consultationListDirective")
public class ConsultationListDirective extends BaseDirective
{
  private static final String IIIllIlI = "memberId";
  private static final String IIIllIll = "productId";
  private static final String IIIlllII = "consultations";

  @Resource(name="consultationServiceImpl")
  private ConsultationService IIIlllIl;

  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;

  @Resource(name="productServiceImpl")
  private ProductService IIIlllll;

  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    Long localLong1 = (Long)FreemarkerUtils.getParameter("memberId", Long.class, params);
    Long localLong2 = (Long)FreemarkerUtils.getParameter("productId", Long.class, params);
    Member localMember = (Member)this.IIIllllI.find(localLong1);
    Product localProduct = (Product)this.IIIlllll.find(localLong2);
    boolean bool = IIIllIlI(env, params);
    String str = IIIllIll(env, params);
    Integer localInteger = IIIllIll(params);
    List localList1 = IIIllIlI(params, Brand.class, new String[0]);
    List localList2 = IIIllIlI(params, new String[0]);
    Object localObject;
    if (((localLong1 != null) && (localMember == null)) || ((localLong2 != null) && (localProduct == null)))
      localObject = new ArrayList();
    else if (bool)
      localObject = this.IIIlllIl.findList(localMember, localProduct, Boolean.valueOf(true), localInteger, localList1, localList2, str);
    else
      localObject = this.IIIlllIl.findList(localMember, localProduct, Boolean.valueOf(true), localInteger, localList1, localList2);
    IIIllIlI("consultations", localObject, env, body);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.template.directive.ConsultationListDirective
 * JD-Core Version:    0.6.2
 */