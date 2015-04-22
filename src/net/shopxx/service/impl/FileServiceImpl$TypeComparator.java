package net.shopxx.service.impl;

import java.util.Comparator;
import net.shopxx.FileInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.builder.CompareToBuilder;

class FileServiceImpl$TypeComparator
  implements Comparator<FileInfo>
{
  private FileServiceImpl$TypeComparator(FileServiceImpl paramFileServiceImpl)
  {
  }

  public int compare(FileInfo fileInfos1, FileInfo fileInfos2)
  {
    return new CompareToBuilder().append(!fileInfos1.getIsDirectory().booleanValue(), !fileInfos2.getIsDirectory().booleanValue()).append(FilenameUtils.getExtension(fileInfos1.getName()), FilenameUtils.getExtension(fileInfos2.getName())).toComparison();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.FileServiceImpl.TypeComparator
 * JD-Core Version:    0.6.2
 */