package com.srts.estimation.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.estimation.po.CompanyEstimateInfoPo;
import com.srts.estimation.po.CompanyTestInfoPo;
import com.srts.estimation.po.InfoPo;
import com.srts.estimation.service.CompanyEstimateService;
import com.srts.system.domain.Sys_User;

@Controller
public class CompanyEstimateAction {
	@Resource
	private CompanyEstimateService ceService;
	
	private String selectAveScoreByCompanyAndDept;
	private String selectAveScoreByTestName;
	private String categoryTestScoreByTestCompanyAndDept;
	private CompanyEstimateInfoPo setEstimateInfo; 
	public List<CompanyTestInfoPo> findAllTestInfoByAllConditions;
    
	private String companyId="0";
	private String deptId="0";
	private String startDate="";
	private String endDate="";
	private String testInfoId="0";
	private List<InfoPo> findTestInfoByStartDateAndEndDate;
	private List<InfoPo> findChildDeptByCompanyId;
	private List<InfoPo> findCompany;
	
	private String companyId1="1";
	private String deptId1="0";
	private List<InfoPo> findChildDeptByCompanyId1;
	private List<InfoPo> findCompany1;
	
	private String companyId2="1";
	private String testInfoId2="0";
	private List<InfoPo> findCompany2;
	private List<InfoPo> findTestInfoByStartDateAndEndDate2;
	
	private String companyId3="1";
	private String deptId3="0";
	private String testInfoId3="0";
	private List<InfoPo> findTestInfoByStartDateAndEndDate3;
	private List<InfoPo> findChildDeptByCompanyId3;
	private List<InfoPo> findCompany3;
	
	public String CompanyEstimateList()
	{
		companyId="0";
		deptId="0";
		startDate="";
		endDate="";
		testInfoId="0";
		companyId1="1";
		deptId1="0";
		companyId2="1";
		testInfoId2="0";
		companyId3="1";
		deptId3="0";
		testInfoId3="0";
		findTestInfoByStartDateAndEndDate=ceService.findTestInfoByStartDateAndEndDate(startDate, endDate);
		findChildDeptByCompanyId=ceService.findChildDeptByCompanyId(Long.parseLong(companyId));
		findCompany=ceService.findCompany();
		
		findChildDeptByCompanyId1=ceService.findChildDeptByCompanyId(Long.parseLong(companyId1));
		findCompany1=ceService.findCompany();
		
		findCompany2=ceService.findCompany();
		findTestInfoByStartDateAndEndDate2=ceService.findTestInfoByStartDateAndEndDate("", "");
		
		findTestInfoByStartDateAndEndDate3=ceService.findTestInfoByStartDateAndEndDate("", "");
		findChildDeptByCompanyId3=ceService.findChildDeptByCompanyId(Long.parseLong(companyId3));
		findCompany3=ceService.findCompany();
		return "CompanyEstimateList";
	}
	public String AveScoreByCompanyAndDeptAnalysis()
	{
		selectAveScoreByCompanyAndDept=ceService.selectAveScoreByCompanyAndDept
		(Long.parseLong(companyId1), Long.parseLong(deptId1));
		return "AveScoreByCompanyAndDeptAnalysis";
	}
	public String AveScoreByTestNameAnalysis()
	{
		selectAveScoreByTestName=ceService.selectAveScoreByTestName
		(Long.parseLong(companyId2), Long.parseLong(testInfoId2));
		return "AveScoreByTestNameAnalysis";
	}
	public String categoryTestScoreAnalysis()
	{
		categoryTestScoreByTestCompanyAndDept=ceService.categoryTestScoreByTestCompanyAndDept
		(Long.parseLong(companyId3), Long.parseLong(deptId3), Long.parseLong(testInfoId3));
		return "categoryTestScoreAnalysis";
	}
	public String searchAllTestInfoAndEstString() throws UnsupportedEncodingException
	{
		if(startDate.equals(""))
		{
			
		}
		else
		{
			startDate = java.net.URLDecoder.decode(startDate,"UTF-8");
			startDate = java.net.URLDecoder.decode(startDate,"UTF-8");
		}
		if(endDate.equals(""))
		{
			
		}
		else
		{
			endDate = java.net.URLDecoder.decode(endDate,"UTF-8");
			endDate = java.net.URLDecoder.decode(endDate,"UTF-8");
		}
		findAllTestInfoByAllConditions=ceService.findAllTestInfoByAllConditions
		(Long.parseLong(companyId), Long.parseLong(deptId), startDate, endDate, Long.parseLong(testInfoId));
		setEstimateInfo=ceService.setEstimateInfo
		(Long.parseLong(companyId), Long.parseLong(deptId), startDate, endDate, Long.parseLong(testInfoId));
		return "searchAllTestInfoAndEstString";
	}
	public String CompanyDeptOnChange()
	{
		findChildDeptByCompanyId=ceService.findChildDeptByCompanyId(Long.parseLong(companyId));
		return "CompanyDeptOnChange";
	}
	public String CompanyDeptOnChange1()
	{
		findChildDeptByCompanyId1=ceService.findChildDeptByCompanyId(Long.parseLong(companyId1));
		return "CompanyDeptOnChange1";
	}
	public String CompanyDeptOnChange3()
	{
		findChildDeptByCompanyId3=ceService.findChildDeptByCompanyId(Long.parseLong(companyId3));
		return "CompanyDeptOnChange3";
	}
	public String TestInfoOnDateOnchange() throws UnsupportedEncodingException
	{
		if(startDate.equals(""))
		{
			startDate="0000-00-00";
		}
		if(endDate.equals(""))
		{
			endDate="9999-99-99";
		}
		startDate = java.net.URLDecoder.decode(startDate,"UTF-8");
		startDate = java.net.URLDecoder.decode(startDate,"UTF-8");
		endDate = java.net.URLDecoder.decode(endDate,"UTF-8");
		endDate = java.net.URLDecoder.decode(endDate,"UTF-8");
		findTestInfoByStartDateAndEndDate=ceService.findTestInfoByStartDateAndEndDate(startDate, endDate);
		return "TestInfoOnDateOnchange";
	}
	
	
	
