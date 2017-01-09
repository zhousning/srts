package com.srts.estimation.po;

public class CompanyTestInfoPo {
	private String id;
	private String dept;
	private String workno;
	private String workerName;
	private String testName;
	private String testDate;
	private String score;

	public CompanyTestInfoPo(){}
	public CompanyTestInfoPo(String id, String dept, String workno, String workerName, String testName,
			String testDate, String score) {
		this.id = id;
		this.dept=dept;
		this.workno=workno;
		this.workerName = workerName;
		this.testName = testName;
		this.testDate = testDate;
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getWorkno() {
		return workno;
	}
	public void setWorkno(String workno) {
		this.workno = workno;
	}
	

}
