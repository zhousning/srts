package com.srts.estimation.dao;

import java.util.List;

import com.srts.system.domain.Sys_User;

public interface WorkerKlgBankEstimateDao {
	public List<String[]> workerKlgSearchEst(Sys_User usr);//搜索总量分类统计
	public List<String[]> workerKlgSearchEstToday(Sys_User usr);//本日搜索总量分类统计
	public List<String[]> workerKlgSearchEstToWeek(Sys_User usr);//本周搜索总量分类统计
	public List<String[]> workerKlgSearchEstToMonth(Sys_User usr);//本月搜索总量分类统计
	public List<String[]> workerOpExpUploadToday(Sys_User usr);//本日上传操作经验（已通过未通过）
	public List<String[]> workerOpExpUploadToWeek(Sys_User usr);//本周上传操作经验（已通过未通过）
	public List<String[]> workerOpExpUploadToMonth(Sys_User usr);//本月上传操作经验（已通过未通过）
	public List<String[]> findWorkerKlgSearchRecord(Sys_User usr,String startDate,String endDate,String type);//按起止日期搜索检索记录

}
