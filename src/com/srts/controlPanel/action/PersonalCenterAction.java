package com.srts.controlPanel.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.controlPanel.po.FavorCourseInfoPo;
import com.srts.controlPanel.po.FavorKlgBankInfoPo;
import com.srts.controlPanel.po.FavorThemeInfoPo;
import com.srts.controlPanel.po.MyAnswerInfoPo;
import com.srts.controlPanel.po.MyCompetitionInfoPo;
import com.srts.controlPanel.po.MyCourseInfoPo;
import com.srts.controlPanel.po.MyEstInfoPo;
import com.srts.controlPanel.po.MyExerciseInfoPo;
import com.srts.controlPanel.po.MyKlgUploadInfoPo;
import com.srts.controlPanel.po.MyNoticeInfoPo;
import com.srts.controlPanel.po.MyProblemInfoPo;
import com.srts.controlPanel.po.MyTestInfoPo;
import com.srts.controlPanel.po.MyThemeInfoPo;
import com.srts.controlPanel.service.PersonPasswordChangeService;
import com.srts.controlPanel.service.PersonalInfoListService;
import com.srts.estimation.service.CompanyEstimateService;
import com.srts.system.domain.Sys_Department;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.UserService;

@Controller
public class PersonalCenterAction extends BaseActionImpl<Sys_User>{
	@Resource
	private PersonalInfoListService service;
	@Resource
	private UserService userService;
	@Resource
	private PersonPasswordChangeService passwordService;
	
	private Sys_User usr=new Sys_User();
	private static final long serialVersionUID = 1L;
	private List<MyNoticeInfoPo> selectNoticeByUser;
	private List<MyTestInfoPo> selectTrainTestInfoByUser;
	private List<MyTestInfoPo> selectMockTestInfoByUser;
	private List<MyCompetitionInfoPo> selectCompetitionInfoByUser;
	private List<MyCourseInfoPo> selectCourseInfoByUser;
	private List<FavorCourseInfoPo> selectFavorCourse;
	private List<MyExerciseInfoPo> selectExerciseInfoByUser;
	private List<MyKlgUploadInfoPo> selectKlgBankInfoByUser;
	private List<FavorKlgBankInfoPo> selectFavorKlgBank;
	private List<MyProblemInfoPo> selectProblemInfoByUser;
	private List<MyAnswerInfoPo> selectAnswerInfoByUser;
	private List<MyThemeInfoPo> selectThemeByUser;
	private List<FavorThemeInfoPo> selectFavorThemeByUser;
	private MyEstInfoPo setEstInfo;

	
	private String oldPassword="";
	private String newPassword="";
	private String passwordChangeRes="";
	//培训考核
	private String resNum="0";
	private String pageNum="1";
	private List<String> allPageList;
	//模拟考试
	private String resNum1="0";
	private String pageNum1="1";
	private List<String> allPageList1;
	//竞技问答
	private String resNum2="0";
	private String pageNum2="1";
	private List<String> allPageList2;
	//学习课程
	private String resNum3="0";
	private String pageNum3="1";
	private List<String> allPageList3;
	//练习记录
	private String resNum4="0";
	private String pageNum4="1";
	private List<String> allPageList4;
	//我的知识库
	private String resNum5="0";
	private String pageNum5="1";
	private List<String> allPageList5;
	//我的问题
	private String resNum6="0";
	private String pageNum6="1";
	private List<String> allPageList6;
	//我的回答
	private String resNum7="0";
	private String pageNum7="1";
	private List<String> allPageList7;
	//我的主题
	private String resNum8="0";
	private String pageNum8="1";
	private List<String> allPageList8;
	public Sys_User getModel() {
//		usr=userService.getUserById(1);
//		return usr;
		return null;
	}

	public void prepare() throws Exception {}

