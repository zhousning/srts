package com.srts.estimate.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.estimation.po.UserExeAcurInfoPo;
import com.srts.estimation.po.UserExeEstimatePo;
import com.srts.estimation.po.UserExeFeqInfoPo;
import com.srts.estimation.service.WorkerOnlineExerciseEstService;
import com.srts.system.domain.Sys_User;

public class WorkerOnlineExerciseEstServiceTest {
	private ApplicationContext act;
	private WorkerOnlineExerciseEstService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (WorkerOnlineExerciseEstService) act.getBean("workerOnlineExerciseEstServiceImpl");
	}
	@Test
	public void setUserExerciseFrequencyInfoTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		List<UserExeFeqInfoPo> res=service.setUserExerciseFrequencyInfo(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getTime());
			System.out.println(res.get(i).getAveExerciseQuestionNum());
			System.out.println(res.get(i).getExerciseFeq());
		}
	}
	@Test
	public void setUserExerciseToMonthAccuracyInfoTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		List<UserExeAcurInfoPo> res=service.setUserExerciseToMonthAccuracyInfo(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getTimeString());
			System.out.println(res.get(i).getCourseString());
			System.out.println(res.get(i).getAccuracyString());
		}
	}
	@Test
	public void setUserExerciseToWeekAccuracyInfoTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		List<UserExeAcurInfoPo> res=service.setUserExerciseToWeekAccuracyInfo(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getTimeString());
			System.out.println(res.get(i).getCourseString());
			System.out.println(res.get(i).getAccuracyString());
		}
	}
	@Test
	public void setUserExerciseTodayAccuracyInfoTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		List<UserExeAcurInfoPo> res=service.setUserExerciseTodayAccuracyInfo(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getTimeString());
			System.out.println(res.get(i).getCourseString());
			System.out.println(res.get(i).getAccuracyString());
		}
	}
	@Test
	public void setUserExerciseEstimateInfoToMonthTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		List<UserExeEstimatePo> res=service.setUserExerciseEstimateInfoToMonth(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getType());
			System.out.println(res.get(i).getExerciseContent());
			System.out.println(res.get(i).getEstimateString());
		}
	}
	@Test
	public void setUserExerciseEstimateInfoToWeekTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		List<UserExeEstimatePo> res=service.setUserExerciseEstimateInfoToWeek(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getType());
			System.out.println(res.get(i).getExerciseContent());
			System.out.println(res.get(i).getEstimateString());
		}
	}
	@Test
	public void setUserExerciseEstimateInfoTodayTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		List<UserExeEstimatePo> res=service.setUserExerciseEstimateInfoToday(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getType());
			System.out.println(res.get(i).getExerciseContent());
			System.out.println(res.get(i).getEstimateString());
		}
	}
	@Test
	public void setAccuracyStringTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.setAccuracyString(usr);
		System.out.println(res);
	}
	@Test
	public void setFeqStringTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.setFeqString(usr);
		System.out.println(res);
	}



}
