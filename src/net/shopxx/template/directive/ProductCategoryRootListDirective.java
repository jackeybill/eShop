package net.shopxx.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.shopxx.service.ProductCategoryService;
import org.springframework.stereotype.Component;

@Component("productCategoryRootListDirective")
public class ProductCategoryRootListDirective extends BaseDirective
{
  private static final String IIIllIlI = "productCategories";

  @Resource(name="productCategoryServiceImpl")
  private ProductCategoryService IIIllIll;

  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    boolean bool = IIIllIlI(env, params);
    String str = IIIllIll(env, params);
    Integer localInteger = IIIllIll(params);
    List localList;
    if (bool)
      localList = this.IIIllIll.findRoots(localInteger, str);
    else
      localList = this.IIIllIll.findRoots(localInteger);
    IIIllIlI("productCategories", localList, env, body);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.template.directive.ProductCategoryRootListDirective
 * JD-Core Version:    0.6.2
 */