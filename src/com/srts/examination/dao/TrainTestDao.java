package com.srts.examination.dao;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.srts.common.base.BaseDao;
import com.srts.examination.domain.AnswerSheet;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.domain.UserTestScore;
import com.srts.examination.po.QuestionBankPo;
import com.srts.learning.domain.ErrorSet;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;

public interface TrainTestDao {
	public TestInfo findTestInfo(long id);
	public int findTestTakenNumByUser(Sys_User usr);
	public TestPaper findTestPaperById(long id);
	public TestPaper findTestPaperByTrainTypeMajor(Train train,String major,String type);
	public int insertAnswerSheet(Sys_User usr,TestPaper testPaper,String answer_Content);
	public List findUserTestScoreByUserAndType(Sys_User usr,String type);
	public List<Integer> categoryUserTestScore(Sys_User usr ,String type);
	public int findUserTestScoreRankByUserAndType(Sys_User usr ,String type,long testPaperId);
	public QuestionBank findQuestionById(long id);
	public List<Long> findTestPaperIdByUser(Sys_User usr,String type);
	public AnswerSheet findAnswerSheetByUserAndTestPaper(Sys_User usr,long testPaperId);
	public String findTestNameByTrainAndType(String type, long testPaperId);
	public void insertAnswer(long userId, long testPaperId,
			String questionAnswer);

}
