package com.srts.estimation.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.estimation.dao.WorkerKlgBankEstimateDao;
import com.srts.estimation.po.UserKlgBankSearchRecordPo;
import com.srts.estimation.po.UserKlgBankSearchEstPo;
import com.srts.estimation.service.WorkerKlgBankEstimateService;
import com.srts.system.domain.Sys_User;

@Service
public class WorkerKlgBankEstimateServiceImpl implements
		WorkerKlgBankEstimateService {
	
	@Resource
	private WorkerKlgBankEstimateDao workerKlgBankEstimateDao;

	public List<UserKlgBankSearchRecordPo> findWorkerKlgSearchRecord(
			Sys_User usr, String startDate, String endDate, String type) {
		List<String[]> list=workerKlgBankEstimateDao.findWorkerKlgSearchRecord(usr, startDate, endDate, type);
		List<UserKlgBankSearchRecordPo> res=new ArrayList<UserKlgBankSearchRecordPo>();
		if(list.size()==0)
		{
			UserKlgBankSearchRecordPo temp=new UserKlgBankSearchRecordPo("无记录","无记录","无记录","无记录","无记录");
			res.add(temp);
		}
		for(int i=0;i<list.size();i++)
		{
			UserKlgBankSearchRecordPo temp=new UserKlgBankSearchRecordPo(list.get(i)[0],list.get(i)[1],list.get(i)[2],list.get(i)[3],list.get(i)[4]);
			res.add(temp);
		}
		return res;
	}

	public String workerKlgSearchEst(Sys_User usr) {
		List<String[]> list=workerKlgBankEstimateDao.workerKlgSearchEst(usr);
		String workerKlgBankEstimate = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'知识库搜索总量统计','xAxisName':'类别','yAxisName':'查看次数','numberPrefix':'次'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			workerKlgBankEstimate+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		workerKlgBankEstimate+="]}";
		return workerKlgBankEstimate;
	}

	public String workerKlgSearchEstToMonth(Sys_User usr) {
		List<String[]> list=workerKlgBankEstimateDao.workerKlgSearchEstToMonth(usr);
		String workerKlgBankEstimate = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'本月知识库搜索统计','xAxisName':'类别','yAxisName':'查看次数','numberPrefix':'次'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			workerKlgBankEstimate+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		workerKlgBankEstimate+="]}";
		return workerKlgBankEstimate;
	}

	public String workerKlgSearchEstToWeek(Sys_User usr) {
		List<String[]> list=workerKlgBankEstimateDao.workerKlgSearchEstToWeek(usr);
		String workerKlgBankEstimate = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'本周知识库搜索统计','xAxisName':'类别','yAxisName':'查看次数','numberPrefix':'次'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			workerKlgBankEstimate+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		workerKlgBankEstimate+="]}";
		return workerKlgBankEstimate;
	}

	public String workerKlgSearchEstToday(Sys_User usr) {
		List<String[]> list=workerKlgBankEstimateDao.workerKlgSearchEstToday(usr);
		String workerKlgBankEstimate = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'本日知识库搜索统计','xAxisName':'类别','yAxisName':'查看次数','numberPrefix':'次'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			workerKlgBankEstimate+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		workerKlgBankEstimate+="]}";
		return workerKlgBankEstimate;
	}

	public String workerOpExpUploadToMonth(Sys_User usr) {
		List<String[]> list=workerKlgBankEstimateDao.workerOpExpUploadToMonth(usr);
		String workerOpExpUpload = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'本月操作经验上传统计','xAxisName':'审核状态','yAxisName':'经验条目数','numberPrefix':'条'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			workerOpExpUpload+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		workerOpExpUpload+="]}";
		return workerOpExpUpload;
	}

	public String workerOpExpUploadToWeek(Sys_User usr) {
		List<String[]> list=workerKlgBankEstimateDao.workerOpExpUploadToWeek(usr);
		String workerOpExpUpload = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'本周操作经验上传统计','xAxisName':'审核状态','yAxisName':'经验条目数','numberPrefix':'条'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			workerOpExpUpload+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		workerOpExpUpload+="]}";
		return workerOpExpUpload;
	}

	public String workerOpExpUploadToday(Sys_User usr) {
		List<String[]> list=workerKlgBankEstimateDao.workerOpExpUploadToday(usr);
		String workerOpExpUpload = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'本日操作经验上传统计','xAxisName':'审核状态','yAxisName':'经验条目数','numberPrefix':'条'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			workerOpExpUpload+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		workerOpExpUpload+="]}";
		return workerOpExpUpload;
	}

	public List<UserKlgBankSearchEstPo> setUserKlgBankEstimateInfoPo(
			Sys_User usr) {
        List<UserKlgBankSearchEstPo> resList=new ArrayList<UserKlgBankSearchEstPo>();
		List<String[]> listSearchWeek=workerKlgBankEstimateDao.workerKlgSearchEstToWeek(usr);
		List<String[]> listSearchMonth=workerKlgBankEstimateDao.workerKlgSearchEstToMonth(usr);
		List<String[]> listUploadWeek=workerKlgBankEstimateDao.workerOpExpUploadToWeek(usr);
		List<String[]> listUploadMonth=workerKlgBankEstimateDao.workerOpExpUploadToMonth(usr);
		UserKlgBankSearchEstPo temp=new UserKlgBankSearchEstPo();
		String estimateString="";
		for(int i=0;i<listSearchWeek.size();i++)
		{
			if(Integer.parseInt(listSearchWeek.get(i)[0])==0)
			{
				estimateString+="本周"+listSearchWeek.get(i)[1]+"检索次数为0,多检索检索其中内容吧.";
			}
			else if(Integer.parseInt(listSearchWeek.get(i)[0])>=1&&Integer.parseInt(listSearchWeek.get(i)[0])<=40)
			{
				estimateString+="本周"+listSearchWeek.get(i)[1]+"检索次数为"+listSearchWeek.get(i)[0]+",知识库检索虽然可以快速查到知识条目,但是自己记住更好.";
			}
			else if(Integer.parseInt(listSearchWeek.get(i)[0])>40)
			{
				estimateString+="本周"+listSearchWeek.get(i)[1]+"检索次数为"+listSearchWeek.get(i)[0]+",有空请返回学习模块多看多练.";
			}
		}
		temp.setId("1");
		temp.setType("知识库检索周评估");
		temp.setEstimateString(estimateString);
		resList.add(temp);
		UserKlgBankSearchEstPo temp1=new UserKlgBankSearchEstPo();
		String estimateString1="";
		for(int i=0;i<listSearchWeek.size();i++)
		{
			if(Integer.parseInt(listSearchMonth.get(i)[0])==0)
			{
				estimateString1+="本月"+listSearchMonth.get(i)[1]+"检索次数为0,多检索检索其中内容吧.";
			}
			else if(Integer.parseInt(listSearchMonth.get(i)[0])>=1&&Integer.parseInt(listSearchMonth.get(i)[0])<=100)
			{
				estimateString1+="本月"+listSearchMonth.get(i)[1]+"检索次数为"+listSearchMonth.get(i)[0]+",知识库检索虽然可以快速查到知识条目,但是自己记住更好.";
			}
			else if(Integer.parseInt(listSearchMonth.get(i)[0])>100)
			{
				estimateString1+="本月"+listSearchMonth.get(i)[1]+"检索次数为"+listSearchMonth.get(i)[0]+",有空请返回学习模块多看多练.";
			}
		}
		temp1.setId("2");
		temp1.setType("知识库检索月评估");
		temp1.setEstimateString(estimateString1);
		resList.add(temp1);
		UserKlgBankSearchEstPo temp2=new UserKlgBankSearchEstPo();
		String estimateString2="";
			if(Integer.parseInt(listUploadWeek.get(0)[0])==0&&Integer.parseInt(listUploadWeek.get(1)[0])==0)
			{
				estimateString2+="本周未上传操作经验,有好的操作经验记得分享.";
			}
			else if(Integer.parseInt(listUploadWeek.get(0)[0])>=0&&Integer.parseInt(listUploadWeek.get(0)[0])<=10&&Integer.parseInt(listUploadWeek.get(1)[0])<=10)
			{
				estimateString2+="本周上传操作经验共"+String.valueOf(Integer.parseInt(listUploadWeek.get(0)[0])+Integer.parseInt(listUploadWeek.get(1)[0]))+"条";
				estimateString2+="其中审核通过"+listUploadWeek.get(0)[0]+"条,待审核"+listUploadWeek.get(1)[0]+"条.";
				estimateString2+="自己的操作经验分享完了也记得看看别人的操作经验,这样更容易进步.";
			}
			else if(Integer.parseInt(listUploadWeek.get(0)[0])>=0&&Integer.parseInt(listUploadWeek.get(0)[0])<=10&&Integer.parseInt(listUploadWeek.get(1)[0])>10)
			{
				estimateString2+="本周上传操作经验共"+String.valueOf(Integer.parseInt(listUploadWeek.get(0)[0])+Integer.parseInt(listUploadWeek.get(1)[0]))+"条";
				estimateString2+="其中审核通过"+listUploadWeek.get(0)[0]+"条,待审核"+listUploadWeek.get(1)[0]+"条.";
				estimateString2+="自己的操作经验分享完了也记得看看别人的操作经验,记得注意自己先看看上传的操作经验有没有错,这样更容易进步.";
			}
			else if(Integer.parseInt(listUploadWeek.get(0)[0])>10)
			{
				estimateString2+="本周上传操作经验共"+String.valueOf(Integer.parseInt(listUploadWeek.get(0)[0])+Integer.parseInt(listUploadWeek.get(1)[0]))+"条";
				estimateString2+="其中审核通过"+listUploadWeek.get(0)[0]+"条,待审核"+listUploadWeek.get(1)[0]+"条.";
				estimateString2+="上传的足够多了,分几周上传更有利于别人消化理解操作经验.";
			}
		temp2.setId("3");
		temp2.setType("操作经验上传周评估");
		temp2.setEstimateString(estimateString2);
		resList.add(temp2);
		UserKlgBankSearchEstPo temp3=new UserKlgBankSearchEstPo();
		String estimateString3="";
			if(Integer.parseInt(listUploadWeek.get(0)[0])==0&&Integer.parseInt(listUploadWeek.get(1)[0])==0)
			{
				estimateString3+="本月未上传操作经验,有好的操作经验记得分享.";
			}
			else if(Integer.parseInt(listUploadWeek.get(0)[0])>=0&&Integer.parseInt(listUploadWeek.get(0)[0])<=20&&Integer.parseInt(listUploadWeek.get(1)[0])<=10)
			{
				estimateString3+="本月上传操作经验共"+String.valueOf(Integer.parseInt(listUploadWeek.get(0)[0])+Integer.parseInt(listUploadWeek.get(1)[0]))+"条";
				estimateString3+="其中审核通过"+listUploadWeek.get(0)[0]+"条,待审核"+listUploadWeek.get(1)[0]+"条.";
				estimateString3+="自己的操作经验分享完了也记得看看别人的操作经验,这样更容易进步.";
			}
			else if(Integer.parseInt(listUploadWeek.get(0)[0])>=0&&Integer.parseInt(listUploadWeek.get(0)[0])<=20&&Integer.parseInt(listUploadWeek.get(1)[0])>10)
			{
				estimateString3+="本月上传操作经验共"+String.valueOf(Integer.parseInt(listUploadWeek.get(0)[0])+Integer.parseInt(listUploadWeek.get(1)[0]))+"条";
				estimateString3+="其中审核通过"+listUploadWeek.get(0)[0]+"条,待审核"+listUploadWeek.get(1)[0]+"条.";
				estimateString3+="自己的操作经验分享完了也记得看看别人的操作经验,记得注意自己先看看上传的操作经验有没有错,这样更容易进步.";
			}
			else if(Integer.parseInt(listUploadWeek.get(0)[0])>20)
			{
				estimateString3+="本月上传操作经验共"+String.valueOf(Integer.parseInt(listUploadWeek.get(0)[0])+Integer.parseInt(listUploadWeek.get(1)[0]))+"条";
				estimateString3+="其中审核通过"+listUploadWeek.get(0)[0]+"条,待审核"+listUploadWeek.get(1)[0]+"条.";
				estimateString3+="上传的足够多了,分几月上传更有利于别人消化理解操作经验.";
			}
		temp3.setId("4");
		temp3.setType("操作经验上传月评估");
		temp3.setEstimateString(estimateString3);
		resList.add(temp3);
		return resList;
	}

}
