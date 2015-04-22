package net.shopxx.controller.shop;

import javax.annotation.Resource;
import net.shopxx.service.ProductCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopProductCategoryController")
@RequestMapping({"/product_category"})
public class ProductCategoryController extends BaseController
{

  @Resource(name="productCategoryServiceImpl")
  private ProductCategoryService IIIlllIl;

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String index(ModelMap model)
  {
    model.addAttribute("rootProductCategories", this.IIIlllIl.findRoots());
    return "/shop/product_category/index";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.ProductCategoryController
 * JD-Core Version:    0.6.2
 */