package com.srts.learning.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.system.dao.Sys_UserDao;
import com.srts.system.domain.Sys_User;

public class Sys_UserDaoTest {
	private ApplicationContext act;
	private Sys_UserDao dao;
	//private StudyCourseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (Sys_UserDao) act.getBean("sys_UserDaoImpl");
		//service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
	}
	@Test
	public void getUserByDepIds(){
		init();
		Long[] depsIds={2l,3l,5l,13l,14l};
		List<Sys_User> users=dao.getUserByDepIds(depsIds);
		System.out.println(users.size());
		Iterator<Sys_User> iterator=users.iterator();
		while (iterator.hasNext()) {
			Sys_User sysUser = (Sys_User) iterator.next();
			System.out.println(sysUser.getName());
		}
	}
	
	@Test
	public void getUserByDepId(){
		init();
		Long[] depsIds={2l,3l,5l,13l,14l};
		List<Sys_User> list=dao.getUserByDepId(2l);
		Iterator<Sys_User> iterator=list.iterator();
		while (iterator.hasNext()) {
			Sys_User sysUser = (Sys_User) iterator.next();
			System.out.println(sysUser.getName()+"***"+sysUser.getDepartment().getName());
		}

	}

}
