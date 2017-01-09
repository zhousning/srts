package com.srts.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.srts.system.dao.Sys_UserDao;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private Sys_UserDao userDao;

	public List<Sys_User> getUserByDepIds(Long[] depIds) {
		return userDao.getUserByDepIds(depIds);
	}

	public List<Sys_User> getUserByDepId(Long depId) {
		return userDao.getUserByDepId(depId);
	}

	public Sys_User getUserById(long id) {
		return userDao.getById(id);
	}

	public List<Sys_User> findAll() {
		return userDao.findAll();
	}

	public void deleteUserById(Long userId) {
		Sys_User user = getUserById(userId);
		user.setDepartment(null);
		updateUser(user);
		userDao.delete(userId);
	}

	public List<Sys_User> getUserListByCon(String userName, Long depId,
			String workNo) {

		return userDao.getUserListByCon(userName, depId, workNo);
	}

	public void updateUser(Sys_User user) {
		String userName=user.getWorkno();
		String password=userName.substring(userName.length()-6, userName.length());
		user.setUsername(userName);
		user.setPassword(DigestUtils.md5Hex(password));
		userDao.update(user);
	}

	public void saveUser(Sys_User user,String workNo) {
		//初始化密码
		String userName=workNo;
		String password=workNo.substring(userName.length()-6, userName.length());
		user.setUsername(userName);
		user.setWorkno(workNo);
		user.setPassword(DigestUtils.md5Hex(password));
		userDao.save(user);
	}

	/**
	 * 随机抽取制定部门指定数量的员工
	 */
	public List<Sys_User> getUsersByRandom(Long[] departmentIds, int counts) {
	 List<Sys_User> users=null;
	 users=userDao.getgetUsersByRandom(departmentIds,counts);
	 return users;
	}

	public List<Sys_User> getUserByIds(Long[] nameArr) {
		List<Sys_User> users=userDao.getByIds(nameArr);
		return users;
	}

	public Sys_User findUserByNamePass(String username, String password) {
		Sys_User user=null;
		user=userDao.findUserByNamePass(username,password);
		return user;
	}

	public void saveAdmin(Sys_User user) {
		userDao.save(user);
	}
	

}
