package com.srts.learning.service;

import java.util.List;

import com.srts.information.domain.TrainNotice;
import com.srts.learning.po.OnlineCourseTracePo;

public interface OnlineCourseTraceManageService {
	public List<OnlineCourseTracePo> getCourseTracePo(int year,int month);
	public List<OnlineCourseTracePo> getCourseTracePoByPage(int page,int year,int month);
	public Integer getCourseTraceTotalPages(int year,int month);
	public List<TrainNotice> getOnlineCourseNoticeTitle(int noticeYear);
	public List<OnlineCourseTracePo> getCourseTraceQueryByOptions(int pageNum,int noticeYear,int noticeMonth,String usrName,String majorName,String companyName,String noticeTitle);
	public Integer getCourseTraceTotalPages(int noticeYear,int noticeMonth,String usrName,String majorName,String companyName,String noticeTitle);
	public String userStudyTraceRecord(long userID,int noticeYear,int noticeMonth,String noticeTitle);
	public String getMonthStudyTimeCount(int year);
}
