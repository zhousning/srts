package com.srts.estimation.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.estimation.po.SysUserInfoPo;
import com.srts.estimation.po.UserCmncEstimatePo;
import com.srts.estimation.po.UserEstimatePo;
import com.srts.estimation.po.UserExeAcurInfoPo;
import com.srts.estimation.po.UserExeEstimatePo;
import com.srts.estimation.po.UserExeFeqInfoPo;
import com.srts.estimation.po.UserInfoPo;
import com.srts.estimation.po.UserKlgBankSearchEstPo;
import com.srts.estimation.po.UserKlgBankSearchRecordPo;
import com.srts.estimation.po.UserTestEstimateInfoPo;
import com.srts.estimation.service.WorkerCmncEstimateService;
import com.srts.estimation.service.WorkerKlgBankEstimateService;
import com.srts.estimation.service.WorkerOnlineExerciseEstService;
import com.srts.estimation.service.WorkerOnlineStudyEstService;
import com.srts.estimation.service.WorkerTestEstimateService;
import com.srts.estimation.service.WorkerTrainTestEstimateService;
import com.srts.estimation.service.WorkerWholeEstimateService;
import com.srts.system.domain.Sys_User;
import com.srts.utils.estUtils.FCMalgorithm;

@Controller
public class WorkerEstimateListAction {
	
	@Resource
	private WorkerOnlineExerciseEstService workerOnlineExerciseEstService;
	@Resource
	private WorkerOnlineStudyEstService workerOnlineStudyEstService;
	@Resource
	private WorkerTestEstimateService workerTestEstimateService;
	@Resource
	private WorkerTrainTestEstimateService workerTrainTestEstimateService;
	@Resource
	private WorkerKlgBankEstimateService workerKlgBankEstimateService;
	@Resource
	private WorkerCmncEstimateService workerCmncEstimateService;
	@Resource
	private WorkerWholeEstimateService workerWholeEstimateService;
	
	
	private List<UserExeFeqInfoPo> userExerciseFrequencyInfo;
	private List<UserExeAcurInfoPo> userExerciseToMonthAccuracyInfo;
	private List<UserExeAcurInfoPo> userExerciseToWeekAccuracyInfo;
	private List<UserExeAcurInfoPo> userExerciseTodayAccuracyInfo;
	private List<UserExeEstimatePo> userExerciseEstimateInfoToMonth;
	private List<UserExeEstimatePo> userExerciseEstimateInfoToWeek;
	private List<UserExeEstimatePo> userExerciseEstimateInfoToday;
	private String setAccuracyString;
	private String setFeqString;
	
	private List<UserInfoPo> myStudyTimeLengthInfoCurrentDay;
	private List<UserInfoPo> myStudyTimeLengthInfoCurrentWeek;
	private List<UserInfoPo> myStudyTimeLengthInfoCurrentMonth;
	private String timeLengthString;
	private List<UserEstimatePo> userEstimateInfoCurrentDay;
	private List<UserEstimatePo> userEstimateInfoCurrentMonth;
	private List<UserEstimatePo> userEstimateInfoCurrentWeek;
	
	private String categoryUserTestScore;
	private String userTestScoreByUserAndType;
	private String userTestScoreRankByUserAndType;
	private String userTestScoreStablilityByUserAndType;
	private List<UserTestEstimateInfoPo> userTestEstimateInfo;
	private SysUserInfoPo userInfo;
	
	private String categoryUserTrainTestScore;
	private String userTrainTestScoreByUserAndType;
	private String userTrainTestScoreRankByUserAndType;
	private String userTrainTestScoreStablilityByUserAndType;
	private List<UserTestEstimateInfoPo> userTrainTestEstimateInfo;
	
	private String workerKlgSearchEst;//搜索总量分类统计
	private String workerKlgSearchEstToday;//本日搜索总量分类统计
	private String workerKlgSearchEstToWeek;//本周搜索总量分类统计
	private String workerKlgSearchEstToMonth;//本月搜索总量分类统计
	private String workerOpExpUploadToday;//本日上传操作经验（已通过未通过）
	private String workerOpExpUploadToWeek;//本周上传操作经验（已通过未通过）
	private String workerOpExpUploadToMonth;//本周上传操作经验（已通过未通过）
	private List<UserKlgBankSearchRecordPo> findWorkerKlgSearchRecord;//按起止日期搜索检索记录
	private List<UserKlgBankSearchEstPo> setUserKlgBankEstimateInfoPo;//设置评价
	private String startDate;
	private String endDate;
	private String type;
	
	private String selectWorkerProCmncAmountToWeek;//
	private String selectWorkerProCmncAmountToMonth;//
	private String selectWorkerProCmncAmount;//
	private String selectWorkerProCmncAcp;//
	private String selectWorkerAcpRatePerMonth;
	private String selectWorkerStuCmncAmountToWeek;//
	private String selectWorkerStuCmncAmountToMonth;//
	private String selectWorkerStuCmncAmount;//
	private List<UserCmncEstimatePo> setWorkerCmncEstimateInfo;
	
	private String resNum="0";
	private String pageNum="1";
	private List<String> allPageList;
	
	private String resNum1="0";
	private String pageNum1="1";
	private List<String> allPageList1;
	
	private String resNum2="0";
	private String pageNum2="1";
	private List<String> allPageList2;
	
