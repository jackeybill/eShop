package net.shopxx;

import net.shopxx.util.SpringUtils;

public class Message
{
  private Message.Type IIIllIlI;
  private String IIIllIll;

  public Message()
  {
  }

  public Message(Message.Type type, String content)
  {
    this.IIIllIlI = type;
    this.IIIllIll = content;
  }

  public Message(Message.Type type, String content, Object[] args)
  {
    this.IIIllIlI = type;
    this.IIIllIll = SpringUtils.getMessage(content, args);
  }

  public static Message success(String content, Object[] args)
  {
    return new Message(Message.Type.success, content, args);
  }

  public static Message warn(String content, Object[] args)
  {
    return new Message(Message.Type.warn, content, args);
  }

  public static Message error(String content, Object[] args)
  {
    return new Message(Message.Type.error, content, args);
  }

  public Message.Type getType()
  {
    return this.IIIllIlI;
  }

  public void setType(Message.Type type)
  {
    this.IIIllIlI = type;
  }

  public String getContent()
  {
    return this.IIIllIll;
  }

  public void setContent(String content)
  {
    this.IIIllIll = content;
  }

  public String toString()
  {
    return SpringUtils.getMessage(this.IIIllIll, new Object[0]);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.Message
 * JD-Core Version:    0.6.2
 */