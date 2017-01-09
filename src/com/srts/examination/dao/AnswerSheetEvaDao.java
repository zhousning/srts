package com.srts.examination.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.examination.domain.UserTestScore;
import com.srts.examination.po.AnswerSheetDispPo;
import com.srts.examination.po.AnswerSheetListPo;
import com.srts.examination.po.TestPaperListPo;

public interface AnswerSheetEvaDao extends BaseDao<UserTestScore> {
	public List<AnswerSheetDispPo> findAnswerSheetDispByAnswerSheetId(long answerSheetId);
	public List<AnswerSheetListPo> findAnswerSheetListByTestPaperId(long testPaperId);
	public List<TestPaperListPo> findAllTestPaper();
	public int findQuestionScore(long testPaperId,String questionType);
	public int insertIntoUserTestScore(int grade,String comment,long usrId,long testPaperId);
	public long findTestPaperIdByAnswerSheetId(long answerSheetId);
	public long findUsrIdByAnswerSheetId(long answerSheetId);

}
