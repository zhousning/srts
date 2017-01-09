package com.srts.examination.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.examination.dao.AnswerSheetEvaDao;
import com.srts.examination.domain.AnswerSheet;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.UserTestScore;
import com.srts.examination.po.AnswerSheetDispPo;
import com.srts.examination.po.AnswerSheetListPo;
import com.srts.examination.po.TestPaperListPo;
@Repository
@Transactional
public class AnswerSheetEvaDaoImpl extends BaseDaoImpl<UserTestScore> implements AnswerSheetEvaDao {

	public List<TestPaperListPo> findAllTestPaper() {
		List<TestPaperListPo> resList=new ArrayList<TestPaperListPo>();
		String sql="select distinct testPaperId from exm_answerSheet";
		List list=getSession().createSQLQuery(sql).list();
		if(list.isEmpty()==false)
		{
		Iterator iterator=list.iterator();
		int j=1;
		while(iterator.hasNext())
		{
			long testPaperId=Long.parseLong(String.valueOf(iterator.next()));
			String sql1="select testName,testPaperName,exam_date from exm_testPaper,exm_testInfo " +
					"where exm_testPaper.testInfoId=exm_testInfo.id and exm_testPaper.id=:id";
			String testName="";
			String testPaperName="";
			String testDate="";
			List nameList=getSession().createSQLQuery(sql1).setLong("id", testPaperId).list();
			for(int i=0;i<nameList.size();i++)
			{
				Object[] objs=(Object[])nameList.get(i);
				testName=objs[0].toString();
				testPaperName=objs[1].toString();
				testDate=objs[2].toString();
			}
			TestPaperListPo temp=new TestPaperListPo();
			temp.setId(String.valueOf(j));
			temp.setTestName(testName);
			temp.setTestPaperId(String.valueOf(testPaperId));
			temp.setTestPaperName(testPaperName);
			temp.setTestDate(testDate);
			resList.add(temp);
		}
		}
		else
		{
			TestPaperListPo temp=new TestPaperListPo();
			temp.setId(String.valueOf(1));
			temp.setTestName("暂时没有考试");
			temp.setTestPaperId(String.valueOf(0));
			temp.setTestPaperName("没有对应试卷");
			temp.setTestDate("0000-00-00");
			resList.add(temp);
		}
		return resList;
	}

	public List<AnswerSheetDispPo> findAnswerSheetDispByAnswerSheetId(
			long answerSheetId) {
		List<AnswerSheetDispPo> resList=new ArrayList<AnswerSheetDispPo>();
		String hql="from AnswerSheet where id=:id";
		AnswerSheet answerSheet=(AnswerSheet)getSession().createQuery(hql).setLong("id", answerSheetId).uniqueResult();
		String answerString=answerSheet.getContent();
		String []answerStringSplit=answerString.split(",");
		if(answerStringSplit.length!=0)
		{
		for(int i=0;i<answerStringSplit.length;i++)
		{
				String[] answerStringSplitTwice = answerStringSplit[i]
						.split("@");
				String questionId = answerStringSplitTwice[0];
				String userAnswer = "";
				if (answerStringSplitTwice.length == 2) {
					userAnswer = answerStringSplitTwice[1];
				} else if (answerStringSplitTwice.length > 2) {
					for (int j = 1; j < answerStringSplitTwice.length; j++) {
						userAnswer+=answerStringSplitTwice[j]+",";
					}
				}
			String hql1="from QuestionBank where id=:id";
			QuestionBank question=(QuestionBank)getSession().createQuery(hql1).setLong("id", Long.parseLong(questionId)).uniqueResult();
			String answerTrue=question.getAnswer();
			String questionType=question.getType();
			String sql="select score from exm_questionScoreList where testPaperId=:testPaperId and type=:type";
			String questionScore=String.valueOf(getSession().createSQLQuery(sql)
					.setLong("testPaperId", answerSheet.getTestPaper().getId())
					.setString("type", question.getType()).uniqueResult());
			AnswerSheetDispPo temp=new AnswerSheetDispPo();
			temp.setId(String.valueOf(i+1));
			temp.setAnswerSheetId(String.valueOf(answerSheetId));
			temp.setQuestionId(questionId);
			temp.setAnswerTrue(answerTrue);
			temp.setUserAnswer(userAnswer);
			temp.setQuestionScore(questionScore);
			temp.setQuestionType(questionType);
			resList.add(temp);
		}
		}
		else
		{
			AnswerSheetDispPo temp=new AnswerSheetDispPo();
			temp.setId(String.valueOf(1));
			temp.setAnswerSheetId(String.valueOf("0"));
			temp.setQuestionId("0");
			temp.setAnswerTrue("无回答记录");
			temp.setUserAnswer("无回答记录");
			temp.setQuestionScore("无试题分数");
			temp.setQuestionType("无题目类别");
			resList.add(temp);
		}
		return resList;
	}

