package net.shopxx.entity;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import net.shopxx.interceptor.MemberInterceptor;
import net.shopxx.util.JsonUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_member")
public class Member extends BaseEntity
{
  private static final long serialVersionUID = 1533130686714725835L;
  public static final String PRINCIPAL_ATTRIBUTE_NAME = MemberInterceptor.class.getName() + ".PRINCIPAL";
  public static final String USERNAME_COOKIE_NAME = "username";
  public static final int ATTRIBUTE_VALUE_PROPERTY_COUNT = 10;
  public static final String ATTRIBUTE_VALUE_PROPERTY_NAME_PREFIX = "attributeValue";
  public static final Integer MAX_FAVORITE_COUNT = Integer.valueOf(10);
  private String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private Long IIIlllIl;
  private BigDecimal IIIllllI;
  private BigDecimal IIIlllll;
  private Boolean IIlIIIII;
  private Boolean IIlIIIIl;
  private Integer IIlIIIlI;
  private Date IIlIIIll;
  private String IIlIIlII;
  private String IIlIIlIl;
  private Date IIlIIllI;
  private String IIlIIlll;
  private Member.Gender IIlIlIII;
  private Date IIlIlIIl;
  private String IIlIlIlI;
  private String IIlIlIll;
  private String IIlIllII;
  private String IIlIllIl;
  private String IIlIlllI;
  private String IIlIllll;
  private String IIllIIII;
  private String IIllIIIl;
  private String IIllIIlI;
  private String IIllIIll;
  private String IIllIlII;
  private String IIllIlIl;
  private String IIllIllI;
  private String IIllIlll;
  private SafeKey IIlllIII;
  private Area IIlllIIl;
  private MemberRank IIlllIlI;
  private Cart IIlllIll;
  private Set<Order> IIllllII = new HashSet();
  private Set<Deposit> IIllllIl = new HashSet();
  private Set<Payment> IIlllllI = new HashSet();
  private Set<CouponCode> IIllllll = new HashSet();
  private Set<Receiver> IlIIIIII = new HashSet();
  private Set<Review> IlIIIIIl = new HashSet();
  private Set<Consultation> IlIIIIlI = new HashSet();
  private Set<Product> IlIIIIll = new HashSet();
  private Set<ProductNotify> IlIIIlII = new HashSet();
  private Set<Message> IlIIIlIl = new HashSet();
  private Set<Message> IlIIIllI = new HashSet();

  @NotEmpty(groups={BaseEntity.Save.class})
  @Pattern(regexp="^[0-9a-z_A-Z\\u4e00-\\u9fa5]+$")
  @Column(nullable=false, updatable=false, unique=true)
  public String getUsername()
  {
    return this.IIIllIlI;
  }

  public void setUsername(String username)
  {
    this.IIIllIlI = username;
  }

  @NotEmpty(groups={BaseEntity.Save.class})
  @Pattern(regexp="^[^\\s&\"<>]+$")
  @Column(nullable=false)
  public String getPassword()
  {
    return this.IIIllIll;
  }

  public void setPassword(String password)
  {
    this.IIIllIll = password;
  }

  @NotEmpty
  @Email
  @Length(max=200)
  @Column(nullable=false)
  public String getEmail()
  {
    return this.IIIlllII;
  }

  public void setEmail(String email)
  {
    this.IIIlllII = email;
  }

  @NotNull(groups={BaseEntity.Save.class})
  @Min(0L)
  @Column(nullable=false)
  public Long getPoint()
  {
    return this.IIIlllIl;
  }

  public void setPoint(Long point)
  {
    this.IIIlllIl = point;
  }

  @Column(nullable=false, precision=27, scale=12)
  public BigDecimal getAmount()
  {
    return this.IIIllllI;
  }

  public void setAmount(BigDecimal amount)
  {
    this.IIIllllI = amount;
  }

  @NotNull(groups={BaseEntity.Save.class})
  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(nullable=false, precision=27, scale=12)
  public BigDecimal getBalance()
  {
    return this.IIIlllll;
  }

  public void setBalance(BigDecimal balance)
  {
    this.IIIlllll = balance;
  }

  @NotNull
  @Column(nullable=false)
  public Boolean getIsEnabled()
  {
    return this.IIlIIIII;
  }

  public void setIsEnabled(Boolean isEnabled)
  {
    this.IIlIIIII = isEnabled;
  }

  @Column(nullable=false)
  public Boolean getIsLocked()
  {
    return this.IIlIIIIl;
  }

  public void setIsLocked(Boolean isLocked)
  {
    this.IIlIIIIl = isLocked;
  }

