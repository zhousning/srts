package com.srts.knowledge.po;

public class ExperienceDispPo {
	private String id;
	private String content;
	public ExperienceDispPo(){}
	public ExperienceDispPo(String id, String content) {
		this.id = id;
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
