package com.srts.system.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.system.domain.Sys_Department;

public interface DepartmentDao extends BaseDao<Sys_Department> {

	List<Sys_Department> findTopDepartmentList();

	List<Sys_Department> findChildDepartmentByParentId(long parentId);

}
