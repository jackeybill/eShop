package net.shopxx.controller.shop;

import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.ResourceNotFoundException;
import net.shopxx.Setting;
import net.shopxx.Setting.CaptchaType;
import net.shopxx.Setting.ReviewAuthority;
import net.shopxx.entity.Member;
import net.shopxx.entity.Product;
import net.shopxx.entity.Review;
import net.shopxx.service.CaptchaService;
import net.shopxx.service.MemberService;
import net.shopxx.service.ProductService;
import net.shopxx.service.ReviewService;
import net.shopxx.util.SettingUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopReviewController")
@RequestMapping({"/review"})
public class ReviewController extends BaseController
{
  private static final int IIIlllIl = 10;

  @Resource(name="reviewServiceImpl")
  private ReviewService IIIllllI;

  @Resource(name="productServiceImpl")
  private ProductService IIIlllll;

  @Resource(name="memberServiceImpl")
  private MemberService IIlIIIII;

  @Resource(name="captchaServiceImpl")
  private CaptchaService IIlIIIIl;

  @RequestMapping(value={"/add/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(@PathVariable Long id, ModelMap model)
  {
    Setting localSetting = SettingUtils.get();
    if (!localSetting.getIsReviewEnabled().booleanValue())
      throw new ResourceNotFoundException();
    Product localProduct = (Product)this.IIIlllll.find(id);
    if (localProduct == null)
      throw new ResourceNotFoundException();
    model.addAttribute("product", localProduct);
    model.addAttribute("captchaId", UUID.randomUUID().toString());
    return "/shop/review/add";
  }

  @RequestMapping(value={"/content/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String content(@PathVariable Long id, Integer pageNumber, ModelMap model)
  {
    Setting localSetting = SettingUtils.get();
    if (!localSetting.getIsReviewEnabled().booleanValue())
      throw new ResourceNotFoundException();
    Product localProduct = (Product)this.IIIlllll.find(id);
    if (localProduct == null)
      throw new ResourceNotFoundException();
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("product", localProduct);
    model.addAttribute("page", this.IIIllllI.findPage(null, localProduct, null, Boolean.valueOf(true), localPageable));
    return "/shop/review/content";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message save(String captchaId, String captcha, Long id, Integer score, String content, HttpServletRequest request)
  {
    if (!this.IIlIIIIl.isValid(Setting.CaptchaType.review, captchaId, captcha))
      return Message.error("shop.captcha.invalid", new Object[0]);
    Setting localSetting = SettingUtils.get();
    if (!localSetting.getIsReviewEnabled().booleanValue())
      return Message.error("shop.review.disabled", new Object[0]);
    if ((!IIIllIlI(Review.class, "score", score, new Class[0])) || (!IIIllIlI(Review.class, "content", content, new Class[0])))
      return IIIllIll;
    Product localProduct = (Product)this.IIIlllll.find(id);
    if (localProduct == null)
      return IIIllIll;
    Member localMember = this.IIlIIIII.getCurrent();
    if ((localSetting.getReviewAuthority() != Setting.ReviewAuthority.anyone) && (localMember == null))
      return Message.error("shop.review.accessDenied", new Object[0]);
    if (localSetting.getReviewAuthority() == Setting.ReviewAuthority.purchased)
    {
      if (!this.IIIlllll.isPurchased(localMember, localProduct))
        return Message.error("shop.review.noPurchased", new Object[0]);
      if (this.IIIllllI.isReviewed(localMember, localProduct))
        return Message.error("shop.review.reviewed", new Object[0]);
    }
    Review localReview = new Review();
    localReview.setScore(score);
    localReview.setContent(content);
    localReview.setIp(request.getRemoteAddr());
    localReview.setMember(localMember);
    localReview.setProduct(localProduct);
    if (localSetting.getIsReviewCheck().booleanValue())
    {
      localReview.setIsShow(Boolean.valueOf(false));
      this.IIIllllI.save(localReview);
      return Message.success("shop.review.check", new Object[0]);
    }
    localReview.setIsShow(Boolean.valueOf(true));
    this.IIIllllI.save(localReview);
    return Message.success("shop.review.success", new Object[0]);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.ReviewController
 * JD-Core Version:    0.6.2
 */