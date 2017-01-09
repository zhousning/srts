package com.srts.examination.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.QuestionScoreList;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.po.AnswerSheetDispPo;
import com.srts.examination.po.AnswerSheetListPo;
import com.srts.examination.po.ExamInfoPo;
import com.srts.examination.po.TestPaperListPo;
import com.srts.examination.service.AnswerSheetEvaService;
import com.srts.examination.service.ExaminationPaperManageService;
import com.srts.examination.service.QuestionBankManageService;
import com.srts.examination.service.TestInfoManService;
import com.srts.examination.service.TestPaperService;
import com.srts.examination.service.TestPeopleService;
import com.srts.system.domain.Sys_Department;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.DepartmentService;

@Controller
@Scope("prototype")
public class ExaminationManageAction extends BaseActionImpl<TestPaper>{
	private static final long serialVersionUID = 1L;
	private List<Sys_Department> topDepartmentList;
	private List<Sys_Department> departmentList;
	private List<QuestionBank> questionBankList=new ArrayList<QuestionBank>();
	private List< TestInfo> testInfos;
	private List<ExamInfoPo> examInfoPos=new ArrayList<ExamInfoPo>();
	private List<TestPaper> testPapers=new ArrayList<TestPaper>();
	private long testInfoId;
	private int reqStatus;

	private String typeOne;
	private String typeTwo;
	private String typeThree;
	private String typeFour;
	private String typeFive;
	private int oneNum=0;
	private int twoNum=0;
	private int threeNum=0;
	private int fourNum=0;
	private int fiveNum=0;
	private int oneScore;
	private int twoScore;
	private int threeScore;
	private int fourScore;
	private int fiveScore;
	private long userId;
	
	//评卷管理
	private String resString="";
	private String evaMark="0";
	private String subjectiveQuestionNum="0";
	private String answerSheetId;
	private String testPaperId="2";
	private String objectiveQuestionMark="0";
	private List<AnswerSheetDispPo> examPaperCheckSheet;
	private List<AnswerSheetDispPo> findAnswerSheetDispByAnswerSheetId;
	private List<AnswerSheetListPo> findAnswerSheetListByTestPaperId;
	private List<TestPaperListPo> findAllTestPaper;
	private List<Sys_User> testUsers;
	
	
	private int page=1;
	private int totalPage;
	private int allRow;
	
	
	private String testPaperIds;
	@Resource
	private ExaminationPaperManageService service;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private QuestionBankManageService questionBankManageService;
	@Resource
	private TestInfoManService testInfoManService;
	@Resource
	private TestPaperService testPaperService;
	@Resource
	private TestPeopleService testPeopleService;
	@Resource
	private AnswerSheetEvaService answerSheetEvaService;
	
	private TestPaper testPaper = new TestPaper();
	private String examPaper="";
	

	public int getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(int reqStatus) {
		this.reqStatus = reqStatus;
	}
	public List<Sys_User> getTestUsers() {
		return testUsers;
	}
	public void setTestUsers(List<Sys_User> testUsers) {
		this.testUsers = testUsers;
	}
	public TestPaper getModel() {
		return null;
	}
	public void prepare() throws Exception {
	}
	
	/**
	 * 跳转到examManageList.jsp页面
	 * @return
	 */
	public String examManageList(){
		List<ExamInfoPo> list=new ArrayList<ExamInfoPo>();
		testInfos=testInfoManService.findAllTestByTime();
		for(TestInfo testInfo :testInfos){
			ExamInfoPo examInfoPo=new ExamInfoPo();
			TestPaper testPaper=testPaperService.geTestPaperByTestInfoID(testInfo.getId());
			List<Sys_User> testPeoples=testPeopleService.getTestPeoples(testInfo.getId());
			examInfoPo.setId(testInfo.getId());
			examInfoPo.setTestName(testInfo.getTestName());
			examInfoPo.setTestDate(testInfo.getTestDate());
			examInfoPo.setTestTime(testInfo.getTestTime());
			examInfoPo.setTestPaper(testPaper);
			examInfoPo.setTestPeople(testPeoples);
			list.add(examInfoPo);
		}
		
		allRow=list.size();
		if(allRow>0){
			if(allRow%10==0){
				totalPage=allRow/10;
			}else{
				totalPage=allRow/10+1;
			}
			
			for(int i=(page-1)*10; i<page*10&&i<list.size(); i++){
				examInfoPos.add(list.get(i));
			}
		}else{
			totalPage=1;
		}
		
		return "examManageList";
	}
	
