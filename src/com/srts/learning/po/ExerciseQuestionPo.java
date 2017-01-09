package com.srts.learning.po;
/**
 * 
 * @author H 2014-5-23 上午05:36:15
 *
 */
public class ExerciseQuestionPo {
	
	private String exerciseQuestionId;
	private String exerciseQuestionType;
	private String exerciseQuestionContent;
	public ExerciseQuestionPo(){}
	public ExerciseQuestionPo(String exerciseQuestionId,
			String exerciseQuestionType, String exerciseQuestionContent) {
		this.exerciseQuestionId = exerciseQuestionId;
		this.exerciseQuestionType = exerciseQuestionType;
		this.exerciseQuestionContent = exerciseQuestionContent;
	}
	public String getExerciseQuestionId() {
		return exerciseQuestionId;
	}
	public void setExerciseQuestionId(String exerciseQuestionId) {
		this.exerciseQuestionId = exerciseQuestionId;
	}
	public String getExerciseQuestionType() {
		return exerciseQuestionType;
	}
	public void setExerciseQuestionType(String exerciseQuestionType) {
		this.exerciseQuestionType = exerciseQuestionType;
	}
	public String getExerciseQuestionContent() {
		return exerciseQuestionContent;
	}
	public void setExerciseQuestionContent(String exerciseQuestionContent) {
		this.exerciseQuestionContent = exerciseQuestionContent;
	}
}

