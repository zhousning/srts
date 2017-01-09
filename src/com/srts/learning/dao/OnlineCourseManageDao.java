package com.srts.learning.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;

public interface OnlineCourseManageDao extends BaseDao<Book>{
	public List<Book> getOnlineCourseBookInfo(int min,int max);
	public List<OnlineCoursePPT> getOnlineCoursePPTInfo(int min,int max);
	public List<OnlineCourseVideo> getOnlineCourseVideoInfo(int min,int max);
	
	public Long getBookCount();
	public Long getPptCount();
	public Long getVideoCount();
	
	public Long getPptLoadCount();
	public Long getVideoLoadCount();
	public Long getBookLoadCount();
	
	public Long getPptViewCount();
	public Long getVideoViewCount();
	public Long getBookViewCount();
	
	public void deleteBook(Book book);
	public void deletePpt(OnlineCoursePPT ppt);
	public void deleteVideo(OnlineCourseVideo video);
	
	public Book getBookInfoById(Long bookId);
	public OnlineCoursePPT getPptInfoById(Long pptId);
	public OnlineCourseVideo getVideoInfoById(Long videoId);
	
	public boolean updateBookInfoById(Long bookId,Book book);
	public boolean updatePptInfoById(Long pptId,OnlineCoursePPT ppt);
	public boolean updateVideoInfoById(Long videoId,OnlineCourseVideo video);
	
	public void addBookInfo(Book bookInfo);
	public void addPptInfo(OnlineCoursePPT pptInfo);
	public void addVideoInfo(OnlineCourseVideo videoInfo);
	
	
	
	public List queryForPage(String hql, int offset,int length);
	public int getAllRowCount(String hql);
}
