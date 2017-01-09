package com.srts.system.service;

import java.util.List;

import com.srts.system.domain.Sys_Role;

public interface RoleService {

	List<Sys_Role> findAll();

	Sys_Role findById(long roleId);

	void update(Sys_Role role);

	void saveRole(Sys_Role role);

	List<Sys_Role> findByIds(Long[] roleIds);




}
