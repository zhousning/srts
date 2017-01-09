package com.srts.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.system.dao.DepartmentDao;
import com.srts.system.domain.Sys_Department;
@Repository
@Transactional
public class DepartmentDaoImpl extends BaseDaoImpl<Sys_Department> implements DepartmentDao{

	//获取所有的顶级部门
	public List<Sys_Department> findTopDepartmentList() {
		return this.getSession().createQuery("from Sys_Department dep where dep.parentdept is null ").list();	
	}

	//按照父级部门的id获取相应的子部门
	@SuppressWarnings("unchecked")
	public List<Sys_Department> findChildDepartmentByParentId(long parentId) {
		String sql="from Sys_Department where parentdept.id="+parentId+"";
		return this.getSession().createQuery(sql).list();
	}

}
