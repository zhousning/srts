package com.srts.estimation.dao;

import java.util.List;

import com.srts.system.domain.Sys_User;

public interface WorkerOnlineExerciseEstDao {
	public List<String[]> selectAccuracyRateByUserToday(Sys_User usr);
	public List<String[]> selectAccuracyRateByUserToWeek(Sys_User usr);
	public List<String[]> selectAccuracyRateByUserToMonth(Sys_User usr);
	public List<String[]> selectExerciseFeqByUserToday(Sys_User usr);
	public List<String[]> selectExerciseFeqByUserToWeek(Sys_User usr);
	public List<String[]> selectExerciseFeqByUserToMonth(Sys_User usr);
	public List<String[]> selectExerciseContentByUserAndTimeArea(Sys_User usr,String TimeArea);
	public List<String[]> selectAccuracyRateByUserPerMonth(Sys_User usr);
	public List<String[]> selectExerciseFeqByUserPerMonth(Sys_User usr);

}
