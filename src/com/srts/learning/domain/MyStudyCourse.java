package com.srts.learning.domain;

import java.util.Set;

import com.srts.knowledge.domain.Book;
import com.srts.system.domain.Sys_User;

public class MyStudyCourse {
	private static final long serialVersionUID = 1L;
	private long id;//主键id
	private long sumTime;//学习时长
	private Sys_User usr;//员工
	private String studyRecord;//学习记录
	private String studyContent;//学习内容
	private Train train;//针对哪次培训
	
	private String startTime;//开始日期
	private String endTime;//结束日期
	private String lastStudyTime;//最近一次学习日期
	private Book book;//书号
	
	public MyStudyCourse(){}

	public MyStudyCourse(long id, long sumTime, Sys_User usr,
			String studyRecord, String studyContent, Train train,
			String startTime, String endTime, String lastStudyTime, Book book) {
		this.id = id;
		this.sumTime = sumTime;
		this.usr = usr;
		this.studyRecord = studyRecord;
		this.studyContent = studyContent;
		this.train = train;
		this.startTime = startTime;
		this.endTime = endTime;
		this.lastStudyTime = lastStudyTime;
		this.book = book;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSumTime() {
		return sumTime;
	}

	public void setSumTime(long sumTime) {
		this.sumTime = sumTime;
	}

	public Sys_User getUsr() {
		return usr;
	}

	public void setUsr(Sys_User usr) {
		this.usr = usr;
	}

	public String getStudyRecord() {
		return studyRecord;
	}

	public void setStudyRecord(String studyRecord) {
		this.studyRecord = studyRecord;
	}

	public String getStudyContent() {
		return studyContent;
	}

	public void setStudyContent(String studyContent) {
		this.studyContent = studyContent;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
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

	public String getLastStudyTime() {
		return lastStudyTime;
	}

	public void setLastStudyTime(String lastStudyTime) {
		this.lastStudyTime = lastStudyTime;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
