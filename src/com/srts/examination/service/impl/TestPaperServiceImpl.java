package com.srts.examination.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.examination.dao.QuestionBankManageDao;
import com.srts.examination.dao.TestPaperDao;
import com.srts.examination.domain.QuestionScoreList;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.service.TestPaperService;
@Service
public class TestPaperServiceImpl implements TestPaperService {

	@Resource
	private TestPaperDao testPaperDao;
	@Resource
	private QuestionBankManageDao questionBankManageDao;
	
	public TestPaper geTestPaperByTestInfoID(long testInfoId) {
		return testPaperDao.geTestPaperByTestInfoID(testInfoId);
	}

	public List<?> getQuesByIds(String questionIds,long testPaperId) {
//		return questionBankManageDao.getByIds(questionIds);
		List<?> banks=questionBankManageDao.getByQuesIds(questionIds,testPaperId);
		return  banks;
	}

	public List<String> getType(String questionIds) {
		return testPaperDao.getType(questionIds);
	}

	//查询已考完的试卷
	public List<TestPaper> findFinishedTestPaper() {
		List<TestPaper> testPapers=null;
		List<TestPaper> finishedTestPapers=new ArrayList<TestPaper>();
		
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
		
		testPapers=testPaperDao.findByExamDate();
		if (testPapers!=null) {
			Iterator<TestPaper> iterator=testPapers.iterator();
			while (iterator.hasNext()) {
				TestPaper testPaper = (TestPaper) iterator.next();
				Date exmDate;
				try {
					exmDate = dateFormat.parse(testPaper.getExam_date());
					if (exmDate.before(now)) {
						finishedTestPapers.add(testPaper);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}	
			}
		}
		return finishedTestPapers;
	}

	public List<TestPaper> findPaperByCon(String paperName, String examName,
			String examDate) {
		List<TestPaper> testPapers=null;
		testPapers=testPaperDao.findPaperByCon(paperName,examName,examDate);
		return testPapers;
	}
	
	public void saveTestPaper(TestPaper testPaper) {
		// TODO Auto-generated method stub
		testPaperDao.saveTestPaper(testPaper);
	}

	public List<TestPaper> findAllTestPapers() {
		// TODO Auto-generated method stub
		return testPaperDao.findAllTestPapers();
	}

	public void deleteTestPaper(TestPaper testPaper) {
		// TODO Auto-generated method stub
		testPaperDao.deleteTestPaper(testPaper);
	}

	public TestPaper findTestPaperById(long id) {
		// TODO Auto-generated method stub
		return testPaperDao.findTestPaperById(id);
	}

	public void addQuestionScore(QuestionScoreList questionScore) {
		// TODO Auto-generated method stub
		testPaperDao.addQuestionScore(questionScore);
	}

}
