package com.srts.system.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.srts.common.base.impl.BaseActionImpl;
import com.srts.system.domain.Sys_Department;
import com.srts.system.service.DepartmentService;
import com.srts.utils.depUtils.DepartmentUtils;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseActionImpl<Sys_Department> {

	private List<Sys_Department> topDepList;
	private List<Sys_Department> departmentList;
	private Long depParentId;
	private Long depId;
	private String depName;
	private String depInfo;
	private String result;
	private Sys_Department department;

	@Resource
	private DepartmentService depService;

	/**
	 * 跳转到部门管理页面
	 */
	public String findTopDepList() {
		departmentList = new ArrayList<Sys_Department>();
		topDepList = depService.findTopDepartmentList();
		DepartmentUtils.printDepartmentTree(topDepList, "┣", departmentList);
		return "topDepList";
	}

	/**
	 * 添加部门
	 */
	public String addDepartment() {
		department = new Sys_Department();
		if (depParentId != null) {
			department.setParentdept(depService.getParentById(depParentId));
		}
		department.setName(depName);
		depService.saveDepartment(department);
		return "toList";
	}
	
	/**
	 * 根据部门id获取相应部门信息
	 */
	public String getDepById(){
		
		department=depService.getDepById(depId);
		long id=department.getId();
		long depParId;
		if (department.getParentdept()==null) {
			depParId=0;
		}else {
			depParId=department.getParentdept().getId();
		}
		
		String name=department.getName();
		
	depInfo="{'id':"+id+",'name':'"+name+"','parentId':"+depParId+"}";
		return "depInfo";
	}
	
	
	/**
	 * 修改部门信息
	 */
	public String updateDepartment() {
		Sys_Department department=depService.getDepById(depId);
 		if (depParentId!=null&&depParentId!=0) {
			Sys_Department parDepartment=depService.getDepById(depParentId);
			department.setParentdept(parDepartment);
		}
 		department.setName(depName);
 		
 		depService.updateDep(department);
 		
		return "toList";
	}
	
	/**
	 * 删除部门
	 */
	public String delete() {
		System.out.println(depId+"depId");
		if (depId!=null) {
			depService.deleteDepById(depId);
			result="{'k':'success'}";
		}else {
			result="{'k':'fail'}";
		}
		return "toFindTopList";
	}

	public Sys_Department getModel() {
		return null;
	}

	public void prepare() throws Exception {
	}

	public List<Sys_Department> getTopDepList() {
		return topDepList;
	}

	public void setTopDepList(List<Sys_Department> topDepList) {
		this.topDepList = topDepList;
	}

	public List<Sys_Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Sys_Department> departmentList) {
		this.departmentList = departmentList;
	}

	public Long getDepParentId() {
		return depParentId;
	}

	public void setDepParentId(Long depParentId) {
		this.depParentId = depParentId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Sys_Department getDepartment() {
		return department;
	}

	public void setDepartment(Sys_Department department) {
		this.department = department;
	}

	public Long getDepId() {
		return depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	public String getDepInfo() {
		return depInfo;
	}

	public void setDepInfo(String depInfo) {
		this.depInfo = depInfo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	

}
