package com.srts.examination.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.po.MockTestAnalysisPo;
import com.srts.examination.po.TestInfoPo;
import com.srts.examination.service.MockTestService;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;

@Controller
public class ExaminationTestAction extends BaseActionImpl<TestPaper>{
	private static final long serialVersionUID = 1L;
	@Resource
	private MockTestService service;
	private TestPaper testPaper = new TestPaper();
	private MockTestAnalysisPo mockTestAnalysis;
	private TestInfoPo info = new TestInfoPo();
	private List<String[]> mockTestQuestionContent=new ArrayList<String[]>();
	private List<String[]> questionNumByType=new ArrayList<String[]>();
	private String resInsertString;
	private String questionAnswer;
	private String questionNo;//试卷题目号
	private String[] questionAnswerString;
	private String testPaperAnswerString;
	private Train testTrain;
	private String testType;
	private String testMajor;
	
	private List<QuestionBank> testQuestions=new ArrayList<QuestionBank>();
	
	public TestPaper getModel() {
		return null;
	}
	public void prepare() throws Exception {}
	/*
	 * 用户模拟考试成绩分析：userTestScoreByUserAndType为模拟考试成绩折线图，userTestScoreRankByUserAndType为模拟考试成绩排名折线图，
	 * userTestScoreStablilityByUserAndType为模拟考试成绩稳定性折线图，categoryUserTestScore为成绩分类饼图
	 */
	public String examTestAnalysis(){
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		if(mockTestAnalysis==null){
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
		return "examTestAnalysis";
	}
	/**
	 * 跳转到examTestList.jsp
	 * @return
	 */
	public String examTestList(){
		long id = 1L;
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		info=service.findUserAndTestInfo(usr, id);
		if(mockTestAnalysis==null){
			mockTestAnalysis = new MockTestAnalysisPo();
		}
		return "examTestList";
	}
	/**
	 * 跳转到examTestDisp.jsp
	 * @return
	 */
	public String examTestDisp(){
		Train testTrain=new Train();
		testTrain.setId(1);
		String testMajor="运维检修";
		String testType="模拟";
		testQuestions=service.findTestPaperQuestion(testTrain, testMajor, testType);
		return "examTestDisp";
	}
	/*
	 * 模拟考试试卷题目显示：questionNumByType为试卷各个类型题目数目，mockTestQuestionContent为题号（1）和题目内容（2）
	 */
	public String TrainTestQuestionDisp(){
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
			String[] temp={String.valueOf(tag),String.valueOf(res.get(i).getId()),res.get(i).getContent(),String.valueOf(res.get(i).getSelectOptions())};
			mockTestQuestionContent.add(temp);
			tag++;
		}
		for(int j=0;j<kind.length;j++)
		{
			String num=String.valueOf(questionNum[j]);
			String[] addItem={kind[j],num};
			qNum.add(addItem);
		}
		questionNumByType=qNum;
		return "examTrainDisp";
	}
	/*
	 * 设置答卷答案字符串：questionAnswerString是一个String数组，从0~n为对应题号答案
	 */
	public String SetAnswerString()
	{
		List<QuestionBank> res=new ArrayList<QuestionBank>();
		res=service.findTestPaperQuestion(testTrain, testMajor, testType);
		int testPaperSize=res.size();
		questionAnswerString=new String[testPaperSize];
		questionAnswerString[Integer.parseInt(questionNo)-1]=questionAnswer;
		return "setAnswerString";
	}
	/*
	 * 交卷：设置答卷字符串并将结果插入答卷表
	 */
	public String SubmitTestPaper()
	{
		Sys_User usr =new Sys_User();
		usr.setId(1);
		testPaperAnswerString=null;
		List<QuestionBank> res=new ArrayList<QuestionBank>();
		res=service.findTestPaperQuestion(testTrain, testMajor, testType);
		int testPaperSize=res.size();
		for(int i=0;i<testPaperSize;i++)
		{
			if(questionAnswerString[i]!=null&&i!=testPaperSize-1)
			{
				testPaperAnswerString+=questionAnswerString+"&";
			}else if(questionAnswerString[i]==null&&i!=testPaperSize-1)
			{
				testPaperAnswerString+="此题答案为空"+"&";
			}else if(questionAnswerString[i]!=null&&i==testPaperSize-1)
			{
				testPaperAnswerString+=questionAnswerString;
			}else if(questionAnswerString[i]==null&&i==testPaperSize-1)
			{
				testPaperAnswerString+="此题答案为空";
			}
			int resInsert=service.insertAnswerSheet(usr, testPaper, testPaperAnswerString);
			resInsertString=String.valueOf(resInsert);
		}
		return "submitTestPaper";
	}
	
	////////////////////////////////////////
	public MockTestService getService() {
		return service;
	}
	public void setService(MockTestService service) {
		this.service = service;
	}
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
	public MockTestAnalysisPo getMockTestAnalysis() {
		return mockTestAnalysis;
	}
	public void setMockTestAnalysis(MockTestAnalysisPo mockTestAnalysis) {
		this.mockTestAnalysis = mockTestAnalysis;
	}
	public List<String[]> getMockTestQuestionContent() {
		return mockTestQuestionContent;
	}
	public void setMockTestQuestionContent(List<String[]> mockTestQuestionContent) {
		this.mockTestQuestionContent = mockTestQuestionContent;
	}
	public List<String[]> getQuestionNumByType() {
		return questionNumByType;
	}
	public void setQuestionNumByType(List<String[]> questionNumByType) {
		this.questionNumByType = questionNumByType;
	}
	public String getResInsertString() {
		return resInsertString;
	}
	public void setResInsertString(String resInsertString) {
		this.resInsertString = resInsertString;
	}
	public String getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public String getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}
	public String[] getQuestionAnswerString() {
		return questionAnswerString;
	}
	public void setQuestionAnswerString(String[] questionAnswerString) {
		this.questionAnswerString = questionAnswerString;
	}
	public String getTestPaperAnswerString() {
		return testPaperAnswerString;
	}
	public void setTestPaperAnswerString(String testPaperAnswerString) {
		this.testPaperAnswerString = testPaperAnswerString;
	}
	public Train getTestTrain() {
		return testTrain;
	}
	public void setTestTrain(Train testTrain) {
		this.testTrain = testTrain;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getTestMajor() {
		return testMajor;
	}
	public void setTestMajor(String testMajor) {
		this.testMajor = testMajor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TestInfoPo getInfo() {
		return info;
	}
	public void setInfo(TestInfoPo info) {
		this.info = info;
	}
	public List<QuestionBank> getTestQuestions() {
		return testQuestions;
	}
	public void setTestQuestions(List<QuestionBank> testQuestions) {
		this.testQuestions = testQuestions;
	}
}
