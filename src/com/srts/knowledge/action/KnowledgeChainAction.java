package com.srts.knowledge.action;

import org.springframework.stereotype.Controller;

import com.srts.common.base.impl.BaseActionImpl;
import com.srts.knowledge.domain.Book;

@Controller
public class KnowledgeChainAction extends BaseActionImpl<Book>{
	private static final long serialVersionUID = 1L;
	private Book book = new Book();
	public Book getModel() {
		return null;
	} 
	public void prepare() throws Exception {
		
	}
	
	/**
	 * 跳转到klgChainDisp.jsp
	 * @return
	 */
	public String knowledgeChainDisp(){
		return "knowledgeChainDisp";
	}
	
	/**
	 * 跳转到klgChainList.jsp
	 * @return
	 */
	public String knowledgeChainList(){
		return "knowledgeChainList";
	}
	
	/**
	 * 跳转到klgChainUploadDisp.jsp
	 * @return
	 */
	public String knowledgeChainUploadDisp(){
		return "knowledgeChainUploadDisp";
	}
}
