package com.srts.estimation.dao;

import java.util.List;

import com.srts.system.domain.Sys_User;

public interface WorkerOnlineStudyEstDao {
	public List selectWorkerStudyInfoByUser(Sys_User usr);
	public List selectWorkerStudyInfoByCourse(long bookID);
	public List selectCourse();
	public List selectPeople();
	public List selectAllWorkerStudyInfo();
	public List<String[]> getUserStudySumTimeByCurrentDay(Sys_User usr);
	public List<String[]> getUserStudySumTimeByCurrentWeek(Sys_User usr);
	public List<String[]> getUserStudySumTimeByCurrentMonth(Sys_User usr);
	public List<String[]> getAveStudyTimeTodayByCourse();
	public List<String[]> getAveStudyTimeToWeekByCourse();
	public List<String[]> getAveStudyTimeToMonthByCourse();
	public List<String[]> getUserStudySumTimeToNowPerMonth(Sys_User usr);
	public List<String[]> getAveStudySumTimeToNowPerMonth();

}
