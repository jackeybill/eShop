package net.shopxx.entity;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="xx_plugin_config")
public class PluginConfig extends OrderEntity
{
  private static final long serialVersionUID = -4357367409438384806L;
  private String IIIllIlI;
  private Boolean IIIllIll;
  private Map<String, String> IIIlllII = new HashMap();

  @Column(nullable=false, updatable=false, unique=true)
  public String getPluginId()
  {
    return this.IIIllIlI;
  }

  public void setPluginId(String pluginId)
  {
    this.IIIllIlI = pluginId;
  }

  @Column(nullable=false)
  public Boolean getIsEnabled()
  {
    return this.IIIllIll;
  }

  public void setIsEnabled(Boolean isEnabled)
  {
    this.IIIllIll = isEnabled;
  }

  @ElementCollection(fetch=FetchType.EAGER)
  @CollectionTable(name="xx_plugin_config_attribute")
  public Map<String, String> getAttributes()
  {
    return this.IIIlllII;
  }

  public void setAttributes(Map<String, String> attributes)
  {
    this.IIIlllII = attributes;
  }

  @Transient
  public String getAttribute(String name)
  {
    if ((getAttributes() != null) && (name != null))
      return (String)getAttributes().get(name);
    return null;
  }

  @Transient
  public void setAttribute(String name, String value)
  {
    if ((getAttributes() != null) && (name != null))
      getAttributes().put(name, value);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.PluginConfig
 * JD-Core Version:    0.6.2
 */