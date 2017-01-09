package com.srts.knowledge.po;

public class RuleLearningDispPo {
	private String id;
	private String bookname;
	private String chaptername;
	private String ruleno;
	private String content;
	public RuleLearningDispPo(){}
	public RuleLearningDispPo(String id, String bookname, String chaptername,
			String ruleno, String content) {
		this.id = id;
		this.bookname = bookname;
		this.chaptername = chaptername;
		this.ruleno = ruleno;
		this.content = content;
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
	public String getRuleno() {
		return ruleno;
	}
	public void setRuleno(String ruleno) {
		this.ruleno = ruleno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
