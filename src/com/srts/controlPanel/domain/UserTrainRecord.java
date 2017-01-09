package com.srts.controlPanel.domain;

import com.srts.system.domain.Sys_User;

public class UserTrainRecord {
	private long id;
	private Sys_User usr;
	private String trainDate;
	private String trainContent;
	private String trainTimeLength;
	private String trainOrgCompany;
	private String trainRes;
	public UserTrainRecord(){}
	public UserTrainRecord(long id, Sys_User usr, String trainDate,
			String trainContent, String trainTimeLength,
			String trainOrgCompany, String trainRes) {
		this.id = id;
		this.usr = usr;
		this.trainDate = trainDate;
		this.trainContent = trainContent;
		this.trainTimeLength = trainTimeLength;
		this.trainOrgCompany = trainOrgCompany;
		this.trainRes = trainRes;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Sys_User getUsr() {
		return usr;
	}
	public void setUsr(Sys_User usr) {
		this.usr = usr;
	}
	public String getTrainDate() {
		return trainDate;
	}
	public void setTrainDate(String trainDate) {
		this.trainDate = trainDate;
	}
	public String getTrainContent() {
		return trainContent;
	}
	public void setTrainContent(String trainContent) {
		this.trainContent = trainContent;
	}
	public String getTrainTimeLength() {
		return trainTimeLength;
	}
	public void setTrainTimeLength(String trainTimeLength) {
		this.trainTimeLength = trainTimeLength;
	}
	public String getTrainOrgCompany() {
		return trainOrgCompany;
	}
	public void setTrainOrgCompany(String trainOrgCompany) {
		this.trainOrgCompany = trainOrgCompany;
	}
	public String getTrainRes() {
		return trainRes;
	}
	public void setTrainRes(String trainRes) {
		this.trainRes = trainRes;
	}
	
	

}
