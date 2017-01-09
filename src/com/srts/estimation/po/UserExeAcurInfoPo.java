package com.srts.estimation.po;

public class UserExeAcurInfoPo {
	private String id;
	private String accuracyString;
	private String timeString;
	private String courseString;
	public UserExeAcurInfoPo(){}
	public UserExeAcurInfoPo(String id, String accuracyString,
			String timeString, String courseString) {
		this.id = id;
		this.accuracyString = accuracyString;
		this.timeString = timeString;
		this.courseString = courseString;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccuracyString() {
		return accuracyString;
	}
	public void setAccuracyString(String accuracyString) {
		this.accuracyString = accuracyString;
	}
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
	public String getCourseString() {
		return courseString;
	}
	public void setCourseString(String courseString) {
		this.courseString = courseString;
	}
	

}
