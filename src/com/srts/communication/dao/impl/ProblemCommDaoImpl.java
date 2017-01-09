package com.srts.communication.dao.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.communication.dao.ProblemCommDao;
import com.srts.communication.domain.ProblemInfo;
import com.srts.communication.po.CommUtils;
import com.srts.communication.po.CommonUser;
import com.srts.communication.po.SelfProblemInfo;
import com.srts.system.domain.Sys_User;

@Repository
@Transactional
public class ProblemCommDaoImpl extends BaseDaoImpl<ProblemInfo> implements ProblemCommDao{
	private Session session;
	private Query query;
	
	/**
	 *我的提问
	 */
	@SuppressWarnings("unchecked")
	public SelfProblemInfo findAllMyProblemInfos(Sys_User sysUser,int curPageNum) {
		List<ProblemInfo> problemInfos;
		session = getSession();
		String hql = "from ProblemInfo as problemInfo where problemInfo.usr.id = ? order by problemInfo.postDate desc";
		query = session.createQuery(hql);
		query.setLong(0, sysUser.getId());
		query.setFirstResult((curPageNum - 1)*CommUtils.recordsOnePage);
		query.setMaxResults(CommUtils.recordsOnePage);
		problemInfos = query.list();
		
		for(int i=0;i<problemInfos.size();i++){
			ProblemInfo pi=problemInfos.get(i);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pi.setDate(sdf.format(pi.getPostDate()));
			pi.setAnswerCount(pi.getAnswerInfos().size());
		}
		SelfProblemInfo selfProblemInfo =new SelfProblemInfo();
		selfProblemInfo.setSelfProblemInfos(problemInfos);
		
		int postAmount = 0;
		session =getSession();
		String hql2 = "select count(*) from ProblemInfo as problemInfo where problemInfo.usr.id = ?";
		query = session.createQuery(hql2);
		query.setLong(0, sysUser.getId());
		long  l = (Long)query.uniqueResult();
		postAmount = (int)l;
		postAmount= getPostAmout(postAmount);
		selfProblemInfo.setAllPageNum(postAmount);
		return selfProblemInfo;
	}
	private int getPostAmout(int postAmount) {
		if(postAmount%CommUtils.recordsOnePage==0){
			postAmount=postAmount/CommUtils.recordsOnePage;
		}else{
			postAmount=postAmount/CommUtils.recordsOnePage+1;
		}
		return postAmount;
	}
	/**
	 * 所有的提问
	 */
	@SuppressWarnings("unchecked")
	public SelfProblemInfo findAllProblemInfos(int curPageNum) {
		List<ProblemInfo> problemInfos;
		session = getSession();
		String hql = "from ProblemInfo as problemInfo  order by problemInfo.postDate desc";
		query = session.createQuery(hql);
		query.setFirstResult((curPageNum - 1)*CommUtils.recordsOnePage);
		query.setMaxResults(CommUtils.recordsOnePage);
		problemInfos = query.list();
		
		for(int i=0;i<problemInfos.size();i++){
			ProblemInfo pi=problemInfos.get(i);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(pi.getPostDate()!=null){
				pi.setDate(sdf.format(pi.getPostDate()));
			}
			
			pi.setAnswerCount(pi.getAnswerInfos().size());
		}
		
		SelfProblemInfo selfProblemInfo =new SelfProblemInfo();
		selfProblemInfo.setSelfProblemInfos(problemInfos);
		
		
		int postAmount = 0;
		session =getSession();
		String hql2 = "select count(*) from ProblemInfo ";
		query = session.createQuery(hql2);
		long  l = (Long)query.uniqueResult();
		postAmount = (int)l;
		postAmount= getPostAmout(postAmount);
		selfProblemInfo.setAllPageNum(postAmount);
		return selfProblemInfo;
	}
	/**
	 * 单个问题信息
	 */
	public ProblemInfo findProblemInfoById(Long problemId) {
		session = getSession();
		String hql = "from ProblemInfo as problemInfo where problemInfo.id=? ";
		query = session.createQuery(hql);
		query.setLong(0, problemId);
		ProblemInfo problemInfo=(ProblemInfo) query.uniqueResult();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		problemInfo.setDate(sdf.format(problemInfo.getPostDate()));
		problemInfo.setAnswerCount(problemInfo.getAnswerInfos().size());
		return problemInfo;
	}

	public void updateProblemInfoViewCount(int i,Long id) {
		session = getSession();
		String hql = "update cmnc_probleminfo set viewCount=? where id=? ";
		query = session.createSQLQuery(hql);
		query.setInteger(0, i);
		query.setLong(1, id);
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<CommonUser> getProblemCountTop5(){
		String sql = "select top 5 * from (	select count(pbi.id) problemcount,usrId, name from cmnc_probleminfo as pbi,srts_sys_user as usr where pbi.usrId=usr.id group by pbi.usrId,usr.name) problemCount_usrName order by problemcount desc;";
		List list = getSession().createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		List<CommonUser> userList = new ArrayList<CommonUser>();
		while(iterator.hasNext()){
			Object[]objects = (Object[]) iterator.next();
			String count = objects[0].toString();
			String id = objects[1].toString();
			String name = objects[2].toString();
			CommonUser usr = new CommonUser(name,count);
			usr.setId(id);
			userList.add(usr);
		}
		
		return userList;
	}
	
	@SuppressWarnings("unchecked")
	public List<CommonUser> getAnswerCountTop5(){
		String sql = "select top 5 * from (	select count(pbi.id) problemcount,usrId, name from cmnc_answerinfo as pbi,srts_sys_user as usr where pbi.usrId=usr.id group by pbi.usrId,usr.name) problemCount_usrName order by problemcount desc;";
		List list = getSession().createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		List<CommonUser> userList = new ArrayList<CommonUser>();
		while(iterator.hasNext()){
			Object[]objects = (Object[]) iterator.next();
			String count = objects[0].toString();
			String id = objects[1].toString();
			String name = objects[2].toString();
			CommonUser usr = new CommonUser(name,count);
			usr.setId(id);
			userList.add(usr);
		}
		
		return userList;
	}
	
	@SuppressWarnings("unchecked")
	public List getAcceptCountTop5(){
		String sql = "select top 5 * from (	select count(acp.problemId) problemcount,answer.usrId, name 	from cmnc_answerinfo as answer, cmnc_pbmansaccept as acp,srts_sys_user as usr where answer.usrId=usr.id AND acp.answerId=answer.id group by answer.usrId,usr.name) problemCount_usrName order by problemcount desc;";
		List list = getSession().createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		List<CommonUser> userList = new ArrayList<CommonUser>();
		while(iterator.hasNext()){
			Object[]objects = (Object[]) iterator.next();
			String count = objects[0].toString();
			String id = objects[1].toString();
			String name = objects[2].toString();
			CommonUser usr = new CommonUser(name,count);
			usr.setId(id);
			userList.add(usr);
		}
		
		return userList;
	}
	
	
	public List queryForPage(String hql,int offset,int length){
		System.out.println(hql);
		System.out.println(offset);
		return getSession().createQuery(hql).setFirstResult(offset).setMaxResults(length).list();
		
		}
	
	
	public int getAllRowCount(String hql){
		return getSession().createQuery(hql).list().size();
		}

}
