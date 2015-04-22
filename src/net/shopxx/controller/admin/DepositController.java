package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.Pageable;
import net.shopxx.entity.Member;
import net.shopxx.service.DepositService;
import net.shopxx.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminDepositController")
@RequestMapping({"/admin/deposit"})
public class DepositController extends BaseController
{

  @Resource(name="depositServiceImpl")
  private DepositService IIIlllIl;

  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Long memberId, Pageable pageable, ModelMap model)
  {
    Member localMember = (Member)this.IIIllllI.find(memberId);
    if (localMember != null)
    {
      model.addAttribute("member", localMember);
      model.addAttribute("page", this.IIIlllIl.findPage(localMember, pageable));
    }
    else
    {
      model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    }
    return "/admin/deposit/list";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.DepositController
 * JD-Core Version:    0.6.2
 */