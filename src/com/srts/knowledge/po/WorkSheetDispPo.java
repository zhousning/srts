package com.srts.knowledge.po;

public class WorkSheetDispPo {
	private String id;
	private String company;
	private String title;
	private String content;
	public WorkSheetDispPo(){}
	public WorkSheetDispPo(String id, String company, String title,
			String content) {
		this.id = id;
		this.company = company;
		this.title = title;
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
