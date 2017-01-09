package com.srts.learning.dao.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.service.TrainTestService;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_Department;
import com.srts.system.domain.Sys_User;

public class TrainTestServiceTest {
	@Test
	public void testFindUserTestScoreByUserAndType(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		TrainTestService trainTestService = (TrainTestService) act.getBean("trainTestServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		String resString=trainTestService.findUserTestScoreByUserAndType(usr);
		System.out.println(resString);
	}
	@Test
	public void testFindUserTestScoreRankByUserAndType(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		TrainTestService trainTestService = (TrainTestService) act.getBean("trainTestServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		String resString=trainTestService.findUserTestScoreRankByUserAndType(usr);
		System.out.println(resString);
	}
	@Test
	public void testFindUserTestScoreStablilityByUserAndType(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		TrainTestService trainTestService = (TrainTestService) act.getBean("trainTestServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		String resString=trainTestService.findUserTestScoreStablilityByUserAndType(usr);
		System.out.println(resString);
	}
	@Test
	public void dispCategoryUserTestScoreTest(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		TrainTestService trainTestService = (TrainTestService) act.getBean("trainTestServiceImpl");
		Sys_User usr = new Sys_User();
		usr.setId(1);
		String resString=trainTestService.dispCategoryUserTestScore(usr);
		System.out.println(resString);
	}
	@Test
	public void findTestPaperQuestionTest(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		TrainTestService trainTestService = (TrainTestService) act.getBean("trainTestServiceImpl");
		Train train=new Train();
		train.setId(1);
		String major="运维检修1";
		String type="正式";
		List<QuestionBank> list=trainTestService.findTestPaperQuestion(train, major, type);
		Iterator<QuestionBank> iterator=list.iterator();
		while(iterator.hasNext())
		{
			QuestionBank question=iterator.next();
			System.out.println(question.getId());
			System.out.println(question.getType());
			//System.out.println(question.getBookChapter());
			System.out.println(question.getAnswer());
			System.out.println(question.getContent());
		}
	}
	@Test
	public void compareUserAnswerAndTestPaperAnswerTest(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		TrainTestService trainTestService = (TrainTestService) act.getBean("trainTestServiceImpl");
        Sys_User usr=new Sys_User();
        usr.setId(1);
        long testPaperId=10;
		List<String[]> list=trainTestService.compareUserAnswerAndTestPaperAnswer(usr, testPaperId);
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
		TrainTestService trainTestService = (TrainTestService) act.getBean("trainTestServiceImpl");
		Sys_User usr=new Sys_User();
        usr.setId(10);
		List<Long> list = trainTestService.findTestPaperIdByUser(usr);
		Iterator<Long> iterator=list.iterator();
		while(iterator.hasNext())
		{
			long id=iterator.next();
			System.out.println(id);
		}
	}
	@Test
	public void findUserAndTestInfoTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		TrainTestService trainTestService = (TrainTestService) act.getBean("trainTestServiceImpl");
		long id = 1;
		Sys_Department dept=new Sys_Department();
		dept.setId(2);
		Sys_User usr=new Sys_User((long)1,"李庆","admin","运维检修工区","1","张三","1","1","1","1","1","1","1","1","50",dept);
		List<String> list = new ArrayList<String>();
		list=trainTestService.findUserAndTestInfo(usr, id);
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext())
		{
			String s=iterator.next();
			System.out.println(s);
		}
	}
}
