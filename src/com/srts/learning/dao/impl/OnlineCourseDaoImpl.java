package com.srts.learning.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.dao.OnlineCourseDao;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class OnlineCourseDaoImpl extends BaseDaoImpl<Book> implements OnlineCourseDao{
	
	/**
	 * 获取所有的课件资源
	 */
	public List<OnlineCoursePPT> getAllOnlineCoursePPT(){
		String HQL="from OnlineCoursePPT";
		return getSession().createQuery(HQL).list();
	}
	
	/**
	 * 获取所有的视频资源
	 */
	public List<OnlineCourseVideo> getAllOnlineCourseVideo(){
		String HQL="from OnlineCourseVideo";
		return getSession().createQuery(HQL).list();
	}
	
	/**
	 * 根据bookId获取书的章节
	 * @param bookID
	 * @return
	 */
	public List<BookChapter> getBookChapters(long bookID){
		String HQL = "from BookChapter where book.id = :bookID";
		return getSession().createQuery(HQL).setLong("bookID", bookID).list();
	}
	
	/**
	 * 根据pptID获取课件的信息
	 * @param pptID
	 * @return
	 */
	public OnlineCoursePPT getPptByPptId(long pptID){
		String HQL = "from OnlineCoursePPT where id = :pptID";
		return (OnlineCoursePPT) getSession().createQuery(HQL).setLong("pptID", pptID).uniqueResult();
	}
	
	/**
	 * 根据videoID获取视频的信息
	 * @param videoID
	 * @return
	 */
	public OnlineCourseVideo getVideoByID( long videoID){
		String HQL = "from OnlineCourseVideo where id = :videoID";
		return (OnlineCourseVideo) getSession().createQuery(HQL).setLong("videoID", videoID).uniqueResult();
	}
	
	/**
	 * 通过章节id获取章节内容，点击左侧章节，右侧显示章节内容
	 * @param chapterID
	 * @return
	 */
	public List<BookChapterContent> getChapterContentsByChapterID(long chapterID){
		String HQL = "from BookChapterContent where chapter.id = :chapterID";
		return getSession().createQuery(HQL).setLong("chapterID", chapterID).list();
	}
	
	/**
	 * 获取浏览数最高的六个，并推荐给用户
	 * @return
	 */
	public List<OnlineCourseVideo> getTop6Video(){
		String HQL = "from OnlineCourseVideo order by viewCount desc";
		return getSession().createQuery(HQL).setMaxResults(6).list();
	}
	
	/**
	 * 根据bookId来统计书的章节
	 */
	public Integer getBookChapterCountById(long bookId){
		String SQL = "select COUNT(bc.bookId) countAll " +
				"from klg_bookChapter bc " +
				"where bc.bookId =:bookId " +
				"group by bc.bookId";
		Integer count = (Integer) getSession().createSQLQuery(SQL).setLong("bookId", bookId).uniqueResult();
		return count ==null?0:count;
	}
	
	/**
	 * 根据bookId,userId来统计自主学习书的章节
	 */
	public Integer getStudyBookChapterCountById(long bookId,long userId){
		String SQL = "select COUNT(scc.chapterId)sumstudychapter " +
				"from lrn_studyCourseChapter scc,lrn_myStudyCourse msc " +
				"where msc.id = scc.myStudyCourseId " +
				"and msc.usrId = :userId " +
				"and scc.status='完成' " +
				"and scc.bookId = :bookId " +
				"group by scc.bookId";
		Integer count = (Integer) getSession().createSQLQuery(SQL).setLong("userId", userId).setLong("bookId", bookId).uniqueResult();
		return count==null?0:count;
	}
	
	/**
	 * 根据员工的状态--完成/进行中获取书
	 */
	public List getBookChapterStatusByFinishOrUndone(long userId,long bookId,String status){
		String SQL = "select scc.bookId,scc.bookName,scc.chapterId " +
				"from lrn_studyCourseChapter scc,lrn_myStudyCourse msc " +
				"where scc.myStudyCourseId = msc.id " +
				"and msc.usrId = :userId " +
				"and scc.bookId = :bookId " +
				"and scc.status= :status";
		return getSession().createSQLQuery(SQL).setLong("userId", userId).setLong("bookId", bookId).setString("status", status).list();
	}
	
	/**
	 * 获取员工自主学习课程现有章节的状态，用作进度
	 */
	public List getBookChapterStatusNotByFinishOrUndone(long userId,long bookId){
		String SQL = "select scc.chapterId ,scc.status,scc.bookId,scc.bookName " +
				"from lrn_studyCourseChapter scc,lrn_myStudyCourse msc " +
				"where scc.myStudyCourseId = msc.id " +
				"and msc.usrId = :userId " +
				"and scc.bookId = :bookId";
		return getSession().createSQLQuery(SQL).setLong("userId", userId).setLong("bookId", bookId).list();
	}

	public int insertIntoMyStudyCourse(long sumTime, Sys_User usr,
			String studyRecord, String studyContent, long trainId,
			String startTime, String endTime, String lastStudyTime, long bookId) {
		int insertRes=1;
		long UsrId=usr.getId();
		String search="select * from lrn_myStudyCourse where lrn_myStudyCourse.usrId=:UsrId and lrn_myStudyCourse.bookId=:bookId and lrn_myStudyCourse.trainId=:trainId";
		List list = getSession()
		.createSQLQuery(search).setLong("UsrId", UsrId).setLong("bookId",bookId).setLong("trainId",trainId).list();
		if(list.isEmpty()==false)
		{
			String record="";
			long sum=0;
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				record=objs[6].toString()+","+lastStudyTime+"|"+String.valueOf(sumTime);
				sum=Long.parseLong(objs[3].toString())+sumTime;
			}
			insertRes=getSession().createSQLQuery(
			"update lrn_myStudyCourse set lrn_myStudyCourse.sumTime=:sum," +
			"lrn_myStudyCourse.studyRecord=:record," +
			"lrn_myStudyCourse.lastStudyTime=:lastStudyTime " +
			"where lrn_myStudyCourse.usrId=:UsrId and lrn_myStudyCourse.bookId=:bookId and lrn_myStudyCourse.trainId=:trainId")
			.setLong("bookId",bookId)
			.setLong("UsrId", UsrId)
			.setString("record", record)
			.setString("lastStudyTime", lastStudyTime)
			.setLong("sum", sum)
			.setLong("trainId",trainId)
			.executeUpdate();
		}
		else{
		String sql="insert into lrn_myStudyCourse(startTime,endTime,sumTime,lastStudyTime,usrId," +
				"studyRecord,trainId,studyContent,bookId) values(?,?,?,?,?,?,?,?,?)";
		SQLQuery query= getSession().createSQLQuery(sql);
		query.setString(0,startTime);
		query.setString(1, endTime);
		query.setLong(2, sumTime);
		query.setString(3, lastStudyTime);
		query.setLong(4, UsrId);
		query.setString(5, studyRecord);
		query.setLong(6, trainId);
		query.setString(7, studyContent);
		query.setLong(8, bookId);
		insertRes=query.executeUpdate();
		}
		return insertRes;
	}

	public int updateBookViewCount(long bookID) {
		int insertRes=getSession().createSQLQuery(
				"update klg_book set klg_book.viewCount=klg_book.viewCount+1 " +
				"where klg_book.id=:bookID")
				.setLong("bookID",bookID)
				.executeUpdate();
		return insertRes;
	}

	public int updateVideoViewCount(long videoID) {
		int insertRes=getSession().createSQLQuery(
				"update klg_coursevideo set klg_coursevideo.viewCount=klg_coursevideo.viewCount+1 " +
				"where klg_coursevideo.id=:videoID")
				.setLong("videoID",videoID)
				.executeUpdate();
		return insertRes;
	}

	public long selectTrainIdByNoticeId(long noticeId) {
		String sql = "select id from lrn_train where noticeId=:noticeId";
		long id=Long.parseLong(String.valueOf(getSession().createSQLQuery(sql).setLong("noticeId", noticeId).uniqueResult()));
		return id;
	}
	
}
