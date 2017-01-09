package com.srts.examination.dao;

import java.util.List;

import com.srts.examination.domain.Competition;
import com.srts.examination.domain.QuestionBank;
import com.srts.system.domain.Sys_User;

public interface CompetitionDao {
	public int findCompetitionMaxGradeByUser(Sys_User usr);
	public int findCompetitionLastGradeByUser(Sys_User usr);
	public List<Competition> findCompetitionGradeByUser(Sys_User usr);
	public List<Competition> findCompetitionRankRightNow(String CurrentTime);
	public int findCompetitionRankRightNowByUser(Sys_User usr,String CurrentTime);
	public List<Competition> findHistoricalCompetitionRank();
	public int findHistoricalCompetitionRankByUser(Sys_User usr);
	public QuestionBank findQuestionById(long id);
	public int insertCompetitionError(String errorAnswer,String errorDate,Sys_User usr,QuestionBank errorQuestion);
	public int insertCompetition(int grade,String comp_date,int comp_time,Sys_User usr);
	public List findRecentFiveCompetitionError(Sys_User usr);
	public int deleteCompetitionErrorByQuestionId(long questionId);

}
