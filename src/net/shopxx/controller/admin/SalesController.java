package net.shopxx.controller.admin;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Resource;
import net.shopxx.service.OrderService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminSalesController")
@RequestMapping({"/admin/sales"})
public class SalesController extends BaseController
{
  private static final int IIIlllIl = 12;

  @Resource(name="orderServiceImpl")
  private OrderService IIIllllI;

  @RequestMapping(value={"/view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String view(SalesController.Type type, Date beginDate, Date endDate, Model model)
  {
    if (type == null)
      type = SalesController.Type.month;
    if (beginDate == null)
      beginDate = DateUtils.addMonths(new Date(), -11);
    if (endDate == null)
      endDate = new Date();
    LinkedHashMap localLinkedHashMap1 = new LinkedHashMap();
    LinkedHashMap localLinkedHashMap2 = new LinkedHashMap();
    Calendar localCalendar1 = DateUtils.toCalendar(beginDate);
    Calendar localCalendar2 = DateUtils.toCalendar(endDate);
    int i = localCalendar1.get(1);
    int j = localCalendar2.get(1);
    int k = localCalendar1.get(2);
    int m = localCalendar2.get(2);
    for (int n = i; n <= j; n++)
    {
      if (localLinkedHashMap1.size() >= 12)
        break;
      Calendar localCalendar3 = Calendar.getInstance();
      localCalendar3.set(1, n);
      Date localDate2;
      Object localObject1;
      Object localObject2;
      if (type == SalesController.Type.year)
      {
        localCalendar3.set(2, localCalendar3.getActualMinimum(2));
        localCalendar3.set(5, localCalendar3.getActualMinimum(5));
        localCalendar3.set(11, localCalendar3.getActualMinimum(11));
        localCalendar3.set(12, localCalendar3.getActualMinimum(12));
        localCalendar3.set(13, localCalendar3.getActualMinimum(13));
        Date localDate1 = localCalendar3.getTime();
        localCalendar3.set(2, localCalendar3.getActualMaximum(2));
        localCalendar3.set(5, localCalendar3.getActualMaximum(5));
        localCalendar3.set(11, localCalendar3.getActualMaximum(11));
        localCalendar3.set(12, localCalendar3.getActualMaximum(12));
        localCalendar3.set(13, localCalendar3.getActualMaximum(13));
        localDate2 = localCalendar3.getTime();
        localObject1 = this.IIIllllI.getSalesAmount(localDate1, localDate2);
        localObject2 = this.IIIllllI.getSalesVolume(localDate1, localDate2);
        localLinkedHashMap1.put(localDate1, localObject1 != null ? localObject1 : BigDecimal.ZERO);
        localLinkedHashMap2.put(localDate1, Integer.valueOf(localObject2 != null ? ((Integer)localObject2).intValue() : 0));
      }
      else
      {
        for (int i1 = n == i ? k : localCalendar3.getActualMinimum(2); i1 <= (n == j ? m : localCalendar3.getActualMaximum(2)); i1++)
        {
          if (localLinkedHashMap1.size() >= 12)
            break;
          localCalendar3.set(2, i1);
          localCalendar3.set(5, localCalendar3.getActualMinimum(5));
          localCalendar3.set(11, localCalendar3.getActualMinimum(11));
          localCalendar3.set(12, localCalendar3.getActualMinimum(12));
          localCalendar3.set(13, localCalendar3.getActualMinimum(13));
          localDate2 = localCalendar3.getTime();
          localCalendar3.set(5, localCalendar3.getActualMaximum(5));
          localCalendar3.set(11, localCalendar3.getActualMaximum(11));
          localCalendar3.set(12, localCalendar3.getActualMaximum(12));
          localCalendar3.set(13, localCalendar3.getActualMaximum(13));
          localObject1 = localCalendar3.getTime();
          localObject2 = this.IIIllllI.getSalesAmount(localDate2, (Date)localObject1);
          Integer localInteger = this.IIIllllI.getSalesVolume(localDate2, (Date)localObject1);
          localLinkedHashMap1.put(localDate2, localObject2 != null ? localObject2 : BigDecimal.ZERO);
          localLinkedHashMap2.put(localDate2, Integer.valueOf(localInteger != null ? localInteger.intValue() : 0));
        }
      }
    }
    model.addAttribute("types", SalesController.Type.values());
    model.addAttribute("type", type);
    model.addAttribute("beginDate", beginDate);
    model.addAttribute("endDate", endDate);
    model.addAttribute("salesAmountMap", localLinkedHashMap1);
    model.addAttribute("salesVolumeMap", localLinkedHashMap2);
    return "/admin/sales/view";
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.SalesController
 * JD-Core Version:    0.6.2
 */