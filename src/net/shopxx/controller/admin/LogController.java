package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("adminLogController")
@RequestMapping({"/admin/log"})
public class LogController extends BaseController
{

  @Resource(name="logServiceImpl")
  private LogService IIIlllIl;

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/log/list";
  }

  @RequestMapping(value={"/view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String view(Long id, ModelMap model)
  {
    model.addAttribute("log", this.IIIlllIl.find(id));
    return "/admin/log/view";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    this.IIIlllIl.delete(ids);
    return IIIlllII;
  }

  @RequestMapping(value={"/clear"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message clear()
  {
    this.IIIlllIl.clear();
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.LogController
 * JD-Core Version:    0.6.2
 */