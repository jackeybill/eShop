package net.shopxx.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.shopxx.LogConfig;
import net.shopxx.service.LogConfigService;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service("logConfigServiceImpl")
public class LogConfigServiceImpl
  implements LogConfigService
{
  @Cacheable({"logConfig"})
  public List<LogConfig> getAll()
  {
    try
    {
      File localFile = new ClassPathResource("/shopxx.xml").getFile();
      Document localDocument = new SAXReader().read(localFile);
      List localList = localDocument.selectNodes("/shopxx/logConfig");
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Element localElement = (Element)localIterator.next();
        String str1 = localElement.attributeValue("operation");
        String str2 = localElement.attributeValue("urlPattern");
        LogConfig localLogConfig = new LogConfig();
        localLogConfig.setOperation(str1);
        localLogConfig.setUrlPattern(str2);
        localArrayList.add(localLogConfig);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.LogConfigServiceImpl
 * JD-Core Version:    0.6.2
 */