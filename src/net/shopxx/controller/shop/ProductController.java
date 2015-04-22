package net.shopxx.controller.shop;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.shopxx.Pageable;
import net.shopxx.ResourceNotFoundException;
import net.shopxx.entity.Attribute;
import net.shopxx.entity.Brand;
import net.shopxx.entity.Product;
import net.shopxx.entity.Product.OrderType;
import net.shopxx.entity.ProductCategory;
import net.shopxx.entity.Promotion;
import net.shopxx.service.BrandService;
import net.shopxx.service.ProductCategoryService;
import net.shopxx.service.ProductService;
import net.shopxx.service.PromotionService;
import net.shopxx.service.SearchService;
import net.shopxx.service.TagService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopProductController")
@RequestMapping({"/product"})
public class ProductController extends BaseController
{

  @Resource(name="productServiceImpl")
  private ProductService IIIlllIl;

  @Resource(name="productCategoryServiceImpl")
  private ProductCategoryService IIIllllI;

  @Resource(name="brandServiceImpl")
  private BrandService IIIlllll;

  @Resource(name="promotionServiceImpl")
  private PromotionService IIlIIIII;

  @Resource(name="tagServiceImpl")
  private TagService IIlIIIIl;

  @Resource(name="searchServiceImpl")
  private SearchService IIlIIIlI;

  @RequestMapping(value={"/history"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public List<Product> history(Long[] ids)
  {
    return this.IIIlllIl.findList(ids);
  }

  @RequestMapping(value={"/list/{productCategoryId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(@PathVariable Long productCategoryId, Long brandId, Long promotionId, Long[] tagIds, BigDecimal startPrice, BigDecimal endPrice, Product.OrderType orderType, Integer pageNumber, Integer pageSize, HttpServletRequest request, ModelMap model)
  {
    ProductCategory localProductCategory = (ProductCategory)this.IIIllllI.find(productCategoryId);
    if (localProductCategory == null)
      throw new ResourceNotFoundException();
    Brand localBrand = (Brand)this.IIIlllll.find(brandId);
    Promotion localPromotion = (Promotion)this.IIlIIIII.find(promotionId);
    List localList = this.IIlIIIIl.findList(tagIds);
    HashMap localHashMap = new HashMap();
    if (localProductCategory != null)
    {
      localObject = localProductCategory.getAttributes();
      Iterator localIterator = ((Set)localObject).iterator();
      while (localIterator.hasNext())
      {
        Attribute localAttribute = (Attribute)localIterator.next();
        String str = request.getParameter("attribute_" + localAttribute.getId());
        if (StringUtils.isNotEmpty(str))
          localHashMap.put(localAttribute, str);
      }
    }
    Object localObject = new Pageable(pageNumber, pageSize);
    model.addAttribute("orderTypes", Product.OrderType.values());
    model.addAttribute("productCategory", localProductCategory);
    model.addAttribute("brand", localBrand);
    model.addAttribute("promotion", localPromotion);
    model.addAttribute("tags", localList);
    model.addAttribute("attributeValue", localHashMap);
    model.addAttribute("startPrice", startPrice);
    model.addAttribute("endPrice", endPrice);
    model.addAttribute("orderType", orderType);
    model.addAttribute("pageNumber", pageNumber);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("page", this.IIIlllIl.findPage(localProductCategory, localBrand, localPromotion, localList, localHashMap, startPrice, endPrice, Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(false), null, null, orderType, (Pageable)localObject));
    return "/shop/product/list";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Long brandId, Long promotionId, Long[] tagIds, BigDecimal startPrice, BigDecimal endPrice, Product.OrderType orderType, Integer pageNumber, Integer pageSize, HttpServletRequest request, ModelMap model)
  {
    Brand localBrand = (Brand)this.IIIlllll.find(brandId);
    Promotion localPromotion = (Promotion)this.IIlIIIII.find(promotionId);
    List localList = this.IIlIIIIl.findList(tagIds);
    Pageable localPageable = new Pageable(pageNumber, pageSize);
    model.addAttribute("orderTypes", Product.OrderType.values());
    model.addAttribute("brand", localBrand);
    model.addAttribute("promotion", localPromotion);
    model.addAttribute("tags", localList);
    model.addAttribute("startPrice", startPrice);
    model.addAttribute("endPrice", endPrice);
    model.addAttribute("orderType", orderType);
    model.addAttribute("pageNumber", pageNumber);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("page", this.IIIlllIl.findPage(null, localBrand, localPromotion, localList, null, startPrice, endPrice, Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(false), null, null, orderType, localPageable));
    return "/shop/product/list";
  }

  @RequestMapping(value={"/search"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String search(String keyword, BigDecimal startPrice, BigDecimal endPrice, Product.OrderType orderType, Integer pageNumber, Integer pageSize, ModelMap model)
  {
    if (StringUtils.isEmpty(keyword))
      return "/shop/common/error";
    Pageable localPageable = new Pageable(pageNumber, pageSize);
    model.addAttribute("orderTypes", Product.OrderType.values());
    model.addAttribute("productKeyword", keyword);
    model.addAttribute("startPrice", startPrice);
    model.addAttribute("endPrice", endPrice);
    model.addAttribute("orderType", orderType);
    model.addAttribute("page", this.IIlIIIlI.search(keyword, startPrice, endPrice, orderType, localPageable));
    return "shop/product/search";
  }

  @RequestMapping(value={"/hits/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public Long hits(@PathVariable Long id)
  {
    return Long.valueOf(this.IIIlllIl.viewHits(id));
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.ProductController
 * JD-Core Version:    0.6.2
 */