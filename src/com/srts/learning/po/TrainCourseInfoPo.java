package com.srts.learning.po;

public class TrainCourseInfoPo {
	private static final long serialVersionUID = 1L;
	private long id;// 主键id
	private long userId;// 员工
	private long trainCourseId;// 培训课程
	private String schedule;// 小节学习状态，用于统计学习进度
	private String status;// 该课程状态
	private String startTime;// 开始时间
	private String endTime;// 结束时间

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getTrainCourseId() {
		return trainCourseId;
	}

	public void setTrainCourseId(long trainCourseId) {
		this.trainCourseId = trainCourseId;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSumTime() {
		return sumTime;
	}

	public void setSumTime(String sumTime) {
		this.sumTime = sumTime;
	}

	public String getSumRead() {
		return sumRead;
	}

	public void setSumRead(String sumRead) {
		this.sumRead = sumRead;
	}

	public String getLastStudyDate() {
		return lastStudyDate;
	}

	public void setLastStudyDate(String lastStudyDate) {
		this.lastStudyDate = lastStudyDate;
	}

	private String sumTime;// 时长
	private String sumRead;// 阅读次数
	private String lastStudyDate;// 最近一次学习时间

}
