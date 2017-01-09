package com.srts.knowledge.po;

public class WholeRuleLearningPo {
	private String id;
	private String bookname;
	private String chaptername;
	private String roleno;
	private String contentSe;
	private String content;
	private String pic;
	private String uploaddate;
	private String updatedate;
	private String searchnum;
	private String serialnumber;
	public WholeRuleLearningPo(){}
	public WholeRuleLearningPo(String id, String bookname, String chaptername,
			String roleno, String contentSe, String content, String pic, String uploaddate,
			String updatedate, String searchnum, String serialnumber) {
		this.id = id;
		this.bookname = bookname;
		this.chaptername = chaptername;
		this.roleno = roleno;
		this.contentSe = contentSe;
		this.content = content;
		this.pic = pic;
		this.uploaddate = uploaddate;
		this.updatedate = updatedate;
		this.searchnum = searchnum;
		this.serialnumber = serialnumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getSearchnum() {
		return searchnum;
	}
	public void setSearchnum(String searchnum) {
		this.searchnum = searchnum;
	}
	public String getContentSe() {
		return contentSe;
	}
	public void setContentSe(String contentSe) {
		this.contentSe = contentSe;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	

}
