package com.srts.examination.domain;

import com.srts.system.domain.Sys_User;

public class Competition {
	private long id;
	private Sys_User usr;
	private String comp_date;
	private int comp_time;
	private int grade;
	public Competition(){}
	public Competition(long id, Sys_User usr, String compDate, int compTime,
			int grade) {
		this.id = id;
		this.usr = usr;
		comp_date = compDate;
		comp_time = compTime;
		this.grade = grade;
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
	public String getComp_date() {
		return comp_date;
	}
	public void setComp_date(String compDate) {
		comp_date = compDate;
	}
	public int getComp_time() {
		return comp_time;
	}
	public void setComp_time(int compTime) {
		comp_time = compTime;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
