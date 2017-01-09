package com.srts.controlPanel.po;

public class FavorKlgBankInfoPo {
	private String id;
	private String viewCount;
	private String type;
	private String title;
	public FavorKlgBankInfoPo(){}
	public FavorKlgBankInfoPo(String id, String viewCount, String type,
			String title) {
		this.id = id;
		this.viewCount = viewCount;
		this.type = type;
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

}
