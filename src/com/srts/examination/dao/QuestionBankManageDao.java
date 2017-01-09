package com.srts.examination.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.BookChapter;

public interface QuestionBankManageDao extends BaseDao<QuestionBank>{
	public List findAllQuestionId();
	public List findQuestionByKeyWords(String key);
	public List findQuestionByTypeAndKeyWords(String type,String key);
	public QuestionBank findQuestionById(long id);
	public List findAllQuestion();
	public List findAllQuestionUploadTimeDesc();
	public List findAllQuestionUpdateTimeDesc();
	public List findTopFiveQuestionOrderByUploadTime();
	public List findTopFiveQuestionOrderBylastUpdateTime();
	public List<Integer> findQuestionNumByType();
	public List findQuestionByType(String type);
	public int insertQuestionBank(String type, String content, String answer, BookChapter bookChapter, String questionPic, String uploadTime, String lastUpdateTime, int selectOptions);
	public int deleteQuestionById(long id);
	public int updateQuestionContentById(long id,String content);
	public int updateQuestionAnswerById(long id,String answer);
	public int updateLastUpdateTimeById(long id, String lastUpdateTime);
	public List<Integer> findUploadQuestionNumPerMonth(String currentTime);
	public List<Integer> findUploadQuestionNumPerKind(String currentTime);
	public int updateQuestionSelectOptionsById(long id,int selectOptions);
	public int updateQuestionPicById(long id,String questionPic);
	//////////////////////////////////////////////////////////////////////////
	public void saveQuestionsInfo(QuestionBank question);
	public BookChapter getBookChapterId(String bookName,String chapterNum);
	public List<?> getByQuesIds(String questionIds,long testPaperId);
	
	public List<QuestionBank> findQuestionBank(String hql);
	
}
