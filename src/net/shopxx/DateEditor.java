package net.shopxx;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;

public class DateEditor extends PropertyEditorSupport
{
  private static final String IIIllIlI = "yyyy-MM-dd HH:mm:ss";
  private boolean IIIllIll;
  private String IIIlllII = "yyyy-MM-dd HH:mm:ss";

  public DateEditor(boolean emptyAsNull)
  {
    this.IIIllIll = emptyAsNull;
  }

  public DateEditor(boolean emptyAsNull, String dateFormat)
  {
    this.IIIllIll = emptyAsNull;
    this.IIIlllII = dateFormat;
  }

  public String getAsText()
  {
    Date localDate = (Date)getValue();
    return localDate != null ? new SimpleDateFormat(this.IIIlllII).format(localDate) : "";
  }

  public void setAsText(String text)
  {
    if (text == null)
    {
      setValue(null);
    }
    else
    {
      String str = text.trim();
      if ((this.IIIllIll) && ("".equals(str)))
        setValue(null);
      else
        try
        {
          setValue(DateUtils.parseDate(str, CommonAttributes.DATE_PATTERNS));
        }
        catch (ParseException localParseException)
        {
          setValue(null);
        }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.DateEditor
 * JD-Core Version:    0.6.2
 */