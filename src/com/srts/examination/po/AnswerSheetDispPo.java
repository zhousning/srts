package com.srts.examination.po;

public class AnswerSheetDispPo {
	private String id;
	private String answerSheetId;
	private String questionId;
	private String questionType;
	private String userAnswer;
	private String answerTrue;
	private String questionScore;
	public AnswerSheetDispPo(){}
	public AnswerSheetDispPo(String id, String answerSheetId,
			String questionId, String questionType, String userAnswer,
			String answerTrue, String questionScore) {
		this.id = id;
		this.answerSheetId = answerSheetId;
		this.questionId = questionId;
		this.questionType = questionType;
		this.userAnswer = userAnswer;
		this.answerTrue = answerTrue;
		this.questionScore = questionScore;
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
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public String getAnswerTrue() {
		return answerTrue;
	}
	public void setAnswerTrue(String answerTrue) {
		this.answerTrue = answerTrue;
	}
	public String getQuestionScore() {
		return questionScore;
	}
	public void setQuestionScore(String questionScore) {
		this.questionScore = questionScore;
	}
	

}
