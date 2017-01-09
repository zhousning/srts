package com.srts.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.system.dao.PriviliegeDao;
import com.srts.system.domain.Sys_Privilieges;

@Repository
@Transactional
public class PriviliegeDaoImpl extends BaseDaoImpl<Sys_Privilieges> implements PriviliegeDao {

	public List<Sys_Privilieges> findTopPriList() {
		List<Sys_Privilieges> toPrivilieges=null;
		String sql="from  Sys_Privilieges p where p.parent=null";
		Query query=getSession().createQuery(sql);
		toPrivilieges=query.list();
		return toPrivilieges;
	}

	public List<String> findAllUrl() {
		List<String> url=null;
		String sql="select p.url from Sys_Privilieges p";
		Query query=getSession().createQuery(sql);
		url=query.list();
		return url;
	}

}
