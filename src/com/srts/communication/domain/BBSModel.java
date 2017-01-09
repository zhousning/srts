package com.srts.communication.domain;

/**
 * 帖子模块
 * @author wyw
 */
public class BBSModel {
	private long id;//主键id
	private String modelName;//模块名称
	private String description;//模块描述
	private long articalCount;//帖子总数
	private int position;//模块位置
	
	public BBSModel() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getArticalCount() {
		return articalCount;
	}

	public void setArticalCount(long articalCount) {
		this.articalCount = articalCount;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
}
