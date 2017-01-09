package com.srts.learning.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.system.domain.Sys_Department;
import com.srts.system.service.DepartmentService;


public class DepartmentTest {

	private ApplicationContext act;
	private DepartmentService depService;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		depService =  (DepartmentService) act.getBean("departmentServiceImpl");
	}
	
	@Test
	public void findTopDepartmentList() {
		init();
	List<Sys_Department> departments=depService.findTopDepartmentList();
	Iterator<Sys_Department> iterator=departments.iterator();
	while (iterator.hasNext()) {
		Sys_Department sysDepartment = (Sys_Department) iterator.next();
		System.out.println(sysDepartment.getName());
	}
	}
	@Test
	public void findChildDepartmentByParentId() {
		init();
		long pId=11l;
		List<Sys_Department> departments=depService.findChildDepartmentByParentId(pId);
		if (departments.size()>0) {
			System.out.println("有子部门");
			Iterator<Sys_Department> iterator=departments.iterator();
			while (iterator.hasNext()) {
				Sys_Department sysDepartment = (Sys_Department) iterator.next();
				System.out.println(sysDepartment.getName());
			}
		}else {
			System.out.println("无子部门");
		}
		
		
	}
	
}
