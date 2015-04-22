package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import net.shopxx.listener.EntityListener;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, setterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE, creatorVisibility=JsonAutoDetect.Visibility.NONE)
@EntityListeners({EntityListener.class})
@MappedSuperclass
public abstract class BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = -67188388306700736L;
  public static final String ID_PROPERTY_NAME = "id";
  public static final String CREATE_DATE_PROPERTY_NAME = "createDate";
  public static final String MODIFY_DATE_PROPERTY_NAME = "modifyDate";
  private Long IIIllIlI;
  private Date IIIllIll;
  private Date IIIlllII;

  @JsonProperty
  @DocumentId
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long getId()
  {
    return this.IIIllIlI;
  }

  public void setId(Long id)
  {
    this.IIIllIlI = id;
  }

  @JsonProperty
  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @DateBridge(resolution=Resolution.SECOND)
  @Column(nullable=false, updatable=false)
  public Date getCreateDate()
  {
    return this.IIIllIll;
  }

  public void setCreateDate(Date createDate)
  {
    this.IIIllIll = createDate;
  }

  @JsonProperty
  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @DateBridge(resolution=Resolution.SECOND)
  @Column(nullable=false)
  public Date getModifyDate()
  {
    return this.IIIlllII;
  }

  public void setModifyDate(Date modifyDate)
  {
    this.IIIlllII = modifyDate;
  }

  public boolean equals(Object obj)
  {
    if (obj == null)
      return false;
    if (this == obj)
      return true;
    if (!BaseEntity.class.isAssignableFrom(obj.getClass()))
      return false;
    BaseEntity localBaseEntity = (BaseEntity)obj;
    return getId() != null ? getId().equals(localBaseEntity.getId()) : false;
  }

  public int hashCode()
  {
    int i = 17;
    i += (getId() == null ? 0 : getId().hashCode() * 31);
    return i;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.BaseEntity
 * JD-Core Version:    0.6.2
 */