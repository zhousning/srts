package com.srts.system.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.system.domain.Sys_Privilieges;

public interface PriviliegeDao extends BaseDao<Sys_Privilieges> {

	List<Sys_Privilieges> findTopPriList();

	List<String> findAllUrl();

}
