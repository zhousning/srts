package com.srts.learning.po;

public class ErrorSetSimplifiedDisplayedPo {
	private String questionId;
	private String type;
	private String content;
	private String flag;
	private String lastTestTime;
	public ErrorSetSimplifiedDisplayedPo(){}
	public ErrorSetSimplifiedDisplayedPo(String questionId, String type,
			String content, String flag, String lastTestTime) {
		super();
		this.questionId = questionId;
		this.type = type;
		this.content = content;
		this.flag = flag;
		this.lastTestTime = lastTestTime;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getLastTestTime() {
		return lastTestTime;
	}
	public void setLastTestTime(String lastTestTime) {
		this.lastTestTime = lastTestTime;
	}
	
}
