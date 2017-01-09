package com.srts.communication.po;
/**
* 类描述：专区达人  用于显示上个月份的每个专区的发帖数最多的人
* 创建人：vector
* 创建时间：2014-10-21 下午09:36:24   
* 备注：包含：模块名称  人名 发帖数目
 */
public class MonthTop {
	
	//模块名称
	private String modleName;
	//人名
	private String userName;
	//发帖数目
	private String articalNum;
	public String getModleName() {
		return modleName;
	}
	public void setModleName(String modleName) {
		this.modleName = modleName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getArticalNum() {
		return articalNum;
	}
	public void setArticalNum(String articalNum) {
		this.articalNum = articalNum;
	}
	

}
