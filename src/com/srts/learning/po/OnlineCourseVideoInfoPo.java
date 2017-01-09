package com.srts.learning.po;

import java.util.ArrayList;
import java.util.List;

import com.srts.knowledge.domain.OnlineCourseVideo;

/**
 * 用于封装List<Book>，
 * @author wyw
 *
 */
public class OnlineCourseVideoInfoPo {
	private long totalPage;
	private List<OnlineCourseVideo> videoInfos;
	private List<String> pageLi = new ArrayList<String>();
	
	public OnlineCourseVideoInfoPo(){}
	public OnlineCourseVideoInfoPo(long totalPage, List<OnlineCourseVideo> videoInfos) {
		this.totalPage = totalPage;
		this.videoInfos = videoInfos;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public List<OnlineCourseVideo> getVideoInfos() {
		return videoInfos;
	}
	public void setVideoInfos(List<OnlineCourseVideo> videoInfos) {
		this.videoInfos = videoInfos;
	}
	public List<String> getPageLi() {
		return pageLi;
	}
	public void setPageLi(List<String> pageLi) {
		this.pageLi = pageLi;
	}
}
