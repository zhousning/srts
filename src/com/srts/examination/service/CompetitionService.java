package com.srts.examination.service;

import java.util.List;

import com.srts.examination.domain.Competition;
import com.srts.examination.domain.QuestionBank;
import com.srts.system.domain.Sys_User;

public interface CompetitionService {
	public String dispCompetitionGradeByUser(Sys_User usr);//用户竞赛历史成绩的折线图数据
	public List<String[]> findCompetitionRankRightNow(String CurrentTime);//当月的闯关前10名显示(名次,用户名和成绩)
	public List<String[]> findHistoricalCompetitionRank();//历史闯关前10名显示(名次,用户名和成绩)
	public QuestionBank findQuestionRandomly();//闯关随机选题
	public QuestionBank findQuestionById(String id);//闯关随机选题
	public int judgeTheAnswer(QuestionBank question,String answer);//判断答案是否正确
	public String findCompetitionRankRightNowByUser(Sys_User usr,String CurrentTime);//用户本月闯关的排名
	public String findHistoricalCompetitionRankByUser(Sys_User usr);//用户历史闯关最好排名
	public String findCompetitionLastGradeByUser(Sys_User usr);//用户上次闯关成绩
	public String findCompetitionMaxGradeByUser(Sys_User usr);//用户历史最佳闯关成绩
	public int insertCompetitionError(String errorAnswer,String errorDate,Sys_User usr,QuestionBank errorQuestion);//闯关错题插入
	public int insertCompetition(int grade,String comp_date,int comp_time,Sys_User usr);//闯关成绩插入
	public List<String[]> findRecentFiveCompetitionError(Sys_User usr);//显示最近闯关错的5题
}
