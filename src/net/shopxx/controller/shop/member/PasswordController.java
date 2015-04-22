package net.shopxx.controller.shop.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.shopxx.Setting;
import net.shopxx.controller.shop.BaseController;
import net.shopxx.entity.Member;
import net.shopxx.service.MemberService;
import net.shopxx.util.SettingUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("shopMemberPasswordController")
@RequestMapping({"/member/password"})
public class PasswordController extends BaseController
{

  @Resource(name="memberServiceImpl")
  private MemberService IIIlllIl;

  @RequestMapping(value={"/check_current_password"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public boolean checkCurrentPassword(String currentPassword)
  {
    if (StringUtils.isEmpty(currentPassword))
      return false;
    Member localMember = this.IIIlllIl.getCurrent();
    return StringUtils.equals(DigestUtils.md5Hex(currentPassword), localMember.getPassword());
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit()
  {
    return "shop/member/password/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(String currentPassword, String password, HttpServletRequest request, RedirectAttributes redirectAttributes)
  {
    if ((StringUtils.isEmpty(password)) || (StringUtils.isEmpty(currentPassword)))
      return "/shop/common/error";
    if (!IIIllIlI(Member.class, "password", password, new Class[0]))
      return "/shop/common/error";
    Setting localSetting = SettingUtils.get();
    if ((password.length() < localSetting.getPasswordMinLength().intValue()) || (password.length() > localSetting.getPasswordMaxLength().intValue()))
      return "/shop/common/error";
    Member localMember = this.IIIlllIl.getCurrent();
    if (!StringUtils.equals(DigestUtils.md5Hex(currentPassword), localMember.getPassword()))
      return "/shop/common/error";
    localMember.setPassword(DigestUtils.md5Hex(password));
    this.IIIlllIl.update(localMember);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:edit.jhtml";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.member.PasswordController
 * JD-Core Version:    0.6.2
 */