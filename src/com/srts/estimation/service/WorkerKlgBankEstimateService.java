package com.srts.estimation.service;

import java.util.List;

import com.srts.estimation.po.UserKlgBankSearchEstPo;
import com.srts.estimation.po.UserKlgBankSearchRecordPo;
import com.srts.system.domain.Sys_User;

public interface WorkerKlgBankEstimateService {
	public String workerKlgSearchEst(Sys_User usr);//搜索总量分类统计
	public String workerKlgSearchEstToday(Sys_User usr);//本日搜索总量分类统计
	public String workerKlgSearchEstToWeek(Sys_User usr);//本周搜索总量分类统计
	public String workerKlgSearchEstToMonth(Sys_User usr);//本月搜索总量分类统计
	public String workerOpExpUploadToday(Sys_User usr);//本日上传操作经验（已通过未通过）
	public String workerOpExpUploadToWeek(Sys_User usr);//本周上传操作经验（已通过未通过）
	public String workerOpExpUploadToMonth(Sys_User usr);//本月上传操作经验（已通过未通过）
	public List<UserKlgBankSearchRecordPo> findWorkerKlgSearchRecord(Sys_User usr,String startDate,String endDate,String type);//按起止日期搜索检索记录
	public List<UserKlgBankSearchEstPo> setUserKlgBankEstimateInfoPo(Sys_User usr);//设置评价

}
