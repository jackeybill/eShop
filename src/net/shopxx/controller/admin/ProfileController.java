package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.entity.Admin;
import net.shopxx.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminProfileController")
@RequestMapping({"/admin/profile"})
public class ProfileController extends BaseController
{

  @Resource(name="adminServiceImpl")
  private AdminService IIIlllIl;

  @RequestMapping(value={"/check_current_password"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public boolean checkCurrentPassword(String currentPassword)
  {
    if (StringUtils.isEmpty(currentPassword))
      return false;
    Admin localAdmin = this.IIIlllIl.getCurrent();
    return StringUtils.equals(DigestUtils.md5Hex(currentPassword), localAdmin.getPassword());
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(ModelMap model)
  {
    model.addAttribute("admin", this.IIIlllIl.getCurrent());
    return "/admin/profile/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(String currentPassword, String password, String email, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(Admin.class, "email", email, new Class[0]))
      return "/admin/common/error";
    Admin localAdmin = this.IIIlllIl.getCurrent();
    if ((StringUtils.isNotEmpty(currentPassword)) && (StringUtils.isNotEmpty(password)))
    {
      if (!IIIllIlI(Admin.class, "password", password, new Class[0]))
        return "/admin/common/error";
      if (!StringUtils.equals(DigestUtils.md5Hex(currentPassword), localAdmin.getPassword()))
        return "/admin/common/error";
      localAdmin.setPassword(DigestUtils.md5Hex(password));
    }
    localAdmin.setEmail(email);
    this.IIIlllIl.update(localAdmin);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:edit.jhtml";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.ProfileController
 * JD-Core Version:    0.6.2
 */