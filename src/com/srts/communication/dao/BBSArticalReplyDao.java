package com.srts.communication.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.communication.domain.BBSArticalReply;

public interface BBSArticalReplyDao extends BaseDao<BBSArticalReply> {

	List<BBSArticalReply> getBBSArticalReplyByArticalId(long articalId);

}
