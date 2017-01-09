package com.srts.communication.po;

import java.util.List;

import com.srts.communication.domain.AnswerInfo;
import com.srts.communication.domain.ProblemInfo;

/**
* 类描述：用于显示AnswerInfo列表页面
* 创建人：vector   
* 创建时间：2014-7-15 下午08:56:32   
* 备注：页数 每页的列表
 */
public class AllAnswerInfo {
	//我的提问部分的分页  总页数
	private int allPageNum=0;
	//我的提问部分每页的列表
	private List<AnswerInfoAndProblemInfo> apInfos;
	public int getAllPageNum() {
		return allPageNum;
	}
	public void setAllPageNum(int allPageNum) {
		this.allPageNum = allPageNum;
	}
	public List<AnswerInfoAndProblemInfo> getApInfos() {
		return apInfos;
	}
	public void setApInfos(List<AnswerInfoAndProblemInfo> apInfos) {
		AnswerInfoAndProblemInfo ap;
		ProblemInfo pi;
		AnswerInfo ai;
		for(int i =0;i<apInfos.size();i++){
			ap=apInfos.get(i);
			pi=ap.getProblemInfo();
			ai=ap.getAnswerInfo();
			pi.setDesc(CommUtils.subString(pi.getProblemDesc()));
			ai.setContent(CommUtils.subString(ai.getAnswerContent()));
		}
		this.apInfos = apInfos;
	}
	
	
}
