package com.srts.estimate.service.test;

import java.text.ParseException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.estimation.service.WorkerWholeEstimateService;
import com.srts.system.domain.Sys_User;

public class WorkerWholeEstimateServiceTest {
	private ApplicationContext act;
	private WorkerWholeEstimateService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (WorkerWholeEstimateService) act.getBean("workerWholeEstimateServiceImpl");
	}
	
	@Test
	public void setTrainTestEstMarkTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res=service.setTrainTestEstMark(usr);
		System.out.println(res);
	}
	@Test
	public void setMockTestEstMarkTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res=service.setMockTestEstMark(usr);
		System.out.println(res);
	}
	@Test
	public void setCmncEstMarkTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res=service.setCmncEstMark(usr);
		System.out.println(res);
	}
	@Test
	public void setStudyEstMarkTest() throws ParseException
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res=service.setStudyEstMark(usr);
		System.out.println(res);
	}
	@Test
	public void setExerciseEstMarkTest() throws ParseException
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res=service.setExerciseEstMark(usr);
		System.out.println(res);
	}
	@Test
	public void setKlgBankEstMarkTest() throws ParseException
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		int res=service.setKlgBankEstMark(usr);
		System.out.println(res);
	}

}
