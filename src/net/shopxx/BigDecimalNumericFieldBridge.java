package net.shopxx;

import java.math.BigDecimal;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Fieldable;
import org.hibernate.search.bridge.LuceneOptions;
import org.hibernate.search.bridge.builtin.NumericFieldBridge;

public class BigDecimalNumericFieldBridge extends NumericFieldBridge
{
  public Object get(String name, Document document)
  {
    return new BigDecimal(document.getFieldable(name).stringValue());
  }

  public void set(String name, Object value, Document document, LuceneOptions luceneOptions)
  {
    if (value != null)
    {
      BigDecimal localBigDecimal = (BigDecimal)value;
      luceneOptions.addNumericFieldToDocument(name, Double.valueOf(localBigDecimal.doubleValue()), document);
    }
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.BigDecimalNumericFieldBridge
 * JD-Core Version:    0.6.2
 */