package net.shopxx.plugin.oss;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.ListObjectsRequest;
import com.aliyun.openservices.oss.model.OSSObjectSummary;
import com.aliyun.openservices.oss.model.ObjectListing;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.shopxx.FileInfo;
import net.shopxx.entity.PluginConfig;
import net.shopxx.plugin.StoragePlugin;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component("ossPlugin")
public class OssPlugin extends StoragePlugin
{
  public String getName()
  {
    return "阿里云存储";
  }

  public String getVersion()
  {
    return "1.0";
  }

  public String getAuthor()
  {
    return "SHOP++";
  }

  public String getSiteUrl()
  {
    return "http://www.shopxx.net";
  }

  public String getInstallUrl()
  {
    return "oss/install.jhtml";
  }

  public String getUninstallUrl()
  {
    return "oss/uninstall.jhtml";
  }

  public String getSettingUrl()
  {
    return "oss/setting.jhtml";
  }

  public void upload(String path, File file, String contentType)
  {
    PluginConfig localPluginConfig = getPluginConfig();
    if (localPluginConfig != null)
    {
      String str1 = localPluginConfig.getAttribute("accessId");
      String str2 = localPluginConfig.getAttribute("accessKey");
      String str3 = localPluginConfig.getAttribute("bucketName");
      FileInputStream localFileInputStream = null;
      try
      {
        localFileInputStream = new FileInputStream(file);
        OSSClient localOSSClient = new OSSClient(str1, str2);
        ObjectMetadata localObjectMetadata = new ObjectMetadata();
        localObjectMetadata.setContentType(contentType);
        localObjectMetadata.setContentLength(file.length());
        localOSSClient.putObject(str3, StringUtils.removeStart(path, "/"), localFileInputStream, localObjectMetadata);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      finally
      {
        IOUtils.closeQuietly(localFileInputStream);
      }
    }
  }

  public String getUrl(String path)
  {
    PluginConfig localPluginConfig = getPluginConfig();
    if (localPluginConfig != null)
    {
      String str = localPluginConfig.getAttribute("urlPrefix");
      return str + path;
    }
    return null;
  }

  public List<FileInfo> browser(String path)
  {
    ArrayList localArrayList = new ArrayList();
    PluginConfig localPluginConfig = getPluginConfig();
    if (localPluginConfig != null)
    {
      String str1 = localPluginConfig.getAttribute("accessId");
      String str2 = localPluginConfig.getAttribute("accessKey");
      String str3 = localPluginConfig.getAttribute("bucketName");
      String str4 = localPluginConfig.getAttribute("urlPrefix");
      try
      {
        OSSClient localOSSClient = new OSSClient(str1, str2);
        ListObjectsRequest localListObjectsRequest = new ListObjectsRequest(str3);
        localListObjectsRequest.setPrefix(StringUtils.removeStart(path, "/"));
        localListObjectsRequest.setDelimiter("/");
        ObjectListing localObjectListing = localOSSClient.listObjects(localListObjectsRequest);
        Iterator localIterator = localObjectListing.getCommonPrefixes().iterator();
        Object localObject;
        FileInfo localFileInfo;
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          localFileInfo = new FileInfo();
          localFileInfo.setName(StringUtils.substringAfterLast(StringUtils.removeEnd((String)localObject, "/"), "/"));
          localFileInfo.setUrl(str4 + "/" + (String)localObject);
          localFileInfo.setIsDirectory(Boolean.valueOf(true));
          localFileInfo.setSize(Long.valueOf(0L));
          localArrayList.add(localFileInfo);
        }
        localIterator = localObjectListing.getObjectSummaries().iterator();
        while (localIterator.hasNext())
        {
          localObject = (OSSObjectSummary)localIterator.next();
          if (!((OSSObjectSummary)localObject).getKey().endsWith("/"))
          {
            localFileInfo = new FileInfo();
            localFileInfo.setName(StringUtils.substringAfterLast(((OSSObjectSummary)localObject).getKey(), "/"));
            localFileInfo.setUrl(str4 + "/" + ((OSSObjectSummary)localObject).getKey());
            localFileInfo.setIsDirectory(Boolean.valueOf(false));
            localFileInfo.setSize(Long.valueOf(((OSSObjectSummary)localObject).getSize()));
            localFileInfo.setLastModified(((OSSObjectSummary)localObject).getLastModified());
            localArrayList.add(localFileInfo);
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    return localArrayList;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.plugin.oss.OssPlugin
 * JD-Core Version:    0.6.2
 */