package com.srts.examination.po;

public class TestInfoPo {
	private String num1;
	private String name;
	private String num2;
	private String date;
	private String count;
	
	public TestInfoPo(){}
	
	public TestInfoPo(String num1, String name, String num2, String date,
			String count) {
		this.num1 = num1;
		this.name = name;
		this.num2 = num2;
		this.date = date;
		this.count = count;
	}
	public String getNum1() {
		return num1;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum2() {
		return num2;
	}
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
}
