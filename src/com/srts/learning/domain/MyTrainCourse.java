package com.srts.learning.domain;

import java.util.HashSet;
import java.util.Set;

import com.srts.system.domain.Sys_User;

public class MyTrainCourse {
	private static final long serialVersionUID = 1L;
	private long id;//主键id
	private Sys_User user;//员工
	private TrainCourse trainCourse;//培训课程
	private Set<ChapterContentStatus>contentStatus=new HashSet<ChapterContentStatus>();//小节学习状态，用于统计学习进度
	private String status;//该课程状态
	private String startTime;//开始时间
	private String endTime;//结束时间
	private String sumTime;//时长
	private String sumRead;//阅读次数
	private String lastStudyDate;//最近一次学习时间
	private String schedule;
	
	public MyTrainCourse(){}
	public MyTrainCourse(long id, Sys_User user, TrainCourse trainCourse,
			Set<ChapterContentStatus> contentStatus, String status,
			String startTime, String endTime, String sumTime, String sumRead,
			String lastStudyDate) {
		super();
		this.id = id;
		this.user = user;
		this.trainCourse = trainCourse;
		this.contentStatus = contentStatus;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.sumTime = sumTime;
		this.sumRead = sumRead;
		this.lastStudyDate = lastStudyDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Sys_User getUser() {
		return user;
	}
	public void setUser(Sys_User user) {
		this.user = user;
	}
	public TrainCourse getTrainCourse() {
		return trainCourse;
	}
	public void setTrainCourse(TrainCourse trainCourse) {
		this.trainCourse = trainCourse;
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
	public String getLastStudyDate() {
		return lastStudyDate;
	}
	public void setLastStudyDate(String lastStudyDate) {
		this.lastStudyDate = lastStudyDate;
	}
	public Set<ChapterContentStatus> getContentStatus() {
		return contentStatus;
	}
	public void setContentStatus(Set<ChapterContentStatus> contentStatus) {
		this.contentStatus = contentStatus;
	}
	public String getSumRead() {
		return sumRead;
	}
	public void setSumRead(String sumRead) {
		this.sumRead = sumRead;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
}
