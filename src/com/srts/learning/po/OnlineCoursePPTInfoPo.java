package com.srts.learning.po;

import java.util.ArrayList;
import java.util.List;

import com.srts.knowledge.domain.OnlineCoursePPT;

/**
 * 用于封装List<Book>，
 * @author wyw
 *
 */
public class OnlineCoursePPTInfoPo {
	private long totalPage;
	private List<OnlineCoursePPT> pptInfos;
	private List<String> pageLi = new ArrayList<String>();
	
	public OnlineCoursePPTInfoPo(){}
	public OnlineCoursePPTInfoPo(long totalPage, List<OnlineCoursePPT> pptInfos) {
		this.totalPage = totalPage;
		this.pptInfos = pptInfos;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public List<OnlineCoursePPT> getPptInfos() {
		return pptInfos;
	}
	public void setPptInfos(List<OnlineCoursePPT> pptInfos) {
		this.pptInfos = pptInfos;
	}
	public List<String> getPageLi() {
		return pageLi;
	}
	public void setPageLi(List<String> pageLi) {
		this.pageLi = pageLi;
	}
	
}
