package net.shopxx.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_article_category")
public class ArticleCategory extends OrderEntity
{
  private static final long serialVersionUID = -5132652107151648662L;
  public static final String TREE_PATH_SEPARATOR = ",";
  private static final String IIIllIlI = "/article/list";
  private static final String IIIllIll = ".jhtml";
  private String IIIlllII;
  private String IIIlllIl;
  private String IIIllllI;
  private String IIIlllll;
  private String IIlIIIII;
  private Integer IIlIIIIl;
  private ArticleCategory IIlIIIlI;
  private Set<ArticleCategory> IIlIIIll = new HashSet();
  private Set<Article> IIlIIlII = new HashSet();

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

  @Length(max=200)
  public String getSeoTitle()
  {
    return this.IIIlllIl;
  }

  public void setSeoTitle(String seoTitle)
  {
    this.IIIlllIl = seoTitle;
  }

  @Length(max=200)
  public String getSeoKeywords()
  {
    return this.IIIllllI;
  }

  public void setSeoKeywords(String seoKeywords)
  {
    this.IIIllllI = seoKeywords;
  }

  @Length(max=200)
  public String getSeoDescription()
  {
    return this.IIIlllll;
  }

  public void setSeoDescription(String seoDescription)
  {
    this.IIIlllll = seoDescription;
  }

  @Column(nullable=false)
  public String getTreePath()
  {
    return this.IIlIIIII;
  }

  public void setTreePath(String treePath)
  {
    this.IIlIIIII = treePath;
  }

  @Column(nullable=false)
  public Integer getGrade()
  {
    return this.IIlIIIIl;
  }

  public void setGrade(Integer grade)
  {
    this.IIlIIIIl = grade;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  public ArticleCategory getParent()
  {
    return this.IIlIIIlI;
  }

  public void setParent(ArticleCategory parent)
  {
    this.IIlIIIlI = parent;
  }

  @OneToMany(mappedBy="parent", fetch=FetchType.LAZY)
  @OrderBy("order asc")
  public Set<ArticleCategory> getChildren()
  {
    return this.IIlIIIll;
  }

  public void setChildren(Set<ArticleCategory> children)
  {
    this.IIlIIIll = children;
  }

  @OneToMany(mappedBy="articleCategory", fetch=FetchType.LAZY)
  public Set<Article> getArticles()
  {
    return this.IIlIIlII;
  }

  public void setArticles(Set<Article> articles)
  {
    this.IIlIIlII = articles;
  }

  @Transient
  public List<Long> getTreePaths()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = StringUtils.split(getTreePath(), ",");
    if (arrayOfString1 != null)
      for (String str : arrayOfString1)
        localArrayList.add(Long.valueOf(str));
    return localArrayList;
  }

  @Transient
  public String getPath()
  {
    if (getId() != null)
      return "/article/list/" + getId() + ".jhtml";
    return null;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.ArticleCategory
 * JD-Core Version:    0.6.2
 */