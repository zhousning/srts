package com.srts.learning.po;

public class ErrorSetQuestionPo {
	private String errorSetQuestionId;
	private String errorSetQuestionType;
	private String errorSetQuestionContent;
	public ErrorSetQuestionPo(){}
	public ErrorSetQuestionPo(String errorSetQuestionId,
			String errorSetQuestionType, String errorSetQuestionContent) {
		this.errorSetQuestionId = errorSetQuestionId;
		this.errorSetQuestionType = errorSetQuestionType;
		this.errorSetQuestionContent = errorSetQuestionContent;
	}
	public String getErrorSetQuestionId() {
		return errorSetQuestionId;
	}
	public void setErrorSetQuestionId(String errorSetQuestionId) {
		this.errorSetQuestionId = errorSetQuestionId;
	}
	public String getErrorSetQuestionType() {
		return errorSetQuestionType;
	}
	public void setErrorSetQuestionType(String errorSetQuestionType) {
		this.errorSetQuestionType = errorSetQuestionType;
	}
	public String getErrorSetQuestionContent() {
		return errorSetQuestionContent;
	}
	public void setErrorSetQuestionContent(String errorSetQuestionContent) {
		this.errorSetQuestionContent = errorSetQuestionContent;
	}
}
