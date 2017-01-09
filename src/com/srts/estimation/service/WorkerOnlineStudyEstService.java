package com.srts.estimation.service;

import java.util.List;

import com.srts.estimation.po.UserEstimatePo;
import com.srts.estimation.po.UserInfoPo;
import com.srts.system.domain.Sys_User;

public interface WorkerOnlineStudyEstService {
	public List<UserInfoPo> setMyStudyTimeLengthInfoCurrentDay(Sys_User usr);
	public List<UserInfoPo> setMyStudyTimeLengthInfoCurrentWeek(Sys_User usr);
	public List<UserInfoPo> setMyStudyTimeLengthInfoCurrentMonth(Sys_User usr);
	public String getTimeLengthString(Sys_User usr);
	public List<UserEstimatePo> setUserEstimateInfoCurrentDay(Sys_User usr);
	public List<UserEstimatePo> setUserEstimateInfoCurrentWeek(Sys_User usr);
	public List<UserEstimatePo> setUserEstimateInfoCurrentMonth(Sys_User usr);

}
