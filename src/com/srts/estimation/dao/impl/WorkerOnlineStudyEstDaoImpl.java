package com.srts.estimation.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.estimation.dao.WorkerOnlineStudyEstDao;
import com.srts.system.domain.Sys_User;
@Repository
@Transactional
public class WorkerOnlineStudyEstDaoImpl implements WorkerOnlineStudyEstDao{

	@Resource
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List selectWorkerStudyInfoByUser(Sys_User usr) {
		Long usrId=usr.getId();
		String sql="select * from lrn_myStudyCourse where lrn_myStudyCourse.usrId=:usrId";
		return (List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId", usrId).list();
	}

	@SuppressWarnings("unchecked")
	public List selectWorkerStudyInfoByCourse(long bookID) {
		String sql="select * from lrn_myStudyCourse where lrn_myStudyCourse.bookId=:bookID";
		return (List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("bookID", bookID).list();
	}

	@SuppressWarnings("unchecked")
	public List selectCourse() {
		String sql="select distinct lrn_myStudyCourse.bookId from lrn_myStudyCourse";
		return (List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).list();
	}

	@SuppressWarnings("unchecked")
	public List selectAllWorkerStudyInfo() {
		String sql="select * from lrn_myStudyCourse";
		return (List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).list();
	}

	@SuppressWarnings("unchecked")
	public List selectPeople() {
		String sql="select distinct lrn_myStudyCourse.usrId from lrn_myStudyCourse";
		return (List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).list();
	}

	@SuppressWarnings("unchecked")
	public List<String[]> getAveStudySumTimeToNowPerMonth() {
		List<String[]> aveStudyTimeList = new ArrayList<String[]>();
		List res =(List) sessionFactory.getCurrentSession()
		.createSQLQuery("select * from lrn_myStudyCourse").list();
		List peopleRes = (List) sessionFactory.getCurrentSession()
		.createSQLQuery("select distinct lrn_myStudyCourse.usrId from lrn_myStudyCourse").list();
		int peopleNum=peopleRes.size();
		List<String> monthList=new ArrayList<String>();
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
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
		if(res.isEmpty()==false)
		{
			for(int i=0;i<monthList.size();i++)
			{
			Iterator iterator = res.iterator();
			String trainTimeLengthToday="0";
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String timeInfo = objs[6].toString();
				String[] timeInfoSplit=timeInfo.split(",");
				int length = timeInfoSplit.length;
				for(int j=0;j<length;j++)
				{
					String[] timeInfoSplitTwice=timeInfoSplit[j].split("\\|");
					if(timeInfoSplitTwice[0].startsWith(monthList.get(i))==true)
					{
						int time=Integer.parseInt(timeInfoSplitTwice[1]);
						trainTimeLengthToday=String.valueOf((Integer.parseInt(trainTimeLengthToday)+time));
					}
				}
				}
			String aveTimeLength = String.valueOf(Integer.parseInt(trainTimeLengthToday)/peopleNum);
			String []addItem = {aveTimeLength,monthList.get(i)};
			aveStudyTimeList.add(addItem);
			}
			}
			else
			{
				String empty[]={"无记录","无记录"};
				aveStudyTimeList.add(empty);
			}
		return aveStudyTimeList;
	}

	@SuppressWarnings("unchecked")
	public List<String[]> getAveStudyTimeToMonthByCourse() {
		List<Long> courseList = (List<Long>) sessionFactory.getCurrentSession()
		.createSQLQuery("select distinct lrn_myStudyCourse.bookId from lrn_myStudyCourse").list();
		List<String[]> aveStudyTimeList = new ArrayList<String[]>();
		for(int i=0;i<courseList.size();i++)
		{
			List res =(List) sessionFactory.getCurrentSession()
			.createSQLQuery("select * from lrn_myStudyCourse where lrn_myStudyCourse.bookId=:bookID").setLong("bookID", Long.parseLong(String.valueOf(courseList.get(i)))).list();
			List res1 =(List) sessionFactory.getCurrentSession()
			.createSQLQuery("select distinct usrId from lrn_myStudyCourse where lrn_myStudyCourse.bookId=:bookID").setLong("bookID", Long.parseLong(String.valueOf(courseList.get(i)))).list();
			int peopleNum=res1.size();
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
			String currentTime=year+"-"+month;
			if(res.isEmpty()==false)
			{
			Iterator iterator = res.iterator();
			String trainTimeLengthToday="0";
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String timeInfo = objs[6].toString();
				String[] timeInfoSplit=timeInfo.split(",");
				int length = timeInfoSplit.length;
				for(int j=0;j<length;j++)
				{
					String[] timeInfoSplitTwice=timeInfoSplit[j].split("\\|");
					if(timeInfoSplitTwice[0].startsWith(currentTime)==true)
					{
						int time=Integer.parseInt(timeInfoSplitTwice[1]);
						trainTimeLengthToday=String.valueOf((Integer.parseInt(trainTimeLengthToday)+time));
					}
				}
				}
			String aveTimeLength = String.valueOf(Integer.parseInt(trainTimeLengthToday)/peopleNum);
			String []addItem = {aveTimeLength,String.valueOf(courseList.get(i))};
			aveStudyTimeList.add(addItem);
			}
			else
			{
				String empty[]={"无记录","无记录"};
				aveStudyTimeList.add(empty);
			}
		}
		return aveStudyTimeList;
	}

