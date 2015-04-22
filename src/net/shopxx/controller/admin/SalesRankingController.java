package net.shopxx.controller.admin;

import java.util.Date;
import javax.annotation.Resource;
import net.shopxx.Pageable;
import net.shopxx.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminSalesRankingController")
@RequestMapping({"/admin/sales_ranking"})
public class SalesRankingController extends BaseController
{

  @Resource(name="productServiceImpl")
  private ProductService IIIlllIl;

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Date beginDate, Date endDate, Pageable pageable, Model model)
  {
    model.addAttribute("beginDate", beginDate);
    model.addAttribute("endDate", endDate);
    model.addAttribute("page", this.IIIlllIl.findSalesPage(beginDate, endDate, pageable));
    return "/admin/sales_ranking/list";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.SalesRankingController
 * JD-Core Version:    0.6.2
 */