	private String resNum3="0";
	private String pageNum3="1";
	private List<String> allPageList3;
	
	private String resNum4="0";
	private String pageNum4="1";
	private List<String> allPageList4;
	
	private String resNum5="0";
	private String pageNum5="1";
	private List<String> allPageList5;
	
	//查询
	private List<String> allPageList0;
	private String resNum0="0";
	private String curPage="1";
	private String pageAmount="1";
	private String newPage="1";
	
	//总评雷达图
	private String radarString="";
	private String wholeEstString="";

	public String WorkerEstimateList() throws ParseException
	{
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		userExerciseFrequencyInfo = workerOnlineExerciseEstService.setUserExerciseFrequencyInfo(usr);
		userExerciseToMonthAccuracyInfo = workerOnlineExerciseEstService.setUserExerciseToMonthAccuracyInfo(usr);
	    userExerciseToWeekAccuracyInfo = workerOnlineExerciseEstService.setUserExerciseToWeekAccuracyInfo(usr);
		userExerciseTodayAccuracyInfo = workerOnlineExerciseEstService.setUserExerciseTodayAccuracyInfo(usr);
		userExerciseEstimateInfoToMonth = workerOnlineExerciseEstService.setUserExerciseEstimateInfoToMonth(usr);
		userExerciseEstimateInfoToWeek = workerOnlineExerciseEstService.setUserExerciseEstimateInfoToWeek(usr);
		userExerciseEstimateInfoToday = workerOnlineExerciseEstService.setUserExerciseEstimateInfoToday(usr);
		myStudyTimeLengthInfoCurrentDay = workerOnlineStudyEstService.setMyStudyTimeLengthInfoCurrentDay(usr);
		myStudyTimeLengthInfoCurrentWeek = workerOnlineStudyEstService.setMyStudyTimeLengthInfoCurrentWeek(usr);
		myStudyTimeLengthInfoCurrentMonth = workerOnlineStudyEstService.setMyStudyTimeLengthInfoCurrentMonth(usr);
		userEstimateInfoCurrentDay = workerOnlineStudyEstService.setUserEstimateInfoCurrentDay(usr);
		userEstimateInfoCurrentMonth = workerOnlineStudyEstService.setUserEstimateInfoCurrentMonth(usr);
		userEstimateInfoCurrentWeek = workerOnlineStudyEstService.setUserEstimateInfoCurrentWeek(usr);
		userTestEstimateInfo = workerTestEstimateService.setUserTestEstimateInfo(usr);
		userInfo = workerTestEstimateService.setSysUserInfoPo(usr);
		userTrainTestEstimateInfo = workerTrainTestEstimateService.setUserTestEstimateInfo(usr);
		setUserKlgBankEstimateInfoPo=workerKlgBankEstimateService.setUserKlgBankEstimateInfoPo(usr);
		setWorkerCmncEstimateInfo=workerCmncEstimateService.setWorkerCmncEstimateInfo(usr);
		//日学习记录
		resNum=String.valueOf(myStudyTimeLengthInfoCurrentDay.size());
		allPageList=new ArrayList<String>();
		if(myStudyTimeLengthInfoCurrentDay.size()%3==0)
		{
			pageNum=String.valueOf(myStudyTimeLengthInfoCurrentDay.size()/3);
		}
		else
		{
			pageNum=String.valueOf(myStudyTimeLengthInfoCurrentDay.size()/3+1);
		}
		for(int j=1;j<=Integer.parseInt(pageNum);j++)
		{
			allPageList.add(String.valueOf(j));
		}
		//周学习记录
		resNum1=String.valueOf(myStudyTimeLengthInfoCurrentWeek.size());
		allPageList1=new ArrayList<String>();
		if(myStudyTimeLengthInfoCurrentWeek.size()%3==0)
		{
			pageNum1=String.valueOf(myStudyTimeLengthInfoCurrentWeek.size()/3);
		}
		else
		{
			pageNum1=String.valueOf(myStudyTimeLengthInfoCurrentWeek.size()/3+1);
		}
		for(int j1=1;j1<=Integer.parseInt(pageNum1);j1++)
		{
			allPageList1.add(String.valueOf(j1));
		}
		//月学习记录
		resNum2=String.valueOf(myStudyTimeLengthInfoCurrentMonth.size());
		allPageList2=new ArrayList<String>();
		if(myStudyTimeLengthInfoCurrentMonth.size()%3==0)
		{
			pageNum2=String.valueOf(myStudyTimeLengthInfoCurrentMonth.size()/3);
		}
		else
		{
			pageNum2=String.valueOf(myStudyTimeLengthInfoCurrentMonth.size()/3+1);
		}
		for(int j2=1;j2<=Integer.parseInt(pageNum2);j2++)
		{
			allPageList2.add(String.valueOf(j2));
		}
		//日练习记录
		resNum3=String.valueOf(userExerciseTodayAccuracyInfo.size());
		allPageList3=new ArrayList<String>();
		if(userExerciseTodayAccuracyInfo.size()%3==0)
		{
			pageNum3=String.valueOf(userExerciseTodayAccuracyInfo.size()/3);
		}
		else
		{
			pageNum3=String.valueOf(userExerciseTodayAccuracyInfo.size()/3+1);
		}
		for(int j3=1;j3<=Integer.parseInt(pageNum3);j3++)
		{
			allPageList3.add(String.valueOf(j3));
		}
		//周练习记录
		resNum4=String.valueOf(userExerciseToWeekAccuracyInfo.size());
		allPageList4=new ArrayList<String>();
		if(userExerciseToWeekAccuracyInfo.size()%3==0)
		{
			pageNum4=String.valueOf(userExerciseToWeekAccuracyInfo.size()/3);
		}
		else
		{
			pageNum4=String.valueOf(userExerciseToWeekAccuracyInfo.size()/3+1);
		}
		for(int j4=1;j4<=Integer.parseInt(pageNum4);j4++)
		{
			allPageList4.add(String.valueOf(j4));
		}
		//月练习记录
		resNum5=String.valueOf(userExerciseToMonthAccuracyInfo.size());
		allPageList5=new ArrayList<String>();
		if(userExerciseToMonthAccuracyInfo.size()%3==0)
		{
			pageNum5=String.valueOf(userExerciseToMonthAccuracyInfo.size()/3);
		}
		else
		{
			pageNum5=String.valueOf(userExerciseToMonthAccuracyInfo.size()/3+1);
		}
		for(int j5=1;j5<=Integer.parseInt(pageNum5);j5++)
		{
			allPageList5.add(String.valueOf(j5));
		}
		
		//总评信息
		int trainTestScore=workerWholeEstimateService.setTrainTestEstMark(usr);
		int klgBankScore=workerWholeEstimateService.setKlgBankEstMark(usr);
		int exerciseScore=workerWholeEstimateService.setExerciseEstMark(usr);
		int studyScore=workerWholeEstimateService.setStudyEstMark(usr);
		int cmncScore=workerWholeEstimateService.setCmncEstMark(usr);
		int mockTestScore=workerWholeEstimateService.setMockTestEstMark(usr);
	    int[] point={trainTestScore,klgBankScore,exerciseScore,studyScore,cmncScore,mockTestScore};
		List<int[]> cores=new ArrayList<int[]>();
		int[] core0={100,100,100,100,100,100};
		int[] core1={100,90,90,90,90,90};
		int[] core2={95,80,80,80,80,80};
		int[] core3={85,80,80,80,80,80};
		int[] core4={85,70,70,70,70,70};
		int[] core5={70,70,70,70,70,70};
		cores.add(core0);
		cores.add(core1);
		cores.add(core2);
		cores.add(core3);
		cores.add(core4);
		cores.add(core5);
		double[] weight={0.7,0.04,0.08,0.1,0.02,0.06};
		FCMalgorithm FCMtemp=new FCMalgorithm();
		String resString=FCMtemp.FCMfunction(point,cores,weight);
		if(resString.equals("0"))
		{
			wholeEstString="学习评价：S,学习状况非常好,对课程内容的翻阅以及练习十分到位,能够充分利用交流模块和知识库模块解决学习问题,模拟考试和调考的成绩优秀且成绩十分稳定,请继续保持";
		}
		else if(resString.equals("1"))
		{
			wholeEstString="学习评价：A,学习状况很好,对课程内容的翻阅以及练习相当到位,能够很好地利用交流模块和知识库模块解决学习问题,模拟考试和调考的成绩优秀且成绩十分稳定,请继续保持";
		}
		else if(resString.equals("2"))
		{
			wholeEstString="学习评价：A-,学习状况不错,对课程内容的翻阅以及练习比较到位,能够良好地利用交流模块和知识库模块解决学习问题,模拟考试和调考的成绩不错且成绩比较稳定,总体上还有进步的空间,请继续努力";
		}
		else if(resString.equals("3"))
		{
			wholeEstString="学习评价：B,学习状况一般,对课程内容的翻阅以及练习需要再积极一些,能够利用交流模块和知识库模块解决部分学习问题,模拟考试和调考的成绩基本合格且成绩稳定性尚可,总体上还有不少进步的空间,请继续努力";
		}
		else if(resString.equals("4"))
		{
			wholeEstString="学习评价：C,学习状况存在一些问题,请多多翻阅课程内容,多做一些练习来提升知识的掌握程度,能够在一定程度上利用交流模块和知识库模块解决部分学习问题,模拟考试和调考的成绩基本合格且成绩一般,总体上还有很多进步的空间,请努力";
		}
		else if(resString.equals("5"))
		{
			wholeEstString="学习评价：D,学习状况不如人意,请多翻阅学习内容并且多做练习,对交流模块和知识库模块的使用不到位,模拟考试和调考的成绩合格率不高且成绩不稳定,请努力学习";
		}
		return "WorkerEstimateList";
		
	}
	public String WorkerEstimateAnalysis() throws ParseException
	{
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		setAccuracyString = workerOnlineExerciseEstService.setAccuracyString(usr);
		setFeqString = workerOnlineExerciseEstService.setFeqString(usr);
		timeLengthString = workerOnlineStudyEstService.getTimeLengthString(usr);
		categoryUserTestScore= workerTestEstimateService.dispCategoryUserTestScore(usr);
		userTestScoreByUserAndType = workerTestEstimateService.findUserTestScoreByUserAndType(usr);
		userTestScoreRankByUserAndType = workerTestEstimateService.findUserTestScoreRankByUserAndType(usr);
		userTestScoreStablilityByUserAndType = workerTestEstimateService.findUserTestScoreStablilityByUserAndType(usr);
		categoryUserTrainTestScore= workerTrainTestEstimateService.dispCategoryUserTestScore(usr);
		userTrainTestScoreByUserAndType = workerTrainTestEstimateService.findUserTestScoreByUserAndType(usr);
		userTrainTestScoreRankByUserAndType = workerTrainTestEstimateService.findUserTestScoreRankByUserAndType(usr);
		userTrainTestScoreStablilityByUserAndType = workerTrainTestEstimateService.findUserTestScoreStablilityByUserAndType(usr);
		workerKlgSearchEst=workerKlgBankEstimateService.workerKlgSearchEst(usr);
		workerKlgSearchEstToday=workerKlgBankEstimateService.workerKlgSearchEstToday(usr);
		workerKlgSearchEstToWeek=workerKlgBankEstimateService.workerKlgSearchEstToWeek(usr);
		workerKlgSearchEstToMonth=workerKlgBankEstimateService.workerKlgSearchEstToMonth(usr);
		workerOpExpUploadToday=workerKlgBankEstimateService.workerOpExpUploadToday(usr);
		workerOpExpUploadToWeek=workerKlgBankEstimateService.workerOpExpUploadToWeek(usr);
		workerOpExpUploadToMonth=workerKlgBankEstimateService.workerOpExpUploadToMonth(usr);
		selectWorkerProCmncAmountToWeek=workerCmncEstimateService.selectWorkerProCmncAmountToWeek(usr);
		selectWorkerProCmncAmountToMonth=workerCmncEstimateService.selectWorkerProCmncAmountToMonth(usr);
		selectWorkerProCmncAmount=workerCmncEstimateService.selectWorkerProCmncAmount(usr);
		selectWorkerProCmncAcp=workerCmncEstimateService.selectWorkerProCmncAcp(usr);
		selectWorkerAcpRatePerMonth=workerCmncEstimateService.selectWorkerAcpRatePerMonth(usr);
		selectWorkerStuCmncAmountToWeek=workerCmncEstimateService.selectWorkerStuCmncAmountToWeek(usr);
		selectWorkerStuCmncAmountToMonth=workerCmncEstimateService.selectWorkerStuCmncAmountToMonth(usr);
		selectWorkerStuCmncAmount=workerCmncEstimateService.selectWorkerStuCmncAmount(usr);
		
		int trainTestScore=workerWholeEstimateService.setTrainTestEstMark(usr);
		int klgBankScore=workerWholeEstimateService.setKlgBankEstMark(usr);
		int exerciseScore=workerWholeEstimateService.setExerciseEstMark(usr);
		int studyScore=workerWholeEstimateService.setStudyEstMark(usr);
		int cmncScore=workerWholeEstimateService.setCmncEstMark(usr);
		int mockTestScore=workerWholeEstimateService.setMockTestEstMark(usr);
		int[] point={trainTestScore,klgBankScore,exerciseScore,studyScore,cmncScore,mockTestScore};
		int aimtrainTestScore=100;
		int aimklgBankScore=100;
		int aimexerciseScore=100;
		int aimstudyScore=100;
		int aimcmncScore=100;
		int aimmockTestScore=100;
		List<int[]> cores=new ArrayList<int[]>();
		int[] core0={100,100,100,100,100,100};
		int[] core1={100,90,90,90,90,90};
		int[] core2={95,80,80,80,80,80};
		int[] core3={85,80,80,80,80,80};
		int[] core4={85,70,70,70,70,70};
		int[] core5={70,70,70,70,70,70};
		cores.add(core0);
		cores.add(core1);
		cores.add(core2);
		cores.add(core3);
		cores.add(core4);
		cores.add(core5);
		double[] weight={0.7,0.04,0.08,0.1,0.02,0.06};
		FCMalgorithm FCMtemp=new FCMalgorithm();
		String resString=FCMtemp.FCMfunction(point,cores,weight);
		if(resString.equals("0"))
		{
			aimtrainTestScore=100;
			aimklgBankScore=100;
			aimexerciseScore=100;
			aimstudyScore=100;
			aimcmncScore=100;
			aimmockTestScore=100;
		}
		else if(resString.equals("1"))
		{
			aimtrainTestScore=100;
			aimklgBankScore=100;
			aimexerciseScore=100;
			aimstudyScore=100;
			aimcmncScore=100;
			aimmockTestScore=100;
		}
		else if(resString.equals("2"))
		{
			aimtrainTestScore=100;
			aimklgBankScore=90;
			aimexerciseScore=90;
			aimstudyScore=90;
			aimcmncScore=90;
			aimmockTestScore=90;
		}
		else if(resString.equals("3"))
		{
			aimtrainTestScore=95;
			aimklgBankScore=80;
			aimexerciseScore=80;
			aimstudyScore=80;
			aimcmncScore=80;
			aimmockTestScore=80;
		}
		else if(resString.equals("4"))
		{
			aimtrainTestScore=90;
			aimklgBankScore=80;
			aimexerciseScore=80;
			aimstudyScore=80;
			aimcmncScore=80;
			aimmockTestScore=80;
		}
		else if(resString.equals("5"))
		{
			aimtrainTestScore=90;
			aimklgBankScore=80;
			aimexerciseScore=80;
			aimstudyScore=80;
			aimcmncScore=80;
			aimmockTestScore=80;
		}
		radarString = "{ 'chart': { 'caption':'员工学习状态评估','bgColor':'FFFFFF','radarFillColor':'FFFFFF','plotFillAlpha':'5','plotBorderThickness':'2','anchorAlpha':'100','numberPrefix':'','numDivLines':'2'}, " +
				"'categories': [ {'category':[{'label':'调考成绩评分'},{'label':'知识库使用评分'},"+
        "{'label':'练习情况评分'},{'label':'课程学习评分'},{'label':'论坛活跃度评分'},{'label':'模拟考试成绩评分'}]}],";
		radarString+="'dataset':[{'seriesname':'员工各项状态评分','anchorSides':'100','anchorRadius':'4','anchorBorderColor':'4a8bd6','anchorBgAlpha':'10','font':'Arial','baseFontSize':'15','color': '008ee4','alpha':'40','data':[";
		radarString+="{'value':'"+String.valueOf(trainTestScore)+"'},"+"{'value':'"+String.valueOf(klgBankScore)+"'},"+"{'value':'"+String.valueOf(exerciseScore)+"'},"+"{'value':'"+String.valueOf(studyScore)+"'},"+"{'value':'"+String.valueOf(cmncScore)+"'},"+"{'value':'"+String.valueOf(mockTestScore)+"'}";
		radarString+="]},";
		radarString+="{'seriesname':'学习努力目标','anchorSides':'100','anchorRadius':'4','anchorBorderColor':'4a8bd6','anchorBgAlpha':'10','font':'Arial','baseFontSize':'15','color': '6baa01','alpha':'40','data':[";
		radarString+="{'value':'"+String.valueOf(aimtrainTestScore)+"'},"+"{'value':'"+String.valueOf(aimklgBankScore)+"'},"+"{'value':'"+String.valueOf(aimexerciseScore)+"'},"+"{'value':'"+String.valueOf(aimstudyScore)+"'},"+"{'value':'"+String.valueOf(aimcmncScore)+"'},"+"{'value':'"+String.valueOf(aimmockTestScore)+"'}";
	    radarString+="]}]}";
		return "WorkerEstimateAnalysis";
		
	}
	
