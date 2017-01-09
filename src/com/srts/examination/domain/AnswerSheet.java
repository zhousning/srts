package com.srts.examination.domain;

import com.srts.system.domain.Sys_User;

public class AnswerSheet {
	private long id;
	private Sys_User usr;
	private TestPaper testPaper;
	private String content;
	public AnswerSheet(){}
	public AnswerSheet(long id, Sys_User usr, TestPaper testPaper,
			String content) {
		this.id = id;
		this.usr = usr;
		this.testPaper = testPaper;
		this.content = content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
