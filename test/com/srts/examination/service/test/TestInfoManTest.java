package com.srts.examination.service.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.TestInfo;
import com.srts.examination.service.TestInfoManService;


public class TestInfoManTest {
	private ApplicationContext act;
	private TestInfoManService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (TestInfoManService) act.getBean("testInfoManServiceImpl");	
	}
	
	@Test
	public void getExamPlan(){
		init();
		List<TestInfo> testInfos=service.getExamPlan();
		Iterator<TestInfo> iterator=testInfos.iterator();
		while (iterator.hasNext()) {
			TestInfo testInfo = (TestInfo) iterator.next();
			System.out.println(testInfo.getTestName()+"*****"+testInfo.getTestDate());		
		}
	}
	
	@Test
	public void getUserNowExam(){
		init();
		long userId=1l;
		TestInfo testInfo=service.getUserNowExam(userId);
		if (testInfo!=null) {
			System.out.println(testInfo.getTestDate()+"*****"+testInfo.getTestName());
		}
		
	}
	
	@Test
	public void findAllTestByTime(){
		init();
		List<TestInfo> testInfos=null;
		testInfos=service.findAllTestByTime();
		
		for (TestInfo testInfo : testInfos) {
			System.out.println(testInfo.getTestName()+"&&&&&"+testInfo.getTestDate());
		}
	}
	
}
