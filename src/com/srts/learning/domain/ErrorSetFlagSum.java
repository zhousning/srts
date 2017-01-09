package com.srts.learning.domain;

import com.srts.system.domain.Sys_User;

public class ErrorSetFlagSum {
	private static final long serialVersionUID = 1L;
	private long id;//主键id
	private int flagSum;//flag之和
	private Sys_User usr;//做错该题的用户
	private String TimePoint;//时间点
	public ErrorSetFlagSum()
	{
		
	}
	
	public ErrorSetFlagSum(long id, int flagSum, Sys_User usr, String timePoint) {
		this.id = id;
		this.flagSum = flagSum;
		this.usr = usr;
		TimePoint = timePoint;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getFlagSum() {
		return flagSum;
	}
	public void setFlagSum(int flagSum) {
		this.flagSum = flagSum;
	}
	public Sys_User getUsr() {
		return usr;
	}
	public void setUsr(Sys_User usr) {
		this.usr = usr;
	}
	public String getTimePoint() {
		return TimePoint;
	}
	public void setTimePoint(String timePoint) {
		TimePoint = timePoint;
	}
	

}
