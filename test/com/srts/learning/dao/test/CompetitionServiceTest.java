package com.srts.learning.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.examination.service.CompetitionService;
import com.srts.examination.service.QuestionBankManageService;
import com.srts.system.domain.Sys_User;

public class CompetitionServiceTest {
	@Test
	public void dispCompetitionGradeByUserTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompetitionService competitionService = (CompetitionService) act.getBean("competitionServiceImpl");
		Sys_User usr=new Sys_User();
		usr.setId(1);
		String resString=competitionService.dispCompetitionGradeByUser(usr);
		System.out.println(resString);
	}
	@Test
	public void findCompetitionRankRightNowTest()
	{
		String CurrentTime="2014-06";
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompetitionService competitionService = (CompetitionService) act.getBean("competitionServiceImpl");
		List<String[]> list=competitionService.findCompetitionRankRightNow(CurrentTime);
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
	public void findHistoricalCompetitionRankTest()
	{
		//String CurrentTime="2014-06";
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompetitionService competitionService = (CompetitionService) act.getBean("competitionServiceImpl");
		List<String[]> list=competitionService.findHistoricalCompetitionRank();
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
	public void findQuestionRandomlyTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompetitionService competitionService = (CompetitionService) act.getBean("competitionServiceImpl");
		QuestionBank question=competitionService.findQuestionRandomly();
		System.out.println(question.getId());
		System.out.println(question.getType());
		System.out.println(question.getContent());
		System.out.println(question.getAnswer());
	}
	@Test
	public void judgeTheAnswerTest()
	{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompetitionService competitionService = (CompetitionService) act.getBean("competitionServiceImpl");
		QuestionBank question=competitionService.findQuestionRandomly();
		String answer="A";
		int res=competitionService.judgeTheAnswer(question, answer);
		System.out.println(res);
	}
    @Test
    public void findCompetitionRankRightNowByUserTest()
    {
    	ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompetitionService competitionService = (CompetitionService) act.getBean("competitionServiceImpl");
    	Sys_User usr=new Sys_User();
    	usr.setId(1);
    	String CurrentTime="2014-06";
    	String res=competitionService.findCompetitionRankRightNowByUser(usr, CurrentTime);
    	System.out.println(res);
    }
    @Test
    public void findHistoricalCompetitionRankByUserTest()
    {
    	ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompetitionService competitionService = (CompetitionService) act.getBean("competitionServiceImpl");
    	Sys_User usr=new Sys_User();
    	usr.setId(1);
    	String res=competitionService.findHistoricalCompetitionRankByUser(usr);
    	System.out.println(res);
    }
    @Test
    public void findRecentFiveCompetitionErrorTest()
    {
    	Sys_User usr=new Sys_User();
    	usr.setId(10);
    	ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompetitionService competitionService = (CompetitionService) act.getBean("competitionServiceImpl");
    	List<String[]> list=competitionService.findRecentFiveCompetitionError(usr);
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			String[] compare=iterator.next();
			System.out.println(compare[0]);
			System.out.println(compare[1]);
			System.out.println(compare[2]);
			System.out.println(compare[3]);
			System.out.println(compare[4]);
			System.out.println(compare[5]);
		}
    }
}
