package net.shopxx;

import java.io.Serializable;

public class Principal
  implements Serializable
{
  private static final long serialVersionUID = 5798882004228239559L;
  private Long IIIllIlI;
  private String IIIllIll;

  public Principal(Long id, String username)
  {
    this.IIIllIlI = id;
    this.IIIllIll = username;
  }

  public Long getId()
  {
    return this.IIIllIlI;
  }

  public void setId(Long id)
  {
    this.IIIllIlI = id;
  }

  public String getUsername()
  {
    return this.IIIllIll;
  }

  public void setUsername(String username)
  {
    this.IIIllIll = username;
  }

  public String toString()
  {
    return this.IIIllIll;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.Principal
 * JD-Core Version:    0.6.2
 */