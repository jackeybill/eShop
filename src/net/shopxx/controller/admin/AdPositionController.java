package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.AdPosition;
import net.shopxx.service.AdPositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminAdPositionController")
@RequestMapping({"/admin/ad_position"})
public class AdPositionController extends BaseController
{

  @Resource(name="adPositionServiceImpl")
  private AdPositionService IIIlllIl;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    return "/admin/ad_position/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(AdPosition adPosition, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(adPosition, new Class[0]))
      return "/admin/common/error";
    adPosition.setAds(null);
    this.IIIlllIl.save(adPosition);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("adPosition", this.IIIlllIl.find(id));
    return "/admin/ad_position/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(AdPosition adPosition, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(adPosition, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.update(adPosition, new String[] { "ads" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/ad_position/list";
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
 * Qualified Name:     net.shopxx.controller.admin.AdPositionController
 * JD-Core Version:    0.6.2
 */