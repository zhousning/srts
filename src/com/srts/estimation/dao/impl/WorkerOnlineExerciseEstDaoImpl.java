package com.srts.estimation.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.estimation.dao.WorkerOnlineExerciseEstDao;
import com.srts.system.domain.Sys_User;
@Repository
@Transactional
public class WorkerOnlineExerciseEstDaoImpl implements
		WorkerOnlineExerciseEstDao {
	
	@Resource
	private SessionFactory sessionFactory;

	public List<String[]> selectAccuracyRateByUserToMonth(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		if(month.length()==1)
		{
			month="0"+month;
		}
		String currentMonth=year+"-"+month;
		String sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate like'%"+currentMonth+"%'";
		Long usrId=usr.getId();
		List res =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId", usrId).list();//
		String sql1="select distinct lrn_onlineExercise.exerciseName from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate like'%"+currentMonth+"%'";
		List res1 =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql1).setLong("usrId", usrId).list();
		List<String> exerciseNameList=new ArrayList<String>();
		for(int i=0;i<res1.size();i++)
		{
			exerciseNameList.add(res1.get(i).toString());
		}
		if(exerciseNameList.size()==0)
		{
			String accuracyString=String.valueOf(0);
			String timeString=currentMonth;
			String courseString="无记录";
			String []addItem = {"1",accuracyString,timeString,courseString};
			resList.add(addItem);
		}
		for(int j=0;j<exerciseNameList.size();j++)
		{
			int rightNum=0;
			int allNum=0;
			float accuracy=0;
			Iterator iterator = res.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				if(objs[9].toString().equals(exerciseNameList.get(j))==true)
				{
					allNum+=(Integer.parseInt(String.valueOf(objs[2]))+Integer.parseInt(String.valueOf(objs[3]))+Integer.parseInt(String.valueOf(objs[4])));
					rightNum+=Integer.parseInt(String.valueOf(objs[2]));				
				}
			}
			accuracy=(float)rightNum/allNum;
			String id=String.valueOf(j+1);
			String accuracyString=String.valueOf(accuracy);
			String timeString=currentMonth;
			String courseString=exerciseNameList.get(j);
			String []addItem = {id,accuracyString,timeString,courseString};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectAccuracyRateByUserToWeek(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		Calendar calendar=Calendar.getInstance();
		String y=String.valueOf(calendar.get(Calendar.YEAR));
		String mon=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String currentMonth=y+"年"+mon+"月";
		List<String> dateList=new ArrayList<String>();
		int week = calendar.get(Calendar.WEEK_OF_MONTH);//获取是本月的第几周
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
		for(int k=0;k<dayWeek;k++)
		{
			Calendar calendar1=Calendar.getInstance();
			calendar1.add(Calendar.DATE,-k);
			String year=String.valueOf(calendar1.get(Calendar.YEAR));
			String month=String.valueOf(calendar1.get(Calendar.MONTH)+1);
			String date=String.valueOf(calendar1.get(Calendar.DATE));
			if(month.length()==1)
			{
				month="0"+month;
			}
			if(date.length()==1)
			{
				date="0"+date;
			}
			String currentTime=year+"-"+month+"-"+date;
			dateList.add(currentTime);
		}
		String sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate<=:lastDate and lrn_onlineExercise.exerciseDate>=:firstDate";
		Long usrId=usr.getId();
		List res =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId", usrId).setString("lastDate", dateList.get(0)).setString("firstDate", dateList.get(dayWeek-1)).list();//
		String sql1="select distinct lrn_onlineExercise.exerciseName from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate<=:lastDate and lrn_onlineExercise.exerciseDate>=:firstDate";
		List res1 =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql1).setString("lastDate", dateList.get(0)).setString("firstDate", dateList.get(dayWeek-1)).setLong("usrId", usrId).list();
		List<String> exerciseNameList=new ArrayList<String>();
		for(int i=0;i<res1.size();i++)
		{
			exerciseNameList.add(res1.get(i).toString());
		}
		if(exerciseNameList.size()==0)
		{
			String accuracyString=String.valueOf(0);
			String timeString=currentMonth+"第"+String.valueOf(week)+"周";
			String courseString="无记录";
			String []addItem = {"1",accuracyString,timeString,courseString};
			resList.add(addItem);
		}
		for(int j=0;j<exerciseNameList.size();j++)
		{
			int rightNum=0;
			int allNum=0;
			float accuracy=0;
			Iterator iterator = res.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				if(objs[9].toString().equals(exerciseNameList.get(j))==true)
				{
					allNum+=(Integer.parseInt(String.valueOf(objs[2]))+Integer.parseInt(String.valueOf(objs[3]))+Integer.parseInt(String.valueOf(objs[4])));
					rightNum+=Integer.parseInt(String.valueOf(objs[2]));				
				}
			}
			accuracy=(float)rightNum/allNum;
			String id=String.valueOf(j+1);
			String accuracyString=String.valueOf(accuracy);
			String timeString=currentMonth+"第"+String.valueOf(week)+"周";
			String courseString=exerciseNameList.get(j);
			String []addItem = {id,accuracyString,timeString,courseString};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectAccuracyRateByUserToday(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		if(month.length()==1)
		{
			month="0"+month;
		}
		if(date.length()==1)
		{
			date="0"+date;
		}
		String currentTime=year+"-"+month+"-"+date;
		String sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate=:currentTime";
		Long usrId=usr.getId();
		List res =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId", usrId).setString("currentTime", currentTime).list();//
		String sql1="select distinct lrn_onlineExercise.exerciseName from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate=:currentTime";
		List res1 =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql1).setLong("usrId", usrId).setString("currentTime", currentTime).list();
		List<String> exerciseNameList=new ArrayList<String>();
		for(int i=0;i<res1.size();i++)
		{
			exerciseNameList.add(res1.get(i).toString());
		}
		if(exerciseNameList.size()==0)
		{
			String accuracyString=String.valueOf(0);
			String timeString=currentTime;
			String courseString="无记录";
			String []addItem = {"1",accuracyString,timeString,courseString};
			resList.add(addItem);
		}
		for(int j=0;j<exerciseNameList.size();j++)
		{
			int rightNum=0;
			int allNum=0;
			float accuracy=0;
			Iterator iterator = res.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				if(objs[9].toString().equals(exerciseNameList.get(j))==true)
				{
					allNum+=(Integer.parseInt(String.valueOf(objs[2]))+Integer.parseInt(String.valueOf(objs[3]))+Integer.parseInt(String.valueOf(objs[4])));
					rightNum+=Integer.parseInt(String.valueOf(objs[2]));				
				}
			}
			accuracy=(float)rightNum/allNum;
			String id=String.valueOf(j+1);
			String accuracyString=String.valueOf(accuracy);
			String timeString=currentTime;
			String courseString=exerciseNameList.get(j);
			String []addItem = {id,accuracyString,timeString,courseString};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectExerciseFeqByUserToMonth(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		if(month.length()==1)
		{
			month="0"+month;
		}
		String currentMonth=year+"-"+month;
		String sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate like'%"+currentMonth+"%'";
		Long usrId=usr.getId();
		List res =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId", usrId).list();//
		String sql1="select distinct lrn_onlineExercise.exerciseName from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate like'%"+currentMonth+"%'";
		List res1 =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql1).setLong("usrId", usrId).list();
		List<String> exerciseNameList=new ArrayList<String>();
		for(int i=0;i<res1.size();i++)
		{
			exerciseNameList.add(res1.get(i).toString());
		}
		int allNum=0;
		Iterator iterator = res.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			allNum+=(Integer.parseInt(String.valueOf(objs[4]))+Integer.parseInt(String.valueOf(objs[5]))+Integer.parseInt(String.valueOf(objs[6])));					
		}
		String aveExerciseQuestionNum="0";
		String timeString=currentMonth;
		String exerciseFeqPerMonth=String.valueOf(res.size());
		if(allNum!=0)
		{
		aveExerciseQuestionNum=String.valueOf((float)(allNum/res.size()));
		}
		String []addItem = {exerciseFeqPerMonth,timeString,aveExerciseQuestionNum};
		resList.add(addItem);
		return resList;
	}

	public List<String[]> selectExerciseFeqByUserToWeek(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		Calendar calendar=Calendar.getInstance();
		String y=String.valueOf(calendar.get(Calendar.YEAR));
		String mon=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String currentMonth=y+"年"+mon+"月";
		List<String> dateList=new ArrayList<String>();
		int week = calendar.get(Calendar.WEEK_OF_MONTH);//获取是本月的第几周
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
		for(int k=0;k<dayWeek;k++)
		{
			Calendar calendar1=Calendar.getInstance();
			calendar1.add(Calendar.DATE,-k);
			String year=String.valueOf(calendar1.get(Calendar.YEAR));
			String month=String.valueOf(calendar1.get(Calendar.MONTH)+1);
			String date=String.valueOf(calendar1.get(Calendar.DATE));
			if(month.length()==1)
			{
				month="0"+month;
			}
			if(date.length()==1)
			{
				date="0"+date;
			}
			String currentTime=year+"-"+month+"-"+date;
			dateList.add(currentTime);
		}
		String sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate<=:lastDate and lrn_onlineExercise.exerciseDate>=:firstDate";
		Long usrId=usr.getId();
		List res =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId", usrId).setString("lastDate", dateList.get(0)).setString("firstDate", dateList.get(dayWeek-1)).list();//
		String sql1="select distinct lrn_onlineExercise.exerciseName from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate<=:lastDate and lrn_onlineExercise.exerciseDate>=:firstDate";
		List res1 =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql1).setLong("usrId", usrId).setString("lastDate", dateList.get(0)).setString("firstDate", dateList.get(dayWeek-1)).list();
		List<String> exerciseNameList=new ArrayList<String>();
		for(int i=0;i<res1.size();i++)
		{
			exerciseNameList.add(res1.get(i).toString());
		}
		int allNum=0;
		Iterator iterator = res.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			allNum+=(Integer.parseInt(String.valueOf(objs[4]))+Integer.parseInt(String.valueOf(objs[5]))+Integer.parseInt(String.valueOf(objs[6])));					
		}
		String timeString=currentMonth+"第"+String.valueOf(week)+"周";
		String exerciseFeqPerWeek=String.valueOf(res.size());
		String aveExerciseQuestionNum="0";
		if(allNum!=0)
		{
		aveExerciseQuestionNum=String.valueOf((float)(allNum/res.size()));
		}
		String []addItem = {exerciseFeqPerWeek,timeString,aveExerciseQuestionNum};
		resList.add(addItem);
		return resList;
	}

	public List<String[]> selectExerciseFeqByUserToday(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		if(month.length()==1)
		{
			month="0"+month;
		}
		if(date.length()==1)
		{
			date="0"+date;
		}
		String currentTime=year+"-"+month+"-"+date;
		String sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate=:currentTime";
		Long usrId=usr.getId();
		List res =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId", usrId).setString("currentTime",currentTime).list();//
		String sql1="select distinct lrn_onlineExercise.exerciseName from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate=:currentTime";
		List res1 =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql1).setLong("usrId", usrId).setString("currentTime",currentTime).list();
		List<String> exerciseNameList=new ArrayList<String>();
		for(int i=0;i<res1.size();i++)
		{
			exerciseNameList.add(res1.get(i).toString());
		}
		int allNum=0;
		Iterator iterator = res.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			allNum+=(Integer.parseInt(String.valueOf(objs[4]))+Integer.parseInt(String.valueOf(objs[5]))+Integer.parseInt(String.valueOf(objs[6])));					
		}
		String aveExerciseQuestionNum="0";
		String timeString=currentTime;
		String exerciseFeqPerDay=String.valueOf(res.size());
		if(allNum!=0)
		{
		aveExerciseQuestionNum=String.valueOf((float)(allNum/res.size()));
		}
		String []addItem = {exerciseFeqPerDay,timeString,aveExerciseQuestionNum};
		resList.add(addItem);
		return resList;
	}

	public List<String[]> selectExerciseContentByUserAndTimeArea(Sys_User usr,
			String TimeArea) {
		List<String[]> resList=new ArrayList<String[]>();
		List<String[]> resListFinal=new ArrayList<String[]>();
		long usrId=usr.getId();
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		if(month.length()==1)
		{
			month="0"+month;
		}
		if(date.length()==1)
		{
			date="0"+date;
		}
		String currentTime=year+"-"+month+"-"+date;
		String currentMonth=year+"-"+month;
		List<String> dateList=new ArrayList<String>();
		int week = calendar.get(Calendar.WEEK_OF_MONTH);//获取是本月的第几周
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
		for(int k=0;k<dayWeek;k++)
		{
			Calendar calendar1=Calendar.getInstance();
			calendar1.add(Calendar.DATE,-k);
			String year1=String.valueOf(calendar1.get(Calendar.YEAR));
			String month1=String.valueOf(calendar1.get(Calendar.MONTH)+1);
			String date1=String.valueOf(calendar1.get(Calendar.DATE));
			if(month1.length()==1)
			{
				month1="0"+month1;
			}
			if(date.length()==1)
			{
				date1="0"+date1;
			}
			String currentTime1=year1+"-"+month1+"-"+date1;
			dateList.add(currentTime1);
		}
		String sql="";
		if(TimeArea.equals("month"))
		{
			sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate like'%"+currentMonth+"%'";
			List res =(List) sessionFactory.getCurrentSession()
			.createSQLQuery(sql).setLong("usrId", usrId).list();
			if(res.size()==0)
			{
				String[] elementAdd={"无记录","无记录","无记录"};
				resListFinal.add(elementAdd);
			}
			Iterator iterator = res.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String exerciseContent=objs[3].toString();
				String[] contentSplit=exerciseContent.split("\\|");
				if(contentSplit[1].length()>1)
				{
					String[] chapterSplit=contentSplit[1].split(",");
					for(int i=0;i<chapterSplit.length;i++)
					{
						String[] temp={contentSplit[0],chapterSplit[i]};
						resList.add(temp);
					}
				}
				else
				{
					String[] temp={contentSplit[0],contentSplit[1]};
					resList.add(temp);
				}
			}
			for(int j=0;j<resList.size();j++)
			{
				int tip=0;
				if(resListFinal.size()==0)
				{
					String[] element1={resList.get(0)[0],resList.get(0)[1],"0"};
					resListFinal.add(element1);
				}
				for(int l=0;l<resListFinal.size();l++)
				{
					if(resListFinal.get(l)[0].equals(resList.get(j)[0])==true&&
							resListFinal.get(l)[1].equals(resList.get(j)[1])==true)
					{
						tip=1;
					}
				}
				if(tip==0)
				{
					String[] elementAdd={resList.get(j)[0],resList.get(j)[1],"0"};
					resListFinal.add(elementAdd);
				}
			}
			for(int i=0;i<resList.size();i++)
			{
				for(int t=0;t<resListFinal.size();t++)
				{
					if(resListFinal.get(t)[0].equals(resList.get(i)[0])==true&&
							resListFinal.get(t)[1].equals(resList.get(i)[1])==true)
					{
						resListFinal.get(t)[2]=String.valueOf(Integer.parseInt(resListFinal.get(t)[2])+1);
					}
				}
			}
			
		}
		else if(TimeArea.equals("day"))
		{
			sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate=:currentTime";
			List res =(List) sessionFactory.getCurrentSession()
			.createSQLQuery(sql).setLong("usrId", usrId).setString("currentTime", currentTime).list();
			if(res.size()==0)
			{
				String[] elementAdd={"无记录","无记录","无记录"};
				resListFinal.add(elementAdd);
			}
			Iterator iterator = res.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String exerciseContent=objs[3].toString();
				String[] contentSplit=exerciseContent.split("\\|");
				if(contentSplit[1].length()>1)
				{
					String[] chapterSplit=contentSplit[1].split(",");
					for(int i=0;i<chapterSplit.length;i++)
					{
						String[] temp={contentSplit[0],chapterSplit[i]};
						resList.add(temp);
					}
				}
				else
				{
					String[] temp={contentSplit[0],contentSplit[1]};
					resList.add(temp);
				}
			}
			for(int j=0;j<resList.size();j++)
			{
				int tip=0;
				if(resListFinal.size()==0)
				{
					String[] element1={resList.get(0)[0],resList.get(0)[1],"0"};
					resListFinal.add(element1);
				}
				for(int l=0;l<resListFinal.size();l++)
				{
					if(resListFinal.get(l)[0].equals(resList.get(j)[0])==true&&
							resListFinal.get(l)[1].equals(resList.get(j)[1])==true)
					{
						tip=1;
					}
				}
				if(tip==0)
				{
					String[] elementAdd={resList.get(j)[0],resList.get(j)[1],"0"};
					resListFinal.add(elementAdd);
				}
			}
			for(int i=0;i<resList.size();i++)
			{
				for(int t=0;t<resListFinal.size();t++)
				{
					if(resListFinal.get(t)[0].equals(resList.get(i)[0])==true&&
							resListFinal.get(t)[1].equals(resList.get(i)[1])==true)
					{
						resListFinal.get(t)[2]=String.valueOf(Integer.parseInt(resListFinal.get(t)[2])+1);
					}
				}
			}
		}
		else if(TimeArea.equals("week"))
		{
			sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate<=:lastDate and lrn_onlineExercise.exerciseDate>=:firstDate";
			List res =(List) sessionFactory.getCurrentSession()
			.createSQLQuery(sql).setLong("usrId", usrId).setString("lastDate", dateList.get(0)).setString("firstDate", dateList.get(dayWeek-1)).list();
			if(res.size()==0)
			{
				String[] elementAdd={"无记录","无记录","无记录"};
				resListFinal.add(elementAdd);
			}
			Iterator iterator = res.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String exerciseContent=objs[3].toString();
				String[] contentSplit=exerciseContent.split("\\|");
				if(contentSplit[1].length()>1)
				{
					String[] chapterSplit=contentSplit[1].split(",");
					for(int i=0;i<chapterSplit.length;i++)
					{
						String[] temp={contentSplit[0],chapterSplit[i]};
						resList.add(temp);
					}
				}
				else
				{
					String[] temp={contentSplit[0],contentSplit[1]};
					resList.add(temp);
				}
			}
			for(int j=0;j<resList.size();j++)
			{
				int tip=0;
				if(resListFinal.size()==0)
				{
					String[] element1={resList.get(0)[0],resList.get(0)[1],"0"};
					resListFinal.add(element1);
				}
				for(int l=0;l<resListFinal.size();l++)
				{
					if(resListFinal.get(l)[0].equals(resList.get(j)[0])==true&&
							resListFinal.get(l)[1].equals(resList.get(j)[1])==true)
					{
						tip=1;
					}
				}
				if(tip==0)
				{
					String[] elementAdd={resList.get(j)[0],resList.get(j)[1],"0"};
					resListFinal.add(elementAdd);
				}
			}
			for(int i=0;i<resList.size();i++)
			{
				for(int t=0;t<resListFinal.size();t++)
				{
					if(resListFinal.get(t)[0].equals(resList.get(i)[0])==true&&
							resListFinal.get(t)[1].equals(resList.get(i)[1])==true)
					{
						resListFinal.get(t)[2]=String.valueOf(Integer.parseInt(resListFinal.get(t)[2])+1);
					}
				}
			}
		}
		return resListFinal;
	}

	public List<String[]> selectAccuracyRateByUserPerMonth(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		List<String> monthList=new ArrayList<String>();
		if(month.length()==1)
		{
			month="0"+month;
		}
		String currentMonth=year+"-"+month;
		for(int m=1;m<=Integer.parseInt(month);m++)
		{
			String mon=String.valueOf(m);
		if(String.valueOf(m).length()==1)
		{
			mon="0"+String.valueOf(m);
		}
		String currentTime=year+"-"+mon;
		monthList.add(currentTime);
		}
		for(int s=0;s<monthList.size();s++)
		{
		String sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate like'%"+monthList.get(s)+"%'";
		Long usrId=usr.getId();
		List res =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId", usrId).list();//
		String sql1="select distinct lrn_onlineExercise.exerciseName from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate like'%"+monthList.get(s)+"%'";
		List res1 =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql1).setLong("usrId", usrId).list();
		List<String> exerciseNameList=new ArrayList<String>();
		for(int i=0;i<res1.size();i++)
		{
			exerciseNameList.add(res1.get(i).toString());
		}
		if(exerciseNameList.size()==0)
		{
			String accuracyString=String.valueOf(0);
			String timeString=monthList.get(s);
			String courseString="无记录";
			String []addItem = {accuracyString,timeString,courseString};
			resList.add(addItem);
		}
		for(int j=0;j<exerciseNameList.size();j++)
		{
			int rightNum=0;
			int allNum=0;
			float accuracy=0;
			Iterator iterator = res.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				if(objs[9].toString().equals(exerciseNameList.get(j))==true)
				{
					allNum+=(Integer.parseInt(String.valueOf(objs[2]))+Integer.parseInt(String.valueOf(objs[3]))+Integer.parseInt(String.valueOf(objs[4])));
					rightNum+=Integer.parseInt(String.valueOf(objs[2]));				
				}
			}
			if(allNum==0)
			{
				String accuracyString=String.valueOf(0);
				String timeString=monthList.get(s);
				String courseString="无记录";
				String []addItem = {accuracyString,timeString,courseString};
				resList.add(addItem);
			}
			else
			{
			accuracy=(float)rightNum/allNum;
			String accuracyString=String.valueOf(accuracy);
			String timeString=monthList.get(s);
			String courseString=exerciseNameList.get(j);
			String []addItem = {accuracyString,timeString,courseString};
			resList.add(addItem);
			}
		}
		}
		return resList;
	}

	public List<String[]> selectExerciseFeqByUserPerMonth(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		List<String> monthList=new ArrayList<String>();
		if(month.length()==1)
		{
			month="0"+month;
		}
		String currentMonth=year+"-"+month;
		for(int m=1;m<=Integer.parseInt(month);m++)
		{
			String mon=String.valueOf(m);
		if(String.valueOf(m).length()==1)
		{
			mon="0"+String.valueOf(m);
		}
		String currentTime=year+"-"+mon;
		monthList.add(currentTime);
		}
		for(int s=0;s<monthList.size();s++)
		{
		String sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate like'%"+monthList.get(s)+"%'";
		Long usrId=usr.getId();
		List res =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId", usrId).list();//
		String sql1="select distinct lrn_onlineExercise.exerciseName from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId and lrn_onlineExercise.exerciseDate like'%"+monthList.get(s)+"%'";
		List res1 =(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql1).setLong("usrId", usrId).list();
		List<String> exerciseNameList=new ArrayList<String>();
		for(int i=0;i<res1.size();i++)
		{
			exerciseNameList.add(res1.get(i).toString());
		}
		int allNum=0;
		Iterator iterator = res.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			allNum+=(Integer.parseInt(String.valueOf(objs[4]))+Integer.parseInt(String.valueOf(objs[5]))+Integer.parseInt(String.valueOf(objs[6])));					
		}
		String timeString=monthList.get(s);
		String exerciseFeqPerMonth=String.valueOf(res.size());
		String aveExerciseQuestionNum="";
		if(allNum==0)
		{
		    aveExerciseQuestionNum="0";
		}
		else
		{
		aveExerciseQuestionNum=String.valueOf((float)(allNum/res.size()));
		}
		String []addItem = {exerciseFeqPerMonth,timeString,aveExerciseQuestionNum};
		resList.add(addItem);
		}
		return resList;
	}

}
