package net.shopxx.controller.shop;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.annotation.Resource;
import javax.validation.Validator;
import net.shopxx.DateEditor;
import net.shopxx.HtmlCleanEditor;
import net.shopxx.Message;
import net.shopxx.Setting;
import net.shopxx.template.directive.FlashMessageDirective;
import net.shopxx.util.SettingUtils;
import net.shopxx.util.SpringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class BaseController
{
  protected static final String IIIllIlI = "/shop/common/error";
  protected static final Message IIIllIll = Message.error("shop.message.error", new Object[0]);
  protected static final Message IIIlllII = Message.success("shop.message.success", new Object[0]);
  private static final String IIIlllIl = "constraintViolations";

  @Resource(name="validator")
  private Validator IIIllllI;

  @InitBinder
  protected void IIIllIlI(WebDataBinder paramWebDataBinder)
  {
    paramWebDataBinder.registerCustomEditor(String.class, new HtmlCleanEditor(true, true));
    paramWebDataBinder.registerCustomEditor(Date.class, new DateEditor(true));
  }

  protected boolean IIIllIlI(Object paramObject, Class<?>[] paramArrayOfClass)
  {
    Set localSet = this.IIIllllI.validate(paramObject, paramArrayOfClass);
    if (localSet.isEmpty())
      return true;
    RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
    localRequestAttributes.setAttribute("constraintViolations", localSet, 0);
    return false;
  }

  protected boolean IIIllIlI(Class<?> paramClass, String paramString, Object paramObject, Class<?>[] paramArrayOfClass)
  {
    Set localSet = this.IIIllllI.validateValue(paramClass, paramString, paramObject, paramArrayOfClass);
    if (localSet.isEmpty())
      return true;
    RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
    localRequestAttributes.setAttribute("constraintViolations", localSet, 0);
    return false;
  }

  protected String IIIllIlI(BigDecimal paramBigDecimal, boolean paramBoolean1, boolean paramBoolean2)
  {
    Setting localSetting = SettingUtils.get();
    String str = localSetting.setScale(paramBigDecimal).toString();
    if (paramBoolean1)
      str = localSetting.getCurrencySign() + str;
    if (paramBoolean2)
      str = str + localSetting.getCurrencyUnit();
    return str;
  }

  protected String IIIllIlI(String paramString, Object[] paramArrayOfObject)
  {
    return SpringUtils.getMessage(paramString, paramArrayOfObject);
  }

  protected void IIIllIlI(RedirectAttributes paramRedirectAttributes, Message paramMessage)
  {
    if ((paramRedirectAttributes != null) && (paramMessage != null))
      paramRedirectAttributes.addFlashAttribute(FlashMessageDirective.FLASH_MESSAGE_ATTRIBUTE_NAME, paramMessage);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.BaseController
 * JD-Core Version:    0.6.2
 */