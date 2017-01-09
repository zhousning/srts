package com.srts.estimation.po;

public class UserExeEstimatePo {
	private String id;
	private String type;
	private String exerciseContent;
	private String estimateString;
	public UserExeEstimatePo(){}
	public UserExeEstimatePo(String id, String type, String exerciseContent, String estimateString) {
		this.id = id;
		this.type = type;
		this.exerciseContent = exerciseContent;
		this.estimateString = estimateString;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEstimateString() {
		return estimateString;
	}
	public void setEstimateString(String estimateString) {
		this.estimateString = estimateString;
	}
	public String getExerciseContent() {
		return exerciseContent;
	}
	public void setExerciseContent(String exerciseContent) {
		this.exerciseContent = exerciseContent;
	}
	

}
