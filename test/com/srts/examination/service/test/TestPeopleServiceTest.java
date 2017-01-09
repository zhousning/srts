package com.srts.examination.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.service.TestInfoManService;
import com.srts.examination.service.TestPeopleService;
import com.srts.system.domain.Sys_User;

public class TestPeopleServiceTest {

	private ApplicationContext act;
	private TestPeopleService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (TestPeopleService) act.getBean("testPeopleServiceImpl");	
	}
	
	@Test
	public void createNameList() {
		init();
		String names="1,2,3,";
		service.createNameList(names, 2);
	}
	
	@Test
	public void exporNameList(){
		init();
		List<Sys_User> users=service.getTestPeoples(128l);
		for(int i=0;i<users.size();i++){
			System.out.println(users.get(i).getName());
		}
	}
}
