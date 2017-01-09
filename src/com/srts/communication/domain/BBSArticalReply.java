package com.srts.communication.domain;

 
import java.text.SimpleDateFormat;
import java.util.Date;

import com.srts.system.domain.Sys_User;

/**
 * 帖子回复
 * @author wyw
 */
public class BBSArticalReply {
	private long id;//主键id
	private String replyContent;//回复内容
	private Date relayDate;//回复日期
	private Sys_User usr;//回复的员工
	private BBSArtical artical;//回复的帖子
	private String date;//用于时间显示
	
	public BBSArticalReply() {
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getRelayDate() {
		return relayDate;
	}
	public void setRelayDate(Date relayDate) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.date=sdf.format(relayDate);
		this.relayDate = relayDate;
	}
	public BBSArtical getArtical() {
		return artical;
	}
	public void setArtical(BBSArtical artical) {
		this.artical = artical;
	}
	
	public Sys_User getUsr() {
		return usr;
	}
	public void setUsr(Sys_User usr) {
		this.usr = usr;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
