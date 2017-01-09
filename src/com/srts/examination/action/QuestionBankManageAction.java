package com.srts.examination.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.po.QuestionBankManagePo;
import com.srts.examination.po.QuestionBankPo;
import com.srts.examination.po.QuestionBankUpdateLogPo;
import com.srts.examination.po.QuestionBankUploadLogPo;
import com.srts.examination.service.QuestionBankManageService;
import com.srts.system.domain.Sys_User;

@Controller
public class QuestionBankManageAction {
	
	private static final long serialVersionUID = 1L;
	@Resource
	private QuestionBankManageService service;
	private QuestionBankManagePo questionBankManagePo = new QuestionBankManagePo();
	private List<QuestionBankUploadLogPo> questionBankUploadLog = new ArrayList<QuestionBankUploadLogPo>();
	private List<QuestionBankUpdateLogPo> questionBankUpdateLog = new ArrayList<QuestionBankUpdateLogPo>();
	private String questionId;
	private String questionType;
	private String questionKeyWords;
	private String deleteQuestionId;
	private String updateQuestionId;
	private String updateQuestionAnswer;
	private String updateQuestionContent;
	private String updateQuestionPic;
	private File questionPicture;
	private File uploadQuestionBank;
	private String updateSelectOptions;
	private String updateResString;
	private String resUpdateContentString;
	private String resUpdateAnswerString;
	private String resDeleteString;
	private String resUpdateQuestionPicString;
	private String retRes;
	private String selectOptions;
	private String model;
	private String randomNumber;
	private String excelPath;
	private List<String[]> questionNumByType=new ArrayList<String[]>();
	private QuestionBankPo questionResSearchById = new QuestionBankPo();
	private List<QuestionBankPo> questionResSearchByConditions;
	private List<QuestionBankPo> questionAllDisp;
	private QuestionBank questionBank = new QuestionBank();
	private List<String> allPageList;
	private String resNum="0";
	private String curPage="1";
	private String pageAmount="1";
	private String newPage="1";
	
