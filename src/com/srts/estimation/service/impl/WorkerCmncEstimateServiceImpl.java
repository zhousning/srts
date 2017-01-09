package com.srts.estimation.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.estimation.dao.WorkerCmncEstimateDao;
import com.srts.estimation.po.UserCmncEstimatePo;
import com.srts.estimation.service.WorkerCmncEstimateService;
import com.srts.learning.domain.ErrorSetFlagSum;
import com.srts.system.domain.Sys_User;

@Service
public class WorkerCmncEstimateServiceImpl implements WorkerCmncEstimateService {
	
	@Resource
	private WorkerCmncEstimateDao workerCmncEstimateDao;

	public String selectWorkerAcpRatePerMonth(Sys_User usr) {
		List<String[]> res=workerCmncEstimateDao.selectWorkerAcpRatePerMonth(usr);
		String resString = "{'chart': {'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','divlinecolor': '91AF46','xaxisname': '月份','yaxisname':'回答被采纳率','caption': '月回答采纳率统计变化趋势','divlinealpha': '30','showvalues': '0','bgcolor': '009b83,FFFFFF','anchorradius': '5','anchorsides': '3','yaxismaxvalue': '1'}," +
		"'data':[";
		for(int i=0;i<res.size();i++)
		{
			resString+="{'value':'"+res.get(i)[0]+"','label':'"+res.get(i)[1]+"'},";
		}	
		resString+="]," +
		"'trendlines':[{'line':[" +
		"{'color': 'BC9F3F','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '很高','endvalue': '1.0','startvalue': '0.5'}," +
		"{'color': '894D1B','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '较高','endvalue': '0.5','startvalue': '0.3'}," +
		"{'color': '000111','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '一般','endvalue': '0.3','startvalue': '0,1'}," +
		"{'color': 'f7ab00','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '较低','endvalue': '0.1','startvalue': '0'},]}]}";
		return resString;
	}

	public String selectWorkerProCmncAcp(Sys_User usr) {
		List<String[]> list=workerCmncEstimateDao.selectWorkerProCmncAcp(usr);
		String resString = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'个人回答总量分类统计','xAxisName':'类别','yAxisName':'次数','numberPrefix':'次'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			resString+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		resString+="]}";
		return resString;
	}

	public String selectWorkerProCmncAmount(Sys_User usr) {
		List<String[]> list=workerCmncEstimateDao.selectWorkerProCmncAmount(usr);
		String resString = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'个人回答总量分类统计','xAxisName':'类别','yAxisName':'次数','numberPrefix':'次'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			resString+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		resString+="]}";
		return resString;
	}

	public String selectWorkerProCmncAmountToMonth(Sys_User usr) {
		List<String[]> list=workerCmncEstimateDao.selectWorkerProCmncAmountToMonth(usr);
		String resString = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'本月个人回答总量分类统计','xAxisName':'类别','yAxisName':'次数','numberPrefix':'次'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			resString+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		resString+="]}";
		return resString;
	}

	public String selectWorkerProCmncAmountToWeek(Sys_User usr) {
		List<String[]> list=workerCmncEstimateDao.selectWorkerProCmncAmountToWeek(usr);
		String resString = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'本周个人回答总量分类统计','xAxisName':'类别','yAxisName':'次数','numberPrefix':'次'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			resString+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		resString+="]}";
		return resString;
	}

	public String selectWorkerStuCmncAmount(Sys_User usr) {
		List<String[]> list=workerCmncEstimateDao.selectWorkerStuCmncAmount(usr);
		String resString = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'个人学习交流信息总量分类统计','xAxisName':'类别','yAxisName':'次数','numberPrefix':'次'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			resString+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		resString+="]}";
		return resString;
	}

	public String selectWorkerStuCmncAmountToMonth(Sys_User usr) {
		List<String[]> list=workerCmncEstimateDao.selectWorkerStuCmncAmountToMonth(usr);
		String resString = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'本月个人学习交流信息总量分类统计','xAxisName':'类别','yAxisName':'次数','numberPrefix':'次'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			resString+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		resString+="]}";
		return resString;
	}

	public String selectWorkerStuCmncAmountToWeek(Sys_User usr) {
		List<String[]> list=workerCmncEstimateDao.selectWorkerStuCmncAmountToWeek(usr);
		String resString = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'本周个人学习交流信息总量分类统计','xAxisName':'类别','yAxisName':'次数','numberPrefix':'次'},'data':[";
		Iterator<String[]> iterator = list.iterator();
		while(iterator.hasNext()){
			String[] obj =  iterator.next();
			String state = obj[1];			
			String countAmount = obj[0];
			resString+="{'label':'"+state+"','value':'"+countAmount+"'},";
		}
		resString+="]}";
		return resString;
	}

