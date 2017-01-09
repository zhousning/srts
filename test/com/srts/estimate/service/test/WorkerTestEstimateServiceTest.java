package com.srts.estimate.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.estimation.po.UserTestEstimateInfoPo;
import com.srts.estimation.service.WorkerTestEstimateService;
import com.srts.estimation.service.WorkerTrainTestEstimateService;
import com.srts.system.domain.Sys_User;

public class WorkerTestEstimateServiceTest {
	
	private ApplicationContext act;
	private WorkerTestEstimateService service;
	private WorkerTrainTestEstimateService service1;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (WorkerTestEstimateService) act.getBean("workerTestEstimateServiceImpl");
		service1 = (WorkerTrainTestEstimateService) act.getBean("workerTrainTestEstimateServiceImpl");
	}
	
	@Test
	public void dispCategoryUserTestScoreTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(4);
		String res=service.dispCategoryUserTestScore(usr);
		System.out.println(res);
	}
	@Test
	public void findUserTestScoreByUserAndTypeTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		String res=service.findUserTestScoreByUserAndType(usr);
		System.out.println(res);
	}
	@Test
	public void findUserTestScoreStablilityByUserAndTypeTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(4);
		String res=service.findUserTestScoreStablilityByUserAndType(usr);
		System.out.println(res);
	}
	@Test
	public void setUserTestEstimateInfoTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(4);
		List<UserTestEstimateInfoPo> res=service.setUserTestEstimateInfo(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getType());
			System.out.println(res.get(i).getEstimateString());
		}
	}
	
	@Test
	public void setUserTrainTestEstimateInfoTest()
	{
		init();
		Sys_User usr =new Sys_User();
		usr.setId(1);
		List<UserTestEstimateInfoPo> res=service1.setUserTestEstimateInfo(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getType());
			System.out.println(res.get(i).getEstimateString());
		}
	}

}
