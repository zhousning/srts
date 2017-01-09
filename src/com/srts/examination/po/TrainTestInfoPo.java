package com.srts.examination.po;

public class TrainTestInfoPo {
	private String testTakenNum;
	private String testerName;
	private String testerJob;
	private String testerWorkno;
	private String testerCompany;
	private String testNum;
	private String testDate;
	private String testPeopleNum;
	private String testName;
	public TrainTestInfoPo(){}
	public TrainTestInfoPo(String testTakenNum, String testerName,
			String testerJob, String testerWorkno, String testerCompany,
			String testNum, String testDate, String testPeopleNum, String testName) {
		this.testTakenNum = testTakenNum;
		this.testerName = testerName;
		this.testerJob = testerJob;
		this.testerWorkno = testerWorkno;
		this.testerCompany = testerCompany;
		this.testNum = testNum;
		this.testDate = testDate;
		this.testPeopleNum = testPeopleNum;
		this.testerName=testName;
	}
	public String getTestTakenNum() {
		return testTakenNum;
	}
	public void setTestTakenNum(String testTakenNum) {
		this.testTakenNum = testTakenNum;
	}
	public String getTesterName() {
		return testerName;
	}
	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}
	public String getTesterJob() {
		return testerJob;
	}
	public void setTesterJob(String testerJob) {
		this.testerJob = testerJob;
	}
	public String getTesterWorkno() {
		return testerWorkno;
	}
	public void setTesterWorkno(String testerWorkno) {
		this.testerWorkno = testerWorkno;
	}
	public String getTesterCompany() {
		return testerCompany;
	}
	public void setTesterCompany(String testerCompany) {
		this.testerCompany = testerCompany;
	}
	public String getTestNum() {
		return testNum;
	}
	public void setTestNum(String testNum) {
		this.testNum = testNum;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getTestPeopleNum() {
		return testPeopleNum;
	}
	public void setTestPeopleNum(String testPeopleNum) {
		this.testPeopleNum = testPeopleNum;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	

}
