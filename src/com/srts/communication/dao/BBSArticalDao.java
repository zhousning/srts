package com.srts.communication.dao;

import java.util.ArrayList;

import com.srts.common.base.BaseDao;
import com.srts.communication.domain.BBSArtical;
import com.srts.communication.po.ArticalTop3;
import com.srts.communication.po.BBSModelInfo;
import com.srts.communication.po.ComArtical;
import com.srts.communication.po.MonthTop;
import com.srts.system.domain.Sys_User;

public interface BBSArticalDao extends BaseDao<BBSArtical> {

	ComArtical getHotArtical(int curPage);

	ComArtical getNewArtical(int curPage);

	ComArtical getMyArticals(Sys_User usr, int curPage);

	void updateBBSArticalViewCount(long id, int i);

	ArrayList<ArticalTop3> getArticalTop3();

	ArrayList<BBSModelInfo> getBBSModelInfos();

	ArrayList<MonthTop> getMonthTop();

	void updateBBSArticalReplyCount(long articalId);

}
