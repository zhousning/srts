package com.srts.estimation.service;

import java.util.List;

import com.srts.estimation.po.CompanyEstimateInfoPo;
import com.srts.estimation.po.CompanyTestInfoPo;
import com.srts.estimation.po.InfoPo;

public interface CompanyEstimateService {
	public List<CompanyTestInfoPo> findAllTestInfoByAllConditions(long companyId,
			long deptId, String startDate, String endDate, long testInfoId);
	public String selectAveScoreByCompanyAndDept(long companyId,long deptId);
	public String selectAveScoreByTestName(long companyId,long testInfoId);
	public String categoryTestScoreByTestCompanyAndDept(long companyId,long deptId,long testInfoId);
	public List<InfoPo> findTestInfoByStartDateAndEndDate(String startDate,String endDate);
	public List<InfoPo> findChildDeptByCompanyId(long companyId);
	public List<InfoPo> findCompany();
	public CompanyEstimateInfoPo setEstimateInfo(long companyId,
			long deptId, String startDate, String endDate, long testInfoId);

}
