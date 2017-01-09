package com.srts.controlPanel;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.controlPanel.dao.PersonPasswordChangeDao;
import com.srts.system.domain.Sys_User;

public class PasswordTest {
	private ApplicationContext act;
	private PersonPasswordChangeDao dao;
		
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (PersonPasswordChangeDao) act.getBean("personPasswordChangeDaoImpl");	
	}
	@Test
	public void updateUserPasswordTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		String res=dao.updateUserPassword(usr, "123456");
		System.out.println(res);
	}

}
