package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import net.shopxx.BigDecimalNumericFieldBridge;
import net.shopxx.util.FreemarkerUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.io.ClassPathResource;
import org.wltea.analyzer.lucene.IKAnalyzer;

@Indexed
@Entity
@Table(name="xx_product")
public class Product extends BaseEntity
{
  private static final long serialVersionUID = 2167830430439593293L;
  public static final String HITS_CACHE_NAME = "productHits";
  public static final int HITS_CACHE_INTERVAL = 600000;
  public static final int ATTRIBUTE_VALUE_PROPERTY_COUNT = 20;
  public static final String ATTRIBUTE_VALUE_PROPERTY_NAME_PREFIX = "attributeValue";
  public static final String FULL_NAME_SPECIFICATION_PREFIX = "[";
  public static final String FULL_NAME_SPECIFICATION_SUFFIX = "]";
  public static final String FULL_NAME_SPECIFICATION_SEPARATOR = " ";
  private static String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private BigDecimal IIIllllI;
  private BigDecimal IIIlllll;
  private BigDecimal IIlIIIII;
  private String IIlIIIIl;
  private String IIlIIIlI;
  private Integer IIlIIIll;
  private Integer IIlIIlII;
  private Integer IIlIIlIl;
  private String IIlIIllI;
  private Long IIlIIlll;
  private Boolean IIlIlIII;
  private Boolean IIlIlIIl;
  private Boolean IIlIlIlI;
  private Boolean IIlIlIll;
  private String IIlIllII;
  private String IIlIllIl;
  private String IIlIlllI;
  private String IIlIllll;
  private String IIllIIII;
  private String IIllIIIl;
  private Float IIllIIlI;
  private Long IIllIIll;
  private Long IIllIlII;
  private Long IIllIlIl;
  private Long IIllIllI;
  private Long IIllIlll;
  private Long IIlllIII;
  private Long IIlllIIl;
  private Long IIlllIlI;
  private Date IIlllIll;
  private Date IIllllII;
  private Date IIllllIl;
  private Date IIlllllI;
  private String IIllllll;
  private String IlIIIIII;
  private String IlIIIIIl;
  private String IlIIIIlI;
  private String IlIIIIll;
  private String IlIIIlII;
  private String IlIIIlIl;
  private String IlIIIllI;
  private String IlIIIlll;
  private String IlIIlIII;
  private String IlIIlIIl;
  private String IlIIlIlI;
  private String IlIIlIll;
  private String IlIIllII;
  private String IlIIllIl;
  private String IlIIlllI;
  private String IlIIllll;
  private String IlIlIIII;
  private String IlIlIIIl;
  private String IlIlIIlI;
  private ProductCategory IlIlIIll;
  private Goods IlIlIlII;
  private Brand IlIlIlIl;
  private List<ProductImage> IlIlIllI = new ArrayList();
  private Set<Review> IlIlIlll = new HashSet();
  private Set<Consultation> IlIllIII = new HashSet();
  private Set<Tag> IlIllIIl = new HashSet();
  private Set<Member> IlIllIlI = new HashSet();
  private Set<Specification> IlIllIll = new HashSet();
  private Set<SpecificationValue> IlIlllII = new HashSet();
  private Set<Promotion> IlIlllIl = new HashSet();
  private Set<CartItem> IlIllllI = new HashSet();
  private Set<OrderItem> IlIlllll = new HashSet();
  private Set<GiftItem> IllIIIII = new HashSet();
  private Set<ProductNotify> IllIIIIl = new HashSet();
  private Map<MemberRank, BigDecimal> IllIIIlI = new HashMap();
  private Map<Parameter, String> IllIIIll = new HashMap();