	public List<AnswerSheetListPo> findAnswerSheetListByTestPaperId(
			long testPaperId) {
		List<AnswerSheetListPo> resList=new ArrayList<AnswerSheetListPo>();
		String sql="select exm_answerSheet.id as ASID,exm_testInfo.testName,exm_testPaper.testPaperName,srts_sys_user.workno,srts_sys_user.name " +
				"from exm_answerSheet,exm_testPaper,exm_testInfo,srts_sys_user " +
				"where exm_answerSheet.testPaperId=exm_testPaper.id " +
				"and exm_testPaper.testInfoId=exm_testInfo.id " +
				"and exm_answerSheet.usrId=srts_sys_user.id " +
				"and exm_answerSheet.testPaperId=:testPaperId";
		List list=getSession().createSQLQuery(sql).setLong("testPaperId", testPaperId).list();
		if(list.isEmpty()==false)
		{
		Iterator iterator=list.iterator();
		int i=1;
		while(iterator.hasNext())
		{
			Object[] objs=(Object[]) iterator.next();
			String id=String.valueOf(i);
			String answerSheetId=objs[0].toString();
			String testName=objs[1].toString();
			String testPaperName=objs[2].toString();
			String workno=objs[3].toString();
			String userName=objs[4].toString();
			AnswerSheetListPo temp=new AnswerSheetListPo();
			temp.setId(id);
			temp.setAnswerSheetId(answerSheetId);
			temp.setTestName(testName);
			temp.setTestPaperName(testPaperName);
			temp.setUserName(userName);
			temp.setWorkno(workno);
			resList.add(temp);
		}
		}
		else
		{
			AnswerSheetListPo temp=new AnswerSheetListPo();
			temp.setId("1");
			temp.setAnswerSheetId("0");
			temp.setTestName("无记录");
			temp.setTestPaperName("无记录");
			temp.setUserName("无记录");
			temp.setWorkno("无记录");
			resList.add(temp);
		}
		return resList;
	}

	public int findQuestionScore(long testPaperId, String questionType) {
		String sql="select score from exm_questionScoreList where testPaperId=:testPaperId and type=:type";
		int questionScore=Integer.parseInt(String.valueOf(getSession().createSQLQuery(sql)
				.setLong("testPaperId", testPaperId)
				.setString("type", questionType).uniqueResult()));
		return questionScore;
	}

	public int insertIntoUserTestScore(int grade, String comment, long usrId,
			long testPaperId) {
		int insertRes=0;
		String sql="select * from exm_userTestScore where usrId=:usrId and testPaperId=:testPaperId";
		List list=getSession().createSQLQuery(sql).setLong("usrId", usrId).setLong("testPaperId", testPaperId).list();
		if(list.isEmpty()==true)
        {
			String sql2 = "insert into exm_userTestScore(grade,comment,usrId,testPaperId) values(?,?,?,?)";
			SQLQuery query = getSession().createSQLQuery(sql2);
			query.setInteger(0, grade);
			query.setString(1, comment);
			query.setLong(2, usrId);
			query.setLong(3, testPaperId);
			insertRes = query.executeUpdate();
		}
		else
		{
			String sql1="update exm_userTestScore set grade=:grade where usrId=:usrId and testPaperId=:testPaperId";
			insertRes = getSession().createSQLQuery(sql1).setInteger("grade",grade)
			.setLong("usrId", usrId)
			.setLong("testPaperId", testPaperId).executeUpdate();
		}
		return insertRes;
	}

	public long findTestPaperIdByAnswerSheetId(long answerSheetId) {
		String sql="select testPaperId from exm_answerSheet where id=:id";
		long testPaperId=Long.parseLong(String.valueOf(getSession().createSQLQuery(sql).setLong("id", answerSheetId).uniqueResult()));
		return testPaperId;
	}
	public long findUsrIdByAnswerSheetId(long answerSheetId) {
		String sql="select usrId from exm_answerSheet where id=:id";
		long usrId=Long.parseLong(String.valueOf(getSession().createSQLQuery(sql).setLong("id", answerSheetId).uniqueResult()));
		return usrId;
	}

}