	public String examManageDisp() {
		if (reqStatus==0) {
			testPaper=testPaperService.geTestPaperByTestInfoID(testInfoId);
			questionBankList=questionBankManageService.findByIds(testPaper.getContent());
		}
		if (reqStatus==1) {
			testUsers=testPeopleService.getTestPeoples(testInfoId);
		}
		
		return "disp";
	}


	
	/**
	 * 跳转到examPaperManageDisp.jsp
	 * @return
	 */
	public String examPaperManageList(){
		//testPaperList=testPaperService.findAllTestPapers();
		//return "examPaperManageList";
		return queryByPage();
	}
	
	/**
	 * 跳转到examPaperManageDisp.jsp
	 * @return
	 */
	public String examPaperManageDisp(){
		testInfos=testInfoManService.getTestInfosByState("0");
		return "examPaperManageDisp";
	}
	
	/**
	 * 
	 * 将试卷显示在“预览试卷”panel中
	 * @return
	 * @throws 
	 */
	public String examPaperManageShow() throws Exception {
		
		if("true".equals(typeOne)){
			List<QuestionBank> oneList=questionBankManageService.findQuestionBank("from QuestionBank where type='单选题'");
			List<Integer> list=new ArrayList<Integer>();
			for(int i=0; list.size()<oneNum; i++){
				int index=new Random().nextInt(oneList.size());
				if(!list.contains(index)){
					list.add(index);
				}
			}
			for(int i=0; i<list.size(); i++){
				questionBankList.add(oneList.get(list.get(i)));
			}
		}
		
		if("true".equals(typeTwo)){
			List<QuestionBank> twoList=questionBankManageService.findQuestionBank("from QuestionBank where type='多选题'");
			List<Integer> list=new ArrayList<Integer>();
			for(int i=0; list.size()<twoNum; i++){
				int index=new Random().nextInt(twoList.size());
				if(!list.contains(index)){
					list.add(index);
				}
			}
			for(int i=0; i<list.size(); i++){
				questionBankList.add(twoList.get(list.get(i)));
			}
		}
		if("true".equals(typeThree)){
			List<QuestionBank> threeList=questionBankManageService.findQuestionBank("from QuestionBank where type='判断题'");
			List<Integer> list=new ArrayList<Integer>();
			for(int i=0; list.size()<threeNum; i++){
				int index=new Random().nextInt(threeList.size());
				if(!list.contains(index)){
					list.add(index);
				}
			}
			for(int i=0; i<list.size(); i++){
				questionBankList.add(threeList.get(list.get(i)));
			}
		}
		if("true".equals(typeFour)){
			List<QuestionBank> fourList=questionBankManageService.findQuestionBank("from QuestionBank where type='填空题'");
			List<Integer> list=new ArrayList<Integer>();
			for(int i=0; list.size()<fourNum; i++){
				int index=new Random().nextInt(fourList.size());
				if(!list.contains(index)){
					list.add(index);
				}
			}
			for(int i=0; i<list.size(); i++){
				questionBankList.add(fourList.get(list.get(i)));
			}
		}
		if("true".equals(typeFive)){
			List<QuestionBank> fiveList=questionBankManageService.findQuestionBank("from QuestionBank where type='简答题'");
			List<Integer> list=new ArrayList<Integer>();
			for(int i=0; list.size()<fiveNum; i++){
				int index=new Random().nextInt(fiveList.size());
				if(!list.contains(index)){
					list.add(index);
				}
			}
			for(int i=0; i<list.size(); i++){
				questionBankList.add(fiveList.get(list.get(i)));
			}
		}
		
		String idsString="";
		for(QuestionBank question:questionBankList){
			idsString+=question.getId()+",";
		}
		
		TestInfo testInfo=testInfoManService.getTestInfoById(testInfoId);
		testInfo.setState("1");
		
		testPaper.setContent(idsString);
		testPaper.setCreatedate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		testPaper.setTestPaperName(testInfo.getTestName());
		testPaper.setExam_date(testInfo.getTestDate());	
		testPaper.setExam_time(testInfo.getTestTime());
		testPaper.setEnd_time(testInfo.getEndTime());
		testPaper.setTestInfo(testInfo);
		
		testInfoManService.updateTestInfo(testInfo);
		testPaperService.saveTestPaper(testPaper);
		
		if("true".equals(typeOne)){
			QuestionScoreList questionScore=new QuestionScoreList();
			questionScore.setType("单选题");
			questionScore.setScore(oneScore);
			questionScore.setTestPaper(testPaper);
			testPaperService.addQuestionScore(questionScore);
		}
		if("true".equals(typeTwo)){
			QuestionScoreList questionScore=new QuestionScoreList();
			questionScore.setType("多选题");
			questionScore.setScore(twoScore);
			questionScore.setTestPaper(testPaper);
			testPaperService.addQuestionScore(questionScore);
			
		}
		if("true".equals(typeThree)){
			QuestionScoreList questionScore=new QuestionScoreList();
			questionScore.setType("判断题");
			questionScore.setScore(threeScore);
			questionScore.setTestPaper(testPaper);
			testPaperService.addQuestionScore(questionScore);
		}
		if("true".equals(typeFour)){
			QuestionScoreList questionScore=new QuestionScoreList();
			questionScore.setType("填空题");
			questionScore.setScore(fourScore);
			questionScore.setTestPaper(testPaper);
			testPaperService.addQuestionScore(questionScore);
		}
		if("true".equals(typeFive)){
			QuestionScoreList questionScore=new QuestionScoreList();
			questionScore.setType("简单题");
			questionScore.setScore(fiveScore);
			questionScore.setTestPaper(testPaper);
			testPaperService.addQuestionScore(questionScore);
		}
		
		return "examPaperManageShow";
	}
	
