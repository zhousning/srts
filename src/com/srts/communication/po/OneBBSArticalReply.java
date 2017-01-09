package com.srts.communication.po;

import java.util.List;

import com.srts.communication.domain.BBSArticalReply;
import com.srts.communication.domain.BBSReplyReply;

/**
* 类描述：用于一个帖子回复的显示 
* 创建人：vector   
* 创建时间：2014-7-21 上午11:49:13   
* 备注：包含 ： 回复 及 二级回复
 */
public class OneBBSArticalReply {
	//回帖
	private BBSArticalReply bbsArticalRePly;
	//回帖的回帖  二级回帖
	private List<BBSReplyReply> bbsReplyReplies;
	public BBSArticalReply getBbsArticalRePly() {
		return bbsArticalRePly;
	}
	public void setBbsArticalRePly(BBSArticalReply bbsArticalRePly) {
		this.bbsArticalRePly = bbsArticalRePly;
	}
	public List<BBSReplyReply> getBbsReplyReplies() {
		return bbsReplyReplies;
	}
	public void setBbsReplyReplies(List<BBSReplyReply> bbsReplyReplies) {
		this.bbsReplyReplies = bbsReplyReplies;
	}
}
