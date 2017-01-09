package com.srts.knowledge.po;

public class KlgBankDispSePo {
	private String id;
	private String type;
	private String contentSe;
	private String lastUpdateDate;
	public KlgBankDispSePo(){}
	public KlgBankDispSePo(String id, String type, String contentSe,
			String lastUpdateDate) {
		this.id = id;
		this.type = type;
		this.contentSe = contentSe;
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContentSe() {
		return contentSe;
	}
	public void setContentSe(String contentSe) {
		this.contentSe = contentSe;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	

}
