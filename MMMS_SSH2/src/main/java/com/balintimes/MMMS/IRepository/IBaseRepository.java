package com.balintimes.MMMS.IRepository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IBaseRepository<T extends Serializable>
{
	/**
	 * �Ѷ��󱣴浽�־ò�
	 * 
	 * @param obj
	 * @return ������ɹ����򷵻�true�����򷵻�false
	 * @throws IdExistException
	 */
	boolean save(T obj);

	/**
	 * ���³־ò��еĶ���
	 * 
	 * @param obj
	 * @return ���޸ĳɹ����򷵻�true�����򷵻�false
	 */
	boolean update(T obj);

	/**
	 * ɾ���־ò��еĶ���
	 * 
	 * @param obj
	 * @return ��ɾ�������ɹ����򷵻�true�����򷵻�false
	 */
	boolean del(T obj);

	/**
	 * �����༰�������ض���
	 * 
	 * @param id
	 * @return �����ҵ�ָ������ֵ�ĳ־ö����򷵻ظö��󣬷��򷵻�null
	 */
	T get(Serializable id);

	/**
	 * �����ࡢ�ֶ������ֶ�ֵ���ض���ֻ����һ�����������Ķ���
	 * 
	 * @param fieldName
	 * @param value
	 * @return ����ѯ��ָ�����Լ�ֵ�ĳ־ö����򷵻ظö��󣬷��򷵻�null
	 */
	T getBy(String fieldName, Serializable value);

	/**
	 * ����������ѯ����
	 * 
	 * @param scope
	 *            ��ѯ����
	 * @return ���ز�ѯ�ļ�¼�����¼
	 */
	List<T> query(String scope);

	/**
	 * ��������������������ѯ����
	 * 
	 * @param scope
	 *            ��ѯ����
	 * @param paras
	 *            ��ѯ����
	 * @return ���ز�ѯ�ļ�¼�����
	 */
	List<T> query(String scope, Collection paras);

	/**
	 * ��ѯ���������Ķ��󣬴�begin��ʼȡmax����¼
	 * 
	 * @param scope
	 *            ��ѯ����
	 * @param paras
	 *            ��ѯ����
	 * @param begin
	 *            ������Ч�����ʼ��¼��
	 * @param max
	 *            ���ص�����¼��
	 * @return ���ز�ѯ�ļ�¼�����
	 */
	List<T> query(String scope, Collection paras, int begin, int max);

	/**
	 * ִ��sql��䣬������һ������,��select count(*) from tableName��
	 * 
	 * @param sql
	 *            sql���
	 * @return ���ز�ѯ�������û�н���򷵻�null
	 */
	Object uniqueResult(String sql);

	/**
	 * ����sql��估��ѯ����ִ�в�ѯ��������һ��Ψһ������select count(*) from tableName where filed=?
	 * 
	 * @param sql
	 * @param paras
	 * @return ���ص�һ�Ĳ�ѯ�������û�н���򷵻�null
	 */
	Object uniqueResult(String sql, Collection paras);

	/**
	 * ִ������sql��䣬������Ӱ��ļ�¼��
	 * 
	 * @param sql
	 *            sql���
	 * @return ������Ӱ��ļ�¼��
	 */
	int execute(String sql);

	/**
	 * ����sql��估����ִ�����ݿ������������Ӱ��ļ�¼��
	 * 
	 * @param sql
	 *            sql���
	 * @param paras
	 *            ����
	 * @return ������Ӱ��ļ�¼��
	 */
	int execute(String sql, Collection paras);

	/**
	 * @param nameQuery
	 *            ����
	 * @param params
	 *            �����б�
	 * @return Object���
	 */
	List execNameQuery(String nameQuery, List<Object> params);

	/**
	 * @param nameQuery
	 *            ����
	 * @param params
	 *            Map�����б�
	 * @return Object���
	 */
	List execNameQuery(String nameQuery, Map<String, Object> params);
}
