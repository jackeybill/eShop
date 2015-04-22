package net.shopxx.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Resource;
import net.shopxx.entity.Article;
import net.shopxx.entity.Attribute;
import net.shopxx.entity.Brand;
import net.shopxx.entity.Product.OrderType;
import net.shopxx.entity.ProductCategory;
import net.shopxx.entity.Promotion;
import net.shopxx.service.AttributeService;
import net.shopxx.service.BrandService;
import net.shopxx.service.ProductCategoryService;
import net.shopxx.service.ProductService;
import net.shopxx.service.PromotionService;
import net.shopxx.service.TagService;
import net.shopxx.util.FreemarkerUtils;
import org.springframework.stereotype.Component;

@Component("productListDirective")
public class ProductListDirective extends BaseDirective
{
  private static final String IIIllIlI = "productCategoryId";
  private static final String IIIllIll = "brandId";
  private static final String IIIlllII = "promotionId";
  private static final String IIIlllIl = "tagIds";
  private static final String IIIllllI = "attributeValue";
  private static final String IIIlllll = "startPrice";
  private static final String IIlIIIII = "endPrice";
  private static final String IIlIIIIl = "orderType";
  private static final String IIlIIIlI = "products";

  @Resource(name="productServiceImpl")
  private ProductService IIlIIIll;

  @Resource(name="productCategoryServiceImpl")
  private ProductCategoryService IIlIIlII;

  @Resource(name="brandServiceImpl")
  private BrandService IIlIIlIl;

  @Resource(name="promotionServiceImpl")
  private PromotionService IIlIIllI;

  @Resource(name="attributeServiceImpl")
  private AttributeService IIlIIlll;

  @Resource(name="tagServiceImpl")
  private TagService IIlIlIII;

  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    Long localLong1 = (Long)FreemarkerUtils.getParameter("productCategoryId", Long.class, params);
    Long localLong2 = (Long)FreemarkerUtils.getParameter("brandId", Long.class, params);
    Long localLong3 = (Long)FreemarkerUtils.getParameter("promotionId", Long.class, params);
    Long[] arrayOfLong = (Long[])FreemarkerUtils.getParameter("tagIds", [Ljava.lang.Long.class, params);
    Map localMap = (Map)FreemarkerUtils.getParameter("attributeValue", Map.class, params);
    BigDecimal localBigDecimal1 = (BigDecimal)FreemarkerUtils.getParameter("startPrice", BigDecimal.class, params);
    BigDecimal localBigDecimal2 = (BigDecimal)FreemarkerUtils.getParameter("endPrice", BigDecimal.class, params);
    Product.OrderType localOrderType = (Product.OrderType)FreemarkerUtils.getParameter("orderType", Product.OrderType.class, params);
    ProductCategory localProductCategory = (ProductCategory)this.IIlIIlII.find(localLong1);
    Brand localBrand = (Brand)this.IIlIIlIl.find(localLong2);
    Promotion localPromotion = (Promotion)this.IIlIIllI.find(localLong3);
    List localList1 = this.IIlIlIII.findList(arrayOfLong);
    HashMap localHashMap = new HashMap();
    Object localObject1;
    Object localObject2;
    if (localMap != null)
    {
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        localObject2 = (Attribute)this.IIlIIlll.find((Long)((Map.Entry)localObject1).getKey());
        if (localObject2 != null)
          localHashMap.put(localObject2, (String)((Map.Entry)localObject1).getValue());
      }
    }
    if (((localLong1 != null) && (localProductCategory == null)) || ((localLong2 != null) && (localBrand == null)) || ((localLong3 != null) && (localPromotion == null)) || ((arrayOfLong != null) && (localList1.isEmpty())) || ((localMap != null) && (localHashMap.isEmpty())))
    {
      localObject1 = new ArrayList();
    }
    else
    {
      boolean bool = IIIllIlI(env, params);
      localObject2 = IIIllIll(env, params);
      Integer localInteger = IIIllIll(params);
      List localList2 = IIIllIlI(params, Article.class, new String[0]);
      List localList3 = IIIllIlI(params, new String[0]);
      if (bool)
        localObject1 = this.IIlIIIll.findList(localProductCategory, localBrand, localPromotion, localList1, localHashMap, localBigDecimal1, localBigDecimal2, Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(false), null, null, localOrderType, localInteger, localList2, localList3, (String)localObject2);
      else
        localObject1 = this.IIlIIIll.findList(localProductCategory, localBrand, localPromotion, localList1, localHashMap, localBigDecimal1, localBigDecimal2, Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(false), null, null, localOrderType, localInteger, localList2, localList3);
    }
    IIIllIlI("products", localObject1, env, body);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.template.directive.ProductListDirective
 * JD-Core Version:    0.6.2
 */