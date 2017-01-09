package com.srts.learning.domain;

import com.srts.knowledge.domain.BookChapterContent;

public class ChapterContentStatus {
	private static final long serialVersionUID = 1L;
	private long id;//主键id
	private MyTrainCourse myTrainCourse;//我的课程
	private BookChapterContent content;//小节内容
	private String status;//状态
	private String date;//日期
	public ChapterContentStatus(){}
	public ChapterContentStatus(long id, MyTrainCourse myTrainCourse,
			BookChapterContent content, String status, String date) {
		this.id = id;
		this.myTrainCourse = myTrainCourse;
		this.content = content;
		this.status = status;
		this.date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public MyTrainCourse getMyTrainCourse() {
		return myTrainCourse;
	}
	public void setMyTrainCourse(MyTrainCourse myTrainCourse) {
		this.myTrainCourse = myTrainCourse;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BookChapterContent getContent() {
		return content;
	}
	public void setContent(BookChapterContent content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
