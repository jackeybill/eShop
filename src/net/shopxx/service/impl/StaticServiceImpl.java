package net.shopxx.service.impl;

import freemarker.template.Configuration;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import net.shopxx.Filter;
import net.shopxx.dao.ArticleDao;
import net.shopxx.dao.BrandDao;
import net.shopxx.dao.ProductDao;
import net.shopxx.dao.PromotionDao;
import net.shopxx.entity.Article;
import net.shopxx.entity.Product;
import net.shopxx.service.StaticService;
import net.shopxx.service.TemplateService;
import net.shopxx.util.FreemarkerUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Service("staticServiceImpl")
public class StaticServiceImpl
  implements StaticService, ServletContextAware
{
  private static final Integer IIIllIlI = Integer.valueOf(40000);
  private ServletContext IIIllIll;

  @Resource(name="freeMarkerConfigurer")
  private FreeMarkerConfigurer IIIlllII;

  @Resource(name="templateServiceImpl")
  private TemplateService IIIlllIl;

  @Resource(name="articleDaoImpl")
  private ArticleDao IIIllllI;

  @Resource(name="productDaoImpl")
  private ProductDao IIIlllll;

  @Resource(name="brandDaoImpl")
  private BrandDao IIlIIIII;

  @Resource(name="promotionDaoImpl")
  private PromotionDao IIlIIIIl;

  public void setServletContext(ServletContext servletContext)
  {
    this.IIIllIll = servletContext;
  }

  @Transactional(readOnly=true)
  public int build(String templatePath, String staticPath, Map<String, Object> model)
  {
    Assert.hasText(templatePath);
    Assert.hasText(staticPath);
    FileOutputStream localFileOutputStream = null;
    OutputStreamWriter localOutputStreamWriter = null;
    BufferedWriter localBufferedWriter = null;
    try
    {
      freemarker.template.Template localTemplate = this.IIIlllII.getConfiguration().getTemplate(templatePath);
      File localFile1 = new File(this.IIIllIll.getRealPath(staticPath));
      File localFile2 = localFile1.getParentFile();
      if (!localFile2.exists())
        localFile2.mkdirs();
      localFileOutputStream = new FileOutputStream(localFile1);
      localOutputStreamWriter = new OutputStreamWriter(localFileOutputStream, "UTF-8");
      localBufferedWriter = new BufferedWriter(localOutputStreamWriter);
      localTemplate.process(model, localBufferedWriter);
      localBufferedWriter.flush();
      return 1;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    finally
    {
      IOUtils.closeQuietly(localBufferedWriter);
      IOUtils.closeQuietly(localOutputStreamWriter);
      IOUtils.closeQuietly(localFileOutputStream);
    }
    return 0;
  }

  @Transactional(readOnly=true)
  public int build(String templatePath, String staticPath)
  {
    return build(templatePath, staticPath, null);
  }

  @Transactional(readOnly=true)
  public int build(Article article)
  {
    Assert.notNull(article);
    delete(article);
    net.shopxx.Template localTemplate = this.IIIlllIl.get("articleContent");
    int i = 0;
    if (article.getIsPublication().booleanValue())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("article", article);
      for (int j = 1; j <= article.getTotalPages(); j++)
      {
        article.setPageNumber(Integer.valueOf(j));
        i += build(localTemplate.getTemplatePath(), article.getPath(), localHashMap);
      }
      article.setPageNumber(null);
    }
    return i;
  }

  @Transactional(readOnly=true)
  public int build(Product product)
  {
    Assert.notNull(product);
    delete(product);
    net.shopxx.Template localTemplate = this.IIIlllIl.get("productContent");
    int i = 0;
    if (product.getIsMarketable().booleanValue())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("product", product);
      i += build(localTemplate.getTemplatePath(), product.getPath(), localHashMap);
    }
    return i;
  }

  @Transactional(readOnly=true)
  public int buildIndex()
  {
    net.shopxx.Template localTemplate = this.IIIlllIl.get("index");
    return build(localTemplate.getTemplatePath(), localTemplate.getStaticPath());
  }

  @Transactional(readOnly=true)
  public int buildSitemap()
  {
    int i = 0;
    net.shopxx.Template localTemplate1 = this.IIIlllIl.get("sitemapIndex");
    net.shopxx.Template localTemplate2 = this.IIIlllIl.get("sitemap");
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = 0;
    int m = 0;
    int n = IIIllIlI.intValue();
    while (true)
      try
      {
        localHashMap.put("index", Integer.valueOf(k));
        String str1 = localTemplate2.getTemplatePath();
        String str2 = FreemarkerUtils.process(localTemplate2.getStaticPath(), localHashMap);
        List localList;
        if (j == 0)
        {
          localList = this.IIIllllI.findList(Integer.valueOf(m), Integer.valueOf(n), null, null);
          localHashMap.put("articles", localList);
          if (localList.size() < n)
          {
            j++;
            m = 0;
            n -= localList.size();
          }
          else
          {
            i += build(str1, str2, localHashMap);
            this.IIIllllI.clear();
            this.IIIllllI.flush();
            localArrayList.add(str2);
            localHashMap.clear();
            k++;
            m += localList.size();
            n = IIIllIlI.intValue();
          }
        }
        else if (j == 1)
        {
          localList = this.IIIlllll.findList(Integer.valueOf(m), Integer.valueOf(n), null, null);
          localHashMap.put("products", localList);
          if (localList.size() < n)
          {
            j++;
            m = 0;
            n -= localList.size();
          }
          else
          {
            i += build(str1, str2, localHashMap);
            this.IIIlllll.clear();
            this.IIIlllll.flush();
            localArrayList.add(str2);
            localHashMap.clear();
            k++;
            m += localList.size();
            n = IIIllIlI.intValue();
          }
        }
        else if (j == 2)
        {
          localList = this.IIlIIIII.findList(Integer.valueOf(m), Integer.valueOf(n), null, null);
          localHashMap.put("brands", localList);
          if (localList.size() < n)
          {
            j++;
            m = 0;
            n -= localList.size();
          }
          else
          {
            i += build(str1, str2, localHashMap);
            this.IIlIIIII.clear();
            this.IIlIIIII.flush();
            localArrayList.add(str2);
            localHashMap.clear();
            k++;
            m += localList.size();
            n = IIIllIlI.intValue();
          }
        }
        else if (j == 3)
        {
          localList = this.IIlIIIIl.findList(Integer.valueOf(m), Integer.valueOf(n), null, null);
          localHashMap.put("promotions", localList);
          i += build(str1, str2, localHashMap);
          this.IIlIIIIl.clear();
          this.IIlIIIIl.flush();
          localArrayList.add(str2);
          if (localList.size() < n)
          {
            localHashMap.put("staticPaths", localArrayList);
            i += build(localTemplate1.getTemplatePath(), localTemplate1.getStaticPath(), localHashMap);
            break;
          }
          localHashMap.clear();
          k++;
          m += localList.size();
          n = IIIllIlI.intValue();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    return i;
  }

  @Transactional(readOnly=true)
  public int buildOther()
  {
    int i = 0;
    net.shopxx.Template localTemplate1 = this.IIIlllIl.get("shopCommonJs");
    net.shopxx.Template localTemplate2 = this.IIIlllIl.get("adminCommonJs");
    i += build(localTemplate1.getTemplatePath(), localTemplate1.getStaticPath());
    i += build(localTemplate2.getTemplatePath(), localTemplate2.getStaticPath());
    return i;
  }

  @Transactional(readOnly=true)
  public int buildAll()
  {
    int i = 0;
    List localList;
    Iterator localIterator;
    Object localObject;
    for (int j = 0; j < this.IIIllllI.count(new Filter[0]); j += 20)
    {
      localList = this.IIIllllI.findList(Integer.valueOf(j), Integer.valueOf(20), null, null);
      localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (Article)localIterator.next();
        i += build((Article)localObject);
      }
      this.IIIllllI.clear();
    }
    for (j = 0; j < this.IIIlllll.count(new Filter[0]); j += 20)
    {
      localList = this.IIIlllll.findList(Integer.valueOf(j), Integer.valueOf(20), null, null);
      localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (Product)localIterator.next();
        i += build((Product)localObject);
      }
      this.IIIlllll.clear();
    }
    buildIndex();
    buildSitemap();
    buildOther();
    return i;
  }

  @Transactional(readOnly=true)
  public int delete(String staticPath)
  {
    Assert.hasText(staticPath);
    File localFile = new File(this.IIIllIll.getRealPath(staticPath));
    if (localFile.exists())
    {
      localFile.delete();
      return 1;
    }
    return 0;
  }

  @Transactional(readOnly=true)
  public int delete(Article article)
  {
    Assert.notNull(article);
    int i = 0;
    for (int j = 1; j <= article.getTotalPages() + 1000; j++)
    {
      article.setPageNumber(Integer.valueOf(j));
      int k = delete(article.getPath());
      if (k < 1)
        break;
      i += k;
    }
    article.setPageNumber(null);
    return i;
  }

  @Transactional(readOnly=true)
  public int delete(Product product)
  {
    Assert.notNull(product);
    return delete(product.getPath());
  }

  @Transactional(readOnly=true)
  public int deleteIndex()
  {
    net.shopxx.Template localTemplate = this.IIIlllIl.get("index");
    return delete(localTemplate.getStaticPath());
  }

  @Transactional(readOnly=true)
  public int deleteOther()
  {
    int i = 0;
    net.shopxx.Template localTemplate1 = this.IIIlllIl.get("shopCommonJs");
    net.shopxx.Template localTemplate2 = this.IIIlllIl.get("adminCommonJs");
    i += delete(localTemplate1.getStaticPath());
    i += delete(localTemplate2.getStaticPath());
    return i;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.StaticServiceImpl
 * JD-Core Version:    0.6.2
 */