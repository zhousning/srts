package com.srts.examination.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.examination.domain.QuestionBank;
import com.srts.examination.po.MockTestAnalysisPo;
import com.srts.examination.po.TestInfoPo;
import com.srts.examination.service.MockTestService;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;



public class ExaminationServiceTest {
	private ApplicationContext act;
	private MockTestService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (MockTestService) act.getBean("mockTestServiceImpl");
	}
	@Test
	public void test1(){
		init();
		long id = 1;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		usr.setName("sb");
		TestInfoPo info = service.findUserAndTestInfo(usr, id);
		System.out.println(info.getNum1());
		System.out.println(info.getName());
		System.out.println(info.getNum2());
		System.out.println(info.getDate());
		System.out.println(info.getCount());
	}
	
	@Test
	public void test2(){ 
		init();
		MockTestAnalysisPo mockTestAnalysis = null;
		Sys_User usr=new Sys_User();
		usr.setId(1);
		if(mockTestAnalysis==null||mockTestAnalysis.equals(null)){
			mockTestAnalysis = new MockTestAnalysisPo();
		}
		String userTestScoreByUserAndType=service.findUserTestScoreByUserAndType(usr);//用户模拟考试成绩折线图
		String userTestScoreRankByUserAndType=service.findUserTestScoreRankByUserAndType(usr);//用户模拟考试成绩排名折线图
		String userTestScoreStablilityByUserAndType=service.findUserTestScoreStablilityByUserAndType(usr);//用户模拟考试成绩排名稳定性折线图
		String categoryUserTestScore=service.dispCategoryUserTestScore(usr);//成绩分类饼图
		mockTestAnalysis.setCategoryUserTestScore(categoryUserTestScore);
		mockTestAnalysis.setUserTestScoreByUserAndType(userTestScoreByUserAndType);
		mockTestAnalysis.setUserTestScoreRankByUserAndType(userTestScoreRankByUserAndType);
		mockTestAnalysis.setUserTestScoreStablilityByUserAndType(userTestScoreStablilityByUserAndType);
		System.out.println(mockTestAnalysis.getCategoryUserTestScore());
		System.out.println(mockTestAnalysis.getUserTestScoreByUserAndType());
		System.out.println(mockTestAnalysis.getUserTestScoreRankByUserAndType());
		System.out.println(mockTestAnalysis.getUserTestScoreStablilityByUserAndType());
	}
	
	@Test
	public void test3(){
		init();
		Train testTrain=new Train();
		testTrain.setId(1);
		String testMajor="运维检修";
		String testType="模拟";
		List<String[]> mockTestQuestionContent=new ArrayList<String[]>();
		String[] kind={"单选题","多选题","判断题","填空题","改错题","名词解释","简答题","问答题"};
		int[] questionNum={0,0,0,0,0,0,0,0};
		List<QuestionBank> res=new ArrayList<QuestionBank>();
		List<String[]> qNum=new ArrayList<String[]>();
		int tag=0;//试卷题号
		res=service.findTestPaperQuestion(testTrain, testMajor, testType);
		
		for(int i=0;i<res.size();i++)
		{
			QuestionBank q=res.get(i);
			if(q.getType().equals(kind[0]))
			{
				questionNum[0]++;
			}
			else if(q.getType().equals(kind[1]))
			{
				questionNum[1]++;
			}
			else if(q.getType().equals(kind[2]))
			{
				questionNum[2]++;
			}
			else if(q.getType().equals(kind[3]))
			{
				questionNum[3]++;
			}
			else if(q.getType().equals(kind[4]))
			{
				questionNum[4]++;
			}
			else if(q.getType().equals(kind[5]))
			{
				questionNum[5]++;
			}
			else if(q.getType().equals(kind[6]))
			{
				questionNum[6]++;
			}
			else if(q.getType().equals(kind[7]))
			{
				questionNum[7]++;
			}
			String[] temp={String.valueOf(tag),res.get(i).getContent()};
			mockTestQuestionContent.add(temp);
		}
		for(String[] s:mockTestQuestionContent){
			System.out.println(s[0]+"--0-");
			System.out.println(s[1]+"--1-");
		}
	}
}
