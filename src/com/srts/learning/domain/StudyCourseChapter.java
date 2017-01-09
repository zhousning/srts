package com.srts.learning.domain;

public class StudyCourseChapter {
	private static final long serialVersionUID = 1L;
	private long id;//主键id
	private long bookId;//书id
	private String bookName;//书名称
	private long chapterId;//章节id
	private String status;//学习课程状态
	private MyStudyCourse myStudyCourse;//我的学习课程
	public StudyCourseChapter(){}
	public StudyCourseChapter(long id, long bookId, String bookName,
			long chapterId, String status, MyStudyCourse myStudyCourse) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.bookName = bookName;
		this.chapterId = chapterId;
		this.status = status;
		this.myStudyCourse = myStudyCourse;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getChapterId() {
		return chapterId;
	}
	public void setChapterId(long chapterId) {
		this.chapterId = chapterId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public MyStudyCourse getMyStudyCourse() {
		return myStudyCourse;
	}
	public void setMyStudyCourse(MyStudyCourse myStudyCourse) {
		this.myStudyCourse = myStudyCourse;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
}
