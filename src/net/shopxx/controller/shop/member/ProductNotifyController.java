package net.shopxx.controller.shop.member;

import java.util.Set;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.controller.shop.BaseController;
import net.shopxx.entity.Member;
import net.shopxx.entity.ProductNotify;
import net.shopxx.service.MemberService;
import net.shopxx.service.ProductNotifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopMemberProductNotifyController")
@RequestMapping({"/member/product_notify"})
public class ProductNotifyController extends BaseController
{
  private static final int IIIlllll = 10;

  @Resource(name="productNotifyServiceImpl")
  ProductNotifyService IIIlllIl;

  @Resource(name="memberServiceImpl")
  MemberService IIIllllI;

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Integer pageNumber, Model model)
  {
    Member localMember = this.IIIllllI.getCurrent();
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("page", this.IIIlllIl.findPage(localMember, null, null, null, localPageable));
    return "/shop/member/product_notify/list";
  }

  @RequestMapping({"delete"})
  @ResponseBody
  public Message delete(Long id)
  {
    ProductNotify localProductNotify = (ProductNotify)this.IIIlllIl.find(id);
    if (localProductNotify == null)
      return IIIllIll;
    Member localMember = this.IIIllllI.getCurrent();
    if (!localMember.getProductNotifies().contains(localProductNotify))
      return IIIllIll;
    this.IIIlllIl.delete(localProductNotify);
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.member.ProductNotifyController
 * JD-Core Version:    0.6.2
 */