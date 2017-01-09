package com.srts.examination.service;

import java.util.List;

import com.srts.examination.domain.TestInfo;

public interface TestInfoManService {

	public List<TestInfo> getExamPlan();

	public TestInfo getUserNowExam(long userId);
	
	public void addTestInfo(TestInfo testInfo);
	
	public List<TestInfo> getTestInfosByState(String state);
	public TestInfo getTestInfoById(long id);
	public void updateTestInfo(TestInfo testInfo);

	public List<TestInfo> findAllTestByTime();

}
