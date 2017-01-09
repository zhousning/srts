package com.srts.examination.service;

import java.util.List;

import com.srts.examination.domain.TestPaper;
import com.srts.examination.po.AnswerSheetDispPo;
import com.srts.examination.po.AnswerSheetListPo;
import com.srts.examination.po.TestPaperListPo;
import com.srts.system.domain.Sys_User;

public interface AnswerSheetEvaService {
	public List<AnswerSheetDispPo> findAnswerSheetDispByAnswerSheetId(long answerSheetId);
	public List<AnswerSheetListPo> findAnswerSheetListByTestPaperId(long testPaperId);
	public List<TestPaperListPo> findAllTestPaper();
	public int findQuestionScore(long testPaperId,String questionType);
	public int calculateChooseMark(List<AnswerSheetDispPo> list);
	public int insertIntoUserTestScore(int grade,String comment,long usrId,long testPaperId);
	public long findTestPaperIdByAnswerSheetId(long answerSheetId);
	public long findUsrIdByAnswerSheetId(long answerSheetId);

}
