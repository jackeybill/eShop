package net.shopxx.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.shopxx.CommonAttributes;
import net.shopxx.Setting;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.io.IOUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.core.io.ClassPathResource;

public final class SettingUtils
{
  private static final CacheManager IIIllIlI = CacheManager.create();
  private static final BeanUtilsBean IIIllIll = new BeanUtilsBean(local1);

  static
  {
    SettingUtils.1 local1 = new SettingUtils.1();
    DateConverter localDateConverter = new DateConverter();
    localDateConverter.setPatterns(CommonAttributes.DATE_PATTERNS);
    local1.register(localDateConverter, Date.class);
  }

  public static Setting get()
  {
    Ehcache localEhcache = IIIllIlI.getEhcache("setting");
    net.sf.ehcache.Element localElement = localEhcache.get(Setting.CACHE_KEY);
    Setting localSetting;
    if (localElement != null)
    {
      localSetting = (Setting)localElement.getObjectValue();
    }
    else
    {
      localSetting = new Setting();
      try
      {
        File localFile = new ClassPathResource("/shopxx.xml").getFile();
        Document localDocument = new SAXReader().read(localFile);
        List localList = localDocument.selectNodes("/shopxx/setting");
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          org.dom4j.Element localElement1 = (org.dom4j.Element)localIterator.next();
          String str1 = localElement1.attributeValue("name");
          String str2 = localElement1.attributeValue("value");
          try
          {
            IIIllIll.setProperty(localSetting, str1, str2);
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            localInvocationTargetException.printStackTrace();
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localEhcache.put(new net.sf.ehcache.Element(Setting.CACHE_KEY, localSetting));
    }
    return localSetting;
  }

  public static void set(Setting setting)
  {
    try
    {
      File localFile = new ClassPathResource("/shopxx.xml").getFile();
      Document localDocument = new SAXReader().read(localFile);
      List localList = localDocument.selectNodes("/shopxx/setting");
      Object localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (org.dom4j.Element)((Iterator)localObject2).next();
        try
        {
          String str1 = ((org.dom4j.Element)localObject1).attributeValue("name");
          String str2 = IIIllIll.getProperty(setting, str1);
          Attribute localAttribute = ((org.dom4j.Element)localObject1).attribute("value");
          localAttribute.setValue(str2);
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
      Object localObject1 = null;
      localObject2 = null;
      try
      {
        OutputFormat localOutputFormat = OutputFormat.createPrettyPrint();
        localOutputFormat.setEncoding("UTF-8");
        localOutputFormat.setIndent(true);
        localOutputFormat.setIndent("\t");
        localOutputFormat.setNewlines(true);
        localObject1 = new FileOutputStream(localFile);
        localObject2 = new XMLWriter((OutputStream)localObject1, localOutputFormat);
        ((XMLWriter)localObject2).write(localDocument);
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
      }
      finally
      {
        if (localObject2 != null)
          try
          {
            ((XMLWriter)localObject2).close();
          }
          catch (IOException localIOException4)
          {
          }
        IOUtils.closeQuietly((OutputStream)localObject1);
      }
      Ehcache localEhcache = IIIllIlI.getEhcache("setting");
      localEhcache.put(new net.sf.ehcache.Element(Setting.CACHE_KEY, setting));
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.util.SettingUtils
 * JD-Core Version:    0.6.2
 */