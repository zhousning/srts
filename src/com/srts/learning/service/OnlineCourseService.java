package com.srts.learning.service;

import java.util.List;

import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.po.StudyChapterStatusPo;
import com.srts.system.domain.Sys_User;

public interface OnlineCourseService {
	public List<Book> getAllBooks();
	public List<OnlineCourseVideo>getAllVideos();
	public List<OnlineCoursePPT>getAllPPTs();
	public List<BookChapter> getBookChapterByID(long bookID);
	public OnlineCoursePPT getPptByPptId(long pptID);
	public OnlineCourseVideo getVideoByID(long videoID);
	public List<BookChapterContent> getChapterContentsByChapterID(long chapterID);
	public List<OnlineCourseVideo> getRecommendVideo();
	public List<StudyChapterStatusPo> getBookChapterSchedule(long userID, long bookID);
	public String insertIntoMyStudyCourse(long sumTime, Sys_User usr,
			 long trainId, long bookId);
	public int updateBookViewCount(long bookID);
	public int updateVideoViewCount(long videoID);
	public long selectTrainIdByNoticeId(long noticeId);
}
