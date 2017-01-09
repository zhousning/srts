package com.srts.estimation.dao;

import java.util.List;

import com.srts.examination.domain.TestInfo;

public interface CompanyEstimateDao{
	public List<String[]> findAllTestInfoByAllConditions(long companyId,long deptId,
			String startDate,String endDate,long testInfoId);
	public List<Long> findAllTestInfoId();
	public List<TestInfo> findTestListByStartDateAndEndDate(String startDate,String endDate);
}