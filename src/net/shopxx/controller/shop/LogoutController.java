package net.shopxx.controller.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.shopxx.entity.Member;
import net.shopxx.util.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopLogoutController")
public class LogoutController extends BaseController
{
  @RequestMapping(value={"/logout"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
  {
    session.removeAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME);
    CookieUtils.removeCookie(request, response, "username");
    return "redirect:/";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.LogoutController
 * JD-Core Version:    0.6.2
 */