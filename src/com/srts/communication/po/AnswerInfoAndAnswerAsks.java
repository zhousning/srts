package com.srts.communication.po;

import java.util.List;

import com.srts.communication.domain.AnswerAsk;
import com.srts.communication.domain.AnswerInfo;
/**
* 类描述：对一个问题的回复 及针对一个回复的所有的追问
* 创建人：vector   
* 创建时间：2014-7-10 下午04:23:05   
* 备注：
 */
public class AnswerInfoAndAnswerAsks {
	//回复信息
	private AnswerInfo answerInfo;
	//追问信息表
	private List<AnswerAsk> answerAsks;
	
	
	public AnswerInfo getAnswerInfo() {
		return answerInfo;
	}
	public void setAnswerInfo(AnswerInfo answerInfo) {
		this.answerInfo = answerInfo;
	}
	public List<AnswerAsk> getAnswerAsks() {
		return answerAsks;
	}
	public void setAnswerAsks(List<AnswerAsk> answerAsks) {
		this.answerAsks = answerAsks;
	}
	
}
