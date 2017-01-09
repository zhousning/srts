package com.srts.knowledge.domain;

import com.srts.system.domain.Sys_User;

public class ExperienceSearchRecord {
	private long id;
	private long content_id;
	private Sys_User user;
	private String searchdate;
	public ExperienceSearchRecord(){}
	public ExperienceSearchRecord(long id, long contentId, Sys_User user,
			String searchdate) {
		this.id = id;
		content_id = contentId;
		this.user = user;
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
	public void setContent_id(long contentId) {
		content_id = contentId;
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
