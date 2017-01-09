package com.srts.estimation.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.estimation.dao.WorkerTestEstimateDao;
import com.srts.estimation.po.SysUserInfoPo;
import com.srts.estimation.po.UserTestEstimateInfoPo;
import com.srts.estimation.service.WorkerTestEstimateService;
import com.srts.learning.domain.Train;
import com.srts.system.dao.Sys_UserDao;
import com.srts.system.domain.Sys_User;

@Service
public class WorkerTestEstimateServiceImpl implements WorkerTestEstimateService {
	@Resource
	private WorkerTestEstimateDao dao;
	@Resource
	private Sys_UserDao sys_UserDao;
	public String dispCategoryUserTestScore(Sys_User usr) {
		String type="模拟";
		List<Integer> list = dao.categoryUserTestScore(usr, type);
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
	public String findUserTestScoreByUserAndType(Sys_User usr) {
		String type="模拟";
		List list = dao.findUserTestScoreByUserAndType(usr, type);
		String userTestScoreList = "{ 'chart': { 'outCnvbaseFont':'Arial','outCnvbaseFontSize':'11'," +
				"'outCnvBaseFontColor':'#000000','bgColor':'#FFFFFF','bgalpha': '100','showBorder':'0'," +
				"'borderColor':'#000000','canvasbgColor':'#FFFFFF','canvasbgAlpha':'100','canvasBorderColor':'#000000'," +
				"'canvasBorderThickness':'1','canvasBorderAlpha':'100','showLabels':'1','labelDisplay':'Rotate','slantLabels':'1'," +
				"'showValues':'1','placeValuesInside':'0','numberprefix': '', 'baseFont':'Arial','baseFontSize':'10','baseFontColor':'#000000'," +
				"'palette': '2', 'showLimits':'0','yAxisMinValue':'0','yAxisMaxValue':'100','divIntervalHints':'10','divLineIsDashed':'1'," +
				"'chartLeftMargin':'5','chartRightMargin':'5','chartTopMargin':'5','chartBottomMargin':'5','captionPadding':'5','xAxisNamePadding':'1'," +
				"'yAxisNamePadding':'1','canvasPadding':'30'},"+ "'data':[";
		int i = 1;
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String score=objs[1].toString();
			String testName=objs[19].toString();
			userTestScoreList+="{'label':'"+testName+"','value':'"+score+"'},";
			i++;
			}
		userTestScoreList+="]}" ;
		return userTestScoreList;
	}
	public String findUserTestScoreRankByUserAndType(Sys_User usr) {
		String type="模拟";
		List list = dao.findUserTestScoreByUserAndType(usr, type);
		String userTestScoreRankList = "{ 'chart': { 'outCnvbaseFont':'Arial','outCnvbaseFontSize':'11','outCnvBaseFontColor':'#000000'," +
		"'bgColor':'#FFFFFF','bgalpha': '100','showBorder':'0','borderColor':'#000000','canvasbgColor':'#FFFFFF'," +
		"'canvasbgAlpha':'100','canvasBorderColor':'#000000','canvasBorderThickness':'1','canvasBorderAlpha':'100'," +
		"'showLabels':'1','labelDisplay':'Rotate','slantLabels':'1','showValues':'1','placeValuesInside':'0','numberprefix': '', " +
		"'baseFont':'Arial','baseFontSize':'10','baseFontColor':'000000','palette': '2', 'showLimits':'0','yAxisMinValue':'0'," +
		"'yAxisMaxValue':'100','divIntervalHints':'10','divLineIsDashed':'1','divlinecolor': '000000', 'vdivlineisdashed': '1'," +
		"'numvdivlines': '10', 'chartLeftMargin':'5','chartRightMargin':'5','chartTopMargin':'5','chartBottomMargin':'5'," +
		"'captionPadding':'5','xAxisNamePadding':'1','yAxisNamePadding':'1','canvasPadding':'30','linecolor': '006e6b', 'anchorradius': '4', " +
		"'anchorbgcolor': '009b83', 'anchorbordercolor': 'FFFFFF', 'anchorborderthickness': '2'},'data': [ ";
		int i = 1;
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			long testPaperId=Long.valueOf(objs[4].toString());
			String testName=dao.findTestNameByTrainAndType("模拟", testPaperId);
			int rank=dao.findUserTestScoreRankByUserAndType(usr, type, testPaperId);
			String rankString=String.valueOf(rank);
			userTestScoreRankList+="{'label':'"+testName+"','value':'"+rankString+"'},";
			i++;
			}
		userTestScoreRankList+="],"+"'styles': {" +
			"'definition': [ { 'name': 'LineShadow', 'type': 'shadow', 'color': '333333', 'distance': '9' } ],"+
			"'application': [ { 'toobject': 'DATAPLOT', 'styles': 'LineShadow' } ]"+
		"} }" ;
		return userTestScoreRankList;
	}
	public String findUserTestScoreStablilityByUserAndType(Sys_User usr) {
		double ave=0;
		double s=0;//方差
		double sd=0;
		double cv=0;
		int i=1;
		String type="模拟";
		String userTestScoreStablilityList = "{ 'chart': { 'outCnvbaseFont':'Arial','outCnvbaseFontSize':'11','outCnvBaseFontColor':'#000000'," +
		"'bgColor':'#FFFFFF','bgalpha': '100','showBorder':'0','borderColor':'#000000','canvasbgColor':'#FFFFFF'," +
		"'canvasbgAlpha':'100','canvasBorderColor':'#000000','canvasBorderThickness':'1','canvasBorderAlpha':'100'," +
		"'showLabels':'1','labelDisplay':'Rotate','slantLabels':'1','showValues':'1','placeValuesInside':'0','numberprefix': '', " +
		"'baseFont':'Arial','baseFontSize':'10','baseFontColor':'000000','palette': '2', 'showLimits':'0','yAxisMinValue':'0'," +
		"'yAxisMaxValue':'1','divIntervalHints':'10','divLineIsDashed':'1','divlinecolor': '000000', 'vdivlineisdashed': '1'," +
		"'numvdivlines': '10', 'chartLeftMargin':'5','chartRightMargin':'5','chartTopMargin':'5','chartBottomMargin':'5'," +
		"'captionPadding':'5','xAxisNamePadding':'1','yAxisNamePadding':'1','canvasPadding':'30','linecolor': '006e6b', 'anchorradius': '4', " +
		"'anchorbgcolor': '009b83', 'anchorbordercolor': 'FFFFFF', 'anchorborderthickness': '2'},'data': [ ";
		List list = dao.findUserTestScoreByUserAndType(usr, type);
		List<Integer> gradeList=new ArrayList<Integer>();
		List<Double> cvList=new ArrayList<Double>();
		List<String> testNameList=new ArrayList<String>();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			long testPaperId=Long.valueOf(objs[4].toString());
			String testName=dao.findTestNameByTrainAndType("模拟", testPaperId);
			testNameList.add(testName);
			gradeList.add(Integer.valueOf(objs[1].toString()));
			}
		Iterator<Integer> iteratorGrade = gradeList.iterator();
		while(iteratorGrade.hasNext()){
			int grade = iteratorGrade.next();
			System.out.println(grade);
			double temp=ave;
			ave=ave+(grade-ave)/i;
			System.out.println(ave);
			s=s+(grade-temp)*(grade-ave);
			if(i==1)
			{
				sd=0;
				cv=0;
			}
			else
			{
				sd=Math.sqrt(s/(i-1));
				cv=sd/ave;
				System.out.println(sd);
				System.out.println(cv);
			}
			cvList.add(cv);
			i++;
		}
		Iterator<Double> iteratorCv = cvList.iterator();
		int j = 1;
		int a=0;
		while(iteratorCv.hasNext()){
			double cvn = iteratorCv.next();
			String cvString=Double.toString(cvn);
			String testNameGet=testNameList.get(a);
			userTestScoreStablilityList+="{'label':'"+testNameGet+"','value':'"+cvString+"'},";
			j++;
			a++;
			}
		userTestScoreStablilityList+="],"+"'styles': { "+
			"'definition': [ { 'name': 'LineShadow', 'type': 'shadow', 'color': '333333', 'distance': '9' } ],"+
			"'application': [ { 'toobject': 'DATAPLOT', 'styles': 'LineShadow' } ]"+
		"} }";
		return userTestScoreStablilityList;
	}
	public List<UserTestEstimateInfoPo> setUserTestEstimateInfo(Sys_User usr) {
		List<UserTestEstimateInfoPo> res=new ArrayList<UserTestEstimateInfoPo>();
		List<Integer> resList0=dao.categoryUserTestScore(usr, "模拟");
		List resList1=dao.findUserTestScoreByUserAndType(usr, "模拟");
		String estimateString="";
		float passRate=0;
		int testNum=0;
		int passNum=0;
		for(int i=0;i<resList0.size();i++)
		{
			testNum+=resList0.get(i);
			if(i!=0)
			{
				passNum+=resList0.get(i);
			}
		}
		if(testNum!=0)
		{
			passRate=(float)passNum/testNum;
			int scoreBelowLine=resList0.get(0);
			int scoreBelowJe=resList0.get(1);
			int scoreBelowJw=resList0.get(2);
			int scoreBelowJb=resList0.get(3);
			int scoreBelowFull=resList0.get(4);
			if(scoreBelowLine>0)
			{
				estimateString+="模拟考试合格率为"+String.valueOf(passRate*100)+"%.";
				estimateString+="历次模拟考试中存在考试不合格的情况,"+"共"+String.valueOf(scoreBelowLine)+"次.";
				Iterator iterator=resList1.iterator();
				String estTemp1="";
				String estTemp2="";
				String estTemp3="";
				String estTemp4="";
				String estTemp5="";
				while(iterator.hasNext())
				{
					Object[] objects=(Object[]) iterator.next();
					if(Integer.parseInt(objects[1].toString())<90)
					{
						estTemp1+=objects[19].toString()+",";
					}
					else if(Integer.parseInt(objects[1].toString())>=90&&Integer.parseInt(objects[1].toString())<=92)
					{
						estTemp2+=objects[19].toString()+",";
					}
					else if(Integer.parseInt(objects[1].toString())>=93&&Integer.parseInt(objects[1].toString())<=95)
					{
						estTemp3+=objects[19].toString()+",";
					}
					else if(Integer.parseInt(objects[1].toString())>=96&&Integer.parseInt(objects[1].toString())<=98)
					{
						estTemp4+=objects[19].toString()+",";
					}
					else if(Integer.parseInt(objects[1].toString())>=99&&Integer.parseInt(objects[1].toString())<=100)
					{
						estTemp5+=objects[19].toString()+",";
					}
				}
				if(estTemp1.equals("")==false)
				{
					estTemp1+="成绩不合格,请重新学习考试相关内容;";
				}
				if(estTemp2.equals("")==false)
				{
					estTemp2+="成绩勉强合格,请复习考试相关内容;";
				}
				if(estTemp3.equals("")==false)
				{
					estTemp3+="成绩一般,有空可以看看这些考试相关内容;";
				}
				if(estTemp4.equals("")==false)
				{
					estTemp4+="成绩良好,考试相关内容掌握的不错;";
				}
				if(estTemp5.equals("")==false)
				{
					estTemp5+="成绩优秀,请继续保持;";
				}
				estimateString+=(estTemp1+estTemp2+estTemp3+estTemp4+estTemp5);
			}
			else if(scoreBelowLine==0)
			{
				estimateString+="模拟考试合格率为100%.";
				Iterator iterator=resList1.iterator();
				String estTemp1="";
				String estTemp2="";
				String estTemp3="";
				String estTemp4="";
				String estTemp5="";
				while(iterator.hasNext())
				{
					Object[] objects=(Object[]) iterator.next();
					if(Integer.parseInt(objects[1].toString())<90)
					{
						estTemp1+=objects[19].toString()+",";
					}
					else if(Integer.parseInt(objects[1].toString())>=90&&Integer.parseInt(objects[1].toString())<=92)
					{
						estTemp2+=objects[19].toString()+",";
					}
					else if(Integer.parseInt(objects[1].toString())>=93&&Integer.parseInt(objects[1].toString())<=95)
					{
						estTemp3+=objects[19].toString()+",";
					}
					else if(Integer.parseInt(objects[1].toString())>=96&&Integer.parseInt(objects[1].toString())<=98)
					{
						estTemp4+=objects[19].toString()+",";
					}
					else if(Integer.parseInt(objects[1].toString())>=99&&Integer.parseInt(objects[1].toString())<=100)
					{
						estTemp5+=objects[19].toString()+",";
					}
				}
				if(estTemp1.equals("")==false)
				{
					estTemp1+="成绩不合格,请重新学习考试相关内容;";
				}
				if(estTemp2.equals("")==false)
				{
					estTemp2+="成绩勉强合格,请复习考试相关内容;";
				}
				if(estTemp3.equals("")==false)
				{
					estTemp3+="成绩一般,有空可以看看这些考试相关内容;";
				}
				if(estTemp4.equals("")==false)
				{
					estTemp4+="成绩良好,考试相关内容掌握的不错;";
				}
				if(estTemp5.equals("")==false)
				{
					estTemp5+="成绩优秀,请继续保持;";
				}
				estimateString+=(estTemp1+estTemp2+estTemp3+estTemp4+estTemp5);
			}
			UserTestEstimateInfoPo temp=new UserTestEstimateInfoPo();
			temp.setEstimateString(estimateString);
			temp.setType("考试成绩评估");
			temp.setId("1");
			res.add(temp);
		}
		else
		{
			UserTestEstimateInfoPo temp=new UserTestEstimateInfoPo();
			temp.setEstimateString("暂时没有进行过模拟考试,无评价");
			temp.setType("考试成绩评估");
			temp.setId("1");
			res.add(temp);
		}
		return res;
	}
	public SysUserInfoPo setSysUserInfoPo(Sys_User usr) {
		SysUserInfoPo user = new SysUserInfoPo();
		user.setName(usr.getName());
		user.setWorkno(usr.getWorkno());
		return user;
	}

}
