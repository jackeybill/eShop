package net.shopxx.plugin.file;

import javax.annotation.Resource;
import net.shopxx.controller.admin.BaseController;
import net.shopxx.entity.PluginConfig;
import net.shopxx.service.PluginConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminPluginFileController")
@RequestMapping({"/admin/storage_plugin/file"})
public class FileController extends BaseController
{

  @Resource(name="filePlugin")
  private FilePlugin IIIlllIl;

  @Resource(name="pluginConfigServiceImpl")
  private PluginConfigService IIIllllI;

  @RequestMapping(value={"/setting"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String setting(ModelMap model)
  {
    PluginConfig localPluginConfig = this.IIIlllIl.getPluginConfig();
    model.addAttribute("pluginConfig", localPluginConfig);
    return "/net/shopxx/plugin/file/setting";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Integer order, RedirectAttributes redirectAttributes)
  {
    PluginConfig localPluginConfig = this.IIIlllIl.getPluginConfig();
    localPluginConfig.setIsEnabled(Boolean.valueOf(true));
    localPluginConfig.setOrder(order);
    this.IIIllllI.update(localPluginConfig);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:/admin/storage_plugin/list.jhtml";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.plugin.file.FileController
 * JD-Core Version:    0.6.2
 */