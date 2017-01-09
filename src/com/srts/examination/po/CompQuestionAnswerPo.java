package com.srts.examination.po;

public class CompQuestionAnswerPo {
	private String CompQuestionId;
	private String CompQuestionAnswer;
	public CompQuestionAnswerPo(){}
	public CompQuestionAnswerPo(String compQuestionId, String compQuestionAnswer) {
		CompQuestionId = compQuestionId;
		CompQuestionAnswer = compQuestionAnswer;
	}
	public String getCompQuestionId() {
		return CompQuestionId;
	}
	public void setCompQuestionId(String compQuestionId) {
		CompQuestionId = compQuestionId;
	}
	public String getCompQuestionAnswer() {
		return CompQuestionAnswer;
	}
	public void setCompQuestionAnswer(String compQuestionAnswer) {
		CompQuestionAnswer = compQuestionAnswer;
	}
	

}
