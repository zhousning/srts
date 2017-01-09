package com.srts.knowledge.domain;

public class BookChapterContent {
	private static final long serialVersionUID = 1L;
	private long id;
	private String contentName;//小节名
	private String content;//小节内容
	private BookChapter chapter;//所在章节
	public BookChapterContent(){}
	public BookChapterContent(long id, String contentName, String content,
			BookChapter chapter) {
		this.id = id;
		this.contentName = contentName;
		this.content = content;
		this.chapter = chapter;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BookChapter getChapter() {
		return chapter;
	}
	public void setChapter(BookChapter chapter) {
		this.chapter = chapter;
	}
}