  @Column(nullable=false)
  public Integer getLoginFailureCount()
  {
    return this.IIlIIIlI;
  }

  public void setLoginFailureCount(Integer loginFailureCount)
  {
    this.IIlIIIlI = loginFailureCount;
  }

  public Date getLockedDate()
  {
    return this.IIlIIIll;
  }

  public void setLockedDate(Date lockedDate)
  {
    this.IIlIIIll = lockedDate;
  }

  @Column(nullable=false, updatable=false)
  public String getRegisterIp()
  {
    return this.IIlIIlII;
  }

  public void setRegisterIp(String registerIp)
  {
    this.IIlIIlII = registerIp;
  }

  public String getLoginIp()
  {
    return this.IIlIIlIl;
  }

  public void setLoginIp(String loginIp)
  {
    this.IIlIIlIl = loginIp;
  }

  public Date getLoginDate()
  {
    return this.IIlIIllI;
  }

  public void setLoginDate(Date loginDate)
  {
    this.IIlIIllI = loginDate;
  }

  @Length(max=200)
  public String getName()
  {
    return this.IIlIIlll;
  }

  public void setName(String name)
  {
    this.IIlIIlll = name;
  }

  public Member.Gender getGender()
  {
    return this.IIlIlIII;
  }

  public void setGender(Member.Gender gender)
  {
    this.IIlIlIII = gender;
  }

  public Date getBirth()
  {
    return this.IIlIlIIl;
  }

  public void setBirth(Date birth)
  {
    this.IIlIlIIl = birth;
  }

  @Length(max=200)
  public String getAddress()
  {
    return this.IIlIlIlI;
  }

  public void setAddress(String address)
  {
    this.IIlIlIlI = address;
  }

  @Length(max=200)
  public String getZipCode()
  {
    return this.IIlIlIll;
  }

  public void setZipCode(String zipCode)
  {
    this.IIlIlIll = zipCode;
  }

  @Length(max=200)
  public String getPhone()
  {
    return this.IIlIllII;
  }

  public void setPhone(String phone)
  {
    this.IIlIllII = phone;
  }

  @Length(max=200)
  public String getMobile()
  {
    return this.IIlIllIl;
  }

  public void setMobile(String mobile)
  {
    this.IIlIllIl = mobile;
  }

  @Length(max=200)
  public String getAttributeValue0()
  {
    return this.IIlIlllI;
  }

  public void setAttributeValue0(String attributeValue0)
  {
    this.IIlIlllI = attributeValue0;
  }

  @Length(max=200)
  public String getAttributeValue1()
  {
    return this.IIlIllll;
  }

  public void setAttributeValue1(String attributeValue1)
  {
    this.IIlIllll = attributeValue1;
  }

  @Length(max=200)
  public String getAttributeValue2()
  {
    return this.IIllIIII;
  }

  public void setAttributeValue2(String attributeValue2)
  {
    this.IIllIIII = attributeValue2;
  }

  @Length(max=200)
  public String getAttributeValue3()
  {
    return this.IIllIIIl;
  }

  public void setAttributeValue3(String attributeValue3)
  {
    this.IIllIIIl = attributeValue3;
  }

  @Length(max=200)
  public String getAttributeValue4()
  {
    return this.IIllIIlI;
  }

  public void setAttributeValue4(String attributeValue4)
  {
    this.IIllIIlI = attributeValue4;
  }

  @Length(max=200)
  public String getAttributeValue5()
  {
    return this.IIllIIll;
  }

  public void setAttributeValue5(String attributeValue5)
  {
    this.IIllIIll = attributeValue5;
  }

  @Length(max=200)
  public String getAttributeValue6()
  {
    return this.IIllIlII;
  }

  public void setAttributeValue6(String attributeValue6)
  {
    this.IIllIlII = attributeValue6;
  }

  @Length(max=200)
  public String getAttributeValue7()
  {
    return this.IIllIlIl;
  }

  public void setAttributeValue7(String attributeValue7)
  {
    this.IIllIlIl = attributeValue7;
  }

  @Length(max=200)
  public String getAttributeValue8()
  {
    return this.IIllIllI;
  }

  public void setAttributeValue8(String attributeValue8)
  {
    this.IIllIllI = attributeValue8;
  }

  @Length(max=200)
  public String getAttributeValue9()
  {
    return this.IIllIlll;
  }

  public void setAttributeValue9(String attributeValue9)
  {
    this.IIllIlll = attributeValue9;
  }

  @Embedded
  public SafeKey getSafeKey()
  {
    return this.IIlllIII;
  }

