package net.shopxx;

import java.util.Date;

public class FileInfo
{
  private String IIIllIlI;
  private String IIIllIll;
  private Boolean IIIlllII;
  private Long IIIlllIl;
  private Date IIIllllI;

  public String getName()
  {
    return this.IIIllIlI;
  }

  public void setName(String name)
  {
    this.IIIllIlI = name;
  }

  public String getUrl()
  {
    return this.IIIllIll;
  }

  public void setUrl(String url)
  {
    this.IIIllIll = url;
  }

  public Boolean getIsDirectory()
  {
    return this.IIIlllII;
  }

  public void setIsDirectory(Boolean isDirectory)
  {
    this.IIIlllII = isDirectory;
  }

  public Long getSize()
  {
    return this.IIIlllIl;
  }

  public void setSize(Long size)
  {
    this.IIIlllIl = size;
  }

  public Date getLastModified()
  {
    return this.IIIllllI;
  }

  public void setLastModified(Date lastModified)
  {
    this.IIIllllI = lastModified;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.FileInfo
 * JD-Core Version:    0.6.2
 */