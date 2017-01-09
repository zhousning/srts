package com.srts.controlPanel.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.controlPanel.dao.PersonPasswordChangeDao;
import com.srts.system.domain.Sys_User;
@Repository
@Transactional
public class PersonPasswordChangeDaoImpl implements PersonPasswordChangeDao {
	@Resource
	private SessionFactory sessionFactory;

	public String updateUserPassword(Sys_User usr, String password) {
		long UsrId=usr.getId();
		String resString="fail";
		int res=sessionFactory.getCurrentSession().createSQLQuery(
				"update srts_sys_user set srts_sys_user.password=:password " +
				"where srts_sys_user.id=:UsrId")
				.setString("password", password).setLong("UsrId", UsrId).executeUpdate();
		if(res==1)
		{
			resString="success";
		}
		return resString;
	}

}
