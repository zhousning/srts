package com.srts.learning.po;

public class ErrorSetAnswerPo {
	private String errorSetQuestionId;
	private String errorSetQuestionAnswer;
	public ErrorSetAnswerPo(){}
	public ErrorSetAnswerPo(String errorSetQuestionId,
			String errorSetQuestionAnswer) {
		this.errorSetQuestionId = errorSetQuestionId;
		this.errorSetQuestionAnswer = errorSetQuestionAnswer;
	}
	public String getErrorSetQuestionId() {
		return errorSetQuestionId;
	}
	public void setErrorSetQuestionId(String errorSetQuestionId) {
		this.errorSetQuestionId = errorSetQuestionId;
	}
	public String getErrorSetQuestionAnswer() {
		return errorSetQuestionAnswer;
	}
	public void setErrorSetQuestionAnswer(String errorSetQuestionAnswer) {
		this.errorSetQuestionAnswer = errorSetQuestionAnswer;
	}
}
