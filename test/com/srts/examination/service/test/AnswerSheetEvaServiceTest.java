package com.srts.examination.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.po.AnswerSheetDispPo;
import com.srts.examination.po.AnswerSheetListPo;
import com.srts.examination.po.TestPaperListPo;
import com.srts.examination.service.AnswerSheetEvaService;

public class AnswerSheetEvaServiceTest {
	private ApplicationContext act;
	private AnswerSheetEvaService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (AnswerSheetEvaService) act.getBean("answerSheetEvaServiceImpl");
	}
	@Test
	public void findAnswerSheetDispByAnswerSheetIdTest()
	{
		init();
		List<AnswerSheetDispPo> list=service.findAnswerSheetDispByAnswerSheetId(52);
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
		List<AnswerSheetListPo> list=service.findAnswerSheetListByTestPaperId(2);
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
	public void findAllTestPaper()
	{
		init();
		List<TestPaperListPo> list=service.findAllTestPaper();
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getTestName());
			System.out.println(list.get(i).getTestPaperId());
			System.out.println(list.get(i).getTestPaperName());
			System.out.println(list.get(i).getTestDate());
		}
	}
	@Test
	public void findQuestionScoreTest()
	{
		init();
		int res=service.findQuestionScore(2, "单选题");
		System.out.println(res);
	}
	@Test
	public void calculateChooseMark()
	{
		init();
		List<AnswerSheetDispPo> list=service.findAnswerSheetDispByAnswerSheetId(52);
		int res=service.calculateChooseMark(list);
		System.out.println(res);
	}
	@Test
	public void insertIntoUserTestScoreTest()
	{
		init();
		int res=service.insertIntoUserTestScore(90, "非补考", 22, 5);
		System.out.println(res);
	}

}
