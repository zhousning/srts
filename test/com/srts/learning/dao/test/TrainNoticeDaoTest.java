package com.srts.learning.dao.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.dao.CompetitionDao;
import com.srts.examination.domain.Competition;
import com.srts.examination.domain.QuestionBank;
import com.srts.information.dao.TrainNoticeDao;
import com.srts.system.domain.Sys_User;

public class TrainNoticeDaoTest {
	private ApplicationContext act;
	private TrainNoticeDao dao;
	//private StudyCourseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (TrainNoticeDao) act.getBean("trainNoticeDaoImpl");
		//service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
	}
	@Test
	public void addTrainTest()
	{
		init();
		int res=dao.addTrain(50);
		System.out.println(res);
	}
	
}
