package com.srts.learning.service;

import java.io.File;
import java.util.List;
import java.util.Set;

import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.po.OnlineCourseInfoPo;
import com.srts.system.domain.Sys_User;
import com.srts.utils.pageUtils.PageBean;

public interface OnlineCourseManageService {
	public List<?> getOnlineCourseInfoByPage(int page,String courseType);
	public Long getOnlineCourseTotalPages(String courseType);
	public String getOnlineCourseCountByType();
	public String getOnlineCourseLoadCount();
	public String getOnlineCourseviewCount();
	//public String deleteOnlineCourseByTypeAndIds(String courseType,String courseIds);
	public OnlineCourseInfoPo getOnlineCourseByTypeAndID(String courseId,String courseType);
	public String updateOnlineCourseInfoByTypeAndID(String courseType,String courseIds,String courseName,String CourseIntro);
	public String onlineCourseManageAdd(String courseName,String courseIntro,File courseImage,String courseImageFileName,File courseDoc,String courseDocFileName,String type,Sys_User user);
	public Set<BookChapter> getAllChapterFromCourseDoc(File courseDoc,String type);
	
	
	
	
	public void addBookInfo(Book bookInfo);
	public void addPptInfo(OnlineCoursePPT pptInfo);
	public void addVideoInfo(OnlineCourseVideo videoInfo);
	
	
	
	public Book getBookInfoById(Long bookId);
	public OnlineCoursePPT getPptInfoById(Long pptId);
	public OnlineCourseVideo getVideoInfoById(Long videoId);
	
	
	
	public PageBean queryForPage(String hql, int pageSize,int currentPage);
	public int getAllRowCount(String hql);
	
	
	public void deleteBook(Book book);
	public void deletePpt(OnlineCoursePPT ppt);
	public void deleteVideo(OnlineCourseVideo video);
}
