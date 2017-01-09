package com.srts.learning.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.dao.MockTestDao;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.domain.UserTestScore;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;

public class MockTestDaoTest {
	private ApplicationContext act;
	private MockTestDao dao;
	//private StudyCourseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (MockTestDao) act.getBean("mockTestDaoImpl");
		//service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
	}
	@Test
	public void findTestPaperByTrainTypeMajorTest()
	{
		init();
		Train train=new Train();
		train.setId(1);
		String major="运维检修";
		String type="模拟";
		TestPaper testPaper=dao.findTestPaperByTrainTypeMajor(train, major, type);
		System.out.println(testPaper.getId());
		System.out.println(testPaper.getMajor());
		System.out.println(testPaper.getType());
		System.out.println(testPaper.getCreatedate());
		System.out.println(testPaper.getExam_date());
		//System.out.println(testPaper.getTrain().getId());
		System.out.println(testPaper.getContent());
	}
    @Test
    public void insertAnswerSheetTest()
    {
    	init();
    	Sys_User usr=new Sys_User();
    	usr.setId(1);
    	TestPaper testPaper=new TestPaper();
    	testPaper.setId(2);
		String answerContent="A,B,C,D,";
		int res=dao.insertAnswerSheet(usr, testPaper, answerContent);
		System.out.println(res);
    }
    @Test
    public void findUserTestScoreByUserAndTypeTest()
    {
    	init();
    	Sys_User usr=new Sys_User();
    	usr.setId(1);
		String type="模拟";
		List<UserTestScore> list=dao.findUserTestScoreByUserAndType(usr, type);
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
    public void categoryUserTestScoreTest()
    {
    	init();
    	Sys_User usr=new Sys_User();
    	usr.setId(10);
		String type="模拟";
		List<Integer> list=dao.categoryUserTestScore(usr, type);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
    @Test
	public void findQuestionByIdTest()
	{
		init();
		long id=100;
		QuestionBank question=dao.findQuestionById(id);
		System.out.println(question);
		System.out.println(question.getId());
		System.out.println(question.getType());
		System.out.println(question.getContent());
		System.out.println(question.getAnswer());
		System.out.println(question.getBookChapter());
	}
    @Test
    public void findUserTestScoreRankByUserAndTypeTest()
    {
    	init();
    	Sys_User usr=new Sys_User();
    	usr.setId(1);
		String type="模拟";
		Train train=new Train();
		train.setId(1);
		int res=dao.findUserTestScoreRankByUserAndType(usr, type, 1);
		System.out.println(res);
    }
    @Test
    public void findTestTakenNumByUserIdTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(10);
		int res=dao.findTestTakenNumByUser(usr);
		System.out.println(res);
		
	}
    @Test
	public void findTestInfoTest()
	{
		init();
		long id=1;
		TestInfo testInfo=dao.findTestInfo(id);
		System.out.println(testInfo.getId());
		System.out.println(testInfo.getTestName());
	}
    @Test
    public void findTestPaperByIdTest()
    {
    	init();
    	long testPaperId=5;
    	TestPaper res=dao.findTestPaperById(testPaperId);
    	System.out.println(res.getContent());
    }
}