	private List<String> allPageList1;
	private String resNum1="0";
	private String curPage1="1";
	private String pageAmount1="1";
	private String newPage1="1";
	
	
	public QuestionBank getModel() {
		return null;
	}
	public void prepare() throws Exception {		
	}
	/*
	 * 按"单选题","多选题","判断题","填空题","改错题","名词解释","简答题","问答题"的顺序获取题库中题目数目
	 */
	public void QuestionNumDisp()
	{
		questionNumByType=service.findQuestionNumByType();	
	}
	/*
	 * 题库数据分析：uploadQuestionNumPerKind为题库中每月上传题目数目折线图，uploadQuestionNumPerMonth为题库每月上传题目数目分类直方图
	 */
	public String QuestionBankManageAnalysis(){
		if(questionBankManagePo==null){
			questionBankManagePo = new QuestionBankManagePo();
		}
		String uploadQuestionNumPerKind=service.findUploadQuestionNumPerKind();
		String uploadQuestionNumPerMonth=service.findUploadQuestionNumPerMonth();
		questionBankManagePo.setUploadQuestionNumPerKind(uploadQuestionNumPerKind);
		questionBankManagePo.setUploadQuestionNumPerMonth(uploadQuestionNumPerMonth);
		return "questionBankManageAnalysis";
	}
	/*
	 * 题库中最新上传的5题的记录
	 */
	public String QuestionBankUploadLogList()
	{
		List<String[]> res = new ArrayList<String[]>();
		res=service.findTopFiveQuestionOrderByUploadTime();
		int length = res.size();
		questionBankUploadLog = new ArrayList<QuestionBankUploadLogPo>();
		for(int i=0;i<length;i++){
			QuestionBankUploadLogPo temp =new QuestionBankUploadLogPo();
			String questionBankUploadDate= res.get(i)[0];
			String questionBankSeContent = res.get(i)[1];
			String questionBankType = res.get(i)[2];
			temp.setUploadDate(questionBankUploadDate);
			temp.setSeContent(questionBankSeContent);
			temp.setQuestionType(questionBankType);
			questionBankUploadLog.add(temp);
		}
		return "questionBankManageList";
	}
	/*
	 * 题库中最新修改的5题的记录
	 */
	public String QuestionBankUpdateLogList()
	{
		List<String[]> res = new ArrayList<String[]>();
		res=service.findTopFiveQuestionOrderBylastUpdateTime();
		int length = res.size();
		questionBankUpdateLog = new ArrayList<QuestionBankUpdateLogPo>();
		for(int i=0;i<length;i++){
			QuestionBankUpdateLogPo temp =new QuestionBankUpdateLogPo();
			String questionBankUpdateDate= res.get(i)[0];
			String questionBankSeContent = res.get(i)[1];
			String questionBankType = res.get(i)[2];
			temp.setUpdateDate(questionBankUpdateDate);
			temp.setSeContent(questionBankSeContent);
			temp.setQuestionType(questionBankType);
			questionBankUpdateLog.add(temp);
		}
		return "questionBankManageList";
	}
	/*
	 * 按题目id查找题目结果显示
	 */
	public String QuestionSearchResByIdDisp()
	{
		QuestionBank res=new QuestionBank();
		res=service.findQuestionById(Long.parseLong(questionId));
		String id=String.valueOf(res.getId());
		String type=res.getType();
		String content=res.getContent();
	    String questionPic=res.getQuestionPic();
		String answer=res.getAnswer();
		String bookChapter=String.valueOf(res.getBookChapter().getId());
		String uploadTime=res.getUploadTime();
		String lastUpdateTime=res.getLastUpdateTime();
		String selectOptions=String.valueOf(res.getSelectOptions());
		questionResSearchById.setId(id);
		questionResSearchById.setType(type);
		questionResSearchById.setContent(content);
		questionResSearchById.setQuestionPic(questionPic);
		questionResSearchById.setAnswer(answer);
		questionResSearchById.setBookChapter(bookChapter);
		questionResSearchById.setUploadTime(uploadTime);
		questionResSearchById.setLastUpdateTime(lastUpdateTime);
		questionResSearchById.setSelectOptions(selectOptions);
		return "questionBankManageDisp";
	}
	/*
	 * 按题目的类型或关键词或按题目关键词和类别查找题目显示
	 */
	public String QuestionSearchResByKeyWordsTypeDisp() throws UnsupportedEncodingException
	{
		questionResSearchByConditions=new ArrayList<QuestionBankPo>();
		questionKeyWords = java.net.URLDecoder.decode(questionKeyWords,"UTF-8"); 
		questionType = java.net.URLDecoder.decode(questionType,"UTF-8");
		questionKeyWords = java.net.URLDecoder.decode(questionKeyWords,"UTF-8"); 
		questionType = java.net.URLDecoder.decode(questionType,"UTF-8");
		List<String[]> res = new ArrayList<String[]>();
		if(questionType.equals("")==true&&questionKeyWords.equals("")==false)
		{
			res=service.findQuestionByKeyWords(questionKeyWords);
			curPage1=newPage1;
			int length=res.size();
			resNum1=String.valueOf(length);
			allPageList1=new ArrayList<String>();
			int pageNum=0;
			if(length%5==0)
			{
				pageNum=length/5;//一页显示5条
				pageAmount1=String.valueOf(pageNum);
			}
			else
			{
				pageNum=length/5+1;//一页显示5条
				pageAmount1=String.valueOf(pageNum);
			}
			for(int j=1;j<=pageNum;j++)
			{
				allPageList1.add(String.valueOf(j));
			}
			int curStart=(Integer.parseInt(curPage1)-1)*5;
			int curEnd=(Integer.parseInt(curPage1)*5-1)<(length-1)?(Integer.parseInt(curPage1)*5-1):(length-1);
			for(int i=curStart;i<=curEnd;i++)
			{
				QuestionBankPo temp=new QuestionBankPo(res.get(i)[0],res.get(i)[1],res.get(i)[2],
						res.get(i)[5],res.get(i)[3],res.get(i)[4],res.get(i)[6],res.get(i)[7],res.get(i)[8]);
				questionResSearchByConditions.add(temp);
			}
		}
		else if(questionType.equals("")==false&&questionKeyWords.equals("")==true)
		{
			res=service.findQuestionByType(questionType);
			curPage1=newPage1;
			int length=res.size();
			resNum1=String.valueOf(length);
			allPageList1=new ArrayList<String>();
			int pageNum=0;
			if(length%5==0)
			{
				pageNum=length/5;//一页显示5条
				pageAmount1=String.valueOf(pageNum);
			}
			else
			{
				pageNum=length/5+1;//一页显示5条
				pageAmount1=String.valueOf(pageNum);
			}
			for(int j=1;j<=pageNum;j++)
			{
				allPageList1.add(String.valueOf(j));
			}
			int curStart=(Integer.parseInt(curPage1)-1)*5;
			int curEnd=(Integer.parseInt(curPage1)*5-1)<(length-1)?(Integer.parseInt(curPage1)*5-1):(length-1);
			for(int i=curStart;i<=curEnd;i++)
			{
				QuestionBankPo temp=new QuestionBankPo(res.get(i)[0],res.get(i)[1],res.get(i)[2],
						res.get(i)[5],res.get(i)[3],res.get(i)[4],res.get(i)[6],res.get(i)[7],res.get(i)[8]);
				questionResSearchByConditions.add(temp);
			}
		}
		else if(questionType.equals("")==false&&questionKeyWords.equals("")==false)
		{
			res=service.findQuestionByTypeAndKeyWords(questionType, questionKeyWords);
			curPage1=newPage1;
			int length=res.size();
			resNum1=String.valueOf(length);
			allPageList1=new ArrayList<String>();
			int pageNum=0;
			if(length%5==0)
			{
				pageNum=length/5;//一页显示5条
				pageAmount1=String.valueOf(pageNum);
			}
			else
			{
				pageNum=length/5+1;//一页显示5条
				pageAmount1=String.valueOf(pageNum);
			}
			for(int j=1;j<=pageNum;j++)
			{
				allPageList1.add(String.valueOf(j));
			}
			int curStart=(Integer.parseInt(curPage1)-1)*5;
			int curEnd=(Integer.parseInt(curPage1)*5-1)<(length-1)?(Integer.parseInt(curPage1)*5-1):(length-1);
			for(int i=curStart;i<=curEnd;i++)
			{
				QuestionBankPo temp=new QuestionBankPo(res.get(i)[0],res.get(i)[1],res.get(i)[2],
						res.get(i)[5],res.get(i)[3],res.get(i)[4],res.get(i)[6],res.get(i)[7],res.get(i)[8]);
				questionResSearchByConditions.add(temp);
			}
		}
		else
		{
			System.out.println("请输入参数!");
		}
		return "keyAndTypeResult";
	}
	/*
	 * 显示所有题目详细信息
	 */
	public String FindAllQuestionDisp()
	{
		questionAllDisp=new ArrayList<QuestionBankPo>();
		if(model.equals("shangchuanshijian"))
		{
		List<String[]> res = new ArrayList<String[]>();
		res=service.findAllQuestionUploadTimeDesc();
		curPage=newPage;
		int length=res.size();
		resNum=String.valueOf(length);
		allPageList=new ArrayList<String>();
		int pageNum=0;
		if(length%5==0)
		{
			pageNum=length/5;//一页显示5条
			pageAmount=String.valueOf(pageNum);
		}
		else
		{
			pageNum=length/5+1;//一页显示5条
			pageAmount=String.valueOf(pageNum);
		}
		for(int j=1;j<=pageNum;j++)
		{
			allPageList.add(String.valueOf(j));
		}
		int curStart=(Integer.parseInt(curPage)-1)*5;
		int curEnd=(Integer.parseInt(curPage)*5-1)<length?(Integer.parseInt(curPage)*5-1):length;
		for(int i=curStart;i<curEnd;i++)
		{
			QuestionBankPo temp=new QuestionBankPo(res.get(i)[0],res.get(i)[1],res.get(i)[2],
			res.get(i)[5],res.get(i)[3],res.get(i)[4],res.get(i)[6],res.get(i)[7],res.get(i)[8]);
			questionAllDisp.add(temp);
		}
		}
		else if(model.equals("xiugaishijian"))
		{
			List<String[]> res = new ArrayList<String[]>();
			res=service.findAllQuestionUpdateTimeDesc();
			curPage=newPage;
			int length=res.size();
			resNum=String.valueOf(length);
			allPageList=new ArrayList<String>();
			int pageNum=0;
			if(length%5==0)
			{
				pageNum=length/5;//一页显示5条
				pageAmount=String.valueOf(pageNum);
			}
			else
			{
				pageNum=length/5+1;//一页显示5条
				pageAmount=String.valueOf(pageNum);
			}
			for(int j=1;j<=pageNum;j++)
			{
				allPageList.add(String.valueOf(j));
			}
			int curStart=(Integer.parseInt(curPage)-1)*5;
			int curEnd=(Integer.parseInt(curPage)*5-1)<(length-1)?(Integer.parseInt(curPage)*5-1):(length-1);
			for(int i=curStart;i<=curEnd;i++)
			{
				QuestionBankPo temp=new QuestionBankPo(res.get(i)[0],res.get(i)[1],res.get(i)[2],
				res.get(i)[5],res.get(i)[3],res.get(i)[4],res.get(i)[6],res.get(i)[7],res.get(i)[8]);
				questionAllDisp.add(temp);
			}
			}
		return "questionBankManageDisp";
	}
	/*
	 * 更新题目答案
	 */
	public String UpdateQuestion()
	{
		
		//updateDataBase
		int selectOptionsNum=Integer.valueOf(updateSelectOptions);
		int resCon=service.updateQuestionContentById(Long.parseLong(updateQuestionId), updateQuestionContent, selectOptionsNum);
		int resAns=service.updateQuestionAnswerById(Long.parseLong(updateQuestionId), updateQuestionAnswer);
		if(resCon==1&&resAns==1)
		{
			updateResString="success";
		}
		else
		{
			updateResString="fail";
		}
		return "updateQuestionRes";
	}
	/*
	 * 更新题目图片
	 * */
	public String UploadQuestionBank()
	{
		String excelPath=service.saveQuestionBank(uploadQuestionBank);
		System.out.println(excelPath);
		service.saveQuestionInfo(excelPath);
		return "uploadQuestionBankRes";
	}
	public String UpdateQuestionPic()
	{
		String pictureFilePath = service.saveQuestionPic(questionPicture, updateQuestionPic);
		int res=service.updateQuestionPicById(Long.parseLong(updateQuestionId), pictureFilePath);
		randomNumber=String.valueOf(Math.random());
		questionBankManageDisp();
		return "updateQuestionPicRes";
	}
	/*
	 * 删除问题
	 */
	public String DeleteQuestion()
	{
		int res=service.deleteQuestionById(Long.parseLong(deleteQuestionId));
		System.out.println(res);
		if (res==1)
		{
			resDeleteString="success";
		}
		else
		{
			resDeleteString="fail";
		}
		return "deleteQuestionRes";
	}
	/**
	 * 跳转到questionBankManageList.jsp
	 * @return
	 */
	public String questionBankManageList(){		
		QuestionBankUploadLogList();
		QuestionBankUpdateLogList();
		QuestionNumDisp();
		return "questionBankManageList";
	}
	
