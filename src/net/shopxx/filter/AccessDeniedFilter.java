package net.shopxx.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class AccessDeniedFilter
  implements Filter
{
  private static final String IIIllIlI = "Access denied!";

  public void init(FilterConfig filterConfig)
  {
  }

  public void destroy()
  {
  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
  {
    HttpServletResponse localHttpServletResponse = (HttpServletResponse)servletResponse;
    localHttpServletResponse.sendError(403, "Access denied!");
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.filter.AccessDeniedFilter
 * JD-Core Version:    0.6.2
 */