package com.srts.estimate.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.estimation.dao.WorkerCmncEstimateDao;
import com.srts.system.domain.Sys_User;

public class workerCmncEstimateDaoTest {
	
	private ApplicationContext act;
	private WorkerCmncEstimateDao dao;
		
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (WorkerCmncEstimateDao) act.getBean("workerCmncEstimateDaoImpl");
		
	}
	
	@Test
	public void selectWorkerAcpRatePerMonthTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectWorkerAcpRatePerMonth(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void selectWorkerProCmncAcpTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectWorkerProCmncAcp(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void selectWorkerProCmncAmountTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectWorkerProCmncAmount(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void selectWorkerProCmncAmountToMonthTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectWorkerProCmncAmountToMonth(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void selectWorkerProCmncAmountToWeek()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectWorkerProCmncAmountToWeek(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void selectWorkerStuCmncAmountTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectWorkerStuCmncAmount(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void selectWorkerStuCmncAmountToMonthTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectWorkerStuCmncAmountToMonth(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void selectWorkerStuCmncAmountToWeekTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectWorkerStuCmncAmountToWeek(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}

}