	public String examPaperManageExport() throws Exception{
		
			testPaper=testPaperService.geTestPaperByTestInfoID(testInfoId);
			questionBankList=questionBankManageService.findByIds(testPaper.getContent());
			
			int i=1;
			String idsString="";
			for(QuestionBank question:questionBankList){
				String str="";
				str="\n"+String.valueOf(i)+"、"+question.getContent()+"\n";
				examPaper+=str;
				idsString+=question.getId()+",";
				i++;
			}
			byte b[] = examPaper.getBytes();
			ByteArrayInputStream in = new ByteArrayInputStream(b);
			POIFSFileSystem fs = new POIFSFileSystem();
			DirectoryEntry directory = fs.getRoot();
			directory.createDocument("WordDocument", in);
			String str=ServletActionContext.getServletContext().getRealPath("/resource/templete/examination/doc");
			File file=new File(str+"\\examPaper.doc");
			if(!file.exists()){
				file.createNewFile();
			}
			OutputStream out = new FileOutputStream(file);
			fs.writeFilesystem(out);
			in.close();
			out.close();
	
		return "examPaperManageExport";	
	}

	public InputStream getInputStream() throws Exception {
		
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/resource/templete/examination/doc/"+"examPaper.doc");
	}
	/**
	 * 将试卷显示在“生成试卷”panel中
	 * @return
	 */
	public String examPaperManageOut(){
		examPaper = service.getExaminationPaperOut();//返回文件的名字
		return "examPaperManageOut";
	}
	
	/**
	 * 跳转到examPaperCheckManageDisp.jsp
	 * @return
	 */
	public String examPaperCheckManageDisp(){
		findAllTestPaper=answerSheetEvaService.findAllTestPaper();
		findAnswerSheetListByTestPaperId=answerSheetEvaService.findAnswerSheetListByTestPaperId(Long.parseLong(testPaperId));
		return "examPaperCheckManageDisp";
	}
	
	/**
	 * 跳转到答卷展示页面
	 */
	public String examPaperCheckList()
	{
		findAnswerSheetDispByAnswerSheetId=answerSheetEvaService.findAnswerSheetDispByAnswerSheetId(Long.parseLong(answerSheetId));
		return "examPaperCheckList";
	}
	/**
	 * 跳转到评卷页面
	 */
	public String examPaperCheckDisp()
	{
		findAnswerSheetDispByAnswerSheetId=answerSheetEvaService.findAnswerSheetDispByAnswerSheetId(Long.parseLong(answerSheetId));
		examPaperCheckSheet=new ArrayList<AnswerSheetDispPo>();
		objectiveQuestionMark=String.valueOf(answerSheetEvaService.calculateChooseMark(findAnswerSheetDispByAnswerSheetId));
		int j=1;
		for(int i=0;i<findAnswerSheetDispByAnswerSheetId.size();i++)
		{
			if(findAnswerSheetDispByAnswerSheetId.get(i).getQuestionType().equals("单选题")==false&&
					findAnswerSheetDispByAnswerSheetId.get(i).getQuestionType().equals("多选题")==false&&
					findAnswerSheetDispByAnswerSheetId.get(i).getQuestionType().equals("判断题")==false)
			{
				AnswerSheetDispPo temp =new AnswerSheetDispPo();
				temp.setId(String.valueOf(j));
				temp.setAnswerSheetId(findAnswerSheetDispByAnswerSheetId.get(i).getAnswerSheetId());
				temp.setAnswerTrue(findAnswerSheetDispByAnswerSheetId.get(i).getAnswerTrue());
				temp.setQuestionId(findAnswerSheetDispByAnswerSheetId.get(i).getQuestionId());
				temp.setQuestionScore(findAnswerSheetDispByAnswerSheetId.get(i).getQuestionScore());
				temp.setQuestionType(findAnswerSheetDispByAnswerSheetId.get(i).getQuestionType());
				temp.setUserAnswer(findAnswerSheetDispByAnswerSheetId.get(i).getUserAnswer());
				examPaperCheckSheet.add(temp);
				j++;
			}
		}
		subjectiveQuestionNum=String.valueOf(examPaperCheckSheet.size());
		return "examPaperCheckDisp";
	}
	/**
	 * 插入userTestScore
	 */
	public String insertUserTestScore()
	{
		testPaperId=String.valueOf(answerSheetEvaService.findTestPaperIdByAnswerSheetId(Long.parseLong(answerSheetId)));
		long usrId=answerSheetEvaService.findUsrIdByAnswerSheetId(Long.parseLong(answerSheetId));
		int res=answerSheetEvaService.insertIntoUserTestScore(Integer.parseInt(evaMark), "无备注", usrId, Long.parseLong(testPaperId));
		if(res==1)
		{
			resString="success";
		}
		else
		{
			resString="fail";
		}
		return "insertUserTestScore";
	}
	
