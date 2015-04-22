package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_receiver")
public class Receiver extends BaseEntity
{
  private static final long serialVersionUID = 2673602067029665976L;
  public static final Integer MAX_RECEIVER_COUNT = Integer.valueOf(8);
  private String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;
  private Boolean IIIlllll;
  private Area IIlIIIII;
  private Member IIlIIIIl;

  @JsonProperty
  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getConsignee()
  {
    return this.IIIllIlI;
  }

  public void setConsignee(String consignee)
  {
    this.IIIllIlI = consignee;
  }

  @JsonProperty
  @Column(nullable=false)
  public String getAreaName()
  {
    return this.IIIllIll;
  }

  public void setAreaName(String areaName)
  {
    this.IIIllIll = areaName;
  }

  @JsonProperty
  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getAddress()
  {
    return this.IIIlllII;
  }

  public void setAddress(String address)
  {
    this.IIIlllII = address;
  }

  @JsonProperty
  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getZipCode()
  {
    return this.IIIlllIl;
  }

  public void setZipCode(String zipCode)
  {
    this.IIIlllIl = zipCode;
  }

  @JsonProperty
  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getPhone()
  {
    return this.IIIllllI;
  }

  public void setPhone(String phone)
  {
    this.IIIllllI = phone;
  }

  @JsonProperty
  @NotNull
  @Column(nullable=false)
  public Boolean getIsDefault()
  {
    return this.IIIlllll;
  }

  public void setIsDefault(Boolean isDefault)
  {
    this.IIIlllll = isDefault;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  public Area getArea()
  {
    return this.IIlIIIII;
  }

  public void setArea(Area area)
  {
    this.IIlIIIII = area;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Member getMember()
  {
    return this.IIlIIIIl;
  }

  public void setMember(Member member)
  {
    this.IIlIIIIl = member;
  }

  @PrePersist
  public void prePersist()
  {
    if (getArea() != null)
      setAreaName(getArea().getFullName());
  }

  @PreUpdate
  public void preUpdate()
  {
    if (getArea() != null)
      setAreaName(getArea().getFullName());
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Receiver
 * JD-Core Version:    0.6.2
 */