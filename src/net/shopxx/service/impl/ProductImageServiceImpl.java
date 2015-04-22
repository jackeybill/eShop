package net.shopxx.service.impl;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import net.shopxx.Setting;
import net.shopxx.entity.ProductImage;
import net.shopxx.plugin.StoragePlugin;
import net.shopxx.service.ProductImageService;
import net.shopxx.util.FreemarkerUtils;
import net.shopxx.util.SettingUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

@Service("productImageServiceImpl")
public class ProductImageServiceImpl
  implements ProductImageService, ServletContextAware
{
  private static final String IIIllIlI = "jpg";
  private static final String IIIllIll = "image/jpeg";
  private ServletContext IIIlllII;

  @Resource(name="taskExecutor")
  private TaskExecutor IIIlllIl;

  @Resource
  private List<StoragePlugin> IIIllllI;

  public void setServletContext(ServletContext servletContext)
  {
    this.IIIlllII = servletContext;
  }

  private void IIIllIlI(String paramString1, String paramString2, String paramString3, String paramString4, File paramFile, String paramString5)
  {
    try
    {
      this.IIIlllIl.execute(new ProductImageServiceImpl.1(this, paramFile, paramString1, paramString5, paramString2, paramString3, paramString4));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void build(ProductImage productImage)
  {
    MultipartFile localMultipartFile = productImage.getFile();
    if ((localMultipartFile != null) && (!localMultipartFile.isEmpty()))
      try
      {
        Setting localSetting = SettingUtils.get();
        HashMap localHashMap = new HashMap();
        localHashMap.put("uuid", UUID.randomUUID().toString());
        String str1 = FreemarkerUtils.process(localSetting.getImageUploadPath(), localHashMap);
        String str2 = UUID.randomUUID().toString();
        String str3 = str1 + str2 + "-source." + FilenameUtils.getExtension(localMultipartFile.getOriginalFilename());
        String str4 = str1 + str2 + "-large." + "jpg";
        String str5 = str1 + str2 + "-medium." + "jpg";
        String str6 = str1 + str2 + "-thumbnail." + "jpg";
        Collections.sort(this.IIIllllI);
        Iterator localIterator = this.IIIllllI.iterator();
        while (localIterator.hasNext())
        {
          StoragePlugin localStoragePlugin = (StoragePlugin)localIterator.next();
          if (localStoragePlugin.getIsEnabled())
          {
            File localFile = new File(System.getProperty("java.io.tmpdir") + "/upload_" + UUID.randomUUID() + ".tmp");
            if (!localFile.getParentFile().exists())
              localFile.getParentFile().mkdirs();
            localMultipartFile.transferTo(localFile);
            IIIllIlI(str3, str4, str5, str6, localFile, localMultipartFile.getContentType());
            productImage.setSource(localStoragePlugin.getUrl(str3));
            productImage.setLarge(localStoragePlugin.getUrl(str4));
            productImage.setMedium(localStoragePlugin.getUrl(str5));
            productImage.setThumbnail(localStoragePlugin.getUrl(str6));
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.ProductImageServiceImpl
 * JD-Core Version:    0.6.2
 */