	/**
	 * 跳转到examPeopleManageDisp.jsp
	 * @return
	 */
	public String examPeopleManageDisp(){
		Sys_User user=(Sys_User) ActionContext.getContext().getSession().get("user");
		userId=user.getId();
		topDepartmentList=departmentService.findTopDepartmentList();
		testInfos=testInfoManService.getExamPlan();
		return "examPeopleManageDisp";
	}
	/**
	 * 跳转到examScoreManageDisp.jsp
	 * @return
	 */
	public String deleteTestPaper(){
		String[] str = testPaperIds.split(" ");
		for (int i = 0; i < str.length; i++) {
			TestPaper testPaper=testPaperService.findTestPaperById(Long.parseLong(str[i]));
			if(testPaper!=null){
				testPaperService.deleteTestPaper(testPaper);
			}	
		}
		//testPaperList=testPaperService.findAllTestPapers();
		//return "examPaperManageList";
		return queryByPage();
	}
	
	/**
	 * 跳转到examScoreManageList.jsp
	 * @return
	 */
	public String examScoreManageDisp(){
		return "examScoreManageDisp";
	}
	
	public String queryByPage(){
		List<TestPaper> list=testPaperService.findAllTestPapers();
		allRow=list.size();
		if(allRow>0){
			if(allRow%3==0){
				totalPage=allRow/3;
			}else{
				totalPage=allRow/3+1;
			}
			
			for(int i=(page-1)*3; i<page*3&&i<list.size(); i++){
				testPapers.add(list.get(i));
			}
		}else{
			totalPage=1;
		}
		return "examPaperManageList";
	}
	
	////////////////////////////////////////////////////
	
	
	public String getExamPaper() {
		return examPaper;
	}
	public List<ExamInfoPo> getExamInfoPos() {
		return examInfoPos;
	}
	public void setExamInfoPos(List<ExamInfoPo> examInfoPos) {
		this.examInfoPos = examInfoPos;
	}
	public void setExamPaper(String examPaper) {
		this.examPaper = examPaper;
	}
	
