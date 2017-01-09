package com.srts.examination.po;

import java.util.List;

import com.srts.examination.domain.TestPaper;
import com.srts.examination.domain.TestPeople;
import com.srts.system.domain.Sys_User;

public class ExamInfoPo {
       private long id;
       private String testName;
       private String testDate;
       private String testTime;
       private TestPaper testPaper;
       private List<Sys_User> testPeople;
       
       public ExamInfoPo(){}
       
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}

	public List<Sys_User> getTestPeople() {
		return testPeople;
	}

	public void setTestPeople(List<Sys_User> testPeople) {
		this.testPeople = testPeople;
	}

	public String getTestTime() {
		return testTime;
	}

	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}
	

       
       
       
}
