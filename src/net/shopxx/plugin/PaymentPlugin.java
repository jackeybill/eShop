package net.shopxx.plugin;

import java.math.BigDecimal;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.shopxx.Setting;
import net.shopxx.entity.PluginConfig;
import net.shopxx.service.PluginConfigService;
import net.shopxx.util.SettingUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

public abstract class PaymentPlugin
  implements Comparable<PaymentPlugin>
{
  public static final String PAYMENT_NAME_ATTRIBUTE_NAME = "paymentName";
  public static final String FEE_TYPE_ATTRIBUTE_NAME = "feeType";
  public static final String FEE_ATTRIBUTE_NAME = "fee";
  public static final String LOGO_ATTRIBUTE_NAME = "logo";
  public static final String DESCRIPTION_ATTRIBUTE_NAME = "description";

  @Resource(name="pluginConfigServiceImpl")
  private PluginConfigService IIIllIlI;

  public final String getId()
  {
    return ((Component)getClass().getAnnotation(Component.class)).value();
  }

  public abstract String getName();

  public abstract String getVersion();

  public abstract String getAuthor();

  public abstract String getSiteUrl();

  public abstract String getInstallUrl();

  public abstract String getUninstallUrl();

  public abstract String getSettingUrl();

  public boolean getIsInstalled()
  {
    return this.IIIllIlI.pluginIdExists(getId());
  }

  public PluginConfig getPluginConfig()
  {
    return this.IIIllIlI.findByPluginId(getId());
  }

  public boolean getIsEnabled()
  {
    PluginConfig localPluginConfig = getPluginConfig();
    return localPluginConfig != null ? localPluginConfig.getIsEnabled().booleanValue() : false;
  }

  public String getAttribute(String name)
  {
    PluginConfig localPluginConfig = getPluginConfig();
    return localPluginConfig != null ? localPluginConfig.getAttribute(name) : null;
  }

  public Integer getOrder()
  {
    PluginConfig localPluginConfig = getPluginConfig();
    return localPluginConfig != null ? localPluginConfig.getOrder() : null;
  }

  public String getPaymentName()
  {
    PluginConfig localPluginConfig = getPluginConfig();
    return localPluginConfig != null ? localPluginConfig.getAttribute("paymentName") : null;
  }

  public PaymentPlugin.FeeType getFeeType()
  {
    PluginConfig localPluginConfig = getPluginConfig();
    return localPluginConfig != null ? PaymentPlugin.FeeType.valueOf(localPluginConfig.getAttribute("feeType")) : null;
  }

  public BigDecimal getFee()
  {
    PluginConfig localPluginConfig = getPluginConfig();
    return localPluginConfig != null ? new BigDecimal(localPluginConfig.getAttribute("fee")) : null;
  }

  public String getLogo()
  {
    PluginConfig localPluginConfig = getPluginConfig();
    return localPluginConfig != null ? localPluginConfig.getAttribute("logo") : null;
  }

  public String getDescription()
  {
    PluginConfig localPluginConfig = getPluginConfig();
    return localPluginConfig != null ? localPluginConfig.getAttribute("description") : null;
  }

  public abstract String getUrl();

  public abstract PaymentPlugin.Method getMethod();

  public abstract Integer getTimeout();

  public abstract Map<String, String> getParameterMap(String paramString1, BigDecimal paramBigDecimal, String paramString2, HttpServletRequest paramHttpServletRequest);

  public abstract boolean verify(String paramString, HttpServletRequest paramHttpServletRequest);

  public abstract BigDecimal getAmount(String paramString, HttpServletRequest paramHttpServletRequest);

  public abstract String getNotifyContext(String paramString, HttpServletRequest paramHttpServletRequest);

  protected String IIIllIlI(String paramString)
  {
    Setting localSetting = SettingUtils.get();
    return localSetting.getSiteUrl() + "/payment/return/" + paramString + ".jhtml";
  }

  protected String IIIllIll(String paramString)
  {
    Setting localSetting = SettingUtils.get();
    return localSetting.getSiteUrl() + "/payment/notify/" + paramString + ".jhtml";
  }

  public final BigDecimal getFee(BigDecimal amount)
  {
    Setting localSetting = SettingUtils.get();
    BigDecimal localBigDecimal;
    if (getFeeType() == PaymentPlugin.FeeType.scale)
      localBigDecimal = amount.multiply(getFee());
    else
      localBigDecimal = getFee();
    return localSetting.setScale(localBigDecimal);
  }

  public boolean equals(Object obj)
  {
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (this == obj)
      return true;
    PaymentPlugin localPaymentPlugin = (PaymentPlugin)obj;
    return new EqualsBuilder().append(getId(), localPaymentPlugin.getId()).isEquals();
  }

  public int hashCode()
  {
    return new HashCodeBuilder(17, 37).append(getId()).toHashCode();
  }

  public int compareTo(PaymentPlugin paymentPlugin)
  {
    return new CompareToBuilder().append(getOrder(), paymentPlugin.getOrder()).append(getId(), paymentPlugin.getId()).toComparison();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.plugin.PaymentPlugin
 * JD-Core Version:    0.6.2
 */