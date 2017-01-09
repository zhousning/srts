package com.srts.learning.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.communication.po.CommUtils;
import com.srts.information.domain.TrainNotice;
import com.srts.learning.dao.OnlineCourseTraceManageDao;
import com.srts.learning.domain.MyStudyCourse;

/**
 * 学习痕迹dao
 * @author wyw
 *
 */

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class OnlineCourseTraceManageDaoImpl extends BaseDaoImpl<MyStudyCourse> implements OnlineCourseTraceManageDao{
	/**
	 * 获取所有员工学习记录
	 * @return
	 */
	public List<Object[]> getAllUserStudyTrace(int year,int month){
		String SQL = "select usr.id, usr.name,usr.company,usr.job,msc.id,msc.sumTime,msc.studyRecord,msc.studyContent "+
			"from srts_sys_user usr,lrn_myStudyCourse msc "+
			"where usr.id = msc.usrId "+
			"and msc.trainId in ("+
			"select tr.id from lrn_train tr,info_trainNotice tn "+
			"where tr.noticeId = tn.id "+
			"and tn.nonticeYear = :year "+
			"and tn.nonticeMonth = :month "+
			")";
		return getSession().createSQLQuery(SQL).setInteger("year", year).setInteger("month", month).list();
	}
	
	/**
	 * 获取员工学习记录
	 * @param year
	 * @param month
	 * @param min
	 * @param max
	 * @return
	 */
	public List<Object[]> getAllUserCourseTrace(int year,int month,int min,int max){
		String SQL = "select usr.id, usr.name,usr.company,usr.job,msc.id,msc.sumTime,msc.studyRecord,msc.studyContent "+
			"from srts_sys_user usr,lrn_myStudyCourse msc "+
			"where usr.id = msc.usrId "+
			"and msc.trainId in ("+
			"select tr.id from lrn_train tr,info_trainNotice tn "+
			"where tr.noticeId = tn.id "+
			"and tn.nonticeYear = :year "+
			"and tn.nonticeMonth = :month "+
			")";
		return getSession().createSQLQuery(SQL).setInteger("year", year).setInteger("month", month).setFirstResult(min).setMaxResults(max).list();
	}
	
	/**
	 * 统计总数
	 * @return
	 */
	public Integer getUsrCourseTraceCount(int year,int month){
		String SQL = "select count(*) "+
			"from srts_sys_user usr,lrn_myStudyCourse msc "+
			"where usr.id = msc.usrId "+
			"and msc.trainId in ("+
			"select tr.id from lrn_train tr,info_trainNotice tn "+
			"where tr.noticeId = tn.id "+
			"and tn.nonticeYear = :year "+
			"and tn.nonticeMonth = :month "+
			")";
		return (Integer)getSession().createSQLQuery(SQL).setInteger("year", year).setInteger("month", month).uniqueResult();
	}
	
	/**
	 * 根据年份和月份获取noticetitle
	 * @param noticeYear
	 * @param noticeMonth
	 * @return
	 */
	public List<TrainNotice> getOnlineCourseNoticeTitle(int noticeYear){
		String HQL = "from TrainNotice TrainNotice where nonticeYear=:nonticeYear";
		return (List<TrainNotice>) getSession().createQuery(HQL).setInteger("nonticeYear", noticeYear).list();
	}
	
	/**
	 * 根据设置条件查询检索结果
	 * @param year
	 * @param month
	 * @param options
	 * @param optionMatch
	 * @param max
	 * @param min
	 * @return
	 */
	public List<Object[]> getUserStudyTraceQueryByOptions(int year,int month,Map<String,String> options,String optionMatch,int max,int min){
		String name = null;
		String job = null;
		String company = null;
		String studyContent = null;
		
		Query query = null;
		Session session = getSession();
		session = getSession();
		
		String SQL = "select usr.id, usr.name,usr.company,usr.job,msc.id,msc.sumTime,msc.studyRecord,msc.studyContent "+
			"from srts_sys_user usr,lrn_myStudyCourse msc,info_trainNotice tn "+
			"where usr.id = msc.usrId "+
			"and msc.trainId in ("+
			"select tr.id from lrn_train tr,info_trainNotice tn "+
			"where tr.noticeId = tn.id "+
			"and tn.nonticeYear = :year "+
			"and tn.nonticeMonth = :month "+
			") ";
		String SQL_w="and usr.name = :name ";
		String SQL_a="and usr.job = :job ";
		String SQL_n="and usr.company = :company ";
		String SQL_g="and tn.noticeTitle = :studyContent ";
		
		String[] optionMatchs = optionMatch.split(" ");
		for(String match:optionMatchs){
			if(match=="w" || match.equals("w")){
				SQL+=SQL_w;
				name = options.get("w");
			}
			if(match=="a" || match.equals("a")){
				SQL+=SQL_a;
				job = options.get("a");
			}
			if(match=="n" || match.equals("n")){
				SQL+=SQL_n;
				company = options.get("n");
			}
			if(match=="g" || match.equals("g")){
				SQL+=SQL_g;
				studyContent = options.get("g");
			}
		}
		query = session.createSQLQuery(SQL);
		if(name != null){
			query.setString("name",name);
		}
		if(job != null){
			query.setString("job",job);
		}
		if(company != null){
			query.setString("company",company);
		}
		if(studyContent != null){
			query.setString("studyContent",studyContent);
		}
		query.setInteger("year", year);
		query.setInteger("month", month);
		query.setFirstResult(min);
		query.setMaxResults(max);
		return query.list();
	}
	
	/**
	 * 根据设置条件统计总数
	 * @param year
	 * @param month
	 * @param options
	 * @param optionMatch
	 * @return
	 */
	public Integer getCourseTraceCountQueryByOptions(int year,int month,Map<String,String> options,String optionMatch){
		String name = null;
		String company = null;
		String job = null;
		String studyContent = null;
		
		Query query = null;
		Session session = getSession();
		session = getSession();
		
		String SQL = "select count(*) "+
			"from srts_sys_user usr,lrn_myStudyCourse msc "+
			"where usr.id = msc.usrId "+
			"and msc.trainId in ("+
			"select tr.id from lrn_train tr,info_trainNotice tn "+
			"where tr.noticeId = tn.id "+
			"and tn.nonticeYear = :year "+
			"and tn.nonticeMonth = :month "+
			") ";
		String SQL_w="and usr.name = :name ";
		String SQL_a="and usr.job = :job ";
		String SQL_n="and usr.company = :company ";
		String SQL_g="and tn.noticeTitle = :studyContent ";
		
		String[] optionMatchs = optionMatch.split(" ");
		for(String match:optionMatchs){
			if(match=="w"){
				SQL+=SQL_w;
				name = options.get("w");
			}
			if(match=="a"){
				SQL+=SQL_a;
				job = options.get("a");
			}
			if(match=="n"){
				SQL+=SQL_n;
				company = options.get("n");
			}
			if(match=="g"){
				SQL+=SQL_g;
				studyContent = options.get("g");
			}
		}
		query = session.createSQLQuery(SQL);
		if(name != null){
			query.setString("name",name);
		}
		if(job != null){
			query.setString("job",job);
		}
		if(company != null){
			query.setString("company",company);
		}
		if(studyContent != null){
			query.setString("studyContent",studyContent);
		}
		query.setInteger("year", year);
		query.setInteger("month", month);
		return (Integer) query.uniqueResult();
	}
	
	/**
	 * 获取员工的单个月学习记录
	 * @param uesrID
	 * @param noticeYear
	 * @param noticeMonth
	 * @param noticeTitle
	 * @return
	 */
	public String getUserOnlineCourseTraceRecord(long uesrID,int noticeYear,int noticeMonth,String noticeTitle){
		String SQL = "select msc.studyRecord "+
			"from srts_sys_user usr,lrn_myStudyCourse msc,info_trainNotice tn "+
			"where usr.id = msc.usrId "+
			"and msc.trainId in ("+
				"select tr.id from lrn_train tr,info_trainNotice tn "+
				"where tr.noticeId = tn.id "+
				"and tn.nonticeYear = :nonticeYear "+
				"and tn.nonticeMonth = :nonticeMonth "+
			")"+
			"and tn.noticeTitle = :noticeTitle "+
			"and usr.id = :userID";
		return (String) getSession().createSQLQuery(SQL)
			.setInteger("nonticeYear", noticeYear)
			.setInteger("nonticeMonth", noticeMonth)
			.setLong("userID",uesrID)
			.setString("noticeTitle", noticeTitle)
			.uniqueResult();
	}
	
	/**
	 * 按单位统计员工学习总时
	 * @param year
	 * @param month
	 * @return
	 */
	public List<Object[]> getCompanyTimeCount(int year, int month){
		String SQL = "select sum(msc.sumTime),company " +
				"from srts_sys_user usr,lrn_myStudyCourse msc " +
				"where usr.id = msc.usrId " +
				"and msc.trainId in ( " +
					"select tr.id " +
					"from lrn_train tr,info_trainNotice tn " +
					"where tr.noticeId = tn.id " +
					"and tn.nonticeYear = :noticeYear " +
					"and tn.nonticeMonth = :noticeMonth)" +
				"group by company";
		return getSession().createSQLQuery(SQL).setInteger("noticeYear", year).setInteger("noticeMonth", month).list();
	}
	
	/**
	 * 获取各个单位的员工总数
	 * @return
	 */
	public Integer getCompanyUserNumCount(){
		String HQL = "";
		return null;
	}
	
	/**
	 * 获取所有的单位
	 * @return
	 */
	public List<String> getCompany(){
		String HQL = "";
		return null;
	}
	
	/**
	 * 根据月份统计各个月的学习总时
	 * @param month
	 * @return
	 */
	public BigDecimal getMonthStudyTimeCount(int year,int month){
		String SQL = "select SUM(msc.sumTime) " +
				"from lrn_myStudyCourse msc " +
				"where msc.trainId in (" +
					"select tr.id " +
					"from lrn_train tr,info_trainNotice tn 	" +
					"where tr.noticeId = tn.id " +
					"and tn.nonticeYear = :noticeYear " +
					"and tn.nonticeMonth = :noticeMonth )";
		return (BigDecimal) getSession().createSQLQuery(SQL).setInteger("noticeYear", year).setInteger("noticeMonth", month).uniqueResult();
	}
}
