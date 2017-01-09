package com.srts.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.system.dao.DepartmentDao;
import com.srts.system.domain.Sys_Department;
import com.srts.system.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentDao departmentDao;

	public List<Sys_Department> findAllDepartment() {
		return departmentDao.findAll();
	}

	public List<Sys_Department> findTopDepartmentList() {
		return departmentDao.findTopDepartmentList();
	}

	public List<Sys_Department> findChildDepartmentByParentId(long parentId) {
		return departmentDao.findChildDepartmentByParentId(parentId);
	}

	public Sys_Department getParentById(Long depParentId) {
		return departmentDao.getById(depParentId);
	}

	public void saveDepartment(Sys_Department department) {
		departmentDao.save(department);
	}

	public Sys_Department getDepById(Long depId) {
		
		return departmentDao.getById(depId);
	}

	public void updateDep(Sys_Department department) {
		departmentDao.update(department);
	}

	public void deleteDepById(Long depId) {
		departmentDao.delete(depId);
	}
	
	


}
