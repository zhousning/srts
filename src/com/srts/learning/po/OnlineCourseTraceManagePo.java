package com.srts.learning.po;

import java.util.ArrayList;
import java.util.List;

public class OnlineCourseTraceManagePo {
	private long totalPage;
	private List<OnlineCourseTracePo> traces = null;
	private List<String> pageLi = null;
	public OnlineCourseTraceManagePo(){}
	public OnlineCourseTraceManagePo(long totalPage,List<OnlineCourseTracePo> traces, List<String> pageLi) {
		this.totalPage = totalPage;
		this.traces = traces;
		this.pageLi = pageLi;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public List<OnlineCourseTracePo> getTraces() {
		return traces;
	}
	public void setTraces(List<OnlineCourseTracePo> traces) {
		this.traces = traces;
	}
	public List<String> getPageLi() {
		return pageLi;
	}
	public void setPageLi(List<String> pageLi) {
		this.pageLi = pageLi;
	}
}
