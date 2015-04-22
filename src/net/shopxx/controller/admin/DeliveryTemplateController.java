package net.shopxx.controller.admin;

import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.DeliveryTemplate;
import net.shopxx.service.DeliveryTemplateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminDeliveryTemplateController")
@RequestMapping({"/admin/delivery_template"})
public class DeliveryTemplateController extends BaseController
{

  @Resource(name="deliveryTemplateServiceImpl")
  private DeliveryTemplateService IIIlllIl;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(Pageable pageable)
  {
    return "/admin/delivery_template/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(DeliveryTemplate deliveryTemplate, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(deliveryTemplate, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.save(deliveryTemplate);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String eidt(Long id, Model model)
  {
    model.addAttribute("deliveryTemplate", this.IIIlllIl.find(id));
    return "/admin/delivery_template/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String udpate(DeliveryTemplate deliveryTemplate, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(deliveryTemplate, new Class[0]))
      return "/admin/common/error";
    this.IIIlllIl.update(deliveryTemplate);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, Model model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/delivery_template/list";
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
 * Qualified Name:     net.shopxx.controller.admin.DeliveryTemplateController
 * JD-Core Version:    0.6.2
 */