package net.shopxx.controller.admin;

import java.util.ArrayList;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.entity.Area;
import net.shopxx.service.AreaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminAreaController")
@RequestMapping({"/admin/area"})
public class AreaController extends BaseController
{

  @Resource(name="areaServiceImpl")
  private AreaService IIIlllIl;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(Long parentId, ModelMap model)
  {
    model.addAttribute("parent", this.IIIlllIl.find(parentId));
    return "/admin/area/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(Area area, Long parentId, RedirectAttributes redirectAttributes)
  {
    area.setParent((Area)this.IIIlllIl.find(parentId));
    if (!IIIllIlI(area, new Class[0]))
      return "/admin/common/error";
    area.setFullName(null);
    area.setTreePath(null);
    area.setChildren(null);
    area.setMembers(null);
    area.setReceivers(null);
    area.setOrders(null);
    area.setDeliveryCenters(null);
    this.IIIlllIl.save(area);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("area", this.IIIlllIl.find(id));
    return "/admin/area/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Area area, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(area, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.update(area, new String[] { "fullName", "treePath", "parent", "children", "members", "receivers", "orders", "deliveryCenters" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Long parentId, ModelMap model)
  {
    Area localArea = (Area)this.IIIlllIl.find(parentId);
    if (localArea != null)
    {
      model.addAttribute("parent", localArea);
      model.addAttribute("areas", new ArrayList(localArea.getChildren()));
    }
    else
    {
      model.addAttribute("areas", this.IIIlllIl.findRoots());
    }
    return "/admin/area/list";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long id)
  {
    this.IIIlllIl.delete(id);
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.AreaController
 * JD-Core Version:    0.6.2
 */