	public List<UserCmncEstimatePo> setWorkerCmncEstimateInfo(Sys_User usr) {
		List<String[]> list0=workerCmncEstimateDao.selectWorkerStuCmncAmountToWeek(usr);
		List<String[]> list1=workerCmncEstimateDao.selectWorkerStuCmncAmountToMonth(usr);
		List<String[]> list2=workerCmncEstimateDao.selectWorkerProCmncAmountToWeek(usr);
		List<String[]> list3=workerCmncEstimateDao.selectWorkerProCmncAmountToMonth(usr);
		List<String[]> list4=workerCmncEstimateDao.selectWorkerAcpRatePerMonth(usr);
		List<String[]> list5=workerCmncEstimateDao.selectWorkerProCmncAcp(usr);
		List<UserCmncEstimatePo> resList=new ArrayList<UserCmncEstimatePo>();
		String estString0="";
		UserCmncEstimatePo temp0=new UserCmncEstimatePo();
		for(int i=0;i<list0.size();i++)
		{
			if(i==0)
			{
				estString0+="本周发帖"+list0.get(i)[0]+"次,";
				if(Integer.parseInt(list0.get(i)[0])<5)
				{
					estString0+="本周发帖次数不多,有什么话想说的可以发帖交流.";
				}
				else if(Integer.parseInt(list0.get(i)[0])>=5&&Integer.parseInt(list0.get(i)[0])<10)
				{
					estString0+="发帖交流次数正常,有空的话去看看论坛的学友们的回复吧.";
				}
				else if(Integer.parseInt(list0.get(i)[0])>=10)
				{
					estString0+="发帖次数过多,经常发起讨论没事,但是学习课程和练习更加重要.";
				}
			}
			else if(i==1)
			{
				estString0+="本周回复"+list0.get(i)[0]+"次,";
				if(Integer.parseInt(list0.get(i)[0])<5)
				{
					estString0+="本周回复次数不多,多去看看论坛交流交流吧.";
				}
				else if(Integer.parseInt(list0.get(i)[0])>=5&&Integer.parseInt(list0.get(i)[0])<40)
				{
					estString0+="回复交流次数正常,有空的话去看看论坛的学友们的回复吧.";
				}
				else if(Integer.parseInt(list0.get(i)[0])>=40)
				{
					estString0+="回复次数过多,经常参与讨论没事,但是学习课程和练习更加重要.";
				}
			}
		}
		temp0.setId("1");
		temp0.setType("本周论坛交流评估");
		temp0.setEstimateString(estString0);
		String estString1="";
		UserCmncEstimatePo temp1=new UserCmncEstimatePo();
		for(int i=0;i<list1.size();i++)
		{
			if(i==0)
			{
				estString1+="本月发帖"+list0.get(i)[0]+"次,";
				if(Integer.parseInt(list0.get(i)[0])<5)
				{
					estString1+="本月发帖次数不多,有什么话想说的可以发帖交流.";
				}
				else if(Integer.parseInt(list0.get(i)[0])>=5&&Integer.parseInt(list0.get(i)[0])<20)
				{
					estString1+="发帖交流次数正常,有空的话去看看论坛的学友们的回复吧.";
				}
				else if(Integer.parseInt(list0.get(i)[0])>=20)
				{
					estString1+="发帖次数过多,经常发起讨论没事,但是学习课程和练习更加重要.";
				}
			}
			else if(i==1)
			{
				estString1+="本月回复"+list0.get(i)[0]+"次,";
				if(Integer.parseInt(list0.get(i)[0])<15)
				{
					estString1+="本周回复次数不多,多去看看论坛交流交流吧.";
				}
				else if(Integer.parseInt(list0.get(i)[0])>=15&&Integer.parseInt(list0.get(i)[0])<70)
				{
					estString1+="回复交流次数正常,有空的话去看看论坛的学友们的回复吧.";
				}
				else if(Integer.parseInt(list0.get(i)[0])>=70)
				{
					estString1+="回复次数过多,经常参与讨论没事,但是学习课程和练习更加重要.";
				}
			}
		}
		temp1.setId("2");
		temp1.setType("本月论坛交流评估");
		temp1.setEstimateString(estString1);
		//论坛交流评估
		String estString2="";
		UserCmncEstimatePo temp2=new UserCmncEstimatePo();
		for(int i=0;i<list2.size();i++)
		{
			if(i==0)
			{
				estString2+="本周提问"+list2.get(i)[0]+"次,";
				if(Integer.parseInt(list2.get(i)[0])<5)
				{
					estString2+="本周提问次数不多,有什么不懂得可以论文提问交流.";
				}
				else if(Integer.parseInt(list2.get(i)[0])>=5&&Integer.parseInt(list2.get(i)[0])<10)
				{
					estString2+="提问交流次数正常,有空的话去看看论坛的学友们的回复吧.";
				}
				else if(Integer.parseInt(list2.get(i)[0])>=10)
				{
					estString2+="提问次数过多,经常提问没事,最好是能自己学习课程找到答案.";
				}
			}
			else if(i==1)
			{
				estString2+="本周回答问题"+list1.get(i)[0]+"次,";
				if(Integer.parseInt(list1.get(i)[0])<5)
				{
					estString2+="本周回答问题不多,多去看看论坛交流交流吧.";
				}
				else if(Integer.parseInt(list1.get(i)[0])>=5&&Integer.parseInt(list1.get(i)[0])<40)
				{
					estString2+="回答问题频率正常,有空的话去看看论坛的学友们的回复吧.";
				}
				else if(Integer.parseInt(list1.get(i)[0])>=40)
				{
					estString2+="回答问题较为频繁,经常解决没事,学习课程和练习也很重要.";
				}
			}
		}
		temp2.setId("3");
		temp2.setType("本周论坛问题交流评估");
		temp2.setEstimateString(estString2);
		String estString3="";
		UserCmncEstimatePo temp3=new UserCmncEstimatePo();
		for(int i=0;i<list3.size();i++)
		{
			if(i==0)
			{
				estString3+="本月提问"+list3.get(i)[0]+"次,";
				if(Integer.parseInt(list3.get(i)[0])<5)
				{
					estString3+="本月提问次数不多,有什么不懂得可以论文提问交流.";
				}
				else if(Integer.parseInt(list3.get(i)[0])>=5&&Integer.parseInt(list3.get(i)[0])<10)
				{
					estString3+="提问交流次数正常,有空的话去看看论坛的学友们的回复吧.";
				}
				else if(Integer.parseInt(list3.get(i)[0])>=10)
				{
					estString3+="提问次数过多,经常提问没事,最好是能自己学习课程找到答案.";
				}
			}
			else if(i==1)
			{
				estString0+="本月回答问题"+list3.get(i)[0]+"次,";
				if(Integer.parseInt(list3.get(i)[0])<5)
				{
					estString3+="本月回答问题不多,多去看看论坛交流交流吧.";
				}
				else if(Integer.parseInt(list3.get(i)[0])>=5&&Integer.parseInt(list3.get(i)[0])<40)
				{
					estString3+="回答问题频率正常,有空的话去看看论坛的学友们的回复吧.";
				}
				else if(Integer.parseInt(list3.get(i)[0])>=40)
				{
					estString3+="回答问题较为频繁,经常解决没事,学习课程和练习也很重要.";
				}
			}
		}
		temp3.setId("4");
		temp3.setType("本月论坛问题交流评估");
		temp3.setEstimateString(estString3);
		String estString4="";
		UserCmncEstimatePo temp4=new UserCmncEstimatePo();
		estString4+="本月回答被采纳率为"+list4.get(list4.size()-1)[0]+",";
		if(Float.parseFloat(list4.get(list4.size()-1)[0])>Float.parseFloat(list4.get(list4.size()-2)[0]))
		{
			estString4+="本月回答被采纳率比上月略有提升,恭喜,请继续努力";
		}
		else if(Float.parseFloat(list4.get(list4.size()-1)[0])==Float.parseFloat(list4.get(list4.size()-2)[0]))
		{
			estString4+="本月回答被采纳率和上月持平";
		}
		else if(Float.parseFloat(list4.get(list4.size()-1)[0])<Float.parseFloat(list4.get(list4.size()-2)[0]))
		{
			estString4+="本月回答被采纳率比上月有所降低,检查检查平时的学习疏漏吧,请加油.";
		}
		if(Float.parseFloat(list4.get(list4.size()-1)[0])==0)
		{
			estString4+="暂时还没有回答或被采纳回答,请加油.";
		}
		else if(Float.parseFloat(list4.get(list4.size()-1)[0])>0&&Float.parseFloat(list4.get(list4.size()-1)[0])<=0.2)
		{
			estString4+="回答被采纳率略低,请加油.";
		}
		else if(Float.parseFloat(list4.get(list4.size()-1)[0])>0.2&&Float.parseFloat(list4.get(list4.size()-1)[0])<=0.5)
		{
			estString4+="回答被采纳率正常,请继续努力.";
		}
		else if(Float.parseFloat(list4.get(list4.size()-1)[0])>0.5)
		{
			estString4+="回答被采纳率很高,知识掌握的不错.";
		}
		estString4+="历史回答次数为"+list5.get(0)[0]+",";
		estString4+="被采纳次数为"+list5.get(1)[0]+",";
		estString4+="未被采纳次数为"+list5.get(2)[0]+",";
		temp4.setId("5");
		temp4.setType("论坛问题回答评估");
		temp4.setEstimateString(estString4);
		resList.add(temp0);
		resList.add(temp1);
		resList.add(temp2);
		resList.add(temp3);
		resList.add(temp4);
		return resList;
	}

}
