package com.srts.system.domain;

import java.util.HashSet;
import java.util.Set;


public class Sys_Privilieges {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Sys_Privilieges parent;
	private Set<Sys_Privilieges> children = new HashSet<Sys_Privilieges>();
	private Set<Sys_Role> roles=new HashSet<Sys_Role>();

	private String url; // 对应的功能链接地址
	private String name; // 名称（要唯一）
	private String icon; // 图标（只有一级菜单用）
	
	public Sys_Privilieges(){}
	
	

	public Sys_Privilieges( String name, String url,
			String icon,Sys_Privilieges parent) {
		super();
		this.parent = parent;
		this.url = url;
		this.name = name;
		this.icon = icon;
	}



	public Set<Sys_Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Sys_Role> roles) {
		this.roles = roles;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sys_Privilieges getParent() {
		return parent;
	}

	public void setParent(Sys_Privilieges parent) {
		this.parent = parent;
	}

	public Set<Sys_Privilieges> getChildren() {
		return children;
	}

	public void setChildren(Set<Sys_Privilieges> children) {
		this.children = children;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	
	

}
