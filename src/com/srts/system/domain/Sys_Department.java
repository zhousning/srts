package com.srts.system.domain;

import java.util.HashSet;
import java.util.Set;

public class Sys_Department {
	private long id;
	private Sys_Department parentdept;
	private Set<Sys_Department> childrenDepartment=new HashSet<Sys_Department>();
	private Set<Sys_User> users=new HashSet<Sys_User>();
	
	private String name;
	
	public Sys_Department(){}
	
	public Sys_Department(long id, Sys_Department parentdept,
			Set<Sys_Department> childrenDepartment, String name) {
		super();
		this.id = id;
		this.parentdept = parentdept;
		this.childrenDepartment = childrenDepartment;
		this.name = name;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Sys_Department getParentdept() {
		return parentdept;
	}
	public void setParentdept(Sys_Department parentdept) {
		this.parentdept = parentdept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Sys_Department> getChildrenDepartment() {
		return childrenDepartment;
	}
	public void setChildrenDepartment(Set<Sys_Department> childrenDepartment) {
		this.childrenDepartment = childrenDepartment;
	}
	public Set<Sys_User> getUsers() {
		return users;
	}

	public void setUsers(Set<Sys_User> users) {
		this.users = users;
	}
}
