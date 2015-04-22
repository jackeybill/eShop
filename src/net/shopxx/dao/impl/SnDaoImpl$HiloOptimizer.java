package net.shopxx.dao.impl;

import net.shopxx.entity.Sn.Type;
import net.shopxx.util.FreemarkerUtils;

class SnDaoImpl$HiloOptimizer
{
  private Sn.Type IIIllIll;
  private String IIIlllII;
  private int IIIlllIl;
  private int IIIllllI;
  private long IIIlllll;
  private long IIlIIIII;

  public SnDaoImpl$HiloOptimizer(SnDaoImpl paramSnDaoImpl, Sn.Type type, String prefix, int maxLo)
  {
    this.IIIllIll = type;
    this.IIIlllII = (prefix != null ? prefix.replace("{", "${") : "");
    this.IIIlllIl = maxLo;
    this.IIIllllI = (maxLo + 1);
  }

  public synchronized String generate()
  {
    if (this.IIIllllI > this.IIIlllIl)
    {
      this.IIlIIIII = SnDaoImpl.IIIllIlI(this.IIIllIlI, this.IIIllIll);
      this.IIIllllI = (this.IIlIIIII == 0L ? 1 : 0);
      this.IIIlllll = (this.IIlIIIII * (this.IIIlllIl + 1));
    }
    return FreemarkerUtils.process(this.IIIlllII, null) + (this.IIIlllll + this.IIIllllI++);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.SnDaoImpl.HiloOptimizer
 * JD-Core Version:    0.6.2
 */