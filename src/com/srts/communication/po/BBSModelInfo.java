package com.srts.communication.po;

/**
* 类描述：用于显示贴吧板块的帖子数和活跃人数
* 创建人：vector   
* 创建时间：2014-10-21 下午03:39:30   
* 备注：用于显示贴吧模块信息 模块名称 帖子数量 活跃人数
 */
public class BBSModelInfo {
	//板块名称
	private String modelName;
	//帖子数
	private String articalNum;
	//活跃人数
	private String activePersonNum;
	
	public String getArticalNum() {
		return articalNum;
	}
	public void setArticalNum(String articalNum) {
		this.articalNum = articalNum;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getActivePersonNum() {
		return activePersonNum;
	}
	public void setActivePersonNum(String activePersonNum) {
		this.activePersonNum = activePersonNum;
	}

}
