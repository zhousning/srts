package com.srts.system.service;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.system.domain.Sys_User;

public interface UserService {

	public List<Sys_User> getUserByDepIds(Long[] depIds);
	
	public List<Sys_User> getUserByDepId(Long depId);

	public Sys_User getUserById(long id);

	public List<Sys_User> findAll();

	public void deleteUserById(Long userId);

	public List<Sys_User> getUserListByCon(String userName, Long depId,
			String workNo);

	public void updateUser(Sys_User user);

	public void saveUser(Sys_User user, String workNo);

	public List<Sys_User> getUsersByRandom(Long[] departmentIds, int counts);

	public List<Sys_User> getUserByIds(Long[] nameArr);

	public Sys_User findUserByNamePass(String username, String password);

	public void saveAdmin(Sys_User user);
}
