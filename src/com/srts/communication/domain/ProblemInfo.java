package com.srts.communication.domain;

import java.util.Date;
import java.util.Set;

import com.srts.system.domain.Sys_User;
/**
 * 问题信息
 * @author wyw
 *
 */
public class ProblemInfo {
	private long id;//主键
	private String problemDesc;//问题描述
	private String problemDescAdd;//问题补充
	private Date postDate;//提交日期
	private Date validDateFrom;//有效日期起
	private Date validDateTo;//有效日期止
	private int viewCount;//浏览统计
	private int answerCount;//回复统计
	private Sys_User usr;//提问员工
	private String labels;//问题标签
	private Set<AnswerInfo> answerInfos;//问题回复
	private String date;//用于时间显示 存储格式转换后日期
	private String desc;//String problemDesc 的存储 简化版
	public ProblemInfo(){
	}	
	public ProblemInfo(long id, String problemDesc, String problemDescAdd,
			Date postDate, Date validDateFrom, Date validDateTo, int viewCount,
			int answerCount, Sys_User usr, String labels,
			Set<AnswerInfo> answerInfos) {
		this.id = id;
		this.problemDesc = problemDesc;
		this.problemDescAdd = problemDescAdd;
		this.postDate = postDate;
		this.validDateFrom = validDateFrom;
		this.validDateTo = validDateTo;
		this.viewCount = viewCount;
		this.answerCount = answerCount;
		this.usr = usr;
		this.labels = labels;
		this.answerInfos = answerInfos;
	}
	public ProblemInfo(Long problemId) {
		id=problemId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProblemDesc() {
		return problemDesc;
	}
	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	public String getProblemDescAdd() {
		return problemDescAdd;
	}
	public void setProblemDescAdd(String problemDescAdd) {
		this.problemDescAdd = problemDescAdd;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Date getValidDateFrom() {
		return validDateFrom;
	}
	public void setValidDateFrom(Date validDateFrom) {
		this.validDateFrom = validDateFrom;
	}
	public Date getValidDateTo() {
		return validDateTo;
	}
	public void setValidDateTo(Date validDateTo) {
		this.validDateTo = validDateTo;
	}
	public Sys_User getUsr() {
		return usr;
	}
	public void setUsr(Sys_User usr) {
		this.usr = usr;
	}
	public String getLabels() {
		return labels;
	}
	public void setLabels(String labels) {
		this.labels = labels;
	}
	public Set<AnswerInfo> getAnswerInfos() {
		return answerInfos;
	}
	public void setAnswerInfos(Set<AnswerInfo> answerInfos) {
		this.answerInfos = answerInfos;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}	
	
}
