package com.srts.examination.po;

public class AnswerSheetListPo {
	private String id;
	private String answerSheetId;
	private String testName;
	private String testPaperName;
	private String workno;
	private String userName;
	public AnswerSheetListPo(){}
	public AnswerSheetListPo(String id, String answerSheetId, String testName,
			String testPaperName, String workno, String userName) {
		this.id = id;
		this.answerSheetId = answerSheetId;
		this.testName = testName;
		this.testPaperName = testPaperName;
		this.workno = workno;
		this.userName = userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAnswerSheetId() {
		return answerSheetId;
	}
	public void setAnswerSheetId(String answerSheetId) {
		this.answerSheetId = answerSheetId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestPaperName() {
		return testPaperName;
	}
	public void setTestPaperName(String testPaperName) {
		this.testPaperName = testPaperName;
	}
	public String getWorkno() {
		return workno;
	}
	public void setWorkno(String workno) {
		this.workno = workno;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
