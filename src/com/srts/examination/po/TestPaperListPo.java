package com.srts.examination.po;

public class TestPaperListPo {
	private String id;
	private String testPaperId;
	private String testPaperName;
	private String testName;
	private String testDate;
	public TestPaperListPo(){}
	public TestPaperListPo(String id, String testPaperId, String testPaperName,
			String testName,String testDate) {
		this.id = id;
		this.testPaperId = testPaperId;
		this.testPaperName = testPaperName;
		this.testName = testName;
		this.testDate = testDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTestPaperId() {
		return testPaperId;
	}
	public void setTestPaperId(String testPaperId) {
		this.testPaperId = testPaperId;
	}
	public String getTestPaperName() {
		return testPaperName;
	}
	public void setTestPaperName(String testPaperName) {
		this.testPaperName = testPaperName;
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
	

}
