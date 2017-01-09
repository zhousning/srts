package com.srts.controlPanel.po;

public class MyKlgUploadInfoPo {
	private String id;
	private String klgContent;
	private String klgDate;
	private String type;
	public MyKlgUploadInfoPo(){}
	public MyKlgUploadInfoPo(String id,String klgContent, String klgDate, String type) {
		this.id=id;
		this.klgContent = klgContent;
		this.klgDate = klgDate;
		this.type = type;
	}
	public String getKlgContent() {
		return klgContent;
	}
	public void setKlgContent(String klgContent) {
		this.klgContent = klgContent;
	}
	public String getKlgDate() {
		return klgDate;
	}
	public void setKlgDate(String klgDate) {
		this.klgDate = klgDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
