package net.shopxx.service;

import java.awt.image.BufferedImage;
import net.shopxx.Setting.CaptchaType;

public abstract interface CaptchaService
{
  public abstract BufferedImage buildImage(String paramString);

  public abstract boolean isValid(Setting.CaptchaType paramCaptchaType, String paramString1, String paramString2);
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.CaptchaService
 * JD-Core Version:    0.6.2
 */