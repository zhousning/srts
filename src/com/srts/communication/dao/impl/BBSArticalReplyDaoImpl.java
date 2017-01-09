package com.srts.communication.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.communication.dao.BBSArticalReplyDao;
import com.srts.communication.domain.BBSArticalReply;

@Repository
@Transactional
public class BBSArticalReplyDaoImpl extends BaseDaoImpl<BBSArticalReply> implements BBSArticalReplyDao {
	private Session session;
	private Query query;
	@SuppressWarnings("unchecked")
	public List<BBSArticalReply> getBBSArticalReplyByArticalId(long articalId) {
		List<BBSArticalReply> replys;
		session = getSession();
		String hql = "from BBSArticalReply as b where b.artical.id = ? order by b.relayDate desc";
		query = session.createQuery(hql);
		query.setLong(0, articalId);
		replys = query.list();
		return replys;
	}

}
