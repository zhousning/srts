package com.srts.controlPanel.po;

public class MyNoticeInfoPo {
	private String id;
	private String type;
	private String title;
	private String content;
	public MyNoticeInfoPo(){}
	public MyNoticeInfoPo(String id, String type, String title, String content) {
		this.id = id;
		this.type=type;
		this.title = title;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
