package com.srts.communication.po;

import java.util.List;

import com.srts.communication.domain.AnswerAsk;
import com.srts.communication.domain.AnswerInfo;
import com.srts.communication.domain.ProblemInfo;
/**
* 类描述：我的回答页数据
* 创建人：vector   
* 创建时间：2014-7-10 上午09:54:56   
* 备注：问题 我的回复   追问和回答
 */
public class MyAsk{
	private ProblemInfo problemInfo;
	private AnswerInfo answerInfo;
	private List<AnswerAsk> answerAsk;
	public ProblemInfo getProblemInfo() {
		return problemInfo;
	}
	public void setProblemInfo(ProblemInfo problemInfo) {
		this.problemInfo = problemInfo;
	}
	public AnswerInfo getAnswerInfo() {
		return answerInfo;
	}
	public void setAnswerInfo(AnswerInfo answerInfo) {
		this.answerInfo = answerInfo;
	}
	public List<AnswerAsk> getAnswerAsk() {
		return answerAsk;
	}
	public void setAnswerAsk(List<AnswerAsk> answerAsk) {
		this.answerAsk = answerAsk;
	}
	
}
