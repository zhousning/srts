package com.srts.learning.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.examination.service.QuestionBankManageService;
import com.srts.knowledge.domain.BookChapter;

public class QuestionBankManageServiceTest {
	@Test
	public void deleteQuestionByIdTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		long id=10;
		int res=questionBankManageService.deleteQuestionById(id);
		System.out.println(res);
	}
	@Test
	public void findAllQuestionTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		List<String[]> list=questionBankManageService.findAllQuestion();
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findAllQuestionUpdateTimeTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		List<String[]> list=questionBankManageService.findAllQuestionUpdateTimeDesc();
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findAllQuestionUploadTimeTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		List<String[]> list=questionBankManageService.findAllQuestionUploadTimeDesc();
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findQuestionByIdTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		QuestionBank question=questionBankManageService.findQuestionById(100);
		System.out.println(question.getId());
		System.out.println(question.getType());
		System.out.println(question.getContent());
		System.out.println(question.getAnswer());
		//System.out.println(question.getBookChapter());
		
	}
	@Test
	public void findQuestionByKeyWordsTest()
	{
		String key="工作票";
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		List<String[]> list=questionBankManageService.findQuestionByKeyWords(key);
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findQuestionByTypeTest()
	{
		String type="单选题";
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		List<String[]> list=questionBankManageService.findQuestionByType(type);
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findQuestionByTypeAndKeyWordsTest()
	{
		String type="单选题";
		String key="工作票";
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		List<String[]> list=questionBankManageService.findQuestionByTypeAndKeyWords(type, key);
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void insertQuestionBankTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		String type="问答题";
		String content="hsalfncLSN";
		String answer="hsjcjnasudcb";
		String questionPic="hsjcjnasudcb";
		String uploadTime="2014-05-30";
		String lastUpdateTime="2014-07-05";
		String bookName="安规";
		String chapterNum="第三章";
		BookChapter bookChapter=new BookChapter();
		bookChapter.setId(1);
		int res=questionBankManageService.insertQuestionBank(type, content, answer, bookName, chapterNum, questionPic, uploadTime, lastUpdateTime, 4);
		System.out.println(res);
	}
	@Test
	public void updateQuestionBankTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		String content="ceshi";
		String answer="ceshi";
		int res1=questionBankManageService.updateQuestionAnswerById(71, answer);
		int res2=questionBankManageService.updateQuestionContentById(71, content,4);
		System.out.println(res1);
		System.out.println(res2);
	}
	@Test
	public void findUpdateTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		String res1=questionBankManageService.findUploadQuestionNumPerKind();
		String res2=questionBankManageService.findUploadQuestionNumPerMonth();
		System.out.println(res1);
		System.out.println(res2);
	}
	@Test
	public void findTopFiveQuestionOrderByUploadTimeTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		List<String[]> list=questionBankManageService.findTopFiveQuestionOrderByUploadTime();
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findTopFiveQuestionOrderBylastUpdateTimeTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		List<String[]> list=questionBankManageService.findTopFiveQuestionOrderBylastUpdateTime();
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findQuestionNumByTypeTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		List<String[]> list=questionBankManageService.findQuestionNumByType();
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			for(int i=0;i<objs.length;i++){
				System.out.println(i+":"+objs[i]);
			}
			
//			for(Object ojb:objs){
//				if(ojb!=null){
//				System.out.println(ojb.toString());
//				}
//			}
		}
	}
	@Test
	public void findUploadQuestionNumPerMonthTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		String res=questionBankManageService.findUploadQuestionNumPerMonth();
		System.out.println(res);
	}
	@Test
	public void findUploadQuestionNumPerKindTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestionBankManageService questionBankManageService = (QuestionBankManageService) act.getBean("questionBankManageServiceImpl");
		String res=questionBankManageService.findUploadQuestionNumPerKind();
		System.out.println(res);
	}
}
