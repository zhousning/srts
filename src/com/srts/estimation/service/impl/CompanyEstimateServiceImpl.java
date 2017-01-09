package com.srts.estimation.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.estimation.dao.CompanyEstimateDao;
import com.srts.estimation.po.CompanyEstimateInfoPo;
import com.srts.estimation.po.CompanyTestInfoPo;
import com.srts.estimation.po.InfoPo;
import com.srts.estimation.service.CompanyEstimateService;
import com.srts.examination.dao.TrainTestDao;
import com.srts.examination.domain.TestInfo;
import com.srts.system.dao.DepartmentDao;
import com.srts.system.domain.Sys_Department;

@Service
public class CompanyEstimateServiceImpl implements CompanyEstimateService {
	@Resource
	private CompanyEstimateDao companyEstimateDao;
	@Resource
	private DepartmentDao deptDao;
	@Resource
	private TrainTestDao ttDao;

	public List<CompanyTestInfoPo> findAllTestInfoByAllConditions(
			long companyId, long deptId, String startDate, String endDate,
			long testInfoId) {
		List<CompanyTestInfoPo> resList=new ArrayList<CompanyTestInfoPo>();
		List<String[]> list=companyEstimateDao.findAllTestInfoByAllConditions(companyId, deptId, startDate, endDate, testInfoId);
		for(int i=0;i<list.size();i++)
		{
			CompanyTestInfoPo temp=new CompanyTestInfoPo();
			String id=String.valueOf(i+1);
			String workno=list.get(i)[0];
			String workerName=list.get(i)[1];
			String examName=list.get(i)[7];
			String testDate=list.get(i)[9];
			String grade=list.get(i)[5];
			String dept=list.get(i)[11];
			temp.setId(id);
			temp.setScore(grade);
			temp.setTestDate(testDate);
			temp.setWorkerName(workerName);
			temp.setTestName(examName);
			temp.setDept(dept);
			temp.setWorkno(workno);
			resList.add(temp);
		}
		return resList;
	}

