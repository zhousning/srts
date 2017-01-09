package com.srts.communication.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.srts.system.domain.Sys_User;

/**
* 类描述：对回复的回复
* 创建人：vector   
* 创建时间：2014-7-19 上午11:53:35   
* 备注：
 */
public class BBSReplyReply {
	private long id;//主键id
	private String replyContent;//回复内容
	private Date relayDate;//回复日期
	private Sys_User usrReply;//被回复的员工
	private Sys_User usr;//回复的员工(保存时为自己)
	private BBSArticalReply  articalReply;//父级-回帖
	private String date;//用于时间显示
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
	public Sys_User getUsrReply() {
		return usrReply;
	}
	public void setUsrReply(Sys_User usrReply) {
		this.usrReply = usrReply;
	}
	public Sys_User getUsr() {
		return usr;
	}
	public void setUsr(Sys_User usr) {
		this.usr = usr;
	}
	
	public BBSArticalReply getArticalReply() {
		return articalReply;
	}
	public void setArticalReply(BBSArticalReply articalReply) {
		this.articalReply = articalReply;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
