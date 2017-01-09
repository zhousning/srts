package com.srts.estimation.po;

public class UserEstimatePo {
	private String id;
	private String type;
	private String estimateInfo;
	public UserEstimatePo(){}
	public UserEstimatePo(String id, String type, String estimateInfo) {
		this.id = id;
		this.type = type;
		this.estimateInfo = estimateInfo;
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
	public String getEstimateInfo() {
		return estimateInfo;
	}
	public void setEstimateInfo(String estimateInfo) {
		this.estimateInfo = estimateInfo;
	}
	

}
