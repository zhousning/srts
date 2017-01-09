package com.srts.examination.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.examination.domain.TestInfo;

public interface TestInfoManDao extends BaseDao<TestInfo> {

	List<TestInfo> getExamPlan();
	
	public void addTestInfo(TestInfo testInfo);
	
	public List<TestInfo> getTestInfosByState(String state);
	public TestInfo getTestInfoById(long id);
	public void updateTestInfo(TestInfo testInfo);

	List<TestInfo> findAllTestByTime();
}
