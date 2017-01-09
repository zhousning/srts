package com.srts.knowledge.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.dao.KlgBankListDao;
import com.srts.system.domain.Sys_User;

@Repository
@Transactional
public class KlgBankListDaoImpl implements KlgBankListDao {
	@Resource
	private SessionFactory sessionFactory;

	public List findFavorRuleByUser(Sys_User user) {
		// TODO Auto-generated method stub
		long id=user.getId();
		String SQL="select top 5 * from("+ 
                   "select count(klg_ruleLearning.id) countnum,klg_ruleLearning.id,klg_ruleLearning.bookname,klg_ruleLearning.chaptername"+
                   ",klg_ruleLearning.roleno,"+
                   "klg_ruleLearning.content,klg_ruleLearning.pic,klg_ruleLearning.updatedate,klg_ruleLearning.uploaddate "+
                   "from klg_ruleLearning,klg_ruleLearningSearchRecord "+
                   "where klg_ruleLearning.id=klg_ruleLearningSearchRecord.content_id "+ 
                   "and klg_ruleLearningSearchRecord.usrId=:id "+
                   "group by klg_ruleLearning.id,klg_ruleLearning.bookname,klg_ruleLearning.chaptername"+
                   ",klg_ruleLearning.roleno,"+
                   "klg_ruleLearning.content,klg_ruleLearning.pic,klg_ruleLearning.updatedate,klg_ruleLearning.uploaddate) ruleCount "+
                   "order by countnum desc";
		return (List) sessionFactory.getCurrentSession().createSQLQuery(SQL).setLong("id",id).list();
	}

