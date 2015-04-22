package net.shopxx.controller.admin;

import java.math.BigDecimal;
import java.util.Set;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.MemberRank;
import net.shopxx.service.MemberRankService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminMemberRankController")
@RequestMapping({"/admin/member_rank"})
public class MemberRankController extends BaseController
{

  @Resource(name="memberRankServiceImpl")
  private MemberRankService IIIlllIl;

  @RequestMapping(value={"/check_name"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public boolean checkName(String previousName, String name)
  {
    if (StringUtils.isEmpty(name))
      return false;
    return this.IIIlllIl.nameUnique(previousName, name);
  }

  @RequestMapping(value={"/check_amount"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public boolean checkAmount(BigDecimal previousAmount, BigDecimal amount)
  {
    if (amount == null)
      return false;
    return this.IIIlllIl.amountUnique(previousAmount, amount);
  }

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    return "/admin/member_rank/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(MemberRank memberRank, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(memberRank, new Class[0]))
      return "/admin/common/error";
    if (this.IIIlllIl.nameExists(memberRank.getName()))
      return "/admin/common/error";
    if (memberRank.getIsSpecial().booleanValue())
      memberRank.setAmount(null);
    else if ((memberRank.getAmount() == null) || (this.IIIlllIl.amountExists(memberRank.getAmount())))
      return "/admin/common/error";
    memberRank.setMembers(null);
    memberRank.setPromotions(null);
    this.IIIlllIl.save(memberRank);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("memberRank", this.IIIlllIl.find(id));
    return "/admin/member_rank/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(MemberRank memberRank, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(memberRank, new Class[0]))
      return "/admin/common/error";
    MemberRank localMemberRank = (MemberRank)this.IIIlllIl.find(memberRank.getId());
    if (localMemberRank == null)
      return "/admin/common/error";
    if (!this.IIIlllIl.nameUnique(localMemberRank.getName(), memberRank.getName()))
      return "/admin/common/error";
    if (localMemberRank.getIsDefault().booleanValue())
      memberRank.setIsDefault(Boolean.valueOf(true));
    if (memberRank.getIsSpecial().booleanValue())
      memberRank.setAmount(null);
    else if ((memberRank.getAmount() == null) || (!this.IIIlllIl.amountUnique(localMemberRank.getAmount(), memberRank.getAmount())))
      return "/admin/common/error";
    this.IIIlllIl.update(memberRank, new String[] { "members", "promotions" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/member_rank/list";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    if (ids != null)
    {
      for (Long localLong : ids)
      {
        MemberRank localMemberRank = (MemberRank)this.IIIlllIl.find(localLong);
        if ((localMemberRank != null) && (localMemberRank.getMembers() != null) && (!localMemberRank.getMembers().isEmpty()))
          return Message.error("admin.memberRank.deleteExistNotAllowed", new Object[] { localMemberRank.getName() });
      }
      long l = this.IIIlllIl.count();
      if (ids.length >= l)
        return Message.error("admin.common.deleteAllNotAllowed", new Object[0]);
      this.IIIlllIl.delete(ids);
    }
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.MemberRankController
 * JD-Core Version:    0.6.2
 */