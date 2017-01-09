package com.srts.learning.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;

public interface OnlineCourseDao extends BaseDao<Book>{
	public List<OnlineCoursePPT> getAllOnlineCoursePPT();
	public List<OnlineCourseVideo> getAllOnlineCourseVideo();
	public List<BookChapter> getBookChapters(long bookID);
	public OnlineCoursePPT getPptByPptId(long pptID);
	public OnlineCourseVideo getVideoByID( long videoID);
	public List<BookChapterContent> getChapterContentsByChapterID(long chapterID);
	public List<OnlineCourseVideo> getTop6Video();
	public Integer getBookChapterCountById(long bookId);
	public Integer getStudyBookChapterCountById(long bookId,long userId);
	public List<?> getBookChapterStatusByFinishOrUndone(long userId,long bookId,String status);
	public List<?> getBookChapterStatusNotByFinishOrUndone(long userId,long bookId);
	public int insertIntoMyStudyCourse(long sumTime, Sys_User usr,
			String studyRecord, String studyContent, long trainId,
			String startTime, String endTime, String lastStudyTime, long bookId);
	public int updateBookViewCount(long bookID);
	public int updateVideoViewCount(long videoID);
	public long selectTrainIdByNoticeId(long noticeId);
}
