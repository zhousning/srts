package com.srts.examination.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.dao.AnswerSheetEvaDao;
import com.srts.examination.po.AnswerSheetDispPo;
import com.srts.examination.po.AnswerSheetListPo;
import com.srts.examination.po.TestPaperListPo;

public class AnswerSheetDispDaoTest {
	private ApplicationContext act;
	private AnswerSheetEvaDao dao;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (AnswerSheetEvaDao) act.getBean("answerSheetEvaDaoImpl");
		}
	
	@Test
	public void findAnswerSheetDispByAnswerSheetIdTest()
	{
		init();
		List<AnswerSheetDispPo> list=dao.findAnswerSheetDispByAnswerSheetId(52);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getQuestionId());
			System.out.println(list.get(i).getQuestionScore());
			System.out.println(list.get(i).getQuestionType());
			System.out.println(list.get(i).getAnswerTrue());
			System.out.println(list.get(i).getUserAnswer());
			System.out.println(list.get(i).getAnswerSheetId());
		}
	}
	@Test
	public void findAnswerSheetListByTestPaperIdTest()
	{
		init();
		List<AnswerSheetListPo> list=dao.findAnswerSheetListByTestPaperId(2);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getTestName());
			System.out.println(list.get(i).getTestPaperName());
			System.out.println(list.get(i).getAnswerSheetId());
			System.out.println(list.get(i).getUserName());
			System.out.println(list.get(i).getWorkno());
			System.out.println(list.get(i).getAnswerSheetId());
		}
	}
	@Test
	public void findAllTestPaperTest()
	{
		init();
		List<TestPaperListPo> list=dao.findAllTestPaper();
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getTestName());
			System.out.println(list.get(i).getTestPaperId());
			System.out.println(list.get(i).getTestPaperName());
		}
	}
	@Test
	public void findQuestionScoreTest()
	{
		init();
		int res=dao.findQuestionScore(2, "单选题");
		System.out.println(res);
	}
	@Test
	public void insertIntoUserTestScoreTest()
	{
		init();
		int res=dao.insertIntoUserTestScore(90, "非补考", 22, 6);
		System.out.println(res);
	}

}
