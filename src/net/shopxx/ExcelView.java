package net.shopxx;

import java.net.URLEncoder;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Comment;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelView extends AbstractExcelView
{
  private static final String IIIllIlI = "yyyy-MM-dd HH:mm:ss";
  private String IIIllIll;
  private String IIIlllII;
  private String[] IIIlllIl;
  private String[] IIIllllI;
  private Integer[] IIIlllll;
  private Converter[] IIlIIIII;
  private Collection<?> IIlIIIIl;
  private String[] IIlIIIlI;

  static
  {
    DateConverter localDateConverter = new DateConverter();
    localDateConverter.setPattern("yyyy-MM-dd HH:mm:ss");
    ConvertUtils.register(localDateConverter, Date.class);
  }

  public ExcelView(String filename, String sheetName, String[] properties, String[] titles, Integer[] widths, Converter[] converters, Collection<?> data, String[] contents)
  {
    this.IIIllIll = filename;
    this.IIIlllII = sheetName;
    this.IIIlllIl = properties;
    this.IIIllllI = titles;
    this.IIIlllll = widths;
    this.IIlIIIII = converters;
    this.IIlIIIIl = data;
    this.IIlIIIlI = contents;
  }

  public ExcelView(String[] properties, String[] titles, Collection<?> data, String[] contents)
  {
    this.IIIlllIl = properties;
    this.IIIllllI = titles;
    this.IIlIIIIl = data;
    this.IIlIIIlI = contents;
  }

  public ExcelView(String[] properties, String[] titles, Collection<?> data)
  {
    this.IIIlllIl = properties;
    this.IIIllllI = titles;
    this.IIlIIIIl = data;
  }

  public ExcelView(String[] properties, Collection<?> data)
  {
    this.IIIlllIl = properties;
    this.IIlIIIIl = data;
  }

  public void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
  {
    Assert.notEmpty(this.IIIlllIl);
    HSSFSheet localHSSFSheet;
    if (StringUtils.isNotEmpty(this.IIIlllII))
      localHSSFSheet = workbook.createSheet(this.IIIlllII);
    else
      localHSSFSheet = workbook.createSheet();
    int i = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if ((this.IIIllllI != null) && (this.IIIllllI.length > 0))
    {
      localObject1 = localHSSFSheet.createRow(i);
      ((HSSFRow)localObject1).setHeight((short)400);
      for (int j = 0; j < this.IIIlllIl.length; j++)
      {
        localObject2 = ((HSSFRow)localObject1).createCell(j);
        HSSFCellStyle localHSSFCellStyle = workbook.createCellStyle();
        localHSSFCellStyle.setFillForegroundColor((short)31);
        localHSSFCellStyle.setFillPattern((short)1);
        localHSSFCellStyle.setAlignment((short)2);
        localHSSFCellStyle.setVerticalAlignment((short)1);
        localObject3 = workbook.createFont();
        ((HSSFFont)localObject3).setFontHeightInPoints((short)11);
        ((HSSFFont)localObject3).setBoldweight((short)700);
        localHSSFCellStyle.setFont((HSSFFont)localObject3);
        ((HSSFCell)localObject2).setCellStyle(localHSSFCellStyle);
        if (j == 0)
        {
          localObject4 = localHSSFSheet.createDrawingPatriarch();
          localObject5 = ((HSSFPatriarch)localObject4).createComment(new HSSFClientAnchor(0, 0, 0, 0, (short)1, 1, (short)4, 4));
          ((HSSFComment)localObject5).setString(new HSSFRichTextString("Powered By SHOP++"));
          ((HSSFCell)localObject2).setCellComment((Comment)localObject5);
        }
        if ((this.IIIllllI.length > j) && (this.IIIllllI[j] != null))
          ((HSSFCell)localObject2).setCellValue(this.IIIllllI[j]);
        else
          ((HSSFCell)localObject2).setCellValue(this.IIIlllIl[j]);
        if ((this.IIIlllll != null) && (this.IIIlllll.length > j) && (this.IIIlllll[j] != null))
          localHSSFSheet.setColumnWidth(j, this.IIIlllll[j].intValue());
        else
          localHSSFSheet.autoSizeColumn(j);
      }
      i++;
    }
    if (this.IIlIIIIl != null)
    {
      Iterator localIterator = this.IIlIIIIl.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        localObject2 = localHSSFSheet.createRow(i);
        for (int n = 0; n < this.IIIlllIl.length; n++)
        {
          localObject3 = ((HSSFRow)localObject2).createCell(n);
          if ((this.IIlIIIII != null) && (this.IIlIIIII.length > n) && (this.IIlIIIII[n] != null))
          {
            localObject4 = PropertyUtils.getPropertyType(localObject1, this.IIIlllIl[n]);
            ConvertUtils.register(this.IIlIIIII[n], (Class)localObject4);
            ((HSSFCell)localObject3).setCellValue(BeanUtils.getProperty(localObject1, this.IIIlllIl[n]));
            ConvertUtils.deregister((Class)localObject4);
            if (localObject4.equals(Date.class))
            {
              localObject5 = new DateConverter();
              ((DateConverter)localObject5).setPattern("yyyy-MM-dd HH:mm:ss");
              ConvertUtils.register((Converter)localObject5, Date.class);
            }
          }
          else
          {
            ((HSSFCell)localObject3).setCellValue(BeanUtils.getProperty(localObject1, this.IIIlllIl[n]));
          }
          if ((i == 0) || (i == 1))
            if ((this.IIIlllll != null) && (this.IIIlllll.length > n) && (this.IIIlllll[n] != null))
              localHSSFSheet.setColumnWidth(n, this.IIIlllll[n].intValue());
            else
              localHSSFSheet.autoSizeColumn(n);
        }
        i++;
      }
    }
    if ((this.IIlIIIlI != null) && (this.IIlIIIlI.length > 0))
    {
      i++;
      for (localObject1 : this.IIlIIIlI)
      {
        localObject3 = localHSSFSheet.createRow(i);
        localObject4 = ((HSSFRow)localObject3).createCell(0);
        localObject5 = workbook.createCellStyle();
        HSSFFont localHSSFFont = workbook.createFont();
        localHSSFFont.setColor((short)23);
        ((HSSFCellStyle)localObject5).setFont(localHSSFFont);
        ((HSSFCell)localObject4).setCellStyle((HSSFCellStyle)localObject5);
        ((HSSFCell)localObject4).setCellValue((String)localObject1);
        i++;
      }
    }
    response.setContentType("application/force-download");
    if (StringUtils.isNotEmpty(this.IIIllIll))
      response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(this.IIIllIll, "UTF-8"));
    else
      response.setHeader("Content-disposition", "attachment");
  }

  public String getFileName()
  {
    return this.IIIllIll;
  }

  public void setFileName(String filename)
  {
    this.IIIllIll = filename;
  }

  public String getSheetName()
  {
    return this.IIIlllII;
  }

  public void setSheetName(String sheetName)
  {
    this.IIIlllII = sheetName;
  }

  public String[] getProperties()
  {
    return this.IIIlllIl;
  }

  public void setProperties(String[] properties)
  {
    this.IIIlllIl = properties;
  }

  public String[] getTitles()
  {
    return this.IIIllllI;
  }

  public void setTitles(String[] titles)
  {
    this.IIIllllI = titles;
  }

  public Integer[] getWidths()
  {
    return this.IIIlllll;
  }

  public void setWidths(Integer[] widths)
  {
    this.IIIlllll = widths;
  }

  public Converter[] getConverters()
  {
    return this.IIlIIIII;
  }

  public void setConverters(Converter[] converters)
  {
    this.IIlIIIII = converters;
  }

  public Collection<?> getData()
  {
    return this.IIlIIIIl;
  }

  public void setData(Collection<?> data)
  {
    this.IIlIIIIl = data;
  }

  public String[] getContents()
  {
    return this.IIlIIIlI;
  }

  public void setContents(String[] contents)
  {
    this.IIlIIIlI = contents;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.ExcelView
 * JD-Core Version:    0.6.2
 */