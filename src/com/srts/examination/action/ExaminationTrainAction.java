package com.srts.examination.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.domain.TestPeople;
import com.srts.examination.po.TrainTestAnalysisPo;
import com.srts.examination.po.TrainTestInfoPo;
import com.srts.examination.service.TestInfoManService;
import com.srts.examination.service.TestPaperService;
import com.srts.examination.service.TestPeopleService;
import com.srts.examination.service.TrainTestService;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_Department;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.UserService;

@Controller
public class ExaminationTrainAction extends BaseActionImpl<TestPaper> {
	private static final long serialVersionUID = 1L;
	@Resource
	private TrainTestService service;
	@Resource
	private TestPaperService testPaperService;
	@Resource
	private UserService userService;
	@Resource
	private TestInfoManService testInfoManService;

	private TestPaper testPaper = new TestPaper();
	private TrainTestAnalysisPo trainTestAnalysis;
	private TrainTestInfoPo trainTestInfoPo;
	private List<String> trainTestInfo = new ArrayList<String>();
	private List<String[]> trainTestQuestionContent = new ArrayList<String[]>();
	private List<String[]> questionNumByType = new ArrayList<String[]>();
	private String resInsertString;
	private String questionAnswer;
	private String questionNo;// 试卷题目号
	private String[] questionAnswerString;
	private String testPaperAnswerString;
	private Train testTrain;
	private String testType;
	private String testMajor;

	private long userId;
	private long testInfoId;
	private long testPaperId;
	private Map<String, Object[]> testPaperMap;

	private TestInfo testInfo;
	private Sys_User user;

	/**
	 * 跳转到examTrainList.jsp
	 * 
	 * @return
	 */
	public String examTrainList() {
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		userId=usr.getId();
		user = userService.getUserById(userId);
		testInfo = testInfoManService.getUserNowExam(userId);
		return "examTrainList";
	}

	/**
	 * 跳转到examTrainDisp.jsp
	 * 
	 * @return
	 */
	public String examTrainDisp() {
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		userId=usr.getId();
		System.out.println(testInfoId);
		testPaper = testPaperService.geTestPaperByTestInfoID(testInfoId);

		String questionIds = testPaper.getContent();
		testPaperId = testPaper.getId();
		System.out.println(questionIds + "}}}}}}}}}}}}}}" + testPaperId);

		testPaperMap = service.getTestPaperMap(questionIds, testPaperId);

		return "examTrainDisp";
	}

	/**
	 * 提交试卷答案
	 */
	public String insertAnswer() {
		System.out.println(questionAnswer+"%%%%%%%%%%%");
		service.insertAnswer(userId, testPaperId, questionAnswer);
		return "endTest";
	}

	/*
	 * 用户正式考试成绩分析：userTestScoreByUserAndType为正式考试成绩折线图，userTestScoreRankByUserAndType为正式考试成绩排名折线图
	 * ，userTestScoreStablilityByUserAndType为正式考试成绩稳定性折线图，
	 * categoryUserTestScore为正式分类饼图
	 */
	public String TrainTestAnalysis() {
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");;
		if (trainTestAnalysis == null) {
			trainTestAnalysis = new TrainTestAnalysisPo();
		}
		String userTestScoreByUserAndType = service
				.findUserTestScoreByUserAndType(usr);// 用户正式考试成绩折线图
		String userTestScoreRankByUserAndType = service
				.findUserTestScoreRankByUserAndType(usr);// 用户正式考试成绩排名折线图
		String userTestScoreStablilityByUserAndType = service
				.findUserTestScoreStablilityByUserAndType(usr);// 用户正式考试成绩排名稳定性折线图
		String categoryUserTestScore = service.dispCategoryUserTestScore(usr);// 成绩分类饼图
		trainTestAnalysis.setCategoryUserTestScore(categoryUserTestScore);
		trainTestAnalysis
				.setUserTestScoreByUserAndType(userTestScoreByUserAndType);
		trainTestAnalysis
				.setUserTestScoreRankByUserAndType(userTestScoreRankByUserAndType);
		trainTestAnalysis
				.setUserTestScoreStablilityByUserAndType(userTestScoreStablilityByUserAndType);
		return "trainTestAnalysis";
	}

	/*
	 * 模拟考试信息和用户获取：1.用户已考过的模拟考试次数 2.用户名 3.用户职位 4.用户工号 5.用户单位 6.用户当前考试次数 7.考试日期
	 * 8.考试人数
	 */
	public void TrainTestInfoList() {
		trainTestInfoPo = new TrainTestInfoPo();
		long id = 1;
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		trainTestInfo = service.findUserAndTestInfo(usr, id);
		System.out.println(trainTestInfo.get(0));
		trainTestInfoPo.setTestTakenNum(trainTestInfo.get(0));
		trainTestInfoPo.setTesterName(trainTestInfo.get(1));
		trainTestInfoPo.setTesterJob(trainTestInfo.get(2));
		trainTestInfoPo.setTesterWorkno(trainTestInfo.get(3));
		trainTestInfoPo.setTesterCompany(trainTestInfo.get(4));
		trainTestInfoPo.setTestNum(trainTestInfo.get(5));
		trainTestInfoPo.setTestName(trainTestInfo.get(6));
		trainTestInfoPo.setTestDate(trainTestInfo.get(7));
		trainTestInfoPo.setTestPeopleNum(trainTestInfo.get(8));
	}

