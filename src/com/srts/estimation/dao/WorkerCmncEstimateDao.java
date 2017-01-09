package com.srts.estimation.dao;

import java.util.List;

import com.srts.system.domain.Sys_User;

public interface WorkerCmncEstimateDao {
	public List<String[]> selectWorkerProCmncAmountToWeek(Sys_User usr);
	public List<String[]> selectWorkerProCmncAmountToMonth(Sys_User usr);
	public List<String[]> selectWorkerProCmncAmount(Sys_User usr);
	public List<String[]> selectWorkerProCmncAcp(Sys_User usr);
	public List<String[]> selectWorkerAcpRatePerMonth(Sys_User usr);
	public List<String[]> selectWorkerStuCmncAmountToWeek(Sys_User usr);
	public List<String[]> selectWorkerStuCmncAmountToMonth(Sys_User usr);
	public List<String[]> selectWorkerStuCmncAmount(Sys_User usr);

}
