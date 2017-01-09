package com.srts.estimation.po;

public class UserExeFeqInfoPo {
	private String id;
	private String exerciseFeq;
	private String time;
	private String aveExerciseQuestionNum;
	public UserExeFeqInfoPo(){}
	public UserExeFeqInfoPo(String id, String exerciseFeq, String time,
			String aveExerciseQuestionNum) {
		this.id = id;
		this.exerciseFeq = exerciseFeq;
		this.time = time;
		this.aveExerciseQuestionNum = aveExerciseQuestionNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExerciseFeq() {
		return exerciseFeq;
	}
	public void setExerciseFeq(String exerciseFeq) {
		this.exerciseFeq = exerciseFeq;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAveExerciseQuestionNum() {
		return aveExerciseQuestionNum;
	}
	public void setAveExerciseQuestionNum(String aveExerciseQuestionNum) {
		this.aveExerciseQuestionNum = aveExerciseQuestionNum;
	}
	

}
