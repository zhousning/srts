package com.srts.learning.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.service.QuestionBankManageService;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.domain.OnlineExercise;
import com.srts.learning.po.ExerciseJudgeAnswerPo;
import com.srts.learning.service.OnlineExerciseService;
import com.srts.system.domain.Sys_User;
/**
 * 
 * @author  2014-5-23 上午05:22:13
 *
 */
@Controller
@Scope("prototype")
public class OnlineExerciseAction extends BaseActionImpl<OnlineExercise>{
	private static final long serialVersionUID = 1L;
	@Resource
	private OnlineExerciseService service;
	@Resource
	private QuestionBankManageService qBService;

	private OnlineExercise onlineExercise = new OnlineExercise();
	private List<QuestionBank> questionBankList=new ArrayList<QuestionBank>();
	private String chapterStr="1";//获取提交的章节
	private int testNum;//待测试题总数
	private String testType;//测试类型
	private String bookID="1";//获取书的id
	private String answerInfo;//获取员工每题答案，order,id,content
	private String resString;//提交结果
	private String resAcur;//练习准确率
	private String getRecentAccuracyRateN;
	private String getRecentAccuracyStabilityN;
	
	private List<Book> books = new ArrayList<Book>();//获取所有的书用于选择章节
	private List<BookChapter> chapters = new ArrayList<BookChapter>();//获取书的章节
	private List<QuestionBank> questions = new ArrayList<QuestionBank>();//获取试题
	
	@Resource
	private QuestionBankManageService questionBankManageService;
	public OnlineExercise getModel() {
		return null;
	}

	public void prepare() throws Exception {}

	/**
	 * 在线练习获取所有要练习的书，及第一本书的章节
	 * @return
	 */
	public String onlineExerciseList(){
		books = service.getAllBooks();//获取所有的书
		chapters = service.getBookChaptersByBookID(Long.parseLong(bookID));//显示第一本书的章节
		return "onlineExerciseList";
	}
	
	public String onlineExerciseAnalysis()
	{
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		getRecentAccuracyRateN=service.getRecentAccuracyRateN(usr);
		getRecentAccuracyStabilityN=service.getRecentAccuracyStabilityN(usr);
		return "onlineExerciseAnalysis";
	}
	/**
	 * 在线练习获取所有要练习的书的章节
	 * @return
	 */
	public String onlineExerciseChpater(){
		long id = Long.parseLong(bookID);
		chapters = service.getBookChaptersByBookID(id);//显示第一本书的章节
		return "onlineExerciseChpater";
	}
	
	/**
	 * 跳转到onlineExerciseDisp页面，
	 * T1:章节练习 T2:随机练习T3:题目类型
	 * @return
	 */
	public String onlineExerciseDisp(){
		//System.out.println(testNum);
		List<QuestionBank> oneList=questionBankManageService.findQuestionBank("from QuestionBank");
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0; list.size()<testNum; i++){
			int index=new Random().nextInt(oneList.size());
			if(!list.contains(index)){
				list.add(index);
			}
		}
		for(int i=0; i<list.size(); i++){
			questionBankList.add(oneList.get(list.get(i)));
		}
		System.out.println(questionBankList.size());
		return "onlineExerciseDisp";
	}
	
	/**
	 * 员工提交答案
	 * 格式为：order*questionbankId*answer|order*questionbankId*answer|
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String onlineExerciseAnswerCheck() throws UnsupportedEncodingException{
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		List<Book> bookList=service.getAllBooks();
		Book book=new Book();
		for(int i=0;i<bookList.size();i++)
		{
			if(bookList.get(i).getId()==Long.parseLong(bookID))
			{
				book=bookList.get(i);
			}
		}
		answerInfo = java.net.URLDecoder.decode(answerInfo,"UTF-8"); 
		answerInfo = java.net.URLDecoder.decode(answerInfo,"UTF-8"); 
		String exerciseName=book.getBookName()+"|"+chapterStr;
		String[] ansSplit1=answerInfo.split("\\|");
		List<String[]> answerList=new ArrayList<String[]>();
		for(int j=0;j<ansSplit1.length;j++)
		{
			answerList.add(ansSplit1[j].split(","));
		}
		List <ExerciseJudgeAnswerPo> resList=new ArrayList<ExerciseJudgeAnswerPo>();
		int right=0;
		for(int i=0;i<answerList.size();i++)
		{
			QuestionBank question=qBService.findQuestionById(Long.parseLong(answerList.get(i)[1]));
			int resultStatus=service.judgeAnswer(question, answerList.get(i)[2]);
			if(resultStatus==1)
			{
				right++;
			}
			ExerciseJudgeAnswerPo temp=new ExerciseJudgeAnswerPo();
			temp.setAnswer(answerList.get(i)[2]);
			temp.setQuestionResult(question);
			temp.setResultStatus(resultStatus);
			resList.add(temp);
		}
		resAcur=String.valueOf((float)right/(float)answerList.size());
		boolean res=service.updateTable(usr, resList, exerciseName);
		if(res==true)
		{
			resString="success";
		}
		else
		{
			resString="fail";
		}
		return "onlineExerciseAnswerCheck";
	}

	public OnlineExercise getOnlineExercise() {
		return onlineExercise;
	}

	public void setOnlineExercise(OnlineExercise onlineExercise) {
		this.onlineExercise = onlineExercise;
	}

	public String getChapterStr() {
		return chapterStr;
	}

	public void setChapterStr(String chapterStr) {
		this.chapterStr = chapterStr;
	}


	public int getTestNum() {
		return testNum;
	}

	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getAnswerInfo() {
		return answerInfo;
	}

	public void setAnswerInfo(String answerInfo) {
		this.answerInfo = answerInfo;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<BookChapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<BookChapter> chapters) {
		this.chapters = chapters;
	}

	public List<QuestionBank> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionBank> questions) {
		this.questions = questions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResString() {
		return resString;
	}

	public void setResString(String resString) {
		this.resString = resString;
	}

	public String getGetRecentAccuracyRateN() {
		return getRecentAccuracyRateN;
	}

	public void setGetRecentAccuracyRateN(String getRecentAccuracyRateN) {
		this.getRecentAccuracyRateN = getRecentAccuracyRateN;
	}

	public String getGetRecentAccuracyStabilityN() {
		return getRecentAccuracyStabilityN;
	}

	public void setGetRecentAccuracyStabilityN(String getRecentAccuracyStabilityN) {
		this.getRecentAccuracyStabilityN = getRecentAccuracyStabilityN;
	}

	public String getResAcur() {
		return resAcur;
	}

	public void setResAcur(String resAcur) {
		this.resAcur = resAcur;
	}

	public List<QuestionBank> getQuestionBankList() {
		return questionBankList;
	}

	public void setQuestionBankList(List<QuestionBank> questionBankList) {
		this.questionBankList = questionBankList;
	}

	
	///////////////////////////////////////////////
	
	
}
