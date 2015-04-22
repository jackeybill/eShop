package net.shopxx.controller.admin;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.Specification;
import net.shopxx.entity.Specification.Type;
import net.shopxx.entity.SpecificationValue;
import net.shopxx.service.SpecificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminSpecificationController")
@RequestMapping({"/admin/specification"})
public class SpecificationController extends BaseController
{

  @Resource(name="specificationServiceImpl")
  private SpecificationService IIIlllIl;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("types", Specification.Type.values());
    return "/admin/specification/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(Specification specification, RedirectAttributes redirectAttributes)
  {
    Iterator localIterator = specification.getSpecificationValues().iterator();
    while (localIterator.hasNext())
    {
      SpecificationValue localSpecificationValue = (SpecificationValue)localIterator.next();
      if ((localSpecificationValue == null) || (localSpecificationValue.getName() == null))
      {
        localIterator.remove();
      }
      else
      {
        if (specification.getType() == Specification.Type.text)
          localSpecificationValue.setImage(null);
        localSpecificationValue.setSpecification(specification);
      }
    }
    if (!IIIllIlI(specification, new Class[0]))
      return "/admin/common/error";
    specification.setProducts(null);
    this.IIIlllIl.save(specification);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("types", Specification.Type.values());
    model.addAttribute("specification", this.IIIlllIl.find(id));
    return "/admin/specification/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Specification specification, RedirectAttributes redirectAttributes)
  {
    Iterator localIterator = specification.getSpecificationValues().iterator();
    while (localIterator.hasNext())
    {
      SpecificationValue localSpecificationValue = (SpecificationValue)localIterator.next();
      if ((localSpecificationValue == null) || (localSpecificationValue.getName() == null))
      {
        localIterator.remove();
      }
      else
      {
        if (specification.getType() == Specification.Type.text)
          localSpecificationValue.setImage(null);
        localSpecificationValue.setSpecification(specification);
      }
    }
    if (!IIIllIlI(specification, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.update(specification, new String[] { "products" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/specification/list";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    if (ids != null)
    {
      for (Long localLong : ids)
      {
        Specification localSpecification = (Specification)this.IIIlllIl.find(localLong);
        if ((localSpecification != null) && (localSpecification.getProducts() != null) && (!localSpecification.getProducts().isEmpty()))
          return Message.error("admin.specification.deleteExistProductNotAllowed", new Object[] { localSpecification.getName() });
      }
      this.IIIlllIl.delete(ids);
    }
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.SpecificationController
 * JD-Core Version:    0.6.2
 */