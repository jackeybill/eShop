package net.shopxx;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Filter
  implements Serializable
{
  private static final long serialVersionUID = -8712382358441065075L;
  private static final boolean IIIllIlI = false;
  private String IIIllIll;
  private Filter.Operator IIIlllII;
  private Object IIIlllIl;
  private Boolean IIIllllI = Boolean.valueOf(false);

  public Filter()
  {
  }

  public Filter(String property, Filter.Operator operator, Object value)
  {
    this.IIIllIll = property;
    this.IIIlllII = operator;
    this.IIIlllIl = value;
  }

  public Filter(String property, Filter.Operator operator, Object value, boolean ignoreCase)
  {
    this.IIIllIll = property;
    this.IIIlllII = operator;
    this.IIIlllIl = value;
    this.IIIllllI = Boolean.valueOf(ignoreCase);
  }

  public static Filter eq(String property, Object value)
  {
    return new Filter(property, Filter.Operator.eq, value);
  }

  public static Filter eq(String property, Object value, boolean ignoreCase)
  {
    return new Filter(property, Filter.Operator.eq, value, ignoreCase);
  }

  public static Filter ne(String property, Object value)
  {
    return new Filter(property, Filter.Operator.ne, value);
  }

  public static Filter ne(String property, Object value, boolean ignoreCase)
  {
    return new Filter(property, Filter.Operator.ne, value, ignoreCase);
  }

  public static Filter gt(String property, Object value)
  {
    return new Filter(property, Filter.Operator.gt, value);
  }

  public static Filter lt(String property, Object value)
  {
    return new Filter(property, Filter.Operator.lt, value);
  }

  public static Filter ge(String property, Object value)
  {
    return new Filter(property, Filter.Operator.ge, value);
  }

  public static Filter le(String property, Object value)
  {
    return new Filter(property, Filter.Operator.le, value);
  }

  public static Filter like(String property, Object value)
  {
    return new Filter(property, Filter.Operator.like, value);
  }

  public static Filter in(String property, Object value)
  {
    return new Filter(property, Filter.Operator.in, value);
  }

  public static Filter isNull(String property)
  {
    return new Filter(property, Filter.Operator.isNull, null);
  }

  public static Filter isNotNull(String property)
  {
    return new Filter(property, Filter.Operator.isNotNull, null);
  }

  public Filter ignoreCase()
  {
    this.IIIllllI = Boolean.valueOf(true);
    return this;
  }

  public String getProperty()
  {
    return this.IIIllIll;
  }

  public void setProperty(String property)
  {
    this.IIIllIll = property;
  }

  public Filter.Operator getOperator()
  {
    return this.IIIlllII;
  }

  public void setOperator(Filter.Operator operator)
  {
    this.IIIlllII = operator;
  }

  public Object getValue()
  {
    return this.IIIlllIl;
  }

  public void setValue(Object value)
  {
    this.IIIlllIl = value;
  }

  public Boolean getIgnoreCase()
  {
    return this.IIIllllI;
  }

  public void setIgnoreCase(Boolean ignoreCase)
  {
    this.IIIllllI = ignoreCase;
  }

  public boolean equals(Object obj)
  {
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (this == obj)
      return true;
    Filter localFilter = (Filter)obj;
    return new EqualsBuilder().append(getProperty(), localFilter.getProperty()).append(getOperator(), localFilter.getOperator()).append(getValue(), localFilter.getValue()).isEquals();
  }

  public int hashCode()
  {
    return new HashCodeBuilder(17, 37).append(getProperty()).append(getOperator()).append(getValue()).toHashCode();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.Filter
 * JD-Core Version:    0.6.2
 */