	/**
	 * 跳转到personalInfoList.jsp
	 * @return
	 * @throws ParseException 
	 */
	public String personalInfoList() throws ParseException{
		usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		selectNoticeByUser=service.selectNoticeByUser(usr);
		selectTrainTestInfoByUser=service.selectTrainTestInfoByUser(usr);
		selectMockTestInfoByUser=service.selectMockTestInfoByUser(usr);
		selectCompetitionInfoByUser=service.selectCompetitionInfoByUser(usr);
		selectCourseInfoByUser=service.selectCourseInfoByUser(usr);
		selectFavorCourse=service.selectFavorCourse();
		selectExerciseInfoByUser=service.selectExerciseInfoByUser(usr);
		selectKlgBankInfoByUser=service.selectKlgBankInfoByUser(usr);
		selectFavorKlgBank=service.selectFavorKlgBank();
		selectProblemInfoByUser=service.selectProblemInfoByUser(usr);
		selectAnswerInfoByUser=service.selectAnswerInfoByUser(usr);
		selectThemeByUser=service.selectThemeByUser(usr);
		selectFavorThemeByUser=service.selectFavorThemeByUser();
		setEstInfo=service.setEstInfo(usr);
		
		//培训考核
		resNum=String.valueOf(selectTrainTestInfoByUser.size());
		allPageList=new ArrayList<String>();
		if(selectTrainTestInfoByUser.size()%3==0)
		{
			pageNum=String.valueOf(selectTrainTestInfoByUser.size()/3);
		}
		else
		{
			pageNum=String.valueOf(selectTrainTestInfoByUser.size()/3+1);
		}
		for(int j=1;j<=Integer.parseInt(pageNum);j++)
		{
			allPageList.add(String.valueOf(j));
		}
		//模拟考试
		resNum1=String.valueOf(selectMockTestInfoByUser.size());
		allPageList1=new ArrayList<String>();
		if(selectMockTestInfoByUser.size()%3==0)
		{
			pageNum1=String.valueOf(selectMockTestInfoByUser.size()/3);
		}
		else
		{
			pageNum1=String.valueOf(selectMockTestInfoByUser.size()/3+1);
		}
		for(int j1=1;j1<=Integer.parseInt(pageNum1);j1++)
		{
			allPageList1.add(String.valueOf(j1));
		}
		//竞技问答
		resNum2=String.valueOf(selectCompetitionInfoByUser.size());
		allPageList2=new ArrayList<String>();
		if(selectCompetitionInfoByUser.size()%3==0)
		{
			pageNum2=String.valueOf(selectCompetitionInfoByUser.size()/3);
		}
		else
		{
			pageNum2=String.valueOf(selectCompetitionInfoByUser.size()/3+1);
		}
		for(int j2=1;j2<=Integer.parseInt(pageNum2);j2++)
		{
			allPageList2.add(String.valueOf(j2));
		}
		//学习课程
		resNum3=String.valueOf(selectCourseInfoByUser.size());
		allPageList3=new ArrayList<String>();
		if(selectCourseInfoByUser.size()%3==0)
		{
			pageNum3=String.valueOf(selectCourseInfoByUser.size()/3);
		}
		else
		{
			pageNum3=String.valueOf(selectCourseInfoByUser.size()/3+1);
		}
		for(int j3=1;j3<=Integer.parseInt(pageNum3);j3++)
		{
			allPageList3.add(String.valueOf(j3));
		}
		//练习记录
		resNum4=String.valueOf(selectExerciseInfoByUser.size());
		allPageList4=new ArrayList<String>();
		if(selectExerciseInfoByUser.size()%3==0)
		{
			pageNum4=String.valueOf(selectExerciseInfoByUser.size()/3);
		}
		else
		{
			pageNum4=String.valueOf(selectExerciseInfoByUser.size()/3+1);
		}
		for(int j4=1;j4<=Integer.parseInt(pageNum4);j4++)
		{
			allPageList4.add(String.valueOf(j4));
		}
		//我的知识库
		resNum5=String.valueOf(selectKlgBankInfoByUser.size());
		allPageList5=new ArrayList<String>();
		if(selectKlgBankInfoByUser.size()%3==0)
		{
			pageNum5=String.valueOf(selectKlgBankInfoByUser.size()/3);
		}
		else
		{
			pageNum5=String.valueOf(selectKlgBankInfoByUser.size()/3+1);
		}
		for(int j5=1;j5<=Integer.parseInt(pageNum5);j5++)
		{
			allPageList5.add(String.valueOf(j5));
		}
		//我的问题
		resNum6=String.valueOf(selectProblemInfoByUser.size());
		allPageList6=new ArrayList<String>();
		if(selectProblemInfoByUser.size()%3==0)
		{
			pageNum6=String.valueOf(selectProblemInfoByUser.size()/3);
		}
		else
		{
			pageNum6=String.valueOf(selectProblemInfoByUser.size()/3+1);
		}
		for(int j6=1;j6<=Integer.parseInt(pageNum6);j6++)
		{
			allPageList6.add(String.valueOf(j6));
		}
		//我的回答
		resNum7=String.valueOf(selectAnswerInfoByUser.size());
		allPageList7=new ArrayList<String>();
		if(selectAnswerInfoByUser.size()%3==0)
		{
			pageNum7=String.valueOf(selectAnswerInfoByUser.size()/3);
		}
		else
		{
			pageNum7=String.valueOf(selectAnswerInfoByUser.size()/3+1);
		}
		for(int j7=1;j7<=Integer.parseInt(pageNum7);j7++)
		{
			allPageList7.add(String.valueOf(j7));
		}
		//我的主题
		resNum8=String.valueOf(selectThemeByUser.size());
		allPageList8=new ArrayList<String>();
		if(selectThemeByUser.size()%3==0)
		{
			pageNum8=String.valueOf(selectThemeByUser.size()/3);
		}
		else
		{
			pageNum8=String.valueOf(selectThemeByUser.size()/3+1);
		}
		for(int j8=1;j8<=Integer.parseInt(pageNum8);j8++)
		{
			allPageList8.add(String.valueOf(j8));
		}
		return "personalInfoList";
	}
	
