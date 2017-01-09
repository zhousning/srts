package com.srts.communication.po;

import java.util.List;

import com.srts.communication.domain.ProblemInfo;
/**
* 类描述：我的一个问题的详细描述 包含问题  采纳的回答及其回答   其他回答和追问的集合
* 创建人：vector   
* 创建时间：2014-7-10 上午11:31:20   
* 备注：
 */
public class MyOneProblem {
	//问题
	private ProblemInfo problemInfo;
	//采纳的答案的追问
	private AnswerInfoAndAnswerAsks aaas;
	//其他答案和追问
	private List<AnswerInfoAndAnswerAsks> answerInfoAndAnswerAsks;
	
	public ProblemInfo getProblemInfo() {
		return problemInfo;
	}
	public void setProblemInfo(ProblemInfo problemInfo) {
		this.problemInfo = problemInfo;
	}
	public List<AnswerInfoAndAnswerAsks> getAnswerInfoAndAnswerAsks() {
		return answerInfoAndAnswerAsks;
	}
	public void setAnswerInfoAndAnswerAsks(
			List<AnswerInfoAndAnswerAsks> answerInfoAndAnswerAsks) {
		this.answerInfoAndAnswerAsks = answerInfoAndAnswerAsks;
	}
	public AnswerInfoAndAnswerAsks getAaas() {
		return aaas;
	}
	public void setAaas(AnswerInfoAndAnswerAsks aaas) {
		this.aaas = aaas;
	}
	
}
