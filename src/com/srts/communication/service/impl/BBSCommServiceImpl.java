package com.srts.communication.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.communication.dao.BBSArticalDao;
import com.srts.communication.dao.BBSArticalReplyDao;
import com.srts.communication.dao.BBSModelDao;
import com.srts.communication.dao.BBSReplyReplyDao;
import com.srts.communication.domain.BBSArtical;
import com.srts.communication.domain.BBSArticalReply;
import com.srts.communication.domain.BBSModel;
import com.srts.communication.domain.BBSReplyReply;
import com.srts.communication.po.ArticalTop3;
import com.srts.communication.po.BBSModelInfo;
import com.srts.communication.po.ComArtical;
import com.srts.communication.po.MonthTop;
import com.srts.communication.po.ReplyContent;
import com.srts.communication.service.BBSCommService;
import com.srts.system.domain.Sys_User;

@Service
public class BBSCommServiceImpl implements BBSCommService {
	@Resource
	private BBSModelDao bbsModelDao;
	@Resource
	private BBSArticalDao bbsArticalDao;
	
	@Resource
	private BBSArticalReplyDao replyDao;
	
	@Resource
	private BBSReplyReplyDao rrDao;
	
	public List<BBSModel> findAllBBSModels() {
		return bbsModelDao.findAll();
	}
	public void save(BBSArtical ba) {
		bbsArticalDao.save(ba);
	}
	public ComArtical getHotArtical(int curPage) {
		
		return bbsArticalDao.getHotArtical(curPage);
	}
	public ComArtical getNewArtical(int curPage) {
		return bbsArticalDao.getNewArtical(curPage);
	}
	
	public ComArtical getMyArticals(Sys_User usr,int curPage) {
		
		return bbsArticalDao.getMyArticals(usr,curPage);
	}

	public BBSArtical getOneBBSArticalById(long articalId) {
		
		return bbsArticalDao.getById(articalId);
	}

	public List<BBSArticalReply> getBBSArticalReplyByArticalId(long articalId) {
		
		return replyDao.getBBSArticalReplyByArticalId(articalId);
	}

	public List<BBSReplyReply> getBBSReplyReplyByArticalReplyId(long id) {

		return rrDao.getBBSReplyReplyByArticalReplyId(id);
	}

	public void save(BBSArticalReply reply) {
		replyDao.save(reply);
	}
	public void save(BBSReplyReply b) {
		rrDao.save(b);
	}
	
	public void updateBBSArticalViewCount(long id,int i) {
		bbsArticalDao.updateBBSArticalViewCount(id,i);
	}

	public ArrayList<ArticalTop3> getArticalTop3() {
		return bbsArticalDao.getArticalTop3();
	}
	public ArrayList<BBSModelInfo> getBBSModelInfos() {
		
		return bbsArticalDao.getBBSModelInfos();
	}
	public void updateModelArticalNum(long bbsModelid) {
		bbsModelDao.updateModelArticalNum(bbsModelid);
	}
	public ArrayList<MonthTop> getMonthTop() {
		return bbsArticalDao.getMonthTop();
	}
	public void updateBBSArticalReplyCount(long articalId) {
		bbsArticalDao.updateBBSArticalReplyCount(articalId);
	}
	public ArrayList<ReplyContent> getHisReplyContents(long id) {
		
		return rrDao.getHisReplyContents(id);
	}
	public ArrayList<ReplyContent> getMyReplyContents(long id) {
		
		return rrDao.getMyReplyContents(id);
	}
	

}
