package com.srts.controlPanel.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.controlPanel.dao.PersonalInfoListDao;
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
import com.srts.controlPanel.service.PersonalInfoListService;
import com.srts.estimation.service.WorkerCmncEstimateService;
import com.srts.estimation.service.WorkerKlgBankEstimateService;
import com.srts.estimation.service.WorkerOnlineExerciseEstService;
import com.srts.estimation.service.WorkerOnlineStudyEstService;
import com.srts.estimation.service.WorkerTestEstimateService;
import com.srts.estimation.service.WorkerTrainTestEstimateService;
import com.srts.estimation.service.WorkerWholeEstimateService;
import com.srts.system.domain.Sys_User;
import com.srts.utils.estUtils.FCMalgorithm;
@Service
public class PersonalInfoListServiceImpl implements PersonalInfoListService {
	@Resource
	private PersonalInfoListDao dao;
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

	public List<MyAnswerInfoPo> selectAnswerInfoByUser(Sys_User usr) {
		List<String[]> list=dao.selectAnswerInfoByUser(usr);
		List<MyAnswerInfoPo> resList=new ArrayList<MyAnswerInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			MyAnswerInfoPo temp=new MyAnswerInfoPo();
			String id=String.valueOf(i+1);
			String answerContent=list.get(i)[1];
			String answerDate=list.get(i)[2];
			temp.setId(id);
			temp.setAnswerContent(answerContent);
			temp.setAnswerDate(answerDate);
			resList.add(temp);
		}
		return resList;
	}

	public List<MyCompetitionInfoPo> selectCompetitionInfoByUser(Sys_User usr) {
		List<String[]> list=dao.selectCompetitionInfoByUser(usr);
		List<MyCompetitionInfoPo> resList=new ArrayList<MyCompetitionInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			MyCompetitionInfoPo temp=new MyCompetitionInfoPo();
			String id= String.valueOf(i+1);
			String date=list.get(i)[0];
			String grade=list.get(i)[1];
			String time=list.get(i)[2];
			temp.setId(id);
			temp.setDate(date);
			temp.setGrade(grade);
			temp.setTime(time);
			resList.add(temp);
		}
		return resList;
	}

	public List<MyCourseInfoPo> selectCourseInfoByUser(Sys_User usr) {
		List<String[]> list=dao.selectCourseInfoByUser(usr);
		List<MyCourseInfoPo> resList=new ArrayList<MyCourseInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			MyCourseInfoPo temp=new MyCourseInfoPo();
			String id=String.valueOf(i+1);
			String studyContent=list.get(i)[0];
			String studyTime=list.get(i)[1];
			String lastStudyDate=list.get(i)[2];
			temp.setId(id);
			temp.setLastStudyDate(lastStudyDate);
			temp.setStudyContent(studyContent);
			temp.setStudyTime(studyTime);
			resList.add(temp);
		}
		return resList;
	}

	public List<MyExerciseInfoPo> selectExerciseInfoByUser(Sys_User usr) {
		List<String[]> list=dao.selectExerciseInfoByUser(usr);
		List<MyExerciseInfoPo> resList=new ArrayList<MyExerciseInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			MyExerciseInfoPo temp=new MyExerciseInfoPo();
			String id=String.valueOf(i+1);
			String exerciseName=list.get(i)[0];
			String exerciseDate=list.get(i)[1];
			String exerciseAcur=list.get(i)[2];
			temp.setId(id);
			temp.setExerciseAcur(exerciseAcur);
			temp.setExerciseDate(exerciseDate);
			temp.setExerciseName(exerciseName);
			resList.add(temp);
		}
		return resList;
	}

	public List<FavorCourseInfoPo> selectFavorCourse() {
		List<String[]> list=dao.selectFavorCourse();
		List<FavorCourseInfoPo> resList=new ArrayList<FavorCourseInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			FavorCourseInfoPo temp=new FavorCourseInfoPo();
			String id=String.valueOf(i+1);
			String bookName=list.get(i)[0];
			String viewCount=list.get(i)[1];
			temp.setId(id);
			temp.setBookName(bookName);
			temp.setViewCount(viewCount);
			resList.add(temp);
		}
		return resList;
	}

	public List<FavorKlgBankInfoPo> selectFavorKlgBank() {
		List<String[]> list=dao.selectFavorKlgBank();
		List<FavorKlgBankInfoPo> resList=new ArrayList<FavorKlgBankInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			FavorKlgBankInfoPo temp=new FavorKlgBankInfoPo();
			String id=list.get(i)[3];
			String title=list.get(i)[1];
			String type=list.get(i)[0];
			String viewCount=list.get(i)[2];
			temp.setId(id);
			temp.setTitle(title);
			temp.setType(type);
			temp.setViewCount(viewCount);
			resList.add(temp);
		}
		return resList;
	}

	public List<FavorThemeInfoPo> selectFavorThemeByUser() {
		List<String[]> list=dao.selectFavorThemeByUser();
		List<FavorThemeInfoPo> resList=new ArrayList<FavorThemeInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			FavorThemeInfoPo temp=new FavorThemeInfoPo();
			String id=list.get(i)[0];
			String articleTitle=list.get(i)[1];
			String articleDate=list.get(i)[2];
			String userName=list.get(i)[3];
			String replyCount=list.get(i)[4];
			temp.setId(id);
			temp.setArticleTitle(articleTitle);
			temp.setArticleDate(articleDate);
			temp.setUserName(userName);
			temp.setReplyCount(replyCount);
			resList.add(temp);
		}
		return resList;
	}

	public List<MyKlgUploadInfoPo> selectKlgBankInfoByUser(Sys_User usr) {
		List<String[]> list=dao.selectKlgBankInfoByUser(usr);
		List<MyKlgUploadInfoPo> resList=new ArrayList<MyKlgUploadInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			MyKlgUploadInfoPo temp=new MyKlgUploadInfoPo();
			String id=String.valueOf(i+1);
			String klgContent=list.get(i)[0];
			String klgDate=list.get(i)[1];
			String type=list.get(i)[2];
			temp.setId(id);
			temp.setKlgContent(klgContent);
			temp.setKlgDate(klgDate);
			temp.setType(type);
			resList.add(temp);
		}
		return resList;
	}

	public List<MyTestInfoPo> selectMockTestInfoByUser(Sys_User usr) {
		List<String[]> list=dao.selectMockTestInfoByUser(usr);
		List<MyTestInfoPo> resList=new ArrayList<MyTestInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			MyTestInfoPo temp=new MyTestInfoPo();
			String id=String.valueOf(i+1);
			String testDate=list.get(i)[0];
			String testContent=list.get(i)[1];
			String grade=list.get(i)[2];
			String testCompany=list.get(i)[3];
			String tips=list.get(i)[4];
			temp.setId(id);
			temp.setGrade(grade);
			temp.setTestCompany(testCompany);
			temp.setTestContent(testContent);
			temp.setTestDate(testDate);
			temp.setTips(tips);
			resList.add(temp);
		}
		return resList;
	}

	public List<MyNoticeInfoPo> selectNoticeByUser(Sys_User usr) {
		List<String[]> list=dao.selectNoticeByUser(usr);
		List<MyNoticeInfoPo> resList=new ArrayList<MyNoticeInfoPo>();
		//for(int i=0;i<list.size();i++)
		for(int i=0;i<3;i++)
		{
			MyNoticeInfoPo temp=new MyNoticeInfoPo();
			String id=list.get(i)[0];
			String noticeType=list.get(i)[1];
			String noticeTitle=list.get(i)[2];
			String noticeContent=list.get(i)[3];
			temp.setId(id);
			temp.setType(noticeType);
			temp.setTitle(noticeTitle);
			temp.setContent(noticeContent);
			resList.add(temp);
		}
		return resList;
	}

	public List<MyProblemInfoPo> selectProblemInfoByUser(Sys_User usr) {
		List<String[]> list=dao.selectProblemInfoByUser(usr);
		List<MyProblemInfoPo> resList=new ArrayList<MyProblemInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			MyProblemInfoPo temp=new MyProblemInfoPo();
			String id=String.valueOf(i+1);
			String proContent=list.get(i)[1];
			String proDate=list.get(i)[2];
			String proAnsCount=list.get(i)[3];
			temp.setId(id);
			temp.setProAnsCount(proAnsCount);
			temp.setProContent(proContent);
			temp.setProDate(proDate);
			resList.add(temp);
		}
		return resList;
	}

	public List<MyThemeInfoPo> selectThemeByUser(Sys_User usr) {
		List<String[]> list=dao.selectThemeByUser(usr);
		List<MyThemeInfoPo> resList=new ArrayList<MyThemeInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			MyThemeInfoPo temp=new MyThemeInfoPo();
			String id=String.valueOf(i+1);
			String articleTitle=list.get(i)[1];
			String articleDate=list.get(i)[2];
			String userName=list.get(i)[3];
			String replyCount=list.get(i)[4];
			temp.setId(id);
			temp.setArticleTitle(articleTitle);
			temp.setArticleDate(articleDate);
			temp.setUserName(userName);
			temp.setReplyCount(replyCount);
			resList.add(temp);
		}
		return resList;
	}

	public List<MyTestInfoPo> selectTrainTestInfoByUser(Sys_User usr) {
		List<String[]> list=dao.selectTrainTestInfoByUser(usr);
		List<MyTestInfoPo> resList=new ArrayList<MyTestInfoPo>();
		for(int i=0;i<list.size();i++)
		{
			MyTestInfoPo temp=new MyTestInfoPo();
			String id=String.valueOf(i+1);
			String testDate=list.get(i)[0];
			String testContent=list.get(i)[1];
			String grade=list.get(i)[2];
			String testCompany=list.get(i)[3];
			String tips=list.get(i)[4];
			temp.setId(id);
			temp.setGrade(grade);
			temp.setTestCompany(testCompany);
			temp.setTestContent(testContent);
			temp.setTestDate(testDate);
			temp.setTips(tips);
			resList.add(temp);
		}
		return resList;
	}

	public MyEstInfoPo setEstInfo(Sys_User usr) throws ParseException {
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
		MyEstInfoPo estInfo=new MyEstInfoPo();
		String wholeEstString="";
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
		estInfo.setContent(wholeEstString);
		return estInfo;
	}

}
