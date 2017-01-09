package com.srts.examination.po;

public class UserPo {
	private long id;
	private String name;
	private String age;
	private String testTimes;
	private String failTimes;
	private String department;

	public UserPo() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
