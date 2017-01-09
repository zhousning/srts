package com.srts.learning.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.learning.domain.MyTrainCourse;

public interface TrainCourseDao extends BaseDao<MyTrainCourse> {

	List<MyTrainCourse> selectCurrentCourse(long userId);

	List<MyTrainCourse> selectHistoryCourse(long userId);


	List<?> getSumTime(long userId);

	List<?> getSumReadTime(long userId);

	List<?> getAvgAndMyStuTime(long userId);

	List<?> getComDegree(long userId);

	String getTrainStudyTime(long userId);

	List<?> getAllChapters(long trainCourseId);
	
	List<BookChapter> getBookChapter(long trainCourseId);

	List<BookChapterContent> getAllChapterContents(long chapterId);

	void updateThisStartTime(long userId, long trainCourseId, String dateString);

	void updateTrainResult(long myTrainCourseId, float schedule, String endTime,
			String lastStudyDate, long sumTime);

	MyTrainCourse getByUsrIdAndTrainCouId(long userId, long trainCourseId);

	void updateThisItem(long myTrainCourseId, long itemID, String dateString);

	List<?> getSchedule(long myTrainCourseId);




}
