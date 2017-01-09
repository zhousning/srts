package com.srts.controlPanel.dao;

import java.util.List;

import com.srts.system.domain.Sys_User;

public interface PersonalInfoListDao {
	public List<String[]> selectNoticeByUser(Sys_User usr);
	public List<String[]> selectTrainTestInfoByUser(Sys_User usr);
	public List<String[]> selectMockTestInfoByUser(Sys_User usr);
	public List<String[]> selectCompetitionInfoByUser(Sys_User usr);
	public List<String[]> selectCourseInfoByUser(Sys_User usr);
	public List<String[]> selectFavorCourse();
	public List<String[]> selectExerciseInfoByUser(Sys_User usr);
	public List<String[]> selectKlgBankInfoByUser(Sys_User usr);
	public List<String[]> selectFavorKlgBank();
	public List<String[]> selectProblemInfoByUser(Sys_User usr);
	public List<String[]> selectAnswerInfoByUser(Sys_User usr);
	public List<String[]> selectThemeByUser(Sys_User usr);
	public List<String[]> selectFavorThemeByUser();
}
