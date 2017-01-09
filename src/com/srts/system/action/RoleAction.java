package com.srts.system.action;

import java.util.HashSet;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import antlr.collections.List;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.system.domain.Sys_Privilieges;
import com.srts.system.domain.Sys_Role;
import com.srts.system.service.PriviliegeService;
import com.srts.system.service.RoleService;

@Controller
@Scope("prototype")
public class RoleAction extends BaseActionImpl<Sys_Role> {
	private static final long serialVersionUID = 1L;

	@Resource
	private RoleService roleService;
	@Resource
	private PriviliegeService priviliegeService;
	
	private java.util.List<Sys_Role> roleList;
	private java.util.List<Sys_Privilieges> privilegeList;
	private java.util.List<Sys_Privilieges> rolePri;
	private Sys_Role role;
	private Long[] privilegeIds;
	private Long roleId;
	private String name;

	public Sys_Role getModel() {
		if (role == null) {
			role = new Sys_Role();
		}
		return role;
	}
	
	public String roleList() {
		roleList = roleService.findAll();
		return "roleList";
	}

	public String roleDisp() {
		if (roleId != null) {
			role = roleService.findById(roleId);
		}
		ActionContext.getContext().getValueStack().push(role);
		return "roleDisp";
	}

	public String saveRole() {
		System.out.println("&&&&&&&&&%%%%%%%%");
		System.out.println(role.getName());
		roleService.saveRole(role);
		return "toRoleList";
	}

	public String updateRole() {
		Sys_Role role=roleService.findById(roleId);
		role.setName(name);
		System.out.println("name" + name);
		roleService.update(role);
		return "toRoleList";
	}

	public String setPriviliegeUi() {
		privilegeList = priviliegeService.findTopPriList();
		System.out.println(roleId + "&&&&&&&&&&");
		role = roleService.findById(roleId);

		privilegeIds = new Long[role.getPrivilieges().size()];
		int i = 0;
		for (Sys_Privilieges p : role.getPrivilieges()) {
			System.out.println(p.getId() + "%%%%" + p.getName());
			privilegeIds[i++] = p.getId();
		}

		return "setPriviliegeUi";
	}

	public String setPrivilege() {
		Sys_Role role = null;
		System.out.println(roleId + "%&%&%&%&");
		role = roleService.findById(roleId);

		for (int i = 0; i < privilegeIds.length; i++) {
			System.out.println(privilegeIds[i] + "______________");
		}

		rolePri = priviliegeService.findByIds(privilegeIds);

		for (Sys_Privilieges pr : rolePri) {
			System.out.println(pr.getName() + "^^^^^^^");
		}
		role.setPrivilieges(new HashSet<Sys_Privilieges>(rolePri));
		roleService.update(role);
		return "toRoleList";
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sys_Role getRole() {
		return role;
	}

	public void setRole(Sys_Role role) {
		this.role = role;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public java.util.List<Sys_Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(java.util.List<Sys_Role> roleList) {
		this.roleList = roleList;
	}

	public java.util.List<Sys_Privilieges> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(java.util.List<Sys_Privilieges> privilegeList) {
		this.privilegeList = privilegeList;
	}

	public java.util.List<Sys_Privilieges> getRolePri() {
		return rolePri;
	}

	public void setRolePri(java.util.List<Sys_Privilieges> rolePri) {
		this.rolePri = rolePri;
	}

	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}


	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

}
