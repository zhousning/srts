package com.srts.learning.po;

/**
 * 
 * @author H 2014-5-22 下午10:20:13
 *
 */

public class ExerciseResultSumPo {
	private String resultRight;
	private String resultBlank;
	private String resultWrong;
	public ExerciseResultSumPo(){}
	public ExerciseResultSumPo(String resultRight, String resultBlank,
			String resultWrong) {
		this.resultRight = resultRight;
		this.resultBlank = resultBlank;
		this.resultWrong = resultWrong;
	}
	public String getResultRight() {
		return resultRight;
	}
	public void setResultRight(String resultRight) {
		this.resultRight = resultRight;
	}
	public String getResultBlank() {
		return resultBlank;
	}
	public void setResultBlank(String resultBlank) {
		this.resultBlank = resultBlank;
	}
	public String getResultWrong() {
		return resultWrong;
	}
	public void setResultWrong(String resultWrong) {
		this.resultWrong = resultWrong;
	}
	
}
