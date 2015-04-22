package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.FriendLink;
import net.shopxx.entity.FriendLink.Type;
import net.shopxx.service.FriendLinkService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminFriendLinkController")
@RequestMapping({"/admin/friend_link"})
public class FriendLinkController extends BaseController
{

  @Resource(name="friendLinkServiceImpl")
  private FriendLinkService IIIlllIl;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("types", FriendLink.Type.values());
    return "/admin/friend_link/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(FriendLink friendLink, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(friendLink, new Class[0]))
      return "/admin/common/error";
    if (friendLink.getType() == FriendLink.Type.text)
      friendLink.setLogo(null);
    else if (StringUtils.isEmpty(friendLink.getLogo()))
      return "/admin/common/error";
    this.IIIlllIl.save(friendLink);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("types", FriendLink.Type.values());
    model.addAttribute("friendLink", this.IIIlllIl.find(id));
    return "/admin/friend_link/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(FriendLink friendLink, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(friendLink, new Class[0]))
      return "/admin/common/error";
    if (friendLink.getType() == FriendLink.Type.text)
      friendLink.setLogo(null);
    else if (StringUtils.isEmpty(friendLink.getLogo()))
      return "/admin/common/error";
    this.IIIlllIl.update(friendLink);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/friend_link/list";
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
 * Qualified Name:     net.shopxx.controller.admin.FriendLinkController
 * JD-Core Version:    0.6.2
 */