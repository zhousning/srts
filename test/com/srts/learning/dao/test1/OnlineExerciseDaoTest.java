package com.srts.learning.dao.test1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.dao.OnlineExerciseDao;
import com.srts.learning.po.ExerciseResultSumPo;
import com.srts.learning.po.ExerciseSelectByNamePo;
import com.srts.learning.service.OnlineExerciseService;
import com.srts.system.domain.Sys_User;

public class OnlineExerciseDaoTest {
	private ApplicationContext act;
	private OnlineExerciseDao dao;
	private OnlineExerciseService service;
	
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (OnlineExerciseDao) act.getBean("onlineExerciseDaoImpl");
		service = (OnlineExerciseService)act.getBean("onlineExerciseServiceImpl");
	}
	
	@Test
	public void getRecentAccuracyRateTest()
	{
		init();
		List<String[]> list=dao.getRecentAccuracyRate(1);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i)[0]);
			System.out.println(list.get(i)[1]);
		}
	}
	@Test
	public void getRecentAccuracyStabilityTest()
	{
		init();
		List<String[]> list=dao.getRecentAccuracyStability(1);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i)[0]);
			System.out.println(list.get(i)[1]);
		}
	}
	@Test
	public void getResultSumTest()
	{
		init();
		ExerciseResultSumPo res=dao.getResultSum(1);
		System.out.println(res.getResultBlank());
		System.out.println(res.getResultRight());
		System.out.println(res.getResultWrong());
	}
	@Test
	public void getAllChapterTest()
	{
		init();
		List<ExerciseSelectByNamePo> res=dao.getAllChapter();
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getBookId());
			System.out.println(res.get(i).getBookName());
			System.out.println(res.get(i).getChapterId());
			System.out.println(res.get(i).getChapterName());
			System.out.println(res.get(i).getChapterNum());
		}
	}
	@Test
	public void getQuestionByChapterTest()
	{
		init();
		ExerciseSelectByNamePo esbnPo=new ExerciseSelectByNamePo();
		esbnPo.setChapterId("1");
		List<QuestionBank> res=dao.getQuestionByChapter(esbnPo);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getContent());
			System.out.println(res.get(i).getAnswer());
			System.out.println(res.get(i).getQuestionPic());
			System.out.println(res.get(i).getType());
		}
	}

	@Test
	public void getAllQuestionTest() {
		init();
		List<QuestionBank> res = dao.getAllQuestion();
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getContent());
			System.out.println(res.get(i).getAnswer());
			System.out.println(res.get(i).getQuestionPic());
			System.out.println(res.get(i).getType());
		}
	}
	@Test
	public void getCurrentExerciseSnTest()
	{
		init();
		long res=dao.getCurrentExerciseSn(25);
		System.out.println(res);
	}
	@Test
	public void updateOnlineExerciseTest()
	{
		init();
		boolean res=dao.updateOnlineExercise(4, 12, 4, 4, 0.5f, (float)0.167, 1, "2014-11-10", "国家电网公司安全生产反违章工作管理办法|1,2");
		System.out.println(res);
	}
	@Test
	public void getChapterQuestionsByChapterIDTest()
	{
		init();
		List<Long> chapterIDs=new ArrayList<Long>();
		chapterIDs.add(1L);
		List<QuestionBank> res=dao.getChapterQuestionsByChapterID(2, chapterIDs);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getContent());
			System.out.println(res.get(i).getAnswer());
			System.out.println(res.get(i).getQuestionPic());
			System.out.println(res.get(i).getType());
		}
	}
	@Test
	public void calAccuracyRateTest()
	{
		init();
		float res=service.calAccuracyRate(1, 1, 1);
		System.out.println(res);
	}
	@Test
	public void calAccuracyStabilityTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		float res=service.calAccuracyStability(usr, 0.5f);
		System.out.println(res);
	}
	@Test
	public void getBookChaptersByBookIDTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<BookChapter> res=service.getBookChaptersByBookID(1);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
		}
	}

}