  static
  {
    try
    {
      File localFile = new ClassPathResource("/shopxx.xml").getFile();
      Document localDocument = new SAXReader().read(localFile);
      Element localElement = (Element)localDocument.selectSingleNode("/shopxx/template[@id='productContent']");
      IIIllIlI = localElement.attributeValue("staticPath");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  @JsonProperty
  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @Pattern(regexp="^[0-9a-zA-Z_-]+$")
  @Length(max=200)
  @Column(nullable=false, unique=true)
  public String getSn()
  {
    return this.IIIllIll;
  }

  public void setSn(String sn)
  {
    this.IIIllIll = sn;
  }

  @JsonProperty
  @Field(store=Store.YES, index=Index.TOKENIZED, analyzer=@Analyzer(impl=IKAnalyzer.class))
  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getName()
  {
    return this.IIIlllII;
  }

  public void setName(String name)
  {
    this.IIIlllII = name;
  }

  @JsonProperty
  @Field(store=Store.YES, index=Index.NO)
  @Column(nullable=false)
  public String getFullName()
  {
    return this.IIIlllIl;
  }

  public void setFullName(String fullName)
  {
    this.IIIlllIl = fullName;
  }

  @JsonProperty
  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @NumericField
  @FieldBridge(impl=BigDecimalNumericFieldBridge.class)
  @NotNull
  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(nullable=false, precision=21, scale=6)
  public BigDecimal getPrice()
  {
    return this.IIIllllI;
  }

  public void setPrice(BigDecimal price)
  {
    this.IIIllllI = price;
  }

  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(precision=21, scale=6)
  public BigDecimal getCost()
  {
    return this.IIIlllll;
  }

  public void setCost(BigDecimal cost)
  {
    this.IIIlllll = cost;
  }

  @Field(store=Store.YES, index=Index.NO)
  @Min(0L)
  @Digits(integer=12, fraction=3)
  @Column(nullable=false, precision=21, scale=6)
  public BigDecimal getMarketPrice()
  {
    return this.IIlIIIII;
  }

  public void setMarketPrice(BigDecimal marketPrice)
  {
    this.IIlIIIII = marketPrice;
  }

  @JsonProperty
  @Field(store=Store.YES, index=Index.NO)
  @Length(max=200)
  public String getImage()
  {
    return this.IIlIIIIl;
  }

  public void setImage(String image)
  {
    this.IIlIIIIl = image;
  }

  @JsonProperty
  @Field(store=Store.YES, index=Index.NO)
  @Length(max=200)
  public String getUnit()
  {
    return this.IIlIIIlI;
  }

  public void setUnit(String unit)
  {
    this.IIlIIIlI = unit;
  }

  @Field(store=Store.YES, index=Index.NO)
  @Min(0L)
  public Integer getWeight()
  {
    return this.IIlIIIll;
  }

  public void setWeight(Integer weight)
  {
    this.IIlIIIll = weight;
  }

  @Field(store=Store.YES, index=Index.NO)
  @Min(0L)
  public Integer getStock()
  {
    return this.IIlIIlII;
  }

  public void setStock(Integer stock)
  {
    this.IIlIIlII = stock;
  }

  @Field(store=Store.YES, index=Index.NO)
  @Column(nullable=false)
  public Integer getAllocatedStock()
  {
    return this.IIlIIlIl;
  }

  public void setAllocatedStock(Integer allocatedStock)
  {
    this.IIlIIlIl = allocatedStock;
  }

  @Length(max=200)
  public String getStockMemo()
  {
    return this.IIlIIllI;
  }

  public void setStockMemo(String stockMemo)
  {
    this.IIlIIllI = stockMemo;
  }

  @Field(store=Store.YES, index=Index.NO)
  @Min(0L)
  @Column(nullable=false)
  public Long getPoint()
  {
    return this.IIlIIlll;
  }

  public void setPoint(Long point)
  {
    this.IIlIIlll = point;
  }

  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @NotNull
  @Column(nullable=false)
  public Boolean getIsMarketable()
  {
    return this.IIlIlIII;
  }

  public void setIsMarketable(Boolean isMarketable)
  {
    this.IIlIlIII = isMarketable;
  }

  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @NotNull
  @Column(nullable=false)
  public Boolean getIsList()
  {
    return this.IIlIlIIl;
  }

  public void setIsList(Boolean isList)
  {
    this.IIlIlIIl = isList;
  }

  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @NotNull
  @Column(nullable=false)
  public Boolean getIsTop()
  {
    return this.IIlIlIlI;
  }

  public void setIsTop(Boolean isTop)
  {
    this.IIlIlIlI = isTop;
  }

  @JsonProperty
  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @NotNull
  @Column(nullable=false)
  public Boolean getIsGift()
  {
    return this.IIlIlIll;
  }

  public void setIsGift(Boolean isGift)
  {
    this.IIlIlIll = isGift;
  }

  @Field(store=Store.YES, index=Index.TOKENIZED, analyzer=@Analyzer(impl=IKAnalyzer.class))
  @Lob
  public String getIntroduction()
  {
    return this.IIlIllII;
  }

  public void setIntroduction(String introduction)
  {
    this.IIlIllII = introduction;
  }

  @Length(max=200)
  public String getMemo()
  {
    return this.IIlIllIl;
  }

  public void setMemo(String memo)
  {
    this.IIlIllIl = memo;
  }

  @Field(store=Store.YES, index=Index.TOKENIZED, analyzer=@Analyzer(impl=IKAnalyzer.class))
  @Length(max=200)
  public String getKeyword()
  {
    return this.IIlIlllI;
  }

  public void setKeyword(String keyword)
  {
    if (keyword != null)
      keyword = keyword.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "");
    this.IIlIlllI = keyword;
  }

  @Length(max=200)
  public String getSeoTitle()
  {
    return this.IIlIllll;
  }

  public void setSeoTitle(String seoTitle)
  {
    this.IIlIllll = seoTitle;
  }

  @Length(max=200)
  public String getSeoKeywords()
  {
    return this.IIllIIII;
  }

  public void setSeoKeywords(String seoKeywords)
  {
    if (seoKeywords != null)
      seoKeywords = seoKeywords.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "");
    this.IIllIIII = seoKeywords;
  }

