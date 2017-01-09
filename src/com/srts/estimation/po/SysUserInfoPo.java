package com.srts.estimation.po;

public class SysUserInfoPo {
	private String name;
	private String workno;
	private String company;
	public SysUserInfoPo(){}
	public SysUserInfoPo(String name, String workno, String company) {
		this.name = name;
		this.workno = workno;
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWorkno() {
		return workno;
	}
	public void setWorkno(String workno) {
		this.workno = workno;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	

}
