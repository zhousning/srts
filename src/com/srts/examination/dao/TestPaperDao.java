package com.srts.examination.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.examination.domain.QuestionScoreList;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.po.QuestionBankPo;

public interface TestPaperDao extends BaseDao<TestPaper> {
	
	public List<QuestionBankPo> getPaperQuestion(long testInfoId);
	public TestPaper geTestPaperByTestInfoID(long testInfoId);
	public List<String> getType(String questionIds);
	public List<TestPaper> findByExamDate();
	public List<TestPaper> findPaperByCon(String paperName, String examName,
			String examDate);

	public  void saveTestPaper(TestPaper testPaper);
	public List<TestPaper> findAllTestPapers();
	
	public TestPaper findTestPaperById(long id);
	public void deleteTestPaper(TestPaper testPaper);
	
	public void addQuestionScore(QuestionScoreList questionScore);

	
}
