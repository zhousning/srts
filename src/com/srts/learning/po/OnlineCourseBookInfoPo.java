package com.srts.learning.po;

import java.util.ArrayList;
import java.util.List;

import com.srts.knowledge.domain.Book;

/**
 * 用于封装List<Book>，
 * @author wyw
 *
 */
public class OnlineCourseBookInfoPo {
	private long totalPage;
	private List<Book> bookInfos = new ArrayList<Book>();
	private List<String> pageLi = new ArrayList<String>();
	
	public OnlineCourseBookInfoPo(){}
	public OnlineCourseBookInfoPo(long totalPage, List<Book> bookInfos) {
		this.totalPage = totalPage;
		this.bookInfos = bookInfos;
	}
	
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public List<Book> getBookInfos() {
		return bookInfos;
	}
	public void setBookInfos(List<Book> bookInfos) {
		this.bookInfos = bookInfos;
	}
	public List<String> getPageLi() {
		return pageLi;
	}
	public void setPageLi(List<String> pageLi) {
		this.pageLi = pageLi;
	}
	
}