  @Length(max=200)
  public String getSeoDescription()
  {
    return this.IIllIIIl;
  }

  public void setSeoDescription(String seoDescription)
  {
    this.IIllIIIl = seoDescription;
  }

  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @NumericField
  @Column(nullable=false, precision=12, scale=6)
  public Float getScore()
  {
    return this.IIllIIlI;
  }

  public void setScore(Float score)
  {
    this.IIllIIlI = score;
  }

  @Column(nullable=false)
  public Long getTotalScore()
  {
    return this.IIllIIll;
  }

  public void setTotalScore(Long totalScore)
  {
    this.IIllIIll = totalScore;
  }

  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @Column(nullable=false)
  public Long getScoreCount()
  {
    return this.IIllIlII;
  }

  public void setScoreCount(Long scoreCount)
  {
    this.IIllIlII = scoreCount;
  }

  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @Column(nullable=false)
  public Long getHits()
  {
    return this.IIllIlIl;
  }

  public void setHits(Long hits)
  {
    this.IIllIlIl = hits;
  }

  @Field(store=Store.YES, index=Index.NO)
  @Column(nullable=false)
  public Long getWeekHits()
  {
    return this.IIllIllI;
  }

  public void setWeekHits(Long weekHits)
  {
    this.IIllIllI = weekHits;
  }

  @Field(store=Store.YES, index=Index.NO)
  @Column(nullable=false)
  public Long getMonthHits()
  {
    return this.IIllIlll;
  }

  public void setMonthHits(Long monthHits)
  {
    this.IIllIlll = monthHits;
  }

  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @Column(nullable=false)
  public Long getSales()
  {
    return this.IIlllIII;
  }

  public void setSales(Long sales)
  {
    this.IIlllIII = sales;
  }

  @Field(store=Store.YES, index=Index.NO)
  @Column(nullable=false)
  public Long getWeekSales()
  {
    return this.IIlllIIl;
  }

