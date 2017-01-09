package com.srts.communication.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.communication.domain.AnswerAsk;

public interface AnswerAskDao extends BaseDao<AnswerAsk> {

	List<AnswerAsk> findAnswerAskByAnswerInfoId(long id);
	
}
