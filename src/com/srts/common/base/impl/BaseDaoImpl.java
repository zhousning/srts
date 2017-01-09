package com.srts.common.base.impl;

import java.lang.reflect.ParameterizedType;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.BaseDao;

/**
 * 所用实体类提取出的公用方法实现，包括增删改查
 * 
 * @author 薄小永
 */
@Transactional
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;

	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	public void save(T entity) {
		getSession().save(entity);
	}

	/**
	 * 删除实体
	 * 
	 * @param entity
	 */
	public void delete(Long id) {
		Object obj = getSession().get(clazz, id);
		getSession().delete(obj);
	}

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		getSession().merge(entity);
	}

	/**
	 * 根据ID获取单个实体
	 * 
	 * @param entity
	 */
	public T getById(Long id) {
		return (T) getSession().get(clazz, id);
	}

	/**
	 * 根据ID获取多个实体
	 * 
	 * @param entity
	 */
	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}
		return getSession().createCriteria(clazz).add(
				Restrictions.in("id", ids)).list();
	}

	/**
	 * 获取所有实体
	 * 
	 * @param entity
	 */
	public List<T> findAll() {
		return getSession().createCriteria(clazz).list();
	}

	/**
	 * 获取当前session
	 * 
	 * @param entity
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 获取当前SessionFactory
	 * 
	 * @param entity
	 */
	protected SessionFactory getFactory() {

		return sessionFactory;
	}
}