  public void setWeekSales(Long weekSales)
  {
    this.IIlllIIl = weekSales;
  }

  @Field(store=Store.YES, index=Index.NO)
  @Column(nullable=false)
  public Long getMonthSales()
  {
    return this.IIlllIlI;
  }

  public void setMonthSales(Long monthSales)
  {
    this.IIlllIlI = monthSales;
  }

  @Column(nullable=false)
  public Date getWeekHitsDate()
  {
    return this.IIlllIll;
  }

  public void setWeekHitsDate(Date weekHitsDate)
  {
    this.IIlllIll = weekHitsDate;
  }

  @Column(nullable=false)
  public Date getMonthHitsDate()
  {
    return this.IIllllII;
  }

  public void setMonthHitsDate(Date monthHitsDate)
  {
    this.IIllllII = monthHitsDate;
  }

  @Column(nullable=false)
  public Date getWeekSalesDate()
  {
    return this.IIllllIl;
  }

  public void setWeekSalesDate(Date weekSalesDate)
  {
    this.IIllllIl = weekSalesDate;
  }

  @Column(nullable=false)
  public Date getMonthSalesDate()
  {
    return this.IIlllllI;
  }

  public void setMonthSalesDate(Date monthSalesDate)
  {
    this.IIlllllI = monthSalesDate;
  }

  @Length(max=200)
  public String getAttributeValue0()
  {
    return this.IIllllll;
  }

  public void setAttributeValue0(String attributeValue0)
  {
    this.IIllllll = attributeValue0;
  }

  @Length(max=200)
  public String getAttributeValue1()
  {
    return this.IlIIIIII;
  }

  public void setAttributeValue1(String attributeValue1)
  {
    this.IlIIIIII = attributeValue1;
  }

  @Length(max=200)
  public String getAttributeValue2()
  {
    return this.IlIIIIIl;
  }

  public void setAttributeValue2(String attributeValue2)
  {
    this.IlIIIIIl = attributeValue2;
  }

  @Length(max=200)
  public String getAttributeValue3()
  {
    return this.IlIIIIlI;
  }

  public void setAttributeValue3(String attributeValue3)
  {
    this.IlIIIIlI = attributeValue3;
  }

  @Length(max=200)
  public String getAttributeValue4()
  {
    return this.IlIIIIll;
  }

  public void setAttributeValue4(String attributeValue4)
  {
    this.IlIIIIll = attributeValue4;
  }

  @Length(max=200)
  public String getAttributeValue5()
  {
    return this.IlIIIlII;
  }

  public void setAttributeValue5(String attributeValue5)
  {
    this.IlIIIlII = attributeValue5;
  }

  @Length(max=200)
  public String getAttributeValue6()
  {
    return this.IlIIIlIl;
  }

  public void setAttributeValue6(String attributeValue6)
  {
    this.IlIIIlIl = attributeValue6;
  }

  @Length(max=200)
  public String getAttributeValue7()
  {
    return this.IlIIIllI;
  }

  public void setAttributeValue7(String attributeValue7)
  {
    this.IlIIIllI = attributeValue7;
  }

  @Length(max=200)
  public String getAttributeValue8()
  {
    return this.IlIIIlll;
  }

  public void setAttributeValue8(String attributeValue8)
  {
    this.IlIIIlll = attributeValue8;
  }

  @Length(max=200)
  public String getAttributeValue9()
  {
    return this.IlIIlIII;
  }

  public void setAttributeValue9(String attributeValue9)
  {
    this.IlIIlIII = attributeValue9;
  }

  @Length(max=200)
  public String getAttributeValue10()
  {
    return this.IlIIlIIl;
  }

  public void setAttributeValue10(String attributeValue10)
  {
    this.IlIIlIIl = attributeValue10;
  }

  @Length(max=200)
  public String getAttributeValue11()
  {
    return this.IlIIlIlI;
  }

