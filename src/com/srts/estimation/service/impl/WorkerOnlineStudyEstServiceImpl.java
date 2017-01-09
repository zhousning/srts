package com.srts.estimation.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.estimation.dao.WorkerOnlineStudyEstDao;
import com.srts.estimation.po.UserEstimatePo;
import com.srts.estimation.po.UserInfoPo;
import com.srts.estimation.service.WorkerOnlineStudyEstService;
import com.srts.learning.dao.OnlineCourseDao;
import com.srts.system.dao.Sys_UserDao;
import com.srts.system.domain.Sys_User;
@Service
public class WorkerOnlineStudyEstServiceImpl implements
		WorkerOnlineStudyEstService {
	@Resource
	private WorkerOnlineStudyEstDao workerOnlineStudyEstDao;
	@Resource
	private Sys_UserDao sys_UserDao;
	
	public List<UserInfoPo> setMyStudyTimeLengthInfoCurrentDay(Sys_User usr) {
		List<String[]> resUser=workerOnlineStudyEstDao.getUserStudySumTimeByCurrentDay(usr);
		List<String[]> resAver=workerOnlineStudyEstDao.getAveStudyTimeTodayByCourse();
		List<UserInfoPo> userStudyTimeLengthInfoDisp=new ArrayList<UserInfoPo>();
		for(int i=1;i<=resUser.size();i++)
		{
			UserInfoPo temp=new UserInfoPo();
			String id=String.valueOf(i);
			String userUsedTimeLength=resUser.get(i-1)[0];
			String userStudyCourse=resUser.get(i-1)[2];
			String averUsedTimeLength="0";
			String type="本日学习情况";
			for(int j=0;j<resAver.size();j++)
			{
				//
				if(resAver.get(j)[1].equals(resUser.get(i-1)[1]))
				{
					averUsedTimeLength=resAver.get(j)[0];
				}
			}
			temp.setAveStudyTimeLength(averUsedTimeLength);
			temp.setCourse(userStudyCourse);
			temp.setId(id);
			temp.setType(type);
			temp.setUserUsedTimeLength(userUsedTimeLength);
			userStudyTimeLengthInfoDisp.add(temp);
		}
		return userStudyTimeLengthInfoDisp;
	}
	public List<UserInfoPo> setMyStudyTimeLengthInfoCurrentWeek(Sys_User usr) {
		List<String[]> resUser=workerOnlineStudyEstDao.getUserStudySumTimeByCurrentWeek(usr);
		List<String[]> resAver=workerOnlineStudyEstDao.getAveStudyTimeToWeekByCourse();
		List<UserInfoPo> userStudyTimeLengthInfoDisp=new ArrayList<UserInfoPo>();
		for(int i=1;i<=resUser.size();i++)
		{
			UserInfoPo temp=new UserInfoPo();
			String id=String.valueOf(i);
			String userUsedTimeLength=resUser.get(i-1)[0];
			String userStudyCourse=resUser.get(i-1)[2];
			String averUsedTimeLength="0";
			String type="本周学习情况";
			for(int j=0;j<resAver.size();j++)
			{
				if(resAver.get(j)[1].equals(resUser.get(i-1)[1]))
				{
					averUsedTimeLength=resAver.get(j)[0];
				}
			}
			temp.setAveStudyTimeLength(averUsedTimeLength);
			temp.setCourse(userStudyCourse);
			temp.setId(id);
			temp.setType(type);
			temp.setUserUsedTimeLength(userUsedTimeLength);
			userStudyTimeLengthInfoDisp.add(temp);
		}
		return userStudyTimeLengthInfoDisp;
	}
	public List<UserInfoPo> setMyStudyTimeLengthInfoCurrentMonth(Sys_User usr) {
		List<String[]> resUser=workerOnlineStudyEstDao.getUserStudySumTimeByCurrentMonth(usr);
		List<String[]> resAver=workerOnlineStudyEstDao.getAveStudyTimeToMonthByCourse();
		List<UserInfoPo> userStudyTimeLengthInfoDisp=new ArrayList<UserInfoPo>();
		for(int i=1;i<=resUser.size();i++)
		{
			UserInfoPo temp=new UserInfoPo();
			String id=String.valueOf(i);
			String userUsedTimeLength=resUser.get(i-1)[0];
			String userStudyCourse=resUser.get(i-1)[2];
			String averUsedTimeLength="0";
			String type="本月学习情况";
			for(int j=0;j<resAver.size();j++)
			{
				if(resAver.get(j)[1].equals(resUser.get(i-1)[1]))
				{
					averUsedTimeLength=resAver.get(j)[0];
				}
			}
			temp.setAveStudyTimeLength(averUsedTimeLength);
			temp.setCourse(userStudyCourse);
			temp.setId(id);
			temp.setType(type);
			temp.setUserUsedTimeLength(userUsedTimeLength);
			userStudyTimeLengthInfoDisp.add(temp);
		}
		return userStudyTimeLengthInfoDisp;
	}
	public String getTimeLengthString(Sys_User usr) {
		List<String[]> resUserYear=workerOnlineStudyEstDao.getUserStudySumTimeToNowPerMonth(usr);
		List<String[]> resAverYear=workerOnlineStudyEstDao.getAveStudySumTimeToNowPerMonth();
		String monthStudyTimeCount = "{\"chart\":{\"caption\":\"各月份学习总时/均时变化\",\"numdivlines\":\"9\",\"linethickness\":\"2\",\"showvalues\":\"0\",\"anchorradius\":\"3\",\"anchorbgalpha\":\"50\",\"numvdivlines\":\"24\",\"showalternatevgridcolor\":\"1\",\"alternatevgridalpha\":\"3\",\"animation\":\"0\"},\"categories\":[{\"category\":[{\"label\":\"1月\"},{\"label\":\"2月\"},{\"label\":\"3月\"},{\"label\":\"4月\"},{\"label\":\"5月\"},{\"label\":\"6月\"},{\"label\":\"7月\"},{\"label\":\"8月\"},{\"label\":\"9月\"},{\"label\":\"10月\"},{\"label\":\"11月\"},{\"label\":\"12月\"}]}],\"dataset\":[";
		String monthStudyTimeTotal = "{\"seriesname\":\"总时\",\"color\":\"800080\",\"anchorbordercolor\":\"800080\",\"data\":[";
		String monthStudyTimeEvg = "{\"seriesname\":\"均时\",\"color\":\"FF8040\",\"anchorbordercolor\":\"FF8040\",\"data\":[";
		for(int i = 1;i < resUserYear.size()+1;i++){
			if(i!=resUserYear.size()){
					monthStudyTimeTotal += "{\"value\":\""+resUserYear.get(i-1)[0]+"\"},";
					monthStudyTimeEvg += "{\"value\":\""+resAverYear.get(i-1)[0]+"\"},";
			}else{
					monthStudyTimeTotal += "{\"value\":\""+resUserYear.get(i-1)[0]+"\"}]},";
					monthStudyTimeEvg += "{\"value\":\""+resAverYear.get(i-1)[0]+"\"}]}]}";
				}
		}
		monthStudyTimeCount+=monthStudyTimeTotal+monthStudyTimeEvg;
		return monthStudyTimeCount;
	}
	public List<UserEstimatePo> setUserEstimateInfoCurrentDay(Sys_User usr) {
		List<String[]> resUser=workerOnlineStudyEstDao.getUserStudySumTimeByCurrentDay(usr);
		List<String[]> resAver=workerOnlineStudyEstDao.getAveStudyTimeTodayByCourse();
		List<UserEstimatePo> userStudyTimeLengthEstDisp=new ArrayList<UserEstimatePo>();
		for(int i=1;i<=resUser.size();i++)
		{
			UserEstimatePo temp=new UserEstimatePo();
			String estimateInfo="暂时无评价信息";
			String id=String.valueOf(i);
			String userUsedTimeLength=resUser.get(i-1)[0];
			String userStudyCourse=resUser.get(i-1)[2];
			String averUsedTimeLength="0";
			String type="本日"+userStudyCourse+"学习评价：";
			if(userStudyCourse.equals("无记录"))
			{
				 type="本日学习评价：";
			}
			for(int j=0;j<resAver.size();j++)
			{
				if(resAver.get(j)[1].equals(resUser.get(i-1)[1]))
				{
					averUsedTimeLength=resAver.get(j)[0];
					int ave=Integer.parseInt(averUsedTimeLength);
					int val=Integer.parseInt(userUsedTimeLength);
					if(val==0)
					{
						estimateInfo=userStudyCourse+"今天还没有进行学习，请翻阅！";
					}
					else if(val<=ave*0.5)
					{
						estimateInfo=userStudyCourse+"今天的学习时间过少，有空请翻阅！";
					}
					else if(val>ave*0.5&&val<=ave)
					{
						estimateInfo=userStudyCourse+"今天学习时间基本达到要求。";
					}
					else if(val>ave&&val<=1.5*ave)
					{
						estimateInfo=userStudyCourse+"今天学习时间达到要求。";
					}
					else if(val>1.5*ave)
					{
						estimateInfo=userStudyCourse+"今天学习时间已经足够，看看别的课程吧。";
					}
				}
			}
			temp.setEstimateInfo(estimateInfo);
			temp.setType(type);
			temp.setId(id);
			userStudyTimeLengthEstDisp.add(temp);
		}
		return userStudyTimeLengthEstDisp;
	}
	public List<UserEstimatePo> setUserEstimateInfoCurrentMonth(Sys_User usr) {
		List<String[]> resUser=workerOnlineStudyEstDao.getUserStudySumTimeByCurrentMonth(usr);
		List<String[]> resAver=workerOnlineStudyEstDao.getAveStudyTimeToMonthByCourse();
		List<UserEstimatePo> userStudyTimeLengthEstDisp=new ArrayList<UserEstimatePo>();
		for(int i=1;i<=resUser.size();i++)
		{
			UserEstimatePo temp=new UserEstimatePo();
			String estimateInfo="暂时无评价信息";
			String id=String.valueOf(i);
			String userUsedTimeLength=resUser.get(i-1)[0];
			String userStudyCourse=resUser.get(i-1)[2];
			String averUsedTimeLength="0";
			String type="本月"+userStudyCourse+"学习评价：";
			if(userStudyCourse.equals("无记录"))
			{
				 type="本月学习评价：";
			}
			for(int j=0;j<resAver.size();j++)
			{
				if(resAver.get(j)[1].equals(resUser.get(i-1)[1]))
				{
					averUsedTimeLength=resAver.get(j)[0];
					int ave=Integer.parseInt(averUsedTimeLength);
					int val=Integer.parseInt(userUsedTimeLength);
					if(val==0)
					{
						estimateInfo=userStudyCourse+"本月暂时还没有进行学习，请翻阅！";
					}
					else if(val<=ave*0.5)
					{
						estimateInfo=userStudyCourse+"本月的学习时间过少，有空请翻阅！";
					}
					else if(val>ave*0.5&&val<=ave)
					{
						estimateInfo=userStudyCourse+"本月学习时间暂时基本达到要求。";
					}
					else if(val>ave&&val<=1.5*ave)
					{
						estimateInfo=userStudyCourse+"本月学习时间暂时达到要求。";
					}
					else if(val>1.5*ave)
					{
						estimateInfo=userStudyCourse+"本月学习时间暂时已经足够，看看别的课程吧。";
					}
				}
			}
			temp.setEstimateInfo(estimateInfo);
			temp.setType(type);
			temp.setId(id);
			userStudyTimeLengthEstDisp.add(temp);
		}
		return userStudyTimeLengthEstDisp;
	}
	public List<UserEstimatePo> setUserEstimateInfoCurrentWeek(Sys_User usr) {
		List<String[]> resUser=workerOnlineStudyEstDao.getUserStudySumTimeByCurrentWeek(usr);
		List<String[]> resAver=workerOnlineStudyEstDao.getAveStudyTimeToWeekByCourse();
		List<UserEstimatePo> userStudyTimeLengthEstDisp=new ArrayList<UserEstimatePo>();
		for(int i=1;i<=resUser.size();i++)
		{
			UserEstimatePo temp=new UserEstimatePo();
			String estimateInfo="暂时无评价信息";
			String id=String.valueOf(i);
			String userUsedTimeLength=resUser.get(i-1)[0];
			String userStudyCourse=resUser.get(i-1)[2];
			String averUsedTimeLength="0";
			String type="本周"+userStudyCourse+"学习评价：";
			if(userStudyCourse.equals("无记录"))
			{
				 type="本周学习评价：";
			}
			for(int j=0;j<resAver.size();j++)
			{
				if(resAver.get(j)[1].equals(resUser.get(i-1)[1]))
				{
					averUsedTimeLength=resAver.get(j)[0];
					int ave=Integer.parseInt(averUsedTimeLength);
					int val=Integer.parseInt(userUsedTimeLength);
					if(val==0)
					{
						estimateInfo=userStudyCourse+"本周暂时还没有进行学习，请翻阅！";
					}
					else if(val<=ave*0.5)
					{
						estimateInfo=userStudyCourse+"本周的学习时间过少，有空请翻阅！";
					}
					else if(val>ave*0.5&&val<=ave)
					{
						estimateInfo=userStudyCourse+"本周学习时间暂时基本达到要求。";
					}
					else if(val>ave&&val<=1.5*ave)
					{
						estimateInfo=userStudyCourse+"本周学习时间暂时达到要求。";
					}
					else if(val>1.5*ave)
					{
						estimateInfo=userStudyCourse+"本周学习时间暂时已经足够，看看别的课程吧。";
					}
				}
			}
			temp.setEstimateInfo(estimateInfo);
			temp.setType(type);
			temp.setId(id);
			userStudyTimeLengthEstDisp.add(temp);
		}
		return userStudyTimeLengthEstDisp;
	}
	
	

}
