package net.shopxx.controller.shop.member;

import javax.annotation.Resource;
import net.shopxx.controller.shop.BaseController;
import net.shopxx.entity.Member;
import net.shopxx.service.ConsultationService;
import net.shopxx.service.CouponCodeService;
import net.shopxx.service.MemberService;
import net.shopxx.service.MessageService;
import net.shopxx.service.OrderService;
import net.shopxx.service.ProductNotifyService;
import net.shopxx.service.ProductService;
import net.shopxx.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopMemberController")
@RequestMapping({"/member"})
public class MemberController extends BaseController
{
  private static final int IIIlllIl = 6;

  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;

  @Resource(name="orderServiceImpl")
  private OrderService IIIlllll;

  @Resource(name="couponCodeServiceImpl")
  private CouponCodeService IIlIIIII;

  @Resource(name="messageServiceImpl")
  private MessageService IIlIIIIl;

  @Resource(name="productServiceImpl")
  private ProductService IIlIIIlI;

  @Resource(name="productNotifyServiceImpl")
  private ProductNotifyService IIlIIIll;

  @Resource(name="reviewServiceImpl")
  private ReviewService IIlIIlII;

  @Resource(name="consultationServiceImpl")
  private ConsultationService IIlIIlIl;

  @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String index(Integer pageNumber, ModelMap model)
  {
    Member localMember = this.IIIllllI.getCurrent();
    model.addAttribute("waitingPaymentOrderCount", this.IIIlllll.waitingPaymentCount(localMember));
    model.addAttribute("waitingShippingOrderCount", this.IIIlllll.waitingShippingCount(localMember));
    model.addAttribute("messageCount", this.IIlIIIIl.count(localMember, Boolean.valueOf(false)));
    model.addAttribute("couponCodeCount", this.IIlIIIII.count(null, localMember, null, Boolean.valueOf(false), Boolean.valueOf(false)));
    model.addAttribute("favoriteCount", this.IIlIIIlI.count(localMember, null, null, null, null, null, null));
    model.addAttribute("productNotifyCount", this.IIlIIIll.count(localMember, null, null, null));
    model.addAttribute("reviewCount", this.IIlIIlII.count(localMember, null, null, null));
    model.addAttribute("consultationCount", this.IIlIIlIl.count(localMember, null, null));
    model.addAttribute("newOrders", this.IIIlllll.findList(localMember, Integer.valueOf(6), null, null));
    return "shop/member/index";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.member.MemberController
 * JD-Core Version:    0.6.2
 */