package net.shopxx.controller.admin;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.shopxx.entity.Area;
import net.shopxx.service.AreaService;
import net.shopxx.service.CaptchaService;
import net.shopxx.service.MemberService;
import net.shopxx.service.MessageService;
import net.shopxx.service.OrderService;
import net.shopxx.service.ProductService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

@Controller("adminCommonController")
@RequestMapping({"/admin/common"})
public class CommonController
  implements ServletContextAware
{

  @Value("${system.name}")
  private String IIIllIlI;

  @Value("${system.version}")
  private String IIIllIll;

  @Value("${system.description}")
  private String IIIlllII;

  @Value("${system.show_powered}")
  private Boolean IIIlllIl;

  @Resource(name="areaServiceImpl")
  private AreaService IIIllllI;

  @Resource(name="captchaServiceImpl")
  private CaptchaService IIIlllll;

  @Resource(name="orderServiceImpl")
  private OrderService IIlIIIII;

  @Resource(name="productServiceImpl")
  private ProductService IIlIIIIl;

  @Resource(name="memberServiceImpl")
  private MemberService IIlIIIlI;

  @Resource(name="messageServiceImpl")
  private MessageService IIlIIIll;
  private ServletContext IIlIIlII;

  public void setServletContext(ServletContext servletContext)
  {
    this.IIlIIlII = servletContext;
  }

  @RequestMapping(value={"/main"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String main()
  {
    return "/admin/common/main";
  }

  @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String index(ModelMap model)
  {
    model.addAttribute("systemName", this.IIIllIlI);
    model.addAttribute("systemVersion", this.IIIllIll);
    model.addAttribute("systemDescription", this.IIIlllII);
    model.addAttribute("systemShowPowered", this.IIIlllIl);
    model.addAttribute("javaVersion", System.getProperty("java.version"));
    model.addAttribute("javaHome", System.getProperty("java.home"));
    model.addAttribute("osName", System.getProperty("os.name"));
    model.addAttribute("osArch", System.getProperty("os.arch"));
    model.addAttribute("serverInfo", this.IIlIIlII.getServerInfo());
    model.addAttribute("servletVersion", this.IIlIIlII.getMajorVersion() + "." + this.IIlIIlII.getMinorVersion());
    model.addAttribute("waitingPaymentOrderCount", this.IIlIIIII.waitingPaymentCount(null));
    model.addAttribute("waitingShippingOrderCount", this.IIlIIIII.waitingShippingCount(null));
    model.addAttribute("marketableProductCount", this.IIlIIIIl.count(null, Boolean.valueOf(true), null, null, Boolean.valueOf(false), null, null));
    model.addAttribute("notMarketableProductCount", this.IIlIIIIl.count(null, Boolean.valueOf(false), null, null, Boolean.valueOf(false), null, null));
    model.addAttribute("stockAlertProductCount", this.IIlIIIIl.count(null, null, null, null, Boolean.valueOf(false), null, Boolean.valueOf(true)));
    model.addAttribute("outOfStockProductCount", this.IIlIIIIl.count(null, null, null, null, Boolean.valueOf(false), Boolean.valueOf(true), null));
    model.addAttribute("memberCount", Long.valueOf(this.IIlIIIlI.count()));
    model.addAttribute("unreadMessageCount", this.IIlIIIll.count(null, Boolean.valueOf(false)));
    return "/admin/common/index";
  }

  @RequestMapping(value={"/area"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public Map<Long, String> area(Long parentId)
  {
    Object localObject = new ArrayList();
    Area localArea1 = (Area)this.IIIllllI.find(parentId);
    if (localArea1 != null)
      localObject = new ArrayList(localArea1.getChildren());
    else
      localObject = this.IIIllllI.findRoots();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      Area localArea2 = (Area)localIterator.next();
      localHashMap.put(localArea2.getId(), localArea2.getName());
    }
    return localHashMap;
  }

  @RequestMapping(value={"/captcha"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public void image(String captchaId, HttpServletRequest request, HttpServletResponse response)
  {
    if (StringUtils.isEmpty(captchaId))
      captchaId = request.getSession().getId();
    String str1 = new StringBuffer().append("yB").append("-").append("der").append("ewoP").reverse().toString();
    String str2 = new StringBuffer().append("ten").append(".").append("xxp").append("ohs").reverse().toString();
    response.addHeader(str1, str2);
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0L);
    response.setContentType("image/jpeg");
    ServletOutputStream localServletOutputStream = null;
    try
    {
      localServletOutputStream = response.getOutputStream();
      BufferedImage localBufferedImage = this.IIIlllll.buildImage(captchaId);
      ImageIO.write(localBufferedImage, "jpg", localServletOutputStream);
      localServletOutputStream.flush();
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    finally
    {
      IOUtils.closeQuietly(localServletOutputStream);
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.CommonController
 * JD-Core Version:    0.6.2
 */