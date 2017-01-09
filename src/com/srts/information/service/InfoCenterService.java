package com.srts.information.service;

import java.util.List;

import com.srts.information.domain.TrainNotice;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.utils.pageUtils.PageBean;

public interface InfoCenterService {

	List<TrainNotice> getAllInfo();
	TrainNotice getOneInfo(long id);
	
	void addOneInfo(TrainNotice trainNotice);
	void updateOneInfo(TrainNotice trainNotice);
	void deleteOneInfo(Long id);
	List<TrainNotice> findAllNoticeInfo(int currentPageNum);
	
	List<OnlineCoursePPT> getAllPPT();
	List<OnlineCourseVideo> getAllVideo();
	List<Book> getAllBook();
	List<TrainNotice> getAllNotice();
	List<OnlineCoursePPT> getTop5PPT();
	List<OnlineCourseVideo> getTop5Video();
	List<Book> getTop5Book();
	List<TrainNotice> getTop5Notice();
	OnlineCoursePPT getPPTById(Long id);
	void updatePPT(OnlineCoursePPT ppt);
	OnlineCourseVideo getVideoById(Long id);
	void updateVideo(OnlineCourseVideo video);
	List<OnlineCoursePPT> findAllPPT(int currentPageNum);
	List<OnlineCourseVideo> findAllVideo(int currentPageNum);
	
	Book getBookById(Long id);
	void updateBook(Book book);
	List<Book> findAllBook(int currentPage);
	List<TrainNotice> findAllNotice(int currentPageNum);
	
	
	
	
	public PageBean queryForPage(String hql, int pageSize,int currentPage);
	public int getAllRowCount(String hql);
}
