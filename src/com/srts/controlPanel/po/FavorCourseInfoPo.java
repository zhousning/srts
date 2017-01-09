package com.srts.controlPanel.po;

public class FavorCourseInfoPo {
	private String id;
	private String bookName;
	private String viewCount;
	public FavorCourseInfoPo(){}
	public FavorCourseInfoPo(String id, String bookName, String viewCount) {
		this.id=id;
		this.bookName = bookName;
		this.viewCount = viewCount;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