	public String workerKlgBankRecordSearch() throws UnsupportedEncodingException
	{
		curPage=newPage;
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		startDate = java.net.URLDecoder.decode(startDate,"UTF-8");
		endDate = java.net.URLDecoder.decode(endDate,"UTF-8"); 
		type = java.net.URLDecoder.decode(type,"UTF-8");
		startDate = java.net.URLDecoder.decode(startDate,"UTF-8");
		endDate = java.net.URLDecoder.decode(endDate,"UTF-8"); 
		type = java.net.URLDecoder.decode(type,"UTF-8");
		List<UserKlgBankSearchRecordPo> res=workerKlgBankEstimateService.findWorkerKlgSearchRecord(usr, startDate, endDate, type);
		findWorkerKlgSearchRecord=new ArrayList<UserKlgBankSearchRecordPo>();
		//搜索记录
		resNum0=String.valueOf(res.size());
		allPageList0=new ArrayList<String>();
		int length=res.size();
		int curStart=(Integer.parseInt(curPage)-1)*10;
		int curEnd=(Integer.parseInt(curPage)*10-1)<(length-1)?(Integer.parseInt(curPage)*10-1):(length-1);
		if(res.size()%10==0)
		{
			pageAmount=String.valueOf(res.size()/10);
		}
		else
		{
			pageAmount=String.valueOf(res.size()/10+1);
		}
		for(int j=1;j<=Integer.parseInt(pageAmount);j++)
		{
			allPageList0.add(String.valueOf(j));
		}
		for(int i=curStart;i<=curEnd;i++)
		{
			findWorkerKlgSearchRecord.add(res.get(i));
		}
		return "workerKlgBankRecordSearch";
	}
	