	public String personalPasswordChangeList()
	{
		return "personalPasswordChangeList";
	}
	
	public String personPasswordChange()
	{
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		if((DigestUtils.md5Hex(oldPassword)).equals(usr.getPassword())==true)
		{
		    passwordChangeRes=passwordService.updateUserPassword(usr, DigestUtils.md5Hex(newPassword));
		}
		else
		{
			passwordChangeRes="error";
		}
		return "personPasswordChange";
	}
	
	/**
	 * 跳转到personalTraceList.jsp
	 * @return
	 */
	public String personalTraceList(){
		return "personalTraceList";
	}
	
	/**
	 * 跳转到personalEstmList.jsp
	 * @return
	 */
	public String personalEstmList(){
		return "personalEstmList";
	}
	
	/**
	 * 跳转到personalCourseList.jsp
	 * @return
	 */
	public String personalCourseList(){
		return "personalCourseList";
	}
	
	/**
	 * 跳转到personalKnowledgeList.jsp
	 * @return
	 */
	public String personalKnowledgeList(){
		return "personalKnowledgeList";
	}
	
	/**
	 * 跳转到personalMessageList.jsp
	 * @return
	 */
	public String personalMessageList(){
		return "personalMessageList";
	}

	public List<MyNoticeInfoPo> getSelectNoticeByUser() {
		return selectNoticeByUser;
	}

	public void setSelectNoticeByUser(List<MyNoticeInfoPo> selectNoticeByUser) {
		this.selectNoticeByUser = selectNoticeByUser;
	}

	public List<MyTestInfoPo> getSelectTrainTestInfoByUser() {
		return selectTrainTestInfoByUser;
	}

	public void setSelectTrainTestInfoByUser(
			List<MyTestInfoPo> selectTrainTestInfoByUser) {
		this.selectTrainTestInfoByUser = selectTrainTestInfoByUser;
	}

	public List<MyTestInfoPo> getSelectMockTestInfoByUser() {
		return selectMockTestInfoByUser;
	}

