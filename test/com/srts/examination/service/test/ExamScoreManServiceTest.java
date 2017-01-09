package com.srts.examination.service.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.UserTestScore;
import com.srts.examination.service.ExamScoreManService;
import com.srts.examination.service.TestInfoManService;

public class ExamScoreManServiceTest {
	private ApplicationContext act;
	private ExamScoreManService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (ExamScoreManService) act.getBean("examScoreManServiceImpl");	
	}
	
	@Test
	public void findScoresByTestPaperId() {
		init();
		List<UserTestScore> scores=service.findScoresByTestPaperId(1l);
		Iterator<UserTestScore> iterator=scores.iterator();
		while (iterator.hasNext()) {
			UserTestScore userTestScore = (UserTestScore) iterator.next();
			System.out.println(userTestScore.getUsr().getName()+"****"+userTestScore.getGrade());
		}
	}
	
	@Test
	public void findScoresByCon(){
		init();
		List<UserTestScore> list=null;
		String examDate="2014-10-15";
		String userName="";
		String depName=null;
		String con=">70";
		long testPaperId=1l;
		list=service.findScoresByCon(examDate, userName, depName, con,testPaperId);	
		Iterator<UserTestScore> iterator=list.iterator();
		while (iterator.hasNext()) {
			UserTestScore userTestScore = (UserTestScore) iterator.next();
			System.out.println(userTestScore.getGrade()+"***"+userTestScore.getUsr().getName());
		}
	}
}
