package com.srts.communication.dao.impl;



import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.communication.dao.BBSModelDao;
import com.srts.communication.domain.BBSModel;
@Repository
@Transactional
public class BBSModelDaoImpl extends BaseDaoImpl<BBSModel> implements BBSModelDao {
	private Session session;
	private Query query;
	
	public void updateModelArticalNum(long bbsModelid) {
		session = getSession();
		String hql = "UPDATE cmnc_bbsmodel SET articalCount=articalCount+1 where id=? ";
		query = session.createSQLQuery(hql);
		query.setLong(0, bbsModelid);
		query.executeUpdate();
	}


}
