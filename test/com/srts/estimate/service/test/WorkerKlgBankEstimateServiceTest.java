package com.srts.estimate.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.estimation.po.UserExeAcurInfoPo;
import com.srts.estimation.po.UserExeEstimatePo;
import com.srts.estimation.po.UserExeFeqInfoPo;
import com.srts.estimation.po.UserKlgBankSearchEstPo;
import com.srts.estimation.po.UserKlgBankSearchRecordPo;
import com.srts.estimation.service.WorkerKlgBankEstimateService;
import com.srts.estimation.service.WorkerOnlineExerciseEstService;
import com.srts.system.domain.Sys_User;

public class WorkerKlgBankEstimateServiceTest {
	private ApplicationContext act;
	private WorkerKlgBankEstimateService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (WorkerKlgBankEstimateService) act.getBean("workerKlgBankEstimateServiceImpl");
	}
	@Test
	public void setUserExerciseFrequencyInfoTest()
	{
		init();
		String startDate="2014-01-01";
		String endDate="2014-12-31";
		String type="条文导学";
		Sys_User usr =new Sys_User();
		usr.setId(1);
		List<UserKlgBankSearchRecordPo> res=service.findWorkerKlgSearchRecord(usr, startDate, endDate, type);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getSearchdate());
			System.out.println(res.get(i).getContent1());
			System.out.println(res.get(i).getContent2());
			System.out.println(res.get(i).getContent3());
		}
	}
	@Test
	public void workerKlgSearchEstTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.workerKlgSearchEst(usr);
		System.out.println(res);
	}
	@Test
	public void workerKlgSearchEstToMonthTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.workerKlgSearchEstToMonth(usr);
		System.out.println(res);
	}
	@Test
	public void workerKlgSearchEstToWeekTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.workerKlgSearchEstToWeek(usr);
		System.out.println(res);
	}
	@Test
	public void workerKlgSearchEstTodayTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.workerKlgSearchEstToday(usr);
		System.out.println(res);
	}
	@Test
	public void workerOpExpUploadToMonthTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.workerOpExpUploadToMonth(usr);
		System.out.println(res);
	}
	@Test
	public void workerOpExpUploadToWeekTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.workerOpExpUploadToWeek(usr);
		System.out.println(res);
	}
	@Test
	public void workerOpExpUploadTodayTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.workerOpExpUploadToday(usr);
		System.out.println(res);
	}
	@Test
	public void setUserKlgBankEstimateInfoPoTest()
	{
		init();
		String startDate="2014-01-01";
		String endDate="2014-12-31";
		String type="条文导学";
		Sys_User usr =new Sys_User();
		usr.setId(1);
		List<UserKlgBankSearchEstPo> res=service.setUserKlgBankEstimateInfoPo(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getType());
			System.out.println(res.get(i).getEstimateString());
		}
	}



}
