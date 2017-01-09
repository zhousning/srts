package com.srts.controlPanel.po;

public class MyThemeInfoPo {
	private String id;
	private String articleTitle;
	private String articleDate;
	private String userName;
	private String replyCount;
	public MyThemeInfoPo(){}
	public MyThemeInfoPo(String id, String articleTitle, String articleDate,
			String userName, String replyCount) {
		this.id = id;
		this.articleTitle = articleTitle;
		this.articleDate = articleDate;
		this.userName = userName;
		this.replyCount = replyCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleDate() {
		return articleDate;
	}
	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(String replyCount) {
		this.replyCount = replyCount;
	}
	

}
