package com.srts.examination.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.examination.dao.AnswerSheetEvaDao;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.domain.UserTestScore;
import com.srts.examination.po.AnswerSheetDispPo;
import com.srts.examination.po.AnswerSheetListPo;
import com.srts.examination.po.TestPaperListPo;
import com.srts.examination.service.AnswerSheetEvaService;
import com.srts.system.domain.Sys_User;
@Service
public class AnswerSheetEvaServiceImpl implements AnswerSheetEvaService{
	@Resource
	private AnswerSheetEvaDao dao;

	public int calculateChooseMark(List<AnswerSheetDispPo> list) {
		int resMark=0;
		for(int i=0;i<list.size();i++)
		{
			AnswerSheetDispPo temp=list.get(i);
			if(temp.getQuestionType().equals("单选题")==true||
					temp.getQuestionType().equals("多选题")==true||
					temp.getQuestionType().equals("判断题")==true)
			{
				if(temp.getAnswerTrue().equals(temp.getUserAnswer())==true)
				{
					resMark+=Integer.parseInt(temp.getQuestionScore());
				}
			}
		}
		return resMark;
	}

	public List<TestPaperListPo> findAllTestPaper() {
		List<TestPaperListPo> resList=dao.findAllTestPaper();
		return resList;
	}

	public List<AnswerSheetDispPo> findAnswerSheetDispByAnswerSheetId(
			long answerSheetId) {
		List<AnswerSheetDispPo> resList = dao.findAnswerSheetDispByAnswerSheetId(answerSheetId);
		return resList;
	}

	public List<AnswerSheetListPo> findAnswerSheetListByTestPaperId(
			long testPaperId) {
		List<AnswerSheetListPo> resList= dao.findAnswerSheetListByTestPaperId(testPaperId);
		return resList;
	}

	public int findQuestionScore(long testPaperId, String questionType) {
		int res=dao.findQuestionScore(testPaperId, questionType);
		return res;
	}

	public int insertIntoUserTestScore(int grade, String comment, long usrId,
			long testPaperId) {
		int insertRes=dao.insertIntoUserTestScore(grade, comment, usrId, testPaperId);
		return insertRes;
	}

	public long findTestPaperIdByAnswerSheetId(long answerSheetId) {
		long testPaperId=dao.findTestPaperIdByAnswerSheetId(answerSheetId);
		return testPaperId;
	}
	public long findUsrIdByAnswerSheetId(long answerSheetId) {
		long usrId=dao.findUsrIdByAnswerSheetId(answerSheetId);
		return usrId;
	}

}
