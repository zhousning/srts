package com.srts.learning.domain;

public class TrainCourseChapter {
	private static final long serialVersionUID = 1L;
	private long id;//主键id
	private long chapterId;//学习章节
	private long bookId;//书id
	private String bookName;//书名
	private String chapterNum;
	public String getChapterNum() {
		return chapterNum;
	}


	public void setChapterNum(String chapterNum) {
		this.chapterNum = chapterNum;
	}


	private TrainCourse trainCourse;//对应哪次培训课程
	
	public TrainCourseChapter(){}
	
	
	public TrainCourseChapter(long id, long chapterId, long bookId,
			String bookName, TrainCourse trainCourse) {
		this.id = id;
		this.chapterId = chapterId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.trainCourse = trainCourse;
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
	public TrainCourse getTrainCourse() {
		return trainCourse;
	}
	public void setTrainCourse(TrainCourse trainCourse) {
		this.trainCourse = trainCourse;
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
