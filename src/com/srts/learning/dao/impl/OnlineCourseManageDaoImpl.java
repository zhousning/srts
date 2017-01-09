package com.srts.learning.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.dao.OnlineCourseManageDao;

/**
 * 课程管理dao
 * @author wyw 2014-07-23
 *
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class OnlineCourseManageDaoImpl extends BaseDaoImpl<Book> implements OnlineCourseManageDao{
	/**
	 * 获取要管理的book的信息
	 * @return
	 */
	public List<Book> getOnlineCourseBookInfo(int min,int max){
		String HQL = "from Book";
		return getSession().createQuery(HQL).setFirstResult(min).setMaxResults(max).list();
	}
	/**
	 * 统计数据库中book数量
	 * @return
	 */
	public Long getBookCount(){
		String HQL = "select count(id) from Book";
		return (Long)getSession().createQuery(HQL).uniqueResult();
	}
	
	/**
	 * 获取要管理课件的信息
	 * @param min
	 * @param max
	 * @return
	 */
	public List<OnlineCoursePPT> getOnlineCoursePPTInfo(int min,int max){
		String HQL = "from OnlineCoursePPT";
		return getSession().createQuery(HQL).setFirstResult(min).setMaxResults(max).list();
	}
	
	/**
	 * 统计数据库中ppt数量
	 * @return
	 */
	public Long getPptCount(){
		String HQL = "select count(id) from OnlineCoursePPT";
		return (Long)getSession().createQuery(HQL).uniqueResult();
	}
	
	/**
	 * 获取要管理视频的信息
	 * @param min
	 * @param max
	 * @return
	 */
	public List<OnlineCourseVideo> getOnlineCourseVideoInfo(int min,int max){
		String HQL = "from OnlineCourseVideo";
		return getSession().createQuery(HQL).setFirstResult(min).setMaxResults(max).list();
	}
	
	/**
	 * 统计数据库中video数量
	 * @return
	 */
	public Long getVideoCount(){
		String HQL = "select count(id) from OnlineCourseVideo";
		return (Long)getSession().createQuery(HQL).uniqueResult();
	}
	
	/**
	 * 统计ppt下载量
	 * @return
	 */
	public Long getPptLoadCount(){
		String HQL = "select sum(loadCount) from OnlineCoursePPT";
		return (Long) getSession().createQuery(HQL).uniqueResult();
	}
	
	/**
	 * 统计video下载量
	 * @return
	 */
	public Long getVideoLoadCount(){
		String HQL = "select sum(loadCount) from OnlineCourseVideo";
		return (Long) getSession().createQuery(HQL).uniqueResult();
	}
	
	
	
	/**
	 * 根据id删除课本
	 * @return
	 */
	public boolean deleteBookByIds(List<Long> ids){
		String HQL = "delete from Book where id in(:ids)";
		return (getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate())>0? true:false;
	}
	/**
	 * 根据id删除课件
	 * @return
	 */
	public boolean deletePptByIds(List<Long> ids){
		String HQL = "delete from OnlineCoursePPT where id in(:ids)";
		return (getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate())>0? true:false;
	}
	/**
	 * 根据id删除视频
	 * @return
	 */
	public boolean deleteVideoByIds(List<Long> ids){
		String HQL = "delete from OnlineCourseVideo where id in(:ids)";
		return (getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate())>0? true:false;
	}
	
	/**
	 * 根据bookid获取book
	 * @param bookId
	 * @return
	 */
	public Book getBookInfoById(Long bookId){
		String HQL = "from Book where id= :bookId";
		return (Book) getSession().createQuery(HQL).setLong("bookId", bookId).uniqueResult();
	}
	
	/**
	 * 根据pptid获取ppt
	 * @param pptId
	 * @return
	 */
	public OnlineCoursePPT getPptInfoById(Long pptId){
		String HQL = "from OnlineCoursePPT where id = :pptId";
		return (OnlineCoursePPT)getSession().createQuery(HQL).setLong("pptId",pptId).uniqueResult();
	}
	
	/**
	 * 根据videoid获取video
	 * @param videoId
	 * @return
	 */
	public OnlineCourseVideo getVideoInfoById(Long videoId){
		String HQL = "from OnlineCourseVideo where id = :videoId";
		return (OnlineCourseVideo)getSession().createQuery(HQL).setLong("videoId",videoId).uniqueResult();
	}
	
	/**
	 * 根据bookid更改book信息
	 * @param bookId
	 * @param book
	 * @return
	 */
	public boolean updateBookInfoById(Long bookId,Book book){
		String HQL = "update Book set bookName = :bookName , bookIntro = :bookIntro where id = :bookId";
		return getSession().createQuery(HQL).setLong("bookId", bookId).setString("bookName", book.getBookName()).setString("bookIntro", book.getBookIntro()).executeUpdate()>0?true:false;
	}
	
	/**
	 * 根据pptid更改ppt信息
	 * @param bookId
	 * @param book
	 * @return
	 */
	public boolean updatePptInfoById(Long pptId,OnlineCoursePPT ppt){
		String HQL = "update OnlineCoursePPT set pptName = :pptName , pptIntro = :pptIntro where id = :pptid";
		return getSession().createQuery(HQL).setLong("pptid", pptId).setString("pptName", ppt.getPptName()).setString("pptIntro", ppt.getPptIntro()).executeUpdate()>0?true:false;
	}
	
	/**
	 * 根据videoid更改video信息
	 * @param bookId
	 * @param book
	 * @return
	 */
	public boolean updateVideoInfoById(Long videoId,OnlineCourseVideo video){
		String HQL = "update OnlineCourseVideo set videoName = :videoName , videoIntro = :videoIntro where id = :videoId";
		return getSession().createQuery(HQL).setLong("videoId", videoId).setString("videoName", video.getVideoName()).setString("videoIntro", video.getVideoIntro()).executeUpdate()>0?true:false;
	}
	
	/**
	 * 添加书籍信息
	 * @param bookInfo
	 * @return
	 */
	public void addBookInfo(Book bookInfo){
		getSession().save(bookInfo);
	}
	
	/**
	 * 添加课件信息
	 * @param pptInfo
	 * @return
	 */
	public void addPptInfo(OnlineCoursePPT pptInfo){
		getSession().save(pptInfo);
	}
	
	/**
	 * 添加视频信息
	 * @param pptInfo
	 * @return
	 */
	public void addVideoInfo(OnlineCourseVideo videoInfo){
		getSession().save(videoInfo);
	}
	
	
	
	public List queryForPage(String hql,int offset,int length){
		
		return getSession().createQuery(hql).setFirstResult(offset).setMaxResults(length).list();
		
		}
	
	public int getAllRowCount(String hql){
		return getSession().createQuery(hql).list().size();
		}
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		getSession().delete(book);
	}
	public void deletePpt(OnlineCoursePPT ppt) {
		// TODO Auto-generated method stub
		getSession().delete(ppt);
	}
	public void deleteVideo(OnlineCourseVideo video) {
		// TODO Auto-generated method stub
		getSession().delete(video);
	}
	public Long getBookLoadCount() {
		String HQL = "select sum(loadCount) from Book";
		return (Long) getSession().createQuery(HQL).uniqueResult();
	}
	public Long getBookViewCount() {
		String HQL = "select sum(viewCount) from Book";
		return (Long) getSession().createQuery(HQL).uniqueResult();
	}
	public Long getPptViewCount() {
		String HQL = "select sum(loadCount) from OnlineCoursePPT";
		return (Long) getSession().createQuery(HQL).uniqueResult();
	}
	public Long getVideoViewCount() {
		String HQL = "select sum(viewCount) from OnlineCourseVideo";
		return (Long) getSession().createQuery(HQL).uniqueResult();
	}
}
