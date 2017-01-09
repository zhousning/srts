package com.srts.knowledge.domain;

public class WorkSheet {
	private long id;
	private String company;
	private String title;
	private String type;
	private String url;
	private String uploaddate;
	private String updatedate;
	private String tips;
	public WorkSheet(){}
	public WorkSheet(long id, String company, String title, String type,
			String url, String uploaddate, String updatedate, String tips) {
		this.id = id;
		this.company = company;
		this.title = title;
		this.type = type;
		this.url = url;
		this.uploaddate = uploaddate;
		this.updatedate = updatedate;
		this.tips = tips;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	

}
