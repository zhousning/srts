package com.srts.communication.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.communication.dao.ProblemAnswerAcceptDao;
import com.srts.communication.domain.ProblemAnswerAccept;
@Repository
@Transactional
public class ProblemAnswerAcceptDaoImpl extends BaseDaoImpl<ProblemAnswerAccept> implements ProblemAnswerAcceptDao {
	private Session session;
	private Query query;
	public ProblemAnswerAccept findProblemAnswerAcceptByProblemId(Long problemId) {
		String hql="from ProblemAnswerAccept  where problemId=?";
		session = getSession();
		query = session.createQuery(hql);
		query.setLong(0, problemId);
		return (ProblemAnswerAccept) query.uniqueResult();
	}

}
