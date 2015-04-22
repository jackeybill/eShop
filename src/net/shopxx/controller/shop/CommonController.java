package net.shopxx.controller.shop;

import java.awt.image.BufferedImage;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.shopxx.Setting;
import net.shopxx.entity.Area;
import net.shopxx.service.AreaService;
import net.shopxx.service.CaptchaService;
import net.shopxx.service.RSAService;
import net.shopxx.util.SettingUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopCommonController")
@RequestMapping({"/common"})
public class CommonController
{

  @Resource(name="rsaServiceImpl")
  private RSAService IIIllIlI;

  @Resource(name="areaServiceImpl")
  private AreaService IIIllIll;

  @Resource(name="captchaServiceImpl")
  private CaptchaService IIIlllII;

  @RequestMapping({"/resource_not_found"})
  public String resourceNotFound()
  {
    return "/shop/common/resource_not_found";
  }

  @RequestMapping({"/error"})
  public String error()
  {
    return "/shop/common/error";
  }

  @RequestMapping({"/site_close"})
  public String siteClose()
  {
    Setting localSetting = SettingUtils.get();
    if (localSetting.getIsSiteEnabled().booleanValue())
      return "redirect:/";
    return "/shop/common/site_close";
  }

  @RequestMapping(value={"/public_key"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public Map<String, String> publicKey(HttpServletRequest request)
  {
    RSAPublicKey localRSAPublicKey = this.IIIllIlI.generateKey(request);
    HashMap localHashMap = new HashMap();
    localHashMap.put("modulus", Base64.encodeBase64String(localRSAPublicKey.getModulus().toByteArray()));
    localHashMap.put("exponent", Base64.encodeBase64String(localRSAPublicKey.getPublicExponent().toByteArray()));
    return localHashMap;
  }

  @RequestMapping(value={"/area"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public Map<Long, String> area(Long parentId)
  {
    Object localObject = new ArrayList();
    Area localArea1 = (Area)this.IIIllIll.find(parentId);
    if (localArea1 != null)
      localObject = new ArrayList(localArea1.getChildren());
    else
      localObject = this.IIIllIll.findRoots();
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
      BufferedImage localBufferedImage = this.IIIlllII.buildImage(captchaId);
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
 * Qualified Name:     net.shopxx.controller.shop.CommonController
 * JD-Core Version:    0.6.2
 */