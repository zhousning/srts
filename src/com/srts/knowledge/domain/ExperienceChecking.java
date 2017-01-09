package com.srts.knowledge.domain;

import com.srts.system.domain.Sys_User;

public class ExperienceChecking {
	private long id;
	private Sys_User uploader;
	private String uploaddate;
	private Experience experience;
	public ExperienceChecking(){}
	public ExperienceChecking(long id, Sys_User uploader, String uploaddate,
			Experience experience) {
		this.id = id;
		this.uploader = uploader;
		this.uploaddate = uploaddate;
		this.experience = experience;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Sys_User getUploader() {
		return uploader;
	}
	public void setUploader(Sys_User uploader) {
		this.uploader = uploader;
	}
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public Experience getExperience() {
		return experience;
	}
	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	

}
