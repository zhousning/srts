package com.srts.learning.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.dao.QuestionBankManageDao;
import com.srts.examination.dao.TrainTestDao;
import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.BookChapter;
import com.srts.system.domain.Sys_User;

public class QuestionBankManageDaoTest {
	private ApplicationContext act;
	private QuestionBankManageDao dao;
	//private StudyCourseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (QuestionBankManageDao) act.getBean("questionBankManageDaoImpl");
		//service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
	}
	@Test
	public void findQuestionByIdTest()
	{
		init();
		long id=100;
		QuestionBank question=dao.findQuestionById(id);
		System.out.println(question.getId());
		System.out.println(question.getType());
		System.out.println(question.getContent());
		System.out.println(question.getQuestionPic());
		System.out.println(question.getAnswer());
		//System.out.println(question.getBookChapter());
	}
	@Test
	public void findAllQuestionTest()
	{
		init();
		List<QuestionBank> list=dao.findAllQuestion();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
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
		init();
		String type="问答题";
		List<QuestionBank> list=dao.findQuestionByType(type);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
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
		init();
		String type="问答题";
		String content="hsalfncLSN";
		String answer="hsjcjnasudcb";
		String questionPic="hsjcjnasudcb";
		String uploadTime="2014-05-30";
		String lastUpdateTime="2014-07-05";
		int selectOptions=4;
		BookChapter bookChapter=new BookChapter();
		bookChapter.setId(1);
		int res=dao.insertQuestionBank(type, content, answer, bookChapter, questionPic, uploadTime, lastUpdateTime, selectOptions);
		System.out.println(res);	
	}
	@Test
	public void deleteQuestionByIdTest()
	{
		init();
		long id=7;
		int res=dao.deleteQuestionById(id);
		System.out.println(res);
	}
	@Test
	public void updateQuestionContentByIdTest()
	{
		init();
		long id=71;
		String content="ceshi";
		//String answer="ceshi";
		int res=dao.updateQuestionContentById(id, content);
		System.out.println(res);
	}
	@Test
	public void updateLastUpdateTimeByIdTest()
	{
		init();
		long id=71;
		String lastUpdateTime="2014-07-06";
		int res=dao.updateLastUpdateTimeById(id, lastUpdateTime);
		System.out.println(res);
	}
	@Test
	public void updateQuestionAnswerByIdTest()
	{
		init();
		long id=70;
		//String content="ceshi";
		String answer="ceshi";
		int res=dao.updateQuestionAnswerById(id, answer);
		System.out.println(res);
	}
	@Test
	public void findQuestionByKeyWordsTest()
	{
		init();
		String key="工作票";
		List<QuestionBank> list=dao.findQuestionByKeyWords(key);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
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
		init();
		String type="单选题";
		String key="工作票";
		List<QuestionBank> list=dao.findQuestionByTypeAndKeyWords(type,key);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
    public void findUploadQuestionNumPerKindTest()
    {
    	init();
    	Sys_User usr=new Sys_User();
    	usr.setId(1);
		String currentTime="2014-5";
		List<Integer> list=dao.findUploadQuestionNumPerKind(currentTime);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}
	@Test
    public void findUploadQuestionNumPerMonthTest()
    {
    	init();
    	Sys_User usr=new Sys_User();
    	usr.setId(1);
		String currentTime="2014-05";
		List<Integer> list=dao.findUploadQuestionNumPerMonth(currentTime);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}
	@Test
    public void findQuestionNumByTypeTest()
    {
    	init();
		List<Integer> list=dao.findQuestionNumByType();
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}
	@Test
	public void findTopFiveQuestionOrderByUploadTimeTest()
	{
		init();
		List<QuestionBank> list=dao.findTopFiveQuestionOrderByUploadTime();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
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
		init();
		List<QuestionBank> list=dao.findTopFiveQuestionOrderBylastUpdateTime();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
}
