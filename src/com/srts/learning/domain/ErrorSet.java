package com.srts.learning.domain;

import com.srts.examination.domain.QuestionBank;
import com.srts.system.domain.Sys_User;

public class ErrorSet {
	private static final long serialVersionUID = 1L;
	private long id;//主键id
	private Sys_User usr;//做错该题的用户
	private int flag;//用户记忆曲线
	private String lastTestTime;//最近一次做错该题时间
	private QuestionBank question;//对应的错题
	public ErrorSet(){}
	public ErrorSet(long id, Sys_User usr, int flag, String lastTestTime,
			QuestionBank question) {
		this.id = id;
		this.usr = usr;
		this.flag = flag;
		this.lastTestTime = lastTestTime;
		this.question = question;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Sys_User getUsr() {
		return usr;
	}
	public void setUsr(Sys_User usr) {
		this.usr = usr;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getLastTestTime() {
		return lastTestTime;
	}
	public void setLastTestTime(String lastTestTime) {
		this.lastTestTime = lastTestTime;
	}
	public QuestionBank getQuestion() {
		return question;
	}
	public void setQuestion(QuestionBank question) {
		this.question = question;
	}
}
