package iCaster.Repository;

import iCaster.Annotation.EntityL2Cache;
import iCaster.Annotation.Interceptor;
import iCaster.IRepository.IBaseRepository;
import iCaster.Tuple.DataTuple;
import iCaster.Tuple.TupleUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.primefaces.expression.impl.ThisExpressionResolver;

public abstract class BaseRepository<T extends Serializable> implements
		IBaseRepository<T>
{

	// 取得当前 T 的类，方法体中最好不要获取T.class
	public abstract Class<T> getClazz();

	/*
	 * @PersistenceContext
	 * private EntityManager entityManager;
	 */

	@Inject
	private EntityManager entityManager;
	
	private boolean enableL2Cache()
	{
		EntityL2Cache l2Cache = this.getClazz().getAnnotation(EntityL2Cache.class);
		if (l2Cache != null && l2Cache.value() == true)
		{
			return true;
		}
		return false;
	}

	public EntityManager getEntityManager()
	{
		return this.entityManager;
	}

	@Override
	public boolean del(T obj)
	{
		if (!getEntityManager().contains(obj))
		{
			obj = getEntityManager().merge(obj);
		}
		getEntityManager().remove(obj);
		return true;
	}

	@Override
	public int execute(String sql)
	{
		return execute(sql, null);
	}

	@Override
	public int execute(String sql, Collection paras)
	{
		Query query = getEntityManager().createNativeQuery(sql);
		int parameterIndex = 1;
		if (paras != null && paras.size() > 0)
		{
			for (Object obj : paras)
			{
				query.setParameter(parameterIndex++, obj);
			}
		}
		return query.executeUpdate();
	}

	@Override
	public T get(Serializable id)
	{
		return getEntityManager().find(this.getClazz(), id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getBy(String fieldName, Serializable value)
	{

		String sql = String.format("from %s where %s = ?1", this.getClazz().getSimpleName(), fieldName);
		Query query = getEntityManager().createQuery(sql); 
		query.setParameter(1, value);
		
		if (this.enableL2Cache() == true)
		{
			query.setHint("org.hibernate.cacheable", true);
		}
		
		List result = query.getResultList();
		if (result.size() > 0)
		{
			return (T) result.get(0);
		}
		return null;
	}

	@Override
	public List<T> query(String scope)
	{
		List<Object> argList = null;
		return this.query(scope, argList);
	}

	@Override
	public List<T> query(String scope, Collection paras)
	{
		return query(scope, paras, -1, -1);
	}

	@Override
	public List<T> query(String scope, Object... args)
	{
		if (args.length == 0)
		{
			return this.query(scope);
		}
		else
		{
			List<Object> argList = new LinkedList<Object>();
			for (Object object : args)
			{
				argList.add(object);
			}

			return this.query(scope, argList);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> query(String scope, Collection paras, int begin, int max)
	{
		String sqlString = "from " + this.getClazz().getSimpleName();

		if (scope.length() > 0)
		{
			sqlString += " where " + scope;
		}

		Query query = getEntityManager().createQuery(sqlString);  
		
		int parameterIndex = 1;
		if (paras != null && paras.size() > 0)
		{
			for (Object obj : paras)
			{
				query.setParameter(parameterIndex++, obj);
			}
		}
		if (begin >= 0 && max > 0)
		{
			query.setFirstResult(begin);
			query.setMaxResults(max);
		}
		
		if (this.enableL2Cache() == true)
		{
			query.setHint("org.hibernate.cacheable", true);
		}
		
		return (List<T>) query.getResultList();
	}

	@Override
	public boolean save(T obj)
	{
		getEntityManager().persist(obj);
		return true;
	}

	@Override
	public Object uniqueResult(String sql)
	{
		return uniqueResult(sql, null);
	}

	@Override
	public Object uniqueResult(String sql, Collection paras)
	{
		Query query = getEntityManager().createQuery(sql);
		int parameterIndex = 1;
		if (paras != null && paras.size() > 0)
		{
			for (Object obj : paras)
			{
				query.setParameter(parameterIndex++, obj);
			}
		}
		if (this.enableL2Cache() == true)
		{
			query.setHint("org.hibernate.cacheable", true);
		}
		return query.getSingleResult();
	}

	@Override
	public boolean update(T obj)
	{
		getEntityManager().merge(obj);
		return true;
	}

	@Override
	public List execNameQuery(String nameQuery, List<Object> params)
	{
		Query query = this.getEntityManager().createNamedQuery(nameQuery);

		if (params != null && params.size() > 0)
		{
			int n = 0;
			for (int i = 0; i < params.size(); i++)
			{
				n = i + 1;
				query.setParameter(n, params.get(i));
			}
		}
		if (this.enableL2Cache() == true)
		{
			query.setHint("org.hibernate.cacheable", true);
		}

		return query.getResultList();

	}

	@Override
	public List execNameQuery(String nameQuery, Map<String, Object> params)
	{
		Query query = this.getEntityManager().createNamedQuery(nameQuery);

		if (params != null && params.size() > 0)
		{
			for (String keyString : params.keySet())
			{
				query.setParameter(keyString, params.get(keyString));
			}
		}
		if (this.enableL2Cache() == true)
		{
			query.setHint("org.hibernate.cacheable", true);
		}
		return query.getResultList();
	}

	@Override
	public List execNameQuery(String nameQuery, Object... params)
	{
		Query query = this.getEntityManager().createNamedQuery(nameQuery);

		if (params != null && params.length > 0)
		{
			int n = 0;
			for (int i = 0; i < params.length; i++)
			{
				n = i + 1;
				query.setParameter(n, params[i]);
			}
		}
		if (this.enableL2Cache() == true)
		{
			query.setHint("org.hibernate.cacheable", true);
		}
		return query.getResultList();
	}

	public DataTuple<Integer, List<T>> queryDataTuple(String scope, Collection paras, int begin, int max)
	{
		String sqlString = "from " + this.getClazz().getSimpleName();

		if (scope.length() > 0)
		{
			sqlString += " where " + scope;
		}

		List<T> data = new ArrayList<T>(0);
		int count = 0;
		Query query = getEntityManager().createQuery(sqlString);

		int parameterIndex = 1;
		if (paras != null && paras.size() > 0)
		{
			for (Object obj : paras)
			{
				query.setParameter(parameterIndex++, obj);
			}
		} 
		count = query.getResultList().size();

		if (begin >= 0 && max > 0)
		{
			query.setFirstResult(begin);
			query.setMaxResults(max);
		}
		
		if (this.enableL2Cache() == true)
		{
			query.setHint("org.hibernate.cacheable", true);
		}
		data = (List<T>) query.getResultList();

		return TupleUtil.DataTuple(count, data);
	}
}
