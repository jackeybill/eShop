package net.shopxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="xx_log")
public class Log extends BaseEntity
{
  private static final long serialVersionUID = -4494144902110236826L;
  public static final String LOG_CONTENT_ATTRIBUTE_NAME = Log.class.getName() + ".CONTENT";
  private String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;

  @Column(nullable=false, updatable=false)
  public String getOperation()
  {
    return this.IIIllIlI;
  }

  public void setOperation(String operation)
  {
    this.IIIllIlI = operation;
  }

  @Column(updatable=false)
  public String getOperator()
  {
    return this.IIIllIll;
  }

  public void setOperator(String operator)
  {
    this.IIIllIll = operator;
  }

  @Column(length=3000, updatable=false)
  public String getContent()
  {
    return this.IIIlllII;
  }

  public void setContent(String content)
  {
    this.IIIlllII = content;
  }

  @Lob
  @Column(updatable=false)
  public String getParameter()
  {
    return this.IIIlllIl;
  }

  public void setParameter(String parameter)
  {
    this.IIIlllIl = parameter;
  }

  @Column(nullable=false, updatable=false)
  public String getIp()
  {
    return this.IIIllllI;
  }

  public void setIp(String ip)
  {
    this.IIIllllI = ip;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Log
 * JD-Core Version:    0.6.2
 */