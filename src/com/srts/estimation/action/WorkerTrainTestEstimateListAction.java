package com.srts.estimation.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.srts.estimation.po.UserEstimatePo;
import com.srts.estimation.po.UserExeAcurInfoPo;
import com.srts.estimation.po.UserExeEstimatePo;
import com.srts.estimation.po.UserExeFeqInfoPo;
import com.srts.estimation.po.UserInfoPo;
import com.srts.estimation.po.UserTestEstimateInfoPo;
import com.srts.estimation.service.WorkerOnlineExerciseEstService;
import com.srts.estimation.service.WorkerOnlineStudyEstService;
import com.srts.estimation.service.WorkerTestEstimateService;
import com.srts.estimation.service.WorkerTrainTestEstimateService;
import com.srts.system.domain.Sys_User;

@Controller
public class WorkerTrainTestEstimateListAction {
	
	@Resource
	private WorkerOnlineExerciseEstService workerOnlineExerciseEstService;
	@Resource
	private WorkerOnlineStudyEstService workerOnlineStudyEstService;
	@Resource
	private WorkerTrainTestEstimateService workerTrainTestEstimateService;
	
	private String categoryUserTrainTestScore;
	private String userTrainTestScoreByUserAndType;
	private String userTrainTestScoreRankByUserAndType;
	private String userTrainTestScoreStablilityByUserAndType;
	private List<UserTestEstimateInfoPo> userTrainTestEstimateInfo;
	public String WorkerEstimateList()
	{
		Sys_User usr = new Sys_User();
		usr.setId(1);
		userTrainTestEstimateInfo = workerTrainTestEstimateService.setUserTestEstimateInfo(usr);
		return "WorkerEstimateList";
		
	}
	public String WorkerEstimateAnalysis()
	{
		Sys_User usr = new Sys_User();
		usr.setId(1);
		categoryUserTrainTestScore= workerTrainTestEstimateService.dispCategoryUserTestScore(usr);
		userTrainTestScoreByUserAndType = workerTrainTestEstimateService.findUserTestScoreByUserAndType(usr);
		userTrainTestScoreRankByUserAndType = workerTrainTestEstimateService.findUserTestScoreRankByUserAndType(usr);
		userTrainTestScoreStablilityByUserAndType = workerTrainTestEstimateService.findUserTestScoreStablilityByUserAndType(usr);
		return "WorkerEstimateAnalysis";
		
	}
	public String getCategoryUserTrainTestScore() {
		return categoryUserTrainTestScore;
	}
	public void setCategoryUserTrainTestScore(String categoryUserTrainTestScore) {
		this.categoryUserTrainTestScore = categoryUserTrainTestScore;
	}
	public String getUserTrainTestScoreByUserAndType() {
		return userTrainTestScoreByUserAndType;
	}
	public void setUserTrainTestScoreByUserAndType(
			String userTrainTestScoreByUserAndType) {
		this.userTrainTestScoreByUserAndType = userTrainTestScoreByUserAndType;
	}
	public String getUserTrainTestScoreRankByUserAndType() {
		return userTrainTestScoreRankByUserAndType;
	}
	public void setUserTrainTestScoreRankByUserAndType(
			String userTrainTestScoreRankByUserAndType) {
		this.userTrainTestScoreRankByUserAndType = userTrainTestScoreRankByUserAndType;
	}
	public String getUserTrainTestScoreStablilityByUserAndType() {
		return userTrainTestScoreStablilityByUserAndType;
	}
	public void setUserTrainTestScoreStablilityByUserAndType(
			String userTrainTestScoreStablilityByUserAndType) {
		this.userTrainTestScoreStablilityByUserAndType = userTrainTestScoreStablilityByUserAndType;
	}
	public List<UserTestEstimateInfoPo> getUserTrainTestEstimateInfo() {
		return userTrainTestEstimateInfo;
	}
	public void setUserTrainTestEstimateInfo(
			List<UserTestEstimateInfoPo> userTrainTestEstimateInfo) {
		this.userTrainTestEstimateInfo = userTrainTestEstimateInfo;
	}
	
	
}
