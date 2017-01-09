package com.srts.estimate.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.estimation.po.UserEstimatePo;
import com.srts.estimation.po.UserInfoPo;
import com.srts.estimation.service.WorkerOnlineStudyEstService;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.po.MockTestAnalysisPo;
import com.srts.examination.po.TestInfoPo;
import com.srts.examination.service.MockTestService;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;



public class WorkerOnlineStudyEstServiceTest {
	private ApplicationContext act;
	private WorkerOnlineStudyEstService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (WorkerOnlineStudyEstService) act.getBean("workerOnlineStudyEstServiceImpl");
	}
	@Test
	public void setMyStudyTimeLengthInfoCurrentDayTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<UserInfoPo> resList=service.setMyStudyTimeLengthInfoCurrentDay(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i).getAveStudyTimeLength());
			System.out.println(resList.get(i).getCourse());
			System.out.println(resList.get(i).getId());
			System.out.println(resList.get(i).getType());
			System.out.println(resList.get(i).getUserUsedTimeLength());
		}
	}
	@Test
	public void setMyStudyTimeLengthInfoCurrentWeekTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<UserInfoPo> resList=service.setMyStudyTimeLengthInfoCurrentWeek(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i).getAveStudyTimeLength());
			System.out.println(resList.get(i).getCourse());
			System.out.println(resList.get(i).getId());
			System.out.println(resList.get(i).getType());
			System.out.println(resList.get(i).getUserUsedTimeLength());
		}
	}
	@Test
	public void setMyStudyTimeLengthInfoCurrentMonthTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<UserInfoPo> resList=service.setMyStudyTimeLengthInfoCurrentMonth(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i).getAveStudyTimeLength());
			System.out.println(resList.get(i).getCourse());
			System.out.println(resList.get(i).getId());
			System.out.println(resList.get(i).getType());
			System.out.println(resList.get(i).getUserUsedTimeLength());
		}
	}
	@Test
	public void getTimeLengthStringTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(4);
		String res=service.getTimeLengthString(usr);
		System.out.println(res);
	}
	@Test
	public void setUserEstimateInfoCurrentDayTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(4);
		List<UserEstimatePo> resList=service.setUserEstimateInfoCurrentDay(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i).getId());
			System.out.println(resList.get(i).getType());
			System.out.println(resList.get(i).getEstimateInfo());
		}
	}
	@Test
	public void setUserEstimateInfoCurrentMonthTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(4);
		List<UserEstimatePo> resList=service.setUserEstimateInfoCurrentMonth(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i).getEstimateInfo());
			System.out.println(resList.get(i).getId());
			System.out.println(resList.get(i).getType());
		}
	}
	@Test
	public void setUserEstimateInfoCurrentWeekTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(4);
		List<UserEstimatePo> resList=service.setUserEstimateInfoCurrentWeek(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i).getEstimateInfo());
			System.out.println(resList.get(i).getId());
			System.out.println(resList.get(i).getType());
		}
	}
}
