package com.srts.knowledge.domain;

import com.srts.system.domain.Sys_User;

public class Experience {
	private long id;
    private String content;
    private String explaination;
    private String statement;
    private String uploaddate;
	private String updatedate;
	private String checkeddate;

	private Sys_User user;
	private long searchnum;
    public Experience(){}
	public Experience(long id, Sys_User user, String content, String statement,
			String explaination, String uploaddate, String updatedate,
			String checkeddate, long searchnum) {
		this.id = id;
		this.user = user;
		this.content = content;
		this.statement = statement;
		this.explaination = explaination;
		this.uploaddate = uploaddate;
		this.updatedate = updatedate;
		this.checkeddate = checkeddate;
		this.searchnum = searchnum;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Sys_User getUser() {
		return user;
	}
	public void setUser(Sys_User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public String getExplaination() {
		return explaination;
	}
	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public String getCheckeddate() {
		return checkeddate;
	}
	public void setCheckeddate(String checkeddate) {
		this.checkeddate = checkeddate;
	}
	public long getSearchnum() {
		return searchnum;
	}
	public void setSearchnum(long searchnum) {
		this.searchnum = searchnum;
	}
	
}
