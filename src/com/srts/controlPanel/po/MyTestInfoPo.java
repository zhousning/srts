package com.srts.controlPanel.po;

public class MyTestInfoPo {
	private String id;
	private String testDate;
	private String testContent;
	private String grade;
	private String testCompany;
	private String tips;
	public MyTestInfoPo(){}
	public MyTestInfoPo(String id, String testDate, String testContent, String grade,
			String testCompany, String tips) {
		this.id=id;
		this.testDate = testDate;
		this.testContent = testContent;
		this.grade = grade;
		this.testCompany = testCompany;
		this.tips = tips;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getTestContent() {
		return testContent;
	}
	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTestCompany() {
		return testCompany;
	}
	public void setTestCompany(String testCompany) {
		this.testCompany = testCompany;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	

}
