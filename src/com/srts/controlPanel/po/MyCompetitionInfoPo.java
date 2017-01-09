package com.srts.controlPanel.po;

public class MyCompetitionInfoPo {
	private String id;
	private String date;
	private String grade;
	private String time;
	public MyCompetitionInfoPo(){}
	public MyCompetitionInfoPo(String id,String date, String grade, String time) {
		this.id=id;
		this.date = date;
		this.grade = grade;
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
