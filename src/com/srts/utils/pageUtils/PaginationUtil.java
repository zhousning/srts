package com.srts.utils.pageUtils;

import java.util.ArrayList;
import java.util.List;

public class PaginationUtil {
	
	private List<String> page;
	public List<String> getPage() {
		return page;
	}
	public void setPage(List<String> page) {
		this.page = page;
	}
	/**
	 * 页面初始化时最开始的分页
	 * @param totalPage
	 * @return
	 */
	public List<String> getInitPages(Long totalPage,String courseType){
		page  = new ArrayList<String>();
		page.add("<li class=\"disabled\"><a>«</a></li>");
		boolean i_6 = false;
		for(int i = 1;i<=totalPage;i++){
			if(i==1){
				page.add("<li class=\"active\"><a onclick=\"currentPage($(this),\'"+courseType+"\')\">"+i+"</a></li>");
			}else{
				page.add("<li><a onclick=\"currentPage($(this),\'"+courseType+"\')\">"+i+"</a></li>");
			}
			if(i>6){
				i_6 = true;
				break;
			}
		}
		if(i_6){
			page.add("<li><a onclick=\"aftPages($(this),\'"+courseType+"\')\">»</a></li>");
		}else{
			page.add("<li class=\"disabled\"><a>»</a></li>");
		}
		return page;
	}
	
	/**
	 * 向下翻滚，查询下一页的数据
	 * @param totalPage
	 * @param pageNum
	 * @return
	 */
	public List<String> turnAfterPages(Long totalPage,String pageNum,String courseType){
		page  = new ArrayList<String>();
		page.add("<li><a onclick=\"prePages($(this),\'"+courseType+"\')\">«</a></li>");
		int num = Integer.parseInt(pageNum)+1;
		boolean i_6 = false;
		for(int i = num;i<=totalPage;i++){
			if(i>(6+num)){
				i_6 = true;
				break;
			}
			if(i==num){
				page.add("<li class=\"active\"><a onclick=\"currentPage($(this),\'"+courseType+"\')\">"+i+"</a></li>");
			}else{
				page.add("<li><a onclick=\"currentPage($(this),\'"+courseType+"\')\">"+i+"</a></li>");
			}
		}
		if(i_6){
			page.add("<li><a onclick=\"aftPages($(this),\'"+courseType+"\')\">»</a></li>");
		}else{
			page.add("<li class=\"disabled\"><a>»</a></li>");
		}
		return page;
	}
	/**
	 * 页面初始化时最开始的分页
	 * @param totalPage
	 * @return
	 */
	public List<String> getInitCommPages(Integer totalPage){
		page  = new ArrayList<String>();
		page.add("<li class=\"disabled\"><a>«</a></li>");
		boolean i_6 = false;
		for(int i = 1;i<=totalPage;i++){
			if(i==1){
				page.add("<li class=\"active\"><a onclick=\"currentPage($(this))\">"+i+"</a></li>");
			}else{
				page.add("<li><a onclick=\"currentPage($(this))\">"+i+"</a></li>");
			}
			if(i>6){
				i_6 = true;
				break;
			}
		}
		if(i_6){
			page.add("<li><a onclick=\"aftPages($(this))\">»</a></li>");
		}else{
			page.add("<li class=\"disabled\"><a>»</a></li>");
		}
		return page;
	}
	/**
	 * 向上翻滚，查询上一页的数据
	 * @param totalPage
	 * @param pageNum
	 * @return
	 */
	public List<String> turnForwardPages(Long totalPage,String pageNum,String courseType){
		page  = new ArrayList<String>();
		int num = Integer.parseInt(pageNum)-7;
		page = new ArrayList<String>();
		if(num==1){
			page.add("<li class=\"disabled\"><a>«</a></li>");
		}else{
			page.add("<li><a onclick=\"prePages($(this),\'"+courseType+"\')\">«</a></li>");
		}
		boolean i_6 = false;
		for(int i = num;i<=totalPage;i++){
			if(i==num){
				page.add("<li class=\"active\"><a onclick=\"currentPage($(this),\'"+courseType+"\')\">"+i+"</a></li>");
			}else{
				page.add("<li><a onclick=\"currentPage($(this),\'"+courseType+"\')\">"+i+"</a></li>");
			}
			if(i>(6-1+num)){
				i_6 = true;
				break;
			}
		}
		if(i_6){
			page.add("<li><a onclick=\"aftPages($(this),\'"+courseType+"\')\">»</a></li>");
		}else{
			page.add("<li class=\"disabled\"><a>»</a></li>");
		}
		return page;
	}
	
