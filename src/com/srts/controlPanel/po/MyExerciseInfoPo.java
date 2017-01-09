package com.srts.controlPanel.po;

public class MyExerciseInfoPo {
	private String id;
	private String exerciseName;
	private String exerciseDate;
	private String exerciseAcur;
	public MyExerciseInfoPo(){}
	public MyExerciseInfoPo(String id,String exerciseName, String exerciseDate,
			String exerciseAcur) {
		this.id=id;
		this.exerciseName = exerciseName;
		this.exerciseDate = exerciseDate;
		this.exerciseAcur = exerciseAcur;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public String getExerciseDate() {
		return exerciseDate;
	}
	public void setExerciseDate(String exerciseDate) {
		this.exerciseDate = exerciseDate;
	}
	public String getExerciseAcur() {
		return exerciseAcur;
	}
	public void setExerciseAcur(String exerciseAcur) {
		this.exerciseAcur = exerciseAcur;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
