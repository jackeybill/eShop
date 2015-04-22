package net.shopxx.util;

import net.shopxx.EnumConverter;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.ArrayConverter;

class FreemarkerUtils$1 extends ConvertUtilsBean
{
  public String convert(Object value)
  {
    if (value != null)
    {
      Class localClass = value.getClass();
      if ((localClass.isEnum()) && (super.lookup(localClass) == null))
      {
        super.register(new EnumConverter(localClass), localClass);
      }
      else if ((localClass.isArray()) && (localClass.getComponentType().isEnum()))
      {
        if (super.lookup(localClass) == null)
        {
          localObject = new ArrayConverter(localClass, new EnumConverter(localClass.getComponentType()), 0);
          ((ArrayConverter)localObject).setOnlyFirstToString(false);
          super.register((Converter)localObject, localClass);
        }
        Object localObject = super.lookup(localClass);
        return (String)((Converter)localObject).convert(String.class, value);
      }
    }
    return super.convert(value);
  }

  public Object convert(String value, Class clazz)
  {
    if ((clazz.isEnum()) && (super.lookup(clazz) == null))
      super.register(new EnumConverter(clazz), clazz);
    return super.convert(value, clazz);
  }

  public Object convert(String[] values, Class clazz)
  {
    if ((clazz.isArray()) && (clazz.getComponentType().isEnum()) && (super.lookup(clazz.getComponentType()) == null))
      super.register(new EnumConverter(clazz.getComponentType()), clazz.getComponentType());
    return super.convert(values, clazz);
  }

  public Object convert(Object value, Class targetType)
  {
    if (super.lookup(targetType) == null)
      if (targetType.isEnum())
      {
        super.register(new EnumConverter(targetType), targetType);
      }
      else if ((targetType.isArray()) && (targetType.getComponentType().isEnum()))
      {
        ArrayConverter localArrayConverter = new ArrayConverter(targetType, new EnumConverter(targetType.getComponentType()), 0);
        localArrayConverter.setOnlyFirstToString(false);
        super.register(localArrayConverter, targetType);
      }
    return super.convert(value, targetType);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.util.FreemarkerUtils.1
 * JD-Core Version:    0.6.2
 */