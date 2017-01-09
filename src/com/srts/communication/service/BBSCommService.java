package com.srts.communication.service;

import java.util.ArrayList;
import java.util.List;

import com.srts.communication.domain.BBSArtical;
import com.srts.communication.domain.BBSArticalReply;
import com.srts.communication.domain.BBSModel;
import com.srts.communication.domain.BBSReplyReply;
import com.srts.communication.po.ArticalTop3;
import com.srts.communication.po.BBSModelInfo;
import com.srts.communication.po.ComArtical;
import com.srts.communication.po.MonthTop;
import com.srts.communication.po.ReplyContent;
import com.srts.system.domain.Sys_User;

public interface BBSCommService {

	List<BBSModel> findAllBBSModels();

	void save(BBSArtical ba);

	ComArtical getHotArtical(int curPage);

	ComArtical getNewArtical(int curPage);

	ComArtical getMyArticals(Sys_User usr, int curPage);

	BBSArtical getOneBBSArticalById(long articalId);

	List<BBSArticalReply> getBBSArticalReplyByArticalId(long articalId);

	List<BBSReplyReply> getBBSReplyReplyByArticalReplyId(long id);

	void save(BBSArticalReply reply);

	void save(BBSReplyReply b);

	void updateBBSArticalViewCount(long articalId, int i);

	ArrayList<ArticalTop3> getArticalTop3();

	ArrayList<BBSModelInfo> getBBSModelInfos();

	void updateModelArticalNum(long bbsModelid);

	ArrayList<MonthTop> getMonthTop();

	void updateBBSArticalReplyCount(long articalId);

	ArrayList<ReplyContent> getMyReplyContents(long id);

	ArrayList<ReplyContent> getHisReplyContents(long id);


}
