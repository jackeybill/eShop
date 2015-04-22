package net.shopxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_delivery_center")
public class DeliveryCenter extends BaseEntity
{
  private static final long serialVersionUID = 3328996121729039075L;
  private String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;
  private String IIIlllll;
  private String IIlIIIII;
  private String IIlIIIIl;
  private Boolean IIlIIIlI;
  private Area IIlIIIll;

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getName()
  {
    return this.IIIllIlI;
  }

  public void setName(String name)
  {
    this.IIIllIlI = name;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getContact()
  {
    return this.IIIllIll;
  }

  public void setContact(String contact)
  {
    this.IIIllIll = contact;
  }

  @Column(nullable=false)
  public String getAreaName()
  {
    return this.IIIlllII;
  }

  public void setAreaName(String areaName)
  {
    this.IIIlllII = areaName;
  }

  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getAddress()
  {
    return this.IIIlllIl;
  }

  public void setAddress(String address)
  {
    this.IIIlllIl = address;
  }

  @Length(max=200)
  public String getZipCode()
  {
    return this.IIIllllI;
  }

  public void setZipCode(String zipCode)
  {
    this.IIIllllI = zipCode;
  }

  @Length(max=200)
  public String getPhone()
  {
    return this.IIIlllll;
  }

  public void setPhone(String phone)
  {
    this.IIIlllll = phone;
  }

  @Length(max=200)
  public String getMobile()
  {
    return this.IIlIIIII;
  }

  public void setMobile(String mobile)
  {
    this.IIlIIIII = mobile;
  }

  @Length(max=200)
  public String getMemo()
  {
    return this.IIlIIIIl;
  }

  public void setMemo(String memo)
  {
    this.IIlIIIIl = memo;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsDefault()
  {
    return this.IIlIIIlI;
  }

  public void setIsDefault(Boolean isDefault)
  {
    this.IIlIIIlI = isDefault;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  public Area getArea()
  {
    return this.IIlIIIll;
  }

  public void setArea(Area area)
  {
    this.IIlIIIll = area;
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
 * Qualified Name:     net.shopxx.entity.DeliveryCenter
 * JD-Core Version:    0.6.2
 */