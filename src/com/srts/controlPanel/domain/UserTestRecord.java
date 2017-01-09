package com.srts.controlPanel.domain;

import com.srts.system.domain.Sys_User;

public class UserTestRecord {
	private long id;
	private Sys_User usr;
	private String testDate;
	private String testContent;
	private int testScore;
	private String testOrgCompany;
	private String testTips;
	public UserTestRecord(){}
	public UserTestRecord(long id, Sys_User usr, String testDate,
			String testContent, int testScore, String testOrgCompany,
			String testTips) {
		this.id = id;
		this.usr = usr;
		this.testDate = testDate;
		this.testContent = testContent;
		this.testScore = testScore;
		this.testOrgCompany = testOrgCompany;
		this.testTips = testTips;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Sys_User getUsr() {
		return usr;
	}
	public void setUsr(Sys_User usr) {
		this.usr = usr;
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
	public int getTestScore() {
		return testScore;
	}
	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}
	public String getTestOrgCompany() {
		return testOrgCompany;
	}
	public void setTestOrgCompany(String testOrgCompany) {
		this.testOrgCompany = testOrgCompany;
	}
	public String getTestTips() {
		return testTips;
	}
	public void setTestTips(String testTips) {
		this.testTips = testTips;
	}
	

}
