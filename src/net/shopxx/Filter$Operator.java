package net.shopxx;

public enum Filter$Operator
{
  eq, ne, gt, lt, ge, le, like, in, isNull, isNotNull;

  public static Operator fromString(String value)
  {
    return valueOf(value.toLowerCase());
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.Filter.Operator
 * JD-Core Version:    0.6.2
 */