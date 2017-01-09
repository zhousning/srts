package com.srts.learning.po;

public class TrainCoursePo {
	private String currentCourseSumTime;
	private String currentCourseComDeg;
	private String meanComMyStudyTime;
	private String historyCourseSumRead;
	private String trainStudyTime;

	public TrainCoursePo(){}
	
	public TrainCoursePo(String currentCourseSumTime,
			String currentCourseComDeg, String meanComMyStudyTime,
			String historyCourseSumRead, String trainStudyTime) {
		this.currentCourseSumTime = currentCourseSumTime;
		this.currentCourseComDeg = currentCourseComDeg;
		this.meanComMyStudyTime = meanComMyStudyTime;
		this.historyCourseSumRead = historyCourseSumRead;
		this.trainStudyTime = trainStudyTime;
	}
	
	

	public String getCurrentCourseSumTime() {
		return currentCourseSumTime;
	}

	public void setCurrentCourseSumTime(String currentCourseSumTime) {
		this.currentCourseSumTime = currentCourseSumTime;
	}

	public String getCurrentCourseComDeg() {
		return currentCourseComDeg;
	}

	public void setCurrentCourseComDeg(String currentCourseComDeg) {
		this.currentCourseComDeg = currentCourseComDeg;
	}

	public String getMeanComMyStudyTime() {
		return meanComMyStudyTime;
	}

	public void setMeanComMyStudyTime(String meanComMyStudyTime) {
		this.meanComMyStudyTime = meanComMyStudyTime;
	}

	public String getHistoryCourseSumRead() {
		return historyCourseSumRead;
	}

	public void setHistoryCourseSumRead(String historyCourseSumRead) {
		this.historyCourseSumRead = historyCourseSumRead;
	}

	public String getTrainStudyTime() {
		return trainStudyTime;
	}

	public void setTrainStudyTime(String trainStudyTime) {
		this.trainStudyTime = trainStudyTime;
	}

}
