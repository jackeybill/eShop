package net.shopxx.controller.shop;

import javax.annotation.Resource;
import net.shopxx.ResourceNotFoundException;
import net.shopxx.entity.Promotion;
import net.shopxx.service.PromotionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopPromotionController")
@RequestMapping({"/promotion"})
public class PromotionController extends BaseController
{

  @Resource(name="promotionServiceImpl")
  private PromotionService IIIlllIl;

  @RequestMapping(value={"/content/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String content(@PathVariable Long id, ModelMap model)
  {
    Promotion localPromotion = (Promotion)this.IIIlllIl.find(id);
    if (localPromotion == null)
      throw new ResourceNotFoundException();
    model.addAttribute("promotion", localPromotion);
    return "/shop/promotion/content";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.PromotionController
 * JD-Core Version:    0.6.2
 */