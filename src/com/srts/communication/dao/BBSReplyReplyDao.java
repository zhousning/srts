package com.srts.communication.dao;

import java.util.ArrayList;
import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.communication.domain.BBSReplyReply;
import com.srts.communication.po.ReplyContent;

public interface BBSReplyReplyDao extends BaseDao<BBSReplyReply> {

	List<BBSReplyReply> getBBSReplyReplyByArticalReplyId(long id);

	ArrayList<ReplyContent> getHisReplyContents(long id);

	ArrayList<ReplyContent> getMyReplyContents(long id);

}
