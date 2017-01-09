package com.srts.learning.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.learning.dao.StudyCourseDao;

/**
 * 在线自主学习dao
 * @author wyw 2014-05-12
 *
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class StudyCourseDaoImpl extends BaseDaoImpl<Book> implements StudyCourseDao {
	//////////////////////////////////StudyCourseList/////////////////////////
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
	 * 选择员工所有学习课程、章节信息状态,新
	 */
	public List getMyStudyCourseBookInfo(long userId){
		String SQL = "select distinct bk.id,bk.bookName,bk.bookIcon " +
				"from lrn_studyCourseChapter scc, klg_book bk,lrn_myStudyCourse msc " +
				"where scc.bookId = bk.id " +
				"and msc.id = scc.myStudyCourseId " +
				"and msc.usrId = :userId " +
				"order by bk.id";
		return (List) getSession().createSQLQuery(SQL).setLong("userId", userId).list();
	}
	
	/**
	 * 选择员工所有学习章节信息状态,新
	 */
	public List getMyStudyCourseChapterInfo(long userId,long bookId){
		String SQL = "select scc.chapterId,bc.chapterNum,bc.chapterName,scc.status,scc.myStudyCourseId,msc.sumTime,msc.startTime,msc.endTime,bk.id bookId " +
				"from lrn_studyCourseChapter scc, klg_book bk,lrn_myStudyCourse msc,klg_bookChapter bc " +
				"where msc.id = scc.myStudyCourseId " +
				"and scc.bookId = bk.id " +
				"and bc.id = scc.chapterId " +
				"and bk.id = :bookId " +
				"and msc.usrId = :userId";
		return (List) getSession().createSQLQuery(SQL).setLong("bookId", bookId).setLong("userId", userId).list();
	}
	
	/**
	 * 获得书的所有章节 countchapter bookid
	 */
	public List getBookChapterCount(){
		String SQL = "select COUNT(bc.chapterName) sumchapter,bookId from klg_bookChapter bc group by bc.bookId";
		return getSession().createSQLQuery(SQL).list();
	}
	/**
	 * 获得完成的所有章节countstudychapter bookid
	 */
	public List getStudyBookChapterCount(long userId){
		String SQL="select COUNT(scc.chapterId)sumstudychapter,bookId " +
				"from lrn_studyCourseChapter scc,lrn_myStudyCourse msc " +
				"where msc.id = scc.myStudyCourseId " +
				"and msc.usrId = :userId " +
				"and scc.status='完成' " +
				"group by scc.bookId";
		return getSession().createSQLQuery(SQL).setLong("userId", userId).list();
	}
	/**
	 * 获取员工每本书的学习时间累计totaltime bookid
	 */
	public List getStudyTotalTime(long userId){
		String SQL = "select sum(sumTime)totalTime,bookId " +
				"from lrn_studyCourseChapter scc,lrn_myStudyCourse msc " +
				"where msc.id = scc.myStudyCourseId " +
				"and msc.usrId = :userId " +
				"group by scc.bookId";
		return getSession().createSQLQuery(SQL).setLong("userId", userId).list();
	}
	
	/**
	 * 获取员工每个月自主学习的次数 studyCount
	 */
	public Integer getStudyCourseNumCount(long userId,String month){
		String SQL = "select COUNT(msc.id) num " +
				"from lrn_studyCourseChapter scc,lrn_myStudyCourse msc " +
				"where msc.id = scc.myStudyCourseId " +
				"and msc.usrId = :userId " +
				"and msc.startTime like :month";
		
		return (Integer) getSession().createSQLQuery(SQL).setLong("userId", userId).setString("month", month).uniqueResult();
	}
	//////////////////////////////////StudyCourseList/////////////////////////
	
	//////////////////////////////////StudyCourseDisp/////////////////////////

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
	
	/**
	 * 根据bookId获取书的章节
	 */
	public List<BookChapter> getBookChapters(long bookID){
		String HQL = "from BookChapter where book.id = :bookID";
		return getSession().createQuery(HQL).setLong("bookID", bookID).list();
	}
	
	/**
	 * 通过章节id获取章节内容，点击左侧章节，右侧显示章节内容
	 */
	public List<BookChapterContent> getBookChapterContents(long chapterID){
		String HQL = "from BookChapterContent where chapter.id = :chapterID";
		return getSession().createQuery(HQL).setLong("chapterID", chapterID).list();
	}
	/**
	 * 根据bookID,来获得进行中的章节
	 * @param bookID
	 * @return
	 */
	public List<BookChapterContent> getStudyBookOtherChapter(long bookID,long userID){
		String HQL = "from BookChapterContent bcc where bcc.chapter.id=(" +
				"select scc.chapterId from StudyCourseChapter scc,MyStudyCourse msc " +
				"where scc.myStudyCourse.id = msc.id " +
				"and msc.usr.id=:userID " +
				"and scc.bookId=:bookID " +
				"and scc.status='进行中')";
		return getSession().createQuery(HQL).setLong("userID", userID).setLong("bookID", bookID).list();
	}
	/**
	 * 根据bookID，来获取完成章节的下一章节
	 */
	public List<BookChapterContent> getStudyBookOtherChapterUndo(long bookID,long userID){
		String HQL = "from BookChapterContent bcc_out where bcc_out.chapter.id =" +
				"(select min(bcc.chapter.id)from BookChapterContent bcc where bcc.chapter.id>(" +
				"select max(scc.chapterId) from StudyCourseChapter scc,MyStudyCourse msc " +
				"where scc.myStudyCourse.id = msc.id " +
				"and msc.usr.id=:userID " +
				"and scc.bookId=:bookID " +
				"and scc.status='完成'))";
		return getSession().createQuery(HQL).setLong("userID", userID).setLong("bookID", bookID).list();
	}
	
	//////////////////////////////////StudyCourseDisp/////////////////////////
}
