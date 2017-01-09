package com.srts.examination.domain;

import com.srts.system.domain.Sys_User;

public class ExamRecord {
	private long id;
	private String exam_date;
	private String exam_content;
	private int exam_grade;
	private String exam_company;
	private Sys_User usr;
	private String tips;
	public ExamRecord(){}
	public ExamRecord(long id, String examDate, String examContent,
			int examGrade, String examCompany, Sys_User usr, String tips) {
		this.id = id;
		exam_date = examDate;
		exam_content = examContent;
		exam_grade = examGrade;
		exam_company = examCompany;
		this.usr = usr;
		this.tips = tips;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getExam_date() {
		return exam_date;
	}
	public void setExam_date(String examDate) {
		exam_date = examDate;
	}
	public String getExam_content() {
		return exam_content;
	}
	public void setExam_content(String examContent) {
		exam_content = examContent;
	}
	public int getExam_grade() {
		return exam_grade;
	}
	public void setExam_grade(int examGrade) {
		exam_grade = examGrade;
	}
	public String getExam_company() {
		return exam_company;
	}
	public void setExam_company(String examCompany) {
		exam_company = examCompany;
	}
	public Sys_User getUsr() {
		return usr;
	}
	public void setUsr(Sys_User usr) {
		this.usr = usr;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
    
}
