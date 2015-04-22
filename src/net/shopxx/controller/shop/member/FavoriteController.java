package net.shopxx.controller.shop.member;

import java.util.Set;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.controller.shop.BaseController;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.service.MemberService;
import net.shopxx.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopMemberFavoriteController")
@RequestMapping({"/member/favorite"})
public class FavoriteController extends BaseController
{
  private static final int IIIlllIl = 10;

  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;

  @Resource(name="productServiceImpl")
  private ProductService IIIlllll;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message add(Long id)
  {
    Product localProduct = (Product)this.IIIlllll.find(id);
    if (localProduct == null)
      return IIIllIll;
    Member localMember = this.IIIllllI.getCurrent();
    if (localMember.getFavoriteProducts().contains(localProduct))
      return Message.warn("shop.member.favorite.exist", new Object[0]);
    if ((Member.MAX_FAVORITE_COUNT != null) && (localMember.getFavoriteProducts().size() >= Member.MAX_FAVORITE_COUNT.intValue()))
      return Message.warn("shop.member.favorite.addCountNotAllowed", new Object[] { Member.MAX_FAVORITE_COUNT });
    localMember.getFavoriteProducts().add(localProduct);
    this.IIIllllI.update(localMember);
    return Message.success("shop.member.favorite.success", new Object[0]);
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Integer pageNumber, ModelMap model)
  {
    Member localMember = this.IIIllllI.getCurrent();
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("page", this.IIIlllll.findPage(localMember, localPageable));
    return "shop/member/favorite/list";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long id)
  {
    Product localProduct = (Product)this.IIIlllll.find(id);
    if (localProduct == null)
      return IIIllIll;
    Member localMember = this.IIIllllI.getCurrent();
    if (!localMember.getFavoriteProducts().contains(localProduct))
      return IIIllIll;
    localMember.getFavoriteProducts().remove(localProduct);
    this.IIIllllI.update(localMember);
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.member.FavoriteController
 * JD-Core Version:    0.6.2
 */