package net.shopxx;

public enum Order$Direction
{
  asc, desc;

  public static Direction fromString(String value)
  {
    return valueOf(value.toLowerCase());
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.Order.Direction
 * JD-Core Version:    0.6.2
 */