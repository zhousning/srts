package com.srts.controlPanel.po;

public class MyProblemInfoPo {
	private String id;
	private String proContent;
	private String proDate;
	private String proAnsCount;
	public MyProblemInfoPo(){}
	public MyProblemInfoPo(String id, String proContent, String proDate,
			String proAnsCount) {
		this.id = id;
		this.proContent = proContent;
		this.proDate = proDate;
		this.proAnsCount = proAnsCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProContent() {
		return proContent;
	}
	public void setProContent(String proContent) {
		this.proContent = proContent;
	}
	public String getProDate() {
		return proDate;
	}
	public void setProDate(String proDate) {
		this.proDate = proDate;
	}
	public String getProAnsCount() {
		return proAnsCount;
	}
	public void setProAnsCount(String proAnsCount) {
		this.proAnsCount = proAnsCount;
	}
	

}