	/**
	 * 向下翻滚，查询下一页的数据
	 * @param totalPage
	 * @param pageNum
	 * @return
	 */
	public List<String> turnAfterCommPages(Integer totalPage,String pageNum){
		page  = new ArrayList<String>();
		page.add("<li><a onclick=\"prePages($(this))\">«</a></li>");
		int num = Integer.parseInt(pageNum)+1;
		boolean i_6 = false;
		for(int i = num;i<=totalPage;i++){
			if(i>(6+num)){
				i_6 = true;
				break;
			}
			if(i==num){
				page.add("<li class=\"active\"><a onclick=\"currentPage($(this))\">"+i+"</a></li>");
			}else{
				page.add("<li><a onclick=\"currentPage($(this))\">"+i+"</a></li>");
			}
		}
		if(i_6){
			page.add("<li><a onclick=\"aftPages($(this))\">»</a></li>");
		}else{
			page.add("<li class=\"disabled\"><a>»</a></li>");
		}
		return page;
	}
	
	/**
	 * 向上翻滚，查询上一页的数据
	 * @param totalPage
	 * @param pageNum
	 * @return
	 */
	public List<String> turnForwardCommPages(Integer totalPage,String pageNum){
		int num = Integer.parseInt(pageNum)-7;
		page = new ArrayList<String>();
		if(num==1){
			page.add("<li class=\"disabled\"><a>«</a></li>");
		}else{
			page.add("<li><a onclick=\"prePages($(this))\">«</a></li>");
		}
		boolean i_6 = false;
		for(int i = num;i<=totalPage;i++){
			if(i==num){
				page.add("<li class=\"active\"><a onclick=\"currentPage($(this))\">"+i+"</a></li>");
			}else{
				page.add("<li><a onclick=\"currentPage($(this))\">"+i+"</a></li>");
			}
			if(i>(6-1+num)){
				i_6 = true;
				break;
			}
		}
		if(i_6){
			page.add("<li><a onclick=\"aftPages($(this))\">»</a></li>");
		}else{
			page.add("<li class=\"disabled\"><a>»</a></li>");
		}
		return page;
	}
	
	/**
	 * 页面初始化时最开始的分页
	 * @param totalPage
	 * @return
	 */
	public List<String> getInitQboPages(Integer totalPage){
		page  = new ArrayList<String>();
		page.add("<li class=\"disabled\"><a>«</a></li>");
		boolean i_6 = false;
		for(int i = 1;i<=totalPage;i++){
			if(i==1){
				page.add("<li class=\"active\"><a onclick=\"currentPageQBO($(this))\">"+i+"</a></li>");
			}else{
				page.add("<li><a onclick=\"currentPageQBO($(this))\">"+i+"</a></li>");
			}
			if(i>6){
				i_6 = true;
				break;
			}
		}
		if(i_6){
			page.add("<li><a onclick=\"aftPagesQBO($(this))\">»</a></li>");
		}else{
			page.add("<li class=\"disabled\"><a>»</a></li>");
		}
		return page;
	}
	
	/**
	 * 向上翻滚，查询上一页的数据
	 * @param totalPage
	 * @param pageNum
	 * @return
	 */
	public List<String> turnForwardQboPages(Integer totalPage,String pageNum){
		int num = Integer.parseInt(pageNum)-7;
		page = new ArrayList<String>();
		if(num==1){
			page.add("<li class=\"disabled\"><a>«</a></li>");
		}else{
			page.add("<li><a onclick=\"prePagesQBO($(this))\">«</a></li>");
		}
		boolean i_6 = false;
		for(int i = num;i<=totalPage;i++){
			if(i==num){
				page.add("<li class=\"active\"><a onclick=\"currentPageQBO($(this))\">"+i+"</a></li>");
			}else{
				page.add("<li><a onclick=\"currentPageQBO($(this))\">"+i+"</a></li>");
			}
			if(i>(6-1+num)){
				i_6 = true;
				break;
			}
		}
		if(i_6){
			page.add("<li><a onclick=\"aftPagesQBO($(this))\">»</a></li>");
		}else{
			page.add("<li class=\"disabled\"><a>»</a></li>");
		}
		return page;
	}
	
	/**
	 * 向下翻滚，查询下一页的数据
	 * @param totalPage
	 * @param pageNum
	 * @return
	 */
	public List<String> turnAfterQboPages(Integer totalPage,String pageNum){
		page  = new ArrayList<String>();
		page.add("<li><a onclick=\"prePagesQBO($(this))\">«</a></li>");
		int num = Integer.parseInt(pageNum)+1;
		boolean i_6 = false;
		for(int i = num;i<=totalPage;i++){
			if(i>(6+num)){
				i_6 = true;
				break;
			}
			if(i==num){
				page.add("<li class=\"active\"><a onclick=\"currentPageQBO($(this))\">"+i+"</a></li>");
			}else{
				page.add("<li><a onclick=\"currentPageQBO($(this))\">"+i+"</a></li>");
			}
		}
		if(i_6){
			page.add("<li><a onclick=\"aftPagesQBO($(this))\">»</a></li>");
		}else{
			page.add("<li class=\"disabled\"><a>»</a></li>");
		}
		return page;
	}
}
