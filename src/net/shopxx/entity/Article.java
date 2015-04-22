package net.shopxx.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.shopxx.util.FreemarkerUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.io.SAXReader;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.springframework.core.io.ClassPathResource;
import org.wltea.analyzer.lucene.IKAnalyzer;

@Indexed
@Entity
@Table(name="xx_article")
public class Article extends BaseEntity
{
  private static final long serialVersionUID = 1475773294701585482L;
  public static final String HITS_CACHE_NAME = "articleHits";
  public static final int HITS_CACHE_INTERVAL = 600000;
  private static final int IIIllIlI = 800;
  private static final String IIIllIll = "<hr class=\"pageBreak\" />";
  private static final Pattern IIIlllII = Pattern.compile("[,;\\.!?，；。！？]");
  private static String IIIlllIl;
  private String IIIllllI;
  private String IIIlllll;
  private String IIlIIIII;
  private String IIlIIIIl;
  private String IIlIIIlI;
  private String IIlIIIll;
  private Boolean IIlIIlII;
  private Boolean IIlIIlIl;
  private Long IIlIIllI;
  private Integer IIlIIlll;
  private ArticleCategory IIlIlIII;
  private Set<Tag> IIlIlIIl = new HashSet();

  static
  {
    try
    {
      File localFile = new ClassPathResource("/shopxx.xml").getFile();
      org.dom4j.Document localDocument = new SAXReader().read(localFile);
      org.dom4j.Element localElement = (org.dom4j.Element)localDocument.selectSingleNode("/shopxx/template[@id='articleContent']");
      IIIlllIl = localElement.attributeValue("staticPath");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  @Field(store=Store.YES, index=Index.TOKENIZED, analyzer=@Analyzer(impl=IKAnalyzer.class))
  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getTitle()
  {
    return this.IIIllllI;
  }

  public void setTitle(String title)
  {
    this.IIIllllI = title;
  }

  @Field(store=Store.YES, index=Index.NO)
  @Length(max=200)
  public String getAuthor()
  {
    return this.IIIlllll;
  }

  public void setAuthor(String author)
  {
    this.IIIlllll = author;
  }

  @Field(store=Store.YES, index=Index.TOKENIZED, analyzer=@Analyzer(impl=IKAnalyzer.class))
  @Lob
  public String getContent()
  {
    if (this.IIlIIlll != null)
    {
      String[] arrayOfString = getPageContents();
      if (this.IIlIIlll.intValue() < 1)
        this.IIlIIlll = Integer.valueOf(1);
      if (this.IIlIIlll.intValue() > arrayOfString.length)
        this.IIlIIlll = Integer.valueOf(arrayOfString.length);
      return arrayOfString[(this.IIlIIlll.intValue() - 1)];
    }
    return this.IIlIIIII;
  }

  public void setContent(String content)
  {
    this.IIlIIIII = content;
  }

  @Length(max=200)
  public String getSeoTitle()
  {
    return this.IIlIIIIl;
  }

  public void setSeoTitle(String seoTitle)
  {
    this.IIlIIIIl = seoTitle;
  }

  @Length(max=200)
  public String getSeoKeywords()
  {
    return this.IIlIIIlI;
  }

  public void setSeoKeywords(String seoKeywords)
  {
    if (seoKeywords != null)
      seoKeywords = seoKeywords.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "");
    this.IIlIIIlI = seoKeywords;
  }

  @Length(max=200)
  public String getSeoDescription()
  {
    return this.IIlIIIll;
  }

  public void setSeoDescription(String seoDescription)
  {
    this.IIlIIIll = seoDescription;
  }

  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @NotNull
  @Column(nullable=false)
  public Boolean getIsPublication()
  {
    return this.IIlIIlII;
  }

  public void setIsPublication(Boolean isPublication)
  {
    this.IIlIIlII = isPublication;
  }

  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @NotNull
  @Column(nullable=false)
  public Boolean getIsTop()
  {
    return this.IIlIIlIl;
  }

  public void setIsTop(Boolean isTop)
  {
    this.IIlIIlIl = isTop;
  }

  @Column(nullable=false)
  public Long getHits()
  {
    return this.IIlIIllI;
  }

  public void setHits(Long hits)
  {
    this.IIlIIllI = hits;
  }

  @Transient
  public Integer getPageNumber()
  {
    return this.IIlIIlll;
  }

  @Transient
  public void setPageNumber(Integer pageNumber)
  {
    this.IIlIIlll = pageNumber;
  }

  @NotNull
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false)
  public ArticleCategory getArticleCategory()
  {
    return this.IIlIlIII;
  }

