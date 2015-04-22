package net.shopxx.controller.admin;

import java.util.Date;
import javax.annotation.Resource;
import net.shopxx.Pageable;
import net.shopxx.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminPurchaseRankingController")
@RequestMapping({"/admin/purchase_ranking"})
public class PurchaseRankingController extends BaseController
{

  @Resource(name="memberServiceImpl")
  private MemberService IIIlllIl;

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Date beginDate, Date endDate, Pageable pageable, Model model)
  {
    model.addAttribute("beginDate", beginDate);
    model.addAttribute("endDate", endDate);
    model.addAttribute("page", this.IIIlllIl.findPurchasePage(beginDate, endDate, pageable));
    return "/admin/purchase_ranking/list";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.PurchaseRankingController
 * JD-Core Version:    0.6.2
 */