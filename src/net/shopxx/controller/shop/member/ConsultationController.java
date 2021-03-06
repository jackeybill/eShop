package net.shopxx.controller.shop.member;

import javax.annotation.Resource;
import net.shopxx.Pageable;
import net.shopxx.controller.shop.BaseController;
import net.shopxx.entity.Member;
import net.shopxx.service.ConsultationService;
import net.shopxx.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopMemberConsultationController")
@RequestMapping({"/member/consultation"})
public class ConsultationController extends BaseController
{
  private static final int IIIlllIl = 10;

  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;

  @Resource(name="consultationServiceImpl")
  private ConsultationService IIIlllll;

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Integer pageNumber, ModelMap model)
  {
    Member localMember = this.IIIllllI.getCurrent();
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("page", this.IIIlllll.findPage(localMember, null, null, localPageable));
    return "shop/member/consultation/list";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.member.ConsultationController
 * JD-Core Version:    0.6.2
 */