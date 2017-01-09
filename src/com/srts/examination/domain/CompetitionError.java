package com.srts.examination.domain;

import com.srts.system.domain.Sys_User;

public class CompetitionError {
	private long id;
	private Sys_User usr;
	private QuestionBank errorQuestion;
	private String errorAnswer;
	private String errorDate;
	public CompetitionError(){}
	public CompetitionError(long id, Sys_User usr, QuestionBank errorQuestion,
			String errorAnswer, String errorDate) {
		this.id = id;
		this.usr = usr;
		this.errorQuestion = errorQuestion;
		this.errorAnswer = errorAnswer;
		this.errorDate = errorDate;
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
	public QuestionBank getErrorQuestion() {
		return errorQuestion;
	}
	public void setErrorQuestion(QuestionBank errorQuestion) {
		this.errorQuestion = errorQuestion;
	}
	public String getErrorAnswer() {
		return errorAnswer;
	}
	public void setErrorAnswer(String errorAnswer) {
		this.errorAnswer = errorAnswer;
	}
	public String getErrorDate() {
		return errorDate;
	}
	public void setErrorDate(String errorDate) {
		this.errorDate = errorDate;
	}
	

}
