package com.srts.knowledge.domain;

import java.util.Date;

import com.srts.system.domain.Sys_User;

public class OnlineCourseVideo {
	private long id;
	private String videoName;  //视频名称
	private String videoIntro; //视频简介
	private String saveURL;    //保存路径
	private String videoImgURL;//Img路径
	private String uploadDate;   //上传日期
	private long viewCount;    //阅读统计
	private long loadCount;    //下载统计
	private String uploadUsr;      //上传者，管理员，老师。
	
	public OnlineCourseVideo(){}
	
	public OnlineCourseVideo(long id, String videoName, String videoIntro,
			String saveURL, String videoImgURL, String uploadDate,
			long viewCount, long loadCount, String uploadUsr) {
		this.id = id;
		this.videoName = videoName;
		this.videoIntro = videoIntro;
		this.saveURL = saveURL;
		this.videoImgURL = videoImgURL;
		this.uploadDate = uploadDate;
		this.viewCount = viewCount;
		this.loadCount = loadCount;
		this.uploadUsr = uploadUsr;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getSaveURL() {
		return saveURL;
	}
	public void setSaveURL(String saveURL) {
		this.saveURL = saveURL;
	}
	public String getVideoImgURL() {
		return videoImgURL;
	}
	public void setVideoImgURL(String videoImgURL) {
		this.videoImgURL = videoImgURL;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public long getViewCount() {
		return viewCount;
	}
	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}
	
	public long getLoadCount() {
		return loadCount;
	}

	public void setLoadCount(long loadCount) {
		this.loadCount = loadCount;
	}
	public String getUploadUsr() {
		return uploadUsr;
	}
	public void setUploadUsr(String uploadUsr) {
		this.uploadUsr = uploadUsr;
	}
	public String getVideoIntro() {
		return videoIntro;
	}
	public void setVideoIntro(String videoIntro) {
		this.videoIntro = videoIntro;
	}
}	
