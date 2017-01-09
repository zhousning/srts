package com.srts.communication.po;

import java.util.List;

/**
 * 类描述： 我的回答 创建人：vector 创建时间：2014-7-10 上午10:29:37 备注：用于显示我的回答页面的数据
 */
public class SelfAnswerInfo {
	
	// 我的回答部分的分页 总页数
	private int myAskAllPageNum = 0;
	// 我的回答部分 每页的列表
	private List<MyAsk> myAsks;

	public int getMyAskAllPageNum() {
		return myAskAllPageNum;
	}

	public void setMyAskAllPageNum(int myAskAllPageNum) {
		this.myAskAllPageNum = myAskAllPageNum;
	}

	public List<MyAsk> getMyAsks() {
		return myAsks;
	}

	public void setMyAsks(List<MyAsk> myAsks) {
		this.myAsks = myAsks;
	}

}