	public List<Sys_Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Sys_Department> departmentList) {
		this.departmentList = departmentList;
	}
	public List<Sys_Department> getTopDepartmentList() {
		return topDepartmentList;
	}
	public void setTopDepartmentList(List<Sys_Department> topDepartmentList) {
		this.topDepartmentList = topDepartmentList;
	}
	public String getTypeOne() {
		return typeOne;
	}
	public void setTypeOne(String typeOne) {
		this.typeOne = typeOne;
	}
	public String getTypeTwo() {
		return typeTwo;
	}
	public void setTypeTwo(String typeTwo) {
		this.typeTwo = typeTwo;
	}
	public String getTypeThree() {
		return typeThree;
	}
	public void setTypeThree(String typeThree) {
		this.typeThree = typeThree;
	}
	public String getTypeFour() {
		return typeFour;
	}
	public void setTypeFour(String typeFour) {
		this.typeFour = typeFour;
	}
	public String getTypeFive() {
		return typeFive;
	}
	public void setTypeFive(String typeFive) {
		this.typeFive = typeFive;
	}
	public int getOneNum() {
		return oneNum;
	}
	public void setOneNum(int oneNum) {
		this.oneNum = oneNum;
	}
	public int getTwoNum() {
		return twoNum;
	}
	public void setTwoNum(int twoNum) {
		this.twoNum = twoNum;
	}
	public int getThreeNum() {
		return threeNum;
	}
	public void setThreeNum(int threeNum) {
		this.threeNum = threeNum;
	}
	public int getFourNum() {
		return fourNum;
	}
	public void setFourNum(int fourNum) {
		this.fourNum = fourNum;
	}
	public int getFiveNum() {
		return fiveNum;
	}
	public void setFiveNum(int fiveNum) {
		this.fiveNum = fiveNum;
	}
	
	public int getOneScore() {
		return oneScore;
	}
	public void setOneScore(int oneScore) {
		this.oneScore = oneScore;
	}
	public int getTwoScore() {
		return twoScore;
	}
	public void setTwoScore(int twoScore) {
		this.twoScore = twoScore;
	}
	public int getThreeScore() {
		return threeScore;
	}
	public void setThreeScore(int threeScore) {
		this.threeScore = threeScore;
	}
	public int getFourScore() {
		return fourScore;
	}
	public void setFourScore(int fourScore) {
		this.fourScore = fourScore;
	}
	public int getFiveScore() {
		return fiveScore;
	}
	public void setFiveScore(int fiveScore) {
		this.fiveScore = fiveScore;
	}
	public List<QuestionBank> getQuestionBankList() {
		return questionBankList;
	}
	public void setQuestionBankList(List<QuestionBank> questionBankList) {
		this.questionBankList = questionBankList;
	}
	public List<TestInfo> getTestInfos() {
		return testInfos;
	}
	public void setTestInfos(List<TestInfo> testInfos) {
		this.testInfos = testInfos;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public List<TestPaper> getTestPapers() {
		return testPapers;
	}
	public void setTestPapers(List<TestPaper> testPapers) {
		this.testPapers = testPapers;
	}
	public String getTestPaperIds() {
		return testPaperIds;
	}
	public void setTestPaperIds(String testPaperIds) {
		this.testPaperIds = testPaperIds;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public long getTestInfoId() {
	    return testInfoId;
	}
	public void setTestInfoId(long testInfoId) {
		this.testInfoId = testInfoId;
	}
	public List<AnswerSheetDispPo> getFindAnswerSheetDispByAnswerSheetId() {
		return findAnswerSheetDispByAnswerSheetId;
	}
	public void setFindAnswerSheetDispByAnswerSheetId(
			List<AnswerSheetDispPo> findAnswerSheetDispByAnswerSheetId) {
		this.findAnswerSheetDispByAnswerSheetId = findAnswerSheetDispByAnswerSheetId;
	}
	public List<AnswerSheetListPo> getFindAnswerSheetListByTestPaperId() {
		return findAnswerSheetListByTestPaperId;
	}
	public void setFindAnswerSheetListByTestPaperId(
			List<AnswerSheetListPo> findAnswerSheetListByTestPaperId) {
		this.findAnswerSheetListByTestPaperId = findAnswerSheetListByTestPaperId;
	}
	public List<TestPaperListPo> getFindAllTestPaper() {
		return findAllTestPaper;
	}
	public void setFindAllTestPaper(List<TestPaperListPo> findAllTestPaper) {
		this.findAllTestPaper = findAllTestPaper;
	}
	public String getAnswerSheetId() {
		return answerSheetId;
	}
	public void setAnswerSheetId(String answerSheetId) {
		this.answerSheetId = answerSheetId;
	}
	public List<AnswerSheetDispPo> getExamPaperCheckSheet() {
		return examPaperCheckSheet;
	}
	public void setExamPaperCheckSheet(List<AnswerSheetDispPo> examPaperCheckSheet) {
		this.examPaperCheckSheet = examPaperCheckSheet;
	}
	public String getObjectiveQuestionMark() {
		return objectiveQuestionMark;
	}
	public void setObjectiveQuestionMark(String objectiveQuestionMark) {
		this.objectiveQuestionMark = objectiveQuestionMark;
	}
	public String getSubjectiveQuestionNum() {
		return subjectiveQuestionNum;
	}
	public void setSubjectiveQuestionNum(String subjectiveQuestionNum) {
		this.subjectiveQuestionNum = subjectiveQuestionNum;
	}
	public String getEvaMark() {
		return evaMark;
	}
	public void setEvaMark(String evaMark) {
		this.evaMark = evaMark;
	}
	public String getResString() {
		return resString;
	}
	public void setResString(String resString) {
		this.resString = resString;
	}

}
