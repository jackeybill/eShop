package net.shopxx.service.impl;

import java.util.Comparator;
import net.shopxx.FileInfo;
import org.apache.commons.lang.builder.CompareToBuilder;

class FileServiceImpl$NameComparator
  implements Comparator<FileInfo>
{
  private FileServiceImpl$NameComparator(FileServiceImpl paramFileServiceImpl)
  {
  }

  public int compare(FileInfo fileInfos1, FileInfo fileInfos2)
  {
    return new CompareToBuilder().append(!fileInfos1.getIsDirectory().booleanValue(), !fileInfos2.getIsDirectory().booleanValue()).append(fileInfos1.getName(), fileInfos2.getName()).toComparison();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.FileServiceImpl.NameComparator
 * JD-Core Version:    0.6.2
 */