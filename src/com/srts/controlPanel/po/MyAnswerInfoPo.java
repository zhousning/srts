package com.srts.controlPanel.po;

public class MyAnswerInfoPo {
	private String id;
	private String answerContent;
	private String answerDate;
	public MyAnswerInfoPo(){}
	public MyAnswerInfoPo(String id, String answerContent, String answerDate) {
		this.id = id;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	

}
