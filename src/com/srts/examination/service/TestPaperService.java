package com.srts.examination.service;

import java.util.List;

import com.srts.examination.domain.QuestionScoreList;
import com.srts.examination.domain.TestPaper;


public interface TestPaperService  {

	public TestPaper geTestPaperByTestInfoID(long testInfoId);

	public List<?> getQuesByIds(String questionIds, long testPaperId);

	public List<String> getType(String questionIds);

	public List<TestPaper> findFinishedTestPaper();

	public List<TestPaper> findPaperByCon(String paperName, String examName,
			String examDate);
	public  void saveTestPaper(TestPaper testPaper);
	
	public List<TestPaper> findAllTestPapers();
	
	public TestPaper findTestPaperById(long id);
	public void deleteTestPaper(TestPaper testPaper);
	
	public void addQuestionScore(QuestionScoreList questionScore);
	
}
