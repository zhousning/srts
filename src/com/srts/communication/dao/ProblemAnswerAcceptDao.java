package com.srts.communication.dao;

import com.srts.common.base.BaseDao;
import com.srts.communication.domain.ProblemAnswerAccept;

public interface ProblemAnswerAcceptDao extends BaseDao<ProblemAnswerAccept> {

	ProblemAnswerAccept findProblemAnswerAcceptByProblemId(Long problemId);

}
