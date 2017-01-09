package com.srts.estimation.po;

public class CompanyEstimateInfoPo {
	private String id;
	private String type;
	private String estString;
	public CompanyEstimateInfoPo(){}
	public CompanyEstimateInfoPo(String id, String type, String estString) {
		this.id = id;
		this.type = type;
		this.estString = estString;
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
	public String getEstString() {
		return estString;
	}
	public void setEstString(String estString) {
		this.estString = estString;
	}
	

}
