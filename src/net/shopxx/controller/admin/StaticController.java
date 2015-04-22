package net.shopxx.controller.admin;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.shopxx.entity.Article;
import net.shopxx.entity.ArticleCategory;
import net.shopxx.entity.Product;
import net.shopxx.entity.ProductCategory;
import net.shopxx.service.ArticleCategoryService;
import net.shopxx.service.ArticleService;
import net.shopxx.service.ProductCategoryService;
import net.shopxx.service.ProductService;
import net.shopxx.service.StaticService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("adminStaticController")
@RequestMapping({"/admin/static"})
public class StaticController extends BaseController
{

  @Resource(name="articleServiceImpl")
  private ArticleService IIIlllIl;

  @Resource(name="articleCategoryServiceImpl")
  private ArticleCategoryService IIIllllI;

  @Resource(name="productServiceImpl")
  private ProductService IIIlllll;

  @Resource(name="productCategoryServiceImpl")
  private ProductCategoryService IIlIIIII;

  @Resource(name="staticServiceImpl")
  private StaticService IIlIIIIl;

  @RequestMapping(value={"/build"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String build(ModelMap model)
  {
    model.addAttribute("buildTypes", StaticController.BuildType.values());
    model.addAttribute("defaultBeginDate", DateUtils.addDays(new Date(), -7));
    model.addAttribute("defaultEndDate", new Date());
    model.addAttribute("articleCategoryTree", this.IIIllllI.findChildren(null, null));
    model.addAttribute("productCategoryTree", this.IIlIIIII.findChildren(null, null));
    return "/admin/static/build";
  }

  @RequestMapping(value={"/build"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Map<String, Object> build(StaticController.BuildType buildType, Long articleCategoryId, Long productCategoryId, Date beginDate, Date endDate, Integer first, Integer count)
  {
    long l1 = System.currentTimeMillis();
    Calendar localCalendar;
    if (beginDate != null)
    {
      localCalendar = DateUtils.toCalendar(beginDate);
      localCalendar.set(11, localCalendar.getActualMinimum(11));
      localCalendar.set(12, localCalendar.getActualMinimum(12));
      localCalendar.set(13, localCalendar.getActualMinimum(13));
      beginDate = localCalendar.getTime();
    }
    if (endDate != null)
    {
      localCalendar = DateUtils.toCalendar(endDate);
      localCalendar.set(11, localCalendar.getActualMaximum(11));
      localCalendar.set(12, localCalendar.getActualMaximum(12));
      localCalendar.set(13, localCalendar.getActualMaximum(13));
      endDate = localCalendar.getTime();
    }
    if ((first == null) || (first.intValue() < 0))
      first = Integer.valueOf(0);
    if ((count == null) || (count.intValue() <= 0))
      count = Integer.valueOf(50);
    int i = 0;
    boolean bool = true;
    if (buildType == StaticController.BuildType.index)
    {
      i = this.IIlIIIIl.buildIndex();
    }
    else
    {
      Object localObject1;
      List localList;
      Iterator localIterator;
      if (buildType == StaticController.BuildType.article)
      {
        localObject1 = (ArticleCategory)this.IIIllllI.find(articleCategoryId);
        localList = this.IIIlllIl.findList((ArticleCategory)localObject1, beginDate, endDate, first, count);
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (Article)localIterator.next();
          i += this.IIlIIIIl.build((Article)localObject2);
        }
        first = Integer.valueOf(first.intValue() + localList.size());
        if (localList.size() == count.intValue())
          bool = false;
      }
      else if (buildType == StaticController.BuildType.product)
      {
        localObject1 = (ProductCategory)this.IIlIIIII.find(productCategoryId);
        localList = this.IIIlllll.findList((ProductCategory)localObject1, beginDate, endDate, first, count);
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (Product)localIterator.next();
          i += this.IIlIIIIl.build((Product)localObject2);
        }
        first = Integer.valueOf(first.intValue() + localList.size());
        if (localList.size() == count.intValue())
          bool = false;
      }
      else if (buildType == StaticController.BuildType.other)
      {
        i = this.IIlIIIIl.buildOther();
      }
    }
    long l2 = System.currentTimeMillis();
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("first", first);
    ((Map)localObject2).put("buildCount", Integer.valueOf(i));
    ((Map)localObject2).put("buildTime", Long.valueOf(l2 - l1));
    ((Map)localObject2).put("isCompleted", Boolean.valueOf(bool));
    return localObject2;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.StaticController
 * JD-Core Version:    0.6.2
 */