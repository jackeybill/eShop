package net.shopxx.plugin.alipayDirect;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.shopxx.plugin.PaymentPlugin;
import net.shopxx.plugin.PaymentPlugin.Method;
import org.springframework.stereotype.Component;

@Component("alipayDirectPlugin")
public class AlipayDirectPlugin extends PaymentPlugin
{
  public String getName()
  {
    return "支付宝即时交易";
  }

  public String getVersion()
  {
    return "1.0";
  }

  public String getAuthor()
  {
    return "SHOP++";
  }

  public String getSiteUrl()
  {
    return "http://www.shopxx.net";
  }

  public String getInstallUrl()
  {
    return "alipay_direct/install.jhtml";
  }

  public String getUninstallUrl()
  {
    return "alipay_direct/uninstall.jhtml";
  }

  public String getSettingUrl()
  {
    return "alipay_direct/setting.jhtml";
  }

  public String getUrl()
  {
    return "https://mapi.alipay.com/gateway.do";
  }

  public PaymentPlugin.Method getMethod()
  {
    return PaymentPlugin.Method.get;
  }

  public Integer getTimeout()
  {
    return Integer.valueOf(21600);
  }

  public Map<String, String> getParameterMap(String sn, BigDecimal amount, String description, HttpServletRequest request)
  {
    return new HashMap();
  }

  public boolean verify(String sn, HttpServletRequest request)
  {
    return false;
  }

  public BigDecimal getAmount(String sn, HttpServletRequest request)
  {
    return new BigDecimal(request.getParameter("total_fee"));
  }

  public String getNotifyContext(String sn, HttpServletRequest request)
  {
    return "success";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.plugin.alipayDirect.AlipayDirectPlugin
 * JD-Core Version:    0.6.2
 */