package com.srts.learning.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;

import com.srts.learning.domain.ErrorSet;
import com.srts.learning.po.ErrorSetAnswerPo;
import com.srts.learning.po.ErrorSetPo;
import com.srts.learning.po.ErrorSetQuestionPo;
import com.srts.learning.po.ErrorSetSimplifiedDisplayedPo;
import com.srts.learning.service.ErrorSetService;
import com.srts.system.domain.Sys_User;

@Controller
@Scope("prototype")
public class ErrorSetAction extends BaseActionImpl<ErrorSet> {
	private static final long serialVersionUID = 1L;
	@Resource
	private ErrorSetService service;
	private ErrorSetPo errorSetPo = new ErrorSetPo();
	//private ErrorSetQuestionPo []errorSetQuestionPo;
	private List<ErrorSetQuestionPo> errorSetQuestionPo;
	private List<ErrorSetSimplifiedDisplayedPo> errorSetSimplifiedDisplayedPo;
	private ErrorSetAnswerPo errorSetAnswerPo;
	private String modelType;
	private String flag;
	private String type;
	private String timeLength;
	private String questionId;
	private String questionAnswer;
	private String resString = null;
	private List<String> allPageList;
	private String resNum="0";
	private String curPage="1";
	private String pageAmount="1";
	private String newPage="1";
	
	
	public String SetAnswerAndId(){
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		errorSetAnswerPo = new ErrorSetAnswerPo();
		errorSetAnswerPo.setErrorSetQuestionId(questionId);
		errorSetAnswerPo.setErrorSetQuestionAnswer(questionAnswer);
		System.out.println(errorSetAnswerPo.getErrorSetQuestionId());
		System.out.println(errorSetAnswerPo.getErrorSetQuestionAnswer());
		resString = service.judgeTheAnswer(usr, errorSetAnswerPo);
		return "SetAnswerAndId";
	}
//	public String ErrorSetDisplaySe()
//	{
//		Sys_User usr=new Sys_User();
//		usr.setId(1);
//		List<String[]> res = service.findErrorSetSimpilfiedDisplayedById(usr);
//		int length = res.size();
//		errorSetSimplifiedDisplayedPo = new ArrayList<ErrorSetSimplifiedDisplayedPo>();
//		for(int i=0;i<length;i++){
//			ErrorSetSimplifiedDisplayedPo temp=new ErrorSetSimplifiedDisplayedPo();
//			String errorSetQuestionId= res.get(i)[0];
//			String errorSetQuestionType = res.get(i)[1];
//			String errorSetQuestionContent = res.get(i)[2];
//			String errorSetQuestionFlag = res.get(i)[3];
//			String errorSetQuestionLastTestTime = res.get(i)[4];
//			temp.setQuestionId(errorSetQuestionId);
//			temp.setType(errorSetQuestionType);
//			temp.setContent(errorSetQuestionContent);
//			temp.setFlag(errorSetQuestionFlag);
//			temp.setLastTestTime(errorSetQuestionLastTestTime);
//			System.out.println(errorSetQuestionId);
//			System.out.println(errorSetQuestionType);
//			//System.out.println(errorSetQuestionType);
//			errorSetSimplifiedDisplayedPo.add(temp);
//		}
//		return "errorSetDisplaySe";
//	}
	public String getResString() {
		return resString;
	}
	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(String timeLength) {
		this.timeLength = timeLength;
	}
	
	public String getModelType() {
		return modelType;
	}
	
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public ErrorSetAnswerPo getErrorSetAnswerPo() {
		return errorSetAnswerPo;
	}

	public void setErrorSetAnswerPo(ErrorSetAnswerPo errorSetAnswerPo) {
		this.errorSetAnswerPo = errorSetAnswerPo;
	}

	private ErrorSet errorSet = new ErrorSet();
	public ErrorSet getModel() {
		return null;
	}

	public void prepare() throws Exception {
		
	}

	public ErrorSetService getService() {
		return service;
	}

	public void setService(ErrorSetService service) {
		this.service = service;
	}

	public ErrorSet getErrorSet() {
		return errorSet;
	}

	public void setErrorSet(ErrorSet errorSet) {
		this.errorSet = errorSet;
	}

	public void setErrorSetPo(ErrorSetPo errorSetPo) {
		this.errorSetPo = errorSetPo;
	}

	public List<ErrorSetQuestionPo> getErrorSetQuestionPo() {
		return errorSetQuestionPo;
	}

	public void setErrorSetQuestionPo(List<ErrorSetQuestionPo> errorSetQuestionPo) {
		this.errorSetQuestionPo = errorSetQuestionPo;
	}

