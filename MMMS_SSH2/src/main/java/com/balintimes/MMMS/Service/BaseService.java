package com.balintimes.MMMS.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType; 

import com.balintimes.MMMS.IRepository.IBaseRepository;
import com.balintimes.MMMS.IService.IBaseService;

@Transactional(value = TxType.REQUIRED)
public abstract class BaseService<T extends Serializable> implements
		IBaseService<T>
{

	// protected IBaseRepository<T> repository;
	public abstract IBaseRepository<T> getRepository();

	@Override
	@Transactional(value = TxType.REQUIRED)
	public boolean save(T obj)
	{
		return this.getRepository().save(obj);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public boolean update(T obj)
	{
		return this.getRepository().update(obj);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public boolean del(T obj)
	{
		return this.getRepository().del(obj);
	}

	@Override
	public T get(Serializable id)
	{
		return this.getRepository().get(id);
	}

	@Override
	public T getBy(String fieldName, Serializable value)
	{
		return this.getRepository().getBy(fieldName, value);
	}

	@Override
	public List<T> query(String scope)
	{
		return this.getRepository().query(scope);
	}

	@Override
	public List<T> query(String scope, Collection paras)
	{
		return this.getRepository().query(scope, paras);
	}

	@Override
	public List<T> query(String scope, Collection paras, int begin, int max)
	{
		return this.getRepository().query(scope, paras, begin, max);
	}

	@Override
	public Object uniqueResult(String sql)
	{
		return this.getRepository().uniqueResult(sql);
	}

	@Override
	public Object uniqueResult(String sql, Collection paras)
	{
		return this.getRepository().uniqueResult(sql, paras);
	}

	@Override
	public int execute(String sql)
	{
		return this.getRepository().execute(sql);
	}

	@Override
	public int execute(String sql, Collection paras)
	{
		return this.execute(sql, paras);
	}

	@Override
	public List execNameQuery(String nameQuery, List<Object> params)
	{
		return this.getRepository().execNameQuery(nameQuery, params);
	}

	@Override
	public List execNameQuery(String nameQuery, Map<String, Object> params)
	{
		return this.getRepository().execNameQuery(nameQuery, params);
	}
}
