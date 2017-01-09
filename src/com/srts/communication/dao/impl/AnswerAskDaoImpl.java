package com.srts.communication.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.communication.dao.AnswerAskDao;
import com.srts.communication.domain.AnswerAsk;
@Repository
@Transactional
public class AnswerAskDaoImpl extends BaseDaoImpl<AnswerAsk> implements AnswerAskDao {
	private Session session;
	private Query query;
	@SuppressWarnings("unchecked")
	public List<AnswerAsk> findAnswerAskByAnswerInfoId(long id) {
		session = getSession();
		String hql = "from AnswerAsk as answerAsk where answerAsk.answer.id = ? order by answerAsk.askDate asc";
		query = session.createQuery(hql);
		query.setLong(0, id);
		return query.list();
	}

}
