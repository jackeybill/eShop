package net.shopxx.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_message")
public class Message extends BaseEntity
{
  private static final long serialVersionUID = -5035343536762850722L;
  private String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private Boolean IIIlllIl;
  private Boolean IIIllllI;
  private Boolean IIIlllll;
  private Boolean IIlIIIII;
  private Boolean IIlIIIIl;
  private Member IIlIIIlI;
  private Member IIlIIIll;
  private Message IIlIIlII;
  private Set<Message> IIlIIlIl = new HashSet();

  @Column(nullable=false, updatable=false)
  public String getTitle()
  {
    return this.IIIllIlI;
  }

  public void setTitle(String title)
  {
    this.IIIllIlI = title;
  }

  @NotEmpty
  @Length(max=1000)
  @Column(nullable=false, updatable=false, length=1000)
  public String getContent()
  {
    return this.IIIllIll;
  }

  public void setContent(String content)
  {
    this.IIIllIll = content;
  }

  @Column(nullable=false, updatable=false)
  public String getIp()
  {
    return this.IIIlllII;
  }

  public void setIp(String ip)
  {
    this.IIIlllII = ip;
  }

  @Column(nullable=false, updatable=false)
  public Boolean getIsDraft()
  {
    return this.IIIlllIl;
  }

  public void setIsDraft(Boolean isDraft)
  {
    this.IIIlllIl = isDraft;
  }

  @Column(nullable=false)
  public Boolean getSenderRead()
  {
    return this.IIIllllI;
  }

  public void setSenderRead(Boolean senderRead)
  {
    this.IIIllllI = senderRead;
  }

  @Column(nullable=false)
  public Boolean getReceiverRead()
  {
    return this.IIIlllll;
  }

  public void setReceiverRead(Boolean receiverRead)
  {
    this.IIIlllll = receiverRead;
  }

  @Column(nullable=false)
  public Boolean getSenderDelete()
  {
    return this.IIlIIIII;
  }

  public void setSenderDelete(Boolean senderDelete)
  {
    this.IIlIIIII = senderDelete;
  }

  @Column(nullable=false)
  public Boolean getReceiverDelete()
  {
    return this.IIlIIIIl;
  }

  public void setReceiverDelete(Boolean receiverDelete)
  {
    this.IIlIIIIl = receiverDelete;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(updatable=false)
  public Member getSender()
  {
    return this.IIlIIIlI;
  }

  public void setSender(Member sender)
  {
    this.IIlIIIlI = sender;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(updatable=false)
  public Member getReceiver()
  {
    return this.IIlIIIll;
  }

  public void setReceiver(Member receiver)
  {
    this.IIlIIIll = receiver;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(updatable=false)
  public Message getForMessage()
  {
    return this.IIlIIlII;
  }

  public void setForMessage(Message forMessage)
  {
    this.IIlIIlII = forMessage;
  }

  @OneToMany(mappedBy="forMessage", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("createDate asc")
  public Set<Message> getReplyMessages()
  {
    return this.IIlIIlIl;
  }

  public void setReplyMessages(Set<Message> replyMessages)
  {
    this.IIlIIlIl = replyMessages;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Message
 * JD-Core Version:    0.6.2
 */