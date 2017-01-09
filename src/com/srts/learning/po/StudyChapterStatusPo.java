package com.srts.learning.po;

public class StudyChapterStatusPo {
	private long chapterID;
	private String chapterNum;
	private String chapterName;
	private String chapterStatus;
	public StudyChapterStatusPo(){}
	public StudyChapterStatusPo(long chapterID, String chapterNum,
			String chapterName, String chapterStatus) {
		super();
		this.chapterID = chapterID;
		this.chapterNum = chapterNum;
		this.chapterName = chapterName;
		this.chapterStatus = chapterStatus;
	}
	public long getChapterID() {
		return chapterID;
	}
	public void setChapterID(long chapterID) {
		this.chapterID = chapterID;
	}
	public String getChapterNum() {
		return chapterNum;
	}
	public void setChapterNum(String chapterNum) {
		this.chapterNum = chapterNum;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public String getChapterStatus() {
		return chapterStatus;
	}
	public void setChapterStatus(String chapterStatus) {
		this.chapterStatus = chapterStatus;
	}
}
