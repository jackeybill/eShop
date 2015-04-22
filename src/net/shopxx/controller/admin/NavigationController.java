package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.Navigation;
import net.shopxx.entity.Navigation.Position;
import net.shopxx.service.ArticleCategoryService;
import net.shopxx.service.NavigationService;
import net.shopxx.service.ProductCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminNavigationController")
@RequestMapping({"/admin/navigation"})
public class NavigationController extends BaseController
{

  @Resource(name="navigationServiceImpl")
  private NavigationService IIIlllIl;

  @Resource(name="articleCategoryServiceImpl")
  private ArticleCategoryService IIIllllI;

  @Resource(name="productCategoryServiceImpl")
  private ProductCategoryService IIIlllll;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("positions", Navigation.Position.values());
    model.addAttribute("articleCategoryTree", this.IIIllllI.findTree());
    model.addAttribute("productCategoryTree", this.IIIlllll.findTree());
    return "/admin/navigation/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(Navigation navigation, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(navigation, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.save(navigation);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("positions", Navigation.Position.values());
    model.addAttribute("articleCategoryTree", this.IIIllllI.findTree());
    model.addAttribute("productCategoryTree", this.IIIlllll.findTree());
    model.addAttribute("navigation", this.IIIlllIl.find(id));
    return "/admin/navigation/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Navigation navigation, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(navigation, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.update(navigation);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("topNavigations", this.IIIlllIl.findList(Navigation.Position.top));
    model.addAttribute("middleNavigations", this.IIIlllIl.findList(Navigation.Position.middle));
    model.addAttribute("bottomNavigations", this.IIIlllIl.findList(Navigation.Position.bottom));
    return "/admin/navigation/list";
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
 * Qualified Name:     net.shopxx.controller.admin.NavigationController
 * JD-Core Version:    0.6.2
 */