	public void setSelectMockTestInfoByUser(
			List<MyTestInfoPo> selectMockTestInfoByUser) {
		this.selectMockTestInfoByUser = selectMockTestInfoByUser;
	}

	public List<MyCompetitionInfoPo> getSelectCompetitionInfoByUser() {
		return selectCompetitionInfoByUser;
	}

	public void setSelectCompetitionInfoByUser(
			List<MyCompetitionInfoPo> selectCompetitionInfoByUser) {
		this.selectCompetitionInfoByUser = selectCompetitionInfoByUser;
	}

	public List<MyCourseInfoPo> getSelectCourseInfoByUser() {
		return selectCourseInfoByUser;
	}

	public void setSelectCourseInfoByUser(
			List<MyCourseInfoPo> selectCourseInfoByUser) {
		this.selectCourseInfoByUser = selectCourseInfoByUser;
	}

	public List<FavorCourseInfoPo> getSelectFavorCourse() {
		return selectFavorCourse;
	}

	public void setSelectFavorCourse(List<FavorCourseInfoPo> selectFavorCourse) {
		this.selectFavorCourse = selectFavorCourse;
	}

	public List<MyExerciseInfoPo> getSelectExerciseInfoByUser() {
		return selectExerciseInfoByUser;
	}

	public void setSelectExerciseInfoByUser(
			List<MyExerciseInfoPo> selectExerciseInfoByUser) {
		this.selectExerciseInfoByUser = selectExerciseInfoByUser;
	}

	public List<MyKlgUploadInfoPo> getSelectKlgBankInfoByUser() {
		return selectKlgBankInfoByUser;
	}

	public void setSelectKlgBankInfoByUser(
			List<MyKlgUploadInfoPo> selectKlgBankInfoByUser) {
		this.selectKlgBankInfoByUser = selectKlgBankInfoByUser;
	}

	public List<FavorKlgBankInfoPo> getSelectFavorKlgBank() {
		return selectFavorKlgBank;
	}

	public void setSelectFavorKlgBank(List<FavorKlgBankInfoPo> selectFavorKlgBank) {
		this.selectFavorKlgBank = selectFavorKlgBank;
	}

	public List<MyProblemInfoPo> getSelectProblemInfoByUser() {
		return selectProblemInfoByUser;
	}

	public void setSelectProblemInfoByUser(
			List<MyProblemInfoPo> selectProblemInfoByUser) {
		this.selectProblemInfoByUser = selectProblemInfoByUser;
	}

	public List<MyAnswerInfoPo> getSelectAnswerInfoByUser() {
		return selectAnswerInfoByUser;
	}

	public void setSelectAnswerInfoByUser(
			List<MyAnswerInfoPo> selectAnswerInfoByUser) {
		this.selectAnswerInfoByUser = selectAnswerInfoByUser;
	}

	public List<MyThemeInfoPo> getSelectThemeByUser() {
		return selectThemeByUser;
	}

	public void setSelectThemeByUser(List<MyThemeInfoPo> selectThemeByUser) {
		this.selectThemeByUser = selectThemeByUser;
	}

	public List<FavorThemeInfoPo> getSelectFavorThemeByUser() {
		return selectFavorThemeByUser;
	}

	public void setSelectFavorThemeByUser(
			List<FavorThemeInfoPo> selectFavorThemeByUser) {
		this.selectFavorThemeByUser = selectFavorThemeByUser;
	}

	public MyEstInfoPo getSetEstInfo() {
		return setEstInfo;
	}

