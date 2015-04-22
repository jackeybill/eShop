package net.shopxx.controller.admin;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.BaseEntity.Save;
import net.shopxx.entity.MemberAttribute;
import net.shopxx.entity.MemberAttribute.Type;
import net.shopxx.service.MemberAttributeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminMemberAttributeController")
@RequestMapping({"/admin/member_attribute"})
public class MemberAttributeController extends BaseController
{

  @Resource(name="memberAttributeServiceImpl")
  private MemberAttributeService IIIlllIl;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model, RedirectAttributes redirectAttributes)
  {
    if (this.IIIlllIl.count() - 8L >= 10L)
      IIIllIlI(redirectAttributes, Message.warn("admin.memberAttribute.addCountNotAllowed", new Object[] { Integer.valueOf(10) }));
    return "/admin/member_attribute/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(MemberAttribute memberAttribute, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(memberAttribute, new Class[] { BaseEntity.Save.class }))
      return "/admin/common/error";
    if ((memberAttribute.getType() == MemberAttribute.Type.select) || (memberAttribute.getType() == MemberAttribute.Type.checkbox))
    {
      localObject = memberAttribute.getOptions();
      if (localObject != null)
      {
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (StringUtils.isEmpty(str))
            localIterator.remove();
        }
      }
      if ((localObject == null) || (((List)localObject).isEmpty()))
        return "/admin/common/error";
    }
    else if (memberAttribute.getType() == MemberAttribute.Type.text)
    {
      memberAttribute.setOptions(null);
    }
    else
    {
      return "/admin/common/error";
    }
    Object localObject = this.IIIlllIl.findUnusedPropertyIndex();
    if (localObject == null)
      return "/admin/common/error";
    memberAttribute.setPropertyIndex((Integer)localObject);
    this.IIIlllIl.save(memberAttribute);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("memberAttribute", this.IIIlllIl.find(id));
    return "/admin/member_attribute/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(MemberAttribute memberAttribute, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(memberAttribute, new Class[0]))
      return "/admin/common/error";
    MemberAttribute localMemberAttribute = (MemberAttribute)this.IIIlllIl.find(memberAttribute.getId());
    if (localMemberAttribute == null)
      return "/admin/common/error";
    if ((localMemberAttribute.getType() == MemberAttribute.Type.select) || (localMemberAttribute.getType() == MemberAttribute.Type.checkbox))
    {
      List localList = memberAttribute.getOptions();
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (StringUtils.isEmpty(str))
            localIterator.remove();
        }
      }
      if ((localList == null) || (localList.isEmpty()))
        return "/admin/common/error";
    }
    else
    {
      memberAttribute.setOptions(null);
    }
    this.IIIlllIl.update(memberAttribute, new String[] { "type", "propertyIndex" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/member_attribute/list";
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
 * Qualified Name:     net.shopxx.controller.admin.MemberAttributeController
 * JD-Core Version:    0.6.2
 */