package com.srts.information.domain;

import com.srts.examination.domain.TestInfo;
import com.srts.system.domain.Sys_User;

public class TrainNotice {
	private static final long serialVersionUID = 1L;
	
	private long id;//主键id
	private String noticeTitle;//培训主题
	private String noticeContent;//培训内容
	private String noticeAttach;//附件
	private Sys_User user;//创建者，管理员
	private int nonticeYear;
	private int nonticeMonth;
	private int nonticeDay;
	private String noticeType;//通知类型
	private String establishDate;//创建日期
	private String acceptCompany;//接收单位
	private long loadCount;
	private TestInfo testInfo;
	public TrainNotice(){}
	public TrainNotice(long id, String noticeTitle, String noticeContent,
			String noticeAttach, Sys_User user, int nonticeYear,
			int nonticeMonth, int nonticeDay, String noticeType,
			String establishDate, String acceptCompany, long loadCount) {
		this.id = id;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeAttach = noticeAttach;
		this.user = user;
		this.nonticeYear = nonticeYear;
		this.nonticeMonth = nonticeMonth;
		this.nonticeDay = nonticeDay;
		this.noticeType = noticeType;
		this.establishDate = establishDate;
		this.acceptCompany = acceptCompany;
		this.loadCount = loadCount;
	}
	public int getNonticeYear() {
		return nonticeYear;
	}
	public void setNonticeYear(int nonticeYear) {
		this.nonticeYear = nonticeYear;
	}
	public int getNonticeMonth() {
		return nonticeMonth;
	}
	public void setNonticeMonth(int nonticeMonth) {
		this.nonticeMonth = nonticeMonth;
	}
	public int getNonticeDay() {
		return nonticeDay;
	}
	public void setNonticeDay(int nonticeDay) {
		this.nonticeDay = nonticeDay;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeAttach() {
		return noticeAttach;
	}
	public void setNoticeAttach(String noticeAttach) {
		this.noticeAttach = noticeAttach;
	}
	public Sys_User getUser() {
		return user;
	}
	public void setUser(Sys_User user) {
		this.user = user;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	public String getEstablishDate() {
		return establishDate;
	}
	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}
	public String getAcceptCompany() {
		return acceptCompany;
	}
	public void setAcceptCompany(String acceptCompany) {
		this.acceptCompany = acceptCompany;
	}
	public long getLoadCount() {
		return loadCount;
	}
	public void setLoadCount(long loadCount) {
		this.loadCount = loadCount;
	}
	public TestInfo getTestInfo() {
		return testInfo;
	}
	public void setTestInfo(TestInfo testInfo) {
		this.testInfo = testInfo;
	}
	
	
}
