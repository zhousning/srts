package com.srts.learning.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.learning.po.ExerciseJudgeAnswerPo;
import com.srts.system.domain.Sys_User;


public class OnlineExerciseServiceTest {
	private ApplicationContext act;
	private OnlineExerciseService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (OnlineExerciseService) act.getBean("onlineExerciseServiceImpl");
	}
	@Test
	public void getRecentAccuracyRateNTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		String res=service.getRecentAccuracyRateN(usr);
		System.out.println(res);
	}
	@Test
	public void getRecentAccuracyStabilityNTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(25);
		String res=service.getRecentAccuracyStabilityN(usr);
		System.out.println(res);
	}
	@Test
	public void judgeAnswerTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		List<Long> chapterIDs=new ArrayList<Long>();
		chapterIDs.add(1L);
		List<QuestionBank> list=service.getQuestionsByChpaterIdAndType(1,"1","1");
		QuestionBank question=list.get(0);
		int res=service.judgeAnswer(question, "1");
		System.out.println(res);
	}
	@Test
	public void updateTableTest()
	{
		init();
		Sys_User usr=new Sys_User();
		usr.setId(1);
		String exerciseName="国家电网公司安全生产反违章工作管理办法|1";
		List <ExerciseJudgeAnswerPo> resList=new ArrayList<ExerciseJudgeAnswerPo>();
		List<QuestionBank> list=service.getQuestionsByChpaterIdAndType(1,"1","1");
		for(int i=0;i<list.size();i++)
		{
			int resultStatus=service.judgeAnswer(list.get(i), "1");
			ExerciseJudgeAnswerPo temp=new ExerciseJudgeAnswerPo();
			temp.setAnswer("1");
			temp.setQuestionResult(list.get(i));
			temp.setResultStatus(resultStatus);
			resList.add(temp);
		}
		boolean res=service.updateTable(usr, resList, exerciseName);
		System.out.println(res);
	}
	@Test
	public void getQuestionsByChpaterIdAndTypeTest()
	{
		init();
		List<QuestionBank> res=service.getQuestionsByChpaterIdAndType(1,"1","1");
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getContent());
			System.out.println(res.get(i).getAnswer());
			System.out.println(res.get(i).getQuestionPic());
			System.out.println(res.get(i).getType());
		}
	}
}
