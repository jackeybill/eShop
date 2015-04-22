package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

@MappedSuperclass
public abstract class OrderEntity extends BaseEntity
  implements Comparable<OrderEntity>
{
  private static final long serialVersionUID = 5995013015967525827L;
  public static final String ORDER_PROPERTY_NAME = "order";
  private Integer IIIllIlI;

  @JsonProperty
  @Field(store=Store.YES, index=Index.UN_TOKENIZED)
  @Min(0L)
  @Column(name="orders")
  public Integer getOrder()
  {
    return this.IIIllIlI;
  }

  public void setOrder(Integer order)
  {
    this.IIIllIlI = order;
  }

  public int compareTo(OrderEntity orderEntity)
  {
    return new CompareToBuilder().append(getOrder(), orderEntity.getOrder()).append(getId(), orderEntity.getId()).toComparison();
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.entity.OrderEntity
 * JD-Core Version:    0.6.2
 */