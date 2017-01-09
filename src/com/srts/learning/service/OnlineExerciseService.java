package com.srts.learning.service;

import java.util.List;

import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.po.ExerciseJudgeAnswerPo;
import com.srts.system.domain.Sys_User;

/**
 * 
 * @author H 2014-5-22 下午10:37:30
 *
 */
public interface OnlineExerciseService {
	//----做练习前，展示信息----//
	public String getRecentAccuracyRateN(Sys_User usr);//获取最近n次历史准确率
	public String getRecentAccuracyStabilityN(Sys_User usr);//获取最近n次历史准确率稳定性
	//----做练习中，获取习题----//
	//public List<QuestionBank> getRandomExercise(int n);//随机n题
	//----做完练习，传回数值----//
	public int judgeAnswer(QuestionBank question,String answer);//系统判断一道题对错
	public float calAccuracyRate(int resultRight, int resultBlank, int resultWrong);//计算本次练习准确率
	public float calAccuracyStability(Sys_User usr, float accuracyRate);//计算本次练习准确率稳定性
	public boolean updateTable(Sys_User usr, List<ExerciseJudgeAnswerPo> list, String exerciseName);//更新错题集表和在线练习表

	///////////////////////////////////////////////////////////////
	public List<Book> getAllBooks();
	public List<BookChapter> getBookChaptersByBookID(long bookID);
	public List<QuestionBank> getQuestionsByChpaterIdAndType(int num,String bookID,String chapterIDs);
}