  public void setAttributeValue11(String attributeValue11)
  {
    this.IlIIlIlI = attributeValue11;
  }

  @Length(max=200)
  public String getAttributeValue12()
  {
    return this.IlIIlIll;
  }

  public void setAttributeValue12(String attributeValue12)
  {
    this.IlIIlIll = attributeValue12;
  }

  @Length(max=200)
  public String getAttributeValue13()
  {
    return this.IlIIllII;
  }

  public void setAttributeValue13(String attributeValue13)
  {
    this.IlIIllII = attributeValue13;
  }

  @Length(max=200)
  public String getAttributeValue14()
  {
    return this.IlIIllIl;
  }

  public void setAttributeValue14(String attributeValue14)
  {
    this.IlIIllIl = attributeValue14;
  }

  @Length(max=200)
  public String getAttributeValue15()
  {
    return this.IlIIlllI;
  }

  public void setAttributeValue15(String attributeValue15)
  {
    this.IlIIlllI = attributeValue15;
  }

  @Length(max=200)
  public String getAttributeValue16()
  {
    return this.IlIIllll;
  }

  public void setAttributeValue16(String attributeValue16)
  {
    this.IlIIllll = attributeValue16;
  }

  @Length(max=200)
  public String getAttributeValue17()
  {
    return this.IlIlIIII;
  }

  public void setAttributeValue17(String attributeValue17)
  {
    this.IlIlIIII = attributeValue17;
  }

  @Length(max=200)
  public String getAttributeValue18()
  {
    return this.IlIlIIIl;
  }

  public void setAttributeValue18(String attributeValue18)
  {
    this.IlIlIIIl = attributeValue18;
  }

  @Length(max=200)
  public String getAttributeValue19()
  {
    return this.IlIlIIlI;
  }

  public void setAttributeValue19(String attributeValue19)
  {
    this.IlIlIIlI = attributeValue19;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false)
  public ProductCategory getProductCategory()
  {
    return this.IlIlIIll;
  }

