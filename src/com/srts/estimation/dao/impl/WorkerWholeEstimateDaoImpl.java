package com.srts.estimation.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.estimation.dao.WorkerWholeEstimateDao;
import com.srts.system.domain.Sys_User;

@Repository
@Transactional
public class WorkerWholeEstimateDaoImpl implements WorkerWholeEstimateDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public List<String[]> getAveStudySumTimeToNow(Sys_User usr) throws ParseException {
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String day=String.valueOf(calendar.get(Calendar.DATE));
		if(month.length()==1)
		{
			month="0"+month;
		}
		if(day.length()==1)
		{
			day="0"+day;
		}
		String currentTime=year+"-"+month+"-"+day;
		String endTime=currentTime;
		List<String[]> timeInfoList=new ArrayList<String[]>();
		List studyRecordList=(List) sessionFactory.getCurrentSession()
		.createSQLQuery("select * from lrn_myStudyCourse where lrn_myStudyCourse.usrId=:usrId").setLong("usrId", usr.getId()).list();
		if(studyRecordList.isEmpty()==false)
		{
		Iterator iterator = studyRecordList.iterator();
		String trainTimeLengthToday="0";
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String startTime=objs[1].toString();
			if(objs[2].toString().compareTo(currentTime)<0)
			{
				endTime=objs[2].toString();
			}
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			Date start=ft.parse(startTime);
			Date end=ft.parse(endTime);
			long dateLength=(end.getTime()-start.getTime())/1000/60/60/24;
			if(dateLength==0)
			{
				dateLength=1;
			}
			long sumtime=Long.parseLong(objs[3].toString());
			String aveStudyTime=String.valueOf((sumtime/dateLength));
			String []addItem = {objs[8].toString(),aveStudyTime};
			timeInfoList.add(addItem);
			}
		}
		else
		{
			String empty[]={"0","0"};
			timeInfoList.add(empty);
		}
		return timeInfoList;
	}

	public List<String[]> getExerciseAccuracyRateToNow(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		String sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId";
		Long usrId=usr.getId();
		List res =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId", usrId).list();//
		String sql1="select distinct lrn_onlineExercise.exerciseName from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId";
		List res1 =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql1).setLong("usrId", usrId).list();
		List<String> exerciseNameList=new ArrayList<String>();
		for(int i=0;i<res1.size();i++)
		{
			exerciseNameList.add(res1.get(i).toString());
		}
		if(exerciseNameList.size()==0)
		{
			String accuracyString=String.valueOf(0);
			String courseString="无记录";
			String []addItem = {"1",accuracyString,courseString};
			resList.add(addItem);
		}
		for(int j=0;j<exerciseNameList.size();j++)
		{
			int rightNum=0;
			int allNum=0;
			float accuracy=0;
			Iterator iterator = res.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				if(objs[9].toString().equals(exerciseNameList.get(j))==true)
				{
					allNum+=(Integer.parseInt(String.valueOf(objs[2]))+Integer.parseInt(String.valueOf(objs[3]))+Integer.parseInt(String.valueOf(objs[4])));
					rightNum+=Integer.parseInt(String.valueOf(objs[2]));				
				}
			}
			accuracy=(float)rightNum/allNum;
			String id=String.valueOf(j+1);
			String accuracyString=String.valueOf(accuracy);
			String courseString=exerciseNameList.get(j);
			String []addItem = {id,accuracyString,courseString};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> getExerciseAmountToNow(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		String sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId";
		Long usrId=usr.getId();
		List res =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId", usrId).list();//
		String sql1="select distinct lrn_onlineExercise.exerciseName from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId";
		int allNum=0;
		Iterator iterator = res.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			allNum+=(Integer.parseInt(String.valueOf(objs[4]))+Integer.parseInt(String.valueOf(objs[5]))+Integer.parseInt(String.valueOf(objs[6])));					
		}
		String aveExerciseQuestionNum="0";
		String exerciseAmount=String.valueOf(res.size());
		if(allNum!=0)
		{
		aveExerciseQuestionNum=String.valueOf((float)(allNum/res.size()));
		}
		String []addItem = {exerciseAmount,aveExerciseQuestionNum};
		resList.add(addItem);
		return resList;
	}
	
	public List<String[]> selectWorkerProCmncAcp(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
		String sql = "select count(*) from cmnc_answerinfo where cmnc_answerinfo.usrId=:usrId";
		String sql1 = "select count(*) from cmnc_answerinfo,cmnc_pbmansaccept where cmnc_answerinfo.usrId=:usrId and " +
				"cmnc_pbmansaccept.answerId=cmnc_answerinfo.id";
		long usrId = usr.getId();
		int answerAll = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setLong("usrId", usrId)
				.list().get(0)));
		int answerAcp = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId)
				.list().get(0)));
		String[] addItem1 = { String.valueOf(answerAll), "回答数目" };
		String[] addItem2 = { String.valueOf(answerAcp), "被采纳回答数目" };
		String[] addItem3 = { String.valueOf(answerAll-answerAcp), "未被采纳回答数目" };
		res.add(addItem1);
		res.add(addItem2);
		res.add(addItem3);
		return res;
	}
	
	public List<String[]> selectWorkerProCmncAmount(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
		String sql = "select count(*) from cmnc_probleminfo where cmnc_probleminfo.usrId=:usrId";
		String sql1 = "select count(*) from cmnc_answerinfo where cmnc_answerinfo.usrId=:usrId";
		long usrId = usr.getId();
		int ask = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setLong("usrId", usrId)
				.list().get(0)));
		int answer = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId)
				.list().get(0)));
		String[] addItem1 = { String.valueOf(ask), "提问数目" };
		String[] addItem2 = { String.valueOf(answer), "回答数目" };
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}
	
	public List<String[]> selectWorkerStuCmncAmount(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
		String sql = "select count(*) from cmnc_bbsartical where cmnc_bbsartical.usrId=:usrId";
		String sql1 = "select count(*) from cmnc_bbsarticalreply where cmnc_bbsarticalreply.usrId=:usrId";
		String sql2 = "select count(*) from cmnc_bbsarticalreply where cmnc_bbsarticalreply.usrId=:usrId";
		long usrId = usr.getId();
		int ask = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setLong("usrId", usrId).list().get(0)));
		int answer = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId).list().get(0)));
		int answer2 = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql2).setLong("usrId", usrId).list().get(0)));
		String[] addItem1 = { String.valueOf(ask), "提问数目" };
		String[] addItem2 = { String.valueOf(answer+answer2), "回答数目" };
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}
	
	public List<String[]> workerKlgSearchEst(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
		long usrId=usr.getId();
		String sql1="select count(*) from klg_violationSearchRecord where klg_violationSearchRecord.usrId=:usrId";
		String sql2="select count(*) from klg_ruleLearningSearchRecord where klg_ruleLearningSearchRecord.usrId=:usrId";
		String sql3="select count(*) from klg_caseSearchRecord where klg_caseSearchRecord.usrId=:usrId";
		String sql4="select count(*) from klg_experienceSearchRecord where klg_experienceSearchRecord.usrId=:usrId";
		int vio = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId).list().get(0)));
		int rule = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql2).setLong("usrId", usrId).list().get(0)));
		int tcase = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql3).setLong("usrId", usrId).list().get(0)));
		int exp = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql4).setLong("usrId", usrId).list().get(0)));
		String[] addItem1 = { String.valueOf(vio), "典型违章" };
		String[] addItem2 = { String.valueOf(rule), "条文导学" };
		String[] addItem3 = { String.valueOf(tcase), "典型案例" };
		String[] addItem4 = { String.valueOf(exp), "操作经验" };
		res.add(addItem1);
		res.add(addItem2);
		res.add(addItem3);
		res.add(addItem4);
		return res;
	}

	public List<String[]> workerOpExpUpload(Sys_User usr) {
		String sql = "select count(*) from klg_experience where "
				+ "klg_experience.usrId=:usrId and klg_experience.statement=:statement";
		long usrId = usr.getId();
		int checked = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setString("statement", "已审核")
				.setLong("usrId", usrId).list().get(0)));
		int unchecked = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setString("statement", "未审核")
				.setLong("usrId", usrId).list().get(0)));
		List<String[]> res = new ArrayList<String[]>();
		String[] addItem1 = { String.valueOf(checked), "已审核" };
		String[] addItem2 = { String.valueOf(unchecked), "未审核" };
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}
	
	public List<String[]> findUserTestScoreByUserAndType(Sys_User usr,
			String type) {
		long UsrId=usr.getId();
		String SQL="select * from exm_userTestScore,exm_testPaper,exm_testInfo "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId and exm_testPaper.testInfoId=exm_testInfo.id "+
		"and exm_testPaper.type=:type";
		List list=sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setLong("UsrId", UsrId).setString("type",type).list();
		Iterator iterator=list.iterator();
		List<String[]> resList=new ArrayList<String[]>();
		int i=1;
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String score=objs[1].toString();
			String[] add={String.valueOf(i),score};
			resList.add(add);
			i++;
		}
		return resList;
	}

	public List<String[]> findUserTestScoreStability(Sys_User usr, String type) {
		long UsrId=usr.getId();
		String SQL="select * from exm_userTestScore,exm_testPaper,exm_testInfo "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId and exm_testPaper.testInfoId=exm_testInfo.id "+
		"and exm_testPaper.type=:type";
		List list=sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setLong("UsrId", UsrId).setString("type",type).list();
		Iterator iterator=list.iterator();
		List<Integer> scoreList=new ArrayList<Integer>();
		int i=1;
		int sum=0;
		double aveScore=0;
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			int score=Integer.parseInt(objs[1].toString());
			sum+=score;
			scoreList.add(score);
		}
		if(scoreList.size()!=0)
		{
		aveScore=(double)(sum/scoreList.size());
		}
		else
		{
			aveScore=1;
		}
		double square=0;
		for(int j=0;j<scoreList.size();j++)
		{
			square+=(scoreList.get(j)-aveScore)*(scoreList.get(j)-aveScore);
		}
		double cv=0;
		if(scoreList.size()!=0)
		{
			cv=(double)(Math.sqrt(square/scoreList.size())/aveScore);
		}
		else
		{
			cv=(double)(Math.sqrt(square/1/aveScore));
		}
		List<String[]> resList=new ArrayList<String[]>();
		String[] temp={"成绩稳定性",String.valueOf(cv)};
		resList.add(temp);
		return resList;
	}

}
