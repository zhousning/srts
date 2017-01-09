package com.srts.learning.po;

public class StudyCoursePo {
	private String studyCourseSchedule;
	private String studyCourseSumTime;
	private String studyCourseNumCount;
	
	public StudyCoursePo(){}
	
	public StudyCoursePo(String studyCourseSchedule, String studyCourseSumTime,
			String studyCourseNumCount) {
		this.studyCourseSchedule = studyCourseSchedule;
		this.studyCourseSumTime = studyCourseSumTime;
		this.studyCourseNumCount = studyCourseNumCount;
	}
	public String getStudyCourseSchedule() {
		return studyCourseSchedule;
	}
	public void setStudyCourseSchedule(String studyCourseSchedule) {
		this.studyCourseSchedule = studyCourseSchedule;
	}
	public String getStudyCourseSumTime() {
		return studyCourseSumTime;
	}
	public void setStudyCourseSumTime(String studyCourseSumTime) {
		this.studyCourseSumTime = studyCourseSumTime;
	}
	public String getStudyCourseNumCount() {
		return studyCourseNumCount;
	}
	public void setStudyCourseNumCount(String studyCourseNumCount) {
		this.studyCourseNumCount = studyCourseNumCount;
	}
	
}
