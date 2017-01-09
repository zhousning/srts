package com.srts.knowledge.domain;

import java.util.Date;

import com.srts.system.domain.Sys_User;

/**
 * 在线学习ppt
 * @author wyw
 *
 */
public class OnlineCoursePPT {
	private long id;         //主键id
	private String pptName;  //ppt名称
	private String pptIntro; //ppt简介
	private String saveURL;  //ppt保存路径
	private String pptImgURL;//pptImg路径
	private String uploadDate; //上传日期
	private long readCount;  //阅读统计
	private long loadCount;  //下载统计
	private String uploadUsr;//上传者    //上传者，管理员，老师。
	
	
	public OnlineCoursePPT() {}
	
	public OnlineCoursePPT(long id, String pptName, String pptIntro,
			String saveURL, String pptImgURL, String uploadDate, long readCount,
			long loadCount, String uploadUsr) {
		this.id = id;
		this.pptName = pptName;
		this.pptIntro = pptIntro;
		this.saveURL = saveURL;
		this.pptImgURL = pptImgURL;
		this.uploadDate = uploadDate;
		this.readCount = readCount;
		this.loadCount = loadCount;
		this.uploadUsr = uploadUsr;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPptName() {
		return pptName;
	}
	public void setPptName(String pptName) {
		this.pptName = pptName;
	}
	public String getSaveURL() {
		return saveURL;
	}
	public void setSaveURL(String saveURL) {
		this.saveURL = saveURL;
	}
	public String getPptImgURL() {
		return pptImgURL;
	}
	public void setPptImgURL(String pptImgURL) {
		this.pptImgURL = pptImgURL;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public long getReadCount() {
		return readCount;
	}
	public void setReadCount(long readCount) {
		this.readCount = readCount;
	}
	public String getUploadUsr() {
		return uploadUsr;
	}

	public void setUploadUsr(String uploadUsr) {
		this.uploadUsr = uploadUsr;
	}

	public long getLoadCount() {
		return loadCount;
	}
	public void setLoadCount(long loadCount) {
		this.loadCount = loadCount;
	}
	public String getPptIntro() {
		return pptIntro;
	}
	public void setPptIntro(String pptIntro) {
		this.pptIntro = pptIntro;
	}
}
