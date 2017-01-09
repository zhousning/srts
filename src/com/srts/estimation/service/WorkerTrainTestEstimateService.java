package com.srts.estimation.service;

import java.util.List;

import com.srts.estimation.po.UserTestEstimateInfoPo;
import com.srts.system.domain.Sys_User;

public interface WorkerTrainTestEstimateService {
	public String findUserTestScoreByUserAndType(Sys_User usr);//用户正式考试成绩折线图
	public String findUserTestScoreRankByUserAndType(Sys_User usr);//用户正式考试成绩排名折线图
	public String findUserTestScoreStablilityByUserAndType(Sys_User usr);//用户正式考试成绩排名稳定性折线图
	public String dispCategoryUserTestScore(Sys_User usr);//成绩分类饼图
	public List<UserTestEstimateInfoPo> setUserTestEstimateInfo(Sys_User usr);

}