	public String categoryTestScoreByTestCompanyAndDept(long companyId,
			long deptId, long testInfoId) {
		List<String[]> scoreList=companyEstimateDao.findAllTestInfoByAllConditions(companyId, deptId, "", "", testInfoId);
		List<Integer> list=new ArrayList<Integer>();
		int c0=0;
		int c1=0;
		int c2=0;
		int c3=0;
		int c4=0;
		for(int i=0;i<scoreList.size();i++)
		{
			if(Integer.parseInt(scoreList.get(i)[5])<90)
			{
				c0++;
			}
			else if(Integer.parseInt(scoreList.get(i)[5])>=90&&Integer.parseInt(scoreList.get(i)[5])<=92)
			{
				c1++;
			}
			else if(Integer.parseInt(scoreList.get(i)[5])>=93&&Integer.parseInt(scoreList.get(i)[5])<=95)
			{
				c2++;
			}
			else if(Integer.parseInt(scoreList.get(i)[5])>=96&&Integer.parseInt(scoreList.get(i)[5])<=98)
			{
				c3++;
			}
			else if(Integer.parseInt(scoreList.get(i)[5])>=99&&Integer.parseInt(scoreList.get(i)[5])<=100)
			{
				c4++;
			}
		}
		list.add(c0);
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		int tag=0;
		String []category={"<90","90~92","93~95","96~98","99~100"};
		String dispCategory="{ 'chart': { 'outCnvbaseFont':'Arial','outCnvbaseFontSize':'11','outCnvBaseFontColor':'#000000'," +
				"'bgColor':'#FFFFFF','bgalpha': '100','showBorder':'0','borderColor':'#000000'," +
				"'canvasbgColor':'#FFFFFF','canvasbgAlpha':'100','canvasBorderColor':'#000000','canvasBorderThickness':'1','canvasBorderAlpha':'100'," +
				"'showLabels':'1','labelDisplay':'Rotate','slantLabels':'1','showValues':'1','placeValuesInside':'0'," +
				"'numberprefix': '', 'baseFont':'Arial','baseFontSize':'10','baseFontColor':'000000','palette': '3', 'showLimits':'0'," +
				"'yAxisMinValue':'0','yAxisMaxValue':'100','divIntervalHints':'10','divLineIsDashed':'1','divlinecolor': '000000', 'vdivlineisdashed': '1'," +
				"'numvdivlines': '10', 'chartLeftMargin':'5','chartRightMargin':'5','chartTopMargin':'5','chartBottomMargin':'5','captionPadding':'5','xAxisNamePadding':'1','yAxisNamePadding':'1'," +
				"'canvasPadding':'30','numbersuffix': '%','linecolor': '006e6b', 'anchorradius': '4', 'anchorbgcolor': '009b83', 'anchorbordercolor': 'FFFFFF', 'anchorborderthickness': '2', " +
				"'animation': '1', 'pieslicedepth': '20', 'pieRadius':'80','startingangle': '180','showlegend':'1'}, 'data': [ ";
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer obj =  iterator.next();
			String countAmount = obj.toString();			
			String gradeType = category[tag];
			tag++;
			dispCategory+="{'label':'"+gradeType+"','value':'"+countAmount+"'},";
		}
		dispCategory+="],";
		dispCategory+="'styles': { 'definition': [ { 'name': 'LineShadow', 'type': 'shadow', 'color': '333333', 'distance': '9' } ],"+
			"'application': [ { 'toobject': 'DATAPLOT', 'styles': 'LineShadow' } ]"+
		"} }";
		return dispCategory;
	}

	public String selectAveScoreByCompanyAndDept(long companyId, long deptId) {
		List<String[]> aveList=new ArrayList<String[]>();
		List<Long> testIdList = companyEstimateDao.findAllTestInfoId();
		if (testIdList.isEmpty() == false) {
			for (int i = 0; i < testIdList.size(); i++) {
				List<String[]> scoreList = companyEstimateDao
						.findAllTestInfoByAllConditions(companyId, deptId, "",
								"", testIdList.get(i));
				if (scoreList.isEmpty() == false) {
					int sum = 0;
					int amount = scoreList.size();
					for (int j = 0; j < scoreList.size(); j++) {
						sum += Integer.parseInt(scoreList.get(j)[5]);
					}
					String aveScore = String.valueOf((double) sum
							/ (double) amount);
					String testName = scoreList.get(0)[7];
					String[] temp={aveScore,testName};
					aveList.add(temp);
				}
				else
				{
					String aveScore = "0";
					String testName = ttDao.findTestInfo(testIdList.get(i)).getTestName();
					String[] temp={aveScore,testName};
					aveList.add(temp);
				}
			}
		}
		else
		{
			String aveScore = "0";
			String testName = "无记录";
			String[] temp={aveScore,testName};
			aveList.add(temp);
		}
		String aveString = "{\"chart\":{\"caption\":\"各次考试均分/建议值\",\"numdivlines\":\"9\",\"linethickness\":\"2\",\"showvalues\":\"0\",\"anchorradius\":\"3\",\"anchorbgalpha\":\"50\",\"numvdivlines\":\"24\",\"showalternatevgridcolor\":\"1\",\"alternatevgridalpha\":\"3\",\"animation\":\"0\"},\"categories\":" +
				"[{\"category\":[" ;
		for(int j=1;j<aveList.size()+1;j++)
		{
			if(j!=aveList.size()){
				aveString += "{\"label\":\""+aveList.get(j-1)[1]+"\"},";
		}else{
			aveString += "{\"label\":\""+aveList.get(j-1)[1]+"\"}]}]";
			}
		}
		aveString+=",\"dataset\":[";
		String aveString1 = "{\"seriesname\":\"均值\",\"color\":\"800080\",\"anchorbordercolor\":\"800080\",\"data\":[";
		String aveString2 = "{\"seriesname\":\"建议值\",\"color\":\"FF8040\",\"anchorbordercolor\":\"FF8040\",\"data\":[";
		for(int i = 1;i < aveList.size()+1;i++){
			if(i!=aveList.size()){
				aveString1 += "{\"value\":\""+aveList.get(i-1)[0]+"\"},";
				aveString2 += "{\"value\":\""+String.valueOf(90)+"\"},";
			}else{
				aveString1 += "{\"value\":\""+aveList.get(i-1)[0]+"\"}]},";
				aveString2 += "{\"value\":\""+String.valueOf(90)+"\"}]}]}";
				}
		}
		aveString+=aveString1+aveString2;
		return aveString;
	}

	public String selectAveScoreByTestName(long companyId,long testInfoId) {
		List<Sys_Department> list=new ArrayList<Sys_Department>();
		if(companyId==0)
		{
		    list=deptDao.findTopDepartmentList();
		}
		else if(companyId!=0)
		{
			list=deptDao.findChildDepartmentByParentId(companyId);
		}
		List<String[]> aveList=new ArrayList<String[]>();
		//List<String[]> scoreList=companyEstimateDao.findAllTestInfoByAllConditions(companyId, deptId, startDate, endDate, testInfoId);
		if (list.isEmpty() == false) {
			for (int i = 0; i < list.size(); i++) {
				List<String[]> scoreList = companyEstimateDao
						.findAllTestInfoByAllConditions(list.get(i).getId(), 0, "",
								"", testInfoId);
				if (scoreList.isEmpty() == false) {
					int sum = 0;
					int amount = scoreList.size();
					for (int j = 0; j < scoreList.size(); j++) {
						sum += Integer.parseInt(scoreList.get(j)[5]);
					}
					String aveScore = String.valueOf((double) sum
							/ (double) amount);
					String companyName = list.get(i).getName();;
					String[] temp={aveScore,companyName};
					aveList.add(temp);
				}
				else
				{
					String aveScore = "0";
					String companyName = list.get(i).getName();
					String[] temp={aveScore,companyName};
					aveList.add(temp);
				}
			}
		}
		else
		{
			String aveScore = "0";
			String companyName = "无记录";
			String[] temp={aveScore,companyName};
			aveList.add(temp);
		}
		String aveScoreList = "{ 'chart': { 'outCnvbaseFont':'Arial','outCnvbaseFontSize':'11'," +
				"'outCnvBaseFontColor':'#000000','bgColor':'#FFFFFF','bgalpha': '100','showBorder':'0'," +
				"'borderColor':'#000000','canvasbgColor':'#FFFFFF','canvasbgAlpha':'100','canvasBorderColor':'#000000'," +
				"'canvasBorderThickness':'1','canvasBorderAlpha':'100','showLabels':'1','labelDisplay':'Rotate','slantLabels':'1'," +
				"'showValues':'1','placeValuesInside':'0','numberprefix': '', 'baseFont':'Arial','baseFontSize':'10','baseFontColor':'#000000'," +
				"'palette': '2', 'showLimits':'0','yAxisMinValue':'0','yAxisMaxValue':'100','divIntervalHints':'10','divLineIsDashed':'1'," +
				"'chartLeftMargin':'5','chartRightMargin':'5','chartTopMargin':'5','chartBottomMargin':'5','captionPadding':'5','xAxisNamePadding':'1'," +
				"'yAxisNamePadding':'1','canvasPadding':'30'},"+ "'data':[";
		for(int i=0;i<aveList.size();i++)
		{
			aveScoreList+="{'label':'"+aveList.get(i)[1]+"','value':'"+aveList.get(i)[0]+"'},";
		}
		aveScoreList+="]}" ;
		return aveScoreList;
	}

	public List<InfoPo> findTestInfoByStartDateAndEndDate(String startDate,
			String endDate) {
		List<InfoPo> resList=new ArrayList<InfoPo>();
		InfoPo addItem=new InfoPo("0","请选择考试信息/全部");
		resList.add(addItem);
		List<TestInfo> list=companyEstimateDao.findTestListByStartDateAndEndDate(startDate, endDate);
		if(list.isEmpty()==false)
		{
			for(int i=0;i<list.size();i++)
			{
				InfoPo temp=new InfoPo();
				temp.setId(String.valueOf(list.get(i).getId()));
				temp.setName(list.get(i).getTestName());
				resList.add(temp);
			}
		}
		else
		{
			InfoPo temp=new InfoPo("0","无考试信息");
			resList.add(temp);
		}
		return resList;
	}

	public List<InfoPo> findChildDeptByCompanyId(long companyId) {
		List<InfoPo> resList=new ArrayList<InfoPo>();
		List<Sys_Department> list=deptDao.findChildDepartmentByParentId(companyId);
		InfoPo addItem=new InfoPo("0","全部");
		resList.add(addItem);
		if(list.isEmpty()==false)
		{
			for(int i=0;i<list.size();i++)
			{
				InfoPo temp=new InfoPo();
				temp.setId(String.valueOf(list.get(i).getId()));
				temp.setName(list.get(i).getName());
				resList.add(temp);
			}
		}
		else
		{
			InfoPo temp=new InfoPo("0","无下属部门");
			resList.add(temp);
		}
		return resList;
	}

	public List<InfoPo> findCompany() {
		List<InfoPo> resList=new ArrayList<InfoPo>();
		List<Sys_Department> list=deptDao.findTopDepartmentList();
		InfoPo addItem=new InfoPo("0","全部");
		resList.add(addItem);
		if(list.isEmpty()==false)
		{
			for(int i=0;i<list.size();i++)
			{
				InfoPo temp=new InfoPo();
				temp.setId(String.valueOf(list.get(i).getId()));
				temp.setName(list.get(i).getName());
				resList.add(temp);
			}
		}
		else
		{
			InfoPo temp=new InfoPo("0","无公司信息");
			resList.add(temp);
		}
		return resList;
	}

	public CompanyEstimateInfoPo setEstimateInfo(long companyId, long deptId,
			String startDate, String endDate, long testInfoId) {
		List<String[]> list=companyEstimateDao.findAllTestInfoByAllConditions(companyId, deptId, startDate, endDate, testInfoId);
		CompanyEstimateInfoPo estInfo=new CompanyEstimateInfoPo();
		if(list.isEmpty()==false)
		{
			if(companyId==0&&deptId==0&&testInfoId==0)
			{
				double aveScore=0;
				double passRate=0;
				int sum=0;
				int pass=0;
				int amount=list.size();
				for(int i=0;i<list.size();i++)
				{
					sum+=Integer.parseInt(list.get(i)[5]);
					if(Integer.parseInt(list.get(i)[5])>=90)
					{
						pass++;
					}
				}
				aveScore=(double)sum/(double)amount;
				passRate=(double)pass/(double)amount;
				String id="1";
				String type="各单位历次考试总评";
				String estString="考试总体合格率为"+String.valueOf(passRate*100)+"%,"+"平均分为:"+String.valueOf(aveScore)+",";
				if(passRate>0.98&&aveScore>95)
				{
					estString+="考试情况很好,希望继续保持";
				}
				else if(passRate>0.95&&aveScore>90)
				{
					estString+="考试情况良好,希望继续保持";
				}
				else if(passRate>0.90&&aveScore>90)
				{
					estString+="考试情况达标,请继续努力";
				}
				else
				{
					estString+="考试情况不理想,请督促各单位学习";
				}
				estInfo.setId(id);
				estInfo.setType(type);
				estInfo.setEstString(estString);
			}
			else if(companyId!=0&&deptId==0&&testInfoId==0)
			{
				double aveScore=0;
				double passRate=0;
				String companyName=deptDao.getById(companyId).getName();
				int sum=0;
				int pass=0;
				int amount=list.size();
				for(int i=0;i<list.size();i++)
				{
					sum+=Integer.parseInt(list.get(i)[5]);
					if(Integer.parseInt(list.get(i)[5])>=90)
					{
						pass++;
					}
				}
				aveScore=(double)sum/(double)amount;
				passRate=(double)pass/(double)amount;
				String id="1";
				String type=companyName+"历次考试总评";
				String estString="考试总体合格率为"+String.valueOf(passRate*100)+"%,"+"平均分为:"+String.valueOf(aveScore)+",";
				if(passRate>0.98&&aveScore>95)
				{
					estString+="考试情况很好,希望继续保持";
				}
				else if(passRate>0.95&&aveScore>90)
				{
					estString+="考试情况良好,希望继续保持";
				}
				else if(passRate>0.90&&aveScore>90)
				{
					estString+="考试情况达标,请继续努力";
				}
				else
				{
					estString+="考试情况不理想,请督促各单位学习";
				}
				estInfo.setId(id);
				estInfo.setType(type);
				estInfo.setEstString(estString);
				
			}
			else if(companyId!=0&&deptId!=0&&testInfoId==0)
			{
				double aveScore=0;
				double passRate=0;
				String companyName=deptDao.getById(deptId).getName();
				int sum=0;
				int pass=0;
				int amount=list.size();
				for(int i=0;i<list.size();i++)
				{
					sum+=Integer.parseInt(list.get(i)[5]);
					if(Integer.parseInt(list.get(i)[5])>=90)
					{
						pass++;
					}
				}
				aveScore=(double)sum/(double)amount;
				passRate=(double)pass/(double)amount;
				String id="1";
				String type=companyName+"历次考试总评";
				String estString="考试总体合格率为"+String.valueOf(passRate*100)+"%,"+"平均分为:"+String.valueOf(aveScore)+",";
				if(passRate>0.98&&aveScore>95)
				{
					estString+="考试情况很好,希望继续保持";
				}
				else if(passRate>0.95&&aveScore>90)
				{
					estString+="考试情况良好,希望继续保持";
				}
				else if(passRate>0.90&&aveScore>90)
				{
					estString+="考试情况达标,请继续努力";
				}
				else
				{
					estString+="考试情况不理想,请督促各单位学习";
				}
				estInfo.setId(id);
				estInfo.setType(type);
				estInfo.setEstString(estString);
				
			}
			else if(companyId!=0&&deptId==0&&testInfoId!=0)
			{
				double aveScore=0;
				double passRate=0;
				String companyName=deptDao.getById(companyId).getName();
				String testName=ttDao.findTestInfo(testInfoId).getTestName();
				int sum=0;
				int pass=0;
				int amount=list.size();
				for(int i=0;i<list.size();i++)
				{
					sum+=Integer.parseInt(list.get(i)[5]);
					if(Integer.parseInt(list.get(i)[5])>=90)
					{
						pass++;
					}
				}
				aveScore=(double)sum/(double)amount;
				passRate=(double)pass/(double)amount;
				String id="1";
				String type=companyName+testName+"考试评价";
				String estString="考试总体合格率为"+String.valueOf(passRate*100)+"%,"+"平均分为:"+String.valueOf(aveScore)+",";
				if(passRate>0.98&&aveScore>95)
				{
					estString+="考试情况很好,希望继续保持";
				}
				else if(passRate>0.95&&aveScore>90)
				{
					estString+="考试情况良好,希望继续保持";
				}
				else if(passRate>0.90&&aveScore>90)
				{
					estString+="考试情况达标,请继续努力";
				}
				else
				{
					estString+="考试情况不理想,请督促各单位学习";
				}
				estInfo.setId(id);
				estInfo.setType(type);
				estInfo.setEstString(estString);
			}
			else if(companyId!=0&&deptId!=0&&testInfoId!=0)
			{
				double aveScore=0;
				double passRate=0;
				String companyName=deptDao.getById(deptId).getName();
				String testName=ttDao.findTestInfo(testInfoId).getTestName();
				int sum=0;
				int pass=0;
				int amount=list.size();
				for(int i=0;i<list.size();i++)
				{
					sum+=Integer.parseInt(list.get(i)[5]);
					if(Integer.parseInt(list.get(i)[5])>=90)
					{
						pass++;
					}
				}
				aveScore=(double)sum/(double)amount;
				passRate=(double)pass/(double)amount;
				String id="1";
				String type=companyName+testName+"考试评价";
				String estString="考试总体合格率为"+String.valueOf(passRate*100)+"%,"+"平均分为:"+String.valueOf(aveScore)+",";
				if(passRate>0.98&&aveScore>95)
				{
					estString+="考试情况很好,希望继续保持";
				}
				else if(passRate>0.95&&aveScore>90)
				{
					estString+="考试情况良好,希望继续保持";
				}
				else if(passRate>0.90&&aveScore>90)
				{
					estString+="考试情况达标,请继续努力";
				}
				else
				{
					estString+="考试情况不理想,请督促各单位学习";
				}
				estInfo.setId(id);
				estInfo.setType(type);
				estInfo.setEstString(estString);
			}
		}
		else
		{
			String id="1";
			String type="考试评价";
			String estString="暂时无考试评价信息";
			estInfo.setId(id);
			estInfo.setType(type);
			estInfo.setEstString(estString);
		}
		return estInfo;
	}

}
