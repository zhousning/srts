package com.srts.estimation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.estimation.dao.WorkerTrainTestEstimateDao;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPaper;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;
@Repository
@Transactional
public class WorkerTrainTestEstimateDaoImpl implements WorkerTrainTestEstimateDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public TestPaper findTestPaperByTrainTypeMajor(Train train, String major,
			String type) {
		// TODO Auto-generated method stub
		long TrainId=train.getId();
		String HQL="from TestPaper "+
		"where trainId=:TrainId and type=:type and major=:major";
		return (TestPaper) sessionFactory.getCurrentSession()
		.createQuery(
				HQL).setLong("TrainId", TrainId).setString("type",type).setString("major",major).uniqueResult();
	}


	@SuppressWarnings("unchecked")
	public List findUserTestScoreByUserAndType(Sys_User usr,
			String type) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		String SQL="select * from exm_userTestScore,exm_testPaper,exm_testInfo "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId and exm_testPaper.testInfoId=exm_testInfo.id "+
		"and exm_testPaper.type=:type";
		return (List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setLong("UsrId", UsrId).setString("type",type).list();
		
	}

	public List<Integer> categoryUserTestScore(Sys_User usr, String type) {
		// TODO Auto-generated method stub
		List<Integer> resList=new ArrayList<Integer>();
		long UsrId=usr.getId();
		//int bound=90;
		String SQL1="select count(*) from exm_userTestScore,exm_testPaper "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId "+
		"and exm_testPaper.type=:type "+
		"and exm_userTestScore.grade<90";
		String SQL2="select count(*) from exm_userTestScore,exm_testPaper "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId "+
		"and exm_testPaper.type=:type "+
		"and exm_userTestScore.grade>=90 and exm_userTestScore.grade<=92";
		String SQL3="select count(*) from exm_userTestScore,exm_testPaper "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId "+
		"and exm_testPaper.type=:type "+
		"and exm_userTestScore.grade>=93 and exm_userTestScore.grade<=95";
		String SQL4="select count(*) from exm_userTestScore,exm_testPaper "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId "+
		"and exm_testPaper.type=:type "+
		"and exm_userTestScore.grade>=96 and exm_userTestScore.grade<=98";
		String SQL5="select count(*) from exm_userTestScore,exm_testPaper "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId "+
		"and exm_testPaper.type=:type "+
		"and exm_userTestScore.grade>=99 and exm_userTestScore.grade<=100";
		int kindone=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL1).setLong("UsrId",UsrId).setString("type",type).list().get(0)));
		int kindtwo=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
				.createSQLQuery(
						SQL2).setLong("UsrId",UsrId).setString("type",type).list().get(0)));
		int kindthree=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
				.createSQLQuery(
						SQL3).setLong("UsrId",UsrId).setString("type",type).list().get(0)));
		int kindfour=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
				.createSQLQuery(
						SQL4).setLong("UsrId",UsrId).setString("type",type).list().get(0)));
		int kindfive=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
				.createSQLQuery(
						SQL5).setLong("UsrId",UsrId).setString("type",type).list().get(0)));
		resList.add(kindone);
		resList.add(kindtwo);
		resList.add(kindthree);
		resList.add(kindfour);
		resList.add(kindfive);
		return resList;
	}

	public String findTestNameByTrainAndType(String type, long testPaperId) {
		// TODO Auto-generated method stub
		String SQL="select exm_testInfo.testName from exm_testInfo,exm_testPaper " +
				"where exm_testPaper.id=:id and exm_testPaper.type=:type and exm_testPaper.testInfoId=exm_testInfo.id";
		String testName=sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setString("type",type).setLong("id",testPaperId).list().get(0).toString();
		return testName;
	}
	public int findUserTestScoreRankByUserAndType(Sys_User usr,
			String type, long testPaperId) {
		// TODO Auto-generated method stub
		long usrId=usr.getId();
		String SQL="select count(*) from exm_userTestScore,exm_testPaper,exm_testInfo" +
				" where exm_userTestScore.testPaperId=exm_testPaper.id" +
				" and exm_testPaper.type=:type" +
				" and exm_testPaper.id=:id" +
				" and exm_testInfo.id=exm_testPaper.testInfoId"+
				" and exm_userTestScore.grade>(" +
				"select MAX(grade) from exm_userTestScore,exm_testPaper,exm_testInfo" +
				" where exm_userTestScore.testPaperId=exm_testPaper.id" +
				" and exm_testPaper.id=:id" +
				" and exm_testInfo.id=exm_testPaper.testInfoId"+
				" and exm_testPaper.type=:type" +
				" and exm_userTestScore.usrId=:usrId)";
		int rank=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
				.createSQLQuery(
						SQL).setLong("usrId",usrId).setString("type",type).setLong("id",testPaperId).list().get(0)));
		rank+=1;
		return rank;
	}

	public TestPaper findTestPaperById(long id) {
		// TODO Auto-generated method stub
		String HQL="from TestPaper "+
		"where id=:id";
		return (TestPaper) sessionFactory.getCurrentSession()
		.createQuery(
				HQL).setLong("id", id).uniqueResult();
	}

	public List findTestPaperIdByUser(Sys_User usr,String type) {
		// TODO Auto-generated method stub
		long usrId=usr.getId();
		String SQL="select exm_answerSheet.testPaperId " +
				"from exm_answerSheet,exm_testPaper " +
				"where exm_answerSheet.testPaperId=exm_testPaper.id " +
				"and exm_answerSheet.usrId=:usrId " +
				"and exm_testPaper.type=:type";
		return (List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setString("type",type).setLong("usrId", usrId).list();
	}

	public TestInfo findTestInfo(long id) {
		// TODO Auto-generated method stub
		String HQL="from TestInfo "+
		"where id=:id";
		return (TestInfo) sessionFactory.getCurrentSession()
		.createQuery(
				HQL).setLong("id", id).uniqueResult();
	}

	public int findTestTakenNumByUser(Sys_User usr) {
		// TODO Auto-generated method stub
		long id=usr.getId();
		String SQL="select count(*) from exm_record "+
		"where exm_record.usrId=:id ";
		int num=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
				.createSQLQuery(
						SQL).setLong("id",id).list().get(0)));
		num=num+1;
		return num;
	}

}
