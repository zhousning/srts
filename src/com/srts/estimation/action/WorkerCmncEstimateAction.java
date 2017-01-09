package com.srts.estimation.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.srts.estimation.po.UserCmncEstimatePo;
import com.srts.estimation.service.WorkerCmncEstimateService;
import com.srts.system.domain.Sys_User;

@Controller
public class WorkerCmncEstimateAction {
	
	@Resource
	private WorkerCmncEstimateService workerCmncEstimateService;
	
	private String selectWorkerProCmncAmountToWeek;
	private String selectWorkerProCmncAmountToMonth;
	private String selectWorkerProCmncAmount;
	private String selectWorkerProCmncAcp;
	private String selectWorkerAcpRatePerMonth;
	private String selectWorkerStuCmncAmountToWeek;
	private String selectWorkerStuCmncAmountToMonth;
	private String selectWorkerStuCmncAmount;
	private List<UserCmncEstimatePo> setWorkerCmncEstimateInfo;
	
	public String WorkerCmncEstimateAnalysis()
	{
		Sys_User usr = new Sys_User();
		usr.setId(1);
		selectWorkerProCmncAmountToWeek=workerCmncEstimateService.selectWorkerProCmncAmountToWeek(usr);
		selectWorkerProCmncAmountToMonth=workerCmncEstimateService.selectWorkerProCmncAmountToMonth(usr);
		selectWorkerProCmncAmount=workerCmncEstimateService.selectWorkerProCmncAmount(usr);
		selectWorkerProCmncAcp=workerCmncEstimateService.selectWorkerProCmncAcp(usr);
		selectWorkerAcpRatePerMonth=workerCmncEstimateService.selectWorkerAcpRatePerMonth(usr);
		selectWorkerStuCmncAmountToWeek=workerCmncEstimateService.selectWorkerStuCmncAmountToWeek(usr);
		selectWorkerStuCmncAmountToMonth=workerCmncEstimateService.selectWorkerStuCmncAmountToMonth(usr);
		selectWorkerStuCmncAmount=workerCmncEstimateService.selectWorkerStuCmncAmount(usr);
		return "WorkerCmncEstimateAnalysis";
	}
	public String WorkerCmncEstimateList()
	{
		Sys_User usr = new Sys_User();
		usr.setId(1);
		setWorkerCmncEstimateInfo=workerCmncEstimateService.setWorkerCmncEstimateInfo(usr);
		return "WorkerCmncEstimateList";
	}
	public String getSelectWorkerProCmncAmountToWeek() {
		return selectWorkerProCmncAmountToWeek;
	}
	public void setSelectWorkerProCmncAmountToWeek(
			String selectWorkerProCmncAmountToWeek) {
		this.selectWorkerProCmncAmountToWeek = selectWorkerProCmncAmountToWeek;
	}
	public String getSelectWorkerProCmncAmountToMonth() {
		return selectWorkerProCmncAmountToMonth;
	}
	public void setSelectWorkerProCmncAmountToMonth(
			String selectWorkerProCmncAmountToMonth) {
		this.selectWorkerProCmncAmountToMonth = selectWorkerProCmncAmountToMonth;
	}
	public String getSelectWorkerProCmncAmount() {
		return selectWorkerProCmncAmount;
	}
	public void setSelectWorkerProCmncAmount(String selectWorkerProCmncAmount) {
		this.selectWorkerProCmncAmount = selectWorkerProCmncAmount;
	}
	public String getSelectWorkerProCmncAcp() {
		return selectWorkerProCmncAcp;
	}
	public void setSelectWorkerProCmncAcp(String selectWorkerProCmncAcp) {
		this.selectWorkerProCmncAcp = selectWorkerProCmncAcp;
	}
	public String getSelectWorkerAcpRatePerMonth() {
		return selectWorkerAcpRatePerMonth;
	}
	public void setSelectWorkerAcpRatePerMonth(String selectWorkerAcpRatePerMonth) {
		this.selectWorkerAcpRatePerMonth = selectWorkerAcpRatePerMonth;
	}
	public String getSelectWorkerStuCmncAmountToWeek() {
		return selectWorkerStuCmncAmountToWeek;
	}
	public void setSelectWorkerStuCmncAmountToWeek(
			String selectWorkerStuCmncAmountToWeek) {
		this.selectWorkerStuCmncAmountToWeek = selectWorkerStuCmncAmountToWeek;
	}
	public String getSelectWorkerStuCmncAmountToMonth() {
		return selectWorkerStuCmncAmountToMonth;
	}
	public void setSelectWorkerStuCmncAmountToMonth(
			String selectWorkerStuCmncAmountToMonth) {
		this.selectWorkerStuCmncAmountToMonth = selectWorkerStuCmncAmountToMonth;
	}
	public String getSelectWorkerStuCmncAmount() {
		return selectWorkerStuCmncAmount;
	}
	public void setSelectWorkerStuCmncAmount(String selectWorkerStuCmncAmount) {
		this.selectWorkerStuCmncAmount = selectWorkerStuCmncAmount;
	}
	public List<UserCmncEstimatePo> getSetWorkerCmncEstimateInfo() {
		return setWorkerCmncEstimateInfo;
	}
	public void setSetWorkerCmncEstimateInfo(
			List<UserCmncEstimatePo> setWorkerCmncEstimateInfo) {
		this.setWorkerCmncEstimateInfo = setWorkerCmncEstimateInfo;
	}
	
	

}
