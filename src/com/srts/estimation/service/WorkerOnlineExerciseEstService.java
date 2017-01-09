package com.srts.estimation.service;

import java.util.List;

import com.srts.estimation.po.UserExeAcurInfoPo;
import com.srts.estimation.po.UserExeEstimatePo;
import com.srts.estimation.po.UserExeFeqInfoPo;
import com.srts.system.domain.Sys_User;

public interface WorkerOnlineExerciseEstService {
	public List<UserExeAcurInfoPo> setUserExerciseTodayAccuracyInfo(Sys_User usr);
	public List<UserExeAcurInfoPo> setUserExerciseToWeekAccuracyInfo(Sys_User usr);
	public List<UserExeAcurInfoPo> setUserExerciseToMonthAccuracyInfo(Sys_User usr);
	public List<UserExeFeqInfoPo> setUserExerciseFrequencyInfo(Sys_User usr);
	public List<UserExeEstimatePo> setUserExerciseEstimateInfoToday(Sys_User usr);
	public List<UserExeEstimatePo> setUserExerciseEstimateInfoToWeek(Sys_User usr);
	public List<UserExeEstimatePo> setUserExerciseEstimateInfoToMonth(Sys_User usr);
	public String setAccuracyString(Sys_User usr);
	public String setFeqString(Sys_User usr);

}
