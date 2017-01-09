package com.srts.communication.domain;
/**
 * 回答采纳
 * @author wyw
 *
 */
public class ProblemAnswerAccept {
	private long id;
	private String accept;
	private ProblemInfo problem;
	private AnswerInfo answer;
	public ProblemAnswerAccept(){
		
	}
	public ProblemAnswerAccept(long id, ProblemInfo problem, AnswerInfo answer,
			String accept) {
		this.id = id;
		this.problem = problem;
		this.answer = answer;
		this.accept = accept;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ProblemInfo getProblem() {
		return problem;
	}
	public void setProblem(ProblemInfo problem) {
		this.problem = problem;
	}
	public AnswerInfo getAnswer() {
		return answer;
	}
	public void setAnswer(AnswerInfo answer) {
		this.answer = answer;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
}
