package com.srts.learning.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.srts.common.base.BaseDao;
import com.srts.information.domain.TrainNotice;
import com.srts.learning.domain.MyStudyCourse;

public interface OnlineCourseTraceManageDao extends BaseDao<MyStudyCourse> {
	public List<Object[]> getAllUserStudyTrace(int year,int month);
	public List<Object[]> getAllUserCourseTrace(int year,int month,int min,int max);
	public Integer getUsrCourseTraceCount(int year,int month);
	public List<TrainNotice> getOnlineCourseNoticeTitle(int noticeYear);
	public List<Object[]> getUserStudyTraceQueryByOptions(int year,int month,Map<String,String> options,String optionMatch,int max,int min);
	public Integer getCourseTraceCountQueryByOptions(int year,int month,Map<String,String> options,String optionMatch);
	public String getUserOnlineCourseTraceRecord(long uesrID,int noticeYear,int noticeMonth,String noticeTitle);
	public List<Object[]> getCompanyTimeCount(int year, int month);
	
	
	public BigDecimal getMonthStudyTimeCount(int year,int month);
	
}
