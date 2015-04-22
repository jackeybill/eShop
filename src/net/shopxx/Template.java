package net.shopxx;

import java.io.Serializable;

public class Template
  implements Serializable
{
  private static final long serialVersionUID = -517540800437045215L;
  private String IIIllIlI;
  private Template.Type IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;
  private String IIIlllll;

  public String getId()
  {
    return this.IIIllIlI;
  }

  public void setId(String id)
  {
    this.IIIllIlI = id;
  }

  public Template.Type getType()
  {
    return this.IIIllIll;
  }

  public void setType(Template.Type type)
  {
    this.IIIllIll = type;
  }

  public String getName()
  {
    return this.IIIlllII;
  }

  public void setName(String name)
  {
    this.IIIlllII = name;
  }

  public String getTemplatePath()
  {
    return this.IIIlllIl;
  }

  public void setTemplatePath(String templatePath)
  {
    this.IIIlllIl = templatePath;
  }

  public String getStaticPath()
  {
    return this.IIIllllI;
  }

  public void setStaticPath(String staticPath)
  {
    this.IIIllllI = staticPath;
  }

  public String getDescription()
  {
    return this.IIIlllll;
  }

  public void setDescription(String description)
  {
    this.IIIlllll = description;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.Template
 * JD-Core Version:    0.6.2
 */