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
import com.srts.system.domain.Sys_User;

public class CompetitionDaoTest {
	private ApplicationContext act;
	private CompetitionDao dao;
	//private StudyCourseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (CompetitionDao) act.getBean("competitionDaoImpl");
		//service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
	}
	@Test
	public void findCompetitionGradeByUserTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(25);
		List<Competition> list=dao.findCompetitionGradeByUser(usr);
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
	public void findCompetitionRankRightNowTest()
	{
		init();
		String CurrentTime="2014-04";
		List<Competition> list=dao.findCompetitionRankRightNow(CurrentTime);
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
	public void findHistoricalCompetitionRankTest()
	{
		init();
		//String CurrentTime="2014-04";
		List<Competition> list=dao.findHistoricalCompetitionRank();
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
	public void findQuestionByIdTest()
	{
		init();
		long id=1;
		QuestionBank question=dao.findQuestionById(id);
		System.out.println(question.getId());
		System.out.println(question.getType());
		System.out.println(question.getContent());
		System.out.println(question.getAnswer());
		System.out.println(question.getBookChapter());
	}
	@Test
	public void findHistoricalCompetitionRankByUserTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(25);
		int res=dao.findHistoricalCompetitionRankByUser(usr);
		System.out.println(res);
	}
	@Test
	public void findCompetitionRankRightNowByUserTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(25);
		String CurrentTime="2014-12";
		int res=dao.findCompetitionRankRightNowByUser(usr, CurrentTime);
		System.out.println(res);
	}
	@Test
	public void insertCompetitionErrorTest()
	{
		init();
		String errorAnswer="D";
		String errorDate="2014-06-15";
		Sys_User usr=new Sys_User();
		usr.setId(1);
		QuestionBank errorQuestion=new QuestionBank();
		errorQuestion.setId(1);
		int res=dao.insertCompetitionError(errorAnswer, errorDate, usr, errorQuestion);
		System.out.println(res);
	}
	@Test
	public void insertCompetitionTest()
	{
		init();
		int grade=98;
		String comp_date="2014-06-15";
		int comp_time=133;
		Sys_User usr=new Sys_User();
		usr.setId(14);
		QuestionBank errorQuestion=new QuestionBank();
		errorQuestion.setId(1);
		int res=dao.insertCompetition(grade, comp_date, comp_time, usr);
		System.out.println(res);
	}
	@Test
	public void findRecentFiveCompetitionErrorTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(25);
		List list=dao.findRecentFiveCompetitionError(usr);
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
    public void findCompetitionLastGradeByUserTest()
    {
    	init();
		Sys_User usr=new Sys_User();
		usr.setId(25);
		int res=dao.findCompetitionLastGradeByUser(usr);
		System.out.println(res);
    }
    @Test
    public void findCompetitionMaxGradeByUserTest()
    {
    	init();
		Sys_User usr=new Sys_User();
		usr.setId(25);
		int res=dao.findCompetitionMaxGradeByUser(usr);
		System.out.println(res);
    }
    @Test
	public void deleteByQuestionIdTest()
	{
		init();
		int res=dao.deleteCompetitionErrorByQuestionId(5);
		System.out.println(res);
	}
}
