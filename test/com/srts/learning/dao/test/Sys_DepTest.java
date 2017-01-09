package com.srts.learning.dao.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.system.dao.DepartmentDao;
import com.srts.system.dao.Sys_UserDao;
import com.srts.system.domain.Sys_Department;

public class Sys_DepTest {

	private ApplicationContext act;
	private DepartmentDao departmentDao;
	//private StudyCourseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		departmentDao = (DepartmentDao) act.getBean("departmentDaoImpl");
		//service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
	}
	@Test
	public void getDepById(){
		init();
		Sys_Department department=departmentDao.getById(2l);
		System.out.println(department.getName());
	}
}
