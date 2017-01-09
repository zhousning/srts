package com.srts.learning.dao.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.examination.service.MockTestService;
import com.srts.examination.service.TrainTestService;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;

public class MockTestServiceTest {
	@Test
	public void testFindUserTestScoreByUserAndType(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		MockTestService mockTestService = (MockTestService) act.getBean("mockTestServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(10);
		String resString=mockTestService.findUserTestScoreByUserAndType(usr);
		System.out.println(resString);
	}
	@Test
	public void testFindUserTestScoreRankByUserAndType(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		MockTestService mockTestService = (MockTestService) act.getBean("mockTestServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		String resString=mockTestService.findUserTestScoreRankByUserAndType(usr);
		System.out.println(resString);
	}
	@Test
	public void testFindUserTestScoreStablilityByUserAndType(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		MockTestService mockTestService = (MockTestService) act.getBean("mockTestServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		String resString=mockTestService.findUserTestScoreStablilityByUserAndType(usr);
		System.out.println(resString);
	}
	@Test
	public void dispCategoryUserTestScoreTest(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		MockTestService mockTestService = (MockTestService) act.getBean("mockTestServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		String resString=mockTestService.dispCategoryUserTestScore(usr);
		System.out.println(resString);
	}
	@Test
	public void findTestPaperQuestionTest(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		MockTestService mockTestService = (MockTestService) act.getBean("mockTestServiceImpl");
		Train train=new Train();
		train.setId(1);
		String major="运维检修";
		String type="模拟";
		List<QuestionBank> list=mockTestService.findTestPaperQuestion(train, major, type);
		Iterator<QuestionBank> iterator=list.iterator();
		while(iterator.hasNext())
		{
			QuestionBank question=iterator.next();
			System.out.println(question.getId()+"id");
			System.out.println(question.getType()+"type");
			System.out.println(question.getAnswer()+"answer");
			System.out.println(question.getContent()+"content");
		}
	}
	@Test
	public void compareUserAnswerAndTestPaperAnswerTest(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		MockTestService mockTestService = (MockTestService) act.getBean("mockTestServiceImpl");
        Sys_User usr=new Sys_User();
        usr.setId(10);
        long testPaperId=1;
		List<String[]> list=mockTestService.compareUserAnswerAndTestPaperAnswer(usr, testPaperId);
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			String[] compare=iterator.next();
			System.out.println(compare[0]);
			System.out.println(compare[1]);
			System.out.println(compare[2]);
			System.out.println(compare[3]);
			System.out.println(compare[4]);
		}
	}
	@Test
	public void findTestPaperIdByUserTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		MockTestService mockTestService = (MockTestService) act.getBean("mockTestServiceImpl");
		Sys_User usr=new Sys_User();
        usr.setId(10);
		List<Long> list = mockTestService.findTestPaperIdByUser(usr);
		Iterator<Long> iterator=list.iterator();
		while(iterator.hasNext())
		{
			long id=iterator.next();
			System.out.println(id);
		}
	}
//	@Test
//	public void findUserAndTestInfoTest()
//	{
//		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MockTestService mockTestService = (MockTestService) act.getBean("mockTestServiceImpl");
//		Sys_User usr=new Sys_User();
//		usr.setId(1);
//		long id = 10;
//		List<String> list = new ArrayList<String>();
//		list=mockTestService.findUserAndTestInfo(usr, id);
//		Iterator<String> iterator=list.iterator();
//		while(iterator.hasNext())
//		{
//			String s=iterator.next();
//			System.out.println(s);
//		}
//	}

}
