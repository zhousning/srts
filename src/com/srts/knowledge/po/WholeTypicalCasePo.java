package com.srts.knowledge.po;

public class WholeTypicalCasePo {
	private String id;
	private String title;
	private String content;
	private String type;
	private String searchnum;
	private String uploaddate;
	private String updatedate;
	private String serialnumber;
	private String pic;
	public WholeTypicalCasePo(){}
	public WholeTypicalCasePo(String id, String title, String content,
			String type, String searchnum, String uploaddate, String updatedate, String serialnumber, String pic) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.type = type;
		this.searchnum = searchnum;
		this.uploaddate = uploaddate;
		this.updatedate = updatedate;
		this.serialnumber = serialnumber;
		this.pic=pic;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getSearchnum() {
		return searchnum;
	}
	public void setSearchnum(String searchnum) {
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
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	

}
