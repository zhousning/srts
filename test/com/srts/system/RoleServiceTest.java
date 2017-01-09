package com.srts.system;

import org.junit.Test;

import com.srts.common.CommonTest;
import com.srts.system.domain.Sys_Role;
import com.srts.system.service.RoleService;

public class RoleServiceTest extends CommonTest{

	private RoleService roleService;
	
	public void init(){
		roleService=(RoleService) act.getBean("roleServiceImpl");
	}
	@Test
	public void testP() {
		init();
		long roleId=4;
		Sys_Role role=roleService.findById(roleId);
		System.out.println(role.getPrivilieges().size());
	}
}
