package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="xx_parameter")
public class Parameter extends OrderEntity
{
  private static final long serialVersionUID = -5833568086582136314L;
  private String IIIllIlI;
  private ParameterGroup IIIllIll;

  @JsonProperty
  @NotEmpty
  @Length(max=200)
  @Column(nullable=false)
  public String getName()
  {
    return this.IIIllIlI;
  }

  public void setName(String name)
  {
    this.IIIllIlI = name;
  }

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false)
  public ParameterGroup getParameterGroup()
  {
    return this.IIIllIll;
  }

  public void setParameterGroup(ParameterGroup parameterGroup)
  {
    this.IIIllIll = parameterGroup;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.Parameter
 * JD-Core Version:    0.6.2
 */