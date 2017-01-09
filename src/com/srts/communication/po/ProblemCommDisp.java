package com.srts.communication.po;


import java.util.Set;

import com.srts.communication.domain.AnswerInfo;
/**
* 类描述：单个问题显示时的评论部分
* 创建人：vector   
* 创建时间：2014-7-8 上午08:52:12   
* 备注：包含我的评论 其他人的评论
 */
public class ProblemCommDisp {
	
	//我的评论  没有的话为空值
	AnswerInfo answerInfo;
	
	//其他人的评论 
	private Set<AnswerInfo> otherAnswerInfos;

	public AnswerInfo getAnswerInfo() {
		return answerInfo;
	}

	public void setAnswerInfo(AnswerInfo answerInfo) {
		this.answerInfo = answerInfo;
	}

	public Set<AnswerInfo> getOtherAnswerInfos() {
		return otherAnswerInfos;
	}

	public void setOtherAnswerInfos(Set<AnswerInfo> otherAnswerInfos) {
		this.otherAnswerInfos = otherAnswerInfos;
	}
	
	
}
