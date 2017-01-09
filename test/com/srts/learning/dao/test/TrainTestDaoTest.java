package com.srts.learning.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.dao.TrainTestDao;
import com.srts.examination.domain.AnswerSheet;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.domain.UserTestScore;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;

public class TrainTestDaoTest {
	private ApplicationContext act;
	private TrainTestDao dao;
	//private StudyCourseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (TrainTestDao) act.getBean("trainTestDaoImpl");
		//service = (StudyCourseService) act.getBean("studyCourseServiceImpl");
	}
	@Test
	public void findTestPaperByTrainTypeMajorTest()
	{
		init();
		Train train=new Train();
		train.setId(1);
		String major="运维检修";
		String type="正式";
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
    	testPaper.setId(1);
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
		String type="正式";
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
    	usr.setId(1);
		String type="正式";
		List<Integer> list=dao.categoryUserTestScore(usr, type);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
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
		System.out.println(question.getBookChapter().getId());
	}
    @Test
    public void findTestNameByTrainAndTypeTest()
    {
    	init();
    	String type="正式";
    	Train train=new Train();
    	train.setId(1);
    	String res=dao.findTestNameByTrainAndType(type, 1);
    	System.out.println(res);
    }
    @Test
    public void findUserTestScoreRankByUserAndTypeTest()
    {
    	init();
    	Sys_User usr=new Sys_User();
    	usr.setId(1);
		String type="正式";
		Train train=new Train();
		train.setId(1);
		int res=dao.findUserTestScoreRankByUserAndType(usr, type, 1);
		System.out.println(res);
    }
    @Test
    public void findTestPaperIdByUserTest()
    {
    	init();
    	Sys_User usr=new Sys_User();
    	usr.setId(1);
    	List list=dao.findTestPaperIdByUser(usr,"正式");
    	Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object objs = iterator.next();
			long testPaperId=Long.parseLong(objs.toString());
			System.out.println(testPaperId);
			}
	}
    @Test
	public void findAnswerSheetByUserAndTestPaperTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		long testPaperId=1;
		AnswerSheet answerSheet=dao.findAnswerSheetByUserAndTestPaper(usr, testPaperId);
		System.out.println(answerSheet.getContent());
		
	}
    @Test
    public void findTestTakenNumByUserIdTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
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
    	long id=1;
    	TestPaper t=dao.findTestPaperById(id);
    	System.out.println(t);
    }
}
	


