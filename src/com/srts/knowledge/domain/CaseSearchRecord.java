package com.srts.knowledge.domain;

import com.srts.system.domain.Sys_User;

public class CaseSearchRecord {
	private long id;
	private long content_id;
	private Sys_User user;
	private String searchdate;
	public CaseSearchRecord(){}
	public CaseSearchRecord(long id, long content_id, Sys_User user,
			String searchdate) {
		this.id = id;
		this.content_id = content_id;
		this.user=user;
		this.searchdate = searchdate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getContent_id() {
		return content_id;
	}
	public void setContent_id(long content_id) {
		this.content_id = content_id;
	}
	public Sys_User getUser() {
		return user;
	}
	public void setUser(Sys_User user) {
		this.user = user;
	}
	public String getSearchdate() {
		return searchdate;
	}
	public void setSearchdate(String searchdate) {
		this.searchdate = searchdate;
	}
	

}
