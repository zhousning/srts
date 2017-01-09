package com.srts.knowledge.domain;

import java.util.HashSet;
import java.util.Set;

public class BookChapter {
	private static final long serialVersionUID = 1L;
	private long id;//主键id
	private String chapterNum;//章节号
	private String chapterName;//章节名
	private Book book;//书id
	private Set<BookChapterContent> contents=new HashSet<BookChapterContent>();//章节里的小节
	public BookChapter(){}
	public BookChapter(long id, String chapterNum, String chapterName,
			Book book, Set<BookChapterContent> contents) {
		this.id = id;
		this.chapterNum = chapterNum;
		this.chapterName = chapterName;
		this.book = book;
		this.contents = contents;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getChapterNum() {
		return chapterNum;
	}
	public void setChapterNum(String chapterNum) {
		this.chapterNum = chapterNum;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Set<BookChapterContent> getContents() {
		return contents;
	}
	public void setContents(Set<BookChapterContent> contents) {
		this.contents = contents;
	}
}
