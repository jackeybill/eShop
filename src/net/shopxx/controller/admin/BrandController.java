package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.Brand;
import net.shopxx.entity.Brand.Type;
import net.shopxx.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminBrandController")
@RequestMapping({"/admin/brand"})
public class BrandController extends BaseController
{

  @Resource(name="brandServiceImpl")
  private BrandService IIIlllIl;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("types", Brand.Type.values());
    return "/admin/brand/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(Brand brand, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(brand, new Class[0]))
      return "/admin/common/error";
    if (brand.getType() == Brand.Type.text)
      brand.setLogo(null);
    else if (StringUtils.isEmpty(brand.getLogo()))
      return "/admin/common/error";
    brand.setProducts(null);
    brand.setProductCategories(null);
    brand.setPromotions(null);
    this.IIIlllIl.save(brand);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("types", Brand.Type.values());
    model.addAttribute("brand", this.IIIlllIl.find(id));
    return "/admin/brand/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Brand brand, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(brand, new Class[0]))
      return "/admin/common/error";
    if (brand.getType() == Brand.Type.text)
      brand.setLogo(null);
    else if (StringUtils.isEmpty(brand.getLogo()))
      return "/admin/common/error";
    this.IIIlllIl.update(brand, new String[] { "products", "productCategories", "promotions" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/brand/list";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    this.IIIlllIl.delete(ids);
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.BrandController
 * JD-Core Version:    0.6.2
 */