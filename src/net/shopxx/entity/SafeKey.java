package net.shopxx.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class SafeKey
  implements Serializable
{
  private static final long serialVersionUID = -8536541568286987548L;
  private String IIIllIlI;
  private Date IIIllIll;

  @Column(name="safe_key_value")
  public String getValue()
  {
    return this.IIIllIlI;
  }

  public void setValue(String value)
  {
    this.IIIllIlI = value;
  }

  @Column(name="safe_key_expire")
  public Date getExpire()
  {
    return this.IIIllIll;
  }

  public void setExpire(Date expire)
  {
    this.IIIllIll = expire;
  }

  @Transient
  public boolean hasExpired()
  {
    return (getExpire() != null) && (new Date().after(getExpire()));
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.SafeKey
 * JD-Core Version:    0.6.2
 */