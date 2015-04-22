package net.shopxx.controller.admin;

import java.util.Date;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.Ad;
import net.shopxx.entity.Ad.Type;
import net.shopxx.entity.AdPosition;
import net.shopxx.service.AdPositionService;
import net.shopxx.service.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminAdController")
@RequestMapping({"/admin/ad"})
public class AdController extends BaseController
{

  @Resource(name="adServiceImpl")
  private AdService IIIlllIl;

  @Resource(name="adPositionServiceImpl")
  private AdPositionService IIIllllI;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("types", Ad.Type.values());
    model.addAttribute("adPositions", this.IIIllllI.findAll());
    return "/admin/ad/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(Ad ad, Long adPositionId, RedirectAttributes redirectAttributes)
  {
    ad.setAdPosition((AdPosition)this.IIIllllI.find(adPositionId));
    if (!IIIllIlI(ad, new Class[0]))
      return "/admin/common/error";
    if ((ad.getBeginDate() != null) && (ad.getEndDate() != null) && (ad.getBeginDate().after(ad.getEndDate())))
      return "/admin/common/error";
    if (ad.getType() == Ad.Type.text)
      ad.setPath(null);
    else
      ad.setContent(null);
    this.IIIlllIl.save(ad);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("types", Ad.Type.values());
    model.addAttribute("ad", this.IIIlllIl.find(id));
    model.addAttribute("adPositions", this.IIIllllI.findAll());
    return "/admin/ad/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Ad ad, Long adPositionId, RedirectAttributes redirectAttributes)
  {
    ad.setAdPosition((AdPosition)this.IIIllllI.find(adPositionId));
    if (!IIIllIlI(ad, new Class[0]))
      return "/admin/common/error";
    if ((ad.getBeginDate() != null) && (ad.getEndDate() != null) && (ad.getBeginDate().after(ad.getEndDate())))
      return "/admin/common/error";
    if (ad.getType() == Ad.Type.text)
      ad.setPath(null);
    else
      ad.setContent(null);
    this.IIIlllIl.update(ad);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/ad/list";
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
 * Qualified Name:     net.shopxx.controller.admin.AdController
 * JD-Core Version:    0.6.2
 */