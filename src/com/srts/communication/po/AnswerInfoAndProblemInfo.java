package com.srts.communication.po;

import com.srts.communication.domain.AnswerInfo;
import com.srts.communication.domain.ProblemInfo;


/**
* 类描述：用于显示一个回答及其对应的一个问题
* 创建人：vector   
* 创建时间：2014-7-15 下午09:22:52   
* 备注：问题 回答
 */
public class AnswerInfoAndProblemInfo {
	private AnswerInfo answerInfo;
	private ProblemInfo problemInfo;
	public AnswerInfo getAnswerInfo() {
		return answerInfo;
	}
	public void setAnswerInfo(AnswerInfo answerInfo) {
		this.answerInfo = answerInfo;
	}
	public ProblemInfo getProblemInfo() {
		return problemInfo;
	}
	public void setProblemInfo(ProblemInfo problemInfo) {
		this.problemInfo = problemInfo;
	}
	
}
