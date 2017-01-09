package com.srts.estimate.dao.test;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.estimation.dao.WorkerCmncEstimateDao;
import com.srts.estimation.dao.WorkerWholeEstimateDao;
import com.srts.system.domain.Sys_User;

public class workerWholeEstimateDaoTest {
	
	private ApplicationContext act;
	private WorkerWholeEstimateDao dao;
		
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (WorkerWholeEstimateDao) act.getBean("workerWholeEstimateDaoImpl");
		
	}
	
	@Test
	public void getAveStudySumTimeToNowTest() throws ParseException
	{
		init();
		long id = 4;
		Sys_User usr=new Sys_User();
		usr.setId(id);
		List<String[]> resList=dao.getAveStudySumTimeToNow(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void getExerciseAccuracyRateToNowTest()
	{
		init();
		long id = 4;
		Sys_User usr=new Sys_User();
		usr.setId(id);
		List<String[]> resList=dao.getExerciseAccuracyRateToNow(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
		}
	}
	@Test
	public void getExerciseAmountToNowTest()
	{
		init();
		long id = 4;
		Sys_User usr=new Sys_User();
		usr.setId(id);
		List<String[]> resList=dao.getExerciseAmountToNow(usr);
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
		long id = 4;
		Sys_User usr=new Sys_User();
		usr.setId(id);
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
		long id = 4;
		Sys_User usr=new Sys_User();
		usr.setId(id);
		List<String[]> resList=dao.selectWorkerProCmncAmount(usr);
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
		long id = 4;
		Sys_User usr=new Sys_User();
		usr.setId(id);
		List<String[]> resList=dao.selectWorkerStuCmncAmount(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void workerKlgSearchEstTest()
	{
		init();
		long id = 4;
		Sys_User usr=new Sys_User();
		usr.setId(id);
		List<String[]> resList=dao.workerKlgSearchEst(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void workerOpExpUploadTest()
	{
		init();
		long id = 4;
		Sys_User usr=new Sys_User();
		usr.setId(id);
		List<String[]> resList=dao.workerOpExpUpload(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void findUserTestScoreByUserAndTypeTest()
	{
		init();
		long id = 4;
		Sys_User usr=new Sys_User();
		usr.setId(id);
		List<String[]> resList=dao.findUserTestScoreByUserAndType(usr,"正式");
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void findUserTestScoreStabilityTest()
	{
		init();
		long id = 4;
		Sys_User usr=new Sys_User();
		usr.setId(id);
		List<String[]> resList=dao.findUserTestScoreStability(usr,"正式");
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}

}
