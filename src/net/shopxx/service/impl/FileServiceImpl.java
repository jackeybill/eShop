package net.shopxx.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import net.shopxx.FileInfo;
import net.shopxx.FileInfo.FileType;
import net.shopxx.FileInfo.OrderType;
import net.shopxx.Setting;
import net.shopxx.plugin.StoragePlugin;
import net.shopxx.service.FileService;
import net.shopxx.service.PluginService;
import net.shopxx.util.FreemarkerUtils;
import net.shopxx.util.SettingUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

@Service("fileServiceImpl")
public class FileServiceImpl
  implements FileService, ServletContextAware
{
  private ServletContext IIIllIlI;

  @Resource(name="taskExecutor")
  private TaskExecutor IIIllIll;

  @Resource(name="pluginServiceImpl")
  private PluginService IIIlllII;

  public void setServletContext(ServletContext servletContext)
  {
    this.IIIllIlI = servletContext;
  }

  private void IIIllIlI(StoragePlugin paramStoragePlugin, String paramString1, File paramFile, String paramString2)
  {
    this.IIIllIll.execute(new FileServiceImpl.1(this, paramFile, paramStoragePlugin, paramString1, paramString2));
  }

  public boolean isValid(FileInfo.FileType fileType, MultipartFile multipartFile)
  {
    if (multipartFile == null)
      return false;
    Setting localSetting = SettingUtils.get();
    if ((localSetting.getUploadMaxSize() != null) && (localSetting.getUploadMaxSize().intValue() != 0) && (multipartFile.getSize() > localSetting.getUploadMaxSize().intValue() * 1024L * 1024L))
      return false;
    String[] arrayOfString;
    if (fileType == FileInfo.FileType.flash)
      arrayOfString = localSetting.getUploadFlashExtensions();
    else if (fileType == FileInfo.FileType.media)
      arrayOfString = localSetting.getUploadMediaExtensions();
    else if (fileType == FileInfo.FileType.file)
      arrayOfString = localSetting.getUploadFileExtensions();
    else
      arrayOfString = localSetting.getUploadImageExtensions();
    if (ArrayUtils.isNotEmpty(arrayOfString))
      return FilenameUtils.isExtension(multipartFile.getOriginalFilename(), arrayOfString);
    return false;
  }

  public String upload(FileInfo.FileType fileType, MultipartFile multipartFile, boolean async)
  {
    if (multipartFile == null)
      return null;
    Setting localSetting = SettingUtils.get();
    String str1;
    if (fileType == FileInfo.FileType.flash)
      str1 = localSetting.getFlashUploadPath();
    else if (fileType == FileInfo.FileType.media)
      str1 = localSetting.getMediaUploadPath();
    else if (fileType == FileInfo.FileType.file)
      str1 = localSetting.getFileUploadPath();
    else
      str1 = localSetting.getImageUploadPath();
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uuid", UUID.randomUUID().toString());
      String str2 = FreemarkerUtils.process(str1, localHashMap);
      String str3 = str2 + UUID.randomUUID() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
      Iterator localIterator = this.IIIlllII.getStoragePlugins(true).iterator();
      if (localIterator.hasNext())
      {
        StoragePlugin localStoragePlugin = (StoragePlugin)localIterator.next();
        File localFile = new File(System.getProperty("java.io.tmpdir") + "/upload_" + UUID.randomUUID() + ".tmp");
        if (!localFile.getParentFile().exists())
          localFile.getParentFile().mkdirs();
        multipartFile.transferTo(localFile);
        if (async)
          IIIllIlI(localStoragePlugin, str3, localFile, multipartFile.getContentType());
        else
          try
          {
            localStoragePlugin.upload(str3, localFile, multipartFile.getContentType());
          }
          finally
          {
            FileUtils.deleteQuietly(localFile);
          }
        return localStoragePlugin.getUrl(str3);
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    return null;
  }

  public String upload(FileInfo.FileType fileType, MultipartFile multipartFile)
  {
    return upload(fileType, multipartFile, false);
  }

  public String uploadLocal(FileInfo.FileType fileType, MultipartFile multipartFile)
  {
    if (multipartFile == null)
      return null;
    Setting localSetting = SettingUtils.get();
    String str1;
    if (fileType == FileInfo.FileType.flash)
      str1 = localSetting.getFlashUploadPath();
    else if (fileType == FileInfo.FileType.media)
      str1 = localSetting.getMediaUploadPath();
    else if (fileType == FileInfo.FileType.file)
      str1 = localSetting.getFileUploadPath();
    else
      str1 = localSetting.getImageUploadPath();
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uuid", UUID.randomUUID().toString());
      String str2 = FreemarkerUtils.process(str1, localHashMap);
      String str3 = str2 + UUID.randomUUID() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
      File localFile = new File(this.IIIllIlI.getRealPath(str3));
      if (!localFile.getParentFile().exists())
        localFile.getParentFile().mkdirs();
      multipartFile.transferTo(localFile);
      return str3;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    return null;
  }

  public List<FileInfo> browser(String path, FileInfo.FileType fileType, FileInfo.OrderType orderType)
  {
    if (path != null)
    {
      if (!path.startsWith("/"))
        path = "/" + path;
      if (!path.endsWith("/"))
        path = path + "/";
    }
    else
    {
      path = "/";
    }
    Setting localSetting = SettingUtils.get();
    String str1;
    if (fileType == FileInfo.FileType.flash)
      str1 = localSetting.getFlashUploadPath();
    else if (fileType == FileInfo.FileType.media)
      str1 = localSetting.getMediaUploadPath();
    else if (fileType == FileInfo.FileType.file)
      str1 = localSetting.getFileUploadPath();
    else
      str1 = localSetting.getImageUploadPath();
    String str2 = StringUtils.substringBefore(str1, "${");
    str2 = StringUtils.substringBeforeLast(str2, "/") + path;
    Object localObject = new ArrayList();
    if (str2.indexOf("..") >= 0)
      return localObject;
    Iterator localIterator = this.IIIlllII.getStoragePlugins(true).iterator();
    if (localIterator.hasNext())
    {
      StoragePlugin localStoragePlugin = (StoragePlugin)localIterator.next();
      localObject = localStoragePlugin.browser(str2);
    }
    if (orderType == FileInfo.OrderType.size)
      Collections.sort((List)localObject, new FileServiceImpl.SizeComparator(this, null));
    else if (orderType == FileInfo.OrderType.type)
      Collections.sort((List)localObject, new FileServiceImpl.TypeComparator(this, null));
    else
      Collections.sort((List)localObject, new FileServiceImpl.NameComparator(this, null));
    return localObject;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.FileServiceImpl
 * JD-Core Version:    0.6.2
 */