  public void setArticleCategory(ArticleCategory articleCategory)
  {
    this.IIlIlIII = articleCategory;
  }

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="xx_article_tag")
  @OrderBy("order asc")
  public Set<Tag> getTags()
  {
    return this.IIlIlIIl;
  }

  public void setTags(Set<Tag> tags)
  {
    this.IIlIlIIl = tags;
  }

  @Transient
  public String getPath()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", getId());
    localHashMap.put("createDate", getCreateDate());
    localHashMap.put("modifyDate", getModifyDate());
    localHashMap.put("title", getTitle());
    localHashMap.put("seoTitle", getSeoTitle());
    localHashMap.put("seoKeywords", getSeoKeywords());
    localHashMap.put("seoDescription", getSeoDescription());
    localHashMap.put("pageNumber", getPageNumber());
    localHashMap.put("articleCategory", getArticleCategory());
    return FreemarkerUtils.process(IIIlllIl, localHashMap);
  }

  @Transient
  public String getText()
  {
    if (getContent() != null)
      return Jsoup.parse(getContent()).text();
    return null;
  }

  @Transient
  public String[] getPageContents()
  {
    if (StringUtils.isEmpty(this.IIlIIIII))
      return new String[] { "" };
    if (this.IIlIIIII.contains("<hr class=\"pageBreak\" />"))
      return this.IIlIIIII.split("<hr class=\"pageBreak\" />");
    ArrayList localArrayList = new ArrayList();
    org.jsoup.nodes.Document localDocument = Jsoup.parse(this.IIlIIIII);
    List localList = localDocument.body().childNodes();
    if (localList != null)
    {
      int i = 0;
      StringBuffer localStringBuffer = new StringBuffer();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Node)localIterator.next();
        Object localObject2;
        if ((localObject1 instanceof org.jsoup.nodes.Element))
        {
          localObject2 = (org.jsoup.nodes.Element)localObject1;
          localStringBuffer.append(((org.jsoup.nodes.Element)localObject2).outerHtml());
          i += ((org.jsoup.nodes.Element)localObject2).text().length();
          if (i >= 800)
          {
            localArrayList.add(localStringBuffer.toString());
            i = 0;
            localStringBuffer.setLength(0);
          }
        }
        else if ((localObject1 instanceof TextNode))
        {
          localObject2 = (TextNode)localObject1;
          String str1 = ((TextNode)localObject2).text();
          String[] arrayOfString1 = IIIlllII.split(str1);
          Matcher localMatcher = IIIlllII.matcher(str1);
          for (String str2 : arrayOfString1)
          {
            if (localMatcher.find())
              str2 = str2 + localMatcher.group();
            localStringBuffer.append(str2);
            i += str2.length();
            if (i >= 800)
            {
              localArrayList.add(localStringBuffer.toString());
              i = 0;
              localStringBuffer.setLength(0);
            }
          }
        }
      }
      Object localObject1 = localStringBuffer.toString();
      if (StringUtils.isNotEmpty((String)localObject1))
        localArrayList.add(localObject1);
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  @Transient
  public int getTotalPages()
  {
    return getPageContents().length;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Article
 * JD-Core Version:    0.6.2
 */