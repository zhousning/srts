package com.srts.communication.po;
/**
* 类描述：用于显示谁回复了谁什么信息 在哪个专区的类
* 创建人：vector   
* 创建时间：2014-11-3 上午10:26:48   
* 备注：
 */
public class ReplyContent {
	//回复人名称
	private String name;
	//回复内容
	private String content;
	//帖子标题
	private String title;
	//专区名称
	private String modelName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
}
