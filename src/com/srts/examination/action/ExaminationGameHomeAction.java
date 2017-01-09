package com.srts.examination.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.po.CompQuestionAnswerPo;
import com.srts.examination.po.CompQuestionPo;
import com.srts.examination.po.MyCompetitionInfo;
import com.srts.examination.service.CompetitionService;
import com.srts.learning.service.ErrorSetService;
import com.srts.system.domain.Sys_User;

@Controller
public class ExaminationGameHomeAction extends BaseActionImpl<QuestionBank>{
	private static final long serialVersionUID = 1L;
	@Resource
	private ErrorSetService errorSetService;
	@Resource
	private CompetitionService service;
	
	
	private QuestionBank questionBank = new QuestionBank();
	private String compeitionRankAnalysis;
	private String compeitionScoreAnalysis;
	private List<String[]> competitionRankTopFiveNow=new ArrayList<String[]>();
	private List<String[]> competitionRankTopFiveHis=new ArrayList<String[]>();
	private MyCompetitionInfo myCompetitionInfo=new MyCompetitionInfo();
	private CompQuestionPo compQuestion=new CompQuestionPo();
	private String compLevel="0";//闯关数目
	private String compAnswer;//闯关当前题目用户给出的答案的字符串
	private String resString;//题目答案判断正误的结果
	private CompQuestionAnswerPo compQuestionAnswerPo;//题目答案PO
	private long compTimeUsed=0;//答题所用时间
	private long startTime;//答题开始时间
	private long endTime;//答题结束时间
	
