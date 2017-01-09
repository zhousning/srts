package com.srts.learning.po;

/**
 * 用于封装各类课程的统计信息
 * @author wyw
 *
 */
public class OnlineCourseStatisticsPo {
	private String onlineCourseCount;
	private String onlineCourseViewCount;
	private String onlineCourseLoadCount;
	public OnlineCourseStatisticsPo(){}
	public OnlineCourseStatisticsPo(String onlineCourseCount,
			String onlineCourseViewCount, String onlineCourseLoadCount) {
		this.onlineCourseCount = onlineCourseCount;
		this.onlineCourseViewCount = onlineCourseViewCount;
		this.onlineCourseLoadCount = onlineCourseLoadCount;
	}
	public String getOnlineCourseCount() {
		return onlineCourseCount;
	}
	public void setOnlineCourseCount(String onlineCourseCount) {
		this.onlineCourseCount = onlineCourseCount;
	}
	public String getOnlineCourseViewCount() {
		return onlineCourseViewCount;
	}
	public void setOnlineCourseViewCount(String onlineCourseViewCount) {
		this.onlineCourseViewCount = onlineCourseViewCount;
	}
	public String getOnlineCourseLoadCount() {
		return onlineCourseLoadCount;
	}
	public void setOnlineCourseLoadCount(String onlineCourseLoadCount) {
		this.onlineCourseLoadCount = onlineCourseLoadCount;
	}
}
