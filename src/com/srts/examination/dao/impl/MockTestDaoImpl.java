package com.srts.examination.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.examination.dao.MockTestDao;
import com.srts.examination.domain.AnswerSheet;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPaper;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;
@Repository
@Transactional
public class MockTestDaoImpl implements MockTestDao {
	
	@Resource
	private SessionFactory sessionFactory;
	public List<Integer> categoryUserTestScore(Sys_User usr, String type) {
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
		String SQL="select exm_testInfo.testName from exm_testInfo,exm_testPaper " +
				"where exm_testPaper.id=:id and exm_testPaper.type=:type and exm_testPaper.testInfoId=exm_testInfo.id";
		String testName=sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setString("type",type).setLong("id",testPaperId).list().get(0).toString();
		return testName;
	}

	public TestPaper findTestPaperByTrainTypeMajor(Train train, String major,
			String type) {
		long TrainId=train.getId();
		String HQL="from TestPaper "+
		"where trainId=:TrainId and type=:type and major=:major";
		return (TestPaper) sessionFactory.getCurrentSession()
		.createQuery(
				HQL).setLong("TrainId", TrainId).setString("type",type).setString("major",major).uniqueResult();
	}

	public List findUserTestScoreByUserAndType(Sys_User usr,
			String type) {
		long UsrId=usr.getId();
		String SQL="select * from exm_userTestScore,exm_testPaper,exm_testInfo "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId and exm_testPaper.testInfoId=exm_testInfo.id "+
		"and exm_testPaper.type=:type";
		return (List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setLong("UsrId", UsrId).setString("type",type).list();
	}

	public int insertAnswerSheet(Sys_User usr, TestPaper testPaper,
			String answerContent) {
		long UsrId=usr.getId();
		long TestPaperId=testPaper.getId();
		String AnswerContent=answerContent;
		String sql="insert into exm_answerSheet(usrId,testPaperId,content) values(?,?,?)";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setLong(0,UsrId);
		query.setLong(1, TestPaperId);
		query.setString(2, AnswerContent);
		int insertRes=query.executeUpdate();
		return insertRes;
	}
	public QuestionBank findQuestionById(long id) {
		String HQL="from QuestionBank where id=:id";
		return (QuestionBank) sessionFactory.getCurrentSession().createQuery(HQL).setLong("id",id).uniqueResult();
	}

	public TestPaper findTestPaperById(long testPaperId) {
		String HQL="from TestPaper "+
		"where id=:id";
		return (TestPaper) sessionFactory.getCurrentSession()
		.createQuery(
				HQL).setLong("id", testPaperId).uniqueResult();
	}

	public int findUserTestScoreRankByUserAndType(Sys_User usr,
			String type, long testPaperId) {
		long usrId=usr.getId();
		String SQL="select count(*) from exm_userTestScore,exm_testPaper,exm_testInfo" +
				" where exm_userTestScore.testPaperId=exm_testPaper.id" +
				" and exm_testPaper.type=:type" +
				" and exm_testPaper.id=:id" +
				" and exm_testInfo.id=exm_testPaper.testInfoId"+
				" and exm_userTestScore.grade>(" +
				"select grade from exm_userTestScore,exm_testPaper,exm_testInfo" +
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
	public List findTestPaperIdByUser(Sys_User usr,String type) {
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

	public AnswerSheet findAnswerSheetByUserAndTestPaper(Sys_User usr,
			long testPaperId) {
		long usrId=usr.getId();
		String HQL="from AnswerSheet where usrId=:usrId and testPaperId=:testPaperId";
		return (AnswerSheet) sessionFactory.getCurrentSession()
		.createQuery(
				HQL).setLong("testPaperId",testPaperId).setLong("usrId", usrId).uniqueResult();
	}
	public TestInfo findTestInfo(long id) {
		String HQL="from TestInfo where id=:id";
		return (TestInfo) sessionFactory.getCurrentSession().createQuery(HQL).setLong("id", id).uniqueResult();
	}

	public int findTestTakenNumByUser(Sys_User usr) {
		long id=usr.getId();
		String SQL="select count(*) from exm_userTestScore,exm_testPaper "+
		"where exm_userTestScore.usrId=:id " +
		"and exm_userTestScore.testPaperId=exm_testPaper.id" +
		" and exm_testPaper.type=:type";
		int num=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
				.createSQLQuery(
						SQL).setLong("id",id).setString("type", "模拟").list().get(0)));
		num=num+1;
		return num;
	}

}
