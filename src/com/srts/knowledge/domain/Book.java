package com.srts.knowledge.domain;

import java.util.HashSet;
import java.util.Set;

public class Book {
	private static final long serialVersionUID = 1L;
	private long id;//主键id
	private String bookName;//培训书名
	private String bookIntro;//简介
	private Set<BookChapter> chapters=new HashSet<BookChapter>();//书中章节
	private String date;//上传时间
	private String bookIcon;//书的图标
	private String uploadUsr;//上传者
	private long viewCount;//浏览量
	private String saveURL;  //ppt保存路径
	private long loadCount;  //下载统计
	public Book(){}
	
	public Book(long id, String bookName, String bookIntro,
			Set<BookChapter> chapters, String date, String bookIcon,
			String uploadUsr, long viewCount, String saveURL, long loadCount) {
		this.id = id;
		this.bookName = bookName;
		this.bookIntro = bookIntro;
		this.chapters = chapters;
		this.date = date;
		this.bookIcon = bookIcon;
		this.uploadUsr = uploadUsr;
		this.viewCount = viewCount;
		this.saveURL=saveURL;
		this.loadCount=loadCount;
	}

	public String getUploadUsr() {
		return uploadUsr;
	}
	public void setUploadUsr(String uploadUsr) {
		this.uploadUsr = uploadUsr;
	}
	public String getBookIntro() {
		return bookIntro;
	}
	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}
	public long getViewCount() {
		return viewCount;
	}
	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Set<BookChapter> getChapters() {
		return chapters;
	}
	public void setChapters(Set<BookChapter> chapters) {
		this.chapters = chapters;
	}
	public String getBookIcon() {
		return bookIcon;
	}
	public void setBookIcon(String bookIcon) {
		this.bookIcon = bookIcon;
	}

	public String getSaveURL() {
		return saveURL;
	}

	public void setSaveURL(String saveURL) {
		this.saveURL = saveURL;
	}

	public long getLoadCount() {
		return loadCount;
	}
	public void setLoadCount(long loadCount) {
		this.loadCount = loadCount;
	}
	
}
