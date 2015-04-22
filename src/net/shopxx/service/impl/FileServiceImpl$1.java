package net.shopxx.service.impl;

import java.io.File;
import net.shopxx.plugin.StoragePlugin;
import org.apache.commons.io.FileUtils;

class FileServiceImpl$1
  implements Runnable
{
  FileServiceImpl$1(FileServiceImpl paramFileServiceImpl, File paramFile, StoragePlugin paramStoragePlugin, String paramString1, String paramString2)
  {
  }

  public void run()
  {
    try
    {
      this.IIIlllII.upload(this.IIIlllIl, this.IIIllIll, this.IIIllllI);
    }
    finally
    {
      FileUtils.deleteQuietly(this.IIIllIll);
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.FileServiceImpl.1
 * JD-Core Version:    0.6.2
 */