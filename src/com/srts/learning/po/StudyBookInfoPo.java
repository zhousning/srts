package com.srts.learning.po;

public class StudyBookInfoPo {
	private long bookId;
	private String bookName;
	private String bookIcon;
	private int schedule;
	private String bookChapterInfo;
	public StudyBookInfoPo(){}
	public StudyBookInfoPo(long bookId, String bookName, String bookIcon,
			int schedule, String bookChapterInfo) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookIcon = bookIcon;
		this.schedule = schedule;
		this.bookChapterInfo = bookChapterInfo;
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
	public String getBookIcon() {
		return bookIcon;
	}
	public void setBookIcon(String bookIcon) {
		this.bookIcon = bookIcon;
	}
	public int getSchedule() {
		return schedule;
	}
	public void setSchedule(int schedule) {
		this.schedule = schedule;
	}
	public String getBookChapterInfo() {
		return bookChapterInfo;
	}
	public void setBookChapterInfo(String bookChapterInfo) {
		this.bookChapterInfo = bookChapterInfo;
	}
}
