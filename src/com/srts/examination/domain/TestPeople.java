package com.srts.examination.domain;

import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;

public class TestPeople {
	private long id;
	private Sys_User usr;
	private TestInfo testInfo;
//	private Train train;
	public TestPeople(){}
	
	public TestPeople(long id, Sys_User usr, TestInfo testInfo) {
	super();
	this.id = id;
	this.usr = usr;
	this.testInfo = testInfo;
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
		this.usr=usr;
	}
	public TestInfo getTestInfo() {
		return testInfo;
	}
	public void setTestInfo(TestInfo testInfo) {
		this.testInfo = testInfo;
	}
    
}
