package com.srts.learning.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.learning.dao.TrainCourseDao;
import com.srts.learning.domain.MyTrainCourse;

@Repository("trainCourseDao")
@Transactional
@SuppressWarnings("unchecked")
public class TrainCourseDaoImpl extends BaseDaoImpl<MyTrainCourse> implements
		TrainCourseDao {

	/**
	 *获取当前进行中的课程
	 */
	public List<MyTrainCourse> selectCurrentCourse(long userId) {
		return getSession().createQuery(
				"from MyTrainCourse f where f.user.id=? and f.status=?")
				.setParameter(0, userId).setParameter(1, "进行中").list();
	}

	/**
	 * 获取历史课程
	 */
	public List<MyTrainCourse> selectHistoryCourse(long userId) {
		return getSession().createQuery(
				"from MyTrainCourse f where f.user.id=? and f.status=?")
				.setParameter(0, userId).setParameter(1, "已完成").list();
	}

	/**
	 * 获取当前课程学习时间
	 */
	public List<?> getSumTime(long userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT mtc.sumTime,mtc.trainCourseId FROM lrn_myTrainCourse mtc WHERE mtc.usrId="
				+ userId + "";
		return getSession().createSQLQuery(sql).list();
	}

	/**
	 * 获取历史课程总的学习次数
	 */
	public List<?> getSumReadTime(long userId) {
		return getSession()
				.createSQLQuery(
						" SELECT mtc.sumRead,mtc.trainCourseId FROM lrn_myTrainCourse mtc WHERE mtc.usrId="
								+ userId + "").list();

	}

	/**
	 * 获取员工课程平均学习时间与我的学习时间
	 */
	public List<?> getAvgAndMyStuTime(long userId) {
		String sql = "SELECT* FROM (SELECT trainCourseId,sumTime FROM lrn_myTrainCourse mtc  WHERE mtc.usrId="
				+ userId
				+ ")a JOIN (SELECT trainCourseId, AVG(CONVERT(int,sumTime)) as avgALL FROM lrn_myTrainCourse mtc GROUP BY trainCourseId) b ON a.trainCourseId=b.trainCourseId";
		return this.getSession().createSQLQuery(sql).list();
	}

	/**
	 *当前进行的课程的完成度
	 */
	public List<?> getComDegree(long userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(status),status FROM lrn_myTrainCourse mtc WHERE mtc.usrId="
				+ userId + " GROUP BY status";
		return this.getSession().createSQLQuery(sql).list();
	}

	/**
	 *获取所有课程总的学习时间
	 */
	public String getTrainStudyTime(long userId) {
		String sql = "SELECT SUM(CONVERT(int,sumTime)) AS sumTime FROM lrn_myTrainCourse mtc WHERE mtc.usrId="
				+ userId + "";
		Object object = this.getSession().createSQLQuery(sql).uniqueResult();
		String res = String.valueOf(object);
		return res;
	}

	/**
	 *获取当前员工正在进行的课程的所有章节
	 */
	public List<?> getAllChapters(long trainCourseId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM klg_bookChapter bc WHERE bc.id IN ( SELECT tcc.chapterId  FROM lrn_trainCourseChapter tcc WHERE trainCourseId="
				+ trainCourseId + ")";
		return this.getSession().createSQLQuery(sql).list();
	}

	public List<BookChapter> getBookChapter(long trainCourseId) {
		String sql = "FROM BookChapter bc WHERE bc.id IN (select tcc.chapterId  FROM TrainCourseChapter tcc WHERE trainCourseId="
				+ trainCourseId + ")";
		return this.getSession().createQuery(sql).list();
	}

	/**
	 * 根据chapterId获取该章节相应的内容
	 */
	public List<BookChapterContent> getAllChapterContents(long chapterId) {
		// TODO Auto-generated method stub
		return this.getSession().createQuery(
				"from BookChapterContent bcc where bcc.id=?").setParameter(0,
				chapterId).list();
	}

	/**
	 * 更新培训时间
	 */
	public void updateThisStartTime(long userId, long trainCourseId,
			String dateString) {
		String sql = "UPDATE lrn_myTrainCourse  SET startTime= CASE WHEN LEN(startTime)=0 OR startTime IS NULL THEN '"
				+ dateString
				+ "' ELSE startTime END WHERE usrId="
				+ userId
				+ " AND trainCourseId=" + trainCourseId + "";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	/**
	 * 更新此次培训结果
	 */

	public void updateTrainResult(long myTrainCourseId,float schedule, String endTime,
			String lastStudyDate, long sumTime) {
		// TODO Auto-generated method stub
		String sql = "UPDATE lrn_myTrainCourse  SET endTime='"
				+ endTime
				+ "',status='已完成' WHERE '已完成'=ALL(SELECT ccs.status FROM lrn_chapterContentStatus ccs WHERE ccs.myTrainCourseId="
				+ myTrainCourseId + ") AND id=" + myTrainCourseId + "";
		String sql2 = "UPDATE lrn_myTrainCourse  SET schedule="+String.valueOf(schedule)+",sumTime=sumTime+"
				+ sumTime + ",lastStudyDate='" + lastStudyDate
				+ "',sumRead=sumRead+1 where id=" + myTrainCourseId + "";
		this.getSession().createSQLQuery(sql).executeUpdate();
		this.getSession().createSQLQuery(sql2).executeUpdate();
	}

	/**
	 * 根据userId与trainCourseId获取某一次的MyTrainCourse
	 */
	public MyTrainCourse getByUsrIdAndTrainCouId(long userId, long trainCourseId) {
		// TODO Auto-generated method stub
		return (MyTrainCourse) this.getSession().createQuery(
				"from MyTrainCourse where user.id=" + userId
						+ " and trainCourse=" + trainCourseId + "")
				.uniqueResult();
	}

	/**
	 * 更新小节状态
	 */
	public void updateThisItem(long myTrainCourseId, long itemID,
			String dateString) {
		String sql = "UPDATE lrn_chapterContentStatus SET status='已完成',date='"
				+ dateString + "' WHERE myTrainCourseId=" + myTrainCourseId
				+ " AND chapterContentId=" + itemID + "";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	/**
	 * 获取培训进度信息
	 */
	public List<?> getSchedule(long myTrainCourseId) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(ccs.status) as sums,status FROM lrn_chapterContentStatus ccs WHERE ccs.myTrainCourseId="
				+ myTrainCourseId + " GROUP BY ccs.status";
		return this.getSession().createSQLQuery(sql).list();
	}

}
