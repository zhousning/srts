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

import com.srts.estimation.dao.WorkerOnlineStudyEstDao;
import com.srts.examination.dao.QuestionBankManageDao;
import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.BookChapter;
import com.srts.system.domain.Sys_User;

public class workOnlineStudyEstDaoTest {
	private ApplicationContext act;
	private WorkerOnlineStudyEstDao dao;
		
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (WorkerOnlineStudyEstDao) act.getBean("workerOnlineStudyEstDaoImpl");
		
	}
	
	@Test
	public void selectWorkerStudyInfoByUserTest()
	{
		init();
		Sys_User usr = new Sys_User();
		usr.setId(4);
		List list = dao.selectWorkerStudyInfoByUser(usr);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
					System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void selectWorkerStudyInfoByCourseTest()
	{
		init();
		Sys_User usr = new Sys_User();
		usr.setId(4);
		List list = dao.selectWorkerStudyInfoByCourse(1);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
					System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void selectCourseTest()
	{
		init();
		Sys_User usr = new Sys_User();
		usr.setId(4);
		List list = dao.selectCourse();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object objs =iterator.next();
					System.out.println(objs);
		}
	}
	@Test
	public void selectPeopleTest()
	{
		init();
		Sys_User usr = new Sys_User();
		usr.setId(4);
		List list = dao.selectPeople();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object objs = iterator.next();
					System.out.println(objs);
		}
	}
	@Test
	public void getUserStudySumTimeByCurrentDayTest()
	{
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.getUserStudySumTimeByCurrentDay(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
		}
	}
	@Test
	public void getUserStudySumTimeByMonthTest(){
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(4);
		List<String[]> resList=dao.getUserStudySumTimeByCurrentMonth(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
		}
	}
	@Test
	public void getUserStudySumTimeByWeekTest(){
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(4);
		List<String[]> resList=dao.getUserStudySumTimeByCurrentWeek(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
			System.out.println(resList.get(i)[2]);
		}
	}
	@Test
	public void getAveStudyTimeTodayByCourseTest(){
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.getAveStudyTimeTodayByCourse();
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void getAveStudyTimeToMonthByCourseTest(){
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.getAveStudyTimeToMonthByCourse();
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void getAveStudyTimeToWeekByCourseTest(){
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.getAveStudyTimeToWeekByCourse();
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void getUserStudySumTimeToNowPerMonthTest(){
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<String[]> resList=dao.getUserStudySumTimeToNowPerMonth(usr);
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
	@Test
	public void getAveStudySumTimeToNowPerMonthTest(){
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(4);
		List<String[]> resList=dao.getAveStudySumTimeToNowPerMonth();
		for(int i=0;i<resList.size();i++)
		{
			System.out.println(resList.get(i)[0]);
			System.out.println(resList.get(i)[1]);
		}
	}
}
