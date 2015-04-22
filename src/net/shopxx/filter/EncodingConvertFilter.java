package net.shopxx.filter;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

public class EncodingConvertFilter extends OncePerRequestFilter
{
  private String IIIllIlI = "ISO-8859-1";
  private String IIIllIll = "UTF-8";

  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
  {
    if (request.getMethod().equalsIgnoreCase("GET"))
    {
      Iterator localIterator = request.getParameterMap().values().iterator();
      while (localIterator.hasNext())
      {
        String[] arrayOfString = (String[])localIterator.next();
        for (int i = 0; i < arrayOfString.length; i++)
          try
          {
            arrayOfString[i] = new String(arrayOfString[i].getBytes(this.IIIllIlI), this.IIIllIll);
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
      }
    }
    filterChain.doFilter(request, response);
  }

  public String getFromEncoding()
  {
    return this.IIIllIlI;
  }

  public void setFromEncoding(String fromEncoding)
  {
    this.IIIllIlI = fromEncoding;
  }

  public String getToEncoding()
  {
    return this.IIIllIll;
  }

  public void setToEncoding(String toEncoding)
  {
    this.IIIllIll = toEncoding;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.filter.EncodingConvertFilter
 * JD-Core Version:    0.6.2
 */