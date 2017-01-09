package com.srts.communication.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.communication.dao.AnswerInfoDao;
import com.srts.communication.domain.AnswerInfo;
import com.srts.communication.domain.ProblemInfo;
import com.srts.communication.po.AllAnswerInfo;
import com.srts.communication.po.AnswerInfoAndProblemInfo;
import com.srts.communication.po.CommUtils;
@Repository
@Transactional
public class AnswerInfoDaoImpl extends BaseDaoImpl<AnswerInfo> implements AnswerInfoDao {
	private Session session;
	private Query query;
	public void updateAnswerInfo(AnswerInfo answerInfo) {
		session = getSession();
		String hql = "update cmnc_answerinfo set answerContent=?,answerDate=? where id=? ";
		query = session.createSQLQuery(hql);
		query.setString(0, answerInfo.getAnswerContent());
		query.setDate(1, answerInfo.getAnswerDate());
		query.setLong(2, answerInfo.getId());
		query.executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public AllAnswerInfo findAllAnswerInfo(int curPageNum) {
		AllAnswerInfo allAnswerInfo =new AllAnswerInfo();
		List<AnswerInfoAndProblemInfo> apInfos=new ArrayList<AnswerInfoAndProblemInfo>();
		List<AnswerInfo> answerInfos;
		session = getSession();
		String hql = "from AnswerInfo as a  order by a.answerDate desc";
		query = session.createQuery(hql);
		query.setFirstResult((curPageNum - 1)*CommUtils.recordsOnePage);
		query.setMaxResults(CommUtils.recordsOnePage);
		answerInfos = query.list();
		for(int i=0;i<answerInfos.size();i++){
			AnswerInfo a=answerInfos.get(i);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(a.getAnswerDate()!=null){
				a.setDate(sdf.format(a.getAnswerDate()));
			}
			AnswerInfoAndProblemInfo ap=new AnswerInfoAndProblemInfo();
			ap.setAnswerInfo(a);
			String hql0="from ProblemInfo as p where p.id=?";
			query = session.createQuery(hql0);
			query.setLong(0, a.getProblem().getId());
			ProblemInfo problemInfo=(ProblemInfo) query.uniqueResult();
			ap.setProblemInfo(problemInfo);
			apInfos.add(ap);
		}
		allAnswerInfo.setApInfos(apInfos);
		int postAmount = 0;
		session =getSession();
		String hql2 = "select count(*) from AnswerInfo ";
		query = session.createQuery(hql2);
		long  l = (Long)query.uniqueResult();
		postAmount = (int)l;
		postAmount= getPostAmout(postAmount);
		allAnswerInfo.setAllPageNum(postAmount);
		return allAnswerInfo;
	}
	private int getPostAmout(int postAmount) {
		if(postAmount%CommUtils.recordsOnePage==0){
			postAmount=postAmount/CommUtils.recordsOnePage;
		}else{
			postAmount=postAmount/CommUtils.recordsOnePage+1;
		}
		return postAmount;
	}

}
