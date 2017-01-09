package com.srts.examination.domain;

public class QuestionScoreList {
	private long id;
	private String type;
	private int score;
	private TestPaper testPaper;
	public QuestionScoreList(){}
	public QuestionScoreList(long id, String type, int score,
			TestPaper testPaper) {
		this.id = id;
		this.type = type;
		this.score = score;
		this.testPaper = testPaper;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
}
