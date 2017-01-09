package com.srts.examination.domain;

import com.srts.system.domain.Sys_User;

public class UserTestScore {
	private long id;
	private Sys_User usr;
	private TestPaper testPaper;
	private int grade;
	private String comment;
	public UserTestScore(){}
	public UserTestScore(long id, Sys_User usr, TestPaper testPaper, int grade,
			String comment) {
		this.id = id;
		this.usr = usr;
		this.testPaper = testPaper;
		this.grade = grade;
		this.comment = comment;
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
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
