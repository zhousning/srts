package com.srts.learning.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.learning.dao.ErrorSetFlagSumDao;
import com.srts.learning.domain.ErrorSetFlagSum;
import com.srts.system.domain.Sys_User;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class ErrorSetFlagSumDaoImpl extends BaseDaoImpl<ErrorSetFlagSum> implements ErrorSetFlagSumDao{
	
	public List<ErrorSetFlagSum> findErrorSetFlagSumById(Sys_User usr) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		String HQL = "from ErrorSetFlagSum where usr.id=:UsrId";
		return (List<ErrorSetFlagSum>) getSession().createQuery(HQL).setLong("UsrId", UsrId).list();
//		return (List<ErrorSetFlagSum>) getSession()
//		.createSQLQuery(
//				"select * from lrn_errorSetFlagSum where lrn_errorSetFlagSum.usrId=:UsrId").setLong("UsrId", UsrId).list();
	}
	public int insertErrorSetFlagSum(int flagSum,String TimePoint,Sys_User usr) {
		// TODO Auto-generated method stub
		long UsrId=usr.getId();
		String sql="insert into lrn_errorSetFlagSum(flagSum,TimePoint,usrId) values(?,?,?)";
		SQLQuery query= getSession().createSQLQuery(sql);
		query.setInteger(0,flagSum);
		query.setString(1, TimePoint);
		query.setLong(2, UsrId);
		int insertRes=query.executeUpdate();
		return insertRes;
	}

}
