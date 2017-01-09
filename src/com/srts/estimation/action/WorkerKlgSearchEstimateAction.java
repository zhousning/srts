package com.srts.estimation.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.srts.estimation.po.UserKlgBankSearchEstPo;
import com.srts.estimation.po.UserKlgBankSearchRecordPo;
import com.srts.estimation.service.WorkerKlgBankEstimateService;
import com.srts.estimation.service.WorkerOnlineExerciseEstService;
import com.srts.system.domain.Sys_User;

@Controller
public class WorkerKlgSearchEstimateAction {
	
	@Resource
	private WorkerKlgBankEstimateService workerKlgBankEstimateService;
	
	private String workerKlgSearchEst;//搜索总量分类统计
	private String workerKlgSearchEstToday;//本日搜索总量分类统计
	private String workerKlgSearchEstToWeek;//本周搜索总量分类统计
	private String workerKlgSearchEstToMonth;//本月搜索总量分类统计
	private String workerOpExpUploadToday;//本日上传操作经验（已通过未通过）
	private String workerOpExpUploadToWeek;//本周上传操作经验（已通过未通过）
	private String workerOpExpUploadToMonth;//本月上传操作经验（已通过未通过）
	private List<UserKlgBankSearchRecordPo> findWorkerKlgSearchRecord;//按起止日期搜索检索记录
	private List<UserKlgBankSearchEstPo> setUserKlgBankEstimateInfoPo;//设置评价
	private String startDate;
	private String endDate;
	private String type;
	
	public String workerKlgBankEstimateAnalysis()
	{
		Sys_User usr =new Sys_User();
		usr.setId(1);
		workerKlgSearchEst=workerKlgBankEstimateService.workerKlgSearchEst(usr);
		workerKlgSearchEstToday=workerKlgBankEstimateService.workerKlgSearchEstToday(usr);
		workerKlgSearchEstToWeek=workerKlgBankEstimateService.workerKlgSearchEstToWeek(usr);
		workerKlgSearchEstToMonth=workerKlgBankEstimateService.workerKlgSearchEstToMonth(usr);
		workerOpExpUploadToday=workerKlgBankEstimateService.workerOpExpUploadToday(usr);
		workerOpExpUploadToWeek=workerKlgBankEstimateService.workerOpExpUploadToWeek(usr);
		workerOpExpUploadToMonth=workerKlgBankEstimateService.workerOpExpUploadToMonth(usr);
		return "workerKlgBankEstimateAnalysis";
	}
	
	public String workerKlgBankEstimateList()
	{
		Sys_User usr =new Sys_User();
		usr.setId(1);
		setUserKlgBankEstimateInfoPo=workerKlgBankEstimateService.setUserKlgBankEstimateInfoPo(usr);
		return "workerKlgBankEstimateList";
	}
	
	public String workerKlgBankRecordSearch()
	{
		Sys_User usr =new Sys_User();
		usr.setId(1);
		findWorkerKlgSearchRecord=workerKlgBankEstimateService.findWorkerKlgSearchRecord(usr, startDate, endDate, type);
		return "workerKlgBankRecordSearch";
	}
	
	

	public String getWorkerKlgSearchEst() {
		return workerKlgSearchEst;
	}

	public void setWorkerKlgSearchEst(String workerKlgSearchEst) {
		this.workerKlgSearchEst = workerKlgSearchEst;
	}

	public String getWorkerKlgSearchEstToday() {
		return workerKlgSearchEstToday;
	}

	public void setWorkerKlgSearchEstToday(String workerKlgSearchEstToday) {
		this.workerKlgSearchEstToday = workerKlgSearchEstToday;
	}

	public String getWorkerKlgSearchEstToWeek() {
		return workerKlgSearchEstToWeek;
	}

	public void setWorkerKlgSearchEstToWeek(String workerKlgSearchEstToWeek) {
		this.workerKlgSearchEstToWeek = workerKlgSearchEstToWeek;
	}

	public String getWorkerKlgSearchEstToMonth() {
		return workerKlgSearchEstToMonth;
	}

	public void setWorkerKlgSearchEstToMonth(String workerKlgSearchEstToMonth) {
		this.workerKlgSearchEstToMonth = workerKlgSearchEstToMonth;
	}

	public String getWorkerOpExpUploadToday() {
		return workerOpExpUploadToday;
	}

	public void setWorkerOpExpUploadToday(String workerOpExpUploadToday) {
		this.workerOpExpUploadToday = workerOpExpUploadToday;
	}

	public String getWorkerOpExpUploadToWeek() {
		return workerOpExpUploadToWeek;
	}

	public void setWorkerOpExpUploadToWeek(String workerOpExpUploadToWeek) {
		this.workerOpExpUploadToWeek = workerOpExpUploadToWeek;
	}

	public String getWorkerOpExpUploadToMonth() {
		return workerOpExpUploadToMonth;
	}

	public void setWorkerOpExpUploadToMonth(String workerOpExpUploadToMonth) {
		this.workerOpExpUploadToMonth = workerOpExpUploadToMonth;
	}

	public List<UserKlgBankSearchRecordPo> getFindWorkerKlgSearchRecord() {
		return findWorkerKlgSearchRecord;
	}

	public void setFindWorkerKlgSearchRecord(
			List<UserKlgBankSearchRecordPo> findWorkerKlgSearchRecord) {
		this.findWorkerKlgSearchRecord = findWorkerKlgSearchRecord;
	}

	public List<UserKlgBankSearchEstPo> getSetUserKlgBankEstimateInfoPo() {
		return setUserKlgBankEstimateInfoPo;
	}

	public void setSetUserKlgBankEstimateInfoPo(
			List<UserKlgBankSearchEstPo> setUserKlgBankEstimateInfoPo) {
		this.setUserKlgBankEstimateInfoPo = setUserKlgBankEstimateInfoPo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	
	
}