	/*
	 * 模拟考试试卷题目显示：questionNumByType为试卷各个类型题目数目，mockTestQuestionContent为题号（1）和题目内容
	 * （2）
	 */
	public String TrainTestQuestionDisp() {
		String[] kind = { "单选题", "多选题", "判断题", "填空题", "改错题", "名词解释", "简答题",
				"问答题" };
		int[] questionNum = { 0, 0, 0, 0, 0, 0, 0, 0 };
		List<QuestionBank> res = new ArrayList<QuestionBank>();
		List<String[]> qNum = new ArrayList<String[]>();
		int tag = 0;// 试卷题号
		res = service.findTestPaperQuestion(testTrain, testMajor, testType);

		for (int i = 0; i < res.size(); i++) {
			QuestionBank q = res.get(i);
			if (q.getType().equals(kind[0])) {
				questionNum[0]++;
			} else if (q.getType().equals(kind[1])) {
				questionNum[1]++;
			} else if (q.getType().equals(kind[2])) {
				questionNum[2]++;
			} else if (q.getType().equals(kind[3])) {
				questionNum[3]++;
			} else if (q.getType().equals(kind[4])) {
				questionNum[4]++;
			} else if (q.getType().equals(kind[5])) {
				questionNum[5]++;
			} else if (q.getType().equals(kind[6])) {
				questionNum[6]++;
			} else if (q.getType().equals(kind[7])) {
				questionNum[7]++;
			}
			String[] temp = { String.valueOf(tag),
					String.valueOf(res.get(i).getId()),
					res.get(i).getContent(),
					String.valueOf(res.get(i).getSelectOptions()) };
			trainTestQuestionContent.add(temp);
			tag++;
		}
		for (int j = 0; j < kind.length; j++) {
			String num = String.valueOf(questionNum[j]);
			String[] addItem = { kind[j], num };
			qNum.add(addItem);
		}
		questionNumByType = qNum;
		return "examTrainDisp";
	}

	/*
	 * 设置答卷答案字符串：questionAnswerString是一个String数组，从0~n为对应题号答案
	 */
	public String SetAnswerString() {
		List<QuestionBank> res = new ArrayList<QuestionBank>();
		res = service.findTestPaperQuestion(testTrain, testMajor, testType);
		int testPaperSize = res.size();
		questionAnswerString = new String[testPaperSize];
		questionAnswerString[Integer.parseInt(questionNo) - 1] = questionAnswer;
		return "setAnswerString";
	}

	/*
	 * 交卷：设置答卷字符串并将结果插入答卷表
	 */
	public String SubmitTestPaper() {
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		testPaperAnswerString = "";
		List<QuestionBank> res = new ArrayList<QuestionBank>();
		res = service.findTestPaperQuestion(testTrain, testMajor, testType);
		int testPaperSize = res.size();
		for (int i = 0; i < testPaperSize; i++) {
			if (questionAnswerString[i] != null && i != testPaperSize - 1) {
				testPaperAnswerString += questionAnswerString + "&";
			} else if (questionAnswerString[i] == null
					&& i != testPaperSize - 1) {
				testPaperAnswerString += "此题答案为空" + "&";
			} else if (questionAnswerString[i] != null
					&& i == testPaperSize - 1) {
				testPaperAnswerString += questionAnswerString;
			} else if (questionAnswerString[i] == null
					&& i == testPaperSize - 1) {
				testPaperAnswerString += "此题答案为空";
			}
			int resInsert = service.insertAnswerSheet(usr, testPaper,
					testPaperAnswerString);
			resInsertString = String.valueOf(resInsert);
		}
		return "submitTestPaper";
	}

	public Map<String, Object[]> getTestPaperMap() {
		return testPaperMap;
	}

	public void setTestPaperMap(Map<String, Object[]> testPaperMap) {
		this.testPaperMap = testPaperMap;
	}

	public TrainTestService getService() {
		return service;
	}

	public void setService(TrainTestService service) {
		this.service = service;
	}

	public TestPaper getTestPaper() {
		return testPaper;
	}

	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}

	public TrainTestAnalysisPo getTrainTestAnalysis() {
		return trainTestAnalysis;
	}

	public void setTrainTestAnalysis(TrainTestAnalysisPo trainTestAnalysis) {
		this.trainTestAnalysis = trainTestAnalysis;
	}

	public List<String> getTrainTestInfo() {
		return trainTestInfo;
	}

	public void setTrainTestInfo(List<String> trainTestInfo) {
		this.trainTestInfo = trainTestInfo;
	}

	public List<String[]> getTrainTestQuestionContent() {
		return trainTestQuestionContent;
	}

	public void setTrainTestQuestionContent(
			List<String[]> trainTestQuestionContent) {
		this.trainTestQuestionContent = trainTestQuestionContent;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getTestInfoId() {
		return testInfoId;
	}

	public void setTestInfoId(long testInfoId) {
		this.testInfoId = testInfoId;
	}

	public TestPaper getModel() {
		return null;
	}

	public long getTestPaperId() {
		return testPaperId;
	}

	public void setTestPaperId(long testPaperId) {
		this.testPaperId = testPaperId;
	}

	public void prepare() throws Exception {
	}

	public TestPaperService getTestPaperService() {
		return testPaperService;
	}

	public void setTestPaperService(TestPaperService testPaperService) {
		this.testPaperService = testPaperService;
	}

	public TrainTestInfoPo getTrainTestInfoPo() {
		return trainTestInfoPo;
	}

	public void setTrainTestInfoPo(TrainTestInfoPo trainTestInfoPo) {
		this.trainTestInfoPo = trainTestInfoPo;
	}

	public TestInfo getTestInfo() {
		return testInfo;
	}

	public void setTestInfo(TestInfo testInfo) {
		this.testInfo = testInfo;
	}

	public Sys_User getUser() {
		return user;
	}

	public void setUser(Sys_User user) {
		this.user = user;
	}

}
