package com.srts.controlPanel.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.controlPanel.dao.PersonalInfoListDao;
import com.srts.system.dao.Sys_UserDao;
import com.srts.system.domain.Sys_User;
@Repository
@Transactional
public class PersonalInfoListDaoImpl implements PersonalInfoListDao {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private Sys_UserDao dao;

	public List<String[]> selectCompetitionInfoByUser(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		long UsrId=usr.getId();
		String SQL="select * from exm_competition "+
		"where usrId=:UsrId";
		List list=sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setLong("UsrId", UsrId).list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String date=objs[2].toString();
				String grade=objs[1].toString();
				String time=objs[3].toString();
				String[] addItem={date,grade,time};
				resList.add(addItem);
			}
		}
		else
		{
			String date="无记录";
			String grade="无记录";
			String time="无记录";
			String[] addItem={date,grade,time};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectMockTestInfoByUser(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		long UsrId=usr.getId();
		String SQL="select exm_testInfo.testDate,exm_testInfo.testContent,exm_userTestScore.grade,exm_testInfo.testCompany,exm_userTestScore.comment from exm_testInfo,exm_testPaper,exm_userTestScore "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId and exm_testPaper.testInfoId=exm_testInfo.id "+
		"and exm_testPaper.type=:type";
		List list=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setLong("UsrId", UsrId).setString("type","模拟").list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String testDate=objs[0].toString();
				String testContent=objs[1].toString();
				String grade=objs[2].toString();
				String testCompany=objs[3].toString();
				String tips=objs[4].toString();
				String[] addItem={testDate,testContent,grade,testCompany,tips};
				resList.add(addItem);
			}
		}
		else
		{
			String testDate="无记录";
			String testContent="无记录";
			String grade="无记录";
			String testCompany="无记录";
			String tips="无记录";
			String[] addItem={testDate,testContent,grade,testCompany,tips};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectNoticeByUser(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		String deptName=usr.getDepartment().getName();
		String parentDeptName="";
		if(usr.getDepartment().getParentdept()!=null)
		{
		parentDeptName=usr.getDepartment().getParentdept().getName();
		}
		String topDeptName="吉林供电公司";
		String SQL="select top 1 * from info_trainNotice "+
		"where info_trainNotice.acceptCompany=:deptName or " +
		"info_trainNotice.acceptCompany=:parentDeptName or " +
		"info_trainNotice.acceptCompany=:topDeptName and " +
		"info_trainNotice.noticeType=:noticeType " +
		"order by info_trainNotice.establishDate desc";
		List list=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setString("noticeType","培训通知").
				setString("deptName",deptName).
				setString("parentDeptName",parentDeptName).
				setString("topDeptName",topDeptName).list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String id=objs[0].toString();
				String noticeType=objs[8].toString();
				String noticeTitle=objs[1].toString();
				String noticeContent=objs[2].toString();
				String[] addItem={id,noticeType,noticeTitle,noticeContent};
				resList.add(addItem);
			}
		}
		else
		{
			String id="无记录";
			String noticeType="培训通知";
			String noticeTitle="无记录";
			String noticeContent="无记录";
			String[] addItem={id,noticeType,noticeTitle,noticeContent};
			resList.add(addItem);
		}
		String SQL1="select top 1 * from info_trainNotice "+
		"where info_trainNotice.acceptCompany=:deptName or " +
		"info_trainNotice.acceptCompany=:parentDeptName or " +
		"info_trainNotice.acceptCompany=:topDeptName and " +
		"info_trainNotice.noticeType=:noticeType " +
		"order by info_trainNotice.establishDate desc";
		List list1=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL1).setString("noticeType","考试通知").
				setString("deptName",deptName).
				setString("parentDeptName",parentDeptName).
				setString("topDeptName",topDeptName).list();
		if(list1.isEmpty()==false)
		{
			Iterator iterator=list1.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String id=objs[0].toString();
				String noticeType=objs[8].toString();
				String noticeTitle=objs[1].toString();
				String noticeContent=objs[2].toString();
				String[] addItem={id,noticeType,noticeTitle,noticeContent};
				resList.add(addItem);
			}
		}
		else
		{
			String id="无记录";
			String noticeType="考试通知";
			String noticeTitle="无记录";
			String noticeContent="无记录";
			String[] addItem={id,noticeType,noticeTitle,noticeContent};
			resList.add(addItem);
		}
		long UsrId=usr.getId();
		String SQL2="select exm_testInfo.testName,exm_userTestScore.grade " +
				"from exm_testInfo,exm_testPaper,exm_userTestScore "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId and exm_testPaper.testInfoId=exm_testInfo.id "+
		"and exm_testPaper.type=:type order by exm_testInfo.testDate desc";
		List list2=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL2).setLong("UsrId", UsrId).setString("type","正式").list();
		int i=1;
		if(list2.isEmpty()==false)
		{
			Iterator iterator=list2.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String id=String.valueOf(i);
				String noticeType="考试情况通报";
				String testName=objs[0].toString();
				String grade=objs[1].toString();
				String[] addItem={id,noticeType,testName,grade};
				i++;
				resList.add(addItem);
			}
		}
		else
		{
			String id="0";
			String noticeType="考试情况通报";
			String testName="无记录";
			String grade="无记录";
			String[] addItem={id,noticeType,testName,grade};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectTrainTestInfoByUser(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		long UsrId=usr.getId();
		String SQL="select exm_testInfo.testDate,exm_testInfo.testContent,exm_userTestScore.grade,exm_testInfo.testCompany,exm_userTestScore.comment from exm_testInfo,exm_testPaper,exm_userTestScore "+
		"where exm_userTestScore.testPaperId=exm_testPaper.id "+
		"and exm_userTestScore.usrId=:UsrId and exm_testPaper.testInfoId=exm_testInfo.id "+
		"and exm_testPaper.type=:type";
		List list=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				SQL).setLong("UsrId", UsrId).setString("type","正式").list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String testDate=objs[0].toString();
				String testContent=objs[1].toString();
				String grade=objs[2].toString();
				String testCompany=objs[3].toString();
				String tips=objs[4].toString();
				String[] addItem={testDate,testContent,grade,testCompany,tips};
				resList.add(addItem);
			}
		}
		else
		{
			String testDate="无记录";
			String testContent="无记录";
			String grade="无记录";
			String testCompany="无记录";
			String tips="无记录";
			String[] addItem={testDate,testContent,grade,testCompany,tips};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectAnswerInfoByUser(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		long usrId=usr.getId();
		String sql="select * from cmnc_answerinfo where cmnc_answerinfo.usrId=:usrId order by cmnc_answerinfo.answerDate desc";
		List list=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				sql).setLong("usrId", usrId).list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String id=objs[0].toString();
				String answerContent=objs[1].toString();
				String answerDate=objs[2].toString();
				String[] addItem={id,answerContent,answerDate};
				resList.add(addItem);
			}
		}
		else
		{
			String id="无记录";
			String answerContent="无记录";
			String answerDate="无记录";
			String[] addItem={id,answerContent,answerDate};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectCourseInfoByUser(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		long usrId=usr.getId();
		String sql="select * from lrn_myStudyCourse where lrn_myStudyCourse.usrId=:usrId order by lrn_myStudyCourse.lastStudyTime desc";
		List list=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				sql).setLong("usrId", usrId).list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String studyContent=objs[8].toString();
				String studyTime=objs[3].toString();
				String lastStudyDate=objs[4].toString();
				String[] addItem={studyContent,studyTime,lastStudyDate};
				resList.add(addItem);
			}
		}
		else
		{
			String studyContent="无记录";
			String studyTime="无记录";
			String lastStudyDate="无记录";
			String[] addItem={studyContent,studyTime,lastStudyDate};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectExerciseInfoByUser(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		long usrId=usr.getId();
		String sql="select * from lrn_onlineExercise where lrn_onlineExercise.userId=:usrId " +
				"order by lrn_onlineExercise.exerciseDate desc";
		List list=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				sql).setLong("usrId", usrId).list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String exerciseName=objs[9].toString();
				String exerciseDate=objs[8].toString();
				String exerciseAcur=objs[5].toString();
				String[] addItem={exerciseName,exerciseDate,exerciseAcur};
				resList.add(addItem);
			}
		}
		else
		{
			String exerciseName="无记录";
			String exerciseDate="无记录";
			String exerciseAcur="无记录";
			String[] addItem={exerciseName,exerciseDate,exerciseAcur};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectFavorCourse() {
		List<String[]> resList=new ArrayList<String[]>();
		String sql="select top 5 * from klg_book order by klg_book.viewCount desc";
		List list=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String bookName=objs[1].toString();
				String viewCount=objs[5].toString();
				String[] addItem={bookName,viewCount};
				resList.add(addItem);
			}
		}
		else
		{
			String bookName="无记录";
			String viewCount="无记录";
			String[] addItem={bookName,viewCount};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectFavorKlgBank() {
		List<String[]> resList=new ArrayList<String[]>();
		String SQL1="select top 2 * from klg_ruleLearning order by searchnum desc";
		String SQL2="select top 2 * from klg_typicalViolation order by searchnum desc";
		String SQL3="select top 2 * from klg_typicalCase order by searchnum desc";
		List list1=(List) sessionFactory.getCurrentSession().createSQLQuery(SQL1).list();
		List list2=(List) sessionFactory.getCurrentSession().createSQLQuery(SQL2).list();
		List list3=(List) sessionFactory.getCurrentSession().createSQLQuery(SQL3).list();
		if(list1.isEmpty()==false)
		{
			Iterator iterator1 = list1.iterator();
			while(iterator1.hasNext()){
				Object[] objs = (Object[]) iterator1.next();
				String[] addItem1={"条文导学",objs[1].toString()+objs[2].toString()+objs[3].toString(),objs[8].toString(),objs[0].toString()};
				resList.add(addItem1);}
		}
		if(list2.isEmpty()==false)
		{
			Iterator iterator2 = list2.iterator();
			while(iterator2.hasNext()){
				Object[] objs = (Object[]) iterator2.next();
				String[] addItem2={"典型违章",objs[1].toString(),objs[2].toString(),objs[0].toString()};
				resList.add(addItem2);}
		}
		if(list3.isEmpty()==false)
		{
			Iterator iterator3 = list3.iterator();
			while(iterator3.hasNext()){
				Object[] objs = (Object[]) iterator3.next();
				String[] addItem3={"典型案例",objs[1].toString(),objs[2].toString(),objs[0].toString()};
				resList.add(addItem3);
			}
		}
		return resList;
	}

	public List<String[]> selectFavorThemeByUser() {
		List<String[]> resList=new ArrayList<String[]>();
		String sql="select top 5 * from cmnc_bbsartical order by cmnc_bbsartical.viewCount desc";
		List list=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String id=objs[0].toString();
				String articleTitle=objs[1].toString();
				String articleDate=objs[3].toString();
				String userName=dao.getById(Long.parseLong(objs[7].toString())).getName();
				String replyCount=objs[5].toString();
				String[] addItem={id,articleTitle,articleDate,userName,replyCount};
				resList.add(addItem);
			}
		}
		else
		{
			String id="0";
			String articleTitle="无记录";
			String articleDate="无记录";
			String userName="无记录";
			String replyCount="无记录";
			String[] addItem={id,articleTitle,articleDate,userName,replyCount};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectKlgBankInfoByUser(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		long usrId=usr.getId();
		String sql="select * from klg_experience where klg_experience.usrId=:usrId order by klg_experience.uploaddate desc";
		List list=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				sql).setLong("usrId", usrId).list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String klgContent=objs[1].toString();
				String klgDate=objs[4].toString();
				String type="操作经验";
				String[] addItem={klgContent,klgDate,type};
				resList.add(addItem);
			}
		}
		else
		{
			String klgContent="无记录";
			String klgDate="无记录";
			String type="无记录";
			String[] addItem={klgContent,klgDate,type};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectProblemInfoByUser(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		long usrId=usr.getId();
		String sql="select * from cmnc_probleminfo where cmnc_probleminfo.usrId=:usrId order by cmnc_probleminfo.postDate desc";
		List list=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(
				sql).setLong("usrId", usrId).list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String id=objs[0].toString();
				String proContent=objs[1].toString();
				String proDate=objs[3].toString();
				String proAnsCount=objs[7].toString();
				String[] addItem={id,proContent,proDate,proAnsCount};
				resList.add(addItem);
			}
		}
		else
		{
			String id="0";
			String proContent="无记录";
			String proDate="无记录";
			String proAnsCount="无记录";
			String[] addItem={id,proContent,proDate,proAnsCount};
			resList.add(addItem);
		}
		return resList;
	}

	public List<String[]> selectThemeByUser(Sys_User usr) {
		List<String[]> resList=new ArrayList<String[]>();
		long usrId=usr.getId();
		String sql="select * from cmnc_bbsartical where cmnc_bbsartical.usrId=:usrId order by cmnc_bbsartical.articalDate desc";
		List list=(List) sessionFactory.getCurrentSession()
		.createSQLQuery(sql).setLong("usrId",usrId).list();
		if(list.isEmpty()==false)
		{
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objs=(Object[])iterator.next();
				String id=objs[0].toString();
				String articleTitle=objs[1].toString();
				String articleDate=objs[3].toString();
				String userName=dao.getById(Long.parseLong(objs[7].toString())).getName();
				String replyCount=objs[5].toString();
				String[] addItem={id,articleTitle,articleDate,userName,replyCount};
				resList.add(addItem);
			}
		}
		else
		{
			String id="0";
			String articleTitle="无记录";
			String articleDate="无记录";
			String userName="无记录";
			String replyCount="无记录";
			String[] addItem={id,articleTitle,articleDate,userName,replyCount};
			resList.add(addItem);
		}
		return resList;
	}

}
