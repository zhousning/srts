package com.srts.communication.dao;

import com.srts.common.base.BaseDao;
import com.srts.communication.domain.AnswerInfo;
import com.srts.communication.po.AllAnswerInfo;

public interface AnswerInfoDao extends BaseDao<AnswerInfo> {

	void updateAnswerInfo(AnswerInfo answerInfo);

	AllAnswerInfo findAllAnswerInfo(int curPageNum);

	

}
