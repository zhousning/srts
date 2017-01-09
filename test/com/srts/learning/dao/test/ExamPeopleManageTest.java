package com.srts.learning.dao.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.dao.TestPeopleDao;
import com.srts.system.dao.DepartmentDao;
import com.srts.system.domain.Sys_Department;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.DepartmentService;
import com.srts.system.service.UserService;

public class ExamPeopleManageTest {
	private ApplicationContext act;
	private DepartmentDao departmentDao;
	private UserService userService;
	private TestPeopleDao testPeopleDao;
	
	
	public void init() {
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		departmentDao = (DepartmentDao) act.getBean("departmentDaoImpl");
		userService = (UserService) act.getBean("userServiceImpl");
		testPeopleDao=(TestPeopleDao) act.getBean("testPeopleDaoImpl");
	}

	@Test
	public void getDepAndWorkers() {
		init();
		String depSelected="1,2,3,";
		String[] arr=depSelected.split(",");
		Long[] departmentIds=new Long[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			departmentIds[i]=Long.parseLong(arr[i]);
		}
		
		for (int i = 0; i < departmentIds.length; i++) {
			System.out.println(departmentIds[i]);
		}

		String depAndWorkers = "[";
		for (int i = 0; i < departmentIds.length; i++) {

			Sys_Department department = departmentDao.getById(departmentIds[i]);

			depAndWorkers += "{'dep':{'id':"+department.getId()+",'name':'" + department.getName() + "'},";

			List<Sys_User> users = userService.getUserByDepId(departmentIds[i]);

			depAndWorkers += "'worker':[";
			if (users!=null) {
				Iterator<Sys_User> iterator=users.iterator();
				
				while (iterator.hasNext()) {
					Sys_User sysUser = (Sys_User) iterator.next();
					long userId=sysUser.getId();
					System.out.println("userId="+userId);
					List<?> state=testPeopleDao.getStatistics(userId);
					Iterator<?> iterator2=state.iterator();
					String cou=null;
					String fail=null;
					while (iterator2.hasNext()) {
						Object[] object = (Object[]) iterator2.next();
						cou=object[1].toString();
						fail=object[3].toString();
					}
					System.out.println("start");
					if (cou==null) {
						cou="0";
					}
					if (fail==null) {
						fail="0";
					}
					depAndWorkers+="{'id':"+sysUser.getId()+",'name':'"+sysUser.getName()+"','age':'"+sysUser.getAge()+"','cou':'"+cou+"','fail':'"+fail+"'},";
				}
			}

			depAndWorkers += "]},";

		}
		depAndWorkers += "]";
		System.out.println(depAndWorkers);
	}
	@Test
	public void getStatistics() {
		init();
		List<?> list=testPeopleDao.getStatistics(1);
		Iterator<?> iterator=list.iterator();
		while (iterator.hasNext()) {
			Object[] objects=(Object[]) iterator.next();
			System.out.println(objects[0].toString()+":cou:"+objects[1].toString()+";fail:"+objects[3].toString());
		
		}
	}

}
