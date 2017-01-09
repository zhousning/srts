package com.srts.examination.service;

import java.util.List;
import java.util.Map;

import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.TestPaper;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;

public interface TrainTestService {
	public String findUserTestScoreByUserAndType(Sys_User usr);//用户正式考试成绩折线图
	public String findUserTestScoreRankByUserAndType(Sys_User usr);//用户正式考试成绩排名折线图
	public String findUserTestScoreStablilityByUserAndType(Sys_User usr);//用户正式考试成绩排名稳定性折线图
	public String dispCategoryUserTestScore(Sys_User usr);//成绩分类饼图
	public List<QuestionBank> findTestPaperQuestion(Train train,String major,String type);//通过考试信息查询试卷题目
	public int insertAnswerSheet(Sys_User usr, TestPaper testPaper,String answerContent);//插入答卷
	public List<Long> findTestPaperIdByUser(Sys_User usr);//查询用户做过的试卷id
	public List<String[]> compareUserAnswerAndTestPaperAnswer(Sys_User usr,long testPaperId);//用户答卷和标准答案比较
	public List<String> findUserAndTestInfo(Sys_User usr, long id);//查询List显示用信息
	public Map<String, Object[]> getTestPaperMap(String questionIds, long testPaperId);
	public void insertAnswer(long userId, long testPaperId,
			String questionAnswer);
}