  public void setProductCategory(ProductCategory productCategory)
  {
    this.IlIlIIll = productCategory;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  public Goods getGoods()
  {
    return this.IlIlIlII;
  }

  public void setGoods(Goods goods)
  {
    this.IlIlIlII = goods;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  public Brand getBrand()
  {
    return this.IlIlIlIl;
  }

  public void setBrand(Brand brand)
  {
    this.IlIlIlIl = brand;
  }

  @Valid
  @ElementCollection
  @CollectionTable(name="xx_product_product_image")
  public List<ProductImage> getProductImages()
  {
    return this.IlIlIllI;
  }

  public void setProductImages(List<ProductImage> productImages)
  {
    this.IlIlIllI = productImages;
  }

  @OneToMany(mappedBy="product", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<Review> getReviews()
  {
    return this.IlIlIlll;
  }

  public void setReviews(Set<Review> reviews)
  {
    this.IlIlIlll = reviews;
  }

  @OneToMany(mappedBy="product", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<Consultation> getConsultations()
  {
    return this.IlIllIII;
  }

  public void setConsultations(Set<Consultation> consultations)
  {
    this.IlIllIII = consultations;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_product_tag")
  @OrderBy("order asc")
  public Set<Tag> getTags()
  {
    return this.IlIllIIl;
  }

  public void setTags(Set<Tag> tags)
  {
    this.IlIllIIl = tags;
  }

  @ManyToMany(mappedBy="favoriteProducts", fetch=FetchType.LAZY)
  public Set<Member> getFavoriteMembers()
  {
    return this.IlIllIlI;
  }

  public void setFavoriteMembers(Set<Member> favoriteMembers)
  {
    this.IlIllIlI = favoriteMembers;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_product_specification")
  @OrderBy("order asc")
  public Set<Specification> getSpecifications()
  {
    return this.IlIllIll;
  }

  public void setSpecifications(Set<Specification> specifications)
  {
    this.IlIllIll = specifications;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_product_specification_value")
  @OrderBy("specification asc")
  public Set<SpecificationValue> getSpecificationValues()
  {
    return this.IlIlllII;
  }

  public void setSpecificationValues(Set<SpecificationValue> specificationValues)
  {
    this.IlIlllII = specificationValues;
  }

  @ManyToMany(mappedBy="products", fetch=FetchType.LAZY)
  public Set<Promotion> getPromotions()
  {
    return this.IlIlllIl;
  }

  public void setPromotions(Set<Promotion> promotions)
  {
    this.IlIlllIl = promotions;
  }

  @OneToMany(mappedBy="product", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<CartItem> getCartItems()
  {
    return this.IlIllllI;
  }

  public void setCartItems(Set<CartItem> cartItems)
  {
    this.IlIllllI = cartItems;
  }

  @OneToMany(mappedBy="product", fetch=FetchType.LAZY)
  public Set<OrderItem> getOrderItems()
  {
    return this.IlIlllll;
  }

  public void setOrderItems(Set<OrderItem> orderItems)
  {
    this.IlIlllll = orderItems;
  }

  @OneToMany(mappedBy="gift", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
  public Set<GiftItem> getGiftItems()
  {
    return this.IllIIIII;
  }

  public void setGiftItems(Set<GiftItem> giftItems)
  {
    this.IllIIIII = giftItems;
  }

  @OneToMany(mappedBy="product", fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.REMOVE})
  public Set<ProductNotify> getProductNotifies()
  {
    return this.IllIIIIl;
  }

  public void setProductNotifies(Set<ProductNotify> productNotifies)
  {
    this.IllIIIIl = productNotifies;
  }

  @ElementCollection(fetch=FetchType.LAZY)
  @CollectionTable(name="xx_product_member_price")
  public Map<MemberRank, BigDecimal> getMemberPrice()
  {
    return this.IllIIIlI;
  }

  public void setMemberPrice(Map<MemberRank, BigDecimal> memberPrice)
  {
    this.IllIIIlI = memberPrice;
  }

  @ElementCollection(fetch=FetchType.LAZY)
  @CollectionTable(name="xx_product_parameter_value")
  public Map<Parameter, String> getParameterValue()
  {
    return this.IllIIIll;
  }

  public void setParameterValue(Map<Parameter, String> parameterValue)
  {
    this.IllIIIll = parameterValue;
  }

  @Transient
  public String getAttributeValue(Attribute attribute)
  {
    if ((attribute != null) && (attribute.getPropertyIndex() != null))
      try
      {
        String str = "attributeValue" + attribute.getPropertyIndex();
        return (String)PropertyUtils.getProperty(this, str);
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        localIllegalAccessException1.printStackTrace();
      }
      catch (InvocationTargetException localInvocationTargetException1)
      {
        localInvocationTargetException1.printStackTrace();
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        localNoSuchMethodException1.printStackTrace();
      }
    return null;
  }

  @Transient
  public void setAttributeValue(Attribute attribute, String value)
  {
    if ((attribute != null) && (attribute.getPropertyIndex() != null))
    {
      if (StringUtils.isEmpty(value))
        value = null;
      if ((value == null) || ((attribute.getOptions() != null) && (attribute.getOptions().contains(value))))
        try
        {
          String str = "attributeValue" + attribute.getPropertyIndex();
          PropertyUtils.setProperty(this, str, value);
        }
        catch (IllegalAccessException localIllegalAccessException1)
        {
          localIllegalAccessException1.printStackTrace();
        }
        catch (InvocationTargetException localInvocationTargetException1)
        {
          localInvocationTargetException1.printStackTrace();
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
          localNoSuchMethodException1.printStackTrace();
        }
    }
  }

  @Transient
  public List<Product> getSiblings()
  {
    ArrayList localArrayList = new ArrayList();
    if ((getGoods() != null) && (getGoods().getProducts() != null))
    {
      Iterator localIterator = getGoods().getProducts().iterator();
      while (localIterator.hasNext())
      {
        Product localProduct = (Product)localIterator.next();
        if (!equals(localProduct))
          localArrayList.add(localProduct);
      }
    }
    return localArrayList;
  }

  @JsonProperty
  @Transient
  public String getPath()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", getId());
    localHashMap.put("createDate", getCreateDate());
    localHashMap.put("modifyDate", getModifyDate());
    localHashMap.put("sn", getSn());
    localHashMap.put("name", getName());
    localHashMap.put("fullName", getFullName());
    localHashMap.put("seoTitle", getSeoTitle());
    localHashMap.put("seoKeywords", getSeoKeywords());
    localHashMap.put("seoDescription", getSeoDescription());
    localHashMap.put("productCategory", getProductCategory());
    return FreemarkerUtils.process(IIIllIlI, localHashMap);
  }

  @JsonProperty
  @Transient
  public String getThumbnail()
  {
    if ((getProductImages() != null) && (!getProductImages().isEmpty()))
      return ((ProductImage)getProductImages().get(0)).getThumbnail();
    return null;
  }

  @Transient
  public Set<Promotion> getValidPromotions()
  {
    HashSet localHashSet = new HashSet();
    if (getPromotions() != null)
      localHashSet.addAll(getPromotions());
    if ((getProductCategory() != null) && (getProductCategory().getPromotions() != null))
      localHashSet.addAll(getProductCategory().getPromotions());
    if ((getBrand() != null) && (getBrand().getPromotions() != null))
      localHashSet.addAll(getBrand().getPromotions());
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      Promotion localPromotion = (Promotion)localIterator.next();
      if ((localPromotion != null) && (localPromotion.hasBegun()) && (!localPromotion.hasEnded()))
        localTreeSet.add(localPromotion);
    }
    return localTreeSet;
  }

  @Transient
  public Integer getAvailableStock()
  {
    Integer localInteger = null;
    if ((getStock() != null) && (getAllocatedStock() != null))
    {
      localInteger = Integer.valueOf(getStock().intValue() - getAllocatedStock().intValue());
      if (localInteger.intValue() < 0)
        localInteger = Integer.valueOf(0);
    }
    return localInteger;
  }

  @Transient
  public Boolean getIsOutOfStock()
  {
    if ((getStock() != null) && (getAllocatedStock() != null) && (getAllocatedStock().intValue() >= getStock().intValue()))
      return Boolean.valueOf(true);
    return Boolean.valueOf(false);
  }

  @PreRemove
  public void preRemove()
  {
    Set localSet = getFavoriteMembers();
    if (localSet != null)
    {
      localObject2 = localSet.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Member)((Iterator)localObject2).next();
        ((Member)localObject1).getFavoriteProducts().remove(this);
      }
    }
    Object localObject1 = getPromotions();
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((Set)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Promotion)((Iterator)localObject3).next();
        ((Promotion)localObject2).getProducts().remove(this);
      }
    }
    Object localObject2 = getOrderItems();
    if (localObject2 != null)
    {
      Iterator localIterator = ((Set)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (OrderItem)localIterator.next();
        ((OrderItem)localObject3).setProduct(null);
      }
    }
  }

  @PrePersist
  public void prePersist()
  {
    if (getStock() == null)
      setAllocatedStock(Integer.valueOf(0));
    setScore(Float.valueOf(0.0F));
  }

  @PreUpdate
  public void preUpdate()
  {
    if (getStock() == null)
      setAllocatedStock(Integer.valueOf(0));
    if ((getTotalScore() != null) && (getScoreCount() != null) && (getScoreCount().longValue() != 0L))
      setScore(Float.valueOf((float)getTotalScore().longValue() / (float)getScoreCount().longValue()));
    else
      setScore(Float.valueOf(0.0F));
  }

  public String toString()
  {
    return getFullName();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Product
 * JD-Core Version:    0.6.2
 */