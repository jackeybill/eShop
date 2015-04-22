package net.shopxx.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.Attribute;
import net.shopxx.Filter;
import net.shopxx.Filter.Operator;
import net.shopxx.Order.Direction;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.dao.BaseDao;
import net.shopxx.entity.OrderEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

public abstract class BaseDaoImpl<T, ID extends Serializable>
  implements BaseDao<T, ID>
{
  private Class<T> IIIllIll;
  private static volatile long IIIlllII = 0L;

  @PersistenceContext
  protected EntityManager IIIllIlI;

  public BaseDaoImpl()
  {
    Type localType = getClass().getGenericSuperclass();
    Type[] arrayOfType = ((ParameterizedType)localType).getActualTypeArguments();
    this.IIIllIll = ((Class)arrayOfType[0]);
  }

  public T find(ID id)
  {
    if (id != null)
      return this.IIIllIlI.find(this.IIIllIll, id);
    return null;
  }

  public List<T> findList(Integer first, Integer count, List<Filter> filters, List<net.shopxx.Order> orders)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(this.IIIllIll);
    localCriteriaQuery.select(localCriteriaQuery.from(this.IIIllIll));
    return IIIllIlI(localCriteriaQuery, first, count, filters, orders);
  }

  public Page<T> findPage(Pageable pageable)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(this.IIIllIll);
    localCriteriaQuery.select(localCriteriaQuery.from(this.IIIllIll));
    return IIIllIlI(localCriteriaQuery, pageable);
  }

  public long count(Filter[] filters)
  {
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(this.IIIllIll);
    localCriteriaQuery.select(localCriteriaQuery.from(this.IIIllIll));
    return IIIllIlI(localCriteriaQuery, filters != null ? Arrays.asList(filters) : null).longValue();
  }

  public void persist(T entity)
  {
    Assert.notNull(entity);
    this.IIIllIlI.persist(entity);
  }

  public T merge(T entity)
  {
    Assert.notNull(entity);
    return this.IIIllIlI.merge(entity);
  }

  public void remove(T entity)
  {
    if (entity != null)
      this.IIIllIlI.remove(entity);
  }

  public void refresh(T entity)
  {
    Assert.notNull(entity);
    this.IIIllIlI.refresh(entity);
  }

  public ID getIdentifier(T entity)
  {
    Assert.notNull(entity);
    return (Serializable)this.IIIllIlI.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
  }

  public boolean isManaged(T entity)
  {
    return this.IIIllIlI.contains(entity);
  }

  public void detach(T entity)
  {
    this.IIIllIlI.detach(entity);
  }

  public void lock(T entity, LockModeType lockModeType)
  {
    if ((entity != null) && (lockModeType != null))
      this.IIIllIlI.lock(entity, lockModeType);
  }

  public void clear()
  {
    this.IIIllIlI.clear();
  }

  public void flush()
  {
    this.IIIllIlI.flush();
  }

  protected List<T> IIIllIlI(CriteriaQuery<T> paramCriteriaQuery, Integer paramInteger1, Integer paramInteger2, List<Filter> paramList, List<net.shopxx.Order> paramList1)
  {
    Assert.notNull(paramCriteriaQuery);
    Assert.notNull(paramCriteriaQuery.getSelection());
    Assert.notEmpty(paramCriteriaQuery.getRoots());
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    Root localRoot = IIIllIlI(paramCriteriaQuery);
    IIIllIll(paramCriteriaQuery, paramList);
    IIIlllII(paramCriteriaQuery, paramList1);
    if (paramCriteriaQuery.getOrderList().isEmpty())
      if (OrderEntity.class.isAssignableFrom(this.IIIllIll))
        paramCriteriaQuery.orderBy(new javax.persistence.criteria.Order[] { localCriteriaBuilder.asc(localRoot.get("order")) });
      else
        paramCriteriaQuery.orderBy(new javax.persistence.criteria.Order[] { localCriteriaBuilder.desc(localRoot.get("createDate")) });
    TypedQuery localTypedQuery = this.IIIllIlI.createQuery(paramCriteriaQuery).setFlushMode(FlushModeType.COMMIT);
    if (paramInteger1 != null)
      localTypedQuery.setFirstResult(paramInteger1.intValue());
    if (paramInteger2 != null)
      localTypedQuery.setMaxResults(paramInteger2.intValue());
    return localTypedQuery.getResultList();
  }

  protected Page<T> IIIllIlI(CriteriaQuery<T> paramCriteriaQuery, Pageable paramPageable)
  {
    Assert.notNull(paramCriteriaQuery);
    Assert.notNull(paramCriteriaQuery.getSelection());
    Assert.notEmpty(paramCriteriaQuery.getRoots());
    if (paramPageable == null)
      paramPageable = new Pageable();
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    Root localRoot = IIIllIlI(paramCriteriaQuery);
    IIIllIll(paramCriteriaQuery, paramPageable);
    IIIlllII(paramCriteriaQuery, paramPageable);
    if (paramCriteriaQuery.getOrderList().isEmpty())
      if (OrderEntity.class.isAssignableFrom(this.IIIllIll))
        paramCriteriaQuery.orderBy(new javax.persistence.criteria.Order[] { localCriteriaBuilder.asc(localRoot.get("order")) });
      else
        paramCriteriaQuery.orderBy(new javax.persistence.criteria.Order[] { localCriteriaBuilder.desc(localRoot.get("createDate")) });
    long l = IIIllIlI(paramCriteriaQuery, null).longValue();
    int i = (int)Math.ceil(l / paramPageable.getPageSize());
    if (i < paramPageable.getPageNumber())
      paramPageable.setPageNumber(i);
    TypedQuery localTypedQuery = this.IIIllIlI.createQuery(paramCriteriaQuery).setFlushMode(FlushModeType.COMMIT);
    localTypedQuery.setFirstResult((paramPageable.getPageNumber() - 1) * paramPageable.getPageSize());
    localTypedQuery.setMaxResults(paramPageable.getPageSize());
    return new Page(localTypedQuery.getResultList(), l, paramPageable);
  }

  protected Long IIIllIlI(CriteriaQuery<T> paramCriteriaQuery, List<Filter> paramList)
  {
    Assert.notNull(paramCriteriaQuery);
    Assert.notNull(paramCriteriaQuery.getSelection());
    Assert.notEmpty(paramCriteriaQuery.getRoots());
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    IIIllIll(paramCriteriaQuery, paramList);
    CriteriaQuery localCriteriaQuery = localCriteriaBuilder.createQuery(Long.class);
    Iterator localIterator = paramCriteriaQuery.getRoots().iterator();
    while (localIterator.hasNext())
    {
      localRoot1 = (Root)localIterator.next();
      Root localRoot2 = localCriteriaQuery.from(localRoot1.getJavaType());
      localRoot2.alias(IIIllIlI(localRoot1));
      IIIllIlI(localRoot1, localRoot2);
    }
    Root localRoot1 = IIIllIlI(localCriteriaQuery, paramCriteriaQuery.getResultType());
    localCriteriaQuery.select(localCriteriaBuilder.count(localRoot1));
    if (paramCriteriaQuery.getGroupList() != null)
      localCriteriaQuery.groupBy(paramCriteriaQuery.getGroupList());
    if (paramCriteriaQuery.getGroupRestriction() != null)
      localCriteriaQuery.having(paramCriteriaQuery.getGroupRestriction());
    if (paramCriteriaQuery.getRestriction() != null)
      localCriteriaQuery.where(paramCriteriaQuery.getRestriction());
    return (Long)this.IIIllIlI.createQuery(localCriteriaQuery).setFlushMode(FlushModeType.COMMIT).getSingleResult();
  }

  private synchronized String IIIllIlI(Selection<?> paramSelection)
  {
    if (paramSelection != null)
    {
      String str = paramSelection.getAlias();
      if (str == null)
      {
        if (IIIlllII >= 1000L)
          IIIlllII = 0L;
        str = "shopxxGeneratedAlias" + IIIlllII++;
        paramSelection.alias(str);
      }
      return str;
    }
    return null;
  }

  private Root<T> IIIllIlI(CriteriaQuery<T> paramCriteriaQuery)
  {
    if (paramCriteriaQuery != null)
      return IIIllIlI(paramCriteriaQuery, paramCriteriaQuery.getResultType());
    return null;
  }

  private Root<T> IIIllIlI(CriteriaQuery<?> paramCriteriaQuery, Class<T> paramClass)
  {
    if ((paramCriteriaQuery != null) && (paramCriteriaQuery.getRoots() != null) && (paramClass != null))
    {
      Iterator localIterator = paramCriteriaQuery.getRoots().iterator();
      while (localIterator.hasNext())
      {
        Root localRoot = (Root)localIterator.next();
        if (paramClass.equals(localRoot.getJavaType()))
          return (Root)localRoot.as(paramClass);
      }
    }
    return null;
  }

  private void IIIllIlI(From<?, ?> paramFrom1, From<?, ?> paramFrom2)
  {
    Iterator localIterator = paramFrom1.getJoins().iterator();
    Object localObject1;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (Join)localIterator.next();
      localObject2 = paramFrom2.join(((Join)localObject1).getAttribute().getName(), ((Join)localObject1).getJoinType());
      ((Join)localObject2).alias(IIIllIlI((Selection)localObject1));
      IIIllIlI((From)localObject1, (From)localObject2);
    }
    localIterator = paramFrom1.getFetches().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Fetch)localIterator.next();
      localObject2 = paramFrom2.fetch(((Fetch)localObject1).getAttribute().getName());
      IIIllIlI((Fetch)localObject1, (Fetch)localObject2);
    }
  }

  private void IIIllIlI(Fetch<?, ?> paramFetch1, Fetch<?, ?> paramFetch2)
  {
    Iterator localIterator = paramFetch1.getFetches().iterator();
    while (localIterator.hasNext())
    {
      Fetch localFetch1 = (Fetch)localIterator.next();
      Fetch localFetch2 = paramFetch2.fetch(localFetch1.getAttribute().getName());
      IIIllIlI(localFetch1, localFetch2);
    }
  }

  private void IIIllIll(CriteriaQuery<T> paramCriteriaQuery, List<Filter> paramList)
  {
    if ((paramCriteriaQuery == null) || (paramList == null) || (paramList.isEmpty()))
      return;
    Root localRoot = IIIllIlI(paramCriteriaQuery);
    if (localRoot == null)
      return;
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    Predicate localPredicate = paramCriteriaQuery.getRestriction() != null ? paramCriteriaQuery.getRestriction() : localCriteriaBuilder.conjunction();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Filter localFilter = (Filter)localIterator.next();
      if ((localFilter != null) && (!StringUtils.isEmpty(localFilter.getProperty())))
        if ((localFilter.getOperator() == Filter.Operator.eq) && (localFilter.getValue() != null))
        {
          if ((localFilter.getIgnoreCase() != null) && (localFilter.getIgnoreCase().booleanValue()) && ((localFilter.getValue() instanceof String)))
            localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localCriteriaBuilder.lower(localRoot.get(localFilter.getProperty())), ((String)localFilter.getValue()).toLowerCase()));
          else
            localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get(localFilter.getProperty()), localFilter.getValue()));
        }
        else if ((localFilter.getOperator() == Filter.Operator.ne) && (localFilter.getValue() != null))
        {
          if ((localFilter.getIgnoreCase() != null) && (localFilter.getIgnoreCase().booleanValue()) && ((localFilter.getValue() instanceof String)))
            localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.notEqual(localCriteriaBuilder.lower(localRoot.get(localFilter.getProperty())), ((String)localFilter.getValue()).toLowerCase()));
          else
            localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.notEqual(localRoot.get(localFilter.getProperty()), localFilter.getValue()));
        }
        else if ((localFilter.getOperator() == Filter.Operator.gt) && (localFilter.getValue() != null))
          localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.gt(localRoot.get(localFilter.getProperty()), (Number)localFilter.getValue()));
        else if ((localFilter.getOperator() == Filter.Operator.lt) && (localFilter.getValue() != null))
          localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.lt(localRoot.get(localFilter.getProperty()), (Number)localFilter.getValue()));
        else if ((localFilter.getOperator() == Filter.Operator.ge) && (localFilter.getValue() != null))
          localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.ge(localRoot.get(localFilter.getProperty()), (Number)localFilter.getValue()));
        else if ((localFilter.getOperator() == Filter.Operator.le) && (localFilter.getValue() != null))
          localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.le(localRoot.get(localFilter.getProperty()), (Number)localFilter.getValue()));
        else if ((localFilter.getOperator() == Filter.Operator.like) && (localFilter.getValue() != null) && ((localFilter.getValue() instanceof String)))
          localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.like(localRoot.get(localFilter.getProperty()), (String)localFilter.getValue()));
        else if ((localFilter.getOperator() == Filter.Operator.in) && (localFilter.getValue() != null))
          localPredicate = localCriteriaBuilder.and(localPredicate, localRoot.get(localFilter.getProperty()).in(new Object[] { localFilter.getValue() }));
        else if (localFilter.getOperator() == Filter.Operator.isNull)
          localPredicate = localCriteriaBuilder.and(localPredicate, localRoot.get(localFilter.getProperty()).isNull());
        else if (localFilter.getOperator() == Filter.Operator.isNotNull)
          localPredicate = localCriteriaBuilder.and(localPredicate, localRoot.get(localFilter.getProperty()).isNotNull());
    }
    paramCriteriaQuery.where(localPredicate);
  }

  private void IIIllIll(CriteriaQuery<T> paramCriteriaQuery, Pageable paramPageable)
  {
    if ((paramCriteriaQuery == null) || (paramPageable == null))
      return;
    Root localRoot = IIIllIlI(paramCriteriaQuery);
    if (localRoot == null)
      return;
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    Predicate localPredicate = paramCriteriaQuery.getRestriction() != null ? paramCriteriaQuery.getRestriction() : localCriteriaBuilder.conjunction();
    if ((StringUtils.isNotEmpty(paramPageable.getSearchProperty())) && (StringUtils.isNotEmpty(paramPageable.getSearchValue())))
      localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.like(localRoot.get(paramPageable.getSearchProperty()), "%" + paramPageable.getSearchValue() + "%"));
    if (paramPageable.getFilters() != null)
    {
      Iterator localIterator = paramPageable.getFilters().iterator();
      while (localIterator.hasNext())
      {
        Filter localFilter = (Filter)localIterator.next();
        if ((localFilter != null) && (!StringUtils.isEmpty(localFilter.getProperty())))
          if ((localFilter.getOperator() == Filter.Operator.eq) && (localFilter.getValue() != null))
          {
            if ((localFilter.getIgnoreCase() != null) && (localFilter.getIgnoreCase().booleanValue()) && ((localFilter.getValue() instanceof String)))
              localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localCriteriaBuilder.lower(localRoot.get(localFilter.getProperty())), ((String)localFilter.getValue()).toLowerCase()));
            else
              localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.equal(localRoot.get(localFilter.getProperty()), localFilter.getValue()));
          }
          else if ((localFilter.getOperator() == Filter.Operator.ne) && (localFilter.getValue() != null))
          {
            if ((localFilter.getIgnoreCase() != null) && (localFilter.getIgnoreCase().booleanValue()) && ((localFilter.getValue() instanceof String)))
              localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.notEqual(localCriteriaBuilder.lower(localRoot.get(localFilter.getProperty())), ((String)localFilter.getValue()).toLowerCase()));
            else
              localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.notEqual(localRoot.get(localFilter.getProperty()), localFilter.getValue()));
          }
          else if ((localFilter.getOperator() == Filter.Operator.gt) && (localFilter.getValue() != null))
            localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.gt(localRoot.get(localFilter.getProperty()), (Number)localFilter.getValue()));
          else if ((localFilter.getOperator() == Filter.Operator.lt) && (localFilter.getValue() != null))
            localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.lt(localRoot.get(localFilter.getProperty()), (Number)localFilter.getValue()));
          else if ((localFilter.getOperator() == Filter.Operator.ge) && (localFilter.getValue() != null))
            localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.ge(localRoot.get(localFilter.getProperty()), (Number)localFilter.getValue()));
          else if ((localFilter.getOperator() == Filter.Operator.le) && (localFilter.getValue() != null))
            localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.le(localRoot.get(localFilter.getProperty()), (Number)localFilter.getValue()));
          else if ((localFilter.getOperator() == Filter.Operator.like) && (localFilter.getValue() != null) && ((localFilter.getValue() instanceof String)))
            localPredicate = localCriteriaBuilder.and(localPredicate, localCriteriaBuilder.like(localRoot.get(localFilter.getProperty()), (String)localFilter.getValue()));
          else if ((localFilter.getOperator() == Filter.Operator.in) && (localFilter.getValue() != null))
            localPredicate = localCriteriaBuilder.and(localPredicate, localRoot.get(localFilter.getProperty()).in(new Object[] { localFilter.getValue() }));
          else if (localFilter.getOperator() == Filter.Operator.isNull)
            localPredicate = localCriteriaBuilder.and(localPredicate, localRoot.get(localFilter.getProperty()).isNull());
          else if (localFilter.getOperator() == Filter.Operator.isNotNull)
            localPredicate = localCriteriaBuilder.and(localPredicate, localRoot.get(localFilter.getProperty()).isNotNull());
      }
    }
    paramCriteriaQuery.where(localPredicate);
  }

  private void IIIlllII(CriteriaQuery<T> paramCriteriaQuery, List<net.shopxx.Order> paramList)
  {
    if ((paramCriteriaQuery == null) || (paramList == null) || (paramList.isEmpty()))
      return;
    Root localRoot = IIIllIlI(paramCriteriaQuery);
    if (localRoot == null)
      return;
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    ArrayList localArrayList = new ArrayList();
    if (!paramCriteriaQuery.getOrderList().isEmpty())
      localArrayList.addAll(paramCriteriaQuery.getOrderList());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      net.shopxx.Order localOrder = (net.shopxx.Order)localIterator.next();
      if (localOrder.getDirection() == Order.Direction.asc)
        localArrayList.add(localCriteriaBuilder.asc(localRoot.get(localOrder.getProperty())));
      else if (localOrder.getDirection() == Order.Direction.desc)
        localArrayList.add(localCriteriaBuilder.desc(localRoot.get(localOrder.getProperty())));
    }
    paramCriteriaQuery.orderBy(localArrayList);
  }

  private void IIIlllII(CriteriaQuery<T> paramCriteriaQuery, Pageable paramPageable)
  {
    if ((paramCriteriaQuery == null) || (paramPageable == null))
      return;
    Root localRoot = IIIllIlI(paramCriteriaQuery);
    if (localRoot == null)
      return;
    CriteriaBuilder localCriteriaBuilder = this.IIIllIlI.getCriteriaBuilder();
    ArrayList localArrayList = new ArrayList();
    if (!paramCriteriaQuery.getOrderList().isEmpty())
      localArrayList.addAll(paramCriteriaQuery.getOrderList());
    if ((StringUtils.isNotEmpty(paramPageable.getOrderProperty())) && (paramPageable.getOrderDirection() != null))
      if (paramPageable.getOrderDirection() == Order.Direction.asc)
        localArrayList.add(localCriteriaBuilder.asc(localRoot.get(paramPageable.getOrderProperty())));
      else if (paramPageable.getOrderDirection() == Order.Direction.desc)
        localArrayList.add(localCriteriaBuilder.desc(localRoot.get(paramPageable.getOrderProperty())));
    if (paramPageable.getOrders() != null)
    {
      Iterator localIterator = paramPageable.getOrders().iterator();
      while (localIterator.hasNext())
      {
        net.shopxx.Order localOrder = (net.shopxx.Order)localIterator.next();
        if (localOrder.getDirection() == Order.Direction.asc)
          localArrayList.add(localCriteriaBuilder.asc(localRoot.get(localOrder.getProperty())));
        else if (localOrder.getDirection() == Order.Direction.desc)
          localArrayList.add(localCriteriaBuilder.desc(localRoot.get(localOrder.getProperty())));
      }
    }
    paramCriteriaQuery.orderBy(localArrayList);
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.dao.impl.BaseDaoImpl
 * JD-Core Version:    0.6.2
 */