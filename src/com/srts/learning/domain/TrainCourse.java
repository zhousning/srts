package com.srts.learning.domain;

import java.util.HashSet;
import java.util.Set;

public class TrainCourse {
	private static final long serialVersionUID = 1L;
	private long id;//主键id
	private String startDate;//培训课程开始日期
	private String endDate;//培训课程结束日期
	private Train train;//对应哪次培训
	private Set<TrainCourseChapter> chapters=new HashSet<TrainCourseChapter>();//要学习的章节
	public TrainCourse(){}
	public TrainCourse(long id, String startDate, String endDate, Train train,
			Set<TrainCourseChapter> chapters) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.train = train;
		this.chapters = chapters;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public Set<TrainCourseChapter> getChapters() {
		return chapters;
	}
	public void setChapters(Set<TrainCourseChapter> chapters) {
		this.chapters = chapters;
	}
}
