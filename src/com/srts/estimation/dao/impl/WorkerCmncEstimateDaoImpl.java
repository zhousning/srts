package com.srts.estimation.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.estimation.dao.WorkerCmncEstimateDao;
import com.srts.system.domain.Sys_User;

@Repository
@Transactional
public class WorkerCmncEstimateDaoImpl implements WorkerCmncEstimateDao {
	
	@Resource
	private SessionFactory sessionFactory;

	public List<String[]> selectWorkerAcpRatePerMonth(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
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
		for(int i=0;i<monthList.size();i++)
		{
		String sql = "select count(*) from cmnc_answerinfo where cmnc_answerinfo.usrId=:usrId and cmnc_answerinfo.answerDate like'%"+monthList.get(i)+"%'";
		String sql1 = "select count(*) from cmnc_answerinfo,cmnc_pbmansaccept where cmnc_answerinfo.usrId=:usrId and " +
				"cmnc_pbmansaccept.answerId=cmnc_answerinfo.id and cmnc_answerinfo.answerDate like'%"+monthList.get(i)+"%'";
		long usrId = usr.getId();
		int answerAll = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setLong("usrId", usrId)
				.list().get(0)));
		int answerAcp = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId)
				.list().get(0)));
		if(answerAll!=0)
		{
		String[] addItem1={String.valueOf((float)((answerAcp-answerAll)/answerAll)),monthList.get(i)};
		res.add(addItem1);
		}
		else
		{
			String[] addItem1={"0",monthList.get(i)};
			res.add(addItem1);
		}
		}
		return res;
	}

	public List<String[]> selectWorkerProCmncAcp(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
		String sql = "select count(*) from cmnc_answerinfo where cmnc_answerinfo.usrId=:usrId";
		String sql1 = "select count(*) from cmnc_answerinfo,cmnc_pbmansaccept where cmnc_answerinfo.usrId=:usrId and " +
				"cmnc_pbmansaccept.answerId=cmnc_answerinfo.id";
		long usrId = usr.getId();
		int answerAll = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setLong("usrId", usrId)
				.list().get(0)));
		int answerAcp = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId)
				.list().get(0)));
		String[] addItem1 = { String.valueOf(answerAll), "回答数目" };
		String[] addItem2 = { String.valueOf(answerAcp), "被采纳回答数目" };
		String[] addItem3 = { String.valueOf(answerAll-answerAcp), "未被采纳回答数目" };
		res.add(addItem1);
		res.add(addItem2);
		res.add(addItem3);
		return res;
	}

	public List<String[]> selectWorkerProCmncAmount(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
		String sql = "select count(*) from cmnc_probleminfo where cmnc_probleminfo.usrId=:usrId";
		String sql1 = "select count(*) from cmnc_answerinfo where cmnc_answerinfo.usrId=:usrId";
		long usrId = usr.getId();
		int ask = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setLong("usrId", usrId)
				.list().get(0)));
		int answer = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId)
				.list().get(0)));
		String[] addItem1 = { String.valueOf(ask), "提问数目" };
		String[] addItem2 = { String.valueOf(answer), "回答数目" };
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}

	public List<String[]> selectWorkerProCmncAmountToMonth(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
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
		String sql = "select count(*) from cmnc_probleminfo where cmnc_probleminfo.usrId=:usrId and cmnc_probleminfo.postDate like'%"+uploaddate+"%'";
		String sql1 = "select count(*) from cmnc_answerinfo where cmnc_answerinfo.usrId=:usrId and cmnc_answerinfo.answerDate like'%"+uploaddate+"%'";
		long usrId = usr.getId();
		int ask = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setLong("usrId", usrId)
				.list().get(0)));
		int answer = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId)
				.list().get(0)));
		String[] addItem1 = { String.valueOf(ask), "提问数目" };
		String[] addItem2 = { String.valueOf(answer), "回答数目" };
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}

	public List<String[]> selectWorkerProCmncAmountToWeek(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
		String sql = "select count(*) from cmnc_probleminfo where cmnc_probleminfo.postDate<=:endDate and "
				+ "cmnc_probleminfo.postDate>=:startDate and cmnc_probleminfo.usrId=:usrId";
		String sql1 = "select count(*) from cmnc_answerinfo where cmnc_answerinfo.answerDate<=:endDate and "
				+ "cmnc_answerinfo.answerDate>=:startDate and cmnc_answerinfo.usrId=:usrId";
		List<String> dateList = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		for (int k = 0; k < dayWeek; k++) {
			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DATE, -k);
			String year = String.valueOf(calendar1.get(Calendar.YEAR));
			String month = String.valueOf(calendar1.get(Calendar.MONTH) + 1);
			String date = String.valueOf(calendar1.get(Calendar.DATE));
			if (month.length() == 1) {
				month = "0" + month;
			}
			if (date.length() == 1) {
				date = "0" + date;
			}
			String currentTime = year + "-" + month + "-" + date;
			dateList.add(currentTime);
		}
		long usrId = usr.getId();
		int ask = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setString("endDate",
						dateList.get(0)).setString("startDate",
						dateList.get(dayWeek - 1)).setLong("usrId", usrId)
				.list().get(0)));
		int answer = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setString("endDate",
						dateList.get(0)).setString("startDate",
						dateList.get(dayWeek - 1)).setLong("usrId", usrId)
				.list().get(0)));
		String[] addItem1 = { String.valueOf(ask), "提问数目" };
		String[] addItem2 = { String.valueOf(answer), "回答数目" };
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}

	public List<String[]> selectWorkerStuCmncAmount(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
		String sql = "select count(*) from cmnc_bbsartical where cmnc_bbsartical.usrId=:usrId";
		String sql1 = "select count(*) from cmnc_bbsarticalreply where cmnc_bbsarticalreply.usrId=:usrId";
		String sql2 = "select count(*) from cmnc_bbsarticalreply where cmnc_bbsarticalreply.usrId=:usrId";
		long usrId = usr.getId();
		int ask = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setLong("usrId", usrId).list().get(0)));
		int answer = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId).list().get(0)));
		int answer2 = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql2).setLong("usrId", usrId).list().get(0)));
		String[] addItem1 = { String.valueOf(ask), "提问数目" };
		String[] addItem2 = { String.valueOf(answer+answer2), "回答数目" };
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}

	public List<String[]> selectWorkerStuCmncAmountToMonth(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
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
		String sql = "select count(*) from cmnc_bbsartical where cmnc_bbsartical.usrId=:usrId and cmnc_bbsartical.articalDate like'%"+uploaddate+"%'";
		String sql1 = "select count(*) from cmnc_bbsarticalreply where cmnc_bbsarticalreply.usrId=:usrId and cmnc_bbsarticalreply.relayDate like'%"+uploaddate+"%'";
		String sql2 = "select count(*) from cmnc_BBSReplyReply where cmnc_BBSReplyReply.usrId=:usrId and cmnc_BBSReplyReply.relayDate like'%"+uploaddate+"%'";
		long usrId = usr.getId();
		int ask = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setLong("usrId", usrId)
				.list().get(0)));
		int answer = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setLong("usrId", usrId)
				.list().get(0)));
		int answer2 = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql2).setLong("usrId", usrId)
				.list().get(0)));
		String[] addItem1 = { String.valueOf(ask), "提问数目" };
		String[] addItem2 = { String.valueOf(answer+answer2), "回答数目" };
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}

	public List<String[]> selectWorkerStuCmncAmountToWeek(Sys_User usr) {
		List<String[]> res=new ArrayList<String[]>();
		String sql = "select count(*) from cmnc_bbsartical where cmnc_bbsartical.articalDate<=:endDate and "
				+ "cmnc_bbsartical.articalDate>=:startDate and cmnc_bbsartical.usrId=:usrId";
		String sql1 = "select count(*) from cmnc_bbsarticalreply where cmnc_bbsarticalreply.relayDate<=:endDate and "
				+ "cmnc_bbsarticalreply.relayDate>=:startDate and cmnc_bbsarticalreply.usrId=:usrId";
		String sql2 = "select count(*) from cmnc_BBSReplyReply where cmnc_BBSReplyReply.relayDate<=:endDate and "
			+ "cmnc_BBSReplyReply.relayDate>=:startDate and cmnc_BBSReplyReply.usrId=:usrId";
		List<String> dateList = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		for (int k = 0; k < dayWeek; k++) {
			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DATE, -k);
			String year = String.valueOf(calendar1.get(Calendar.YEAR));
			String month = String.valueOf(calendar1.get(Calendar.MONTH) + 1);
			String date = String.valueOf(calendar1.get(Calendar.DATE));
			if (month.length() == 1) {
				month = "0" + month;
			}
			if (date.length() == 1) {
				date = "0" + date;
			}
			String currentTime = year + "-" + month + "-" + date;
			dateList.add(currentTime);
		}
		long usrId = usr.getId();
		int ask = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql).setString("endDate",
						dateList.get(0)).setString("startDate",
						dateList.get(dayWeek - 1)).setLong("usrId", usrId)
				.list().get(0)));
		int answer = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql1).setString("endDate",
						dateList.get(0)).setString("startDate",
						dateList.get(dayWeek - 1)).setLong("usrId", usrId)
				.list().get(0)));
		int answer2 = Integer.parseInt(String.valueOf(sessionFactory
				.getCurrentSession().createSQLQuery(sql2).setString("endDate",
						dateList.get(0)).setString("startDate",
						dateList.get(dayWeek - 1)).setLong("usrId", usrId)
				.list().get(0)));
		String[] addItem1 = { String.valueOf(ask), "提问数目" };
		String[] addItem2 = { String.valueOf(answer+answer2), "回答数目" };
		res.add(addItem1);
		res.add(addItem2);
		return res;
	}

}
