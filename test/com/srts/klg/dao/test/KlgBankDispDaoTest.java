package com.srts.klg.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.dao.KlgBankDispDao;
import com.srts.knowledge.dao.KlgBankListDao;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.dao.ErrorSetDao;
import com.srts.learning.dao.StudyCourseDao;
import com.srts.learning.po.ErrorSetAnswerPo;
import com.srts.learning.service.ErrorSetService;
import com.srts.learning.service.StudyCourseService;
import com.srts.system.domain.Sys_User;

public class KlgBankDispDaoTest {
	private ApplicationContext act;
	private KlgBankDispDao dao;
	//private StudyCourseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (KlgBankDispDao) act.getBean("klgBankDispDaoImpl");
		//service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
	}
	@Test
	public void insertCaseSearchRecordTest()
	{
		init();
		int res=dao.insertCaseSearchRecord((long)1,"2014-08-03", (long)1);
		System.out.println(res);
	}
	@Test
	public void updateCaseSearchnumTest()
	{
		init();
		int res=dao.updateCaseSearchnum((long)1);
		System.out.println(res);
	}
	
}
