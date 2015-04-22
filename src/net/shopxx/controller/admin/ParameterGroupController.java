package net.shopxx.controller.admin;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.Parameter;
import net.shopxx.entity.ParameterGroup;
import net.shopxx.entity.ProductCategory;
import net.shopxx.service.ParameterGroupService;
import net.shopxx.service.ProductCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminParameterGroupController")
@RequestMapping({"/admin/parameter_group"})
public class ParameterGroupController extends BaseController
{

  @Resource(name="parameterGroupServiceImpl")
  private ParameterGroupService IIIlllIl;

  @Resource(name="productCategoryServiceImpl")
  private ProductCategoryService IIIllllI;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("productCategoryTree", this.IIIllllI.findTree());
    return "/admin/parameter_group/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(ParameterGroup parameterGroup, Long productCategoryId, RedirectAttributes redirectAttributes)
  {
    Iterator localIterator = parameterGroup.getParameters().iterator();
    while (localIterator.hasNext())
    {
      Parameter localParameter = (Parameter)localIterator.next();
      if ((localParameter == null) || (localParameter.getName() == null))
        localIterator.remove();
      else
        localParameter.setParameterGroup(parameterGroup);
    }
    parameterGroup.setProductCategory((ProductCategory)this.IIIllllI.find(productCategoryId));
    if (!IIIllIlI(parameterGroup, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.save(parameterGroup);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("parameterGroup", this.IIIlllIl.find(id));
    model.addAttribute("productCategoryTree", this.IIIllllI.findTree());
    return "/admin/parameter_group/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(ParameterGroup parameterGroup, Long productCategoryId, RedirectAttributes redirectAttributes)
  {
    Iterator localIterator = parameterGroup.getParameters().iterator();
    while (localIterator.hasNext())
    {
      Parameter localParameter = (Parameter)localIterator.next();
      if ((localParameter == null) || (localParameter.getName() == null))
        localIterator.remove();
      else
        localParameter.setParameterGroup(parameterGroup);
    }
    parameterGroup.setProductCategory((ProductCategory)this.IIIllllI.find(productCategoryId));
    if (!IIIllIlI(parameterGroup, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.update(parameterGroup);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/parameter_group/list";
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
 * Qualified Name:     net.shopxx.controller.admin.ParameterGroupController
 * JD-Core Version:    0.6.2
 */