	public void setSetEstInfo(MyEstInfoPo setEstInfo) {
		this.setEstInfo = setEstInfo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResNum() {
		return resNum;
	}

	public void setResNum(String resNum) {
		this.resNum = resNum;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public List<String> getAllPageList() {
		return allPageList;
	}

	public void setAllPageList(List<String> allPageList) {
		this.allPageList = allPageList;
	}

	public String getResNum1() {
		return resNum1;
	}

	public void setResNum1(String resNum1) {
		this.resNum1 = resNum1;
	}

	public String getPageNum1() {
		return pageNum1;
	}

	public void setPageNum1(String pageNum1) {
		this.pageNum1 = pageNum1;
	}

	public List<String> getAllPageList1() {
		return allPageList1;
	}

	public void setAllPageList1(List<String> allPageList1) {
		this.allPageList1 = allPageList1;
	}

	public String getResNum2() {
		return resNum2;
	}

	public void setResNum2(String resNum2) {
		this.resNum2 = resNum2;
	}

	public String getPageNum2() {
		return pageNum2;
	}

	public void setPageNum2(String pageNum2) {
		this.pageNum2 = pageNum2;
	}

	public List<String> getAllPageList2() {
		return allPageList2;
	}

	public void setAllPageList2(List<String> allPageList2) {
		this.allPageList2 = allPageList2;
	}

	public String getResNum3() {
		return resNum3;
	}

	public void setResNum3(String resNum3) {
		this.resNum3 = resNum3;
	}

	public String getPageNum3() {
		return pageNum3;
	}

	public void setPageNum3(String pageNum3) {
		this.pageNum3 = pageNum3;
	}

	public List<String> getAllPageList3() {
		return allPageList3;
	}

	public void setAllPageList3(List<String> allPageList3) {
		this.allPageList3 = allPageList3;
	}

	public String getResNum4() {
		return resNum4;
	}

	public void setResNum4(String resNum4) {
		this.resNum4 = resNum4;
	}

	public String getPageNum4() {
		return pageNum4;
	}

	public void setPageNum4(String pageNum4) {
		this.pageNum4 = pageNum4;
	}

	public List<String> getAllPageList4() {
		return allPageList4;
	}

	public void setAllPageList4(List<String> allPageList4) {
		this.allPageList4 = allPageList4;
	}

	public String getResNum5() {
		return resNum5;
	}

	public void setResNum5(String resNum5) {
		this.resNum5 = resNum5;
	}

	public String getPageNum5() {
		return pageNum5;
	}

	public void setPageNum5(String pageNum5) {
		this.pageNum5 = pageNum5;
	}

	public List<String> getAllPageList5() {
		return allPageList5;
	}

	public void setAllPageList5(List<String> allPageList5) {
		this.allPageList5 = allPageList5;
	}

	public String getResNum6() {
		return resNum6;
	}

	public void setResNum6(String resNum6) {
		this.resNum6 = resNum6;
	}

	public String getPageNum6() {
		return pageNum6;
	}

	public void setPageNum6(String pageNum6) {
		this.pageNum6 = pageNum6;
	}

	public List<String> getAllPageList6() {
		return allPageList6;
	}

	public void setAllPageList6(List<String> allPageList6) {
		this.allPageList6 = allPageList6;
	}

	public String getResNum7() {
		return resNum7;
	}

	public void setResNum7(String resNum7) {
		this.resNum7 = resNum7;
	}

	public String getPageNum7() {
		return pageNum7;
	}

	public void setPageNum7(String pageNum7) {
		this.pageNum7 = pageNum7;
	}

	public List<String> getAllPageList7() {
		return allPageList7;
	}

	public void setAllPageList7(List<String> allPageList7) {
		this.allPageList7 = allPageList7;
	}

	public String getResNum8() {
		return resNum8;
	}

	public void setResNum8(String resNum8) {
		this.resNum8 = resNum8;
	}

	public String getPageNum8() {
		return pageNum8;
	}

	public void setPageNum8(String pageNum8) {
		this.pageNum8 = pageNum8;
	}

	public List<String> getAllPageList8() {
		return allPageList8;
	}

	public void setAllPageList8(List<String> allPageList8) {
		this.allPageList8 = allPageList8;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPasswordChangeRes() {
		return passwordChangeRes;
	}

	public void setPasswordChangeRes(String passwordChangeRes) {
		this.passwordChangeRes = passwordChangeRes;
	}

	public Sys_User getUsr() {
		return usr;
	}

	public void setUsr(Sys_User usr) {
		this.usr = usr;
	}
	
	
}
