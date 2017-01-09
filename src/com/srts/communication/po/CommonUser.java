package com.srts.communication.po;

/**
* 类描述：记录一个人 及其在提问或者回答或者被采纳 的数量
* 创建人：vector   
* 创建时间：2014-7-12 下午05:03:27   
* 备注：
 */
public class CommonUser {
	private String userName;
	private String id;
	private String num;
	
	public CommonUser(String userName, String num) {
		this.userName = userName;
		this.num = num;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	
}