	public List findPopKlgBank() {
		// TODO Auto-generated method stub
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
				String[] addItem1={"条文导学",objs[4].toString(),objs[6].toString(),objs[0].toString()};
				resList.add(addItem1);}
		}
		if(list2.isEmpty()==false)
		{
			Iterator iterator2 = list2.iterator();
			while(iterator2.hasNext()){
				Object[] objs = (Object[]) iterator2.next();
				String[] addItem2={"典型违章",objs[3].toString(),objs[5].toString(),objs[0].toString()};
				resList.add(addItem2);}
		}
		if(list3.isEmpty()==false)
		{
			Iterator iterator3 = list3.iterator();
			while(iterator3.hasNext()){
				Object[] objs = (Object[]) iterator3.next();
				String[] addItem3={"典型案例",objs[3].toString(),objs[5].toString(),objs[0].toString()};
				resList.add(addItem3);
			}
		}
		return resList;
	}

	public List<Integer[]> findSearchnumByMonth() {
		// TODO Auto-generated method stub
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
		int tag=0;
		List<Integer[]> resList=new ArrayList<Integer[]>();
		String[] kind={"01","02","03","04","05","06","07","08","09","10","11","12"};
		for(int a=0;a<12;a++)
		{
			if(month.equals(kind[a]))
			{
				tag=a+1;
			}
		}
		for(int i=0;i<tag;i++)
		{
			String Time=year+"-"+kind[i];
			String SQL1="select count(*) from klg_ruleLearningSearchRecord "
				+"where klg_ruleLearningSearchRecord.searchdate like'%"+Time+"%'";
			String SQL2="select count(*) from klg_violationSearchRecord "
				+"where klg_violationSearchRecord.searchdate like'%"+Time+"%'";
			String SQL3="select count(*) from klg_caseSearchRecord "
				+"where klg_caseSearchRecord.searchdate like'%"+Time+"%'";
			String SQL4="select count(*) from klg_experienceSearchRecord "
				+"where klg_experienceSearchRecord.searchdate like'%"+Time+"%'";
			int num1=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
					.createSQLQuery(
							SQL1).list().get(0)));
			int num2=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
					.createSQLQuery(
							SQL2).list().get(0)));
			int num3=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
					.createSQLQuery(
							SQL3).list().get(0)));
			int num4=Integer.parseInt(String.valueOf(sessionFactory.getCurrentSession()
					.createSQLQuery(
							SQL4).list().get(0)));
			Integer []temp={num1,num2,num3,num4};
			resList.add(temp);			
		}
		return resList;
	}

	public int insertIntoExperience(String content, String statement,
			String explaination, String uploaddate, String updatedate,
			String checkeddate, Sys_User user) {
		long id=user.getId();
		String sql="insert into klg_experience(content,statement,explaination,uploaddate,updatedate,checkeddate,usrId,searchnum) values(?,?,?,?,?,?,?,?)";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setString(0,content);
		query.setString(1, statement);
		query.setString(2, explaination);
		query.setString(3, uploaddate);
		query.setString(4, updatedate);
		query.setString(5, checkeddate);
		query.setLong(6, id);
		query.setLong(7, 0);
		int insertRes=query.executeUpdate();
		return insertRes;
	}

	public List listTopFiveRule() {
		// TODO Auto-generated method stub
		String SQL="select top 5 * from klg_ruleLearning order by uploaddate desc";
		return (List) sessionFactory.getCurrentSession().createSQLQuery(SQL).list();
	}

	public List listTopFiveViolation() {
		// TODO Auto-generated method stub
		String SQL="select top 5 * from klg_typicalViolation order by uploaddate desc";
		return (List) sessionFactory.getCurrentSession().createSQLQuery(SQL).list();
	}

	public List listTopOneCase() {
		// TODO Auto-generated method stub
		String SQL="select top 1 * from klg_typicalCase order by uploaddate desc";
		return (List) sessionFactory.getCurrentSession().createSQLQuery(SQL).list();
	}

	public List listTopOneOperateSheet() {
		// TODO Auto-generated method stub
		String SQL="select top 1 * from klg_operateSheet order by uploaddate desc";
		return (List) sessionFactory.getCurrentSession().createSQLQuery(SQL).list();
	}

	public List listTopOneWorkSheet() {
		// TODO Auto-generated method stub
		String SQL="select top 1 * from klg_workSheet order by uploaddate desc";
		return (List) sessionFactory.getCurrentSession().createSQLQuery(SQL).list();
	}

	public List listTopThreeExperience() {
		// TODO Auto-generated method stub
		String SQL="select top 3 * from klg_experience where klg_experience.statement=:statement order by uploaddate desc";
		return (List) sessionFactory.getCurrentSession().createSQLQuery(SQL).setString("statement","已审核").list();
	}

	public List searchKlgBankByTypeAndKeyWords(String type, String keyWords) {
		// TODO Auto-generated method stub
		String SQL=null;
		if(type.equals("条文导学")==true)
		{
		     SQL="select * from klg_ruleLearning " +
		     "where klg_ruleLearning.content like'%"+keyWords+"%'";
		}else if(type.equals("典型案例")==true)
		{
		     SQL="select * from klg_typicalCase " +
		     "where klg_typicalCase.content like'%"+keyWords+"%'";
		}else if(type.equals("典型违章")==true)
		{
		     SQL="select * from klg_typicalViolation " +
		     "where klg_typicalViolation.content like'%"+keyWords+"%'";
		}else if(type.equals("操作经验")==true)
		{
		     SQL="select * from klg_experience " +
		     "where klg_experience.statement='已审核' and klg_experience.content like'%"+keyWords+"%'";
		}
        return (List) sessionFactory.getCurrentSession()
        .createSQLQuery(SQL).list();
	}

	public List findAllInfo(String id, String type) {
		String SQL=null;
		Long idValue=Long.parseLong(id);
		if(type.equals("条文导学")==true)
		{
		     SQL="select * from klg_ruleLearning " +
		     "where klg_ruleLearning.id=:id";
		}else if(type.equals("典型案例")==true)
		{
		     SQL="select * from klg_typicalCase " +
		     "where klg_typicalCase.id=:id";
		}else if(type.equals("典型违章")==true)
		{
		     SQL="select * from klg_typicalViolation " +
		     "where klg_typicalViolation.id=:id";
		}
        return (List) sessionFactory.getCurrentSession()
        .createSQLQuery(SQL).setLong("id", idValue).list();
	}

	
}
