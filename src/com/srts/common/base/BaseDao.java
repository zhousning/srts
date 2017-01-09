package com.srts.common.base;

import java.util.List;

/**
 * 所用实体类提取出的公用方法接口，包括增删改查
 * 
 * @author 薄小永
 */

public interface BaseDao<T> {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param entity
	 */
	void delete(Long id);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 根据ID获取单个实体
	 * 
	 * @param entity
	 */
	T getById(Long id);

	/**
	 * 根据ID获取多个实体
	 * 
	 * @param entity
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * 获取所有实体
	 * 
	 * @param entity
	 */
	List<T> findAll();

}