package com.srts.estimation.dao;

import java.text.ParseException;
import java.util.List;

import com.srts.system.domain.Sys_User;

public interface WorkerWholeEstimateDao {
	public List<String[]> getAveStudySumTimeToNow(Sys_User usr) throws ParseException;
	public List<String[]> getExerciseAccuracyRateToNow(Sys_User usr);
	public List<String[]> getExerciseAmountToNow(Sys_User usr);
	public List<String[]> selectWorkerProCmncAmount(Sys_User usr);
	public List<String[]> selectWorkerProCmncAcp(Sys_User usr);
	public List<String[]> selectWorkerStuCmncAmount(Sys_User usr);
	public List<String[]> workerKlgSearchEst(Sys_User usr);//搜索总量分类统计
	public List<String[]> workerOpExpUpload(Sys_User usr);
	public List<String[]> findUserTestScoreByUserAndType(Sys_User usr,String type);
	public List<String[]> findUserTestScoreStability(Sys_User usr,String type);

}
