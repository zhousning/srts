package com.srts.knowledge.po;

public class WholeTypicalViolationPo {
	private String id;
	private String title;
	private String content;
	private String searchnum;
	private String uploaddate;
	private String updatedate;
	private String type;
	private String serialnumber;
	public WholeTypicalViolationPo(){}
	public WholeTypicalViolationPo(String id, String title, String content,
		String searchnum, String uploaddate, String updatedate, String type, String serialnumber) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.searchnum = searchnum;
		this.uploaddate = uploaddate;
		this.updatedate = updatedate;
		this.type = type;
		this.serialnumber = serialnumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSearchnum() {
		return searchnum;
	}
	public void setSearchnum(String searchnum) {
		this.searchnum = searchnum;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	

}
