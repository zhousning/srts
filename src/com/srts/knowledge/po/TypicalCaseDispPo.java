package com.srts.knowledge.po;

public class TypicalCaseDispPo {
	private String id;
	private String title;
	private String date;
	private String content;
	public TypicalCaseDispPo(){}
	public TypicalCaseDispPo(String id, String title, String date,
			String content) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.content = content;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
}
