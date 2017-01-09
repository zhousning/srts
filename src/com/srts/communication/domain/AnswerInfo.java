package com.srts.communication.domain;

import java.util.Date;

import com.srts.system.domain.Sys_User;
/**
 * 问题回复
 * @author wyw
 *
 */
public class AnswerInfo implements Comparable<AnswerInfo>{
	private long id;
	private String answerContent;//问题回复内容
	private Date answerDate;//回复日期
	private String date;//用于时间显示
	private String content;//用于回复的内容的显示
	private Sys_User usr;//问题回复员工
	private ProblemInfo problem;//相应问题
	public AnswerInfo(){}
	public AnswerInfo(Long id){
		this.id=id;
	}
	public AnswerInfo(long id, String answerContent, Date answerDate,
			Sys_User usr, ProblemInfo problem) {
		this.id = id;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
		this.usr = usr;
		this.problem = problem;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public Date getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(Date date) {
		this.answerDate = date;
	}
	public Sys_User getUsr() {
		return usr;
	}
	public void setUsr(Sys_User usr) {
		this.usr = usr;
	}
	public ProblemInfo getProblem() {
		return problem;
	}
	public void setProblem(ProblemInfo problem) {
		this.problem = problem;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int compareTo(AnswerInfo info) {
		if(info.getId()>id){
			return -1;
		}else if(id>info.getId()){
			return 1;
		}
		return 0;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
