package com.srts.estimation.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.estimation.dao.WorkerKlgBankEstimateDao;
import com.srts.system.domain.Sys_User;

@Repository
@Transactional
public class WorkerKlgBankEstimateDaoImpl implements WorkerKlgBankEstimateDao {
	
	@Resource
	private SessionFactory sessionFactory;

	public List<String[]> findWorkerKlgSearchRecord(Sys_User usr,
			String startDate, String endDate, String type) {
		List<String[]> res=new ArrayList<String[]>();
		long usrId=usr.getId();
		if(type.equals("典型违章"))
		{
			int i=1;
			String sql="select * from klg_violationSearchRecord,klg_typicalViolation " +
					"where klg_violationSearchRecord.content_id=klg_typicalViolation.id and " +
					"klg_violationSearchRecord.usrId=:usrId and klg_violationSearchRecord.searchdate<=:endDate " +
					"and klg_violationSearchRecord.searchdate>=:startDate";
			List list=sessionFactory.getCurrentSession().createSQLQuery(sql).setString(
					"startDate",startDate).setString("endDate",endDate)
			.setLong("usrId", usrId).list();
			Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String id=String.valueOf(i);
				String searchdate=objs[2].toString();
				String title=objs[5].toString();
				String content=objs[7].toString();
				String vioType=objs[10].toString();
				String[] temp={id,searchdate,vioType,title,content};
				res.add(temp);
				i++;
			}
		}
		else if(type.equals("条文导学"))
		{
			int i=1;
			String sql="select * from klg_ruleLearningSearchRecord,klg_ruleLearning " +
					"where klg_ruleLearningSearchRecord.content_id=klg_ruleLearning.id and " +
					"klg_ruleLearningSearchRecord.usrId=:usrId and klg_ruleLearningSearchRecord.searchdate<=:endDate " +
					"and klg_ruleLearningSearchRecord.searchdate>=:startDate";
			List list=sessionFactory.getCurrentSession().createSQLQuery(sql).setString(
					"startDate",startDate).setString("endDate",endDate)
			.setLong("usrId", usrId).list();
			Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String id=String.valueOf(i);
				String searchdate=objs[2].toString();
				String title=objs[5].toString()+" "+objs[6].toString()+" "+objs[7].toString();
				String content=objs[8].toString();
				String ruleType="条文导学";
				String[] temp={id,searchdate,ruleType,title,content};
				res.add(temp);
				i++;
			}
			return res;
		}
		else if(type.equals("典型案例"))
		{
			int i=1;
			String sql="select * from klg_caseSearchRecord,klg_typicalCase " +
					"where klg_caseSearchRecord.content_id=klg_typicalCase.id and " +
					"klg_caseSearchRecord.usrId=:usrId and klg_caseSearchRecord.searchdate<=:endDate " +
					"and klg_caseSearchRecord.searchdate>=:startDate";
			List list=sessionFactory.getCurrentSession().createSQLQuery(sql).setString(
					"startDate",startDate).setString("endDate",endDate)
			.setLong("usrId", usrId).list();
			Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String id=String.valueOf(i);
				String searchdate=objs[2].toString();
				String title=objs[5].toString();
				String content=objs[7].toString();
				String caseType=objs[10].toString();
				String[] temp={id,searchdate,caseType,title,content};
				res.add(temp);
				i++;
			}
		}
		else if(type.equals("操作经验"))
		{
			int i=1;
			String sql="select * from klg_experienceSearchRecord,klg_experience " +
					"where klg_experienceSearchRecord.content_id=klg_experience.id and " +
					"klg_experienceSearchRecord.usrId=:usrId and klg_experienceSearchRecord.searchdate<=:endDate " +
					"and klg_experienceSearchRecord.searchdate>=:startDate";
			List list=sessionFactory.getCurrentSession().createSQLQuery(sql).setString(
					"startDate",startDate).setString("endDate",endDate)
			.setLong("usrId", usrId).list();
			Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String id=String.valueOf(i);
				String searchdate=objs[2].toString();
				String content=objs[5].toString();
				String explaination=objs[7].toString();
				String uploaddate=objs[8].toString();
				String[] temp={id,searchdate,content,explaination,uploaddate};
				res.add(temp);
				i++;
			}
		}
		return res;
	}

	public List<String[]> workerKlgSearchEst(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
		long usrId=usr.getId();
		String sql1="select count(*) from klg_violationSearchRecord where klg_violationSearchRecord.usrId=:usrId";
		String sql2="select count(*) from klg_ruleLearningSearchRecord where klg_ruleLearningSearchRecord.usrId=:usrId";
		String sql3="select count(*) from klg_caseSearchRecord where klg_caseSearchRecord.usrId=:usrId";
		String sql4="select count(*) from klg_experienceSearchRecord where klg_experienceSearchRecord.usrId=:usrId";
		int vio = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId).list().get(0)));
		int rule = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql2).setLong("usrId", usrId).list().get(0)));
		int tcase = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql3).setLong("usrId", usrId).list().get(0)));
		int exp = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql4).setLong("usrId", usrId).list().get(0)));
		String[] addItem1 = { String.valueOf(vio), "典型违章" };
		String[] addItem2 = { String.valueOf(rule), "条文导学" };
		String[] addItem3 = { String.valueOf(tcase), "典型案例" };
		String[] addItem4 = { String.valueOf(exp), "操作经验" };
		res.add(addItem1);
		res.add(addItem2);
		res.add(addItem3);
		res.add(addItem4);
		return res;
	}

	public List<String[]> workerKlgSearchEstToMonth(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
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
		String searchdate=year+"-"+month;
		String sql1="select count(*) from klg_violationSearchRecord where klg_violationSearchRecord.usrId=:usrId and " +
				"klg_violationSearchRecord.searchdate like'%"+searchdate+"%'";
		String sql2="select count(*) from klg_ruleLearningSearchRecord where klg_ruleLearningSearchRecord.usrId=:usrId and " +
		"klg_ruleLearningSearchRecord.searchdate like'%"+searchdate+"%'";
		String sql3="select count(*) from klg_caseSearchRecord where klg_caseSearchRecord.usrId=:usrId and " +
		"klg_caseSearchRecord.searchdate like'%"+searchdate+"%'";
		String sql4="select count(*) from klg_experienceSearchRecord where klg_experienceSearchRecord.usrId=:usrId and " +
		"klg_experienceSearchRecord.searchdate like'%"+searchdate+"%'";
		int vio = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId).list().get(0)));
		int rule = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql2).setLong("usrId", usrId).list().get(0)));
		int tcase = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql3).setLong("usrId", usrId).list().get(0)));
		int exp = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql4).setLong("usrId", usrId).list().get(0)));
		String[] addItem1 = { String.valueOf(vio), "典型违章" };
		String[] addItem2 = { String.valueOf(rule), "条文导学" };
		String[] addItem3 = { String.valueOf(tcase), "典型案例" };
		String[] addItem4 = { String.valueOf(exp), "操作经验" };
		res.add(addItem1);
		res.add(addItem2);
		res.add(addItem3);
		res.add(addItem4);
		return res;
	}

	public List<String[]> workerKlgSearchEstToWeek(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
		long usrId=usr.getId();
		List<String> dateList=new ArrayList<String>();
		Calendar calendar=Calendar.getInstance();
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
		String sql1="select count(*) from klg_violationSearchRecord where klg_violationSearchRecord.usrId=:usrId and " +
				"klg_violationSearchRecord.searchdate<=:endDate and klg_violationSearchRecord.searchdate>=:startDate";
		String sql2="select count(*) from klg_ruleLearningSearchRecord where klg_ruleLearningSearchRecord.usrId=:usrId and " +
		"klg_ruleLearningSearchRecord.searchdate<=:endDate and klg_ruleLearningSearchRecord.searchdate>=:startDate";
		String sql3="select count(*) from klg_caseSearchRecord where klg_caseSearchRecord.usrId=:usrId and " +
		"klg_caseSearchRecord.searchdate<=:endDate and klg_caseSearchRecord.searchdate>=:startDate";
		String sql4="select count(*) from klg_experienceSearchRecord where klg_experienceSearchRecord.usrId=:usrId and " +
		"klg_experienceSearchRecord.searchdate<=:endDate and klg_experienceSearchRecord.searchdate>=:startDate";
		int vio = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setString(
						"endDate", dateList.get(0)).setString("startDate",dateList.get(dayWeek-1)).setLong("usrId", usrId).list().get(0)));
		int rule = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql2).setString(
						"endDate", dateList.get(0)).setString("startDate",dateList.get(dayWeek-1)).setLong("usrId", usrId).list().get(0)));
		int tcase = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql3).setString(
						"endDate", dateList.get(0)).setString("startDate",dateList.get(dayWeek-1)).setLong("usrId", usrId).list().get(0)));
		int exp = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql4).setString(
						"endDate", dateList.get(0)).setString("startDate",dateList.get(dayWeek-1)).setLong("usrId", usrId).list().get(0)));
		String[] addItem1 = { String.valueOf(vio), "典型违章" };
		String[] addItem2 = { String.valueOf(rule), "条文导学" };
		String[] addItem3 = { String.valueOf(tcase), "典型案例" };
		String[] addItem4 = { String.valueOf(exp), "操作经验" };
		res.add(addItem1);
		res.add(addItem2);
		res.add(addItem3);
		res.add(addItem4);
		return res;
	}

	public List<String[]> workerKlgSearchEstToday(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
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
		String searchdate=year+"-"+month+"-"+date;
		String sql1="select count(*) from klg_violationSearchRecord where klg_violationSearchRecord.usrId=:usrId and " +
				"klg_violationSearchRecord.searchdate=:searchdate";
		String sql2="select count(*) from klg_ruleLearningSearchRecord where klg_ruleLearningSearchRecord.usrId=:usrId and " +
		"klg_ruleLearningSearchRecord.searchdate=:searchdate";
		String sql3="select count(*) from klg_caseSearchRecord where klg_caseSearchRecord.usrId=:usrId and " +
		"klg_caseSearchRecord.searchdate=:searchdate";
		String sql4="select count(*) from klg_experienceSearchRecord where klg_experienceSearchRecord.usrId=:usrId and " +
		"klg_experienceSearchRecord.searchdate=:searchdate";
		int vio = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setString(
						"searchdate", searchdate).setLong("usrId", usrId).list().get(0)));
		int rule = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql2).setString(
						"searchdate", searchdate).setLong("usrId", usrId).list().get(0)));
		int tcase = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql3).setString(
						"searchdate", searchdate).setLong("usrId", usrId).list().get(0)));
		int exp = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql4).setString(
						"searchdate", searchdate).setLong("usrId", usrId).list().get(0)));
		String[] addItem1 = { String.valueOf(vio), "典型违章" };
		String[] addItem2 = { String.valueOf(rule), "条文导学" };
		String[] addItem3 = { String.valueOf(tcase), "典型案例" };
		String[] addItem4 = { String.valueOf(exp), "操作经验" };
		res.add(addItem1);
		res.add(addItem2);
		res.add(addItem3);
		res.add(addItem4);
		return res;
	}

	public List<String[]> workerOpExpUploadToMonth(Sys_User usr) {
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		String date = String.valueOf(calendar.get(Calendar.DATE));
		if (month.length() == 1) {
			month = "0" + month;
		}
		if (date.length() == 1) {
			date = "0" + date;
		}
		String uploaddate = year + "-" + month;
		String sql = "select count(*) from klg_experience where klg_experience.uploaddate like'%"+uploaddate+"%' "
				+ "and klg_experience.usrId=:usrId and klg_experience.statement=:statement";
		long usrId = usr.getId();
		int checked = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setString("statement", "已审核")
				.setLong("usrId", usrId).list().get(0)));
		int unchecked = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setString("statement", "未审核")
				.setLong("usrId", usrId).list().get(0)));
		List<String[]> res = new ArrayList<String[]>();
		String[] addItem1 = { String.valueOf(checked), "已审核" };
		String[] addItem2 = { String.valueOf(unchecked), "未审核" };
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}

	public List<String[]> workerOpExpUploadToWeek(Sys_User usr) {
		String sql = "select count(*) from klg_experience where klg_experience.uploaddate<=:endDate and "
				+ "klg_experience.uploaddate>=:startDate and klg_experience.usrId=:usrId and klg_experience.statement=:statement";
		List<String> dateList=new ArrayList<String>();
		Calendar calendar=Calendar.getInstance();
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
		long usrId = usr.getId();
		int checked = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setString(
						"endDate", dateList.get(0)).setString("startDate", dateList.get(dayWeek-1)).setString("statement", "已审核")
				.setLong("usrId", usrId).list().get(0)));
		int unchecked = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setString(
						"endDate", dateList.get(0)).setString("startDate", dateList.get(dayWeek-1)).setString("statement", "未审核")
				.setLong("usrId", usrId).list().get(0)));
		List<String[]> res = new ArrayList<String[]>();
		String[] addItem1 = { String.valueOf(checked), "已审核" };
		String[] addItem2 = { String.valueOf(unchecked), "未审核" };
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}

	public List<String[]> workerOpExpUploadToday(Sys_User usr) {
		String sql="select count(*) from klg_experience where klg_experience.uploaddate=:uploaddate " +
				"and klg_experience.usrId=:usrId and klg_experience.statement=:statement";
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
		String uploaddate=year+"-"+month+"-"+date;
		long usrId=usr.getId();
		int checked=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
				.createSQLQuery(
						sql).setString("uploaddate",uploaddate).setString("statement", "已审核").setLong("usrId", usrId).list().get(0)));
		int unchecked=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
				.createSQLQuery(
						sql).setString("uploaddate",uploaddate).setString("statement", "未审核").setLong("usrId", usrId).list().get(0)));
		List<String[]> res=new ArrayList<String[]>();
		String[] addItem1={String.valueOf(checked),"已审核"};
		String[] addItem2={String.valueOf(unchecked),"未审核"};
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}
	
	

}
