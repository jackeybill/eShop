package net.shopxx.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import net.shopxx.Setting.WatermarkPosition;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.im4java.core.CompositeCmd;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.IdentifyCmd;
import org.im4java.core.Operation;
import org.springframework.util.Assert;

public final class ImageUtils
{
  private static ImageUtils.Type IIIllIlI = ImageUtils.Type.auto;
  private static String IIIllIll;
  private static String IIIlllII;
  private static final Color IIIlllIl = Color.white;
  private static final int IIIllllI = 88;

  static
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    File localFile1;
    File localFile2;
    if (IIIllIll == null)
    {
      localObject1 = System.getProperty("os.name").toLowerCase();
      if (((String)localObject1).indexOf("windows") >= 0)
      {
        localObject2 = System.getenv("Path");
        if (localObject2 != null)
        {
          localObject3 = ((String)localObject2).split(";");
          for (localObject4 : localObject3)
          {
            localFile1 = new File(localObject4.trim() + "/gm.exe");
            localFile2 = new File(localObject4.trim() + "/gmdisplay.exe");
            if ((localFile1.exists()) && (localFile2.exists()))
            {
              IIIllIll = localObject4.trim();
              break;
            }
          }
        }
      }
    }
    if (IIIlllII == null)
    {
      localObject1 = System.getProperty("os.name").toLowerCase();
      if (((String)localObject1).indexOf("windows") >= 0)
      {
        localObject2 = System.getenv("Path");
        if (localObject2 != null)
        {
          localObject3 = ((String)localObject2).split(";");
          for (localObject4 : localObject3)
          {
            localFile1 = new File(localObject4.trim() + "/convert.exe");
            localFile2 = new File(localObject4.trim() + "/composite.exe");
            if ((localFile1.exists()) && (localFile2.exists()))
            {
              IIIlllII = localObject4.trim();
              break;
            }
          }
        }
      }
    }
    if (IIIllIlI == ImageUtils.Type.auto)
      try
      {
        localObject1 = new IMOperation();
        ((IMOperation)localObject1).version();
        localObject2 = new IdentifyCmd(true);
        if (IIIllIll != null)
          ((IdentifyCmd)localObject2).setSearchPath(IIIllIll);
        ((IdentifyCmd)localObject2).run((Operation)localObject1, new Object[0]);
        IIIllIlI = ImageUtils.Type.graphicsMagick;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject2 = new IMOperation();
          ((IMOperation)localObject2).version();
          localObject3 = new IdentifyCmd(false);
          ((IdentifyCmd)localObject3).run((Operation)localObject2, new Object[0]);
          if (IIIlllII != null)
            ((IdentifyCmd)localObject3).setSearchPath(IIIlllII);
          IIIllIlI = ImageUtils.Type.imageMagick;
        }
        catch (Throwable localThrowable2)
        {
          IIIllIlI = ImageUtils.Type.jdk;
        }
      }
  }

  public static void zoom(File srcFile, File destFile, int destWidth, int destHeight)
  {
    Assert.notNull(srcFile);
    Assert.notNull(destFile);
    Assert.state(destWidth > 0);
    Assert.state(destHeight > 0);
    Object localObject1;
    Object localObject2;
    if (IIIllIlI == ImageUtils.Type.jdk)
    {
      localObject1 = null;
      localObject2 = null;
      ImageWriter localImageWriter = null;
      try
      {
        BufferedImage localBufferedImage1 = ImageIO.read(srcFile);
        int i = localBufferedImage1.getWidth();
        int j = localBufferedImage1.getHeight();
        int k = destWidth;
        int m = destHeight;
        if (j >= i)
          k = (int)Math.round(destHeight * 1.0D / j * i);
        else
          m = (int)Math.round(destWidth * 1.0D / i * j);
        BufferedImage localBufferedImage2 = new BufferedImage(destWidth, destHeight, 1);
        localObject1 = localBufferedImage2.createGraphics();
        ((Graphics2D)localObject1).setBackground(IIIlllIl);
        ((Graphics2D)localObject1).clearRect(0, 0, destWidth, destHeight);
        ((Graphics2D)localObject1).drawImage(localBufferedImage1.getScaledInstance(k, m, 4), destWidth / 2 - k / 2, destHeight / 2 - m / 2, null);
        localObject2 = ImageIO.createImageOutputStream(destFile);
        localImageWriter = (ImageWriter)ImageIO.getImageWritersByFormatName(FilenameUtils.getExtension(destFile.getName())).next();
        localImageWriter.setOutput(localObject2);
        ImageWriteParam localImageWriteParam = localImageWriter.getDefaultWriteParam();
        localImageWriteParam.setCompressionMode(2);
        localImageWriteParam.setCompressionQuality(0.88F);
        localImageWriter.write(null, new IIOImage(localBufferedImage2, null, null), localImageWriteParam);
        ((ImageOutputStream)localObject2).flush();
      }
      catch (IOException localIOException8)
      {
        localIOException8.printStackTrace();
        if (localObject1 != null)
          ((Graphics2D)localObject1).dispose();
        if (localImageWriter != null)
          localImageWriter.dispose();
        if (localObject2 == null)
          return;
        try
        {
          ((ImageOutputStream)localObject2).close();
        }
        catch (IOException localIOException1)
        {
        }
      }
      finally
      {
        if (localObject1 != null)
          ((Graphics2D)localObject1).dispose();
        if (localImageWriter != null)
          localImageWriter.dispose();
        if (localObject2 != null)
          try
          {
            ((ImageOutputStream)localObject2).close();
          }
          catch (IOException localIOException2)
          {
          }
      }
      try
      {
        ((ImageOutputStream)localObject2).close();
      }
      catch (IOException localIOException3)
      {
      }
    }
    else
    {
      localObject1 = new IMOperation();
      ((IMOperation)localObject1).thumbnail(Integer.valueOf(destWidth), Integer.valueOf(destHeight));
      ((IMOperation)localObject1).gravity("center");
      ((IMOperation)localObject1).background(IIIllIlI(IIIlllIl));
      ((IMOperation)localObject1).extent(Integer.valueOf(destWidth), Integer.valueOf(destHeight));
      ((IMOperation)localObject1).quality(Double.valueOf(88.0D));
      ((IMOperation)localObject1).addImage(new String[] { srcFile.getPath() });
      ((IMOperation)localObject1).addImage(new String[] { destFile.getPath() });
      if (IIIllIlI == ImageUtils.Type.graphicsMagick)
      {
        localObject2 = new ConvertCmd(true);
        if (IIIllIll != null)
          ((ConvertCmd)localObject2).setSearchPath(IIIllIll);
        try
        {
          ((ConvertCmd)localObject2).run((Operation)localObject1, new Object[0]);
        }
        catch (IOException localIOException6)
        {
          localIOException6.printStackTrace();
        }
        catch (InterruptedException localInterruptedException2)
        {
          localInterruptedException2.printStackTrace();
        }
        catch (IM4JavaException localIM4JavaException2)
        {
          localIM4JavaException2.printStackTrace();
        }
      }
      else
      {
        localObject2 = new ConvertCmd(false);
        if (IIIlllII != null)
          ((ConvertCmd)localObject2).setSearchPath(IIIlllII);
        try
        {
          ((ConvertCmd)localObject2).run((Operation)localObject1, new Object[0]);
        }
        catch (IOException localIOException7)
        {
          localIOException7.printStackTrace();
        }
        catch (InterruptedException localInterruptedException3)
        {
          localInterruptedException3.printStackTrace();
        }
        catch (IM4JavaException localIM4JavaException3)
        {
          localIM4JavaException3.printStackTrace();
        }
      }
    }
  }

  public static void addWatermark(File srcFile, File destFile, File watermarkFile, Setting.WatermarkPosition watermarkPosition, int alpha)
  {
    Assert.notNull(srcFile);
    Assert.notNull(destFile);
    Assert.state(alpha >= 0);
    Assert.state(alpha <= 100);
    if ((watermarkFile == null) || (!watermarkFile.exists()) || (watermarkPosition == null) || (watermarkPosition == Setting.WatermarkPosition.no))
    {
      try
      {
        FileUtils.copyFile(srcFile, destFile);
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      return;
    }
    Object localObject1;
    Object localObject2;
    if (IIIllIlI == ImageUtils.Type.jdk)
    {
      localIOException = null;
      localObject1 = null;
      localObject2 = null;
      try
      {
        BufferedImage localBufferedImage1 = ImageIO.read(srcFile);
        int i = localBufferedImage1.getWidth();
        int j = localBufferedImage1.getHeight();
        BufferedImage localBufferedImage2 = new BufferedImage(i, j, 1);
        localIOException = localBufferedImage2.createGraphics();
        localIOException.setBackground(IIIlllIl);
        localIOException.clearRect(0, 0, i, j);
        localIOException.drawImage(localBufferedImage1, 0, 0, null);
        localIOException.setComposite(AlphaComposite.getInstance(10, alpha / 100.0F));
        BufferedImage localBufferedImage3 = ImageIO.read(watermarkFile);
        int k = localBufferedImage3.getWidth();
        int m = localBufferedImage3.getHeight();
        int n = i - k;
        int i1 = j - m;
        if (watermarkPosition == Setting.WatermarkPosition.topLeft)
        {
          n = 0;
          i1 = 0;
        }
        else if (watermarkPosition == Setting.WatermarkPosition.topRight)
        {
          n = i - k;
          i1 = 0;
        }
        else if (watermarkPosition == Setting.WatermarkPosition.center)
        {
          n = (i - k) / 2;
          i1 = (j - m) / 2;
        }
        else if (watermarkPosition == Setting.WatermarkPosition.bottomLeft)
        {
          n = 0;
          i1 = j - m;
        }
        else if (watermarkPosition == Setting.WatermarkPosition.bottomRight)
        {
          n = i - k;
          i1 = j - m;
        }
        localIOException.drawImage(localBufferedImage3, n, i1, k, m, null);
        localObject1 = ImageIO.createImageOutputStream(destFile);
        localObject2 = (ImageWriter)ImageIO.getImageWritersByFormatName(FilenameUtils.getExtension(destFile.getName())).next();
        ((ImageWriter)localObject2).setOutput(localObject1);
        ImageWriteParam localImageWriteParam = ((ImageWriter)localObject2).getDefaultWriteParam();
        localImageWriteParam.setCompressionMode(2);
        localImageWriteParam.setCompressionQuality(0.88F);
        ((ImageWriter)localObject2).write(null, new IIOImage(localBufferedImage2, null, null), localImageWriteParam);
        ((ImageOutputStream)localObject1).flush();
      }
      catch (IOException localIOException7)
      {
        localIOException7.printStackTrace();
        if (localIOException != null)
          localIOException.dispose();
        if (localObject2 != null)
          ((ImageWriter)localObject2).dispose();
        if (localObject1 == null)
          return;
        try
        {
          ((ImageOutputStream)localObject1).close();
        }
        catch (IOException localIOException2)
        {
        }
      }
      finally
      {
        if (localIOException != null)
          localIOException.dispose();
        if (localObject2 != null)
          ((ImageWriter)localObject2).dispose();
        if (localObject1 != null)
          try
          {
            ((ImageOutputStream)localObject1).close();
          }
          catch (IOException localIOException3)
          {
          }
      }
      try
      {
        ((ImageOutputStream)localObject1).close();
      }
      catch (IOException localIOException4)
      {
      }
    }
    else
    {
      localIOException = "SouthEast";
      if (watermarkPosition == Setting.WatermarkPosition.topLeft)
        localIOException = "NorthWest";
      else if (watermarkPosition == Setting.WatermarkPosition.topRight)
        localIOException = "NorthEast";
      else if (watermarkPosition == Setting.WatermarkPosition.center)
        localIOException = "Center";
      else if (watermarkPosition == Setting.WatermarkPosition.bottomLeft)
        localIOException = "SouthWest";
      else if (watermarkPosition == Setting.WatermarkPosition.bottomRight)
        localIOException = "SouthEast";
      localObject1 = new IMOperation();
      ((IMOperation)localObject1).gravity(localIOException);
      ((IMOperation)localObject1).dissolve(Integer.valueOf(alpha));
      ((IMOperation)localObject1).quality(Double.valueOf(88.0D));
      ((IMOperation)localObject1).addImage(new String[] { watermarkFile.getPath() });
      ((IMOperation)localObject1).addImage(new String[] { srcFile.getPath() });
      ((IMOperation)localObject1).addImage(new String[] { destFile.getPath() });
      if (IIIllIlI == ImageUtils.Type.graphicsMagick)
      {
        localObject2 = new CompositeCmd(true);
        if (IIIllIll != null)
          ((CompositeCmd)localObject2).setSearchPath(IIIllIll);
        try
        {
          ((CompositeCmd)localObject2).run((Operation)localObject1, new Object[0]);
        }
        catch (IOException localIOException8)
        {
          localIOException8.printStackTrace();
        }
        catch (InterruptedException localInterruptedException2)
        {
          localInterruptedException2.printStackTrace();
        }
        catch (IM4JavaException localIM4JavaException2)
        {
          localIM4JavaException2.printStackTrace();
        }
      }
      else
      {
        localObject2 = new CompositeCmd(false);
        if (IIIlllII != null)
          ((CompositeCmd)localObject2).setSearchPath(IIIlllII);
        try
        {
          ((CompositeCmd)localObject2).run((Operation)localObject1, new Object[0]);
        }
        catch (IOException localIOException9)
        {
          localIOException9.printStackTrace();
        }
        catch (InterruptedException localInterruptedException3)
        {
          localInterruptedException3.printStackTrace();
        }
        catch (IM4JavaException localIM4JavaException3)
        {
          localIM4JavaException3.printStackTrace();
        }
      }
    }
  }

  public static void initialize()
  {
  }

  private static String IIIllIlI(Color paramColor)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str1 = Integer.toHexString(paramColor.getRed());
    String str2 = Integer.toHexString(paramColor.getGreen());
    String str3 = Integer.toHexString(paramColor.getBlue());
    str1 = str1.length() == 1 ? "0" + str1 : str1;
    str2 = str2.length() == 1 ? "0" + str2 : str2;
    str3 = str3.length() == 1 ? "0" + str3 : str3;
    localStringBuffer.append("#");
    localStringBuffer.append(str1);
    localStringBuffer.append(str2);
    localStringBuffer.append(str3);
    return localStringBuffer.toString();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.util.ImageUtils
 * JD-Core Version:    0.6.2
 */