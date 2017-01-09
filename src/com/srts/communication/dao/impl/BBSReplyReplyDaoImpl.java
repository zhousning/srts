package com.srts.communication.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.communication.dao.BBSReplyReplyDao;
import com.srts.communication.domain.BBSArticalReply;
import com.srts.communication.domain.BBSReplyReply;
import com.srts.communication.po.ReplyContent;
@Repository
@Transactional
public class BBSReplyReplyDaoImpl extends BaseDaoImpl<BBSReplyReply> implements BBSReplyReplyDao {
	private Session session;
	private Query query;
	@SuppressWarnings("unchecked")
	public List<BBSReplyReply> getBBSReplyReplyByArticalReplyId(long id) {
		List<BBSReplyReply> rr;
		session = getSession();
		String hql = "from BBSReplyReply as b where b.articalReply.id = ? order by b.relayDate desc";
		query = session.createQuery(hql);
		query.setLong(0, id);
		rr = query.list();
		return rr;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<ReplyContent> getHisReplyContents(long id) {
		System.out.println("id : "+id);
		ArrayList<ReplyContent> h=new ArrayList<ReplyContent>();
		List<BBSReplyReply> rr;
		session = getSession();
		String hql = "from BBSReplyReply where usrReply.id=? order by relayDate desc";
		query = session.createQuery(hql);
		query.setLong(0, id);
		rr=query.list();
		for(int i=0;i<rr.size();i++){
			BBSReplyReply r=rr.get(i);
			ReplyContent rc=new ReplyContent();
			rc.setContent(r.getReplyContent());
			rc.setName(r.getUsr().getName());
			String hql2 = "from BBSArticalReply where id=?";
			query = session.createQuery(hql2);
			query.setLong(0, r.getArticalReply().getId());
			BBSArticalReply ar=(BBSArticalReply) query.uniqueResult();
			rc.setTitle(ar.getArtical().getArticalTile());
			rc.setModelName(ar.getArtical().getModel().getModelName());
			h.add(rc);
		}
		return h;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<ReplyContent> getMyReplyContents(long id) {
		ArrayList<ReplyContent> m=new ArrayList<ReplyContent>();
		List<BBSReplyReply> rr=new ArrayList<BBSReplyReply>();
		session = getSession();
		String hql = "from BBSReplyReply where usr.id=? order by relayDate desc";
		query = session.createQuery(hql);
		query.setLong(0, id);
		rr=query.list();
		for(int i=0;i<rr.size();i++){
			BBSReplyReply r=rr.get(i);
			ReplyContent rc=new ReplyContent();
			rc.setContent(r.getReplyContent());
			rc.setName(r.getUsrReply().getName());
			String hql2 = "from BBSArticalReply where id=?";
			query = session.createQuery(hql2);
			query.setLong(0, r.getArticalReply().getId());
			BBSArticalReply ar=(BBSArticalReply) query.uniqueResult();
			rc.setTitle(ar.getArtical().getArticalTile());
			rc.setModelName(ar.getArtical().getModel().getModelName());
			m.add(rc);
		}
		return m;
	}

}
