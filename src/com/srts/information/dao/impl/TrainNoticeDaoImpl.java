package com.srts.information.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.information.dao.TrainNoticeDao;
import com.srts.information.domain.TrainNotice;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;

@Repository
@Transactional
public class TrainNoticeDaoImpl extends BaseDaoImpl<TrainNotice> implements TrainNoticeDao {
	
	@SuppressWarnings("unchecked")
	public List<TrainNotice> getAllInfo() {
		
		return getSession().createQuery("from TrainNotice order by id desc").list();
	}
	
	public TrainNotice getOneInfo(long id) {
		// TODO Auto-generated method stub
		return (TrainNotice) getSession().get(TrainNotice.class, id);
	}
	
	public void addOneInfo(TrainNotice trainNotice) {
		// TODO Auto-generated method stub
		getSession().save(trainNotice);
	}

	public void updateOneInfo(TrainNotice trainNotice) {
		// TODO Auto-generated method stub
		getSession().update(trainNotice);
	}

	public void deleteOneInfo(Long id) {
		// TODO Auto-generated method stub
		TrainNotice trainNotice=(TrainNotice) getSession().get(TrainNotice.class, id);
		getSession().delete(trainNotice);
	}

	public List<TrainNotice> findAllNoticeInfo(int currentPageNum) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from TrainNotice order by id desc").setFirstResult((currentPageNum - 1)*18).setMaxResults(18).list();
	}

	public List<OnlineCoursePPT> getAllPPT() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from OnlineCoursePPT order by id desc").list();
	}

	public List<OnlineCourseVideo> getAllVideo() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from OnlineCourseVideo order by id desc").list();
	}

	public List<OnlineCoursePPT> getTop5PPT() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from OnlineCoursePPT order by id desc").setFirstResult(0).setMaxResults(5).list();
	}

	public List<OnlineCourseVideo> getTop5Video() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from OnlineCourseVideo order by id desc").setFirstResult(0).setMaxResults(5).list();
	}

	public OnlineCoursePPT getPPTById(Long id) {
		// TODO Auto-generated method stub
		return (OnlineCoursePPT) getSession().get(OnlineCoursePPT.class, id);
	}

	public void updatePPT(OnlineCoursePPT ppt) {
		// TODO Auto-generated method stub
		getSession().update(ppt);
	}

	public OnlineCourseVideo getVideoById(Long id) {
		// TODO Auto-generated method stub
		return (OnlineCourseVideo) getSession().get(OnlineCourseVideo.class, id);
	}

	public void updateVideo(OnlineCourseVideo video) {
		// TODO Auto-generated method stub
		getSession().update(video);
	}

	public List<OnlineCoursePPT> findAllPPT(int currentPageNum) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from OnlineCoursePPT order by id desc").setFirstResult((currentPageNum - 1)*18).setMaxResults(18).list();
	}

	public List<OnlineCourseVideo> findAllVideo(int currentPageNum) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from OnlineCourseVideo order by id desc").setFirstResult((currentPageNum - 1)*18).setMaxResults(18).list();
	}

	public List<Book> findAllBook(int currentPageNum) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Book order by id desc").setFirstResult((currentPageNum - 1)*18).setMaxResults(18).list();
	}

	public Book getBookById(Long id) {
		// TODO Auto-generated method stub
		return (Book) getSession().get(Book.class, id);
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		getSession().update(book);
	}

	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Book order by id desc").list();
	}

	public List<Book> getTop5Book() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Book order by id desc").setFirstResult(0).setMaxResults(5).list();
	}

	public List<TrainNotice> getAllNotice() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from TrainNotice where noticeAttach!='' order by id desc").list();
	}
	public List<TrainNotice> getTop5Notice() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from TrainNotice where noticeAttach!='' order by id desc").setFirstResult(0).setMaxResults(5).list();
	}

	public List<TrainNotice> findAllNotice(int currentPageNum) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from TrainNotice where noticeAttach!='' order by id desc").setFirstResult((currentPageNum - 1)*18).setMaxResults(18).list();
	}
	
	
	
	
	public List queryForPage(String hql,int offset,int length){
		System.out.println(hql);
		System.out.println(offset);
		return getSession().createQuery(hql).setFirstResult(offset).setMaxResults(length).list();
		
		}
	
	
	public int getAllRowCount(String hql){
		return getSession().createQuery(hql).list().size();
		}

	public int addTrain(long trainNoticeId) {
		String sql = "insert into lrn_train(noticeId) values(?)";
		SQLQuery query = (SQLQuery) getSession().createSQLQuery(sql).setLong(0,trainNoticeId);
		int insertRes=query.executeUpdate();
		return insertRes;
	}
}
