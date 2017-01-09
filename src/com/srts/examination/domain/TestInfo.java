package com.srts.examination.domain;

public class TestInfo {
	private long id;
	private String testName;
	private String testContent;//考试内容
	private String testCompany;//考试组织单位
	private String testDate;//考试日期
	private String testTime;//考试开始时间
	private String testTimeLength;//考试时长
	private String endTime;//考试结束时间
	private String testPlace;//考试地点
	private int testPeopleNum;//考试应到人数
	private String testPaperProCondition;//考试组卷情况
	private String testPaperEvaCondition;//考试评卷情况
	private String testPaperCondition;//考试抽人情况
	private String testGradeCondition;//成绩管理情况
	private String state;
	
	public TestInfo(){}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestTime() {
		return testTime;
	}
	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	public String getTestPlace() {
		return testPlace;
	}
	public void setTestPlace(String testPlace) {
		this.testPlace = testPlace;
	}
	public int getTestPeopleNum() {
		return testPeopleNum;
	}
	public void setTestPeopleNum(int testPeopleNum) {
		this.testPeopleNum = testPeopleNum;
	}
	public String getTestPaperProCondition() {
		return testPaperProCondition;
	}
	public void setTestPaperProCondition(String testPaperProCondition) {
		this.testPaperProCondition = testPaperProCondition;
	}
	public String getTestPaperEvaCondition() {
		return testPaperEvaCondition;
	}
	public void setTestPaperEvaCondition(String testPaperEvaCondition) {
		this.testPaperEvaCondition = testPaperEvaCondition;
	}
	public String getTestPaperCondition() {
		return testPaperCondition;
	}
	public void setTestPaperCondition(String testPaperCondition) {
		this.testPaperCondition = testPaperCondition;
	}
	public String getTestGradeCondition() {
		return testGradeCondition;
	}
	public void setTestGradeCondition(String testGradeCondition) {
		this.testGradeCondition = testGradeCondition;
	}
	public String getTestContent() {
		return testContent;
	}
	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}
	public String getTestCompany() {
		return testCompany;
	}
	public void setTestCompany(String testCompany) {
		this.testCompany = testCompany;
	}
	public String getTestTimeLength() {
		return testTimeLength;
	}
	public void setTestTimeLength(String testTimeLength) {
		this.testTimeLength = testTimeLength;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

}
