package net.shopxx.controller.admin;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import net.shopxx.ExcelView;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.entity.Coupon;
import net.shopxx.entity.Coupon.Operator;
import net.shopxx.service.AdminService;
import net.shopxx.service.CouponCodeService;
import net.shopxx.service.CouponService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminCouponController")
@RequestMapping({"/admin/coupon"})
public class CouponController extends BaseController
{

  @Resource(name="couponServiceImpl")
  private CouponService IIIlllIl;

  @Resource(name="couponCodeServiceImpl")
  private CouponCodeService IIIllllI;

  @Resource(name="adminServiceImpl")
  private AdminService IIIlllll;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("operators", Coupon.Operator.values());
    return "/admin/coupon/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(Coupon coupon, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(coupon, new Class[0]))
      return "/admin/common/error";
    if ((coupon.getBeginDate() != null) && (coupon.getEndDate() != null) && (coupon.getBeginDate().after(coupon.getEndDate())))
      return "/admin/common/error";
    if ((coupon.getStartPrice() != null) && (coupon.getEndPrice() != null) && (coupon.getStartPrice().compareTo(coupon.getEndPrice()) > 0))
      return "/admin/common/error";
    if ((coupon.getIsExchange().booleanValue()) && (coupon.getPoint() == null))
      return "/admin/common/error";
    if ((coupon.getPriceOperator() == Coupon.Operator.divide) && (coupon.getPriceValue() != null) && (coupon.getPriceValue().compareTo(new BigDecimal(0)) == 0))
      return "/admin/common/error";
    if (!coupon.getIsExchange().booleanValue())
      coupon.setPoint(null);
    coupon.setCouponCodes(null);
    coupon.setPromotions(null);
    coupon.setOrders(null);
    this.IIIlllIl.save(coupon);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("coupon", this.IIIlllIl.find(id));
    model.addAttribute("operators", Coupon.Operator.values());
    return "/admin/coupon/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Coupon coupon, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(coupon, new Class[0]))
      return "/admin/common/error";
    if ((coupon.getBeginDate() != null) && (coupon.getEndDate() != null) && (coupon.getBeginDate().after(coupon.getEndDate())))
      return "/admin/common/error";
    if ((coupon.getStartPrice() != null) && (coupon.getEndPrice() != null) && (coupon.getStartPrice().compareTo(coupon.getEndPrice()) > 0))
      return "/admin/common/error";
    if ((coupon.getIsExchange().booleanValue()) && (coupon.getPoint() == null))
      return "/admin/common/error";
    if ((coupon.getPriceOperator() == Coupon.Operator.divide) && (coupon.getPriceValue() != null) && (coupon.getPriceValue().compareTo(new BigDecimal(0)) == 0))
      return "/admin/common/error";
    if (!coupon.getIsExchange().booleanValue())
      coupon.setPoint(null);
    this.IIIlllIl.update(coupon, new String[] { "couponCodes", "promotions", "orders" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/coupon/list";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    this.IIIlllIl.delete(ids);
    return IIIlllII;
  }

  @RequestMapping(value={"/build"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String build(Long id, ModelMap model)
  {
    Coupon localCoupon = (Coupon)this.IIIlllIl.find(id);
    model.addAttribute("coupon", localCoupon);
    model.addAttribute("totalCount", this.IIIllllI.count(localCoupon, null, null, null, null));
    model.addAttribute("usedCount", this.IIIllllI.count(localCoupon, null, null, null, Boolean.valueOf(true)));
    return "/admin/coupon/build";
  }

  @RequestMapping(value={"/download"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView download(Long id, Integer count, ModelMap model)
  {
    if ((count == null) || (count.intValue() <= 0))
      count = Integer.valueOf(50);
    Coupon localCoupon = (Coupon)this.IIIlllIl.find(id);
    List localList = this.IIIllllI.build(localCoupon, null, count);
    String str = "coupon_code_" + new SimpleDateFormat("yyyyMM").format(new Date()) + ".xls";
    String[] arrayOfString = new String[4];
    arrayOfString[0] = (IIIllIlI("admin.coupon.type", new Object[0]) + ": " + localCoupon.getName());
    arrayOfString[1] = (IIIllIlI("admin.coupon.count", new Object[0]) + ": " + count);
    arrayOfString[2] = (IIIllIlI("admin.coupon.operator", new Object[0]) + ": " + this.IIIlllll.getCurrentUsername());
    arrayOfString[3] = (IIIllIlI("admin.coupon.date", new Object[0]) + ": " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    return new ModelAndView(new ExcelView(str, null, new String[] { "code" }, new String[] { IIIllIlI("admin.coupon.title", new Object[0]) }, null, null, localList, arrayOfString), model);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.CouponController
 * JD-Core Version:    0.6.2
 */