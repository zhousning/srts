package com.srts.knowledge.po;

import com.srts.system.domain.Sys_User;

public class WholeExperiencePo {
	private String id;
	private String user;
	private String contentSe;
    private String content;
    private String statement;
    private String explaination;
    private String uploaddate;
	private String updatedate;
	private String checkeddate;
	private String searchnum;
	private String serialnumber;
	public WholeExperiencePo(){}
	public WholeExperiencePo(String id, String user, String contentSe, String content,
			String statement, String explaination, String uploaddate,
			String updatedate, String checkeddate, String searchnum, String serialnumber) {
		this.id = id;
		this.user = user;
		this.contentSe = contentSe;
		this.content = content;
		this.statement = statement;
		this.explaination = explaination;
		this.uploaddate = uploaddate;
		this.updatedate = updatedate;
		this.checkeddate = checkeddate;
		this.searchnum = searchnum;
		this.serialnumber = serialnumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
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
	public String getContentSe() {
		return contentSe;
	}
	public void setContentSe(String contentSe) {
		this.contentSe = contentSe;
	}
	public String getSearchnum() {
		return searchnum;
	}
	public void setSearchnum(String searchnum) {
		this.searchnum = searchnum;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	

}
