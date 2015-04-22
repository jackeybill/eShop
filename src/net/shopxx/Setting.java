/*      */ package net.shopxx;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.math.BigDecimal;
/*      */ import javax.validation.constraints.Digits;
/*      */ import javax.validation.constraints.Max;
/*      */ import javax.validation.constraints.Min;
/*      */ import javax.validation.constraints.NotNull;
/*      */ import org.apache.commons.lang.StringUtils;
/*      */ import org.hibernate.validator.constraints.Email;
/*      */ import org.hibernate.validator.constraints.Length;
/*      */ import org.hibernate.validator.constraints.NotEmpty;
/*      */ 
/*      */ public class Setting
/*      */   implements Serializable
/*      */ {
/*      */   private static final long serialVersionUID = -1478999889661796840L;
/*      */   public static final String CACHE_NAME = "setting";
/*  158 */   public static final Integer CACHE_KEY = Integer.valueOf(0);
/*      */   private static final String SEPARATOR = ",";
/*      */   private String siteName;
/*      */   private String siteUrl;
/*      */   private String logo;
/*      */   private String hotSearch;
/*      */   private String address;
/*      */   private String phone;
/*      */   private String zipCode;
/*      */   private String email;
/*      */   private String certtext;
/*      */   private Boolean isSiteEnabled;
/*      */   private String siteCloseMessage;
/*      */   private Integer largeProductImageWidth;
/*      */   private Integer largeProductImageHeight;
/*      */   private Integer mediumProductImageWidth;
/*      */   private Integer mediumProductImageHeight;
/*      */   private Integer thumbnailProductImageWidth;
/*      */   private Integer thumbnailProductImageHeight;
/*      */   private String defaultLargeProductImage;
/*      */   private String defaultMediumProductImage;
/*      */   private String defaultThumbnailProductImage;
/*      */   private Integer watermarkAlpha;
/*      */   private String watermarkImage;
/*      */   private WatermarkPosition watermarkPosition;
/*      */   private Integer priceScale;
/*      */   private RoundType priceRoundType;
/*      */   private Boolean isShowMarketPrice;
/*      */   private Double defaultMarketPriceScale;
/*      */   private Boolean isRegisterEnabled;
/*      */   private Boolean isDuplicateEmail;
/*      */   private String disabledUsername;
/*      */   private Integer usernameMinLength;
/*      */   private Integer usernameMaxLength;
/*      */   private Integer passwordMinLength;
/*      */   private Integer passwordMaxLength;
/*      */   private Long registerPoint;
/*      */   private String registerAgreement;
/*      */   private Boolean isEmailLogin;
/*      */   private CaptchaType[] captchaTypes;
/*      */   private AccountLockType[] accountLockTypes;
/*      */   private Integer accountLockCount;
/*      */   private Integer accountLockTime;
/*      */   private Integer safeKeyExpiryTime;
/*      */   private Integer uploadMaxSize;
/*      */   private String uploadImageExtension;
/*      */   private String uploadFlashExtension;
/*      */   private String uploadMediaExtension;
/*      */   private String uploadFileExtension;
/*      */   private String imageUploadPath;
/*      */   private String flashUploadPath;
/*      */   private String mediaUploadPath;
/*      */   private String fileUploadPath;
/*      */   private String smtpFromMail;
/*      */   private String smtpHost;
/*      */   private Integer smtpPort;
/*      */   private String smtpUsername;
/*      */   private String smtpPassword;
/*      */   private String currencySign;
/*      */   private String currencyUnit;
/*      */   private Integer stockAlertCount;
/*      */   private StockAllocationTime stockAllocationTime;
/*      */   private Double defaultPointScale;
/*      */   private Boolean isDevelopmentEnabled;
/*      */   private Boolean isReviewEnabled;
/*      */   private Boolean isReviewCheck;
/*      */   private ReviewAuthority reviewAuthority;
/*      */   private Boolean isConsultationEnabled;
/*      */   private Boolean isConsultationCheck;
/*      */   private ConsultationAuthority consultationAuthority;
/*      */   private Boolean isInvoiceEnabled;
/*      */   private Boolean isTaxPriceEnabled;
/*      */   private Double taxRate;
/*      */   private String cookiePath;
/*      */   private String cookieDomain;
/*      */   private String kuaidi100Key;
/*      */   private Boolean isCnzzEnabled;
/*      */   private String cnzzSiteId;
/*      */   private String cnzzPassword;
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getSiteName()
/*      */   {
/*  402 */     return this.siteName;
/*      */   }
/*      */ 
/*      */   public void setSiteName(String siteName)
/*      */   {
/*  412 */     this.siteName = siteName;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getSiteUrl()
/*      */   {
/*  423 */     return this.siteUrl;
/*      */   }
/*      */ 
/*      */   public void setSiteUrl(String siteUrl)
/*      */   {
/*  433 */     this.siteUrl = StringUtils.removeEnd(siteUrl, "/");
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getLogo()
/*      */   {
/*  444 */     return this.logo;
/*      */   }
/*      */ 
/*      */   public void setLogo(String logo)
/*      */   {
/*  454 */     this.logo = logo;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getHotSearch()
/*      */   {
/*  464 */     return this.hotSearch;
/*      */   }
/*      */ 
/*      */   public void setHotSearch(String hotSearch)
/*      */   {
/*  474 */     if (hotSearch != null) {
/*  475 */       hotSearch = hotSearch.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "");
/*      */     }
/*  477 */     this.hotSearch = hotSearch;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getAddress()
/*      */   {
/*  487 */     return this.address;
/*      */   }
/*      */ 
/*      */   public void setAddress(String address)
/*      */   {
/*  497 */     this.address = address;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getPhone()
/*      */   {
/*  507 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setPhone(String phone)
/*      */   {
/*  517 */     this.phone = phone;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getZipCode()
/*      */   {
/*  527 */     return this.zipCode;
/*      */   }
/*      */ 
/*      */   public void setZipCode(String zipCode)
/*      */   {
/*  537 */     this.zipCode = zipCode;
/*      */   }
/*      */ 
/*      */   @Email
/*      */   @Length(max=200)
/*      */   public String getEmail()
/*      */   {
/*  548 */     return this.email;
/*      */   }
/*      */ 
/*      */   public void setEmail(String email)
/*      */   {
/*  558 */     this.email = email;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getCerttext()
/*      */   {
/*  568 */     return this.certtext;
/*      */   }
/*      */ 
/*      */   public void setCerttext(String certtext)
/*      */   {
/*  578 */     this.certtext = certtext;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsSiteEnabled()
/*      */   {
/*  588 */     return this.isSiteEnabled;
/*      */   }
/*      */ 
/*      */   public void setIsSiteEnabled(Boolean isSiteEnabled)
/*      */   {
/*  598 */     this.isSiteEnabled = isSiteEnabled;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   public String getSiteCloseMessage()
/*      */   {
/*  608 */     return this.siteCloseMessage;
/*      */   }
/*      */ 
/*      */   public void setSiteCloseMessage(String siteCloseMessage)
/*      */   {
/*  618 */     this.siteCloseMessage = siteCloseMessage;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(1L)
/*      */   public Integer getLargeProductImageWidth()
/*      */   {
/*  629 */     return this.largeProductImageWidth;
/*      */   }
/*      */ 
/*      */   public void setLargeProductImageWidth(Integer largeProductImageWidth)
/*      */   {
/*  639 */     this.largeProductImageWidth = largeProductImageWidth;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(1L)
/*      */   public Integer getLargeProductImageHeight()
/*      */   {
/*  650 */     return this.largeProductImageHeight;
/*      */   }
/*      */ 
/*      */   public void setLargeProductImageHeight(Integer largeProductImageHeight)
/*      */   {
/*  660 */     this.largeProductImageHeight = largeProductImageHeight;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(1L)
/*      */   public Integer getMediumProductImageWidth()
/*      */   {
/*  671 */     return this.mediumProductImageWidth;
/*      */   }
/*      */ 
/*      */   public void setMediumProductImageWidth(Integer mediumProductImageWidth)
/*      */   {
/*  681 */     this.mediumProductImageWidth = mediumProductImageWidth;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(1L)
/*      */   public Integer getMediumProductImageHeight()
/*      */   {
/*  692 */     return this.mediumProductImageHeight;
/*      */   }
/*      */ 
/*      */   public void setMediumProductImageHeight(Integer mediumProductImageHeight)
/*      */   {
/*  702 */     this.mediumProductImageHeight = mediumProductImageHeight;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(1L)
/*      */   public Integer getThumbnailProductImageWidth()
/*      */   {
/*  713 */     return this.thumbnailProductImageWidth;
/*      */   }
/*      */ 
/*      */   public void setThumbnailProductImageWidth(Integer thumbnailProductImageWidth)
/*      */   {
/*  723 */     this.thumbnailProductImageWidth = thumbnailProductImageWidth;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(1L)
/*      */   public Integer getThumbnailProductImageHeight()
/*      */   {
/*  734 */     return this.thumbnailProductImageHeight;
/*      */   }
/*      */ 
/*      */   public void setThumbnailProductImageHeight(Integer thumbnailProductImageHeight)
/*      */   {
/*  744 */     this.thumbnailProductImageHeight = thumbnailProductImageHeight;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getDefaultLargeProductImage()
/*      */   {
/*  755 */     return this.defaultLargeProductImage;
/*      */   }
/*      */ 
/*      */   public void setDefaultLargeProductImage(String defaultLargeProductImage)
/*      */   {
/*  765 */     this.defaultLargeProductImage = defaultLargeProductImage;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getDefaultMediumProductImage()
/*      */   {
/*  776 */     return this.defaultMediumProductImage;
/*      */   }
/*      */ 
/*      */   public void setDefaultMediumProductImage(String defaultMediumProductImage)
/*      */   {
/*  786 */     this.defaultMediumProductImage = defaultMediumProductImage;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getDefaultThumbnailProductImage()
/*      */   {
/*  797 */     return this.defaultThumbnailProductImage;
/*      */   }
/*      */ 
/*      */   public void setDefaultThumbnailProductImage(String defaultThumbnailProductImage)
/*      */   {
/*  807 */     this.defaultThumbnailProductImage = defaultThumbnailProductImage;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(0L)
/*      */   @Max(100L)
/*      */   public Integer getWatermarkAlpha()
/*      */   {
/*  819 */     return this.watermarkAlpha;
/*      */   }
/*      */ 
/*      */   public void setWatermarkAlpha(Integer watermarkAlpha)
/*      */   {
/*  829 */     this.watermarkAlpha = watermarkAlpha;
/*      */   }
/*      */ 
/*      */   public String getWatermarkImage()
/*      */   {
/*  838 */     return this.watermarkImage;
/*      */   }
/*      */ 
/*      */   public void setWatermarkImage(String watermarkImage)
/*      */   {
/*  848 */     this.watermarkImage = watermarkImage;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public WatermarkPosition getWatermarkPosition()
/*      */   {
/*  858 */     return this.watermarkPosition;
/*      */   }
/*      */ 
/*      */   public void setWatermarkPosition(WatermarkPosition watermarkPosition)
/*      */   {
/*  868 */     this.watermarkPosition = watermarkPosition;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(0L)
/*      */   @Max(3L)
/*      */   public Integer getPriceScale()
/*      */   {
/*  880 */     return this.priceScale;
/*      */   }
/*      */ 
/*      */   public void setPriceScale(Integer priceScale)
/*      */   {
/*  890 */     this.priceScale = priceScale;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public RoundType getPriceRoundType()
/*      */   {
/*  900 */     return this.priceRoundType;
/*      */   }
/*      */ 
/*      */   public void setPriceRoundType(RoundType priceRoundType)
/*      */   {
/*  910 */     this.priceRoundType = priceRoundType;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsShowMarketPrice()
/*      */   {
/*  920 */     return this.isShowMarketPrice;
/*      */   }
/*      */ 
/*      */   public void setIsShowMarketPrice(Boolean isShowMarketPrice)
/*      */   {
/*  930 */     this.isShowMarketPrice = isShowMarketPrice;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(0L)
/*      */   @Digits(integer=3, fraction=3)
/*      */   public Double getDefaultMarketPriceScale()
/*      */   {
/*  942 */     return this.defaultMarketPriceScale;
/*      */   }
/*      */ 
/*      */   public void setDefaultMarketPriceScale(Double defaultMarketPriceScale)
/*      */   {
/*  952 */     this.defaultMarketPriceScale = defaultMarketPriceScale;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsRegisterEnabled()
/*      */   {
/*  962 */     return this.isRegisterEnabled;
/*      */   }
/*      */ 
/*      */   public void setIsRegisterEnabled(Boolean isRegisterEnabled)
/*      */   {
/*  972 */     this.isRegisterEnabled = isRegisterEnabled;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsDuplicateEmail()
/*      */   {
/*  982 */     return this.isDuplicateEmail;
/*      */   }
/*      */ 
/*      */   public void setIsDuplicateEmail(Boolean isDuplicateEmail)
/*      */   {
/*  992 */     this.isDuplicateEmail = isDuplicateEmail;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getDisabledUsername()
/*      */   {
/* 1002 */     return this.disabledUsername;
/*      */   }
/*      */ 
/*      */   public void setDisabledUsername(String disabledUsername)
/*      */   {
/* 1012 */     if (disabledUsername != null) {
/* 1013 */       disabledUsername = disabledUsername.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "");
/*      */     }
/* 1015 */     this.disabledUsername = disabledUsername;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(1L)
/*      */   @Max(117L)
/*      */   public Integer getUsernameMinLength()
/*      */   {
/* 1027 */     return this.usernameMinLength;
/*      */   }
/*      */ 
/*      */   public void setUsernameMinLength(Integer usernameMinLength)
/*      */   {
/* 1037 */     this.usernameMinLength = usernameMinLength;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(1L)
/*      */   @Max(117L)
/*      */   public Integer getUsernameMaxLength()
/*      */   {
/* 1049 */     return this.usernameMaxLength;
/*      */   }
/*      */ 
/*      */   public void setUsernameMaxLength(Integer usernameMaxLength)
/*      */   {
/* 1059 */     this.usernameMaxLength = usernameMaxLength;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(1L)
/*      */   @Max(117L)
/*      */   public Integer getPasswordMinLength()
/*      */   {
/* 1071 */     return this.passwordMinLength;
/*      */   }
/*      */ 
/*      */   public void setPasswordMinLength(Integer passwordMinLength)
/*      */   {
/* 1081 */     this.passwordMinLength = passwordMinLength;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(1L)
/*      */   @Max(117L)
/*      */   public Integer getPasswordMaxLength()
/*      */   {
/* 1093 */     return this.passwordMaxLength;
/*      */   }
/*      */ 
/*      */   public void setPasswordMaxLength(Integer passwordMaxLength)
/*      */   {
/* 1103 */     this.passwordMaxLength = passwordMaxLength;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(0L)
/*      */   public Long getRegisterPoint()
/*      */   {
/* 1114 */     return this.registerPoint;
/*      */   }
/*      */ 
/*      */   public void setRegisterPoint(Long registerPoint)
/*      */   {
/* 1124 */     this.registerPoint = registerPoint;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   public String getRegisterAgreement()
/*      */   {
/* 1134 */     return this.registerAgreement;
/*      */   }
/*      */ 
/*      */   public void setRegisterAgreement(String registerAgreement)
/*      */   {
/* 1144 */     this.registerAgreement = registerAgreement;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsEmailLogin()
/*      */   {
/* 1154 */     return this.isEmailLogin;
/*      */   }
/*      */ 
/*      */   public void setIsEmailLogin(Boolean isEmailLogin)
/*      */   {
/* 1164 */     this.isEmailLogin = isEmailLogin;
/*      */   }
/*      */ 
/*      */   public CaptchaType[] getCaptchaTypes()
/*      */   {
/* 1173 */     return this.captchaTypes;
/*      */   }
/*      */ 
/*      */   public void setCaptchaTypes(CaptchaType[] captchaTypes)
/*      */   {
/* 1183 */     this.captchaTypes = captchaTypes;
/*      */   }
/*      */ 
/*      */   public AccountLockType[] getAccountLockTypes()
/*      */   {
/* 1192 */     return this.accountLockTypes;
/*      */   }
/*      */ 
/*      */   public void setAccountLockTypes(AccountLockType[] accountLockTypes)
/*      */   {
/* 1202 */     this.accountLockTypes = accountLockTypes;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(1L)
/*      */   public Integer getAccountLockCount()
/*      */   {
/* 1213 */     return this.accountLockCount;
/*      */   }
/*      */ 
/*      */   public void setAccountLockCount(Integer accountLockCount)
/*      */   {
/* 1223 */     this.accountLockCount = accountLockCount;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(0L)
/*      */   public Integer getAccountLockTime()
/*      */   {
/* 1234 */     return this.accountLockTime;
/*      */   }
/*      */ 
/*      */   public void setAccountLockTime(Integer accountLockTime)
/*      */   {
/* 1244 */     this.accountLockTime = accountLockTime;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(0L)
/*      */   public Integer getSafeKeyExpiryTime()
/*      */   {
/* 1255 */     return this.safeKeyExpiryTime;
/*      */   }
/*      */ 
/*      */   public void setSafeKeyExpiryTime(Integer safeKeyExpiryTime)
/*      */   {
/* 1265 */     this.safeKeyExpiryTime = safeKeyExpiryTime;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(0L)
/*      */   public Integer getUploadMaxSize()
/*      */   {
/* 1276 */     return this.uploadMaxSize;
/*      */   }
/*      */ 
/*      */   public void setUploadMaxSize(Integer uploadMaxSize)
/*      */   {
/* 1286 */     this.uploadMaxSize = uploadMaxSize;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getUploadImageExtension()
/*      */   {
/* 1296 */     return this.uploadImageExtension;
/*      */   }
/*      */ 
/*      */   public void setUploadImageExtension(String uploadImageExtension)
/*      */   {
/* 1306 */     if (uploadImageExtension != null) {
/* 1307 */       uploadImageExtension = uploadImageExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
/*      */     }
/* 1309 */     this.uploadImageExtension = uploadImageExtension;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getUploadFlashExtension()
/*      */   {
/* 1319 */     return this.uploadFlashExtension;
/*      */   }
/*      */ 
/*      */   public void setUploadFlashExtension(String uploadFlashExtension)
/*      */   {
/* 1329 */     if (uploadFlashExtension != null) {
/* 1330 */       uploadFlashExtension = uploadFlashExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
/*      */     }
/* 1332 */     this.uploadFlashExtension = uploadFlashExtension;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getUploadMediaExtension()
/*      */   {
/* 1342 */     return this.uploadMediaExtension;
/*      */   }
/*      */ 
/*      */   public void setUploadMediaExtension(String uploadMediaExtension)
/*      */   {
/* 1352 */     if (uploadMediaExtension != null) {
/* 1353 */       uploadMediaExtension = uploadMediaExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
/*      */     }
/* 1355 */     this.uploadMediaExtension = uploadMediaExtension;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getUploadFileExtension()
/*      */   {
/* 1365 */     return this.uploadFileExtension;
/*      */   }
/*      */ 
/*      */   public void setUploadFileExtension(String uploadFileExtension)
/*      */   {
/* 1375 */     if (uploadFileExtension != null) {
/* 1376 */       uploadFileExtension = uploadFileExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
/*      */     }
/* 1378 */     this.uploadFileExtension = uploadFileExtension;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getImageUploadPath()
/*      */   {
/* 1389 */     return this.imageUploadPath;
/*      */   }
/*      */ 
/*      */   public void setImageUploadPath(String imageUploadPath)
/*      */   {
/* 1399 */     if (imageUploadPath != null) {
/* 1400 */       if (!imageUploadPath.startsWith("/")) {
/* 1401 */         imageUploadPath = "/" + imageUploadPath;
/*      */       }
/* 1403 */       if (!imageUploadPath.endsWith("/")) {
/* 1404 */         imageUploadPath = imageUploadPath + "/";
/*      */       }
/*      */     }
/* 1407 */     this.imageUploadPath = imageUploadPath;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getFlashUploadPath()
/*      */   {
/* 1418 */     return this.flashUploadPath;
/*      */   }
/*      */ 
/*      */   public void setFlashUploadPath(String flashUploadPath)
/*      */   {
/* 1428 */     if (flashUploadPath != null) {
/* 1429 */       if (!flashUploadPath.startsWith("/")) {
/* 1430 */         flashUploadPath = "/" + flashUploadPath;
/*      */       }
/* 1432 */       if (!flashUploadPath.endsWith("/")) {
/* 1433 */         flashUploadPath = flashUploadPath + "/";
/*      */       }
/*      */     }
/* 1436 */     this.flashUploadPath = flashUploadPath;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getMediaUploadPath()
/*      */   {
/* 1447 */     return this.mediaUploadPath;
/*      */   }
/*      */ 
/*      */   public void setMediaUploadPath(String mediaUploadPath)
/*      */   {
/* 1457 */     if (mediaUploadPath != null) {
/* 1458 */       if (!mediaUploadPath.startsWith("/")) {
/* 1459 */         mediaUploadPath = "/" + mediaUploadPath;
/*      */       }
/* 1461 */       if (!mediaUploadPath.endsWith("/")) {
/* 1462 */         mediaUploadPath = mediaUploadPath + "/";
/*      */       }
/*      */     }
/* 1465 */     this.mediaUploadPath = mediaUploadPath;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getFileUploadPath()
/*      */   {
/* 1476 */     return this.fileUploadPath;
/*      */   }
/*      */ 
/*      */   public void setFileUploadPath(String fileUploadPath)
/*      */   {
/* 1486 */     if (fileUploadPath != null) {
/* 1487 */       if (!fileUploadPath.startsWith("/")) {
/* 1488 */         fileUploadPath = "/" + fileUploadPath;
/*      */       }
/* 1490 */       if (!fileUploadPath.endsWith("/")) {
/* 1491 */         fileUploadPath = fileUploadPath + "/";
/*      */       }
/*      */     }
/* 1494 */     this.fileUploadPath = fileUploadPath;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Email
/*      */   @Length(max=200)
/*      */   public String getSmtpFromMail()
/*      */   {
/* 1506 */     return this.smtpFromMail;
/*      */   }
/*      */ 
/*      */   public void setSmtpFromMail(String smtpFromMail)
/*      */   {
/* 1516 */     this.smtpFromMail = smtpFromMail;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getSmtpHost()
/*      */   {
/* 1527 */     return this.smtpHost;
/*      */   }
/*      */ 
/*      */   public void setSmtpHost(String smtpHost)
/*      */   {
/* 1537 */     this.smtpHost = smtpHost;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(0L)
/*      */   public Integer getSmtpPort()
/*      */   {
/* 1548 */     return this.smtpPort;
/*      */   }
/*      */ 
/*      */   public void setSmtpPort(Integer smtpPort)
/*      */   {
/* 1558 */     this.smtpPort = smtpPort;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getSmtpUsername()
/*      */   {
/* 1569 */     return this.smtpUsername;
/*      */   }
/*      */ 
/*      */   public void setSmtpUsername(String smtpUsername)
/*      */   {
/* 1579 */     this.smtpUsername = smtpUsername;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getSmtpPassword()
/*      */   {
/* 1589 */     return this.smtpPassword;
/*      */   }
/*      */ 
/*      */   public void setSmtpPassword(String smtpPassword)
/*      */   {
/* 1599 */     this.smtpPassword = smtpPassword;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getCurrencySign()
/*      */   {
/* 1610 */     return this.currencySign;
/*      */   }
/*      */ 
/*      */   public void setCurrencySign(String currencySign)
/*      */   {
/* 1620 */     this.currencySign = currencySign;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getCurrencyUnit()
/*      */   {
/* 1631 */     return this.currencyUnit;
/*      */   }
/*      */ 
/*      */   public void setCurrencyUnit(String currencyUnit)
/*      */   {
/* 1641 */     this.currencyUnit = currencyUnit;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(0L)
/*      */   public Integer getStockAlertCount()
/*      */   {
/* 1652 */     return this.stockAlertCount;
/*      */   }
/*      */ 
/*      */   public void setStockAlertCount(Integer stockAlertCount)
/*      */   {
/* 1662 */     this.stockAlertCount = stockAlertCount;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public StockAllocationTime getStockAllocationTime()
/*      */   {
/* 1672 */     return this.stockAllocationTime;
/*      */   }
/*      */ 
/*      */   public void setStockAllocationTime(StockAllocationTime stockAllocationTime)
/*      */   {
/* 1682 */     this.stockAllocationTime = stockAllocationTime;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(0L)
/*      */   @Digits(integer=3, fraction=3)
/*      */   public Double getDefaultPointScale()
/*      */   {
/* 1694 */     return this.defaultPointScale;
/*      */   }
/*      */ 
/*      */   public void setDefaultPointScale(Double defaultPointScale)
/*      */   {
/* 1704 */     this.defaultPointScale = defaultPointScale;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsDevelopmentEnabled()
/*      */   {
/* 1714 */     return this.isDevelopmentEnabled;
/*      */   }
/*      */ 
/*      */   public void setIsDevelopmentEnabled(Boolean isDevelopmentEnabled)
/*      */   {
/* 1724 */     this.isDevelopmentEnabled = isDevelopmentEnabled;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsReviewEnabled()
/*      */   {
/* 1734 */     return this.isReviewEnabled;
/*      */   }
/*      */ 
/*      */   public void setIsReviewEnabled(Boolean isReviewEnabled)
/*      */   {
/* 1744 */     this.isReviewEnabled = isReviewEnabled;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsReviewCheck()
/*      */   {
/* 1754 */     return this.isReviewCheck;
/*      */   }
/*      */ 
/*      */   public void setIsReviewCheck(Boolean isReviewCheck)
/*      */   {
/* 1764 */     this.isReviewCheck = isReviewCheck;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public ReviewAuthority getReviewAuthority()
/*      */   {
/* 1774 */     return this.reviewAuthority;
/*      */   }
/*      */ 
/*      */   public void setReviewAuthority(ReviewAuthority reviewAuthority)
/*      */   {
/* 1784 */     this.reviewAuthority = reviewAuthority;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsConsultationEnabled()
/*      */   {
/* 1794 */     return this.isConsultationEnabled;
/*      */   }
/*      */ 
/*      */   public void setIsConsultationEnabled(Boolean isConsultationEnabled)
/*      */   {
/* 1804 */     this.isConsultationEnabled = isConsultationEnabled;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsConsultationCheck()
/*      */   {
/* 1814 */     return this.isConsultationCheck;
/*      */   }
/*      */ 
/*      */   public void setIsConsultationCheck(Boolean isConsultationCheck)
/*      */   {
/* 1824 */     this.isConsultationCheck = isConsultationCheck;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public ConsultationAuthority getConsultationAuthority()
/*      */   {
/* 1834 */     return this.consultationAuthority;
/*      */   }
/*      */ 
/*      */   public void setConsultationAuthority(ConsultationAuthority consultationAuthority)
/*      */   {
/* 1844 */     this.consultationAuthority = consultationAuthority;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsInvoiceEnabled()
/*      */   {
/* 1854 */     return this.isInvoiceEnabled;
/*      */   }
/*      */ 
/*      */   public void setIsInvoiceEnabled(Boolean isInvoiceEnabled)
/*      */   {
/* 1864 */     this.isInvoiceEnabled = isInvoiceEnabled;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   public Boolean getIsTaxPriceEnabled()
/*      */   {
/* 1874 */     return this.isTaxPriceEnabled;
/*      */   }
/*      */ 
/*      */   public void setIsTaxPriceEnabled(Boolean isTaxPriceEnabled)
/*      */   {
/* 1884 */     this.isTaxPriceEnabled = isTaxPriceEnabled;
/*      */   }
/*      */ 
/*      */   @NotNull
/*      */   @Min(0L)
/*      */   @Digits(integer=3, fraction=3)
/*      */   public Double getTaxRate()
/*      */   {
/* 1896 */     return this.taxRate;
/*      */   }
/*      */ 
/*      */   public void setTaxRate(Double taxRate)
/*      */   {
/* 1906 */     this.taxRate = taxRate;
/*      */   }
/*      */ 
/*      */   @NotEmpty
/*      */   @Length(max=200)
/*      */   public String getCookiePath()
/*      */   {
/* 1917 */     return this.cookiePath;
/*      */   }
/*      */ 
/*      */   public void setCookiePath(String cookiePath)
/*      */   {
/* 1927 */     if ((cookiePath != null) && (!cookiePath.endsWith("/"))) {
/* 1928 */       cookiePath = cookiePath + "/";
/*      */     }
/* 1930 */     this.cookiePath = cookiePath;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getCookieDomain()
/*      */   {
/* 1940 */     return this.cookieDomain;
/*      */   }
/*      */ 
/*      */   public void setCookieDomain(String cookieDomain)
/*      */   {
/* 1950 */     this.cookieDomain = cookieDomain;
/*      */   }
/*      */ 
/*      */   @Length(max=200)
/*      */   public String getKuaidi100Key()
/*      */   {
/* 1960 */     return this.kuaidi100Key;
/*      */   }
/*      */ 
/*      */   public void setKuaidi100Key(String kuaidi100Key)
/*      */   {
/* 1970 */     this.kuaidi100Key = kuaidi100Key;
/*      */   }
/*      */ 
/*      */   public Boolean getIsCnzzEnabled()
/*      */   {
/* 1979 */     return this.isCnzzEnabled;
/*      */   }
/*      */ 
/*      */   public void setIsCnzzEnabled(Boolean isCnzzEnabled)
/*      */   {
/* 1989 */     this.isCnzzEnabled = isCnzzEnabled;
/*      */   }
/*      */ 
/*      */   public String getCnzzSiteId()
/*      */   {
/* 1998 */     return this.cnzzSiteId;
/*      */   }
/*      */ 
/*      */   public void setCnzzSiteId(String cnzzSiteId)
/*      */   {
/* 2008 */     this.cnzzSiteId = cnzzSiteId;
/*      */   }
/*      */ 
/*      */   public String getCnzzPassword()
/*      */   {
/* 2017 */     return this.cnzzPassword;
/*      */   }
/*      */ 
/*      */   public void setCnzzPassword(String cnzzPassword)
/*      */   {
/* 2027 */     this.cnzzPassword = cnzzPassword;
/*      */   }
/*      */ 
/*      */   public String[] getHotSearches()
/*      */   {
/* 2036 */     return StringUtils.split(this.hotSearch, ",");
/*      */   }
/*      */ 
/*      */   public String[] getDisabledUsernames()
/*      */   {
/* 2045 */     return StringUtils.split(this.disabledUsername, ",");
/*      */   }
/*      */ 
/*      */   public String[] getUploadImageExtensions()
/*      */   {
/* 2054 */     return StringUtils.split(this.uploadImageExtension, ",");
/*      */   }
/*      */ 
/*      */   public String[] getUploadFlashExtensions()
/*      */   {
/* 2063 */     return StringUtils.split(this.uploadFlashExtension, ",");
/*      */   }
/*      */ 
/*      */   public String[] getUploadMediaExtensions()
/*      */   {
/* 2072 */     return StringUtils.split(this.uploadMediaExtension, ",");
/*      */   }
/*      */ 
/*      */   public String[] getUploadFileExtensions()
/*      */   {
/* 2081 */     return StringUtils.split(this.uploadFileExtension, ",");
/*      */   }
/*      */ 
/*      */   public BigDecimal setScale(BigDecimal amount)
/*      */   {
/* 2092 */     if (amount == null)
/* 2093 */       return null;
/*      */     int roundingMode;
/*      */     int roundingMode;
/* 2096 */     if (getPriceRoundType() == RoundType.roundUp) {
/* 2097 */       roundingMode = 0;
/*      */     }
/*      */     else
/*      */     {
/*      */       int roundingMode;
/* 2098 */       if (getPriceRoundType() == RoundType.roundDown)
/* 2099 */         roundingMode = 1;
/*      */       else
/* 2101 */         roundingMode = 4;
/*      */     }
/* 2103 */     return amount.setScale(getPriceScale().intValue(), roundingMode);
/*      */   }
/*      */ 
/*      */   public static enum AccountLockType
/*      */   {
/*  105 */     member, 
/*      */ 
/*  108 */     admin;
/*      */   }
/*      */ 
/*      */   public static enum CaptchaType
/*      */   {
/*   75 */     memberLogin, 
/*      */ 
/*   78 */     memberRegister, 
/*      */ 
/*   81 */     adminLogin, 
/*      */ 
/*   84 */     review, 
/*      */ 
/*   87 */     consultation, 
/*      */ 
/*   90 */     findPassword, 
/*      */ 
/*   93 */     resetPassword, 
/*      */ 
/*   96 */     other;
/*      */   }
/*      */ 
/*      */   public static enum ConsultationAuthority
/*      */   {
/*  147 */     anyone, 
/*      */ 
/*  150 */     member;
/*      */   }
/*      */ 
/*      */   public static enum ReviewAuthority
/*      */   {
/*  132 */     anyone, 
/*      */ 
/*  135 */     member, 
/*      */ 
/*  138 */     purchased;
/*      */   }
/*      */ 
/*      */   public static enum RoundType
/*      */   {
/*   60 */     roundHalfUp, 
/*      */ 
/*   63 */     roundUp, 
/*      */ 
/*   66 */     roundDown;
/*      */   }
/*      */ 
/*      */   public static enum StockAllocationTime
/*      */   {
/*  117 */     order, 
/*      */ 
/*  120 */     payment, 
/*      */ 
/*  123 */     ship;
/*      */   }
/*      */ 
/*      */   public static enum WatermarkPosition
/*      */   {
/*   36 */     no, 
/*      */ 
/*   39 */     topLeft, 
/*      */ 
/*   42 */     topRight, 
/*      */ 
/*   45 */     center, 
/*      */ 
/*   48 */     bottomLeft, 
/*      */ 
/*   51 */     bottomRight;
/*      */   }
/*      */ }

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.Setting
 * JD-Core Version:    0.6.2
 */