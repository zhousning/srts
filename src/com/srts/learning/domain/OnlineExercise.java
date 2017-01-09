package com.srts.learning.domain;

import com.srts.system.domain.Sys_User;

/**
 * 
 * @author H 2014-5-20 下午10:17:03
 *
 */
public class OnlineExercise {
	private static final long serialVersionUID = 1L;

	private long id;//主键id
	private Sys_User user;//用户
	private long exerciseSn;//此用户的第n次练习
	private String exerciseDate;//练习日期
	private String exerciseName;//练习内容名称
	private int resultRight;//答对题数
	private int resultBlank;//未答题数
	private int resultWrong;//答错题数
	private float accuracyRate;//准确率
	private float accuracyStability;//准确率稳定性
	public OnlineExercise(){}
	public OnlineExercise(long id, Sys_User user, long exerciseSn,
			String exerciseDate, String exerciseName, int resultRight, int resultBlank, int resultWrong,
			float accuracyRate, float accuracyStability) {
		this.id = id;
		this.user = user;
		this.exerciseSn = exerciseSn;
		this.exerciseDate = exerciseDate;
		this.exerciseName = exerciseName;
		this.resultRight = resultRight;
		this.resultBlank = resultBlank;
		this.resultWrong = resultWrong;
		this.accuracyRate = accuracyRate;
		this.accuracyStability = accuracyStability;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Sys_User getUser() {
		return user;
	}
	public void setUser(Sys_User user) {
		this.user = user;
	}
	public long getExerciseSn() {
		return exerciseSn;
	}
	public void setExerciseSn(long exerciseSn) {
		this.exerciseSn = exerciseSn;
	}
	
	public String getExerciseDate() {
		return exerciseDate;
	}
	public void setExerciseDate(String exerciseDate) {
		this.exerciseDate = exerciseDate;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public int getResultRight() {
		return resultRight;
	}
	public void setResultRight(int resultRight) {
		this.resultRight = resultRight;
	}
	public int getResultBlank() {
		return resultBlank;
	}
	public void setResultBlank(int resultBlank) {
		this.resultBlank = resultBlank;
	}
	public int getResultWrong() {
		return resultWrong;
	}
	public void setResultWrong(int resultWrong) {
		this.resultWrong = resultWrong;
	}
	public float getAccuracyRate() {
		return accuracyRate;
	}
	public void setAccuracyRate(float accuracyRate) {
		this.accuracyRate = accuracyRate;
	}
	public float getAccuracyStability() {
		return accuracyStability;
	}
	public void setAccuracyStability(float accuracyStability) {
		this.accuracyStability = accuracyStability;
	}
}