package com.balintimes.MMMS.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.balintimes.MMMS.IRepository.IBaseRepository;

//@Repository(value = "baseRepository")
public abstract class BaseRepository<T extends Serializable> implements
		IBaseRepository<T>
{

	// 取得当前 T 的类，方法体中最好不要获取T.class
	public abstract Class<T> getClazz();

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager()
	{
		return this.entityManager;
	}

	@Override
	public boolean del(T obj)
	{
		if (!getEntityManager().contains(obj))
			obj = getEntityManager().merge(obj);
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
		int parameterIndex = 0;
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
		// Query query = getEntityManager().createQuery(
		// "from " + this.getClazz() + " where " + fieldName + "=?");
		query.setParameter(1, value);

		List result = query.getResultList();
		if (result.size() > 0)
		{
			return (T) result.get(0);
		}
		return null;
	}

	@Override
	public List query(String scope)
	{
		return query(scope, null);
	}

	@Override
	public List query(String scope, Collection paras)
	{
		return query(scope, null, -1, -1);
	}

	@Override
	public List query(String scope, Collection paras, int begin, int max)
	{
		String sqlString = "from " + this.getClazz().getSimpleName();

		if (scope.length() > 0)
		{
			sqlString += " where " + scope;
		}
		Query query = getEntityManager().createQuery(sqlString);
		int parameterIndex = 0;
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
		return query.getResultList();
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
		int parameterIndex = 0;
		if (paras != null && paras.size() > 0)
		{
			for (Object obj : paras)
			{
				query.setParameter(parameterIndex++, obj);
			}
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
		return query.getResultList();
	}
}
