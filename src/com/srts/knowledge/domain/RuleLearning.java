package com.srts.knowledge.domain;

public class RuleLearning {
	private long id;
	private String bookname;
	private String chaptername;
	private String roleno;
	private String content;
	private String pic;
	private String uploaddate;
	private String updatedate;
	private long searchnum;
	public RuleLearning(){}
	public RuleLearning(long id, String bookname, String chaptername,
			String roleno, String content, String pic, String uploaddate,
			String updatedate, long searchnum) {
		this.id = id;
		this.bookname = bookname;
		this.chaptername = chaptername;
		this.roleno = roleno;
		this.content = content;
		this.pic = pic;
		this.uploaddate = uploaddate;
		this.updatedate = updatedate;
		this.searchnum=searchnum;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getChaptername() {
		return chaptername;
	}
	public void setChaptername(String chaptername) {
		this.chaptername = chaptername;
	}
	public String getRoleno() {
		return roleno;
	}
	public void setRoleno(String roleno) {
		this.roleno = roleno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
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
	public long getSearchnum() {
		return searchnum;
	}
	public void setSearchnum(long searchnum) {
		this.searchnum = searchnum;
	}
	

}
