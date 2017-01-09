package com.srts.information.dao;


import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.information.domain.TrainNotice;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;

public interface TrainNoticeDao extends BaseDao<TrainNotice> {

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
	List<Book> findAllBook(int currentPageNum);
	List<TrainNotice> findAllNotice(int currentPageNum);
	
	public int addTrain(long trainNoticeId);
	
	
	public List queryForPage(String hql, int offset,int length);
	public int getAllRowCount(String hql);
}
