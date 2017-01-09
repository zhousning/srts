package com.srts.estimate.dao.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.estimation.dao.WorkerOnlineExerciseEstDao;
import com.srts.estimation.dao.WorkerOnlineStudyEstDao;
import com.srts.examination.dao.QuestionBankManageDao;
import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.BookChapter;
import com.srts.system.domain.Sys_User;

public class workerKlgBankEstimateDaoTest {
	private ApplicationContext act;
	private WorkerOnlineExerciseEstDao dao;
		
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (WorkerOnlineExerciseEstDao) act.getBean("workerOnlineExerciseEstDaoImpl");
		
	}
	
	@Test
	public void selectAccuracyRateByUserToMonthTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectAccuracyRateByUserToMonth(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
			System.out.println(resList.get(i)[3]);
		}
	}
	@Test
	public void selectAccuracyRateByUserToWeekTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectAccuracyRateByUserToWeek(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
			System.out.println(resList.get(i)[3]);
		}
	}
	@Test
	public void selectAccuracyRateByUserTodayTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectAccuracyRateByUserToday(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
			System.out.println(resList.get(i)[3]);
		}
	}
	@Test
	public void selectExerciseFeqByUserTodayTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectExerciseFeqByUserToday(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
		}
	}
	@Test
	public void selectExerciseFeqByUserToWeekTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectExerciseFeqByUserToWeek(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
		}
	}
	@Test
	public void selectExerciseFeqByUserToMonthTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectExerciseFeqByUserToMonth(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
		}
	}
	@Test
	public void selectExerciseContentByUserAndTimeAreaTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectExerciseContentByUserAndTimeArea(usr, "day");
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
		}
		List<String[]> resList1=dao.selectExerciseContentByUserAndTimeArea(usr, "week");
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList1.get(i)[0]);
			System.out.println(resList1.get(i)[1]);
			System.out.println(resList1.get(i)[2]);
		}
		List<String[]> resList2=dao.selectExerciseContentByUserAndTimeArea(usr, "month");
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList2.get(i)[0]);
			System.out.println(resList2.get(i)[1]);
			System.out.println(resList2.get(i)[2]);
		}
	}
	@Test
	public void selectExerciseFeqByUserPerMonthTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectExerciseFeqByUserPerMonth(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
		}
	}
	@Test
	public void selectAccuracyRateByUserPerMonthTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.selectAccuracyRateByUserPerMonth(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
		}
	}
}
