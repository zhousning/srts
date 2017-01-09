package com.srts.system.service;

import java.util.List;

import com.srts.system.domain.Sys_Department;

public interface DepartmentService {

	public List<Sys_Department> findAllDepartment();

	public List<Sys_Department> findTopDepartmentList();
	
	public List<Sys_Department> findChildDepartmentByParentId(long parentId);

	public Sys_Department getParentById(Long depParentId);

	public void saveDepartment(Sys_Department department);

	public Sys_Department getDepById(Long depId);

	public void updateDep(Sys_Department department);

	public void deleteDepById(Long depId);
}
