package net.shopxx.controller.shop;

import javax.annotation.Resource;
import net.shopxx.entity.FriendLink.Type;
import net.shopxx.service.FriendLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopFriendLinkController")
@RequestMapping({"/friend_link"})
public class FriendLinkController extends BaseController
{

  @Resource(name="friendLinkServiceImpl")
  private FriendLinkService IIIlllIl;

  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String index(ModelMap model)
  {
    model.addAttribute("textFriendLinks", this.IIIlllIl.findList(FriendLink.Type.text));
    model.addAttribute("imageFriendLinks", this.IIIlllIl.findList(FriendLink.Type.image));
    return "/shop/friend_link/index";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.FriendLinkController
 * JD-Core Version:    0.6.2
 */