	public WorkerOnlineExerciseEstService getWorkerOnlineExerciseEstService() {
		return workerOnlineExerciseEstService;
	}
	public void setWorkerOnlineExerciseEstService(
			WorkerOnlineExerciseEstService workerOnlineExerciseEstService) {
		this.workerOnlineExerciseEstService = workerOnlineExerciseEstService;
	}
	public WorkerOnlineStudyEstService getWorkerOnlineStudyEstService() {
		return workerOnlineStudyEstService;
	}
	public void setWorkerOnlineStudyEstService(
			WorkerOnlineStudyEstService workerOnlineStudyEstService) {
		this.workerOnlineStudyEstService = workerOnlineStudyEstService;
	}
	public WorkerTestEstimateService getWorkerTestEstimateService() {
		return workerTestEstimateService;
	}
	public void setWorkerTestEstimateService(
			WorkerTestEstimateService workerTestEstimateService) {
		this.workerTestEstimateService = workerTestEstimateService;
	}
	public List<UserExeFeqInfoPo> getUserExerciseFrequencyInfo() {
		return userExerciseFrequencyInfo;
	}
	public void setUserExerciseFrequencyInfo(
			List<UserExeFeqInfoPo> userExerciseFrequencyInfo) {
		this.userExerciseFrequencyInfo = userExerciseFrequencyInfo;
	}
	public List<UserExeAcurInfoPo> getUserExerciseToMonthAccuracyInfo() {
		return userExerciseToMonthAccuracyInfo;
	}
	public void setUserExerciseToMonthAccuracyInfo(
			List<UserExeAcurInfoPo> userExerciseToMonthAccuracyInfo) {
		this.userExerciseToMonthAccuracyInfo = userExerciseToMonthAccuracyInfo;
	}
	public List<UserExeAcurInfoPo> getUserExerciseToWeekAccuracyInfo() {
		return userExerciseToWeekAccuracyInfo;
	}
	public void setUserExerciseToWeekAccuracyInfo(
			List<UserExeAcurInfoPo> userExerciseToWeekAccuracyInfo) {
		this.userExerciseToWeekAccuracyInfo = userExerciseToWeekAccuracyInfo;
	}
	public List<UserExeAcurInfoPo> getUserExerciseTodayAccuracyInfo() {
		return userExerciseTodayAccuracyInfo;
	}
	public void setUserExerciseTodayAccuracyInfo(
			List<UserExeAcurInfoPo> userExerciseTodayAccuracyInfo) {
		this.userExerciseTodayAccuracyInfo = userExerciseTodayAccuracyInfo;
	}
	public List<UserExeEstimatePo> getUserExerciseEstimateInfoToMonth() {
		return userExerciseEstimateInfoToMonth;
	}
	public void setUserExerciseEstimateInfoToMonth(
			List<UserExeEstimatePo> userExerciseEstimateInfoToMonth) {
		this.userExerciseEstimateInfoToMonth = userExerciseEstimateInfoToMonth;
	}
	public List<UserExeEstimatePo> getUserExerciseEstimateInfoToWeek() {
		return userExerciseEstimateInfoToWeek;
	}
	public void setUserExerciseEstimateInfoToWeek(
			List<UserExeEstimatePo> userExerciseEstimateInfoToWeek) {
		this.userExerciseEstimateInfoToWeek = userExerciseEstimateInfoToWeek;
	}
	public List<UserExeEstimatePo> getUserExerciseEstimateInfoToday() {
		return userExerciseEstimateInfoToday;
	}
	public void setUserExerciseEstimateInfoToday(
			List<UserExeEstimatePo> userExerciseEstimateInfoToday) {
		this.userExerciseEstimateInfoToday = userExerciseEstimateInfoToday;
	}
	public String getSetAccuracyString() {
		return setAccuracyString;
	}
	public void setSetAccuracyString(String setAccuracyString) {
		this.setAccuracyString = setAccuracyString;
	}
	public String getSetFeqString() {
		return setFeqString;
	}
	public void setSetFeqString(String setFeqString) {
		this.setFeqString = setFeqString;
	}
	public List<UserInfoPo> getMyStudyTimeLengthInfoCurrentDay() {
		return myStudyTimeLengthInfoCurrentDay;
	}
	public void setMyStudyTimeLengthInfoCurrentDay(
			List<UserInfoPo> myStudyTimeLengthInfoCurrentDay) {
		this.myStudyTimeLengthInfoCurrentDay = myStudyTimeLengthInfoCurrentDay;
	}
	public List<UserInfoPo> getMyStudyTimeLengthInfoCurrentWeek() {
		return myStudyTimeLengthInfoCurrentWeek;
	}
	public void setMyStudyTimeLengthInfoCurrentWeek(
			List<UserInfoPo> myStudyTimeLengthInfoCurrentWeek) {
		this.myStudyTimeLengthInfoCurrentWeek = myStudyTimeLengthInfoCurrentWeek;
	}
	public List<UserInfoPo> getMyStudyTimeLengthInfoCurrentMonth() {
		return myStudyTimeLengthInfoCurrentMonth;
	}
	public void setMyStudyTimeLengthInfoCurrentMonth(
			List<UserInfoPo> myStudyTimeLengthInfoCurrentMonth) {
		this.myStudyTimeLengthInfoCurrentMonth = myStudyTimeLengthInfoCurrentMonth;
	}
	public String getTimeLengthString() {
		return timeLengthString;
	}
	public void setTimeLengthString(String timeLengthString) {
		this.timeLengthString = timeLengthString;
	}
	public List<UserEstimatePo> getUserEstimateInfoCurrentDay() {
		return userEstimateInfoCurrentDay;
	}
	public void setUserEstimateInfoCurrentDay(
			List<UserEstimatePo> userEstimateInfoCurrentDay) {
		this.userEstimateInfoCurrentDay = userEstimateInfoCurrentDay;
	}
	public List<UserEstimatePo> getUserEstimateInfoCurrentMonth() {
		return userEstimateInfoCurrentMonth;
	}
	public void setUserEstimateInfoCurrentMonth(
			List<UserEstimatePo> userEstimateInfoCurrentMonth) {
		this.userEstimateInfoCurrentMonth = userEstimateInfoCurrentMonth;
	}
	public List<UserEstimatePo> getUserEstimateInfoCurrentWeek() {
		return userEstimateInfoCurrentWeek;
	}
	public void setUserEstimateInfoCurrentWeek(
			List<UserEstimatePo> userEstimateInfoCurrentWeek) {
		this.userEstimateInfoCurrentWeek = userEstimateInfoCurrentWeek;
	}
	public String getCategoryUserTestScore() {
		return categoryUserTestScore;
	}
	public void setCategoryUserTestScore(String categoryUserTestScore) {
		this.categoryUserTestScore = categoryUserTestScore;
	}
	public String getUserTestScoreByUserAndType() {
		return userTestScoreByUserAndType;
	}
	public void setUserTestScoreByUserAndType(String userTestScoreByUserAndType) {
		this.userTestScoreByUserAndType = userTestScoreByUserAndType;
	}
	public String getUserTestScoreRankByUserAndType() {
		return userTestScoreRankByUserAndType;
	}
	public void setUserTestScoreRankByUserAndType(
			String userTestScoreRankByUserAndType) {
		this.userTestScoreRankByUserAndType = userTestScoreRankByUserAndType;
	}
	public String getUserTestScoreStablilityByUserAndType() {
		return userTestScoreStablilityByUserAndType;
	}
	public void setUserTestScoreStablilityByUserAndType(
			String userTestScoreStablilityByUserAndType) {
		this.userTestScoreStablilityByUserAndType = userTestScoreStablilityByUserAndType;
	}
	public List<UserTestEstimateInfoPo> getUserTestEstimateInfo() {
		return userTestEstimateInfo;
	}
	public void setUserTestEstimateInfo(
			List<UserTestEstimateInfoPo> userTestEstimateInfo) {
		this.userTestEstimateInfo = userTestEstimateInfo;
	}
	public SysUserInfoPo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(SysUserInfoPo userInfo) {
		this.userInfo = userInfo;
	}
	public String getCategoryUserTrainTestScore() {
		return categoryUserTrainTestScore;
	}
	public void setCategoryUserTrainTestScore(String categoryUserTrainTestScore) {
		this.categoryUserTrainTestScore = categoryUserTrainTestScore;
	}
	public String getUserTrainTestScoreByUserAndType() {
		return userTrainTestScoreByUserAndType;
	}
	public void setUserTrainTestScoreByUserAndType(
			String userTrainTestScoreByUserAndType) {
		this.userTrainTestScoreByUserAndType = userTrainTestScoreByUserAndType;
	}
	public String getUserTrainTestScoreRankByUserAndType() {
		return userTrainTestScoreRankByUserAndType;
	}
	public void setUserTrainTestScoreRankByUserAndType(
			String userTrainTestScoreRankByUserAndType) {
		this.userTrainTestScoreRankByUserAndType = userTrainTestScoreRankByUserAndType;
	}
	public String getUserTrainTestScoreStablilityByUserAndType() {
		return userTrainTestScoreStablilityByUserAndType;
	}
	public void setUserTrainTestScoreStablilityByUserAndType(
			String userTrainTestScoreStablilityByUserAndType) {
		this.userTrainTestScoreStablilityByUserAndType = userTrainTestScoreStablilityByUserAndType;
	}
	public List<UserTestEstimateInfoPo> getUserTrainTestEstimateInfo() {
		return userTrainTestEstimateInfo;
	}
	public void setUserTrainTestEstimateInfo(
			List<UserTestEstimateInfoPo> userTrainTestEstimateInfo) {
		this.userTrainTestEstimateInfo = userTrainTestEstimateInfo;
	}
	public WorkerTrainTestEstimateService getWorkerTrainTestEstimateService() {
		return workerTrainTestEstimateService;
	}
	public void setWorkerTrainTestEstimateService(
			WorkerTrainTestEstimateService workerTrainTestEstimateService) {
		this.workerTrainTestEstimateService = workerTrainTestEstimateService;
	}
	public WorkerKlgBankEstimateService getWorkerKlgBankEstimateService() {
		return workerKlgBankEstimateService;
	}
	public void setWorkerKlgBankEstimateService(
			WorkerKlgBankEstimateService workerKlgBankEstimateService) {
		this.workerKlgBankEstimateService = workerKlgBankEstimateService;
	}
	public String getWorkerKlgSearchEst() {
		return workerKlgSearchEst;
	}
	public void setWorkerKlgSearchEst(String workerKlgSearchEst) {
		this.workerKlgSearchEst = workerKlgSearchEst;
	}
	public String getWorkerKlgSearchEstToday() {
		return workerKlgSearchEstToday;
	}
	public void setWorkerKlgSearchEstToday(String workerKlgSearchEstToday) {
		this.workerKlgSearchEstToday = workerKlgSearchEstToday;
	}
	public String getWorkerKlgSearchEstToWeek() {
		return workerKlgSearchEstToWeek;
	}
	public void setWorkerKlgSearchEstToWeek(String workerKlgSearchEstToWeek) {
		this.workerKlgSearchEstToWeek = workerKlgSearchEstToWeek;
	}
	public String getWorkerKlgSearchEstToMonth() {
		return workerKlgSearchEstToMonth;
	}
	public void setWorkerKlgSearchEstToMonth(String workerKlgSearchEstToMonth) {
		this.workerKlgSearchEstToMonth = workerKlgSearchEstToMonth;
	}
	public String getWorkerOpExpUploadToday() {
		return workerOpExpUploadToday;
	}
	public void setWorkerOpExpUploadToday(String workerOpExpUploadToday) {
		this.workerOpExpUploadToday = workerOpExpUploadToday;
	}
	public String getWorkerOpExpUploadToWeek() {
		return workerOpExpUploadToWeek;
	}
	public void setWorkerOpExpUploadToWeek(String workerOpExpUploadToWeek) {
		this.workerOpExpUploadToWeek = workerOpExpUploadToWeek;
	}
	public String getWorkerOpExpUploadToMonth() {
		return workerOpExpUploadToMonth;
	}
	public void setWorkerOpExpUploadToMonth(String workerOpExpUploadToMonth) {
		this.workerOpExpUploadToMonth = workerOpExpUploadToMonth;
	}
	public List<UserKlgBankSearchRecordPo> getFindWorkerKlgSearchRecord() {
		return findWorkerKlgSearchRecord;
	}
	public void setFindWorkerKlgSearchRecord(
			List<UserKlgBankSearchRecordPo> findWorkerKlgSearchRecord) {
		this.findWorkerKlgSearchRecord = findWorkerKlgSearchRecord;
	}
	public List<UserKlgBankSearchEstPo> getSetUserKlgBankEstimateInfoPo() {
		return setUserKlgBankEstimateInfoPo;
	}
	public void setSetUserKlgBankEstimateInfoPo(
			List<UserKlgBankSearchEstPo> setUserKlgBankEstimateInfoPo) {
		this.setUserKlgBankEstimateInfoPo = setUserKlgBankEstimateInfoPo;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public WorkerCmncEstimateService getWorkerCmncEstimateService() {
		return workerCmncEstimateService;
	}
	public void setWorkerCmncEstimateService(
			WorkerCmncEstimateService workerCmncEstimateService) {
		this.workerCmncEstimateService = workerCmncEstimateService;
	}
	public String getSelectWorkerProCmncAmountToWeek() {
		return selectWorkerProCmncAmountToWeek;
	}
	public void setSelectWorkerProCmncAmountToWeek(
			String selectWorkerProCmncAmountToWeek) {
		this.selectWorkerProCmncAmountToWeek = selectWorkerProCmncAmountToWeek;
	}
	public String getSelectWorkerProCmncAmountToMonth() {
		return selectWorkerProCmncAmountToMonth;
	}
	public void setSelectWorkerProCmncAmountToMonth(
			String selectWorkerProCmncAmountToMonth) {
		this.selectWorkerProCmncAmountToMonth = selectWorkerProCmncAmountToMonth;
	}
	public String getSelectWorkerProCmncAmount() {
		return selectWorkerProCmncAmount;
	}
	public void setSelectWorkerProCmncAmount(String selectWorkerProCmncAmount) {
		this.selectWorkerProCmncAmount = selectWorkerProCmncAmount;
	}
	public String getSelectWorkerProCmncAcp() {
		return selectWorkerProCmncAcp;
	}
	public void setSelectWorkerProCmncAcp(String selectWorkerProCmncAcp) {
		this.selectWorkerProCmncAcp = selectWorkerProCmncAcp;
	}
	public String getSelectWorkerAcpRatePerMonth() {
		return selectWorkerAcpRatePerMonth;
	}
	public void setSelectWorkerAcpRatePerMonth(String selectWorkerAcpRatePerMonth) {
		this.selectWorkerAcpRatePerMonth = selectWorkerAcpRatePerMonth;
	}
	public String getSelectWorkerStuCmncAmountToWeek() {
		return selectWorkerStuCmncAmountToWeek;
	}
	public void setSelectWorkerStuCmncAmountToWeek(
			String selectWorkerStuCmncAmountToWeek) {
		this.selectWorkerStuCmncAmountToWeek = selectWorkerStuCmncAmountToWeek;
	}
	public String getSelectWorkerStuCmncAmountToMonth() {
		return selectWorkerStuCmncAmountToMonth;
	}
	public void setSelectWorkerStuCmncAmountToMonth(
			String selectWorkerStuCmncAmountToMonth) {
		this.selectWorkerStuCmncAmountToMonth = selectWorkerStuCmncAmountToMonth;
	}
	public String getSelectWorkerStuCmncAmount() {
		return selectWorkerStuCmncAmount;
	}
	public void setSelectWorkerStuCmncAmount(String selectWorkerStuCmncAmount) {
		this.selectWorkerStuCmncAmount = selectWorkerStuCmncAmount;
	}
	public List<UserCmncEstimatePo> getSetWorkerCmncEstimateInfo() {
		return setWorkerCmncEstimateInfo;
	}
	public void setSetWorkerCmncEstimateInfo(
			List<UserCmncEstimatePo> setWorkerCmncEstimateInfo) {
		this.setWorkerCmncEstimateInfo = setWorkerCmncEstimateInfo;
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
	public List<String> getAllPageList0() {
		return allPageList0;
	}
	public void setAllPageList0(List<String> allPageList0) {
		this.allPageList0 = allPageList0;
	}
	public String getResNum0() {
		return resNum0;
	}
	public void setResNum0(String resNum0) {
		this.resNum0 = resNum0;
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
	public String getRadarString() {
		return radarString;
	}
	public void setRadarString(String radarString) {
		this.radarString = radarString;
	}
	public WorkerWholeEstimateService getWorkerWholeEstimateService() {
		return workerWholeEstimateService;
	}
	public void setWorkerWholeEstimateService(
			WorkerWholeEstimateService workerWholeEstimateService) {
		this.workerWholeEstimateService = workerWholeEstimateService;
	}
	public String getWholeEstString() {
		return wholeEstString;
	}
	public void setWholeEstString(String wholeEstString) {
		this.wholeEstString = wholeEstString;
	}
	
    
	
}
