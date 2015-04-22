package net.shopxx.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Embeddable
public class ProductImage
  implements Serializable, Comparable<ProductImage>
{
  private static final long serialVersionUID = -673883300094536107L;
  private String IIIllIlI;
  private String IIIllIll;
  private String IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;
  private Integer IIIlllll;
  private MultipartFile IIlIIIII;

  @Length(max=200)
  public String getTitle()
  {
    return this.IIIllIlI;
  }

  public void setTitle(String title)
  {
    this.IIIllIlI = title;
  }

  public String getSource()
  {
    return this.IIIllIll;
  }

  public void setSource(String source)
  {
    this.IIIllIll = source;
  }

  public String getLarge()
  {
    return this.IIIlllII;
  }

  public void setLarge(String large)
  {
    this.IIIlllII = large;
  }

  public String getMedium()
  {
    return this.IIIlllIl;
  }

  public void setMedium(String medium)
  {
    this.IIIlllIl = medium;
  }

  public String getThumbnail()
  {
    return this.IIIllllI;
  }

  public void setThumbnail(String thumbnail)
  {
    this.IIIllllI = thumbnail;
  }

  @Min(0L)
  @Column(name="orders")
  public Integer getOrder()
  {
    return this.IIIlllll;
  }

  public void setOrder(Integer order)
  {
    this.IIIlllll = order;
  }

  @Transient
  public MultipartFile getFile()
  {
    return this.IIlIIIII;
  }

  public void setFile(MultipartFile file)
  {
    this.IIlIIIII = file;
  }

  @Transient
  public boolean isEmpty()
  {
    return ((getFile() == null) || (getFile().isEmpty())) && ((StringUtils.isEmpty(getSource())) || (StringUtils.isEmpty(getLarge())) || (StringUtils.isEmpty(getMedium())) || (StringUtils.isEmpty(getThumbnail())));
  }

  public int compareTo(ProductImage productImage)
  {
    return new CompareToBuilder().append(getOrder(), productImage.getOrder()).toComparison();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.ProductImage
 * JD-Core Version:    0.6.2
 */