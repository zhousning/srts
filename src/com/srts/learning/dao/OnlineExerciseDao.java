package com.srts.learning.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.po.ExerciseJudgeAnswerPo;
import com.srts.learning.po.ExerciseResultSumPo;
import com.srts.learning.po.ExerciseSelectByNamePo;
import com.srts.system.domain.Sys_User;

/**
 * 
 * @author H 2014-5-21 上午09:58:40
 *
 */
@SuppressWarnings("unchecked")
public interface OnlineExerciseDao extends BaseDao<QuestionBank> {
	//----做练习前，展示信息----//
	
	public List<String[]> getRecentAccuracyRate(long userId);//获取最近n次历史准确率
	public List<String[]> getRecentAccuracyStability(long userId);//获取最近n次历史准确率稳定性
	public ExerciseResultSumPo getResultSum(long userId);//获取总答对/未答/答错次数
	
	//----做练习中，获取习题----//
	public List<ExerciseSelectByNamePo> getAllChapter();//1.章节：获取所有书+章节名
	public List<QuestionBank> getQuestionByChapter(ExerciseSelectByNamePo esbnPo);//1.章节：根据书+章节名获取对应习题
	public List<QuestionBank> getAllQuestion();//2.随机：获取所有习题
	
	//----做完练习，传回数值----//
//	public String getAnswer(QuestionBank question);//对给定一道题找正确答案
//	public boolean setOnlineExercise(ExerciseJudgeAnswerPo userAnswer);//记录本次练习统计值，更新lrn_onlineExercise表
//	public boolean setErrorSet(ExerciseJudgeAnswerPo userAnswer);//根据本次练习情况，更新lrn_errorSet表
//	public boolean setErrorSetFlagSum(ExerciseJudgeAnswerPo userAnswer);//根据本次练习情况，更新lrn_errorSetFlagSum表
	public long getCurrentExerciseSn(long userId);//确定当前练习Sn（不算此次）
	public boolean updateOnlineExercise(
			long userId, int resultRight, int resultBlank, int resultWrong, float accuracyRate, float accuracyStability, long sn, String exerciseDate, String exerciseName);//更新在线练习表
	public boolean updateErrorSetRight(ExerciseJudgeAnswerPo ejaPo);//正确时，更新错题集
	public boolean updateErrorSetWrong(ExerciseJudgeAnswerPo ejaPo);//错误时，更新错题集
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Book> getAllBooks();
	public List<BookChapter> getBookChaptersByBookID(long bookID);
	public List<QuestionBank> getChapterQuestionsByChapterID(int num,List<Long> chapterIDs);
}
