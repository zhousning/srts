package com.srts.estimation.po;

public class UserKlgBankSearchRecordPo {
	private String id;
	private String searchdate;
	private String content1;
	private String content2;
	private String content3;
	public UserKlgBankSearchRecordPo(){}
	public UserKlgBankSearchRecordPo(String id, String searchdate,
			String content1, String content2, String content3) {
		this.id = id;
		this.searchdate = searchdate;
		this.content1 = content1;
		this.content2 = content2;
		this.content3 = content3;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSearchdate() {
		return searchdate;
	}
	public void setSearchdate(String searchdate) {
		this.searchdate = searchdate;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public String getContent3() {
		return content3;
	}
	public void setContent3(String content3) {
		this.content3 = content3;
	}
	

}
