package com.srts.controlPanel;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.controlPanel.service.PersonPasswordChangeService;
import com.srts.controlPanel.service.PersonalInfoListService;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.UserService;

public class PasswordServiceTest {
	private ApplicationContext act;
	private PersonPasswordChangeService service;
	private UserService userService;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (PersonPasswordChangeService) act.getBean("personPasswordChangeServiceImpl");
		userService = (UserService) act.getBean("userServiceImpl");
	}
	@Test
	public void updateUserPasswordTest()
	{
		init();
		Sys_User usr=userService.getUserById(1);
		String res=service.updateUserPassword(usr, "199164xzy");
		System.out.println(res);
	}

}