	public String errorSetList(){
		//简要显示
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		List<String[]> res = service.findErrorSetSimpilfiedDisplayedById(usr);
		int length = res.size();
		errorSetSimplifiedDisplayedPo = new ArrayList<ErrorSetSimplifiedDisplayedPo>();
		for(int i=0;i<length;i++){
			ErrorSetSimplifiedDisplayedPo temp=new ErrorSetSimplifiedDisplayedPo();
			String errorSetQuestionId= res.get(i)[0];
			String errorSetQuestionType = res.get(i)[1];
			String errorSetQuestionContent = res.get(i)[2];
			String errorSetQuestionFlag = res.get(i)[3];
			String errorSetQuestionLastTestTime = res.get(i)[4];
			temp.setQuestionId(errorSetQuestionId);
			temp.setType(errorSetQuestionType);
			temp.setContent(errorSetQuestionContent);
			temp.setFlag(errorSetQuestionFlag);
			temp.setLastTestTime(errorSetQuestionLastTestTime);
			errorSetSimplifiedDisplayedPo.add(temp);
		}
		return "errorSetList";
	}
	public List<ErrorSetSimplifiedDisplayedPo> getErrorSetSimplifiedDisplayedPo() {
		return errorSetSimplifiedDisplayedPo;
	}
	public void setErrorSetSimplifiedDisplayedPo(
			List<ErrorSetSimplifiedDisplayedPo> errorSetSimplifiedDisplayedPo) {
		this.errorSetSimplifiedDisplayedPo = errorSetSimplifiedDisplayedPo;
	}
	public String ErrorSetAnalysis(){
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		if(errorSetPo==null){
			errorSetPo = new ErrorSetPo();
		}
		String errorSetCountByFlag= service.getCountByErrorSetFlagUsrId(usr);
		String errorSetQuestionCountByType = service.getCountByErrorSetTypeUsrId(usr);
		String errorSetFlagCount = service.getFindErrorSetFlagSumById(usr);
		errorSetPo.setErrorSetCountByFlag(errorSetCountByFlag);
		errorSetPo.setErrorSetFlagCount(errorSetFlagCount);
		errorSetPo.setErrorSetQuestionCountByType(errorSetQuestionCountByType);
		return "errorSetAnalysis";
	}
	public String ErrorSetDisp() throws UnsupportedEncodingException{
		int length = 0;
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		
		if(modelType.equals("zhangwochengdu")){
			List<String[]> res = service.findByErrorSetFlagUsrId(usr,Integer.parseInt(flag));
			length = res.size();
			errorSetQuestionPo = new ArrayList<ErrorSetQuestionPo>();
			curPage=newPage;
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
			for(int i=curStart;i<curEnd;i++){
				ErrorSetQuestionPo temp=new ErrorSetQuestionPo();
				String errorSetQuestionId= res.get(i)[0];
				String errorSetQuestionType = res.get(i)[1];
				String errorSetQuestionContent = res.get(i)[2];
				temp.setErrorSetQuestionId(errorSetQuestionId);
				temp.setErrorSetQuestionType(errorSetQuestionType);
				temp.setErrorSetQuestionContent(errorSetQuestionContent);
				errorSetQuestionPo.add(temp);
			}
		}else if(modelType.equals("cuotileixing")){
			System.out.println("type="+type);
			String typeChm=null;
			if(type.equals("danxuanti")==true)
			{
				typeChm="单选题";
			}else if(type.equals("duoxuanti")==true)
			{
				typeChm="多选题";
			} else if(type.equals("panduanti")==true)
			{
				typeChm="判断题";
			} else if(type.equals("gaicuoti")==true)
			{
				typeChm="改错题";
			} else if(type.equals("danxuanti")==true)
			{
				typeChm="填空题";
			} else if(type.equals("danxuanti")==true)
			{
				typeChm="名词解释";
			} else if(type.equals("danxuanti")==true)
			{
				typeChm="简答题";
			}
			System.out.println("type="+type);
			List<String[]> res = service.findByErrorSetTypeUsrId(usr, typeChm);
			length = res.size();
			errorSetQuestionPo = new ArrayList<ErrorSetQuestionPo>();
			curPage=newPage;
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
			for(int i=curStart;i<curEnd;i++){
				ErrorSetQuestionPo temp=new ErrorSetQuestionPo();
				String errorSetQuestionId= (res.get(i))[0];
				String errorSetQuestionType = (res.get(i))[1];
				String errorSetQuestionContent = (res.get(i))[2];
				temp.setErrorSetQuestionId(errorSetQuestionId);
				temp.setErrorSetQuestionType(errorSetQuestionType);
				temp.setErrorSetQuestionContent(errorSetQuestionContent);
				errorSetQuestionPo.add(temp);
			}
		}else if(modelType.equals("cuotishijian")){
			Calendar calendar=Calendar.getInstance();
			System.out.println("timeLength="+timeLength);
			calendar.add(Calendar.DATE,-(Integer.parseInt(timeLength)));
			String year=String.valueOf(calendar.get(Calendar.YEAR));
			String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
			String date=String.valueOf(calendar.get(Calendar.DATE));
			String lastTestTime=year+"-"+month+"-"+date;
			if(month.length()==1)
			{
				month="0"+month;
			}
			if(date.length()==1)
			{
				date="0"+date;
			}
			List<String[]> res = service.findByLastTestTimeUsrId(usr, lastTestTime);
			length = res.size();
			errorSetQuestionPo = new ArrayList<ErrorSetQuestionPo>();
			curPage=newPage;
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
			for(int i=curStart;i<curEnd;i++){
				ErrorSetQuestionPo temp=new ErrorSetQuestionPo();
				String errorSetQuestionId= (res.get(i))[0];
				String errorSetQuestionType = (res.get(i))[1];
				String errorSetQuestionContent = (res.get(i))[2];
				temp.setErrorSetQuestionId(errorSetQuestionId);
				temp.setErrorSetQuestionType(errorSetQuestionType);
				temp.setErrorSetQuestionContent(errorSetQuestionContent);
				errorSetQuestionPo.add(temp);
			}
		}
		return "errorSetDisp";
	}
	public String errorSetDisp(){
		return "errorSetDisp";
	}

	public ErrorSetPo getErrorSetPo() {
		return errorSetPo;
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
	public void setResString(String resString) {
		this.resString = resString;
	}
	
}
