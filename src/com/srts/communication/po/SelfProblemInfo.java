package com.srts.communication.po;

import java.util.List;

import com.srts.communication.domain.ProblemInfo;

/**
* 类描述：包含：个人的所有问题  页数
* 创建人：vector   
* 创建时间：2014-7-6 下午08:57:26   
* 备注：
 */
public class SelfProblemInfo {
	//我的提问部分的分页  总页数
	private int allPageNum=0;
	//我的提问部分每页的列表
	private List<ProblemInfo> selfProblemInfos;
	
	public int getAllPageNum() {
		return allPageNum;
	}
	public void setAllPageNum(int allPageNum) {
		this.allPageNum = allPageNum;
	}
	public List<ProblemInfo> getSelfProblemInfos() {
		return selfProblemInfos;
	}
	public void setSelfProblemInfos(List<ProblemInfo> selfProblemInfos) {
		this.selfProblemInfos = selfProblemInfos;
	}
	
}
