package com.srts.knowledge.domain;

public class TypicalCase {
	private long id;
	private String title;
	private String content;
	private String type;
	private String pic;
	private Long searchnum;
	private String uploaddate;
	private String updatedate;

	public TypicalCase(){}
	
	

	public TypicalCase(long id, String title, String content, String type,
			String pic, Long searchnum, String uploaddate, String updatedate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.type = type;
		this.pic = pic;
		this.searchnum = searchnum;
		this.uploaddate = uploaddate;
		this.updatedate = updatedate;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Long getSearchnum() {
		return searchnum;
	}
	public void setSearchnum(Long searchnum) {
		this.searchnum = searchnum;
	}
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	

}
