package net.shopxx.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.Resource;
import net.shopxx.entity.ProductCategory;
import net.shopxx.service.ProductCategoryService;
import net.shopxx.util.FreemarkerUtils;
import org.springframework.stereotype.Component;

@Component("productCategoryParentListDirective")
public class ProductCategoryParentListDirective extends BaseDirective
{
  private static final String IIIllIlI = "productCategoryId";
  private static final String IIIllIll = "productCategories";

  @Resource(name="productCategoryServiceImpl")
  private ProductCategoryService IIIlllII;

  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    Long localLong = (Long)FreemarkerUtils.getParameter("productCategoryId", Long.class, params);
    ProductCategory localProductCategory = (ProductCategory)this.IIIlllII.find(localLong);
    Object localObject;
    if ((localLong != null) && (localProductCategory == null))
    {
      localObject = new ArrayList();
    }
    else
    {
      boolean bool = IIIllIlI(env, params);
      String str = IIIllIll(env, params);
      Integer localInteger = IIIllIll(params);
      if (bool)
        localObject = this.IIIlllII.findParents(localProductCategory, localInteger, str);
      else
        localObject = this.IIIlllII.findParents(localProductCategory, localInteger);
    }
    IIIllIlI("productCategories", localObject, env, body);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.template.directive.ProductCategoryParentListDirective
 * JD-Core Version:    0.6.2
 */