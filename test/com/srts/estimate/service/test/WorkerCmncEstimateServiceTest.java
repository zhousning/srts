package com.srts.estimate.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.estimation.po.UserCmncEstimatePo;
import com.srts.estimation.po.UserKlgBankSearchEstPo;
import com.srts.estimation.service.WorkerCmncEstimateService;
import com.srts.estimation.service.WorkerKlgBankEstimateService;
import com.srts.system.domain.Sys_User;

public class WorkerCmncEstimateServiceTest {
	private ApplicationContext act;
	private WorkerCmncEstimateService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (WorkerCmncEstimateService) act.getBean("workerCmncEstimateServiceImpl");
	}
	
	@Test
	public void selectWorkerProCmncAmountToWeekTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.selectWorkerProCmncAmountToWeek(usr);
		System.out.println(res);
	}
	@Test
	public void selectWorkerProCmncAmountToMonthTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.selectWorkerProCmncAmountToMonth(usr);
		System.out.println(res);
	}
	@Test
	public void selectWorkerProCmncAmountTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.selectWorkerProCmncAmount(usr);
		System.out.println(res);
	}
	@Test
	public void selectWorkerProCmncAcpTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.selectWorkerProCmncAcp(usr);
		System.out.println(res);
	}
	@Test
	public void selectWorkerAcpRatePerMonthTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.selectWorkerAcpRatePerMonth(usr);
		System.out.println(res);
	}
	@Test
	public void selectWorkerStuCmncAmountToWeekTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.selectWorkerStuCmncAmountToWeek(usr);
		System.out.println(res);
	}
	@Test
	public void selectWorkerStuCmncAmountToMonthTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.selectWorkerStuCmncAmountToMonth(usr);
		System.out.println(res);
	}
	@Test
	public void selectWorkerStuCmncAmountTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.selectWorkerStuCmncAmount(usr);
		System.out.println(res);
	}
	@Test
	public void setWorkerCmncEstimateInfoTest()
	{
		init();
		String startDate="2014-01-01";
		String endDate="2014-12-31";
		String type="条文导学";
		Sys_User usr =new Sys_User();
		usr.setId(1);
		List<UserCmncEstimatePo> res=service.setWorkerCmncEstimateInfo(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getType());
			System.out.println(res.get(i).getEstimateString());
		}
	}

}
