package com.srts.learning.po;

import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;

public class OnlineCourseInfoPo {
	private Book bookInfo;
	private OnlineCoursePPT pptInfo;
	private OnlineCourseVideo videoInfo;
	public OnlineCourseInfoPo(){};
	public OnlineCourseInfoPo(Book bookInfo, OnlineCoursePPT pptInfo,
			OnlineCourseVideo videoInfo) {
		this.bookInfo = bookInfo;
		this.pptInfo = pptInfo;
		this.videoInfo = videoInfo;
	}
	public Book getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(Book bookInfo) {
		this.bookInfo = bookInfo;
	}
	public OnlineCoursePPT getPptInfo() {
		return pptInfo;
	}
	public void setPptInfo(OnlineCoursePPT pptInfo) {
		this.pptInfo = pptInfo;
	}
	public OnlineCourseVideo getVideoInfo() {
		return videoInfo;
	}
	public void setVideoInfo(OnlineCourseVideo videoInfo) {
		this.videoInfo = videoInfo;
	}
}
