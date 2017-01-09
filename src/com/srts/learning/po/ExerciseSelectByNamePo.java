package com.srts.learning.po;
/**
 * 
 * @author H 2014-5-24 下午02:26:58
 *
 */
public class ExerciseSelectByNamePo {

	private String bookId;
	private String bookName;
	private String chapterId;
	private String chapterNum;
	private String chapterName;
	public ExerciseSelectByNamePo(){
	}
	public ExerciseSelectByNamePo(String bookId, String bookName, String chapterId, String chapterNum, String chapterName){
		this.bookId=bookId;
		this.bookName=bookName;
		this.chapterId=chapterId;
		this.chapterNum=chapterNum;
		this.chapterName=chapterName;
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getChapterId() {
		return chapterId;
	}
	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
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

}