	public CompanyEstimateService getCeService() {
		return ceService;
	}
	public void setCeService(CompanyEstimateService ceService) {
		this.ceService = ceService;
	}
	public String getSelectAveScoreByCompanyAndDept() {
		return selectAveScoreByCompanyAndDept;
	}
	public void setSelectAveScoreByCompanyAndDept(
			String selectAveScoreByCompanyAndDept) {
		this.selectAveScoreByCompanyAndDept = selectAveScoreByCompanyAndDept;
	}
	public String getSelectAveScoreByTestName() {
		return selectAveScoreByTestName;
	}
	public void setSelectAveScoreByTestName(String selectAveScoreByTestName) {
		this.selectAveScoreByTestName = selectAveScoreByTestName;
	}
	public String getCategoryTestScoreByTestCompanyAndDept() {
		return categoryTestScoreByTestCompanyAndDept;
	}
	public void setCategoryTestScoreByTestCompanyAndDept(
			String categoryTestScoreByTestCompanyAndDept) {
		this.categoryTestScoreByTestCompanyAndDept = categoryTestScoreByTestCompanyAndDept;
	}
	public CompanyEstimateInfoPo getSetEstimateInfo() {
		return setEstimateInfo;
	}
	public void setSetEstimateInfo(CompanyEstimateInfoPo setEstimateInfo) {
		this.setEstimateInfo = setEstimateInfo;
	}
	public List<CompanyTestInfoPo> getFindAllTestInfoByAllConditions() {
		return findAllTestInfoByAllConditions;
	}
	public void setFindAllTestInfoByAllConditions(
			List<CompanyTestInfoPo> findAllTestInfoByAllConditions) {
		this.findAllTestInfoByAllConditions = findAllTestInfoByAllConditions;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTestInfoId() {
		return testInfoId;
	}
	public void setTestInfoId(String testInfoId) {
		this.testInfoId = testInfoId;
	}
	public List<InfoPo> getFindTestInfoByStartDateAndEndDate() {
		return findTestInfoByStartDateAndEndDate;
	}
	public void setFindTestInfoByStartDateAndEndDate(
			List<InfoPo> findTestInfoByStartDateAndEndDate) {
		this.findTestInfoByStartDateAndEndDate = findTestInfoByStartDateAndEndDate;
	}
	public List<InfoPo> getFindChildDeptByCompanyId() {
		return findChildDeptByCompanyId;
	}
	public void setFindChildDeptByCompanyId(List<InfoPo> findChildDeptByCompanyId) {
		this.findChildDeptByCompanyId = findChildDeptByCompanyId;
	}
	public List<InfoPo> getFindCompany() {
		return findCompany;
	}
	public void setFindCompany(List<InfoPo> findCompany) {
		this.findCompany = findCompany;
	}
	public String getCompanyId1() {
		return companyId1;
	}
	public void setCompanyId1(String companyId1) {
		this.companyId1 = companyId1;
	}
	public String getDeptId1() {
		return deptId1;
	}
	public void setDeptId1(String deptId1) {
		this.deptId1 = deptId1;
	}
	public List<InfoPo> getFindChildDeptByCompanyId1() {
		return findChildDeptByCompanyId1;
	}
	public void setFindChildDeptByCompanyId1(List<InfoPo> findChildDeptByCompanyId1) {
		this.findChildDeptByCompanyId1 = findChildDeptByCompanyId1;
	}
	public List<InfoPo> getFindCompany1() {
		return findCompany1;
	}
	public void setFindCompany1(List<InfoPo> findCompany1) {
		this.findCompany1 = findCompany1;
	}
	public String getCompanyId2() {
		return companyId2;
	}
	public void setCompanyId2(String companyId2) {
		this.companyId2 = companyId2;
	}
	public String getTestInfoId2() {
		return testInfoId2;
	}
	public void setTestInfoId2(String testInfoId2) {
		this.testInfoId2 = testInfoId2;
	}
	public List<InfoPo> getFindCompany2() {
		return findCompany2;
	}
	public void setFindCompany2(List<InfoPo> findCompany2) {
		this.findCompany2 = findCompany2;
	}
	public List<InfoPo> getFindTestInfoByStartDateAndEndDate2() {
		return findTestInfoByStartDateAndEndDate2;
	}
	public void setFindTestInfoByStartDateAndEndDate2(
			List<InfoPo> findTestInfoByStartDateAndEndDate2) {
		this.findTestInfoByStartDateAndEndDate2 = findTestInfoByStartDateAndEndDate2;
	}
	public String getCompanyId3() {
		return companyId3;
	}
	public void setCompanyId3(String companyId3) {
		this.companyId3 = companyId3;
	}
	public String getDeptId3() {
		return deptId3;
	}
	public void setDeptId3(String deptId3) {
		this.deptId3 = deptId3;
	}
	public String getTestInfoId3() {
		return testInfoId3;
	}
	public void setTestInfoId3(String testInfoId3) {
		this.testInfoId3 = testInfoId3;
	}
	public List<InfoPo> getFindTestInfoByStartDateAndEndDate3() {
		return findTestInfoByStartDateAndEndDate3;
	}
	public void setFindTestInfoByStartDateAndEndDate3(
			List<InfoPo> findTestInfoByStartDateAndEndDate3) {
		this.findTestInfoByStartDateAndEndDate3 = findTestInfoByStartDateAndEndDate3;
	}
	public List<InfoPo> getFindChildDeptByCompanyId3() {
		return findChildDeptByCompanyId3;
	}
	public void setFindChildDeptByCompanyId3(List<InfoPo> findChildDeptByCompanyId3) {
		this.findChildDeptByCompanyId3 = findChildDeptByCompanyId3;
	}
	public List<InfoPo> getFindCompany3() {
		return findCompany3;
	}
	public void setFindCompany3(List<InfoPo> findCompany3) {
		this.findCompany3 = findCompany3;
	}

	
	

}
