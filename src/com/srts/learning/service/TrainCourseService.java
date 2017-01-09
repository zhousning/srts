package com.srts.learning.service;

import java.util.List;

import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.learning.domain.MyTrainCourse;
import com.srts.learning.po.TrainCourseBookPo;
import com.srts.learning.po.TrainCourseInfoPo;

public interface TrainCourseService {

	List<MyTrainCourse> getCurrentCourse(long userId);

	//根据用户ID获取用户实体
	MyTrainCourse getById(long userId);

	List<MyTrainCourse> getHistoryCourse(long userId);

	String getSumTime(long userId);

	String getSumReadTime(long userId);

	String getAvgCompMyStuTime(long userId);

	String getComDegree(long userId);

	String getTrainStudyTime(long userId);

//	List<TrainCourseChapterInfoPo> getCourseInfo(long trainCourseId);

	List<BookChapter> getAllChapters(long trainCourseId);

	List<BookChapterContent> getAllChapterContents(long chapterId);

	void updateThisStartTime(long userId, long trainCourseId, String dateString);

	MyTrainCourse getByUsrIdAndTrainCouId(long userId, long trainCourseId);

	List<BookChapter> getBookChapter(long trainCourseId);

	void updateThisItem(long myTrainCourseId, long itemID, String dateString);

	void updateTrainResult(long myTrainCourseId, float schedule, String endTime,
			String lastStudyDate, long sumTime);

	float getSchedule(long myTrainCourseId);




	
}
