package com.srts.controlPanel;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.srts.controlPanel.dao.PersonalInfoListDao;
import com.srts.estimation.dao.CompanyEstimateDao;
import com.srts.examination.domain.TestInfo;
import com.srts.system.dao.Sys_UserDao;
import com.srts.system.domain.Sys_User;

public class PersonInfoListDaoTest {
	private ApplicationContext act;
	private PersonalInfoListDao dao;
	private Sys_UserDao userDao;
		
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (PersonalInfoListDao) act.getBean("personalInfoListDaoImpl");
		userDao = (Sys_UserDao) act.getBean("sys_UserDaoImpl");
		
	}
	@Test
	public void selectNoticeByUserTest()
	{
		init();
		Sys_User usr=userDao.getById((long)25);
		List<String[]> resList=dao.selectNoticeByUser(usr);
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectTrainTestInfoByUserTest()
	{
		init();
		Sys_User usr=userDao.getById((long)1);
		List<String[]> resList=dao.selectTrainTestInfoByUser(usr);
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectMockTestInfoByUserTest()
	{
		init();
		Sys_User usr=userDao.getById((long)1);
		List<String[]> resList=dao.selectMockTestInfoByUser(usr);
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectCompetitionInfoByUserTest()
	{
		init();
		Sys_User usr=userDao.getById((long)1);
		List<String[]> resList=dao.selectCompetitionInfoByUser(usr);
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectCourseInfoByUserTest()
	{
		init();
		Sys_User usr=userDao.getById((long)4);
		List<String[]> resList=dao.selectCourseInfoByUser(usr);
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectFavorCourseTest()
	{
		init();
		Sys_User usr=userDao.getById((long)1);
		List<String[]> resList=dao.selectFavorCourse();
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectExerciseInfoByUserTest()
	{
		init();
		Sys_User usr=userDao.getById((long)1);
		List<String[]> resList=dao.selectExerciseInfoByUser(usr);
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectKlgBankInfoByUserTest()
	{
		init();
		Sys_User usr=userDao.getById((long)1);
		List<String[]> resList=dao.selectKlgBankInfoByUser(usr);
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectFavorKlgBankTest()
	{
		init();
		Sys_User usr=userDao.getById((long)1);
		List<String[]> resList=dao.selectFavorKlgBank();
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectProblemInfoByUserTest()
	{
		init();
		Sys_User usr=userDao.getById((long)1);
		List<String[]> resList=dao.selectProblemInfoByUser(usr);
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectAnswerInfoByUserTest()
	{
		init();
		Sys_User usr=userDao.getById((long)1);
		List<String[]> resList=dao.selectAnswerInfoByUser(usr);
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectThemeByUserTest()
	{
		init();
		Sys_User usr=userDao.getById((long)1);
		List<String[]> resList=dao.selectThemeByUser(usr);
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
	@Test
	public void selectFavorThemeByUserTest()
	{
		init();
		Sys_User usr=userDao.getById((long)1);
		List<String[]> resList=dao.selectFavorThemeByUser();
		for(int i=0;i<resList.size();i++)
		{
			for(int j=0;j<resList.get(i).length;j++)
			{
			System.out.println(resList.get(i)[j]);
			}
		}
	}
}
