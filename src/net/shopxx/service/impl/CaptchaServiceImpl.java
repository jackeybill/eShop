package net.shopxx.service.impl;

import java.awt.image.BufferedImage;
import javax.annotation.Resource;
import net.shopxx.Setting;
import net.shopxx.Setting.CaptchaType;
import net.shopxx.util.SettingUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service("captchaServiceImpl")
public class CaptchaServiceImpl
  implements net.shopxx.service.CaptchaService
{

  @Resource(name="imageCaptchaService")
  private com.octo.captcha.service.CaptchaService IIIllIlI;

  public BufferedImage buildImage(String captchaId)
  {
    return (BufferedImage)this.IIIllIlI.getChallengeForID(captchaId);
  }

  public boolean isValid(Setting.CaptchaType captchaType, String captchaId, String captcha)
  {
    Setting localSetting = SettingUtils.get();
    if ((captchaType == null) || (ArrayUtils.contains(localSetting.getCaptchaTypes(), captchaType)))
    {
      if ((StringUtils.isNotEmpty(captchaId)) && (StringUtils.isNotEmpty(captcha)))
        try
        {
          return this.IIIllIlI.validateResponseForID(captchaId, captcha.toUpperCase()).booleanValue();
        }
        catch (Exception localException)
        {
          return false;
        }
      return false;
    }
    return true;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.CaptchaServiceImpl
 * JD-Core Version:    0.6.2
 */