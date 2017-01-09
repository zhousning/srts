package com.srts.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.system.dao.RoleDao;
import com.srts.system.domain.Sys_Role;
import com.srts.system.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleDao roleDao;

	public List<Sys_Role> findAll() {
		List<Sys_Role> roles=null;
		roles=roleDao.findAll();
		return roles;
	}

	public Sys_Role findById(long roleId) {
		Sys_Role role=null;
		role=roleDao.getById(roleId);
		return role;
	}

	public void update(Sys_Role role) {
	roleDao.update(role);
		
	}

	public void saveRole(Sys_Role role) {
		roleDao.save(role);
	}

	public List<Sys_Role> findByIds(Long[] roleIds) {
		List<Sys_Role> roles=null;
		roles=roleDao.getByIds(roleIds);
		return roles;
	}




}
