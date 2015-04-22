package net.shopxx;

import org.apache.shiro.authc.UsernamePasswordToken;

public class AuthenticationToken extends UsernamePasswordToken
{
  private static final long serialVersionUID = 5898441540965086534L;
  private String IIIllIlI;
  private String IIIllIll;

  public AuthenticationToken(String username, String password, String captchaId, String captcha, boolean rememberMe, String host)
  {
    super(username, password, rememberMe);
    this.IIIllIlI = captchaId;
    this.IIIllIll = captcha;
  }

  public String getCaptchaId()
  {
    return this.IIIllIlI;
  }

  public void setCaptchaId(String captchaId)
  {
    this.IIIllIlI = captchaId;
  }

  public String getCaptcha()
  {
    return this.IIIllIll;
  }

  public void setCaptcha(String captcha)
  {
    this.IIIllIll = captcha;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.AuthenticationToken
 * JD-Core Version:    0.6.2
 */