package com.srts.system.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.system.domain.Sys_User;

public interface Sys_UserDao extends BaseDao<Sys_User>{

	List<Sys_User> getUserByDepIds(Long[] depIds);
	
	List<Sys_User> getUserByDepId(Long depId);

	List<Sys_User> getUserListByCon(String userName, Long depId, String workNo);

	void deleteById(Long userId);

	List<Sys_User> getgetUsersByRandom(Long[] departmentIds, int counts);

	Sys_User findUserByNamePass(String username, String password);

}
