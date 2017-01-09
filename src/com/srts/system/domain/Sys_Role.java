package com.srts.system.domain;

import java.util.HashSet;
import java.util.Set;

public class Sys_Role {
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private Set<Sys_User> users = new HashSet<Sys_User>();
	private Set<Sys_Privilieges> privilieges = new HashSet<Sys_Privilieges>();

	public Sys_Role() {
	}

	public Set<Sys_Privilieges> getPrivilieges() {
		return privilieges;
	}

	public void setPrivilieges(Set<Sys_Privilieges> privilieges) {
		this.privilieges = privilieges;
	}

	public Set<Sys_User> getUsers() {
		return users;
	}

	public void setUsers(Set<Sys_User> users) {
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