	public QuestionBank getModel() {
		return null;
	}
	public void prepare() throws Exception {}
	/*
	 * 闯关问答信息显示：myRankNow为我的当前排名，myBestRank为我的最好排名，myLastScore为我的上次成绩，myBestScore为我的最好成绩
	 * compeitionRankAnalysis为成绩排名曲线对应的字符串，compeitionScoreAnalysis为成绩曲线对应的字符串，competitionRankTopFiveNow
	 * 为目前次闯关排名前五的用户名和对应成绩，competitionRankTopFiveHis为历史闯关排名前五的用户名和对应成绩
	 */
//    public String competitionInfoList()
//    {
//    	Sys_User usr = new Sys_User();
//    	usr.setId(1);
//    	Calendar calendar=Calendar.getInstance();
//		String year=String.valueOf(calendar.get(Calendar.YEAR));
//		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
//		String date=String.valueOf(calendar.get(Calendar.DATE));
//		//String currentTime=year+"-"+month+"-"+date;
//		String currentTime=year+"-"+month;
//		compeitionRankAnalysis=service.findCompetitionRankRightNowByUser(usr, currentTime);
//		compeitionScoreAnalysis=service.dispCompetitionGradeByUser(usr);
//    	competitionRankTopFiveNow=service.findCompetitionRankRightNow(currentTime);
//    	competitionRankTopFiveHis=service.findHistoricalCompetitionRank();
//    	String myRankNow=service.findCompetitionRankRightNowByUser(usr, currentTime);
//    	String myBestRank=service.findHistoricalCompetitionRankByUser(usr);
//    	String myLastScore=service.findCompetitionLastGradeByUser(usr);
//    	String myBestScore=service.findCompetitionMaxGradeByUser(usr);
//    	myCompetitionInfo.setMyBestRank(myBestRank);
//    	myCompetitionInfo.setMyBestScore(myBestScore);
//    	myCompetitionInfo.setMyLastScore(myLastScore);
//    	myCompetitionInfo.setMyRankNow(myRankNow);
//    	return "examGameHomeList";
//    }
    /*
	 * 闯关问答题目显示：competitionNo为当前闯关关数，compQuestionContent为闯关题目内容，compQuestionPic为闯关题目图片
	 * compQuestionType为闯关题目类别
	 */
//    public String CompetitionDisp()
//    {
//    	Calendar calendar=Calendar.getInstance();
//    	startTime=calendar.getTimeInMillis();
//    	QuestionBank question=service.findQuestionRandomly();
//    	String compQuestionContent=question.getContent();
//    	String compQuestionPic=question.getQuestionPic();
//    	String compQuestionType=question.getType();
//    	String compQuestionId=String.valueOf(question.getId());
//    	String competitionNo=String.valueOf(Integer.parseInt(compLevel)+1);
//    	System.out.println("sadfasfasdfsd");
//    	System.out.println(competitionNo+" "+compQuestionContent);
//    	compQuestion.setCompetitionNo(competitionNo);
//    	compQuestion.setCompQuestionContent(compQuestionContent);
//    	compQuestion.setCompQuestionPic(compQuestionPic);
//    	compQuestion.setCompQuestionType(compQuestionType);
//    	return "examGameHomeDisp";
//    }
    /*
	 * 闯关问答过程：compQuestionAnswerPo为题目答案的PO，答对进入下一关，打错则直接结束闯关回到List下
	 */
    public String CompetitionRun()
    {
    	String returnString=null;;
    	Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		if(month.length()==1)
		{
			month="0"+month;
		}
		if(date.length()==1)
		{
			date="0"+date;
		}
		String currentTime=year+"-"+month+"-"+date;
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		
		//System.out.println(compAnswer);
		try {
			compAnswer=new String(compAnswer.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(compAnswer);
		compQuestionAnswerPo = new CompQuestionAnswerPo();
		compQuestionAnswerPo.setCompQuestionId(compQuestion.getCompQuestionId());
		compQuestionAnswerPo.setCompQuestionAnswer(compAnswer);
		QuestionBank question=service.findQuestionById(compQuestionAnswerPo.getCompQuestionId());
		System.out.println(question.getAnswer());
		resString = String.valueOf(service.judgeTheAnswer(question, compQuestionAnswerPo.getCompQuestionAnswer()));
		if(resString.equals("1"))
		{
			System.out.println("答对了,进入下一关!");
			compLevel=String.valueOf(Integer.parseInt(compLevel)+1);
			endTime=calendar.getTimeInMillis();
			compTimeUsed+=(endTime-startTime)/1000;
			return examGameHomeDisp();
			
		}
		else if(resString.equals("0"))
		{
			System.out.println("答错，闯关结束!");
			endTime=calendar.getTimeInMillis();
			compTimeUsed+=(endTime-startTime)/1000;
			int comp_time=(int)compTimeUsed;
			service.insertCompetition(Integer.parseInt(compLevel), currentTime, comp_time, usr);
			service.insertCompetitionError(compQuestionAnswerPo.getCompQuestionAnswer(), currentTime, usr, question);
			errorSetService.insertIntoErrorSet(usr, 2, currentTime, question);
			compLevel="0";
			returnString="examGameHomeList";
		}
		return returnString;
    }
	/**
	 * 跳转到examGameHomeList.jsp
	 * @return
	 */
	public String examGameHomeList(){
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
    	Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		if(month.length()==1)
		{
			month="0"+month;
		}
		if(date.length()==1)
		{
			date="0"+date;
		}
		//String currentTime=year+"-"+month+"-"+date;
		String currentTime=year+"-"+month;
    	competitionRankTopFiveNow=service.findCompetitionRankRightNow(currentTime);
    	competitionRankTopFiveHis=service.findHistoricalCompetitionRank();
    	String myRankNow=service.findCompetitionRankRightNowByUser(usr, currentTime);
    	String myBestRank=service.findHistoricalCompetitionRankByUser(usr);
    	String myLastScore=service.findCompetitionLastGradeByUser(usr);
    	String myBestScore=service.findCompetitionMaxGradeByUser(usr);
    	myCompetitionInfo.setMyBestRank(myBestRank);
    	myCompetitionInfo.setMyBestScore(myBestScore);
    	myCompetitionInfo.setMyLastScore(myLastScore);
    	myCompetitionInfo.setMyRankNow(myRankNow);
    	return "examGameHomeList";
	}
	public String examGameHomeAnalysis(){
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
    	Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		if(month.length()==1)
		{
			month="0"+month;
		}
		if(date.length()==1)
		{
			date="0"+date;
		}
		//String currentTime=year+"-"+month+"-"+date;
		String currentTime=year+"-"+month;
		compeitionRankAnalysis=service.findCompetitionRankRightNowByUser(usr, currentTime);
		compeitionScoreAnalysis=service.dispCompetitionGradeByUser(usr);
    	return "examGameHomeAnalysis";
	}
	/**
	 * 跳转到examGameHomeDisp.jsp
	 * @return
	 */
	public String examGameHomeDisp(){
		Calendar calendar=Calendar.getInstance();
    	startTime=calendar.getTimeInMillis();
    	QuestionBank question=service.findQuestionRandomly();

    	String compQuestionContent=question.getContent();
    	String compQuestionPic=question.getQuestionPic();
    	String compQuestionType=question.getType();
    	String compQuestionId=String.valueOf(question.getId());
    	String competitionNo=String.valueOf(Integer.parseInt(compLevel)+1);
    	compQuestion.setCompQuestionType(compQuestionType);
    	compQuestion.setCompetitionNo(competitionNo);
    	compQuestion.setCompQuestionContent(compQuestionContent);
    	compQuestion.setCompQuestionPic(compQuestionPic);
    	
    	compQuestion.setCompQuestionId(compQuestionId);
    	
		return "examGameHomeDisp";
	}
	
	public ErrorSetService getErrorSetService() {
		return errorSetService;
	}
	public void setErrorSetService(ErrorSetService errorSetService) {
		this.errorSetService = errorSetService;
	}
	public CompetitionService getService() {
		return service;
	}
	public void setService(CompetitionService service) {
		this.service = service;
	}
	public QuestionBank getQuestionBank() {
		return questionBank;
	}
	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}
	public String getCompeitionRankAnalysis() {
		return compeitionRankAnalysis;
	}
	public void setCompeitionRankAnalysis(String compeitionRankAnalysis) {
		this.compeitionRankAnalysis = compeitionRankAnalysis;
	}
	public String getCompeitionScoreAnalysis() {
		return compeitionScoreAnalysis;
	}
	public void setCompeitionScoreAnalysis(String compeitionScoreAnalysis) {
		this.compeitionScoreAnalysis = compeitionScoreAnalysis;
	}
	public List<String[]> getCompetitionRankTopFiveNow() {
		return competitionRankTopFiveNow;
	}
	public void setCompetitionRankTopFiveNow(
			List<String[]> competitionRankTopFiveNow) {
		this.competitionRankTopFiveNow = competitionRankTopFiveNow;
	}
	public List<String[]> getCompetitionRankTopFiveHis() {
		return competitionRankTopFiveHis;
	}
	public void setCompetitionRankTopFiveHis(
			List<String[]> competitionRankTopFiveHis) {
		this.competitionRankTopFiveHis = competitionRankTopFiveHis;
	}
	
	public MyCompetitionInfo getMyCompetitionInfo() {
		return myCompetitionInfo;
	}
	public void setMyCompetitionInfo(MyCompetitionInfo myCompetitionInfo) {
		this.myCompetitionInfo = myCompetitionInfo;
	}
	public CompQuestionPo getCompQuestion() {
		return compQuestion;
	}
	public void setCompQuestion(CompQuestionPo compQuestion) {
		this.compQuestion = compQuestion;
	}
	public String getCompLevel() {
		return compLevel;
	}
	public void setCompLevel(String compLevel) {
		this.compLevel = compLevel;
	}
	public String getCompAnswer() {
		return compAnswer;
	}
	public void setCompAnswer(String compAnswer) {
		this.compAnswer = compAnswer;
	}
	public String getResString() {
		return resString;
	}
	public void setResString(String resString) {
		this.resString = resString;
	}
	public CompQuestionAnswerPo getCompQuestionAnswerPo() {
		return compQuestionAnswerPo;
	}
	public void setCompQuestionAnswerPo(CompQuestionAnswerPo compQuestionAnswerPo) {
		this.compQuestionAnswerPo = compQuestionAnswerPo;
	}
	public long getCompTimeUsed() {
		return compTimeUsed;
	}
	public void setCompTimeUsed(long compTimeUsed) {
		this.compTimeUsed = compTimeUsed;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
