package com.srts.examination.po;

import com.srts.system.domain.Sys_User;

public class MockTestAnalysisPo {
	private String userTestScoreByUserAndType;//用户正式考试成绩折线图
	private String userTestScoreRankByUserAndType;//用户正式考试成绩排名折线图
	private String userTestScoreStablilityByUserAndType;//用户正式考试成绩排名稳定性折线图
	private String categoryUserTestScore;//成绩分类饼图
	public MockTestAnalysisPo(){}
	public MockTestAnalysisPo(String userTestScoreByUserAndType,
			String userTestScoreRankByUserAndType,
			String userTestScoreStablilityByUserAndType,
			String categoryUserTestScore) {
		this.userTestScoreByUserAndType = userTestScoreByUserAndType;
		this.userTestScoreRankByUserAndType = userTestScoreRankByUserAndType;
		this.userTestScoreStablilityByUserAndType = userTestScoreStablilityByUserAndType;
		this.categoryUserTestScore = categoryUserTestScore;
	}
	public String getUserTestScoreByUserAndType() {
		return userTestScoreByUserAndType;
	}
	public void setUserTestScoreByUserAndType(String userTestScoreByUserAndType) {
		this.userTestScoreByUserAndType = userTestScoreByUserAndType;
	}
	public String getUserTestScoreRankByUserAndType() {
		return userTestScoreRankByUserAndType;
	}
	public void setUserTestScoreRankByUserAndType(
			String userTestScoreRankByUserAndType) {
		this.userTestScoreRankByUserAndType = userTestScoreRankByUserAndType;
	}
	public String getUserTestScoreStablilityByUserAndType() {
		return userTestScoreStablilityByUserAndType;
	}
	public void setUserTestScoreStablilityByUserAndType(
			String userTestScoreStablilityByUserAndType) {
		this.userTestScoreStablilityByUserAndType = userTestScoreStablilityByUserAndType;
	}
	public String getCategoryUserTestScore() {
		return categoryUserTestScore;
	}
	public void setCategoryUserTestScore(String categoryUserTestScore) {
		this.categoryUserTestScore = categoryUserTestScore;
	}
    
}