	/**
	 * 跳转到questionBankManageDisp.jsp
	 * @return
	 */
	public String questionBankManageDisp(){
		FindAllQuestionDisp();
		return "questionBankManageDisp";
	}
	public QuestionBankManageService getService() {
		return service;
	}
	public void setService(QuestionBankManageService service) {
		this.service = service;
	}
	public QuestionBankManagePo getQuestionBankManagePo() {
		return questionBankManagePo;
	}
	public void setQuestionBankManagePo(QuestionBankManagePo questionBankManagePo) {
		this.questionBankManagePo = questionBankManagePo;
	}
	public List<QuestionBankUploadLogPo> getQuestionBankUploadLog() {
		return questionBankUploadLog;
	}
	public void setQuestionBankUploadLog(
			List<QuestionBankUploadLogPo> questionBankUploadLog) {
		this.questionBankUploadLog = questionBankUploadLog;
	}
	public List<QuestionBankUpdateLogPo> getQuestionBankUpdateLog() {
		return questionBankUpdateLog;
	}
	public void setQuestionBankUpdateLog(
			List<QuestionBankUpdateLogPo> questionBankUpdateLog) {
		this.questionBankUpdateLog = questionBankUpdateLog;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestionKeyWords() {
		return questionKeyWords;
	}
	public void setQuestionKeyWords(String questionKeyWords) {
		this.questionKeyWords = questionKeyWords;
	}
	public String getDeleteQuestionId() {
		return deleteQuestionId;
	}
	public void setDeleteQuestionId(String deleteQuestionId) {
		this.deleteQuestionId = deleteQuestionId;
	}
	public String getUpdateQuestionId() {
		return updateQuestionId;
	}
	public void setUpdateQuestionId(String updateQuestionId) {
		this.updateQuestionId = updateQuestionId;
	}
	public String getUpdateQuestionAnswer() {
		return updateQuestionAnswer;
	}
	public void setUpdateQuestionAnswer(String updateQuestionAnswer) {
		this.updateQuestionAnswer = updateQuestionAnswer;
	}
	public String getUpdateQuestionContent() {
		return updateQuestionContent;
	}
	public void setUpdateQuestionContent(String updateQuestionContent) {
		this.updateQuestionContent = updateQuestionContent;
	}
	public QuestionBankPo getQuestionResSearchById() {
		return questionResSearchById;
	}
	public void setQuestionResSearchById(QuestionBankPo questionResSearchById) {
		this.questionResSearchById = questionResSearchById;
	}
	public List<QuestionBankPo> getQuestionResSearchByConditions() {
		return questionResSearchByConditions;
	}
	public void setQuestionResSearchByConditions(
			List<QuestionBankPo> questionResSearchByConditions) {
		this.questionResSearchByConditions = questionResSearchByConditions;
	}
	public QuestionBank getQuestionBank() {
		return questionBank;
	}
	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<String[]> getQuestionNumByType() {
		return questionNumByType;
	}
	public void setQuestionNumByType(List<String[]> questionNumByType) {
		this.questionNumByType = questionNumByType;
	}
	public String getResUpdateContentString() {
		return resUpdateContentString;
	}
	public void setResUpdateContentString(String resUpdateContentString) {
		this.resUpdateContentString = resUpdateContentString;
	}
	public String getResUpdateAnswerString() {
		return resUpdateAnswerString;
	}
	public void setResUpdateAnswerString(String resUpdateAnswerString) {
		this.resUpdateAnswerString = resUpdateAnswerString;
	}
	public String getResDeleteString() {
		return resDeleteString;
	}
	public void setResDeleteString(String resDeleteString) {
		this.resDeleteString = resDeleteString;
	}
	public String getRetRes() {
		return retRes;
	}
	public void setRetRes(String retRes) {
		this.retRes = retRes;
	}
	public String getSelectOptions() {
		return selectOptions;
	}
	public void setSelectOptions(String selectOptions) {
		this.selectOptions = selectOptions;
	}
	public List<QuestionBankPo> getQuestionAllDisp() {
		return questionAllDisp;
	}
	public void setQuestionAllDisp(List<QuestionBankPo> questionAllDisp) {
		this.questionAllDisp = questionAllDisp;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getUpdateResString() {
		return updateResString;
	}
	public void setUpdateResString(String updateResString) {
		this.updateResString = updateResString;
	}
	public String getUpdateSelectOptions() {
		return updateSelectOptions;
	}
	public void setUpdateSelectOptions(String updateSelectOptions) {
		this.updateSelectOptions = updateSelectOptions;
	}
	public String getUpdateQuestionPic() {
		return updateQuestionPic;
	}
	public void setUpdateQuestionPic(String updateQuestionPic) {
		this.updateQuestionPic = updateQuestionPic;
	}
	public File getQuestionPicture() {
		return questionPicture;
	}
	public void setQuestionPicture(File questionPicture) {
		this.questionPicture = questionPicture;
	}
	public String getResUpdateQuestionPicString() {
		return resUpdateQuestionPicString;
	}
	public void setResUpdateQuestionPicString(String resUpdateQuestionPicString) {
		this.resUpdateQuestionPicString = resUpdateQuestionPicString;
	}
	public String getRandomNumber() {
		return randomNumber;
	}
	public void setRandomNumber(String randomNumber) {
		this.randomNumber = randomNumber;
	}
	public File getUploadQuestionBank() {
		return uploadQuestionBank;
	}
	public void setUploadQuestionBank(File uploadQuestionBank) {
		this.uploadQuestionBank = uploadQuestionBank;
	}
	public String getExcelPath() {
		return excelPath;
	}
	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}
	public List<String> getAllPageList() {
		return allPageList;
	}
	public void setAllPageList(List<String> allPageList) {
		this.allPageList = allPageList;
	}
	public String getResNum() {
		return resNum;
	}
	public void setResNum(String resNum) {
		this.resNum = resNum;
	}
	public String getCurPage() {
		return curPage;
	}
	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}
	public String getPageAmount() {
		return pageAmount;
	}
	public void setPageAmount(String pageAmount) {
		this.pageAmount = pageAmount;
	}
	public String getNewPage() {
		return newPage;
	}
	public void setNewPage(String newPage) {
		this.newPage = newPage;
	}
	public List<String> getAllPageList1() {
		return allPageList1;
	}
	public void setAllPageList1(List<String> allPageList1) {
		this.allPageList1 = allPageList1;
	}
	public String getResNum1() {
		return resNum1;
	}
	public void setResNum1(String resNum1) {
		this.resNum1 = resNum1;
	}
	public String getCurPage1() {
		return curPage1;
	}
	public void setCurPage1(String curPage1) {
		this.curPage1 = curPage1;
	}
	public String getPageAmount1() {
		return pageAmount1;
	}
	public void setPageAmount1(String pageAmount1) {
		this.pageAmount1 = pageAmount1;
	}
	public String getNewPage1() {
		return newPage1;
	}
	public void setNewPage1(String newPage1) {
		this.newPage1 = newPage1;
	}
	
}
