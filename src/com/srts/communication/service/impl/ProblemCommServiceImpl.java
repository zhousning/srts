package com.srts.communication.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.communication.dao.AnswerAskDao;
import com.srts.communication.dao.AnswerInfoDao;
import com.srts.communication.dao.ProblemAnswerAcceptDao;
import com.srts.communication.dao.ProblemCommDao;
import com.srts.communication.domain.AnswerAsk;
import com.srts.communication.domain.AnswerInfo;
import com.srts.communication.domain.ProblemAnswerAccept;
import com.srts.communication.domain.ProblemInfo;
import com.srts.communication.po.AllAnswerInfo;
import com.srts.communication.po.CommonUser;
import com.srts.communication.po.SelfAnswerInfo;
import com.srts.communication.po.SelfProblemInfo;
import com.srts.communication.service.ProblemCommService;
import com.srts.system.domain.Sys_User;
import com.srts.utils.pageUtils.PageBean;

@Service
public class ProblemCommServiceImpl implements ProblemCommService {
	@Resource
	private ProblemCommDao problemCommDao;
	@Resource
	private AnswerInfoDao answerInfoDao;
	@Resource
	private ProblemAnswerAcceptDao problemAnswerAcceptDao;
	@Resource
	private AnswerAskDao answerAskDao;

	public void save(ProblemInfo problemInfo) {
		problemCommDao.save(problemInfo);
	}

	public SelfProblemInfo findAllProblemInfos(int curPageNum) {
		return problemCommDao.findAllProblemInfos(curPageNum);
	}

	public ProblemInfo findProblemInfoById(Long problemId) {
		return problemCommDao.findProblemInfoById(problemId);
	}

	public SelfProblemInfo findAllMyProblemInfos(Sys_User sysUser,int curPageNum) {
		return problemCommDao.findAllMyProblemInfos(sysUser,curPageNum);
	}

	public void addAnswerInfo(AnswerInfo answerInfo) {
		answerInfoDao.save(answerInfo);
	}

	public AnswerInfo findAnswerInfoById(Long answerId) {
		return answerInfoDao.getById(answerId);
	}

	public void updateAnswerInfo(AnswerInfo answerInfo) {
		answerInfoDao.updateAnswerInfo(answerInfo);
	}

	public void updateProblemInfoViewCount(int i,Long id) {
		problemCommDao.updateProblemInfoViewCount(i,id);
	}
	
	//未用
	public SelfAnswerInfo findAllMyAnswerInfo(Sys_User sysUser, int curPageNum) {
		
		return null;
	}

	public List<AnswerAsk> findAnswerAskByAnswerInfoId(long id) {
		
		return answerAskDao.findAnswerAskByAnswerInfoId(id);
	}

	public void saveAnswerAsk(AnswerAsk answerAsk) {
		answerAskDao.save(answerAsk);
	}

	public void saveProblemAnswerAccept(ProblemAnswerAccept accept) {
		problemAnswerAcceptDao.save(accept);
	}

	public ProblemAnswerAccept findProblemAnswerAcceptByProblemId(Long problemId) {
		return problemAnswerAcceptDao.findProblemAnswerAcceptByProblemId(problemId);
	}

	public List<CommonUser> getProblemCountTop5() {
		return problemCommDao.getProblemCountTop5();
	}

	public List<CommonUser> getAnswerCountTop5() {
		return problemCommDao.getAnswerCountTop5();
	}

	public List<CommonUser> getAcceptCountTop5() {
		return problemCommDao.getAcceptCountTop5();
	}

	public AllAnswerInfo findAllAnswerInfo(int curPageNum) {
		return answerInfoDao.findAllAnswerInfo(curPageNum);
	}

	public void deleteProblemInfo(long id) {
		ProblemInfo pi=problemCommDao.getById(id);
		try {
			Set<AnswerInfo> ais=pi.getAnswerInfos();
			Iterator<AnswerInfo> it=ais.iterator();
			while(it.hasNext()){
				AnswerInfo ai=it.next();
				List<AnswerAsk> answerAsks=answerAskDao.findAnswerAskByAnswerInfoId(id);
				for(int i=0;i<answerAsks.size();i++){
					answerAskDao.delete(answerAsks.get(i).getId());
				}
				ProblemAnswerAccept paa=problemAnswerAcceptDao.findProblemAnswerAcceptByProblemId(ai.getProblem().getId());
				if(paa!=null)
					problemAnswerAcceptDao.delete(paa.getId());
				answerInfoDao.delete(ai.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		problemCommDao.delete(id);
	}

	public void deleteAnswerInfo(long id) {
		AnswerInfo ai=answerInfoDao.getById(id);
		List<AnswerAsk> answerAsks=answerAskDao.findAnswerAskByAnswerInfoId(id);
		for(int i=0;i<answerAsks.size();i++){
			answerAskDao.delete(answerAsks.get(i).getId());
		}
		ProblemAnswerAccept paa=problemAnswerAcceptDao.findProblemAnswerAcceptByProblemId(ai.getProblem().getId());
		if(paa!=null)
			problemAnswerAcceptDao.delete(paa.getId());
		answerInfoDao.delete(id);
	}

	
	
	
	public PageBean queryForPage(String hql, int pageSize,int page){

		int allRow = problemCommDao.getAllRowCount(hql);//总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, page);//当前页开始记录
		final int length = pageSize;//每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List list = problemCommDao.queryForPage(hql, offset, length);//"一页"的记录

		//把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
		}

		public int getAllRowCount(String hql) {
			// TODO Auto-generated method stub
			return problemCommDao.getAllRowCount(hql);
		}
	

}
