package net.shopxx.controller.admin;

import java.util.Set;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.Role;
import net.shopxx.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminRoleController")
@RequestMapping({"/admin/role"})
public class RoleController extends BaseController
{

  @Resource(name="roleServiceImpl")
  private RoleService IIIlllIl;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add()
  {
    return "/admin/role/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(Role role, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(role, new Class[0]))
      return "/admin/common/error";
    role.setIsSystem(Boolean.valueOf(false));
    role.setAdmins(null);
    this.IIIlllIl.save(role);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("role", this.IIIlllIl.find(id));
    return "/admin/role/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Role role, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(role, new Class[0]))
      return "/admin/common/error";
    Role localRole = (Role)this.IIIlllIl.find(role.getId());
    if ((localRole == null) || (localRole.getIsSystem().booleanValue()))
      return "/admin/common/error";
    this.IIIlllIl.update(role, new String[] { "isSystem", "admins" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/role/list";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    if (ids != null)
    {
      for (Long localLong : ids)
      {
        Role localRole = (Role)this.IIIlllIl.find(localLong);
        if ((localRole != null) && ((localRole.getIsSystem().booleanValue()) || ((localRole.getAdmins() != null) && (!localRole.getAdmins().isEmpty()))))
          return Message.error("admin.role.deleteExistNotAllowed", new Object[] { localRole.getName() });
      }
      this.IIIlllIl.delete(ids);
    }
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.RoleController
 * JD-Core Version:    0.6.2
 */