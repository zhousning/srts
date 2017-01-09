package com.srts.estimation.po;

public class UserTestEstimateInfoPo {
	private String id;
	private String type;
	private String estimateString;
	public UserTestEstimateInfoPo(){}
	public UserTestEstimateInfoPo(String id, String type, String estimateString) {
		this.id = id;
		this.type = type;
		this.estimateString = estimateString;
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
	public String getEstimateString() {
		return estimateString;
	}
	public void setEstimateString(String estimateString) {
		this.estimateString = estimateString;
	}
	

}
