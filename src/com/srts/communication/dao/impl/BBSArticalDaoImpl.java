package com.srts.communication.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.communication.dao.BBSArticalDao;
import com.srts.communication.domain.BBSArtical;
import com.srts.communication.po.ArticalTop3;
import com.srts.communication.po.BBSModelInfo;
import com.srts.communication.po.ComArtical;
import com.srts.communication.po.CommUtils;
import com.srts.communication.po.MonthTop;
import com.srts.system.domain.Sys_User;
@Repository
@Transactional
public class BBSArticalDaoImpl extends BaseDaoImpl<BBSArtical> implements BBSArticalDao {
	private Session session;
	private Query query;
	@SuppressWarnings("unchecked")
	public ComArtical getHotArtical(int curPage) {
		ComArtical hotArtical=new ComArtical();
		List<BBSArtical> bbsArticals;
		session = getSession();
		String hql = "from BBSArtical as b  order by b.viewCount desc";
		query = session.createQuery(hql);
		query.setFirstResult((curPage - 1)*CommUtils.recordsOnePage);
		query.setMaxResults(CommUtils.recordsOnePage);
		bbsArticals = query.list();
		hotArtical.setArticals(bbsArticals);
		hotArtical.setAllPageNum(CommUtils.getAllPageNum(getTotalrows()));
		return hotArtical;
	}
	private int getTotalrows(){
		session = getSession();
		String hql ="SELECT count(*) FROM  BBSArtical";
		Query query = session.createQuery(hql);
		long count = (Long) query.uniqueResult();
		return  (int)count;
	}
	private int getMyrows(Sys_User user){
		session = getSession();
		String hql ="SELECT count(*) FROM  BBSArtical b where b.usr.id =?";
		query = session.createQuery(hql);
		query.setLong(0, user.getId());
		long count = (Long) query.uniqueResult();
		return  (int)count;
	}
	@SuppressWarnings("unchecked")
	public ComArtical getNewArtical(int curPage) {
		ComArtical newArtical=new ComArtical();
		List<BBSArtical> bbsArticals;
		session = getSession();
		String hql = "from BBSArtical as b  order by b.articalDate desc";
		query = session.createQuery(hql);
		query.setFirstResult((curPage - 1)*CommUtils.recordsOnePage);
		query.setMaxResults(CommUtils.recordsOnePage);
		bbsArticals = query.list();
		newArtical.setArticals(bbsArticals);
		newArtical.setAllPageNum(CommUtils.getAllPageNum(getTotalrows()));
		return newArtical;
	}
	@SuppressWarnings("unchecked")
	public ComArtical getMyArticals(Sys_User usr,int curPage) {
		ComArtical myArtical=new ComArtical();
		List<BBSArtical> bbsArticals;
		session = getSession();
		String hql = "from BBSArtical as b where b.usr.id=? order by b.articalDate desc";//as b where b.usr.id =? order by b.articalDate desc
		query = session.createQuery(hql);
		query.setLong(0, usr.getId());
		query.setFirstResult((curPage - 1)*CommUtils.recordsOnePage);
		query.setMaxResults(CommUtils.recordsOnePage);
		bbsArticals = query.list();
		myArtical.setArticals(bbsArticals);
		myArtical.setAllPageNum(CommUtils.getAllPageNum(getMyrows(usr)));
		return myArtical;
	}
	public void updateBBSArticalViewCount(long id,int i) {
		session = getSession();
		String hql = "update cmnc_bbsartical set viewCount=? where id=? ";
		query = session.createSQLQuery(hql);
		query.setInteger(0, i);
		query.setLong(1, id);
		query.executeUpdate();
		
	}
	@SuppressWarnings("unchecked")
	public ArrayList<ArticalTop3> getArticalTop3() {
		ArrayList<ArticalTop3> at3s=new ArrayList<ArticalTop3>();
		session = getSession();
		String hql = "select * from (select usrId, count(usrId) num  from  cmnc_bbsartical  group by usrId) as t order by t.num desc";
		query = session.createSQLQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(3);
		Iterator it=query.list().iterator();
		Object[] idAndNum;
		ArticalTop3 at3;
		while(it.hasNext()){
			idAndNum=(Object[]) it.next();
			at3=new ArticalTop3();
			at3.setName(String.valueOf(idAndNum[0]));
			at3.setArticalNum(String.valueOf(idAndNum[1]));
			at3s.add(at3);
		}
		return at3s;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<BBSModelInfo> getBBSModelInfos() {
		ArrayList<BBSModelInfo> bmis=new ArrayList<BBSModelInfo>();
		session = getSession();
		String hql = "SELECT modelName,num,userNum from (select  COUNT(DISTINCT usrId) userNum,modelID,COUNT(*) num from cmnc_bbsartical GROUP BY modelID)as t,cmnc_bbsmodel as c where t.modelID=c.id;";
		query = session.createSQLQuery(hql);
		Iterator it=query.list().iterator();
		Object[] nameCountNum;
		BBSModelInfo bmi;
		while(it.hasNext()){
			nameCountNum=(Object[]) it.next();
			bmi=new BBSModelInfo();
			bmi.setModelName(String.valueOf(nameCountNum[0]));
			bmi.setArticalNum(String.valueOf(nameCountNum[1]));
			bmi.setActivePersonNum(String.valueOf(nameCountNum[2]));
			bmis.add(bmi);
		}
		return bmis;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<MonthTop> getMonthTop() {
		ArrayList<MonthTop> monthTops=new ArrayList<MonthTop>();
		session = getSession();
		String sql1="SELECT modelName,modelID from cmnc_bbsmodel as b, (SELECT modelID from cmnc_bbsartical GROUP BY modelID) as m where m.modelID=b.id;";
		query = session.createSQLQuery(sql1);
		Iterator it=query.list().iterator();
		Object[] modelNameAndId=null;
		MonthTop mt;
		while(it.hasNext()){
			mt = new MonthTop();
			modelNameAndId=(Object[]) it.next();
			mt.setModleName(String.valueOf(modelNameAndId[0]));
			//将modelID 暂存
			mt.setArticalNum(String.valueOf(modelNameAndId[1]));
			monthTops.add(mt);
		}
		//查找 usrId 和  发帖数量
		for(int i=0;i<monthTops.size();i++){
			mt=monthTops.get(i);
			long id=Long.valueOf(mt.getArticalNum());
			String sql2="SELECT usrId,COUNT(usrId) num FROM cmnc_bbsartical as c WHERE modelID=? GROUP BY usrId ORDER BY num DESC;";
			query = session.createSQLQuery(sql2);
			query.setLong(0, id);
			query.setFirstResult(0);
			query.setMaxResults(1);
			it=query.list().iterator();
			if(it.hasNext()){
				modelNameAndId=(Object[]) it.next();
				String sql="SELECT name FROM srts_sys_user where id=?";
				query = session.createSQLQuery(sql);
				query.setLong(0, Long.valueOf(String.valueOf(modelNameAndId[0])));
				mt.setUserName((String) query.uniqueResult());
				mt.setArticalNum(String.valueOf(modelNameAndId[1]));
			}
		}
		
		return monthTops;
	}
	public void updateBBSArticalReplyCount(long id) {
		session = getSession();
		String hql = "update cmnc_bbsartical set replyCount=replyCount+1 where id=?";
		query = session.createSQLQuery(hql);
		query.setLong(0, id);
		query.executeUpdate();
	}

}
