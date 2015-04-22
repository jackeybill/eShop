package net.shopxx.controller.admin;

import freemarker.template.Configuration;
import javax.annotation.Resource;
import net.shopxx.Template.Type;
import net.shopxx.service.TemplateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Controller("adminTemplateController")
@RequestMapping({"/admin/template"})
public class TemplateController extends BaseController
{

  @Resource(name="freeMarkerConfigurer")
  private FreeMarkerConfigurer IIIlllIl;

  @Resource(name="templateServiceImpl")
  private TemplateService IIIllllI;

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(String id, ModelMap model)
  {
    if (StringUtils.isEmpty(id))
      return "/admin/common/error";
    model.addAttribute("template", this.IIIllllI.get(id));
    model.addAttribute("content", this.IIIllllI.read(id));
    return "/admin/template/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(String id, String content, RedirectAttributes redirectAttributes)
  {
    if ((StringUtils.isEmpty(id)) || (content == null))
      return "/admin/common/error";
    this.IIIllllI.write(id, content);
    this.IIIlllIl.getConfiguration().clearTemplateCache();
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Template.Type type, ModelMap model)
  {
    model.addAttribute("type", type);
    model.addAttribute("types", Template.Type.values());
    model.addAttribute("templates", this.IIIllllI.getList(type));
    return "/admin/template/list";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.TemplateController
 * JD-Core Version:    0.6.2
 */