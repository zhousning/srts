package com.srts.communication.po;

import java.util.List;

import com.srts.communication.domain.BBSArtical;
/**
* 类描述：一个帖子的展示
* 创建人：vector   
* 创建时间：2014-7-21 上午11:44:49   
* 备注：包含帖子  回帖
 */
public class OneBBSArticalShow {
	//帖子
	private BBSArtical artical;
	//回帖
	private List<OneBBSArticalReply> replys;
	public BBSArtical getArtical() {
		return artical;
	}
	public void setArtical(BBSArtical artical) {
		this.artical = artical;
	}
	public List<OneBBSArticalReply> getReplys() {
		return replys;
	}
	public void setReplys(List<OneBBSArticalReply> replys) {
		this.replys = replys;
	}

}
