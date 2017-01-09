package com.srts.communication.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.srts.system.domain.Sys_User;
/**
 * 帖子
 * @author wyw
 */
public class BBSArtical {
	private long id;//主键id
	private String articalTile;//帖子主题
	private String articalContent;//帖子内容
	private Date articalDate;//发表时间
	private String date;
	private int weight;//置顶
	private int viewCount;//浏览次数
	private int replyCount;//回复次数
	private Sys_User usr;//发表员工
	private BBSModel model;//所在模块
	
	public BBSArtical() {
	}
	public BBSArtical(long id, String articalTile, String articalContent,
			Date articalDate, int weight, Sys_User usr, BBSModel model) {
		this.id = id;
		this.articalTile = articalTile;
		this.articalContent = articalContent;
		this.articalDate = articalDate;
		this.weight = weight;
		this.usr = usr;
		this.model = model;
	}
	public BBSArtical(long articalId) {
		this.id=articalId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getArticalTile() {
		return articalTile;
	}
	public void setArticalTile(String articalTile) {
		this.articalTile = articalTile;
	}
	public String getArticalContent() {
		return articalContent;
	}
	public void setArticalContent(String articalContent) {
		this.articalContent = articalContent;
	}
	public Date getArticalDate() {
		return articalDate;
	}
	public void setArticalDate(Date articalDate) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.date=sdf.format(articalDate);
		this.articalDate = articalDate;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Sys_User getUsr() {
		return usr;
	}
	public void setUsr(Sys_User usr) {
		this.usr = usr;
	}
	public BBSModel getModel() {
		return model;
	}
	public void setModel(BBSModel model) {
		this.model = model;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	
}
