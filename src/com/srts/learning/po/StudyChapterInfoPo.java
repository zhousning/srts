package com.srts.learning.po;

/**
 * 自主学习po scc.chapterId,bc.chapterNum,bc.chapterName,scc.status,msc.sumTime,msc.startTime,msc.endTime,bk.id bookId
 * @author wyw
 *
 */
public class StudyChapterInfoPo {
	private long chapterId;
	private String chapterNum;
	private String chapterName;
	private String status;
	private String startTime;
	private String endTime;
	private String sumTime;
	private String lastStudyTime;
	private long bookId;
	private int schedule;
	public StudyChapterInfoPo(){}
	public StudyChapterInfoPo(long chapterId, String chapterNum,
			String chapterName, String status, String startTime,
			String endTime, String sumTime, String lastStudyTime, long bookId,int schedule) {
		this.chapterId = chapterId;
		this.chapterNum = chapterNum;
		this.chapterName = chapterName;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.sumTime = sumTime;
		this.lastStudyTime = lastStudyTime;
		this.bookId = bookId;
		this.schedule = schedule;
	}
	public String getChapterNum() {
		return chapterNum;
	}
	public void setChapterNum(String chapterNum) {
		this.chapterNum = chapterNum;
	}
	public long getChapterId() {
		return chapterId;
	}
	public void setChapterId(long chapterId) {
		this.chapterId = chapterId;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
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
	public String getLastStudyTime() {
		return lastStudyTime;
	}
	public void setLastStudyTime(String lastStudyTime) {
		this.lastStudyTime = lastStudyTime;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public int getSchedule() {
		return schedule;
	}
	public void setSchedule(int schedule) {
		this.schedule = schedule;
	}
	
}
