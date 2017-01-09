package com.srts.controlPanel.po;

public class MyCourseInfoPo {
	private String id;
	private String studyContent;
	private String studyTime;
	private String lastStudyDate;
	public MyCourseInfoPo(){}
	public MyCourseInfoPo(String id,String studyContent, String studyTime,
			String lastStudyDate) {
		this.id=id;
		this.studyContent = studyContent;
		this.studyTime = studyTime;
		this.lastStudyDate = lastStudyDate;
	}
	public String getStudyContent() {
		return studyContent;
	}
	public void setStudyContent(String studyContent) {
		this.studyContent = studyContent;
	}
	public String getStudyTime() {
		return studyTime;
	}
	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}
	public String getLastStudyDate() {
		return lastStudyDate;
	}
	public void setLastStudyDate(String lastStudyDate) {
		this.lastStudyDate = lastStudyDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