  public void setSafeKey(SafeKey safeKey)
  {
    this.IIlllIII = safeKey;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  public Area getArea()
  {
    return this.IIlllIIl;
  }

  public void setArea(Area area)
  {
    this.IIlllIIl = area;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false)
  public MemberRank getMemberRank()
  {
    return this.IIlllIlI;
  }

  public void setMemberRank(MemberRank memberRank)
  {
    this.IIlllIlI = memberRank;
  }

  @OneToOne(mappedBy="member", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Cart getCart()
  {
    return this.IIlllIll;
  }

  public void setCart(Cart cart)
  {
    this.IIlllIll = cart;
  }

  @OneToMany(mappedBy="member", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<Order> getOrders()
  {
    return this.IIllllII;
  }

  public void setOrders(Set<Order> orders)
  {
    this.IIllllII = orders;
  }

  @OneToMany(mappedBy="member", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<Deposit> getDeposits()
  {
    return this.IIllllIl;
  }

  public void setDeposits(Set<Deposit> deposits)
  {
    this.IIllllIl = deposits;
  }

  @OneToMany(mappedBy="member", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<Payment> getPayments()
  {
    return this.IIlllllI;
  }

  public void setPayments(Set<Payment> payments)
  {
    this.IIlllllI = payments;
  }

  @OneToMany(mappedBy="member", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<CouponCode> getCouponCodes()
  {
    return this.IIllllll;
  }

  public void setCouponCodes(Set<CouponCode> couponCodes)
  {
    this.IIllllll = couponCodes;
  }

  @OneToMany(mappedBy="member", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("isDefault desc, createDate desc")
  public Set<Receiver> getReceivers()
  {
    return this.IlIIIIII;
  }

  public void setReceivers(Set<Receiver> receivers)
  {
    this.IlIIIIII = receivers;
  }

  @OneToMany(mappedBy="member", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("createDate desc")
  public Set<Review> getReviews()
  {
    return this.IlIIIIIl;
  }

  public void setReviews(Set<Review> reviews)
  {
    this.IlIIIIIl = reviews;
  }

  @OneToMany(mappedBy="member", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  @OrderBy("createDate desc")
  public Set<Consultation> getConsultations()
  {
    return this.IlIIIIlI;
  }

  public void setConsultations(Set<Consultation> consultations)
  {
    this.IlIIIIlI = consultations;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_member_favorite_product")
  @OrderBy("createDate desc")
  public Set<Product> getFavoriteProducts()
  {
    return this.IlIIIIll;
  }

  public void setFavoriteProducts(Set<Product> favoriteProducts)
  {
    this.IlIIIIll = favoriteProducts;
  }

  @OneToMany(mappedBy="member", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<ProductNotify> getProductNotifies()
  {
    return this.IlIIIlII;
  }

  public void setProductNotifies(Set<ProductNotify> productNotifies)
  {
    this.IlIIIlII = productNotifies;
  }

  @OneToMany(mappedBy="receiver", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<Message> getInMessages()
  {
    return this.IlIIIlIl;
  }

  public void setInMessages(Set<Message> inMessages)
  {
    this.IlIIIlIl = inMessages;
  }

  @OneToMany(mappedBy="sender", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<Message> getOutMessages()
  {
    return this.IlIIIllI;
  }

  public void setOutMessages(Set<Message> outMessages)
  {
    this.IlIIIllI = outMessages;
  }

  @Transient
  public Object getAttributeValue(MemberAttribute memberAttribute)
  {
    if (memberAttribute != null)
    {
      if (memberAttribute.getType() == MemberAttribute.Type.name)
        return getName();
      if (memberAttribute.getType() == MemberAttribute.Type.gender)
        return getGender();
      if (memberAttribute.getType() == MemberAttribute.Type.birth)
        return getBirth();
      if (memberAttribute.getType() == MemberAttribute.Type.area)
        return getArea();
      if (memberAttribute.getType() == MemberAttribute.Type.address)
        return getAddress();
      if (memberAttribute.getType() == MemberAttribute.Type.zipCode)
        return getZipCode();
      if (memberAttribute.getType() == MemberAttribute.Type.phone)
        return getPhone();
      if (memberAttribute.getType() == MemberAttribute.Type.mobile)
        return getMobile();
      if (memberAttribute.getType() == MemberAttribute.Type.checkbox)
      {
        if (memberAttribute.getPropertyIndex() != null)
          try
          {
            String str1 = "attributeValue" + memberAttribute.getPropertyIndex();
            String str3 = (String)PropertyUtils.getProperty(this, str1);
            if (str3 == null)
              break label262;
            return JsonUtils.toObject(str3, List.class);
          }
          catch (IllegalAccessException localIllegalAccessException2)
          {
            localIllegalAccessException2.printStackTrace();
          }
          catch (InvocationTargetException localInvocationTargetException2)
          {
            localInvocationTargetException2.printStackTrace();
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            localNoSuchMethodException2.printStackTrace();
          }
      }
      else if (memberAttribute.getPropertyIndex() != null)
        try
        {
          String str2 = "attributeValue" + memberAttribute.getPropertyIndex();
          return (String)PropertyUtils.getProperty(this, str2);
        }
        catch (IllegalAccessException localIllegalAccessException3)
        {
          localIllegalAccessException3.printStackTrace();
        }
        catch (InvocationTargetException localInvocationTargetException3)
        {
          localInvocationTargetException3.printStackTrace();
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          localNoSuchMethodException3.printStackTrace();
        }
    }
    label262: return null;
  }

  @Transient
  public void setAttributeValue(MemberAttribute memberAttribute, Object attributeValue)
  {
    if (memberAttribute != null)
    {
      if (((attributeValue instanceof String)) && (StringUtils.isEmpty((String)attributeValue)))
        attributeValue = null;
      if ((memberAttribute.getType() == MemberAttribute.Type.name) && (((attributeValue instanceof String)) || (attributeValue == null)))
        setName((String)attributeValue);
      else if ((memberAttribute.getType() == MemberAttribute.Type.gender) && (((attributeValue instanceof Member.Gender)) || (attributeValue == null)))
        setGender((Member.Gender)attributeValue);
      else if ((memberAttribute.getType() == MemberAttribute.Type.birth) && (((attributeValue instanceof Date)) || (attributeValue == null)))
        setBirth((Date)attributeValue);
      else if ((memberAttribute.getType() == MemberAttribute.Type.area) && (((attributeValue instanceof Area)) || (attributeValue == null)))
        setArea((Area)attributeValue);
      else if ((memberAttribute.getType() == MemberAttribute.Type.address) && (((attributeValue instanceof String)) || (attributeValue == null)))
        setAddress((String)attributeValue);
      else if ((memberAttribute.getType() == MemberAttribute.Type.zipCode) && (((attributeValue instanceof String)) || (attributeValue == null)))
        setZipCode((String)attributeValue);
      else if ((memberAttribute.getType() == MemberAttribute.Type.phone) && (((attributeValue instanceof String)) || (attributeValue == null)))
        setPhone((String)attributeValue);
      else if ((memberAttribute.getType() == MemberAttribute.Type.mobile) && (((attributeValue instanceof String)) || (attributeValue == null)))
        setMobile((String)attributeValue);
      else if ((memberAttribute.getType() == MemberAttribute.Type.checkbox) && (((attributeValue instanceof List)) || (attributeValue == null)))
      {
        if ((memberAttribute.getPropertyIndex() != null) && ((attributeValue == null) || ((memberAttribute.getOptions() != null) && (memberAttribute.getOptions().containsAll((List)attributeValue)))))
          try
          {
            String str1 = "attributeValue" + memberAttribute.getPropertyIndex();
            PropertyUtils.setProperty(this, str1, JsonUtils.toJson(attributeValue));
          }
          catch (IllegalAccessException localIllegalAccessException2)
          {
            localIllegalAccessException2.printStackTrace();
          }
          catch (InvocationTargetException localInvocationTargetException2)
          {
            localInvocationTargetException2.printStackTrace();
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            localNoSuchMethodException2.printStackTrace();
          }
      }
      else if (memberAttribute.getPropertyIndex() != null)
        try
        {
          String str2 = "attributeValue" + memberAttribute.getPropertyIndex();
          PropertyUtils.setProperty(this, str2, attributeValue);
        }
        catch (IllegalAccessException localIllegalAccessException3)
        {
          localIllegalAccessException3.printStackTrace();
        }
        catch (InvocationTargetException localInvocationTargetException3)
        {
          localInvocationTargetException3.printStackTrace();
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          localNoSuchMethodException3.printStackTrace();
        }
    }
  }

  @Transient
  public void removeAttributeValue()
  {
    setName(null);
    setGender(null);
    setBirth(null);
    setArea(null);
    setAddress(null);
    setZipCode(null);
    setPhone(null);
    setMobile(null);
    for (int i = 0; i < 10; i++)
    {
      String str = "attributeValue" + i;
      try
      {
        PropertyUtils.setProperty(this, str, null);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localInvocationTargetException.printStackTrace();
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Member
 * JD-Core Version:    0.6.2
 */