	@SuppressWarnings("unchecked")
	public List<String[]> getAveStudyTimeToWeekByCourse() {
		List<Long> courseList = (List<Long>) sessionFactory.getCurrentSession()
		.createSQLQuery("select distinct lrn_myStudyCourse.bookId from lrn_myStudyCourse").list();
		List<String[]> aveStudyTimeList = new ArrayList<String[]>();
		Calendar calendar=Calendar.getInstance();
		List<String> dateList=new ArrayList<String>();
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
		for(int i=0;i<courseList.size();i++)
		{
			List res = (List) sessionFactory.getCurrentSession()
			.createSQLQuery("select * from lrn_myStudyCourse where lrn_myStudyCourse.bookId=:bookID").setLong("bookID", Long.parseLong(String.valueOf(courseList.get(i)))).list();
			List res1 = (List) sessionFactory.getCurrentSession()
			.createSQLQuery("select distinct usrId from lrn_myStudyCourse where lrn_myStudyCourse.bookId=:bookID").setLong("bookID", Long.parseLong(String.valueOf(courseList.get(i)))).list();
			int peopleNum=res1.size();
			if(res.isEmpty()==false)
			{
			Iterator iterator = res.iterator();
			String trainTimeLengthToday="0";
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String timeInfo = objs[6].toString();
				String[] timeInfoSplit=timeInfo.split(",");
				int length = timeInfoSplit.length;
				for(int j=0;j<length;j++)
				{
					String[] timeInfoSplitTwice=timeInfoSplit[j].split("\\|");
					for(int l=0;l<dateList.size();l++)
					{
					if(timeInfoSplitTwice[0].equals(dateList.get(l))==true)
					{
						int time=Integer.parseInt(timeInfoSplitTwice[1]);
						trainTimeLengthToday=String.valueOf((Integer.parseInt(trainTimeLengthToday)+time));
					}
					}
				}
				}
			String aveTimeLength = String.valueOf(Integer.parseInt(trainTimeLengthToday)/peopleNum);
			String []addItem = {aveTimeLength,String.valueOf(courseList.get(i))};
			aveStudyTimeList.add(addItem);
			}
			else
			{
				String empty[]={"无记录","无记录"};
				aveStudyTimeList.add(empty);
			}
		}
		return aveStudyTimeList;
	}

	@SuppressWarnings("unchecked")
	public List<String[]> getAveStudyTimeTodayByCourse() {
		List<Long> courseList = (List<Long>) sessionFactory.getCurrentSession()
		.createSQLQuery("select distinct lrn_myStudyCourse.bookId from lrn_myStudyCourse").list();
		List<String[]> aveStudyTimeList = new ArrayList<String[]>();
		for(int i=0;i<courseList.size();i++)
		{
			List res = (List) sessionFactory.getCurrentSession()
			.createSQLQuery("select * from lrn_myStudyCourse where lrn_myStudyCourse.bookId=:bookID").setLong("bookID", Long.parseLong(String.valueOf(courseList.get(i)))).list();
			List res1 = (List) sessionFactory.getCurrentSession()
			.createSQLQuery("select distinct lrn_myStudyCourse.usrId from lrn_myStudyCourse where lrn_myStudyCourse.bookId=:bookID").setLong("bookID", Long.parseLong(String.valueOf(courseList.get(i)))).list();
			int peopleNum=res1.size();
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
			if(res.isEmpty()==false)
			{
			Iterator iterator = res.iterator();
			String trainTimeLengthToday="0";
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String timeInfo = objs[6].toString();
				String[] timeInfoSplit=timeInfo.split(",");
				int length = timeInfoSplit.length;
				for(int j=0;j<length;j++)
				{
					String[] timeInfoSplitTwice=timeInfoSplit[j].split("\\|");
					if(timeInfoSplitTwice[0].equals(currentTime)==true)
					{
						int time=Integer.parseInt(timeInfoSplitTwice[1]);
						trainTimeLengthToday=String.valueOf((Integer.parseInt(trainTimeLengthToday)+time));
					}
				}
				}
			String aveTimeLength = String.valueOf(Integer.parseInt(trainTimeLengthToday)/peopleNum);
			String []addItem = {aveTimeLength,String.valueOf(courseList.get(i))};
			aveStudyTimeList.add(addItem);
			}
			else
			{
				String empty[]={"无记录","无记录"};
				aveStudyTimeList.add(empty);
			}
		}
		return aveStudyTimeList;
	}

	@SuppressWarnings("unchecked")
	public List<String[]> getUserStudySumTimeByCurrentDay(Sys_User usr) {
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
		List studyRecordList=(List) sessionFactory.getCurrentSession()
		.createSQLQuery("select * from lrn_myStudyCourse where lrn_myStudyCourse.usrId=:usrId").setLong("usrId", usr.getId()).list();
		List courseList=(List) sessionFactory.getCurrentSession()
		.createSQLQuery("select distinct bookId from lrn_myStudyCourse where lrn_myStudyCourse.usrId=:usrId").setLong("usrId", usr.getId()).list();
		List<String[]> timeInfoList=new ArrayList<String[]>();
		List<String[]> resList=new ArrayList<String[]>();
		if(studyRecordList.isEmpty()==false)
		{
		Iterator iterator = studyRecordList.iterator();
		while(iterator.hasNext()){
			String trainTimeLengthToday="0";
			Object[] objs = (Object[]) iterator.next();
			String timeInfo = objs[6].toString();
			String[] timeInfoSplit=timeInfo.split(",");
			int length = timeInfoSplit.length;
			for(int j=0;j<length;j++)
			{
				String[] timeInfoSplitTwice=timeInfoSplit[j].split("\\|");
				if(timeInfoSplitTwice[0].equals(currentTime)==true)
				{
					int time=Integer.parseInt(timeInfoSplitTwice[1]);
					trainTimeLengthToday=String.valueOf((Integer.parseInt(trainTimeLengthToday)+time));
				}
			}
			String []addItem = {trainTimeLengthToday,objs[9].toString(),objs[8].toString()};
			timeInfoList.add(addItem);
			}
		Iterator cLIterator=courseList.iterator();
		while(cLIterator.hasNext())
		{
			String timeLength="0";
			String bookName="";
			String bookId=cLIterator.next().toString();
			for(int i=0;i<timeInfoList.size();i++)
			{
				if(timeInfoList.get(i)[1].equals(bookId)==true)
				{
					timeLength=String.valueOf((Integer.parseInt(timeLength)+Integer.parseInt(timeInfoList.get(i)[0])));
					bookName=timeInfoList.get(i)[2];
				}
			}
			String[] add={timeLength,bookId,bookName};
			resList.add(add);
		}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;	
	}

	@SuppressWarnings("unchecked")
	public List<String[]> getUserStudySumTimeByCurrentMonth(Sys_User usr) {
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
		String currentTime=year+"-"+month;
		List studyRecordList=(List) sessionFactory.getCurrentSession()
		.createSQLQuery("select * from lrn_myStudyCourse where lrn_myStudyCourse.usrId=:usrId").setLong("usrId", usr.getId()).list();
		List courseList=(List) sessionFactory.getCurrentSession()
		.createSQLQuery("select distinct bookId from lrn_myStudyCourse where lrn_myStudyCourse.usrId=:usrId").setLong("usrId", usr.getId()).list();
		List<String[]> timeInfoList=new ArrayList<String[]>();
		List<String[]> resList=new ArrayList<String[]>();
		if(studyRecordList.isEmpty()==false)
		{
		Iterator iterator = studyRecordList.iterator();
		while(iterator.hasNext()){
			String trainTimeLengthToday="0";
			Object[] objs = (Object[]) iterator.next();
			String timeInfo = objs[6].toString();
			String[] timeInfoSplit=timeInfo.split(",");
			int length = timeInfoSplit.length;
			for(int j=0;j<length;j++)
			{
				String[] timeInfoSplitTwice=timeInfoSplit[j].split("\\|");
				if(timeInfoSplitTwice[0].startsWith(currentTime)==true)
				{
					int time=Integer.parseInt(timeInfoSplitTwice[1]);
					trainTimeLengthToday=String.valueOf((Integer.parseInt(trainTimeLengthToday)+time));
				}
			}
			String []addItem = {trainTimeLengthToday,objs[9].toString(),objs[8].toString()};
			timeInfoList.add(addItem);
			}
		Iterator cLIterator=courseList.iterator();
		while(cLIterator.hasNext())
		{
			String timeLength="0";
			String bookName="";
			String bookId=cLIterator.next().toString();
			for(int i=0;i<timeInfoList.size();i++)
			{
				if(timeInfoList.get(i)[1].equals(bookId)==true)
				{
					timeLength=String.valueOf((Integer.parseInt(timeLength)+Integer.parseInt(timeInfoList.get(i)[0])));
					bookName=timeInfoList.get(i)[2];
				}
			}
			String[] add={timeLength,bookId,bookName};
			resList.add(add);
		}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;	
	}

	@SuppressWarnings("unchecked")
	public List<String[]> getUserStudySumTimeByCurrentWeek(Sys_User usr) {
		Calendar calendar=Calendar.getInstance();
		List<String> dateList=new ArrayList<String>();
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
		List studyRecordList=(List) sessionFactory.getCurrentSession()
		.createSQLQuery("select * from lrn_myStudyCourse where lrn_myStudyCourse.usrId=:usrId").setLong("usrId", usr.getId()).list();
		List courseList=(List) sessionFactory.getCurrentSession()
		.createSQLQuery("select distinct bookId from lrn_myStudyCourse where lrn_myStudyCourse.usrId=:usrId").setLong("usrId", usr.getId()).list();
		List<String[]> timeInfoList=new ArrayList<String[]>();
		List<String[]> resList=new ArrayList<String[]>();
		if(studyRecordList.isEmpty()==false)
		{
		Iterator iterator = studyRecordList.iterator();
		while(iterator.hasNext()){
			String trainTimeLengthToday="0";
			Object[] objs = (Object[]) iterator.next();
			String timeInfo = objs[6].toString();
			String[] timeInfoSplit=timeInfo.split(",");
			int length = timeInfoSplit.length;
			for(int j=0;j<length;j++)
			{
				String[] timeInfoSplitTwice=timeInfoSplit[j].split("\\|");
				for(int i=0;i<dateList.size();i++)
				{
				if(timeInfoSplitTwice[0].equals(dateList.get(i))==true)
				{
					int time=Integer.parseInt(timeInfoSplitTwice[1]);
					trainTimeLengthToday=String.valueOf((Integer.parseInt(trainTimeLengthToday)+time));
				}
				}
			}
			String []addItem = {trainTimeLengthToday,objs[9].toString(),objs[8].toString()};
			timeInfoList.add(addItem);
			}
		Iterator cLIterator=courseList.iterator();
		while(cLIterator.hasNext())
		{
			String timeLength="0";
			String bookName="";
			String bookId=cLIterator.next().toString();
			for(int i=0;i<timeInfoList.size();i++)
			{
				if(timeInfoList.get(i)[1].equals(bookId)==true)
				{
					timeLength=String.valueOf((Integer.parseInt(timeLength)+Integer.parseInt(timeInfoList.get(i)[0])));
					bookName=timeInfoList.get(i)[2];
				}
			}
			String[] add={timeLength,bookId,bookName};
			resList.add(add);
		}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;	
	}

	@SuppressWarnings("unchecked")
	public List<String[]> getUserStudySumTimeToNowPerMonth(Sys_User usr) {
		List<String> monthList=new ArrayList<String>();
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
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
		List studyRecordList=(List) sessionFactory.getCurrentSession()
		.createSQLQuery("select * from lrn_myStudyCourse where lrn_myStudyCourse.usrId=:usrId").setLong("usrId", usr.getId()).list();
		List<String[]> timeInfoList=new ArrayList<String[]>();
		if(studyRecordList.isEmpty()==false)
		{
		for(int i=0;i<monthList.size();i++)
		{
		Iterator iterator = studyRecordList.iterator();
		String trainTimeLengthToday="0";
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String timeInfo = objs[6].toString();
			String[] timeInfoSplit=timeInfo.split(",");
			int length = timeInfoSplit.length;
			for(int j=0;j<length;j++)
			{
				String[] timeInfoSplitTwice=timeInfoSplit[j].split("\\|");
				if(timeInfoSplitTwice[0].startsWith(monthList.get(i))==true)
				{
					int time=Integer.parseInt(timeInfoSplitTwice[1]);
					trainTimeLengthToday=String.valueOf((Integer.parseInt(trainTimeLengthToday)+time));
				}
			}
			}
		String []addItem = {trainTimeLengthToday,monthList.get(i)};
		timeInfoList.add(addItem);
		}
		}
		else
		{
			String empty[]={"无记录","无记录"};
			timeInfoList.add(empty);
		}
		return timeInfoList;
	}
	

}
