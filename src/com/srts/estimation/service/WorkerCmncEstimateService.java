package com.srts.estimation.service;

import java.util.List;

import com.srts.estimation.po.UserCmncEstimatePo;
import com.srts.system.domain.Sys_User;

public interface WorkerCmncEstimateService {
	public String selectWorkerProCmncAmountToWeek(Sys_User usr);
	public String selectWorkerProCmncAmountToMonth(Sys_User usr);
	public String selectWorkerProCmncAmount(Sys_User usr);
	public String selectWorkerProCmncAcp(Sys_User usr);
	public String selectWorkerAcpRatePerMonth(Sys_User usr);
	public String selectWorkerStuCmncAmountToWeek(Sys_User usr);
	public String selectWorkerStuCmncAmountToMonth(Sys_User usr);
	public String selectWorkerStuCmncAmount(Sys_User usr);
	public List<UserCmncEstimatePo> setWorkerCmncEstimateInfo(Sys_User usr);

}
