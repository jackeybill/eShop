package net.shopxx;

import java.beans.PropertyEditorSupport;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class HtmlCleanEditor extends PropertyEditorSupport
{
  private boolean IIIllIlI;
  private boolean IIIllIll;
  private Whitelist IIIlllII = Whitelist.none();

  public HtmlCleanEditor(boolean trim, boolean emptyAsNull)
  {
    this.IIIllIlI = trim;
    this.IIIllIll = emptyAsNull;
  }

  public HtmlCleanEditor(boolean trim, boolean emptyAsNull, Whitelist whitelist)
  {
    this.IIIllIlI = trim;
    this.IIIllIll = emptyAsNull;
    this.IIIlllII = whitelist;
  }

  public String getAsText()
  {
    Object localObject = getValue();
    return localObject != null ? localObject.toString() : "";
  }

  public void setAsText(String text)
  {
    if (text != null)
    {
      String str = this.IIIllIlI ? text.trim() : text;
      str = Jsoup.clean(str, this.IIIlllII);
      if ((this.IIIllIll) && ("".equals(str)))
        str = null;
      setValue(str);
    }
    else
    {
      setValue(null);
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.HtmlCleanEditor
 * JD-Core Version:    0.6.2
 */