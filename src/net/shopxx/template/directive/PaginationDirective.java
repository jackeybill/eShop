package net.shopxx.template.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.shopxx.util.FreemarkerUtils;
import org.springframework.stereotype.Component;

@Component("paginationDirective")
public class PaginationDirective extends BaseDirective
{
  private static final String IIIllIlI = "pattern";
  private static final String IIIllIll = "pageNumber";
  private static final String IIIlllII = "totalPages";
  private static final String IIIlllIl = "segmentCount";
  private static final String IIIllllI = "pattern";
  private static final String IIIlllll = "pageNumber";
  private static final String IIlIIIII = "totalPages";
  private static final String IIlIIIIl = "segmentCount";
  private static final String IIlIIIlI = "hasPrevious";
  private static final String IIlIIIll = "hasNext";
  private static final String IIlIIlII = "isFirst";
  private static final String IIlIIlIl = "isLast";
  private static final String IIlIIllI = "previousPageNumber";
  private static final String IIlIIlll = "nextPageNumber";
  private static final String IIlIlIII = "firstPageNumber";
  private static final String IIlIlIIl = "lastPageNumber";
  private static final String IIlIlIlI = "segment";

  public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
  {
    String str = (String)FreemarkerUtils.getParameter("pattern", String.class, params);
    Integer localInteger1 = (Integer)FreemarkerUtils.getParameter("pageNumber", Integer.class, params);
    Integer localInteger2 = (Integer)FreemarkerUtils.getParameter("totalPages", Integer.class, params);
    Integer localInteger3 = (Integer)FreemarkerUtils.getParameter("segmentCount", Integer.class, params);
    if ((localInteger1 == null) || (localInteger1.intValue() < 1))
      localInteger1 = Integer.valueOf(1);
    if ((localInteger2 == null) || (localInteger2.intValue() < 1))
      localInteger2 = Integer.valueOf(1);
    if ((localInteger3 == null) || (localInteger3.intValue() < 1))
      localInteger3 = Integer.valueOf(5);
    boolean bool1 = localInteger1.intValue() > 1;
    boolean bool2 = localInteger1.intValue() < localInteger2.intValue();
    boolean bool3 = localInteger1.intValue() == 1;
    boolean bool4 = localInteger1.equals(localInteger2);
    int i = localInteger1.intValue() - 1;
    int j = localInteger1.intValue() + 1;
    int k = 1;
    int m = localInteger2.intValue();
    int n = localInteger1.intValue() - (int)Math.floor((localInteger3.intValue() - 1) / 2.0D);
    int i1 = localInteger1.intValue() + (int)Math.ceil((localInteger3.intValue() - 1) / 2.0D);
    if (n < 1)
      n = 1;
    if (i1 > localInteger2.intValue())
      i1 = localInteger2.intValue();
    ArrayList localArrayList = new ArrayList();
    for (int i2 = n; i2 <= i1; i2++)
      localArrayList.add(Integer.valueOf(i2));
    HashMap localHashMap = new HashMap();
    localHashMap.put("pattern", str);
    localHashMap.put("pageNumber", localInteger1);
    localHashMap.put("totalPages", localInteger2);
    localHashMap.put("segmentCount", localInteger3);
    localHashMap.put("hasPrevious", Boolean.valueOf(bool1));
    localHashMap.put("hasNext", Boolean.valueOf(bool2));
    localHashMap.put("isFirst", Boolean.valueOf(bool3));
    localHashMap.put("isLast", Boolean.valueOf(bool4));
    localHashMap.put("previousPageNumber", Integer.valueOf(i));
    localHashMap.put("nextPageNumber", Integer.valueOf(j));
    localHashMap.put("firstPageNumber", Integer.valueOf(k));
    localHashMap.put("lastPageNumber", Integer.valueOf(m));
    localHashMap.put("segment", localArrayList);
    IIIllIlI(localHashMap, env, body);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.template.directive.PaginationDirective
 * JD-Core Version:    0.6.2
 */