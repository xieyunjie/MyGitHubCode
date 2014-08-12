package iCaster.Service;

import iCaster.IRepository.IBaseRepository;
import iCaster.IService.IBaseService;
import iCaster.Tuple.DataTuple;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
 

public abstract class BaseService<T extends Serializable> implements
		IBaseService<T>
{

	// protected IBaseRepository<T> repository;
	public abstract IBaseRepository<T> getRepository();

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean save(T obj)
	{
		return this.getRepository().save(obj);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean update(T obj)
	{
		return this.getRepository().update(obj);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean del(T obj)
	{
		return this.getRepository().del(obj);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public T get(Serializable id)
	{
		return this.getRepository().get(id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public T getBy(String fieldName, Serializable value)
	{
		return this.getRepository().getBy(fieldName, value);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<T> query(String scope)
	{
		return this.getRepository().query(scope);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<T> query(String scope, Collection paras)
	{
		return this.getRepository().query(scope, paras);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<T> query(String scope, Collection paras, int begin, int max)
	{
		return this.getRepository().query(scope, paras, begin, max);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Object uniqueResult(String sql)
	{
		return this.getRepository().uniqueResult(sql);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Object uniqueResult(String sql, Collection paras)
	{
		return this.getRepository().uniqueResult(sql, paras);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int execute(String sql)
	{
		return this.getRepository().execute(sql);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int execute(String sql, Collection paras)
	{
		return this.execute(sql, paras);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List execNameQuery(String nameQuery, List<Object> params)
	{
		return this.getRepository().execNameQuery(nameQuery, params);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List execNameQuery(String nameQuery, Map<String, Object> params)
	{
		return this.getRepository().execNameQuery(nameQuery, params);
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public DataTuple<Integer, List<T>> queryDataTuple(String scope, Collection paras, int begin, int max)
	{
		return this.getRepository().queryDataTuple(scope, paras, begin, max);
	}
}
